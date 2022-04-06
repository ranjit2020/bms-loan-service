package com.bms.loanservice.service;

import com.bms.loanservice.entity.LoanDetail;
import com.bms.loanservice.entity.LoanTypeMaster;
import com.bms.loanservice.repository.LoanDetailRepository;
import com.bms.loanservice.service.impl.LoanServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;


import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;

@RunWith(MockitoJUnitRunner.class)
public class LoanServiceTest {

    @InjectMocks
    LoanServiceImpl loanService;

    @Mock
    LoanDetailRepository dao;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testLoanServiceFindByIdAndCreatedBy() throws Exception{
        LoanTypeMaster loanTypeMaster = new LoanTypeMaster(1,"PL");
        LoanDetail LOAN_DETAIL2 = new LoanDetail(2L,1L,loanTypeMaster,102.34,new Date(),1.2,2);

        given(dao.findByLoanIdAndCustomerId(2L,1L)).willReturn(Arrays.asList(LOAN_DETAIL2));
        List<LoanDetail> loanDetailsData = loanService.getLoans(2L,1,10,"id","desc","1");
        assertEquals(1,loanDetailsData.size());
    }


    @Test
    public void testLoanIdNotExistAndCreatedBy() throws Exception{

        LoanTypeMaster loanTypeMaster = new LoanTypeMaster(1,"PL");
        LoanDetail LOAN_DETAIL2 = new LoanDetail(2L,1L,loanTypeMaster,102.34,new Date(),1.2,2);


        given(dao.findByLoanIdAndCustomerId(1L,null)).willReturn(Arrays.asList(LOAN_DETAIL2));

        List<LoanDetail> loanDetailsData = loanService.getLoans(2L,1,10,"id","desc","1");

        assertEquals(0,loanDetailsData.size());

    }

}
