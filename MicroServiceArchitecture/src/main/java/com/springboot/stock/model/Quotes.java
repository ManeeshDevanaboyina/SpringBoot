package com.springboot.stock.model;

import java.util.List;

//DTO Class ==>Data Transfer Object
public class Quotes {

	private String userName;
	private List<String> quotes;

	//Ramu "Airtel,SBI,ICICI,JIO,HDFC";

	/*
	 * QuotesJSON={
	 * 					username:"Ramu",
	 * 					quotes:"Airtel,SBI,ICICI,JIO,HDFC"
	 * 			  }
	 *
	 *
	 *1 ramu Airtel
	 *2 ramu SBI
	 *3 ramu ICICI
	 *4 ramu JIO
	 *5 ramu HDFC
	 */

	public Quotes() {
	}

	public Quotes(String userName, List<String> quotes) {
		this.userName = userName;
		this.quotes = quotes;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public List<String> getQuotes() {
		return quotes;
	}

	public void setQuotes(List<String> quotes) {
		this.quotes = quotes;
	}
}
