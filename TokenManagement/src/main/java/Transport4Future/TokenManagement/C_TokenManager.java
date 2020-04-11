////Transport4Future////

package Transport4Future.TokenManagement;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringReader;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;
import javax.json.Json;
import javax.json.JsonObject;

public class C_TokenManager {
	
	public String tokenRequestGeneration(String path) throws C_TokenManagementException {
		C_TokenRequest token;
		String myToken;
		
		token = readTokenRequestFromJSON(path);
		myToken = codeHashMD5(token);
		
		return myToken;
	}
	
	public String codeHashMD5(C_TokenRequest mytoken) throws C_TokenManagementException{
		
		MessageDigest md;
		
		try {
			md = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			throw new C_TokenManagementException("Error: no such hashing algorithm.");
		}
		String input = "Stardust" + "-" + mytoken.toString();
		
		md.update(input.getBytes(StandardCharsets.UTF_8));
		byte[] digest = md.digest();
		
		String hex = String.format("%32x", new BigInteger(1, digest));
		return hex;
	}
		
	public String codeHash256(C_Token mytoken) throws C_TokenManagementException{
		
		MessageDigest md;
		
		try {
			md = MessageDigest.getInstance("SHA-256");
		} catch (NoSuchAlgorithmException e) {
			throw new C_TokenManagementException("Error: no such hashing algorithm.");
		}
		
		String input = "Stardust" + "-" + mytoken.valuesToSign();
		
		md.update(input.getBytes(StandardCharsets.UTF_8));
		byte[] digest = md.digest();
		
		String hex = String.format("%64x", new BigInteger(1, digest));
		return hex;
	}
	
	private String encodeString(String stringToEncode) throws C_TokenManagementException{
		
		String encodedURL;
		
		try {
			encodedURL = Base64.getUrlEncoder().encodeToString(stringToEncode.getBytes());
		} catch (Exception ex) {
			throw new C_TokenManagementException("Error encoding 64URL.");
		}
		
		return encodedURL;
	}
	
	public C_TokenRequest readTokenRequestFromJSON(String path) throws C_TokenManagementException {
		C_TokenRequest req = null;
		
		String fileContents = "";

		BufferedReader reader;
		
		try {
			reader = new BufferedReader(new FileReader(path));
		} catch (FileNotFoundException e) {
			throw new C_TokenManagementException("Error: input file not found.");
		}
		
		String line;
		
		try {
			while ((line = reader.readLine()) != null) {
				fileContents += line;
			}
		} catch (IOException e) {
			throw new C_TokenManagementException("Error: input file could not be accessed.");
		}
		
		try {
			reader.close();
		} catch (IOException e) {
			throw new C_TokenManagementException("Error: input file could not be closed.");
		}
		
		JsonObject jsonLicense = null;
		
		try {
			jsonLicense = Json.createReader(new StringReader(fileContents)).readObject();
		} catch (Exception e) {
			throw new C_TokenManagementException("Error: input file could not be readed.");
		}
		
		try {
			
            		String deviceName = jsonLicense.getString("Device Name");
            		String typeOfDevice = jsonLicense.getString("Type of Device");
            		String driverVersion = jsonLicense.getString("Driver Version");
            		String supportEmail = jsonLicense.getString("Support e-mail");
            		String serialNumber = jsonLicense.getString("Serial Number");
            		String macAddress = jsonLicense.getString("MAC Address");

            		req = new C_TokenRequest(deviceName, typeOfDevice, driverVersion, supportEmail, serialNumber, macAddress);
        	} catch (Exception pe) {
        		throw new C_TokenManagementException("Error: invalid input data in JSON structure.");
        	}
		
		checkInformationRequestFormat(req);
		
		return req;
	}
	
	public void checkInformationRequestFormat(C_TokenRequest req) throws C_TokenManagementException{

		String deviceName = req.getDeviceName();
		if(deviceName.length()==0)throw new C_TokenManagementException("Error: Device Name value is missing.");
		if(deviceName.length()>20)throw new C_TokenManagementException("Error: Device Name could not have more than 20 characters.");  
		
		String typeOfDevice = req.getTypeOfDevice();
		if(typeOfDevice.length()==0)throw new C_TokenManagementException("Error: Type of Device value is missing.");
		if(!typeOfDevice.equals("Sensor") && !typeOfDevice.contentEquals("Actuator"))throw new C_TokenManagementException("Error: Type of Device value is not valid.");
		
		String driverVersion = req.getDriverVersion();
		if(driverVersion.length()==0)throw new C_TokenManagementException("Error: Driver Version value is missing.");
		if(driverVersion.length()<3)throw new C_TokenManagementException("Error: Driver Version value is under 3 characters.");
		if(!driverVersion.matches("^\\d*(\\.\\d*)*?")) throw new C_TokenManagementException("Error: Driver Version value is not numeric.");
		if(driverVersion.indexOf(".") == -1) throw new C_TokenManagementException("Error: Driver Version value doesn´t contain dot.");
		if(driverVersion.length()>25)throw new C_TokenManagementException("Error: Driver Version value is longer than 25 characters."); 
		
		String supportEmail = req.getSupportEmail();
		if(supportEmail.length()==0)throw new C_TokenManagementException("Error: Support e-mail value is missing.");
		if(supportEmail.indexOf("@") == -1 || supportEmail.indexOf(".") == -1) throw new C_TokenManagementException("Error: Support e-mail value is not valid.");
		
		String serialNumber = req.getSerialNumber();
		if(serialNumber.length()==0)throw new C_TokenManagementException("Error: Serial Number value is missing.");
		if(serialNumber.indexOf(" ") >= 0)throw new C_TokenManagementException("Error: Serial Number value is not valid.");
		
		String macAddress = req.getMacAddress();
		if(macAddress.length()==0)throw new C_TokenManagementException("Error: MAC Address value is missing.");
		if(!macAddress.matches("([0-9a-fA-F]{2}:){5}[0-9a-fA-F]{2}")) throw new C_TokenManagementException("Error: MAC Address must have 17 characters.");	
		
	}
	
