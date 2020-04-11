////Transport4Future////

package Transport4Future.TokenManagement;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class C_TokenTest {
	private C_TokenManager myManager;
	
	private String jsonFilesFolder; 
	
	public C_TokenTest() {
		jsonFilesFolder = System.getProperty("user.dir") + "/JSONFiles/RequestToken/";

		myManager = new C_TokenManager();
	}
	
	@DisplayName("Correct Token Generation") 
	@Test
	void correctTokenGenerationTest() throws C_TokenManagementException {
		String filePath = this.jsonFilesFolder + "Correct.json";
		String expectedToken = "14723f22d91c4f765a1b88dd64d0f693";
		String obtainedToken = myManager.tokenRequestGeneration(filePath);
		assertEquals(expectedToken, obtainedToken);
	}
	
	@DisplayName("File is missing") 
	@Test
	void fileIsMissingTest() throws C_TokenManagementException {
		String filePath = this.jsonFilesFolder + "FileIsMissing.json";
		String expectedMessage = "Error: input file not found.";
		C_TokenManagementException ex = Assertions.assertThrows(C_TokenManagementException.class, ()-> {
			myManager.tokenRequestGeneration(filePath);
		});
		Assertions.assertEquals(expectedMessage, ex.getMessage());
	}

	@DisplayName("Brackets are missing") 
    @Test
    void bracketsAreMissingTest() throws C_TokenManagementException {
        String filePath = this.jsonFilesFolder + "BracketsAreMissing.json";
        String expectedMessage = "Error: input file could not be readed.";
        C_TokenManagementException ex = Assertions.assertThrows(C_TokenManagementException.class, ()-> {
            myManager.tokenRequestGeneration(filePath);
        });
        Assertions.assertEquals(expectedMessage, ex.getMessage());
    }

    @DisplayName("Bracket is duplicated") 
    @Test
    void bracketIsDuplicatedTest() throws C_TokenManagementException {
        String filePath = this.jsonFilesFolder + "BracketIsDuplicated.json";
        String expectedMessage = "Error: input file could not be readed.";
        C_TokenManagementException ex = Assertions.assertThrows(C_TokenManagementException.class, ()-> {
            myManager.tokenRequestGeneration(filePath);
        });
        Assertions.assertEquals(expectedMessage, ex.getMessage());
    }

    @DisplayName("Bracket is missing") 
    @Test
    void bracketIsMissingTest() throws C_TokenManagementException {
        String filePath = this.jsonFilesFolder + "BracketIsMissing.json";
        String expectedMessage = "Error: input file not found.";
        C_TokenManagementException ex = Assertions.assertThrows(C_TokenManagementException.class, ()-> {
            myManager.tokenRequestGeneration(filePath);
        });
        Assertions.assertEquals(expectedMessage, ex.getMessage());
    }
	
	@DisplayName("DeviceNameIsMissing") 
	@Test
	void deviceNameIsMissingTest() throws C_TokenManagementException {
		String filePath = this.jsonFilesFolder + "DeviceNameIsMissing.json";
		String expectedMessage = "Error: invalid input data in JSON structure.";
		C_TokenManagementException ex = Assertions.assertThrows(C_TokenManagementException.class, ()-> {
			myManager.tokenRequestGeneration(filePath);
		});
		Assertions.assertEquals(expectedMessage, ex.getMessage());
	}
	
	@DisplayName("DeviceNameValueIsMissing") 
	@Test
	void deviceNameValueIsMissingTest() throws C_TokenManagementException {
		String filePath = this.jsonFilesFolder + "DeviceNameValueIsMissing.json";
		String expectedMessage = "Error: Device Name value is missing.";
		C_TokenManagementException ex = Assertions.assertThrows(C_TokenManagementException.class, ()-> {
			myManager.tokenRequestGeneration(filePath);
		});
		Assertions.assertEquals(expectedMessage, ex.getMessage());
	}
	
	@DisplayName("DeviceNameIsLongerThan20") 
	@Test
	void deviceNameIsLongerThan20Test() throws C_TokenManagementException {
		String filePath = this.jsonFilesFolder + "DeviceNameLengthLonger.json";
		String expectedMessage = "Error: Device Name could not have more than 20 characters.";
		C_TokenManagementException ex = Assertions.assertThrows(C_TokenManagementException.class, ()-> {
			myManager.tokenRequestGeneration(filePath);
		});
		Assertions.assertEquals(expectedMessage, ex.getMessage());
	}
	
	@DisplayName("VLDeviceName1") 
	@Test
	void VLdeviceName1Test() throws C_TokenManagementException {
		String filePath = this.jsonFilesFolder + "VLdeviceName1.json";
		String expectedToken = "47701bfc3b9d037cd09554790bac8b5a";
		String obtainedToken = myManager.tokenRequestGeneration(filePath);
		assertEquals(expectedToken, obtainedToken);
	}
	
	@DisplayName("VLDeviceName2") 
	@Test
	void VLdeviceName2Test() throws C_TokenManagementException {
		String filePath = this.jsonFilesFolder + "VLdeviceName2.json";
		String expectedToken = "76dca8875e8d62d42c47325cf577abc5";
		String obtainedToken = myManager.tokenRequestGeneration(filePath);
		assertEquals(expectedToken, obtainedToken);
	}
	
	@DisplayName("VLDeviceName19") 
	@Test
	void VLdeviceName19Test() throws C_TokenManagementException {
		String filePath = this.jsonFilesFolder + "VLdeviceName19.json";
		String expectedToken = "fcbd3a6cfce04060e30240ab40993747";
		String obtainedToken = myManager.tokenRequestGeneration(filePath);
		assertEquals(expectedToken, obtainedToken);
	}
	
	@DisplayName("VLDeviceName20") 
	@Test
	void VLdeviceName20Test() throws C_TokenManagementException {
		String filePath = this.jsonFilesFolder + "VLdeviceName20.json";
		String expectedToken = " a300d67a4a8c568dd542f21f7768209";
		String obtainedToken = myManager.tokenRequestGeneration(filePath);
		assertEquals(expectedToken, obtainedToken);
	}
	
	@DisplayName("VLDeviceName21") 
	@Test
	void VLdeviceName21Test() throws C_TokenManagementException {
		String filePath = this.jsonFilesFolder + "VLdeviceName21.json";
		String expectedMessage = "Error: Device Name could not have more than 20 characters.";
		C_TokenManagementException ex = Assertions.assertThrows(C_TokenManagementException.class, ()-> {
			myManager.tokenRequestGeneration(filePath);
		});
		Assertions.assertEquals(expectedMessage, ex.getMessage());
	}
	
	@DisplayName("TypeOfDeviceIsMissing") 
	@Test
	void typeOfDeviceIsMissingTest() throws C_TokenManagementException {
		String filePath = this.jsonFilesFolder + "TypeOfDeviceIsMissing.json";
		String expectedMessage = "Error: invalid input data in JSON structure.";
		C_TokenManagementException ex = Assertions.assertThrows(C_TokenManagementException.class, ()-> {
			myManager.tokenRequestGeneration(filePath);
		});
		Assertions.assertEquals(expectedMessage, ex.getMessage());
	}
	

	@DisplayName("TypeOfDeviceValueIsMissing") 
	@Test
	void typeOfDeviceValueIsMissingTest() throws C_TokenManagementException {
		String filePath = this.jsonFilesFolder + "TypeOfDeviceValueIsMissing.json";
		String expectedMessage = "Error: Type of Device value is missing.";
		C_TokenManagementException ex = Assertions.assertThrows(C_TokenManagementException.class, ()-> {
			myManager.tokenRequestGeneration(filePath);
		});
		Assertions.assertEquals(expectedMessage, ex.getMessage());
	}
	
	@DisplayName("TypeOfDeviceValueIsNotValid") 
	@Test
	void typeOfDeviceValueIsNotValid() throws C_TokenManagementException {
		String filePath = this.jsonFilesFolder + "TypeOfDeviceValueNotValid.json";
		String expectedMessage = "Error: Type of Device value is not valid.";
		C_TokenManagementException ex = Assertions.assertThrows(C_TokenManagementException.class, ()-> {
			myManager.tokenRequestGeneration(filePath);
		});
		Assertions.assertEquals(expectedMessage, ex.getMessage());
	}
	
	@DisplayName("DriverVersionIsMissing") 
	@Test
	void driverVersionIsMissingTest() throws C_TokenManagementException {
		String filePath = this.jsonFilesFolder + "DriverVersionIsMissing.json";
		String expectedMessage = "Error: invalid input data in JSON structure.";
		C_TokenManagementException ex = Assertions.assertThrows(C_TokenManagementException.class, ()-> {
			myManager.tokenRequestGeneration(filePath);
		});
		Assertions.assertEquals(expectedMessage, ex.getMessage());
	}
	
	@DisplayName("DriverVersionValueIsMissing") 
	@Test
	void driverVersionValueIsMissingTest() throws C_TokenManagementException {
		String filePath = this.jsonFilesFolder + "DriverVersionValueIsMissing.json";
		String expectedMessage = "Error: Driver Version value is missing.";
		C_TokenManagementException ex = Assertions.assertThrows(C_TokenManagementException.class, ()-> {
			myManager.tokenRequestGeneration(filePath);
		});
		Assertions.assertEquals(expectedMessage, ex.getMessage());
	}
	
	@DisplayName("DriverVersionValueNotValid") 
	@Test
	void driverVersionValueNotValidTest() throws C_TokenManagementException {
		String filePath = this.jsonFilesFolder + "DriverVersionValueNotValid.json";
		String expectedMessage = "Error: Driver Version value is not numeric.";
		C_TokenManagementException ex = Assertions.assertThrows(C_TokenManagementException.class, ()-> {
			myManager.tokenRequestGeneration(filePath);
		});
		Assertions.assertEquals(expectedMessage, ex.getMessage());
	}
	
	@DisplayName("DriverVersionValueNotValid2") 
	@Test
	void driverVersionValueNotValid2Test() throws C_TokenManagementException {
		String filePath = this.jsonFilesFolder + "DriverVersionValueNotValid2.json";
		String expectedMessage = "Error: Driver Version value doesn´t contain dot.";
		C_TokenManagementException ex = Assertions.assertThrows(C_TokenManagementException.class, ()-> {
			myManager.tokenRequestGeneration(filePath);
		});
		Assertions.assertEquals(expectedMessage, ex.getMessage());
	}
	
	@DisplayName("DriverVersionValueIsLongerThan25") 
	@Test
	void driverVersionValueIsLongerThan25Test() throws C_TokenManagementException {
		String filePath = this.jsonFilesFolder + "DriverVersionValueLonger.json";
		String expectedMessage = "Error: Driver Version value is longer than 25 characters.";
		C_TokenManagementException ex = Assertions.assertThrows(C_TokenManagementException.class, ()-> {
			myManager.tokenRequestGeneration(filePath);
		});
		Assertions.assertEquals(expectedMessage, ex.getMessage());
	}
	
	@DisplayName("VLDriverVersion2") 
	@Test
	void VLdriverVersion2Test() throws C_TokenManagementException {
		String filePath = this.jsonFilesFolder + "VLdriverVersion2.json";
		String expectedMessage = "Error: Driver Version value is under 3 characters.";
		C_TokenManagementException ex = Assertions.assertThrows(C_TokenManagementException.class, ()-> {
			myManager.tokenRequestGeneration(filePath);
		});
		Assertions.assertEquals(expectedMessage, ex.getMessage());
	}
	
	@DisplayName("VLDriverVersion3") 
	@Test
	void VLdriverVersion3Test() throws C_TokenManagementException {
		String filePath = this.jsonFilesFolder + "VLdriverVersion3.json";
		String expectedToken = "3afb70758638d9b1a5786755fd666033";
		String obtainedToken = myManager.tokenRequestGeneration(filePath);
		assertEquals(expectedToken, obtainedToken);
	}
	
	@DisplayName("VLDriverVersion4") 
	@Test
	void VLdriverVersion4Test() throws C_TokenManagementException {
		String filePath = this.jsonFilesFolder + "VLdriverVersion4.json";
		String expectedToken = " c35ad568698708237233d241a7dbb2f";
		String obtainedToken = myManager.tokenRequestGeneration(filePath);
		assertEquals(expectedToken, obtainedToken);
	}
	
	@DisplayName("VLDriverVersion24") 
	@Test
	void VLdriverVersion24Test() throws C_TokenManagementException {
		String filePath = this.jsonFilesFolder + "VLdriverVersion24.json";
		String expectedToken = "597ace7ff0e72a0f983bce55b9d0d0e1";
		String obtainedToken = myManager.tokenRequestGeneration(filePath);
		assertEquals(expectedToken, obtainedToken);
	}
	
	@DisplayName("VLDriverVersion25") 
	@Test
	void VLdriverVersion25Test() throws C_TokenManagementException {
		String filePath = this.jsonFilesFolder + "VLdriverVersion25.json";
		String expectedToken = "94e6ee61441f5f7e4604e7ad0bf2c842";
		String obtainedToken = myManager.tokenRequestGeneration(filePath);
		assertEquals(expectedToken, obtainedToken);
	}
	
	@DisplayName("VLDriverVersion26") 
	@Test
	void VLdriverVersion26Test() throws C_TokenManagementException {
		String filePath = this.jsonFilesFolder + "VLdriverVersion26.json";
		String expectedMessage = "Error: Driver Version value is longer than 25 characters.";
		C_TokenManagementException ex = Assertions.assertThrows(C_TokenManagementException.class, ()-> {
			myManager.tokenRequestGeneration(filePath);
		});
		Assertions.assertEquals(expectedMessage, ex.getMessage());
	}
	
	@DisplayName("SupportEmailIsMissing") 
	@Test
	void supportEmailIsMissingTest() throws C_TokenManagementException {
		String filePath = this.jsonFilesFolder + "SupportEmailIsMissing.json";
		String expectedMessage = "Error: invalid input data in JSON structure.";
		C_TokenManagementException ex = Assertions.assertThrows(C_TokenManagementException.class, ()-> {
			myManager.tokenRequestGeneration(filePath);
		});
		Assertions.assertEquals(expectedMessage, ex.getMessage());
	}
	
	@DisplayName("SupportEmailValueIsMissing") 
	@Test
	void supportEmailValueIsMissingTest() throws C_TokenManagementException {
		String filePath = this.jsonFilesFolder + "SupportEmailValueIsMissing.json";
		String expectedMessage = "Error: Support e-mail value is missing.";
		C_TokenManagementException ex = Assertions.assertThrows(C_TokenManagementException.class, ()-> {
			myManager.tokenRequestGeneration(filePath);
		});
		Assertions.assertEquals(expectedMessage, ex.getMessage());
	}
	
	@DisplayName("SupportEmailValueNotValid") 
    @Test
    void supportEmailValueNotValidTest() throws C_TokenManagementException {
        String filePath = this.jsonFilesFolder + "SupportEmailValueNotValid.json";
        String expectedMessage = "Error: Support e-mail value is not valid.";
        C_TokenManagementException ex = Assertions.assertThrows(C_TokenManagementException.class, ()-> {
            myManager.tokenRequestGeneration(filePath);
        });
        Assertions.assertEquals(expectedMessage, ex.getMessage());
    }

	@DisplayName("SerialNumberIsMissing") 
	@Test
	void serialNumberIsMissingTest() throws C_TokenManagementException {
		String filePath = this.jsonFilesFolder + "SerialNumberIsMissing.json";
		String expectedMessage = "Error: invalid input data in JSON structure.";
		C_TokenManagementException ex = Assertions.assertThrows(C_TokenManagementException.class, ()-> {
			myManager.tokenRequestGeneration(filePath);
		});
		Assertions.assertEquals(expectedMessage, ex.getMessage());
	}
	
	@DisplayName("SerialNumberValueIsMissing") 
	@Test
	void serialNumberValueIsMissingTest() throws C_TokenManagementException {
		String filePath = this.jsonFilesFolder + "SerialNumberValueIsMissing.json";
		String expectedMessage = "Error: Serial Number value is missing.";
		C_TokenManagementException ex = Assertions.assertThrows(C_TokenManagementException.class, ()-> {
			myManager.tokenRequestGeneration(filePath);
		});
		Assertions.assertEquals(expectedMessage, ex.getMessage());
	}
	
	@DisplayName("SerialNumberValueIsNotValid") 
	@Test
	void serialNumberValueNotValid() throws C_TokenManagementException {
		String filePath = this.jsonFilesFolder + "SerialNumberValueNotValid.json";
		String expectedMessage = "Error: Serial Number value is not valid.";
		C_TokenManagementException ex = Assertions.assertThrows(C_TokenManagementException.class, ()-> {
			myManager.tokenRequestGeneration(filePath);
		});
		Assertions.assertEquals(expectedMessage, ex.getMessage());
	}
	
	@DisplayName("MacAddressIsMissing") 
	@Test
	void macAddressIsMissingTest() throws C_TokenManagementException {
		String filePath = this.jsonFilesFolder + "MacAddressIsMissing.json";
		String expectedMessage = "Error: invalid input data in JSON structure.";
		C_TokenManagementException ex = Assertions.assertThrows(C_TokenManagementException.class, ()-> {
			myManager.tokenRequestGeneration(filePath);
		});
		Assertions.assertEquals(expectedMessage, ex.getMessage());
	}
	
	@DisplayName("MacAddressValueIsMissing") 
	@Test
	void macAddressValueIsMissingTest() throws C_TokenManagementException {
		String filePath = this.jsonFilesFolder + "MacAddressValueIsMissing.json";
		String expectedMessage = "Error: MAC Address value is missing.";
		C_TokenManagementException ex = Assertions.assertThrows(C_TokenManagementException.class, ()-> {
			myManager.tokenRequestGeneration(filePath);
		});
		Assertions.assertEquals(expectedMessage, ex.getMessage());
	}
	
	@DisplayName("MacAddressLengthIsNot17") 
	@Test
	void macAddressLengthIsNot17Test() throws C_TokenManagementException {
		String filePath = this.jsonFilesFolder + "MacAddressLengthIsNot17.json";
		String expectedMessage = "Error: MAC Address must have 17 characters.";
		C_TokenManagementException ex = Assertions.assertThrows(C_TokenManagementException.class, ()-> {
			myManager.tokenRequestGeneration(filePath);
		});
		Assertions.assertEquals(expectedMessage, ex.getMessage());
	}
	

}
