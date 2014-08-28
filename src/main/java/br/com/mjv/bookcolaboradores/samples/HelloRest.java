package br.com.mjv.bookcolaboradores.samples;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Path("/hello")
public class HelloRest {

	@Autowired
	SampleService service;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{param}")
	public String helloWorld(@PathParam("param") String name) {
		String response = "Hello from: " + name ;
		System.out.println("hello");
		return response;
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/mycar/{carName}/{carYear}")
	public Car myCar(@PathParam("carName") String carName, @PathParam("carYear") Integer carYear) {
		System.out.println("chama serviço::"+service.chamaServico());
		return new Car(carName, carYear);
	}

	
}
