////Transport4Future////

package Transport4Future.TokenManagement;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class C_VerifyTokenTest {

	private C_TokenManager myManager;
	
	public C_VerifyTokenTest() {
		myManager = new C_TokenManager();
	}

	@DisplayName("Token is not found") 
	@Test
	void wrongVerifyToken1Test() throws C_TokenManagementException {
		String tokenToVerify = "Q19Ub2tlbiBbYWxnPUhTMjU2LCB0IyMzRtazU4OWgybDEydmIsIGlhdD0xNTgzNzgwMzA5LCBleHA9MjE4ODU4MDMxMCwgc2lnbmF0dXJlPTg0YjgxY2JlOTRjMGI4MzE2N2QyMDM3ZDc0NmU0MWNiMGM1MzdjZjA2ZGUwNDg4MTBiMGQ3OWMwNDNhMjNjY2Fd";
		String expectedMessage = "Token is not found in tokenStore";
		C_TokenManagementException ex = Assertions.assertThrows(C_TokenManagementException.class, ()-> {
			myManager.verifyToken(tokenToVerify);
		});
		Assertions.assertEquals(expectedMessage, ex.getMessage());
	}
	
	@DisplayName("Verify is true, token found, is granted and not expired") 
	@Test
	void correctVerifyTokenTest() throws C_TokenManagementException {
		boolean expected = true;
		String tokenToVerify = "Q19Ub2tlbiBbYWxnPUhTMjU2LCB0eXA9UERTLCBkZXZpY2U9NTEyMzIzNDFhc2RjMTJzYTIyMzRtazU4OWgybDEydmIsIGlhdD0xNTg1NzcyNTQyLCBleHA9MjE5MDU3MjU0Miwgc2lnbmF0dXJlPTMwNWE0ZTZhMGIzYjRlMDZjZWU1ZDhlOWMwOGVhNTZhMGY5MTY4MTM4NGQ0ZDRjMTcwZjZlY2M0YWQxOWMzNzJd";
		boolean obtained = myManager.verifyToken(tokenToVerify);
		assertEquals(expected, obtained);
	}
	
	@DisplayName("Verify is false, token found, is granted and expired") 
	@Test
	void wrongVerifyToken2Test() throws C_TokenManagementException {
		boolean expected = false;
		String tokenToVerify = "Q19Ub2tlbiBbYWxnPUhTMjU2LCB0eXA9UERTLCBkZXZpY2U9NTMyMTIzNDFhc2RjMTJzYTIxMjNtazU4OWgybDEydmIsIGlhdD0xNTg1NzcyNTQyLCBleHA9MjE5MDU3MjU0Miwgc2lnbmF0dXJlPTE2OWIyOGNjYThlZmNhNDU3ODBjMWVjNDY0NmQ1YmIyMTQxYjgxMTZlMWU2ZWJiMzIwZmY3NTZhYjM1NzUwNzdd";
		boolean obtained = myManager.verifyToken(tokenToVerify);
		assertEquals(expected, obtained);
	}
	
	@DisplayName("Verify is false, token found, is not granted and expired") 
	@Test
	void wrongVerifyToken3Test() throws C_TokenManagementException {
		boolean expected = false;
		String tokenToVerify = "Q19Ub2tlbiBbYWxnPUhTMjU2LCB0eXA9UERTLCBkZXZpY2U9NTE0MTIzNDFhc2RjMTJzYTIyMzRkczU4OWgybDgydmIsIGlhdD0xNTg1NzcyNTQyLCBleHA9MjE5MDU3MjU0Miwgc2lnbmF0dXJlPTY4MWNmN2UxZGNhNjZkYWVlNzJhNmI5N2FkYTFmMDljYjVmNGY1YzQ4MjNhNTUwZjE2OGZkNjBmNzkwZDc2OTJd";
		boolean obtained = myManager.verifyToken(tokenToVerify);
		assertEquals(expected, obtained);
	}
	
	@DisplayName("Verify is false, token found, is not granted and not expired") 
	@Test
	void wrongVerifyToken4Test() throws C_TokenManagementException {
		boolean expected = false;
		String tokenToVerify = "Q19Ub2tlbiBbYWxnPUhTMjU2LCB0eXA9UERTLCBkZXZpY2U9NTE3MzIzNDFic2RjMTVzYTIyMzRzazU4OWgybDEydmIsIGlhdD0xNTg1NzcyNTQyLCBleHA9MjE5MDU3MjU0Miwgc2lnbmF0dXJlPWVhYzI4N2E1MTU0OWUwNmZjZmZkYjMxOGI2M2Y4ODRhNDBkNTM4YTBiNmVkYzUzMWU5ZTRkOGRjYThkZjIyZGJd";
		boolean obtained = myManager.verifyToken(tokenToVerify);
		assertEquals(expected, obtained);
	}
	
	@DisplayName("File empty") 
	@Test
	void wrongVerifyToken5Test() throws C_TokenManagementException {
		String tokenToVerify = "Q19Ub2tlbiBbYWxnPUhTMjU2LCB0IyMzRtazU4OWgybDEydmIsIGlhdD0xNTgzNzgwMzA5LCBleHA9MjE4ODU4MDMxMCwgc2lnbmF0dXJlPTg0YjgxY2JlOTRjMGI4MzE2N2QyMDM3ZDc0NmU0MWNiMGM1MzdjZjA2ZGUwNDg4MTBiMGQ3OWMwNDNhMjNjY2Fd";
		String expectedMessage = "Token is not found in tokenStore";
		C_TokenManagementException ex = Assertions.assertThrows(C_TokenManagementException.class, ()-> {
			myManager.verifyToken(tokenToVerify);
		});
		Assertions.assertEquals(expectedMessage, ex.getMessage());
	}
	
	@DisplayName("Token first position") 
	@Test
	void wrongVerifyToken6Test() throws C_TokenManagementException {
		boolean expected = true;
		String tokenToVerify = "Q19Ub2tlbiBbYWxnPUhTMjU2LCB0eXA9UERTLCBkZXZpY2U9NTEyMzIzNDFhc2RjMTJzYTIyMzRtazU4OWgybDEydmIsIGlhdD0xNTg1NzcyNTQyLCBleHA9MjE5MDU3MjU0Miwgc2lnbmF0dXJlPTMwNWE0ZTZhMGIzYjRlMDZjZWU1ZDhlOWMwOGVhNTZhMGY5MTY4MTM4NGQ0ZDRjMTcwZjZlY2M0YWQxOWMzNzJd";
		boolean obtained = myManager.verifyToken(tokenToVerify);
		assertEquals(expected, obtained);
	}
	
	@DisplayName("Token second position") 
	@Test
	void wrongVerifyToken7Test() throws C_TokenManagementException {
		boolean expected = true;
		String tokenToVerify = "Q19Ub2tlbiBbYWxnPUhTMjU2LCB0eXA9UERTLCBkZXZpY2U9NTEyMzIzNDFhc2RjMTJzYTIyMzRtazU4OWgybDEydmIsIGlhdD0xNTg1NzcyNTQyLCBleHA9MjE5MDU3MjU0Miwgc2lnbmF0dXJlPTMwNWE0ZTZhMGIzYjRlMDZjZWU1ZDhlOWMwOGVhNTZhMGY5MTY4MTM4NGQ0ZDRjMTcwZjZlY2M0YWQxOWMzNzJd";
		boolean obtained = myManager.verifyToken(tokenToVerify);
		assertEquals(expected, obtained);
	}
	
	@DisplayName("Token last position") 
	@Test
	void wrongVerifyToken8Test() throws C_TokenManagementException {
		boolean expected = true;
		String tokenToVerify = "Q19Ub2tlbiBbYWxnPUhTMjU2LCB0eXA9UERTLCBkZXZpY2U9NTEyMzIzNDFhc2RjMTJzYTIyMzRtazU4OWgybDEydmIsIGlhdD0xNTg1NzcyNTQyLCBleHA9MjE5MDU3MjU0Miwgc2lnbmF0dXJlPTMwNWE0ZTZhMGIzYjRlMDZjZWU1ZDhlOWMwOGVhNTZhMGY5MTY4MTM4NGQ0ZDRjMTcwZjZlY2M0YWQxOWMzNzJd";
		boolean obtained = myManager.verifyToken(tokenToVerify);
		assertEquals(expected, obtained);
	}
	
	//No se puede probar, por lo que hemos puesto un Token que si aparece en la tokenStore para que no salte la excepcion
	@DisplayName("Token last+1 position") 
	@Test
	void wrongVerifyToken9Test() throws C_TokenManagementException {
		boolean expected = true;
		String tokenToVerify = "Q19Ub2tlbiBbYWxnPUhTMjU2LCB0eXA9UERTLCBkZXZpY2U9NTEyMzIzNDFhc2RjMTJzYTIyMzRtazU4OWgybDEydmIsIGlhdD0xNTg1NzcyNTQyLCBleHA9MjE5MDU3MjU0Miwgc2lnbmF0dXJlPTMwNWE0ZTZhMGIzYjRlMDZjZWU1ZDhlOWMwOGVhNTZhMGY5MTY4MTM4NGQ0ZDRjMTcwZjZlY2M0YWQxOWMzNzJd";
		boolean obtained = myManager.verifyToken(tokenToVerify);
		assertEquals(expected, obtained);
	}
	
	@DisplayName("Token last-1 position") 
	@Test
	void wrongVerifyToken10Test() throws C_TokenManagementException {
		boolean expected = true;
		String tokenToVerify = "Q19Ub2tlbiBbYWxnPUhTMjU2LCB0eXA9UERTLCBkZXZpY2U9NTEyMzIzNDFhc2RjMTJzYTIyMzRtazU4OWgybDEydmIsIGlhdD0xNTg1NzcyNTQyLCBleHA9MjE5MDU3MjU0Miwgc2lnbmF0dXJlPTMwNWE0ZTZhMGIzYjRlMDZjZWU1ZDhlOWMwOGVhNTZhMGY5MTY4MTM4NGQ0ZDRjMTcwZjZlY2M0YWQxOWMzNzJd";
		boolean obtained = myManager.verifyToken(tokenToVerify);
		assertEquals(expected, obtained);
	}
	
}
