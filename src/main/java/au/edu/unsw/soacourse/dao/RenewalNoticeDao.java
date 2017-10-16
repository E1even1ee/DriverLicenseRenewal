package au.edu.unsw.soacourse.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import au.edu.unsw.soacourse.DBConnector.DBConnectionFactory;
import au.edu.unsw.soacourse.DBConnector.ServiceLocatorException;
import au.edu.unsw.soacourse.model.RenewalNotice;

public class RenewalNoticeDao {
	
	/**
	 * The service locator to retrieve database connections from
	 */
	private DBConnectionFactory services;
	
	/** Creates a new instance of ContactDAOImpl */
	public RenewalNoticeDao() {
		try {
			services = new DBConnectionFactory();
		} catch (ServiceLocatorException e) {
			e.printStackTrace();
		}
	}

	public RenewalNoticeDao(DBConnectionFactory services) {
		this.services = services;
	}
	
	public int getCurrentID() {
		Connection con = null;
		int max = 0;
		try{
			con = services.createConnection();
			PreparedStatement stmt = con.prepareStatement("SELECT MAX(rn_id) AS MaxID FROM RENEWAL");
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
	
	public void createNewRenewal(RenewalNotice renewalNotice){
		Connection con = null;
		try{
			con = services.createConnection();
			PreparedStatement stmt = con.prepareStatement("INSERT INTO RENEWAL (rn_id, address, email, fee, status, issueDate, lastModified, lic_id, p_id)"
															+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)");
			stmt.setInt(1, renewalNotice.getId());
			stmt.setString(2, renewalNotice.getAddress());
			stmt.setString(3, renewalNotice.getEmail());
			stmt.setFloat(4, renewalNotice.getFee());
			stmt.setInt(5, renewalNotice.getStatus());
			stmt.setString(6, renewalNotice.getIssueDate());
			stmt.setString(7, renewalNotice.getLastModified());
			stmt.setInt(8, renewalNotice.getLicense().getId());
			stmt.setInt(9, renewalNotice.getPayment().getId());
			stmt.executeUpdate();
			stmt.close();
		    con.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
}
