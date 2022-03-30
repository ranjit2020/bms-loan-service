package com.bms.loanservice;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.bms.loanservice.entity.LoanDetail;
import com.bms.loanservice.entity.LoanTypeMaster;
import com.bms.loanservice.repository.LoanDetailRepository;
import com.bms.loanservice.repository.LoanTypeRepository;

@SpringBootTest
class LoanServiceApplicationTests {

	@Autowired
	LoanDetailRepository loanDetailRepository;
	
	@Autowired
	LoanTypeRepository loanTypeRepository;
	
	@Test
	public void saveData() {
		LoanDetail loanDetail = new LoanDetail();
		loanDetail.setCustomerId(001);
		loanDetail.setIntrestRate(7.1);
		loanDetail.setLoanAmount(800000);
		loanDetail.setLoanDate(new Date());
		loanDetail.setLoanDuration(10);
		LoanTypeMaster loanTypeMaster = loanTypeRepository.findByLoanType("home");
		loanDetail.setLoanTypeMaster(loanTypeMaster);
		loanDetailRepository.save(loanDetail);
		
	}
	

}
