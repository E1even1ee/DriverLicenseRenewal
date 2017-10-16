package au.edu.unsw.soacourse.resource;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import au.edu.unsw.soacourse.model.CarLicenseLink;
import au.edu.unsw.soacourse.model.RenewalNotice;

@Path("/renewals")
public class RenewalNoticeResource {
	
	@GET
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public ArrayList<RenewalNotice> getAll(){
	ArrayList<RenewalNotice> allList = new ArrayList<RenewalNotice>();
//	ArrayList<RenewalNotice> allList = DAO.getALL();
	return allList;
	}
	
	@GET
	@Path("{renewalID}")
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public RenewalNotice getRenewal(@PathParam("renewalID") int id){
		RenewalNotice renewal = new RenewalNotice();
//		renewl = DAO.getWithId(id);
		return renewal;
	}
	
	@POST
	@Path("{renewalID}")
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public RenewalNotice createRenewal(@PathParam("renewalID") int id, RenewalNotice renewalNotice){
//		DAO.createRenewal
//		RenewalNotice renewal = DAO.getLicense(input.id)
//		ATTRIBUTEs NEED TO CHANGE: 
//			status
//			issueDate
//			lastmodified
		RenewalNotice createdRenewal = new RenewalNotice();
		return createdRenewal;
	}
	
	@PUT
	@Path("{renewalID}")
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public RenewalNotice updateRenewal(@PathParam("renewalID") int id, RenewalNotice input){
		RenewalNotice updatedRenewal = new RenewalNotice();
		
//		Other ATTRIBUTEs NEED TO CHANGE: 
//		status
//		lastmodified
		
//		DAO.updateRenewal(input);
		return updatedRenewal;
	}
	
	@DELETE
	@Path("{renewalID}")
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public RenewalNotice deleteRenewal(@PathParam("renewalID") int id){
		RenewalNotice renewal = new RenewalNotice();
//		DAO.removeRenewal
//		renewl = DAO.getWithId(id);
		return renewal;
	}
}
