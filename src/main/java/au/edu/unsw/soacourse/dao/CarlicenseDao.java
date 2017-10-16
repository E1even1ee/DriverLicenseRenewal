package au.edu.unsw.soacourse.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import au.edu.unsw.soacourse.DBConnector.DBConnectionFactory;
import au.edu.unsw.soacourse.DBConnector.ServiceLocatorException;
import au.edu.unsw.soacourse.model.CarLicense;;

public class CarlicenseDao {
	
	/**
	 * The service locator to retrieve database connections from
	 */
	private DBConnectionFactory services;
	
	/** Creates a new instance of ContactDAOImpl */
	public CarlicenseDao() {
		try {
			services = new DBConnectionFactory();
		} catch (ServiceLocatorException e) {
			e.printStackTrace();
		}
	}

	public CarlicenseDao(DBConnectionFactory services) {
		this.services = services;
	}
	
	
	public ArrayList<CarLicense> getAllLicense() {
		
		ArrayList<CarLicense> allLicense = new ArrayList<CarLicense>();
		Connection con = null;
		
		try{
			con = services.createConnection();
			PreparedStatement stmt = con.prepareStatement("SELECT * FROM LICENSE");
			ResultSet result = stmt.executeQuery();
			while(result.next()){
				CarLicense carlicense = new CarLicense();
				carlicense.setId(result.getInt("lic_id"));
				carlicense.setDriverName(result.getString("driverName"));
				carlicense.setAddress(result.getString("address"));
				carlicense.setLicenseNumber(result.getString("licenseNumber"));
				carlicense.setLicenseClass(result.getString("licenseClass"));
				carlicense.setEmail(result.getString("email"));
				carlicense.setExpiryDate(result.getString("expiryDate"));
				allLicense.add(carlicense);
			}
			stmt.close();
		    result.close();
		    con.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		return allLicense;
	}
	
	public CarLicense getLicense(int id) {
		CarLicense carlicense = new CarLicense();
		Connection con = null;
		try{
			con = services.createConnection();
			PreparedStatement stmt = con.prepareStatement("SELECT * FROM LICENSE WHERE lic_id = ?");
			stmt.setInt(1, id);
			ResultSet result = stmt.executeQuery();
			result.next();
			carlicense.setId(result.getInt("lic_id"));
			carlicense.setDriverName(result.getString("driverName"));
			carlicense.setAddress(result.getString("address"));
			carlicense.setLicenseNumber(result.getString("licenseNumber"));
			carlicense.setLicenseClass(result.getString("licenseClass"));
			carlicense.setEmail(result.getString("email"));
			carlicense.setExpiryDate(result.getString("expiryDate"));
			stmt.close();
		    result.close();
		    con.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	    return carlicense;
	}
	
	public void updateDriver(int id, String email, String address) {
		Connection con = null;
		try{
			con = services.createConnection();
			PreparedStatement stmt = con.prepareStatement("UPDATE LICENSE SET email = ?, address= ? WHERE lic_id = ?");
			stmt.setString(1, email);
			stmt.setString(2, address);
			stmt.setInt(3, id);
			stmt.executeUpdate();
			stmt.close();
		    con.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void updateOfficer(int id, String expirydate) {
		Connection con = null;
		try{
			con = services.createConnection();
			PreparedStatement stmt = con.prepareStatement("UPDATE LICENSE SET expiryDate = ? WHERE lic_id = ?");
			stmt.setString(1, expirydate);
			stmt.setInt(2, id);
			stmt.executeUpdate();
			stmt.close();
		    con.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public int getCurrentID() {
		Connection con = null;
		int max = 0;
		try{
			con = services.createConnection();
			PreparedStatement stmt = con.prepareStatement("SELECT MAX(lic_id) AS MaxID FROM LICENSE");
			ResultSet result = stmt.executeQuery();
			max = result.getInt("MaxID");
			stmt.close();
		    con.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return max + 1;
	}
}
