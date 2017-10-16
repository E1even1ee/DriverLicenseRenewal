package au.edu.unsw.soacourse.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class CarLicense {
	
	private int id;
	private String driverName;
	private String address;
	private String email;
	private String licenseNumber;
	private String licenseClass;
	private String expiryDate;
	
	public CarLicense(){
		
	}
	
	public CarLicense(int id, String driverName, String address, String licenseNumber,
			String licenseClass, String email, String expiryDate) {
		this.id = id;
		this.driverName = driverName;
		this.address = address;
		this.email = email;
		this.licenseNumber = licenseNumber;
		this.licenseClass = licenseClass;
		this.expiryDate = expiryDate;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDriverName() {
		return driverName;
	}
	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getLicenseNumber() {
		return licenseNumber;
	}
	public void setLicenseNumber(String licenseNumber) {
		this.licenseNumber = licenseNumber;
	}
	public String getLicenseClass() {
		return licenseClass;
	}
	public void setLicenseClass(String licenseClass) {
		this.licenseClass = licenseClass;
	}
	public String getExpiryDate() {
		return expiryDate;
	}
	public void setExpiryDate(String expiryDate) {
		this.expiryDate = expiryDate;
	}
	
	
}
