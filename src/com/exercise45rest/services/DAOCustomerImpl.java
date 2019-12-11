package com.exercise45rest.services;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.GET;
import javax.ws.rs.DELETE;
import javax.ws.rs.Consumes;
import javax.ws.rs.QueryParam;
import com.exercise45rest.model.Customer;

@Path("/Customer")
public class DAOCustomerImpl implements DAOCostumer {
	
	Connection connection = null;
	PreparedStatement pstmnt = null;
	ResultSet resultSet = null;
	InputStream input = null;
	Properties properties = new Properties();
	String sqlSentence = "";
	
	public Connection getConnection() {
		Connection connection;
		connection = ConnectionFactory.getInstance().getConnection();
		return connection;
	}
	
	@Override
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void SaveCustomer(Customer customer) {
		sqlSentence = "INSERT INTO CUSTOMERS(NAME_CUSTOMER, ADDRESS_CUSTOMER,"
				+ " AGE_CUSTOMER, HEIGHT_CUSTOMER, WEIGHT_CUSTOMER, IS_SINGLE) "
				+ "VALUES(?,?,?,?,?,?)";
		connection = getConnection();
		try {
			pstmnt = connection.prepareStatement(sqlSentence);
			pstmnt.setString(1, customer.getNameCustomer());
			pstmnt.setString(2, customer.getAddressCustomer());
			pstmnt.setInt(3,customer.getAgeCustomer());
			pstmnt.setDouble(4, customer.getHeightCustomer());
			pstmnt.setDouble(5, customer.getWeightCustomer());
			pstmnt.setBoolean(6, customer.getIsSingle());
			pstmnt.executeUpdate();
			System.out.println("Record added to DataBase");
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				pstmnt.close();
				connection.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
	}

	@Override
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public boolean UpdateCustomer(Customer customer) {
		sqlSentence = "UPDATE CUSTOMERS SET name_customer = ?, address_customer = ?, age_customer = ?,"
				+ "height_customer = ?, weight_customer = ?, is_single = ? WHERE id_customer = ?";
		connection = getConnection();
		boolean isUpdated = false;
		
		try {
			pstmnt = connection.prepareStatement(sqlSentence);
			pstmnt.setString(1, customer.getNameCustomer());
			pstmnt.setString(2, customer.getAddressCustomer());
			pstmnt.setInt(3, customer.getAgeCustomer());
			pstmnt.setDouble(4, customer.getHeightCustomer());
			pstmnt.setDouble(5, customer.getWeightCustomer());
			pstmnt.setBoolean(6, customer.getIsSingle());
			pstmnt.setInt(7, customer.getIdCustomer());
			pstmnt.executeUpdate();
			isUpdated = true;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return isUpdated;
	}

	@Override
	@DELETE
	public boolean DeleteCustomer(@QueryParam("idCustomer") int  idCustomer) {
		sqlSentence = "DELETE FROM CUSTOMERS WHERE id_customer="+idCustomer;
		connection = getConnection();
		boolean isDeleted = false;
		try {
			pstmnt = connection.prepareStatement(sqlSentence);
			pstmnt.executeUpdate();
			isDeleted = true;
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				pstmnt.close();
				connection.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return isDeleted;
	}

	@Override
	@GET
	public Customer ReadCustomer(@QueryParam("idCustomer") int idCustomer) {
		sqlSentence = "SELECT * FROM CUSTOMERS WHERE id_customer="+idCustomer;
		connection = getConnection();
		Customer customer = null;
		try {
			pstmnt = connection.prepareStatement(sqlSentence);
			resultSet = pstmnt.executeQuery();
			resultSet.next();
			customer = new Customer();
			customer.setIdCustomer(resultSet.getInt(1));
			customer.setNameCustomer(resultSet.getString(2));
			customer.setAddressCustomer(resultSet.getString(3));
			customer.setAgeCustomer(resultSet.getInt(4));
			customer.setHeightCustomer(resultSet.getDouble(5));
			customer.setWeightCustomer(resultSet.getDouble(6));
			customer.setIsSingle(resultSet.getBoolean(7));
			System.out.println("Selection");
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				resultSet.close();
				pstmnt.close();
				connection.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}

		}
		return customer;
	}

	@Override
	@GET
	@Path("/ReadAll")
	public ArrayList<Customer> ReadAllCustomer() {
		sqlSentence = "SELECT * FROM CUSTOMERS";
		connection = getConnection();
		ArrayList<Customer> listCustomers = null;
		try {
			pstmnt = connection.prepareStatement(sqlSentence);
			resultSet = pstmnt.executeQuery();
			listCustomers = new ArrayList<>();
			while(resultSet.next()) {
				Customer customer = new Customer();
				customer.setIdCustomer(resultSet.getInt(1));
				customer.setNameCustomer(resultSet.getString(2));
				customer.setAddressCustomer(resultSet.getString(3));
				customer.setAgeCustomer(resultSet.getInt(4));
				customer.setHeightCustomer(resultSet.getDouble(5));
				customer.setWeightCustomer(resultSet.getDouble(6));
				customer.setIsSingle(resultSet.getBoolean(7));
				
				listCustomers.add(customer);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally {
			try {
				resultSet.close();
				pstmnt.close();
				resultSet.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
		return listCustomers;
	}

}
