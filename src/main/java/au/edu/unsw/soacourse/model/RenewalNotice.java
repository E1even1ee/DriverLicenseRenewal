package au.edu.unsw.soacourse.model;

import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement
public class RenewalNotice {
	
	private int id;
	private String driverName;
	private String address;
	private String email;
	private float fee;
	private int status;
	private String issueDate;
	private String lastModified;
	private CarLicenseLink license;
	private PaymentsLink payment;
	
	public RenewalNotice() {
		
	}
	
	public RenewalNotice(int id, String driverName, String address, String email, float fee, int status,
			String issueDate, String lastModified, CarLicenseLink license, PaymentsLink payment) {
		super();
		this.id = id;
		this.driverName = driverName;
		this.address = address;
		this.email = email;
		this.fee = fee;
		this.status = status;
		this.issueDate = issueDate;
		this.lastModified = lastModified;
		this.license = license;
		this.payment = payment;
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
	public float getFee() {
		return fee;
	}
	public void setFee(float fee) {
		this.fee = fee;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getIssueDate() {
		return issueDate;
	}
	public void setIssueDate(String issueDate) {
		this.issueDate = issueDate;
	}
	public String getLastModified() {
		return lastModified;
	}
	public void setLastModified(String lastModified) {
		this.lastModified = lastModified;
	}

	public CarLicenseLink getLicense() {
		return license;
	}

	public void setLicense(CarLicenseLink license) {
		this.license = license;
	}

	public PaymentsLink getPayment() {
		return payment;
	}

	public void setPayment(PaymentsLink payment) {
		this.payment = payment;
	}
    
}