	public String requestToken(String InputFile) throws C_TokenManagementException {
		C_Token myToken;
		String aux;
		
		myToken = readRequestTokenFromJSON(InputFile);
		
		aux = codeHash256(myToken);
		myToken.setSignature(aux);
		aux = encodeString(myToken.toString());
		myToken.setTokenValue(aux);
		
		C_TokensStore myStore = new C_TokensStore();
		myStore.add(myToken);
		
		return myToken.getTokenValue();
	}
	
	public C_Token readRequestTokenFromJSON(String InputFile) throws C_TokenManagementException {
		C_Token req = null;
		String fileContents = "";

		BufferedReader reader;
		
		try {
			reader = new BufferedReader(new FileReader(InputFile));
		} catch (FileNotFoundException e) {
			throw new C_TokenManagementException("Error: input file not found.");
		}
		
		String line;
		
		try {
			while ((line = reader.readLine()) != null) {
				fileContents += line;
			}
		} catch (IOException e) {
			throw new C_TokenManagementException("Error: input file could not be accessed.");
		}
		
		try {
			reader.close();
		} catch (IOException e) {
			throw new C_TokenManagementException("Error: input file could not be closed.");
		}
		
		JsonObject jsonLicense = null;
		
		try {
			jsonLicense = Json.createReader(new StringReader(fileContents)).readObject();
		} catch (Exception e) {
			throw new C_TokenManagementException("Error: input file could not be readed.");
		}
		
		try {
			
			String dateString = jsonLicense.getString("Request Date");
			
			if(!dateString.matches("[0-3][0-9]-[0-1][0-9]-[0-9]{4} [0-2][0-4]:[0-5][0-9]:[0-5][0-9]")) throw new C_TokenManagementException("Error: invalid Request Date format.");
            		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy HH:mm:SS");
            		Date date = format.parse(jsonLicense.getString("Request Date"));
            		
		} catch (Exception e) {
            		throw new C_TokenManagementException("Error: invalid Request Date format.");
        	}
		
		try {
			
            		String tokenRequest = jsonLicense.getString("Token Request");
            		String email = jsonLicense.getString("Notification e-mail");
            		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy HH:mm:SS");
            		Date date = format.parse(jsonLicense.getString("Request Date"));

            		req = new C_Token(tokenRequest, date, email);
            
        	} catch (Exception pe) {
        		throw new C_TokenManagementException("Error: invalid input data in JSON structure.");
        	}

		checkTokenRequestInformationFormat(req);
		
		return req;
	}
	
	public void checkTokenRequestInformationFormat(C_Token req) throws C_TokenManagementException{
		
		String tokenRequest = req.getDevice();
		
		if(tokenRequest.length()==0) throw new C_TokenManagementException("Error: Token Request value is missing.");
		if(tokenRequest.length()!=32) throw new C_TokenManagementException("Error: Token Request value is duplicated.");
		
		String email = req.getNotificationEmail();
		if(email.length()==0) throw new C_TokenManagementException("Error: Notification e-mail value is missing.");
		if(!email.matches("[a-zA-Z0-9+_-]+@[a-z0-9]+[.][a-z]{1,3}")) throw new C_TokenManagementException("Error: Notification e-mail value is not valid.");
	}

	public boolean verifyToken(String token) throws C_TokenManagementException{
		C_TokensStore myStore = new C_TokensStore();
		
		boolean result;
		result = false;

		C_Token tokenFound = myStore.find(token);
		
		if(tokenFound != null) {
			result = isValid(tokenFound);
		} else {
			throw new C_TokenManagementException("Token is not found in tokenStore");
		}
		return result;
	}
	
	private boolean isValid (C_Token tokenFound) {
		if(!tokenFound.isExpired() && tokenFound.isGranted()) {
			return true;
		} else {
			return false;
		}
	}
	
}
