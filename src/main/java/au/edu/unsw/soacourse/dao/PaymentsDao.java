package au.edu.unsw.soacourse.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import au.edu.unsw.soacourse.DBConnector.DBConnectionFactory;
import au.edu.unsw.soacourse.DBConnector.ServiceLocatorException;
import au.edu.unsw.soacourse.model.CarLicense;
import au.edu.unsw.soacourse.model.Payments;
import au.edu.unsw.soacourse.model.RenewalNotice;

public class PaymentsDao {
	
	/**
	 * The service locator to retrieve database connections from
	 */
	private DBConnectionFactory services;
	
	/** Creates a new instance of ContactDAOImpl */
	public PaymentsDao() {
		try {
			services = new DBConnectionFactory();
		} catch (ServiceLocatorException e) {
			e.printStackTrace();
		}
	}

	public PaymentsDao(DBConnectionFactory services) {
		this.services = services;
	}
	
	public int getCurrentID() {
		Connection con = null;
		int max = 0;
		try{
			con = services.createConnection();
			PreparedStatement stmt = con.prepareStatement("SELECT MAX(p_id) AS MaxID FROM PAYMENT");
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
	
	public void createPayment(Payments payment){
		Connection con = null;
		try{
			con = services.createConnection();
			PreparedStatement stmt = con.prepareStatement("INSERT INTO RENEWAL (p_id, amount, paidDate, rn_id)"
															+ "VALUES (?, ?, ?, ?)");
			stmt.setInt(1, payment.getId());
			stmt.setFloat(2, payment.getAmount());
			stmt.setString(3, payment.getPaidDate());
			stmt.setInt(4, payment.getRenewalNoticeLink().getId());
			stmt.executeUpdate();
			stmt.close();
		    con.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
}
