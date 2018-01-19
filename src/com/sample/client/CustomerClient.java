package com.sample.client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;
import org.glassfish.jersey.client.ClientConfig;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.raml.sample.dto.Customer;

/**
 * The client(consumer) class that calls the server (producer) methods
 * @author Jay
 *
 */
public class CustomerClient {
 
	 Logger log = Logger.getLogger(CustomerClient.class);
	 //This has to be declared in a property file.
	 final String baseURL = "http://localhost:8081/services/customers";
	 
	 /**
	  * Find all customers
	  * @return
	  */
	 public Response getAllCustomers(){
		  ClientConfig config = new ClientConfig();
		  Client client = ClientBuilder.newClient( config );
		  WebTarget webTarget = client
					.target(baseURL);
		  Builder request = webTarget
				  				.request();
		  request.header("Content-type", MediaType.APPLICATION_JSON);
	
		  Response response = request.get();
		  log.info(response.getStatus());
		  return response;
	 }
	 
	 /**
	  * Find a customer
	  * @param id - customer id
	  * @return
	  */
	 public Response getCustomer(String id){
		  ClientConfig config = new ClientConfig();
		  Client client = ClientBuilder.newClient( config );
		  WebTarget webTarget = client
					.target(baseURL);
		  Builder request = webTarget
				  				.path(id)
				  				.request();
		  request.header("Content-type", MediaType.APPLICATION_JSON);
	
		  Response response = request.get();
		  log.info(response.getStatus());
		  return response;
	 }
	/**
	 * add a customer
	 * @param customer - The customer entity to add
	 * @return
	 */
	public Response addCustomer(Customer customer) {
		  ClientConfig config = new ClientConfig();
		  Client client = ClientBuilder.newClient( config );
		  WebTarget webTarget = client
					.target(baseURL);
		  Builder request = webTarget
				  				.request();
	
		  Gson jsonConverter = new GsonBuilder().create();
		  Response response = request.post(Entity.entity
				  							(jsonConverter.toJson(customer)
				  									, MediaType.APPLICATION_JSON),Response.class);
		  log.info(response.getStatus());
		  return response;
	}
	
	/**
	 * update a customer
	 * @param id - customer id
	 * @param customer - The customer entity to update
	 * @return
	 */
	 public Response updateCustomer(String id,Customer customer){
		  ClientConfig config = new ClientConfig();
		  Client client = ClientBuilder.newClient( config );
		  WebTarget webTarget = client
					.target(baseURL);
		  Builder request = webTarget
				  				.path(id)
				  				.request();
		  Gson jsonConverter = new GsonBuilder().create();
		  Response response = request.put(Entity.entity
				  							(jsonConverter.toJson(customer)
				  									, MediaType.APPLICATION_JSON),Response.class);
		  log.info(response.getStatus());
	 	  return response;
	 }
	 /**
	  * delete a customer
	  * @param id - Customer id
	  * @return
	  */
	 public Response removeCustomer(String id){
		  ClientConfig config = new ClientConfig();
		  Client client = ClientBuilder.newClient( config );
		  WebTarget webTarget = client
					.target(baseURL);
		  Builder request = webTarget
				  				.path(id)
				  				.request();
		  Response response = request.delete();
		  log.info(response.getStatus());
	 	  return response;
	 }
}