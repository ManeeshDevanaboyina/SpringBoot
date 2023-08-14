package com.springboot.stock.resource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.stock.model.Quote;
import com.springboot.stock.model.Quotes;
import com.springboot.stock.repository.QuotesRepository;

@RestController
@RequestMapping("/rest/db")
public class DbServiceResource {

	@Autowired
	private QuotesRepository quotesRepository;

	@GetMapping("/{username}")
	public List<String> getQuotes(@PathVariable("username") final String username) {

		return getQuotesByUserName(username);

	}
	private List<String> getQuotesByUserName(@PathVariable("username") String username){


				/*
				 * findByUserName ==>Output
				 * 	1 Ramu Airtel
					2 Ramu SBI
					3 Ramu ICICI
					4 Ramu JIO
					5 ramu HDFC



					Ramu Airtel,SBI,ICICI,JIO,HDFC


				 */
		return quotesRepository.findByUserName(username).
				stream().map(quote -> {
										return quote.getQuote(); //Airtel,SBI,ICICI,JIO,HDFC
									   }).

						collect(Collectors.toList());
	}

	@PostMapping("/add")
	public List<String> add(@RequestBody final Quotes quotes) {

		/*
		 *
		 * QuotesJSON={
	 				username:"Ramu",
	 * 					quotes:"Airtel,SBI,ICICI,JIO,HDFC"
	 * 			  }


		Quotes qutoes=new Quotes();

		List<String> quoteslist=new ArrayList<>();
				quoteslist.add("Airtel");
				quoteslist.add("SBI");
				quoteslist.add("ICICI");
				quoteslist.add("JIO");
				quoteslist.add("HDFC");

		qutoes.setUserName("Ramu");
		qutoes.setQuotes(quoteslist);
		return qutoes;

		1 Ramu Airtel
		2 Ramu SBI
		3 Ramu ICICI
		4 Ramu JIO
		5 ramu HDFC

		*/
		//Iterating over FE Object,Mapping Database Object and Saving Database Object
		quotes.getQuotes().stream() //Airtel  //SBI
		.map(quote -> new Quote(quotes.getUserName(), quote)) //(Ramu,Airtel) //(Ramu,SBI)
				.forEach(quote -> {
					quotesRepository.save(quote); //RAmu with Airtel  //Ramu with sbi
				});
		return getQuotesByUserName(quotes.getUserName());
		//return getQuotesByUserName(quotes.getUserName());
	}





    @PostMapping("/delete/{username}")
    public List<String> delete(@PathVariable("username") final String username) {

        List<Quote> quotes = quotesRepository.findByUserName(username);
        quotesRepository.deleteAll(quotes);

        return getQuotesByUserName(username);
    }


}
