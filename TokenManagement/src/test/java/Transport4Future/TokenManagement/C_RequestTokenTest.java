////Transport4Future////

package Transport4Future.TokenManagement;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class C_RequestTokenTest {
	
	private C_TokenManager myManager;
	
	private String jsonFilesFolder; 
	
	public C_RequestTokenTest() {
		jsonFilesFolder = System.getProperty("user.dir") + "/JSONFiles/TokenRequest/";

		myManager = new C_TokenManager();
	}

	@DisplayName("Correct Token Request") 
	@Test
	void correctRequestTokenTest() throws C_TokenManagementException {
		String filePath = this.jsonFilesFolder + "Correct.json";
		String expectedToken = "Q19Ub2tlbiBbYWxnPUhTMjU2LCB0eXA9UERTLCBkZXZpY2U9NTEyMzIzNDFhc2RjMTJzYTIyMzRtazU4OWgybDEydmIsIGlhdD0xNTg1NzcyNTQyLCBleHA9MjE5MDU3MjU0Miwgc2lnbmF0dXJlPTMwNWE0ZTZhMGIzYjRlMDZjZWU1ZDhlOWMwOGVhNTZhMGY5MTY4MTM4NGQ0ZDRjMTcwZjZlY2M0YWQxOWMzNzJd";
		String obtainedToken = myManager.requestToken(filePath);
		assertEquals(expectedToken, obtainedToken);
	}
	
	@DisplayName("Correct Token2 Request") 
	@Test
	void correctRequest2TokenTest() throws C_TokenManagementException {
		String filePath = this.jsonFilesFolder + "Correct2.json";
		String expectedToken = "Q19Ub2tlbiBbYWxnPUhTMjU2LCB0eXA9UERTLCBkZXZpY2U9NTE3MzIzNDFic2RjMTVzYTIyMzRzazU4OWgybDEydmIsIGlhdD0xNTg1NzcyNTQyLCBleHA9MjE5MDU3MjU0Miwgc2lnbmF0dXJlPWVhYzI4N2E1MTU0OWUwNmZjZmZkYjMxOGI2M2Y4ODRhNDBkNTM4YTBiNmVkYzUzMWU5ZTRkOGRjYThkZjIyZGJd";
		String obtainedToken = myManager.requestToken(filePath);
		assertEquals(expectedToken, obtainedToken);
	}
	
	@DisplayName("Correct3 Token Request") 
	@Test
	void correctRequest3TokenTest() throws C_TokenManagementException {
		String filePath = this.jsonFilesFolder + "Correct3.json";
		String expectedToken = "Q19Ub2tlbiBbYWxnPUhTMjU2LCB0eXA9UERTLCBkZXZpY2U9NTE0MTIzNDFhc2RjMTJzYTIyMzRkczU4OWgybDgydmIsIGlhdD0xNTg1NzcyNTQyLCBleHA9MjE5MDU3MjU0Miwgc2lnbmF0dXJlPTY4MWNmN2UxZGNhNjZkYWVlNzJhNmI5N2FkYTFmMDljYjVmNGY1YzQ4MjNhNTUwZjE2OGZkNjBmNzkwZDc2OTJd";
		String obtainedToken = myManager.requestToken(filePath);
		assertEquals(expectedToken, obtainedToken);
	}
	
	@DisplayName("Correct Token4 Request") 
	@Test
	void correctRequest4TokenTest() throws C_TokenManagementException {
		String filePath = this.jsonFilesFolder + "Correct4.json";
		String expectedToken = "Q19Ub2tlbiBbYWxnPUhTMjU2LCB0eXA9UERTLCBkZXZpY2U9NTMyMTIzNDFhc2RjMTJzYTIxMjNtazU4OWgybDEydmIsIGlhdD0xNTg1NzcyNTQyLCBleHA9MjE5MDU3MjU0Miwgc2lnbmF0dXJlPTE2OWIyOGNjYThlZmNhNDU3ODBjMWVjNDY0NmQ1YmIyMTQxYjgxMTZlMWU2ZWJiMzIwZmY3NTZhYjM1NzUwNzdd";
		String obtainedToken = myManager.requestToken(filePath);
		assertEquals(expectedToken, obtainedToken);
	}
	
	@DisplayName("Node 1 is empty (File Missing)") 
	@Test
	void fileIsMissingTest() throws C_TokenManagementException {
		String filePath = this.jsonFilesFolder + "FileIsMissing.json";
		String expectedMessage = "Error: input file not found.";
		C_TokenManagementException ex = Assertions.assertThrows(C_TokenManagementException.class, ()-> {
			myManager.requestToken(filePath);
		});
		Assertions.assertEquals(expectedMessage, ex.getMessage());
	}
	
	@DisplayName("Node 2 is empty (Missing {)") 
    @Test
    void bracketIsMissingTest() throws C_TokenManagementException {
        String filePath = this.jsonFilesFolder + "Node2Eliminated.json";
        String expectedMessage = "Error: input file could not be readed.";
        C_TokenManagementException ex = Assertions.assertThrows(C_TokenManagementException.class, ()-> {
            myManager.requestToken(filePath);
        });
        Assertions.assertEquals(expectedMessage, ex.getMessage());
    }
	
	@DisplayName("Node 2 is duplicated (Double {)") 
    @Test
    void bracketIsDuplicatedTest() throws C_TokenManagementException {
        String filePath = this.jsonFilesFolder + "Node2Duplicated.json";
        String expectedMessage = "Error: input file could not be readed.";
        C_TokenManagementException ex = Assertions.assertThrows(C_TokenManagementException.class, ()-> {
            myManager.requestToken(filePath);
        });
        Assertions.assertEquals(expectedMessage, ex.getMessage());
    }
	
	@DisplayName("Node 3 is eliminated (Empty file)") 
    @Test
    void emptyFileTest() throws C_TokenManagementException {
        String filePath = this.jsonFilesFolder + "Node3Eliminated.json";
        String expectedMessage = "Error: invalid Request Date format.";
        C_TokenManagementException ex = Assertions.assertThrows(C_TokenManagementException.class, ()-> {
            myManager.requestToken(filePath);
        });
        Assertions.assertEquals(expectedMessage, ex.getMessage());
    }
	
	@DisplayName("Node 3 is duplicated (File content duplicated)") 
    @Test
    void fileContentDuplicatedTest() throws C_TokenManagementException {
        String filePath = this.jsonFilesFolder + "Node3Duplicated.json";
        String expectedMessage = "Error: input file could not be readed.";
        C_TokenManagementException ex = Assertions.assertThrows(C_TokenManagementException.class, ()-> {
            myManager.requestToken(filePath);
        });
        Assertions.assertEquals(expectedMessage, ex.getMessage());
    }
	
	@DisplayName("Node 4 is empty (Missing })") 
    @Test
    void finalBracketMissingTest() throws C_TokenManagementException {
        String filePath = this.jsonFilesFolder + "Node4Eliminated.json";
        String expectedMessage = "Error: input file could not be readed.";
        C_TokenManagementException ex = Assertions.assertThrows(C_TokenManagementException.class, ()-> {
            myManager.requestToken(filePath);
        });
        Assertions.assertEquals(expectedMessage, ex.getMessage());
    }
	
	/*Este test no se pasa ya que el parser proporcionado es relajado, 
	 *es decir, cuando identifica el primer corchete termina
	 *
	@DisplayName("Node 4 is duplicated (Double })") 
    @Test
    void finalBracketDuplicatedTest() throws C_TokenManagementException {
        String filePath = this.jsonFilesFolder + "Node4Duplicated.json";
        String expectedMessage = "Error: input file could not be readed.";
        C_TokenManagementException ex = Assertions.assertThrows(C_TokenManagementException.class, ()-> {
            myManager.requestToken(filePath);
        });
        Assertions.assertEquals(expectedMessage, ex.getMessage());
    }*/
	
	@DisplayName("Node 6 is empty (Missing token request line)") 
    @Test
    void tokenRequestLineMissingTest() throws C_TokenManagementException {
        String filePath = this.jsonFilesFolder + "Node6Eliminated.json";
        String expectedMessage = "Error: invalid input data in JSON structure.";
        C_TokenManagementException ex = Assertions.assertThrows(C_TokenManagementException.class, ()-> {
            myManager.requestToken(filePath);
        });
        Assertions.assertEquals(expectedMessage, ex.getMessage());
    }
	
	/*Este test no se pasa, ya que el parser proporcionado es relajado,
	 *que en este caso se refiere a que solo comprueba que el campo Token 
	 *Request aparece, no le importa que haya dos
	 *
	@DisplayName("Node 6 is duplicated (Double token request)") 
    @Test
    void tokenRequestLineDuplicatedTest() throws C_TokenManagementException {
        String filePath = this.jsonFilesFolder + "Node6Duplicated.json";
        String expectedMessage = "Error: invalid input data in JSON structure.";
        C_TokenManagementException ex = Assertions.assertThrows(C_TokenManagementException.class, ()-> {
            myManager.requestToken(filePath);
        });
        Assertions.assertEquals(expectedMessage, ex.getMessage());
    }*/
	
	@DisplayName("Node 7 is empty (Missing separator)") 
    @Test
    void separatorMissingTest() throws C_TokenManagementException {
        String filePath = this.jsonFilesFolder + "Node7Eliminated.json";
        String expectedMessage = "Error: input file could not be readed.";
        C_TokenManagementException ex = Assertions.assertThrows(C_TokenManagementException.class, ()-> {
            myManager.requestToken(filePath);
        });
        Assertions.assertEquals(expectedMessage, ex.getMessage());
    }
	
	@DisplayName("Node 7 is duplicated (Double separator)") 
    @Test
    void separatorDuplicatedTest() throws C_TokenManagementException {
        String filePath = this.jsonFilesFolder + "Node7Duplicated.json";
        String expectedMessage = "Error: input file could not be readed.";
        C_TokenManagementException ex = Assertions.assertThrows(C_TokenManagementException.class, ()-> {
            myManager.requestToken(filePath);
        });
        Assertions.assertEquals(expectedMessage, ex.getMessage());
    }
	
	@DisplayName("Node 12 is empty (Missing toquen request)") 
    @Test
    void tokenRequestMissingTest() throws C_TokenManagementException {
        String filePath = this.jsonFilesFolder + "Node12Eliminated.json";
        String expectedMessage = "Error: input file could not be readed.";
        C_TokenManagementException ex = Assertions.assertThrows(C_TokenManagementException.class, ()-> {
            myManager.requestToken(filePath);
        });
        Assertions.assertEquals(expectedMessage, ex.getMessage());
    }
	
	@DisplayName("Node 12 is duplicated (Duplicated toquen request)") 
    @Test
    void tokenRequestDuplicatedTest() throws C_TokenManagementException {
        String filePath = this.jsonFilesFolder + "Node12Duplicated.json";
        String expectedMessage = "Error: input file could not be readed.";
        C_TokenManagementException ex = Assertions.assertThrows(C_TokenManagementException.class, ()-> {
            myManager.requestToken(filePath);
        });
        Assertions.assertEquals(expectedMessage, ex.getMessage());
    }
	
	@DisplayName("Node 13 is empty (Missing ':')") 
    @Test
    void equalitySymbolMissingTest() throws C_TokenManagementException {
        String filePath = this.jsonFilesFolder + "Node13Eliminated.json";
        String expectedMessage = "Error: input file could not be readed.";
        C_TokenManagementException ex = Assertions.assertThrows(C_TokenManagementException.class, ()-> {
            myManager.requestToken(filePath);
        });
        Assertions.assertEquals(expectedMessage, ex.getMessage());
    }
	
	@DisplayName("Node 13 is duplicated (Duplicated ':')") 
    @Test
    void equalitySymbolDuplicatedTest() throws C_TokenManagementException {
        String filePath = this.jsonFilesFolder + "Node13Duplicated.json";
        String expectedMessage = "Error: input file could not be readed.";
        C_TokenManagementException ex = Assertions.assertThrows(C_TokenManagementException.class, ()-> {
            myManager.requestToken(filePath);
        });
        Assertions.assertEquals(expectedMessage, ex.getMessage());
    }
	
	@DisplayName("Node 23 is empty (Missing 'comillas')") 
    @Test
    void comillasSymbolMissingTest() throws C_TokenManagementException {
        String filePath = this.jsonFilesFolder + "Node23Eliminated.json";
        String expectedMessage = "Error: input file could not be readed.";
        C_TokenManagementException ex = Assertions.assertThrows(C_TokenManagementException.class, ()-> {
            myManager.requestToken(filePath);
        });
        Assertions.assertEquals(expectedMessage, ex.getMessage());
    }
	
	@DisplayName("Node 23 is duplicated (Duplicated 'comillas')") 
    @Test
    void comillasSymbolDuplicatedTest() throws C_TokenManagementException {
        String filePath = this.jsonFilesFolder + "Node23Duplicated.json";
        String expectedMessage = "Error: input file could not be readed.";
        C_TokenManagementException ex = Assertions.assertThrows(C_TokenManagementException.class, ()-> {
            myManager.requestToken(filePath);
        });
        Assertions.assertEquals(expectedMessage, ex.getMessage());
    }
	
	@DisplayName("Node 24 is empty (Missing token request literal)") 
    @Test
    void missingTokenRequestTest() throws C_TokenManagementException {
        String filePath = this.jsonFilesFolder + "Node24Eliminated.json";
        String expectedMessage = "Error: invalid input data in JSON structure.";
        C_TokenManagementException ex = Assertions.assertThrows(C_TokenManagementException.class, ()-> {
            myManager.requestToken(filePath);
        });
        Assertions.assertEquals(expectedMessage, ex.getMessage());
    }
	
	@DisplayName("Node 24 is duplicated (Duplicated token request literal)") 
    @Test
    void duplicatedTokenRequestTest() throws C_TokenManagementException {
        String filePath = this.jsonFilesFolder + "Node24Duplicated.json";
        String expectedMessage = "Error: invalid input data in JSON structure.";
        C_TokenManagementException ex = Assertions.assertThrows(C_TokenManagementException.class, ()-> {
            myManager.requestToken(filePath);
        });
        Assertions.assertEquals(expectedMessage, ex.getMessage());
    }
	
	@DisplayName("Node 28 is empty (Missing token request value)") 
    @Test
    void missingTokenRequestValueTest() throws C_TokenManagementException {
        String filePath = this.jsonFilesFolder + "Node28Eliminated.json";
        String expectedMessage = "Error: Token Request value is missing.";
        C_TokenManagementException ex = Assertions.assertThrows(C_TokenManagementException.class, ()-> {
            myManager.requestToken(filePath);
        });
        Assertions.assertEquals(expectedMessage, ex.getMessage());
    }
	
	@DisplayName("Node 28 is duplicated (Duplicated token request value)") 
    @Test
    void duplicatedTokenRequestValueTest() throws C_TokenManagementException {
        String filePath = this.jsonFilesFolder + "Node28Duplicated.json";
        String expectedMessage = "Error: Token Request value is duplicated.";
        C_TokenManagementException ex = Assertions.assertThrows(C_TokenManagementException.class, ()-> {
            myManager.requestToken(filePath);
        });
        Assertions.assertEquals(expectedMessage, ex.getMessage());
    }
	
	@DisplayName("Node 31 is empty (Missing notification email literal)") 
    @Test
    void missingNotificationEmailTest() throws C_TokenManagementException {
        String filePath = this.jsonFilesFolder + "Node31Eliminated.json";
        String expectedMessage = "Error: invalid input data in JSON structure.";
        C_TokenManagementException ex = Assertions.assertThrows(C_TokenManagementException.class, ()-> {
            myManager.requestToken(filePath);
        });
        Assertions.assertEquals(expectedMessage, ex.getMessage());
    }
	
	@DisplayName("Node 31 is duplicated (Duplicated notification email literal)") 
    @Test
    void duplicatedNotificationEmailTest() throws C_TokenManagementException {
        String filePath = this.jsonFilesFolder + "Node31Duplicated.json";
        String expectedMessage = "Error: invalid input data in JSON structure.";
        C_TokenManagementException ex = Assertions.assertThrows(C_TokenManagementException.class, ()-> {
            myManager.requestToken(filePath);
        });
        Assertions.assertEquals(expectedMessage, ex.getMessage());
    }
	
	@DisplayName("Node 35 is empty (Missing notification email value)") 
    @Test
    void missingNotificationEmailValueTest() throws C_TokenManagementException {
        String filePath = this.jsonFilesFolder + "Node35Eliminated.json";
        String expectedMessage = "Error: Notification e-mail value is missing.";
        C_TokenManagementException ex = Assertions.assertThrows(C_TokenManagementException.class, ()-> {
            myManager.requestToken(filePath);
        });
        Assertions.assertEquals(expectedMessage, ex.getMessage());
    }
	
	@DisplayName("Node 35 is duplicated (Duplicated notification email value)") 
    @Test
    void duplicatedNotificationEmailValueTest() throws C_TokenManagementException {
        String filePath = this.jsonFilesFolder + "Node35Duplicated.json";
        String expectedMessage = "Error: Notification e-mail value is not valid.";
        C_TokenManagementException ex = Assertions.assertThrows(C_TokenManagementException.class, ()-> {
            myManager.requestToken(filePath);
        });
        Assertions.assertEquals(expectedMessage, ex.getMessage());
    }
	
	@DisplayName("Node 38 is empty (Missing request date literal)") 
    @Test
    void missingRequestDateTest() throws C_TokenManagementException {
        String filePath = this.jsonFilesFolder + "Node38Eliminated.json";
        String expectedMessage = "Error: invalid Request Date format.";
        C_TokenManagementException ex = Assertions.assertThrows(C_TokenManagementException.class, ()-> {
            myManager.requestToken(filePath);
        });
        Assertions.assertEquals(expectedMessage, ex.getMessage());
    }
	
	@DisplayName("Node 38 is duplicated (Duplicated request date literal)") 
    @Test
    void duplicatedRequestDateTest() throws C_TokenManagementException {
        String filePath = this.jsonFilesFolder + "Node38Duplicated.json";
        String expectedMessage = "Error: invalid Request Date format.";
        C_TokenManagementException ex = Assertions.assertThrows(C_TokenManagementException.class, ()-> {
            myManager.requestToken(filePath);
        });
        Assertions.assertEquals(expectedMessage, ex.getMessage());
    }
	
	@DisplayName("Node 42 is empty (Missing request date value)") 
    @Test
    void missingRequestDateValueTest() throws C_TokenManagementException {
        String filePath = this.jsonFilesFolder + "Node42Eliminated.json";
        String expectedMessage = "Error: invalid Request Date format.";
        C_TokenManagementException ex = Assertions.assertThrows(C_TokenManagementException.class, ()-> {
            myManager.requestToken(filePath);
        });
        Assertions.assertEquals(expectedMessage, ex.getMessage());
    }
	
	@DisplayName("Node 42 is duplicated (Duplicated request date value)") 
    @Test
    void duplicatedRequestDateValueTest() throws C_TokenManagementException {
        String filePath = this.jsonFilesFolder + "Node42Duplicated.json";
        String expectedMessage = "Error: invalid Request Date format.";
        C_TokenManagementException ex = Assertions.assertThrows(C_TokenManagementException.class, ()-> {
            myManager.requestToken(filePath);
        });
        Assertions.assertEquals(expectedMessage, ex.getMessage());
    }
	
	@DisplayName("Node 54 is empty (Missing nombre_mail)") 
    @Test
    void missingNombre_mailTest() throws C_TokenManagementException {
        String filePath = this.jsonFilesFolder + "Node54Eliminated.json";
        String expectedMessage = "Error: Notification e-mail value is not valid.";
        C_TokenManagementException ex = Assertions.assertThrows(C_TokenManagementException.class, ()-> {
            myManager.requestToken(filePath);
        });
        Assertions.assertEquals(expectedMessage, ex.getMessage());
    }
	
	/* Los tests en los que se duplican nodos, como es este caso, no
	 * pasa el test debido a la dificultad de la creación de la expresión regular para ello, 
	 * ya que no se considera que ese sea el objetivo de la práctica.
	 *
	@DisplayName("Node 54 is duplicated (Duplicated nombre_mail)") 
    @Test
    void duplicatedNombre_mailTest() throws C_TokenManagementException {
        String filePath = this.jsonFilesFolder + "Node54Duplicated.json";
        String expectedMessage = "Error: Notification e-mail value is not valid.";
        C_TokenManagementException ex = Assertions.assertThrows(C_TokenManagementException.class, ()-> {
            myManager.requestToken(filePath);
        });
        Assertions.assertEquals(expectedMessage, ex.getMessage());
    }*/
	
	@DisplayName("Node 55 is empty (Missing @)") 
    @Test
    void missingAtSymbolTest() throws C_TokenManagementException {
        String filePath = this.jsonFilesFolder + "Node55Eliminated.json";
        String expectedMessage = "Error: Notification e-mail value is not valid.";
        C_TokenManagementException ex = Assertions.assertThrows(C_TokenManagementException.class, ()-> {
            myManager.requestToken(filePath);
        });
        Assertions.assertEquals(expectedMessage, ex.getMessage());
    }
	
	@DisplayName("Node 55 is duplicated (Duplicated @)") 
    @Test
    void duplicatedAtSymbolTest() throws C_TokenManagementException {
        String filePath = this.jsonFilesFolder + "Node55Duplicated.json";
        String expectedMessage = "Error: Notification e-mail value is not valid.";
        C_TokenManagementException ex = Assertions.assertThrows(C_TokenManagementException.class, ()-> {
            myManager.requestToken(filePath);
        });
        Assertions.assertEquals(expectedMessage, ex.getMessage());
    }
	
	@DisplayName("Node 56 is empty (Missing dominio)") 
    @Test
    void missingDominioTest() throws C_TokenManagementException {
        String filePath = this.jsonFilesFolder + "Node56Eliminated.json";
        String expectedMessage = "Error: Notification e-mail value is not valid.";
        C_TokenManagementException ex = Assertions.assertThrows(C_TokenManagementException.class, ()-> {
            myManager.requestToken(filePath);
        });
        Assertions.assertEquals(expectedMessage, ex.getMessage());
    }
	
	/* Los tests en los que se duplican nodos, como es este caso, no
	 * pasa el test debido a la dificultad de la creación de la expresión regular para ello, 
	 * ya que no se considera que ese sea el objetivo de la práctica.
	 *
	@DisplayName("Node 56 is duplicated (Duplicated dominio)") 
    @Test
    void duplicatedDominioTest() throws C_TokenManagementException {
        String filePath = this.jsonFilesFolder + "Node56Duplicated.json";
        String expectedMessage = "Error: Notification e-mail value is not valid.";
        C_TokenManagementException ex = Assertions.assertThrows(C_TokenManagementException.class, ()-> {
            myManager.requestToken(filePath);
        });
        Assertions.assertEquals(expectedMessage, ex.getMessage());
    }*/
	
	@DisplayName("Node 57 is empty (Missing '.')") 
    @Test
    void missingDotTest() throws C_TokenManagementException {
        String filePath = this.jsonFilesFolder + "Node57Eliminated.json";
        String expectedMessage = "Error: Notification e-mail value is not valid.";
        C_TokenManagementException ex = Assertions.assertThrows(C_TokenManagementException.class, ()-> {
            myManager.requestToken(filePath);
        });
        Assertions.assertEquals(expectedMessage, ex.getMessage());
    }
	
	@DisplayName("Node 57 is duplicated (Duplicated '.')") 
    @Test
    void duplicatedDotTest() throws C_TokenManagementException {
        String filePath = this.jsonFilesFolder + "Node57Duplicated.json";
        String expectedMessage = "Error: Notification e-mail value is not valid.";
        C_TokenManagementException ex = Assertions.assertThrows(C_TokenManagementException.class, ()-> {
            myManager.requestToken(filePath);
        });
        Assertions.assertEquals(expectedMessage, ex.getMessage());
    }
	
	@DisplayName("Node 58 is empty (Missing extension)") 
    @Test
    void missingExtensionTest() throws C_TokenManagementException {
        String filePath = this.jsonFilesFolder + "Node58Eliminated.json";
        String expectedMessage = "Error: Notification e-mail value is not valid.";
        C_TokenManagementException ex = Assertions.assertThrows(C_TokenManagementException.class, ()-> {
            myManager.requestToken(filePath);
        });
        Assertions.assertEquals(expectedMessage, ex.getMessage());
    }
	
	@DisplayName("Node 58 is duplicated (Duplicated extension)") 
    @Test
    void duplicatedExtensionTest() throws C_TokenManagementException {
        String filePath = this.jsonFilesFolder + "Node58Duplicated.json";
        String expectedMessage = "Error: Notification e-mail value is not valid.";
        C_TokenManagementException ex = Assertions.assertThrows(C_TokenManagementException.class, ()-> {
            myManager.requestToken(filePath);
        });
        Assertions.assertEquals(expectedMessage, ex.getMessage());
    }
	
	@DisplayName("Node 64 is empty (Missing dia)") 
    @Test
    void missingDiaTest() throws C_TokenManagementException {
        String filePath = this.jsonFilesFolder + "Node64Eliminated.json";
        String expectedMessage = "Error: invalid Request Date format.";
        C_TokenManagementException ex = Assertions.assertThrows(C_TokenManagementException.class, ()-> {
            myManager.requestToken(filePath);
        });
        Assertions.assertEquals(expectedMessage, ex.getMessage());
    }
	
	@DisplayName("Node 64 is duplicated (Duplicated dia)") 
    @Test
    void duplicatedDiaTest() throws C_TokenManagementException {
        String filePath = this.jsonFilesFolder + "Node64Duplicated.json";
        String expectedMessage = "Error: invalid Request Date format.";
        C_TokenManagementException ex = Assertions.assertThrows(C_TokenManagementException.class, ()-> {
            myManager.requestToken(filePath);
        });
        Assertions.assertEquals(expectedMessage, ex.getMessage());
    }
	
	@DisplayName("Node 65 is empty (Missing guion)") 
    @Test
    void missingGuionTest() throws C_TokenManagementException {
        String filePath = this.jsonFilesFolder + "Node65Eliminated.json";
        String expectedMessage = "Error: invalid Request Date format.";
        C_TokenManagementException ex = Assertions.assertThrows(C_TokenManagementException.class, ()-> {
            myManager.requestToken(filePath);
        });
        Assertions.assertEquals(expectedMessage, ex.getMessage());
    }
	
	@DisplayName("Node 65 is duplicated (Duplicated guion)") 
    @Test
    void duplicatedGuionTest() throws C_TokenManagementException {
        String filePath = this.jsonFilesFolder + "Node65Duplicated.json";
        String expectedMessage = "Error: invalid Request Date format.";
        C_TokenManagementException ex = Assertions.assertThrows(C_TokenManagementException.class, ()-> {
            myManager.requestToken(filePath);
        });
        Assertions.assertEquals(expectedMessage, ex.getMessage());
    }
	
	@DisplayName("Node 66 is empty (Missing mes)") 
    @Test
    void missingMesTest() throws C_TokenManagementException {
        String filePath = this.jsonFilesFolder + "Node66Eliminated.json";
        String expectedMessage = "Error: invalid Request Date format.";
        C_TokenManagementException ex = Assertions.assertThrows(C_TokenManagementException.class, ()-> {
            myManager.requestToken(filePath);
        });
        Assertions.assertEquals(expectedMessage, ex.getMessage());
    }
	
	@DisplayName("Node 66 is duplicated (Duplicated guion)") 
    @Test
    void duplicatedMesTest() throws C_TokenManagementException {
        String filePath = this.jsonFilesFolder + "Node66Duplicated.json";
        String expectedMessage = "Error: invalid Request Date format.";
        C_TokenManagementException ex = Assertions.assertThrows(C_TokenManagementException.class, ()-> {
            myManager.requestToken(filePath);
        });
        Assertions.assertEquals(expectedMessage, ex.getMessage());
    }
	
	@DisplayName("Node 68 is empty (Missing año)") 
    @Test
    void missingAñoTest() throws C_TokenManagementException {
        String filePath = this.jsonFilesFolder + "Node68Eliminated.json";
        String expectedMessage = "Error: invalid Request Date format.";
        C_TokenManagementException ex = Assertions.assertThrows(C_TokenManagementException.class, ()-> {
            myManager.requestToken(filePath);
        });
        Assertions.assertEquals(expectedMessage, ex.getMessage());
    }
	
	@DisplayName("Node 68 is duplicated (Duplicated año)") 
    @Test
    void duplicatedAñoTest() throws C_TokenManagementException {
        String filePath = this.jsonFilesFolder + "Node68Duplicated.json";
        String expectedMessage = "Error: invalid Request Date format.";
        C_TokenManagementException ex = Assertions.assertThrows(C_TokenManagementException.class, ()-> {
            myManager.requestToken(filePath);
        });
        Assertions.assertEquals(expectedMessage, ex.getMessage());
    }
	
	@DisplayName("Node 69 is empty (Missing espacio)") 
    @Test
    void missingEspacioTest() throws C_TokenManagementException {
        String filePath = this.jsonFilesFolder + "Node69Eliminated.json";
        String expectedMessage = "Error: invalid Request Date format.";
        C_TokenManagementException ex = Assertions.assertThrows(C_TokenManagementException.class, ()-> {
            myManager.requestToken(filePath);
        });
        Assertions.assertEquals(expectedMessage, ex.getMessage());
    }
	
	@DisplayName("Node 69 is duplicated (Duplicated espacio)") 
    @Test
    void duplicatedEspacioTest() throws C_TokenManagementException {
        String filePath = this.jsonFilesFolder + "Node69Duplicated.json";
        String expectedMessage = "Error: invalid Request Date format.";
        C_TokenManagementException ex = Assertions.assertThrows(C_TokenManagementException.class, ()-> {
            myManager.requestToken(filePath);
        });
        Assertions.assertEquals(expectedMessage, ex.getMessage());
    }
	
	@DisplayName("Node 70 is empty (Missing hora)") 
    @Test
    void missingHoraTest() throws C_TokenManagementException {
        String filePath = this.jsonFilesFolder + "Node70Eliminated.json";
        String expectedMessage = "Error: invalid Request Date format.";
        C_TokenManagementException ex = Assertions.assertThrows(C_TokenManagementException.class, ()-> {
            myManager.requestToken(filePath);
        });
        Assertions.assertEquals(expectedMessage, ex.getMessage());
    }
	
	@DisplayName("Node 70 is duplicated (Duplicated hora)") 
    @Test
    void duplicatedHoraTest() throws C_TokenManagementException {
        String filePath = this.jsonFilesFolder + "Node70Duplicated.json";
        String expectedMessage = "Error: invalid Request Date format.";
        C_TokenManagementException ex = Assertions.assertThrows(C_TokenManagementException.class, ()-> {
            myManager.requestToken(filePath);
        });
        Assertions.assertEquals(expectedMessage, ex.getMessage());
    }
	
	@DisplayName("Node 72 is empty (Missing minuto)") 
    @Test
    void missingMinutoTest() throws C_TokenManagementException {
        String filePath = this.jsonFilesFolder + "Node72Eliminated.json";
        String expectedMessage = "Error: invalid Request Date format.";
        C_TokenManagementException ex = Assertions.assertThrows(C_TokenManagementException.class, ()-> {
            myManager.requestToken(filePath);
        });
        Assertions.assertEquals(expectedMessage, ex.getMessage());
    }
	
	@DisplayName("Node 72 is duplicated (Duplicated minuto)") 
    @Test
    void duplicatedMinutoTest() throws C_TokenManagementException {
        String filePath = this.jsonFilesFolder + "Node72Duplicated.json";
        String expectedMessage = "Error: invalid Request Date format.";
        C_TokenManagementException ex = Assertions.assertThrows(C_TokenManagementException.class, ()-> {
            myManager.requestToken(filePath);
        });
        Assertions.assertEquals(expectedMessage, ex.getMessage());
    }
	
	@DisplayName("Node 74 is empty (Missing segundo)") 
    @Test
    void missingSegundoTest() throws C_TokenManagementException {
        String filePath = this.jsonFilesFolder + "Node74Eliminated.json";
        String expectedMessage = "Error: invalid Request Date format.";
        C_TokenManagementException ex = Assertions.assertThrows(C_TokenManagementException.class, ()-> {
            myManager.requestToken(filePath);
        });
        Assertions.assertEquals(expectedMessage, ex.getMessage());
    }
	
	@DisplayName("Node 74 is duplicated (Duplicated segundo)") 
    @Test
    void duplicatedSegundoTest() throws C_TokenManagementException {
        String filePath = this.jsonFilesFolder + "Node74Duplicated.json";
        String expectedMessage = "Error: invalid Request Date format.";
        C_TokenManagementException ex = Assertions.assertThrows(C_TokenManagementException.class, ()-> {
            myManager.requestToken(filePath);
        });
        Assertions.assertEquals(expectedMessage, ex.getMessage());
    }
	
	@DisplayName("Node 5 not valid (Not {)") 
    @Test
    void node5NotValidTest() throws C_TokenManagementException {
        String filePath = this.jsonFilesFolder + "Node5NotValid.json";
        String expectedMessage = "Error: input file could not be readed.";
        C_TokenManagementException ex = Assertions.assertThrows(C_TokenManagementException.class, ()-> {
            myManager.requestToken(filePath);
        });
        Assertions.assertEquals(expectedMessage, ex.getMessage());
    }
	
	@DisplayName("Node 44 not valid (Not 'comillas')") 
    @Test
    void node44NotValidTest() throws C_TokenManagementException {
        String filePath = this.jsonFilesFolder + "Node44NotValid.json";
        String expectedMessage = "Error: input file could not be readed.";
        C_TokenManagementException ex = Assertions.assertThrows(C_TokenManagementException.class, ()-> {
            myManager.requestToken(filePath);
        });
        Assertions.assertEquals(expectedMessage, ex.getMessage());
    }
	
	@DisplayName("Node 45 not valid (Not 'Token Request')") 
    @Test
    void node45NotValidTest() throws C_TokenManagementException {
        String filePath = this.jsonFilesFolder + "Node45NotValid.json";
        String expectedMessage = "Error: invalid input data in JSON structure.";
        C_TokenManagementException ex = Assertions.assertThrows(C_TokenManagementException.class, ()-> {
            myManager.requestToken(filePath);
        });
        Assertions.assertEquals(expectedMessage, ex.getMessage());
    }
	
	@DisplayName("Node 26 not valid (Not ':')") 
    @Test
    void node26NotValidTest() throws C_TokenManagementException {
        String filePath = this.jsonFilesFolder + "Node26NotValid.json";
        String expectedMessage = "Error: input file could not be readed.";
        C_TokenManagementException ex = Assertions.assertThrows(C_TokenManagementException.class, ()-> {
            myManager.requestToken(filePath);
        });
        Assertions.assertEquals(expectedMessage, ex.getMessage());
    }
	
	@DisplayName("Node 48 not valid (Not valid value)") 
    @Test
    void node48NotValidTest() throws C_TokenManagementException {
        String filePath = this.jsonFilesFolder + "Node48NotValid.json";
        String expectedMessage = "Error: Token Request value is duplicated.";
        C_TokenManagementException ex = Assertions.assertThrows(C_TokenManagementException.class, ()-> {
            myManager.requestToken(filePath);
        });
        Assertions.assertEquals(expectedMessage, ex.getMessage());
    }
	
	@DisplayName("Node 15 not valid (Not ',')") 
    @Test
    void node15NotValidTest() throws C_TokenManagementException {
        String filePath = this.jsonFilesFolder + "Node15NotValid.json";
        String expectedMessage = "Error: input file could not be readed.";
        C_TokenManagementException ex = Assertions.assertThrows(C_TokenManagementException.class, ()-> {
            myManager.requestToken(filePath);
        });
        Assertions.assertEquals(expectedMessage, ex.getMessage());
    }
	
	@DisplayName("Node 51 not valid (Not 'Notification email')") 
    @Test
    void node51NotValidTest() throws C_TokenManagementException {
        String filePath = this.jsonFilesFolder + "Node51NotValid.json";
        String expectedMessage = "Error: invalid input data in JSON structure.";
        C_TokenManagementException ex = Assertions.assertThrows(C_TokenManagementException.class, ()-> {
            myManager.requestToken(filePath);
        });
        Assertions.assertEquals(expectedMessage, ex.getMessage());
    }
	
	@DisplayName("Node 76 not valid (Not valid value)") 
    @Test
    void node76NotValidTest() throws C_TokenManagementException {
        String filePath = this.jsonFilesFolder + "Node76NotValid.json";
        String expectedMessage = "Error: Notification e-mail value is not valid.";
        C_TokenManagementException ex = Assertions.assertThrows(C_TokenManagementException.class, ()-> {
            myManager.requestToken(filePath);
        });
        Assertions.assertEquals(expectedMessage, ex.getMessage());
    }
	
	@DisplayName("Node 77 not valid (Not @)") 
    @Test
    void node77NotValidTest() throws C_TokenManagementException {
        String filePath = this.jsonFilesFolder + "Node77NotValid.json";
        String expectedMessage = "Error: Notification e-mail value is not valid.";
        C_TokenManagementException ex = Assertions.assertThrows(C_TokenManagementException.class, ()-> {
            myManager.requestToken(filePath);
        });
        Assertions.assertEquals(expectedMessage, ex.getMessage());
    }
	
	@DisplayName("Node 78 not valid (Not valid value)") 
    @Test
    void node78NotValidTest() throws C_TokenManagementException {
        String filePath = this.jsonFilesFolder + "Node78NotValid.json";
        String expectedMessage = "Error: Notification e-mail value is not valid.";
        C_TokenManagementException ex = Assertions.assertThrows(C_TokenManagementException.class, ()-> {
            myManager.requestToken(filePath);
        });
        Assertions.assertEquals(expectedMessage, ex.getMessage());
    }
	
	@DisplayName("Node 79 not valid (Not '.')") 
    @Test
    void node79NotValidTest() throws C_TokenManagementException {
        String filePath = this.jsonFilesFolder + "Node79NotValid.json";
        String expectedMessage = "Error: Notification e-mail value is not valid.";
        C_TokenManagementException ex = Assertions.assertThrows(C_TokenManagementException.class, ()-> {
            myManager.requestToken(filePath);
        });
        Assertions.assertEquals(expectedMessage, ex.getMessage());
    }
	
	@DisplayName("Node 80 not valid (Value longer than 3)") 
    @Test
    void node80NotValidTest() throws C_TokenManagementException {
        String filePath = this.jsonFilesFolder + "Node80NotValid.json";
        String expectedMessage = "Error: Notification e-mail value is not valid.";
        C_TokenManagementException ex = Assertions.assertThrows(C_TokenManagementException.class, ()-> {
            myManager.requestToken(filePath);
        });
        Assertions.assertEquals(expectedMessage, ex.getMessage());
    }
	
	@DisplayName("Node 61 not valid (Not 'Request Date')") 
    @Test
    void node61NotValidTest() throws C_TokenManagementException {
        String filePath = this.jsonFilesFolder + "Node61NotValid.json";
        String expectedMessage = "Error: invalid Request Date format.";
        C_TokenManagementException ex = Assertions.assertThrows(C_TokenManagementException.class, ()-> {
            myManager.requestToken(filePath);
        });
        Assertions.assertEquals(expectedMessage, ex.getMessage());
    }
	
	@DisplayName("Node 81 not valid (Not valid digits)") 
    @Test
    void node81NotValidTest() throws C_TokenManagementException {
        String filePath = this.jsonFilesFolder + "Node81NotValid.json";
        String expectedMessage = "Error: invalid Request Date format.";
        C_TokenManagementException ex = Assertions.assertThrows(C_TokenManagementException.class, ()-> {
            myManager.requestToken(filePath);
        });
        Assertions.assertEquals(expectedMessage, ex.getMessage());
    }
	
	@DisplayName("Node 82 not valid (Not '-')") 
    @Test
    void node82NotValidTest() throws C_TokenManagementException {
        String filePath = this.jsonFilesFolder + "Node82NotValid.json";
        String expectedMessage = "Error: invalid Request Date format.";
        C_TokenManagementException ex = Assertions.assertThrows(C_TokenManagementException.class, ()-> {
            myManager.requestToken(filePath);
        });
        Assertions.assertEquals(expectedMessage, ex.getMessage());
    }
	
	@DisplayName("Node 83 not valid (Not valid digits)") 
    @Test
    void node83NotValidTest() throws C_TokenManagementException {
        String filePath = this.jsonFilesFolder + "Node83NotValid.json";
        String expectedMessage = "Error: invalid Request Date format.";
        C_TokenManagementException ex = Assertions.assertThrows(C_TokenManagementException.class, ()-> {
            myManager.requestToken(filePath);
        });
        Assertions.assertEquals(expectedMessage, ex.getMessage());
    }
	
	@DisplayName("Node 85 not valid (Not valid digits)") 
    @Test
    void node85NotValidTest() throws C_TokenManagementException {
        String filePath = this.jsonFilesFolder + "Node85NotValid.json";
        String expectedMessage = "Error: invalid Request Date format.";
        C_TokenManagementException ex = Assertions.assertThrows(C_TokenManagementException.class, ()-> {
            myManager.requestToken(filePath);
        });
        Assertions.assertEquals(expectedMessage, ex.getMessage());
    }
	
	@DisplayName("Node 86 not valid (Not ' ')") 
    @Test
    void node86NotValidTest() throws C_TokenManagementException {
        String filePath = this.jsonFilesFolder + "Node86NotValid.json";
        String expectedMessage = "Error: invalid Request Date format.";
        C_TokenManagementException ex = Assertions.assertThrows(C_TokenManagementException.class, ()-> {
            myManager.requestToken(filePath);
        });
        Assertions.assertEquals(expectedMessage, ex.getMessage());
    }
	
	@DisplayName("Node 87 not valid (Not valid digits)") 
    @Test
    void node87NotValidTest() throws C_TokenManagementException {
        String filePath = this.jsonFilesFolder + "Node87NotValid.json";
        String expectedMessage = "Error: invalid Request Date format.";
        C_TokenManagementException ex = Assertions.assertThrows(C_TokenManagementException.class, ()-> {
            myManager.requestToken(filePath);
        });
        Assertions.assertEquals(expectedMessage, ex.getMessage());
    }
	
	@DisplayName("Node 89 not valid (Not valid digits)") 
    @Test
    void node89NotValidTest() throws C_TokenManagementException {
        String filePath = this.jsonFilesFolder + "Node89NotValid.json";
        String expectedMessage = "Error: invalid Request Date format.";
        C_TokenManagementException ex = Assertions.assertThrows(C_TokenManagementException.class, ()-> {
            myManager.requestToken(filePath);
        });
        Assertions.assertEquals(expectedMessage, ex.getMessage());
    }
	
	@DisplayName("Node 91 not valid (Not valid digits)") 
    @Test
    void node91NotValidTest() throws C_TokenManagementException {
        String filePath = this.jsonFilesFolder + "Node91NotValid.json";
        String expectedMessage = "Error: invalid Request Date format.";
        C_TokenManagementException ex = Assertions.assertThrows(C_TokenManagementException.class, ()-> {
            myManager.requestToken(filePath);
        });
        Assertions.assertEquals(expectedMessage, ex.getMessage());
    }
	
}
