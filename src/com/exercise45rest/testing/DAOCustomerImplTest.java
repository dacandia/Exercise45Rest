package com.exercise45rest.testing;

import static org.junit.Assert.*;

import org.junit.Test;
import com.exercise45rest.services.DAOCustomerImpl;
import com.exercise45rest.model.Customer;

public class DAOCustomerImplTest {

	@Test
	public void testSaveCustomer() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testSaveCustomer2() {
		String nameCustomer = "";
		String addressCustomer = "";
		int ageCustomer = 12;
		double heightCustomer = 1.65;
		double weightCustomer = 55.5; 
		boolean isSingle = false;
		Customer customer = new Customer(1,nameCustomer, addressCustomer,ageCustomer,heightCustomer,weightCustomer,isSingle);
		//DAOCustomerImpl.SaveCustomer(customer);
	}

	@Test
	public void testUpdateCustomer() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeleteCustomer() {
		fail("Not yet implemented");
	}

	@Test
	public void testReadCustomer() {
		fail("Not yet implemented");
	}

	@Test
	public void testReadAllCustomer() {
		fail("Not yet implemented");
	}

}
