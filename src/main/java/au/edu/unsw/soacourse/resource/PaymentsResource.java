package au.edu.unsw.soacourse.resource;
import au.edu.unsw.soacourse.model.Payments;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/payments")
public class PaymentsResource {
	
	@GET
	@Path("{paymentID}")
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public Payments getPayment(@PathParam("paymentID") int id){
		Payments payment = new Payments();
//		DAO.getPayment(id)
//		???NOT FOUND(implemented in DAO)
		return payment;
	}
	
	@POST
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public Payments createPayment(){
		Payments payment = new Payments();
		payment.setPaidDate(null);
//		when the payment is achieved, change the paidDate
		return payment;
	}
	
//	@PUT
//	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
//	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
//	public Payments
}
