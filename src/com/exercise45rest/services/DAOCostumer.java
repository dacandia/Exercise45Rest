package com.exercise45rest.services;

import com.exercise45rest.model.Customer;
import java.util.ArrayList;

public interface DAOCostumer {
	public void SaveCustomer(Customer customer);
	public boolean UpdateCustomer(Customer customer);
	public boolean DeleteCustomer(int idCustomer);
	public Customer ReadCustomer(int idCustomer);
	public ArrayList<Customer> ReadAllCustomer();
}
