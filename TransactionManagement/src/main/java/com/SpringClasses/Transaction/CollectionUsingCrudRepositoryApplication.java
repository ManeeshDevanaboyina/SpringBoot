package com.SpringClasses.Transaction;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.SpringClasses.DMS.ServiceLayer.OrganizationalLayer;
import com.SpringClasses.Transaction.model.Person;
import com.SpringClasses.Transaction.model.Insurance;

@SpringBootApplication
public class CollectionUsingCrudRepositoryApplication implements CommandLineRunner{ 

	
	@Autowired
	private OrganizationalLayer OrganizationService;
	
	public static void main(String[] args) {
		SpringApplication.run(CollectionUsingCrudRepositoryApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub

			Person p1=new Person("Maneesh","Devana");
			
			Insurance emp=new Insurance();
			
			emp.setInsuranceName("Test");
			emp.setInsuranceAmount(100000);
			
			OrganizationService.onBoardEmployee(p1, emp);
			
			
			
	
	}
}