////Transport4Future////

package Transport4Future.TokenManagement;

public class C_TokenRequest {
	
	private String deviceName;
	
	private String typeOfDevice;
	
	private String driverVersion;
	
	private String supportEmail;
	
	private String serialNumber;
	
	private String macAddress;
	
	public C_TokenRequest(String deviceName, String typeOfDevice, String driverVersion, String supportEmail, String serialNumber, String macAddress) {
		this.deviceName = deviceName;
		this.typeOfDevice = typeOfDevice;
		this.driverVersion = driverVersion;
		this.supportEmail = supportEmail;
		this.serialNumber = serialNumber;
		this.macAddress = macAddress;
	}
	
	@Override
	public String toString() {
		return "TokenRequest [\\n\\Device Name=" + this.deviceName + ",\n\t\\Type of Device=" + this.typeOfDevice 
				+ ",\n\t\\Driver Version=" + this.driverVersion + ",\n\t\\Support Email=" + this.supportEmail + ",\n\t\\Serial Number=" +
				this.serialNumber + ",\n\t\\MAC Address=" + this.macAddress + "\n]";
	}

	public String getDeviceName() {
		return deviceName;
	}

	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
	}

	public String getTypeOfDevice() {
		return typeOfDevice;
	}

	public void setTypeOfDevice(String typeOfDevice) {
		this.typeOfDevice = typeOfDevice;
	}

	public String getDriverVersion() {
		return driverVersion;
	}

	public void setDriverVersion(String driverVersion) {
		this.driverVersion = driverVersion;
	}

	public String getSupportEmail() {
		return supportEmail;
	}

	public void setSupportEmail(String supportEmail) {
		this.supportEmail = supportEmail;
	}

	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public String getMacAddress() {
		return macAddress;
	}

	public void setMacAddress(String macAddress) {
		this.macAddress = macAddress;
	}
	
}
