////Transport4Future////

package Transport4Future.TokenManagement;

import java.util.Date;

public class C_Token {
	private String alg;
	
	private String typ;
	
	private String device;
	
	private Date requestDate;
	
	private String notificationEmail;
	
	private long iat;
	
	private long exp;
	
	private String signature;
	
	private String tokenValue;
	
	public C_Token (String Device, Date RequestDate, String NotificationEmail) {
		this.alg = "HS256";
		this.typ = "PDS";
		this.device = Device;
		this.requestDate = RequestDate;
		this.notificationEmail = NotificationEmail;
		this.iat = 1585772542;
        	this.exp = this.iat + 604800000l;
		this.signature = null;
		this.tokenValue = null;
	}

	public Date getRequestDate() {
		return requestDate;
	}

	public void setRequestDate(Date requestDate) {
		this.requestDate = requestDate;
	}

	public String getNotificationEmail() {
		return notificationEmail;
	}

	public void setNotificationEmail(String notificationEmail) {
		this.notificationEmail = notificationEmail;
	}

	public String getDevice() {
		return device;
	}
	
	public void setDevice(String device) {
		this.device = device;
	}
	
	public String getSignature() {
		return this.signature;
	}
	
	public void setSignature(String signature) {
		this.signature = signature;
	}
	
	public String getTokenValue() {
		return this.tokenValue;
	}
	
	public void setTokenValue(String tokenValue) {
		this.tokenValue = tokenValue;
	}

	public boolean isGranted() {
		if(this.iat < System.currentTimeMillis()/1000) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean isExpired() {
		if(this.exp > (System.currentTimeMillis()/1000)) {
			return false;
		} else {
			return true;
		}
	}
	
	public String valuesToSign() {
		return "C_Token [alg=" + alg + ", typ=" + typ + ", device=" + device + ", iat=" + iat + ", exp=" + exp + "]";
	}

	@Override
	public String toString() {
		return "C_Token [alg=" + alg + ", typ=" + typ + ", device=" + device + ", iat=" + iat + ", exp=" + exp
				+ ", signature=" + signature + "]";
	}
	
}
