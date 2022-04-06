package com.bms.loanservice.service.impl;

import com.bms.loanservice.entity.LoanDetail;
import com.bms.loanservice.entity.LoanTypeMaster;
import com.bms.loanservice.repository.LoanDetailRepository;
import com.bms.loanservice.repository.LoanTypeRepository;
import com.bms.loanservice.service.LoanService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;


import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Component
public class LoanServiceImpl implements LoanService {


    @Autowired
    private  LoanDetailRepository loanDetailRepository;

    @Autowired
    private  LoanTypeRepository loanTypeRepository;

    public LoanServiceImpl() {
        super();
    }


//    @PostConstruct
//    @Profile("test")
//    public void postConstruct(){
//        LoanTypeMaster loanTypeMaster = new LoanTypeMaster(1,"PL");
//
//        loanTypeRepository.save(loanTypeMaster);
//        LoanDetail loanDetail = new LoanDetail(2L,1L,loanTypeMaster,102.34,new Date(),1.2,2);
//
//        LoanDetail loanDetail1 = new LoanDetail(3L,1L,loanTypeMaster,102.34,new Date(),1.2,2);
//
//
//        loanDetailRepository.saveAll(Arrays.asList(loanDetail,loanDetail1));
//    }

    @Override
    @Transactional(readOnly = true)
    public List<LoanDetail> getLoans(Long id, int pageNo, int pageSize, String sortBy, String sortOrder,String customerId) {

        if (customerId==null || customerId.equals("0")){
            throw new IllegalArgumentException("Illegal Access");
        }

        List<LoanDetail> loanDetails;

        Pageable pageable = null;

        if(id<=0) {

            if (sortOrder.equalsIgnoreCase("asc")) {
                pageable = PageRequest.of(pageNo - 1, pageSize, Sort.by(Sort.Order.by(sortBy)).ascending());
            }

            else {
                pageable = PageRequest.of(pageNo - 1, pageSize, Sort.by(Sort.Order.by(sortBy)).descending());
            }

            loanDetails = loanDetailRepository.findAllByCustomerId(Long.parseLong(customerId), pageable);

        }

        else{

            loanDetails = loanDetailRepository.findByLoanIdAndCustomerId(id,Long.parseLong(customerId));
        }

        return loanDetails;
    }

    @Override
    public List<LoanDetail> findAll() {
        return loanDetailRepository.findAll();
    }
}
