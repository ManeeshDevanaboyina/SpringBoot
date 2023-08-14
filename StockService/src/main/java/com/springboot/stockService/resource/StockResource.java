package com.springboot.stockService.resource;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import yahoofinance.Stock;
import yahoofinance.YahooFinance;
import yahoofinance.quotes.stock.StockQuote;

@RestController
@RequestMapping("/rest/stock")
public class StockResource {


    @Autowired
    RestTemplate restTemplate;


    YahooFinance yahooFinance;

    public StockResource() {
    	this.yahooFinance=new YahooFinance();
    }


	 @GetMapping("/{userName}")
	    public List<Quote> getStock(@PathVariable("userName")
	    final String userName) {


		 /*
		  * 		1 Ramu Airtel
					2 Ramu SBI
					3 Ramu ICICI        ===> DB Data
					4 Ramu JIO
					5 ramu HDFC

			Ramu "Airtel,SBI,ICICI,JIO,HDFC" ==> Maintanence Service Output

			Airtel:300$, SBI: 400$, ICICI:500$, JIO: 600$, HDFC:800$ ==> Stock Service Output


		  */

		 //The following line willl retrieve the data from Maintanence Service
		 ///http://db-service/rest/db/{userName}====>


		 //http://localhost:8300/rest/db/{userName}


		 //localhost:8300 -> db-service


		 ResponseEntity<List<String>> quoteResponse=restTemplate.
				 exchange("http://db-service/rest/db/"+userName,
				 HttpMethod.GET,
				 null,
				 new ParameterizedTypeReference<List<String>>() {
         });




		List<String> quotes=quoteResponse.getBody();


		//http://stockservice/rest/stock/ramu ---> Output
		//Ramu "Airtel,SBI,ICICI,JIO,HDFC" ==> Maintanence Service Output

				//Airtel:300$, SBI: 400$, ICICI:500$, JIO: 600$, HDFC:800$ ==> Stock Service Output

				//step1 ==> http://dbservices/rest/db/ramu==>//Ramu -> Airtel, SBI,ICICI,JIO,HDFC
			//We need to get the output as follows


		//Ramu -> stock1, stock2,stock3
		//Airtel - 300$
		//SBI-400$
		//ICICI-500$
		//JIO-600$
		//HDFC-800$

//The following line get the latest price for each and every stock

//Once the URL http://download.finance.yahoo.com/d/quotes.csv-> Is up and
//need to change getStockPrice_internal with getStockPrice_Yahoo.
	    return quotes
                .stream()
                .map(quote -> {   //Airtel,SBI
                	//Stock stock=getStockPrice_yahoo(quote);
                	Stock stock=getStockPrice_internal(quote); //stock1
                return new Quote(quote,stock.getCurrency());
                //(Airtel, 300$) //(SBI,400$) //(ICICI,500$),//(JIO,600$)//(HDFC,800$)
                })
                .collect(Collectors.toList());



	 }

	 private class Quote{
		 private String quote;

		private String price;
		 public Quote(String quote,String price)
		 {
			 this.quote=quote;
			 this.price=price;
		 }
		 public String getQuote() {
				return quote;
			}
			public void setQuote(String quote) {
				this.quote = quote;
			}
			public String getPrice() {
				return price;
			}
			public void setPrice(String price) {
				this.price = price;
			}

	 }


	 private Stock getStockPrice_yahoo(String quote) {
	        try {
	            return YahooFinance.get(quote);
	        } catch (IOException e) {
	            e.printStackTrace();
	            return new Stock(quote);
	        }
	    }


	 private Stock getStockPrice_internal(String quote)
	 {
		 //return	YahooFinance.get(quote);
		 if(quote.equalsIgnoreCase("GOOG"))
		 {
			 Stock stock=new Stock(quote);
			 stock.setCurrency("100$");
			 return stock;
		 } else if(quote.equalsIgnoreCase("RIL"))
		 {
			 Stock stock=new Stock(quote);

			 stock.setCurrency("200$");
			 return stock;
		 }else if(quote.equalsIgnoreCase("AIRTEL"))
		 {
			 Stock stock=new Stock(quote);

			 stock.setCurrency("300$");
			 return stock;
		 }else if(quote.equalsIgnoreCase("JIO"))
		 {
			 Stock stock=new Stock(quote);

			 stock.setCurrency("400$");
			 return stock;
		 }if(quote.equalsIgnoreCase("SUZ"))
		 {
			 Stock stock=new Stock(quote);

			 stock.setCurrency("10$");
			 return stock;
		 }
		 if(quote.equalsIgnoreCase("SBI"))
		 {
			 Stock stock=new Stock(quote);

			 stock.setCurrency("20$");
			 return stock;
		 }

		 if(quote.equalsIgnoreCase("YESBANK"))
		 {
			 Stock stock=new Stock(quote);

			 stock.setCurrency("10$");
			 return stock;
		 }

		 if(quote.equalsIgnoreCase("RLAB"))
		 {
			 Stock stock=new Stock(quote);

			 stock.setCurrency("1000$");
			 return stock;
		 }


		 else
			 {
			 Stock stock=new Stock("NA");

			 stock.setCurrency("0$");
			 return stock;
			 }
	 }
}
