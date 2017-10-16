package au.edu.unsw.soacourse.resource;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;

import au.edu.unsw.soacourse.model.CarLicense;
import au.edu.unsw.soacourse.dao.CarlicenseDao;

@Path("/licenses")
public class CarlicenseResource {	
	
	String DriverTokenID = "03e8296d-566a-4405-bb03-bf4913794c90";
	String OfficerTokenID = "22ecc9e1-fa98-4ea8-a50b-8a074046b02c";
	
//	@GET
//	@Path("test")
//	@Produces(MediaType.TEXT_PLAIN)
//	public String Test(@FormParam("oauth_token") String tokenID){
//		return tokenID;
//	}
	
	@GET
	@Path("{LicenseID}")
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public CarLicense getLicense(@PathParam("LicenseID") int id, @QueryParam("oauth_token") String tokenID){		
		if (tokenID.equals(OfficerTokenID)){
			CarLicense carLicense = new CarLicense();
			CarlicenseDao carlicenseDao = new CarlicenseDao();
			carLicense = carlicenseDao.getLicense(id);
			return carLicense;
		}
		else{
			return null;
		}
	}
	
	@GET
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public ArrayList<CarLicense> getAllLicense(@QueryParam("oauth_token") String tokenID){
		if (tokenID.equals(OfficerTokenID)){
			ArrayList<CarLicense> allLicense = new ArrayList<CarLicense>();
			CarlicenseDao carlicenseDao = new CarlicenseDao();
			allLicense = carlicenseDao.getAllLicense();
			return allLicense;
		}
		else{
			return null;
		}
	}
	
//	Only officer can update the expiry date
//	???Drivers can update their address in the beginning of the renewal
//	???Input format
	@PUT
	@Path("{LicenseID}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public CarLicense updateLicense(@PathParam("LicenseID") int id, @QueryParam("oauth_token") String tokenID, CarLicense alter){
		
		CarLicense updatedLicense = new CarLicense();
		CarlicenseDao carlicenseDao = new CarlicenseDao();
		if (tokenID.equals(DriverTokenID)){
			carlicenseDao.updateDriver(id, alter.getEmail(), alter.getAddress());
			updatedLicense = carlicenseDao.getLicense(id);
			return updatedLicense;
		}
		else if (tokenID.equals(OfficerTokenID)) {
			carlicenseDao.updateOfficer(id, alter.getExpiryDate());
			updatedLicense = carlicenseDao.getLicense(id);
			return updatedLicense;
		}
		return null;
	}
}
