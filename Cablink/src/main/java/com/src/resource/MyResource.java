package com.src.resource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.src.model.Passenger;
import com.src.model.PermDriver;
import com.src.model.TempDriver;
import com.src.services.PassengerServiceInterface;
import com.src.services.PassengerServices;
import com.src.services.PermDriverServices;
import com.src.services.PermDriverServicesInterface;
import com.src.services.TempDriverServices;
import com.src.services.TempDriverServicesInterface;

@Path("/myresource")
public class MyResource {
    
    /** Method processing HTTP GET requests, producing "text/plain" MIME media
     * type.
     * @return String that will be send back as a response of type "text/plain".
     */
	PassengerServiceInterface psi = new PassengerServices();
	TempDriverServicesInterface tsi = new TempDriverServices();
	PermDriverServicesInterface pdsi = new PermDriverServices();
    @GET 
    @Produces("text/plain")
    @Path("/hi")
    public String getIt() {
        return "Hi there!";
    }
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/passengers")
    public  List<Passenger> getAllPassengers(){
    	return psi.getAllDetails();
    }
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/passenger/{name}/{pwd}")
    public  Passenger getPassenger(@PathParam("name") String name,@PathParam("pwd") String pwd){
    	return psi.getDetails(name, pwd);
    }
    @DELETE
    @Produces("text/plain")
    @Path("/deletepassenger/{id}")
    public String deletePassenger(@PathParam("id") String id){
    	Passenger s = new Passenger(id);
    	if(psi.deleteDetails(s))
    		return "Deleted";
    	else
    		return "Unable";
    }
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/addpassenger")
    public String addPassenger(Passenger s){
    	
    	
    	return psi.addDetails(s)?"Added":"Unable to add";
    }
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/tdrivers")
    public  List<TempDriver> getAllTdriver(){
    	return tsi.getAllDetails();
    }
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/tdriver/{name}/{pwd}")
    public  TempDriver getTdriver(@PathParam("name") String name,@PathParam("pwd") String pwd){
    	return tsi.getDetails(name, pwd);
    }
    @DELETE
    @Produces("text/plain")
    @Path("/deletetdriver/{id}")
    public String delete(@PathParam("id") String id){
    	TempDriver s = new TempDriver(id);
    	if(tsi.deleteDetails(s))
    		return "Deleted";
    	else
    		return "Unable";
    }
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/addtdriver")
    public String add(TempDriver s){
    	
    	
    	return tsi.addDetails(s)?"Added":"Unable to add";
    }
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/pdrivers")
    public  List<PermDriver> getAllPdrivers(){
    	return pdsi.getAllDetails();
    }
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/pdriver/{name}/{pwd}")
    public  PermDriver getPdriver(@PathParam("name") String name,@PathParam("pwd") String pwd){
    	return pdsi.getDetails(name, pwd);
    }
    @DELETE
    @Produces("text/plain")
    @Path("/deletepdriver/{id}")
    public String deletePdriver(@PathParam("id") String id){
    	PermDriver s = new PermDriver(id);
    	if(pdsi.deleteDetails(s))
    		return "Deleted";
    	else
    		return "Unable";
    }
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/addpdriver")
    public String add(PermDriver s){
    	
    	
    	return pdsi.addDetails(s)?"Added":"Unable to add";
    }
   
}
    
    