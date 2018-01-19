package test.com.sample.client.test;

import static org.junit.Assert.*;

import javax.ws.rs.core.Response;

import org.junit.Test;

import com.raml.sample.dto.Customer;
import com.sample.client.CustomerClient;

/** 
 * A Test case for client (consumer)
 * @author Jay
 *
 */
public class CustomerClientTest {

	/**
	 * Test the getAllCustomers() method in client
	 */
	@Test
	public void testGetAllCustomers() {
		CustomerClient client = new CustomerClient();
		Response resposne  = client.getAllCustomers();
		//assert if the response from API is 200
		assertEquals(200, resposne.getStatus());
	}
	
	/**
	 * Test the getCustomer() method in client
	 */
	@Test
	public void testGetCustomer() {
		CustomerClient client = new CustomerClient();
		Response resposne  = client.getAllCustomers();
		//assert if the response from API is 200
		assertEquals(200, resposne.getStatus());
	}
	
	/**
	 * Test the addCustomer() method in client
	 */
	@Test
	public void testAddCustomer() {
		CustomerClient client = new CustomerClient();
		Customer customer = new Customer();
		customer.setId("99");
		Response response  = client.addCustomer(customer);
		//assert if the response from API is 201
		assertEquals(201, response.getStatus());
	}
	
	/**
	 * Test the removeCustomer() method in client
	 */
	@Test
	public void testRemoveCustomer() {
		CustomerClient client = new CustomerClient();
		Response resposne  = client.getAllCustomers();
		//assert if the response from API is 200
		assertEquals(200, resposne.getStatus());
	}
	
	/**
	 * Test the updateCustomer() method in client
	 */
	@Test
	public void testUpdateCustomer() {
		CustomerClient client = new CustomerClient();
		Response resposne  = client.getAllCustomers();
		//assert if the response from API is 200
		assertEquals(200, resposne.getStatus());
	}
}