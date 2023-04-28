package com.SpringClasses.DMS.ServiceLayer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SpringClasses.DMS.DAOLayer.TicketDAO;
import com.SpringClasses.DMS.DatabaseLayer.Ticket;



@Service
public class TicketService {
	

	// In Service Layer we will write our business logic
	// Sending the data to the database

//TicketDao ticketDao=new TicketDao();

	@Autowired
	private TicketDAO ticketDao; // TicketDao ticketDao=new TicketDao();

	// Retrive All Tickets

	public Iterable<Ticket> getAllTickets() {

		return ticketDao.findAll();

		// findAll ==> select * from tbl_ticket;
		// JPA WILL take care of transforming ResultSet into Java Object
	}

	// Retrive Single Ticket

	public Ticket getTicket(Integer ticketId) {
		return ticketDao.findById(ticketId).orElse(new Ticket());

		// findById ==> select * from tbl_ticket where ticket_id=ticketId

	}

	// Create Ticket
	public Ticket createTicket(Ticket ticketObj) {

		// Ticket tickObj=new Ticket();
		/*
		 *
		 * ticketObj.setPaseengerName("viay"); .......
		 *
		 */
		return ticketDao.save(ticketObj);
		// save ==> Insert the record or update the record

		// case1 ==> If ticketObj.getTicketId === null > Insert the record
		// case2 ==> If ticketObj.getTicketId != null but not there in database ==>
		// Insert the record
		// case3 ==> If ticketObj.getTicketId != null and its there in database ==>
		// Update the record

	}

	// Delete Ticket

	public void deleteTicket(Integer ticketId) {
		ticketDao.deleteById(ticketId);
		// deleteById ==> delete from tbl_ticket where ticket_id=ticketId

	}

	// Update Ticket
	public Ticket updateTicket(Integer ticketId, String Email) {

		Ticket dbTicketObj = getTicket(ticketId);
		dbTicketObj.setEmail(Email);
		return ticketDao.save(dbTicketObj);
		//save ==> update tbl_ticket set email=newEmail where ticket_id=ticketId;

	}

	

}
