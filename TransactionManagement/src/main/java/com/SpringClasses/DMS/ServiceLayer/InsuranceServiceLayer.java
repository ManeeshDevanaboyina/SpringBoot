package com.SpringClasses.DMS.ServiceLayer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SpringClasses.Transaction.DAO.InsuranceDao;

import com.SpringClasses.Transaction.model.Insurance;


@Service
public class InsuranceServiceLayer {

	@Autowired
	private InsuranceDao insuranceDao;
	

	
	public Insurance createInsurance(Insurance insurance){
		return insuranceDao.save(insurance);
	}
	
	
	
	
	
}
