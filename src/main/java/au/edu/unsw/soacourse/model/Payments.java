package au.edu.unsw.soacourse.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Payments {
	
	private int id;
	private float amount;
	private String paidDate;
	private RenewalNoticeLink renewal;
	
	public Payments(){
		
	}
	
	public Payments(int id, float amount, String paidDate, RenewalNoticeLink renewal) {
		super();
		this.id = id;
		this.amount = amount;
		this.paidDate = paidDate;
		this.renewal = renewal;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public float getAmount() {
		return amount;
	}
	public void setAmount(float amount) {
		this.amount = amount;
	}
	public String getPaidDate() {
		return paidDate;
	}
	public void setPaidDate(String paidDate) {
		this.paidDate = paidDate;
	}
	public RenewalNoticeLink getRenewalNoticeLink() {
		return renewal;
	}
	public void setRenewalNoticeLink(RenewalNoticeLink renewalNoticeLink) {
		this.renewal = renewalNoticeLink;
	}
	
}
