package com.SpringClasses.DMS.DAOLayer;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.SpringClasses.DMS.DatabaseLayer.Ticket;

@Repository
public interface TicketDAO extends CrudRepository<Ticket,Integer>  {

}
