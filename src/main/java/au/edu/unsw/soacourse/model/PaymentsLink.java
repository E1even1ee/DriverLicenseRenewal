package au.edu.unsw.soacourse.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class PaymentsLink {
	
	private int id;
	private String uri;
	
	public PaymentsLink(){
		
	}
	
	public PaymentsLink(int id, String uri) {
		super();
		this.id = id;
		this.uri = uri;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUri() {
		return uri;
	}
	public void setUri(String uri) {
		this.uri = uri;
	}
	
	
}
