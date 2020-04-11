////Transport4Future////

package Transport4Future.TokenManagement;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;


public class C_TokensStore {
	
	private List<C_Token> tokensList;
	
	private void load() {
		try {
			JsonReader reader = new JsonReader (new FileReader(System.getProperty("user.dir") + "/Store/tokenStore.json"));
			Gson gson = new Gson();
			C_Token[] myArray = gson.fromJson(reader, C_Token[].class);
			this.tokensList = new ArrayList<C_Token>();
			for(C_Token token: myArray) {
				this.tokensList.add(token);
			}
		} catch (Exception ex) {
			this.tokensList = new ArrayList<C_Token>();
		}
	}
	
	public void add (C_Token newToken) throws C_TokenManagementException{
		this.load();
		if(find(newToken.getTokenValue())==null) {
			tokensList.add(newToken);
			this.save();
		}
	}
	
	private void save() throws C_TokenManagementException {
		Gson gson = new GsonBuilder().disableHtmlEscaping().create();  
		String jsonString = gson.toJson(this.tokensList);
		FileWriter fileWriter;
		try {
			fileWriter = new FileWriter(System.getProperty("user.dir") + "/Store/tokenStore.json");
			fileWriter.write(jsonString);
			fileWriter.close();
		} catch(IOException e) {
			throw new C_TokenManagementException("Error: Unable to save a new token in the internal licenses store");
		}
	}
	
	public C_Token find (String tokenToFind) {
		C_Token result = null;
		this.load();
		for(C_Token token : this.tokensList) {
			if(token.getTokenValue().equals(tokenToFind)) {
				result = token;
			}
		}
		return result;
	}
}
