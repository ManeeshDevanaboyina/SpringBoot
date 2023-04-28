package com.SpringClasses.DMS.DatabaseLayer;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity //This annotation is going to create table to the database with table name as Ticket(ClassName)
@Table(name = "tbl_ticket")
// This is an optional entity. If we want to create table with name as "tbl_ticket"
public class Ticket {



	/*
	 *   JPA WITH TABLE MAPPING
	 * ------------------------------------------------------------
	 *
	 *       tbl_ticket                      Ticket
	 *
	 *
	 *       ticket_id						ticketId
	 *       passenger_name					passengerName
	 *       source_station					sourceStation
	 *       .....
	 *       ....
	 *
	 * ------------------------------------------------------------
	 */
	//AUTO ==> JPA will create database sequence and will populate to primar key
	//We need ticket_id as Primay Key
	@Id //This is going to create primary key for ticket_id column
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="ticket_id")
	private Integer ticketId;

	//By default property Name will be column name
	@Column(name = "passenger_name") //This will rename the column name to passenger_name
	private String passengerName;


	@Column(name="source_station")
	private String sourceStation;

	@Column(name="destination_station")
	private String DestinationStation;

	@Column(name="travel_date")
	private Date travelDate;


	private String email;


	public Integer getTicketId() {
		return ticketId;
	}


	public void setTicketId(Integer ticketId) {
		this.ticketId = ticketId;
	}


	public String getPassengerName() {
		return passengerName;
	}


	public void setPassengerName(String passengerName) {
		this.passengerName = passengerName;
	}


	public String getSourceStation() {
		return sourceStation;
	}


	public void setSourceStation(String sourceStation) {
		this.sourceStation = sourceStation;
	}


	public String getDestinationStation() {
		return DestinationStation;
	}


	public void setDestinationStation(String destinationStation) {
		DestinationStation = destinationStation;
	}


	public Date getTravelDate() {
		return travelDate;
	}


	public void setTravelDate(Date travelDate) {
		this.travelDate = travelDate;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public Ticket(String passengerName, String sourceStation, String destinationStation, Date travelDate,
			String email) {
		super();
		this.passengerName = passengerName;
		this.sourceStation = sourceStation;
		DestinationStation = destinationStation;
		this.travelDate = travelDate;
		this.email = email;
	}


	public Ticket() {}


	@Override
	public String toString() {
		return "Ticket [ticketId=" + ticketId + ", passengerName=" + passengerName + ", sourceStation=" + sourceStation
				+ ", DestinationStation=" + DestinationStation + ", travelDate=" + travelDate + ", email=" + email
				+ "]";
	}




	

}
