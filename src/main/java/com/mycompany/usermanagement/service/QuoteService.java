package com.mycompany.usermanagement.service;

import com.mycompany.usermanagement.domain.Quote;

public class QuoteService {
	
	public Quote getQuote(){
		Quote q = new Quote();
		q.setType("eloelo");
		return q ;
		
	}

}
