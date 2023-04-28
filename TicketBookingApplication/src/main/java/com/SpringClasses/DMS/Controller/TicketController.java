package com.SpringClasses.DMS.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.SpringClasses.DMS.DatabaseLayer.Ticket;
import com.SpringClasses.DMS.ServiceLayer.TicketService;

@RestController
@RequestMapping(value="/tickets") //http://localhost:8080/tickets

//http://localhost:8080/tickets ==> TicketController obj=ioc.getTicketController();
public class TicketController {


	/*
	 *   JAXRS ==> JAVA API FOR REST SERVICES==> REST CALL
	 *
	 *   REST CALL ==> PART OF WEBSERVVICE ==> HETEROGENIOUS COMMMUNCATIONS
	 *
	 *   OPERATIONS
	 *        GET ==> @Get ==> To get the data
	 *        CREATE ==> @Post   ==> To insert the data
	 *        UPDATE ==> @Put    ==> To Update the data
	 *        DELETE ==> @Delete ==> To Delete the data
	 *
	 *
	 *  @Get + @RequestMapping  ==> @GetMapping
	 *  @Post+@RequestMapping ==> @PostMapping
	 *  @Put+@RequestMapping ==> @PutMapping
	 *  @Delete + @RequestMapping ==> @DeleteMapping
	 *
	 *  As per REST Protocol input and output should be in the JSON format
	 *
	 *  JSON ==> Java Script Object Notation
	 *      {
	 *      	passengerName:"vijay",
	 *      	sourceStation:"Hyderabad",
	 *         ....
	 *         ...
	 *
	 *
	 *      }
	 *
	 * Spring boot internally has JACKSON Library which will convert JAVA TO JSON AND JSON TO JAVA
	 *
	 */


	@Autowired
	private TicketService ticketService;

	//getAllTickets

	@GetMapping(value="/all")  //http://localhost:8080/tickets/all
	 //http://localhost:8080/tickets/all ==>obj.getAllTickets();
    public Iterable<Ticket> getAllTickets(){
		return ticketService.getAllTickets();

	}





	//CreateTicket

	@PostMapping(value="/create") //http://localhost:8080/tickets/create
	//http://localhost:8080/tickets/create ==> obj.createTicket(ticketObj);
	//@RequestBody ==> it will scan body section of the rest request and convert to JAVA
	public Ticket createTicket(@RequestBody Ticket ticketObj) {
		return ticketService.createTicket(ticketObj);
	}

	//getTicket

	//http://localhost:8080/tickets/1 ==> 1st Ticket
	//http://localhost:8080/tickets/20 ==> 20th Ticket
	//{ } inside value ==> Dynamic Value
	//@PathVariable==> Read the variable in the path and assigns to Java datatype
	@GetMapping(value="/{ticketId}")
	public Ticket getTicket(@PathVariable("ticketId") Integer ticketId) {
		return ticketService.getTicket(ticketId);
	}


	//UpdateTicket
	//http://localhost:8080/tickets/1/a@b.com ==> update tbl_ticket set email='a@b.com' where ticket_id=1
	@PutMapping(value="/{ticketId}/{trainName}")
	public Ticket updateTicket(@PathVariable("ticketId") Integer ticketId,
								@PathVariable("trainName") String trainName) {
		return ticketService.updateTicket(ticketId, trainName);
	}




	//deleteTicket
	//http://localhost:8080/tickets/1 ==> delete Ticket with id=1
	@DeleteMapping(value="/{ticketId}")
	public void deleteTicket(@PathVariable("ticketId") Integer ticketId) {
		ticketService.deleteTicket(ticketId);
	}


	}
	
	
	
	
			
