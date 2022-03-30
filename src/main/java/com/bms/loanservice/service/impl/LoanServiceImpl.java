package com.bms.loanservice.service.impl;

import com.bms.loanservice.common.APIResponse;
import com.bms.loanservice.entity.LoanDetail;
import com.bms.loanservice.entity.LoanTypeMaster;
import com.bms.loanservice.repository.LoanDetailRepository;
import com.bms.loanservice.repository.LoanTypeRepository;
import com.bms.loanservice.service.LoanService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.Date;
import java.util.List;


@Component
public class LoanServiceImpl implements LoanService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private final LoanDetailRepository loanDetailRepository;

    private final LoanTypeRepository loanTypeRepository;

    private APIResponse apiResponse;

    public LoanServiceImpl(LoanDetailRepository loanDetailRepository, LoanTypeRepository loanTypeRepository) {
        this.loanDetailRepository = loanDetailRepository;
        this.loanTypeRepository = loanTypeRepository;
    }

    @PostConstruct
    public void postConstruct(){
        LoanTypeMaster loanTypeMaster = new LoanTypeMaster("PL");
        loanTypeMaster.setCreatedBy("sjain");
        loanTypeMaster.setCreatedDate(new Date());
        loanTypeRepository.save(loanTypeMaster);
        LoanDetail loanDetail = new LoanDetail(loanTypeMaster,122.22,new Date(),10.2,2);
        loanDetail.setLoanId(1);
        loanDetail.setCreatedBy("sjain");
        loanDetail.setCreatedDate(new Date());
        loanDetailRepository.save(loanDetail);
    }

    @Override
    @Transactional(readOnly = true)
    public List<LoanDetail> getLoans(Long id, int pageNo, int pageSize, String sortBy, String sortOrder) {


        Pageable pageable = PageRequest.of(pageNo-1,pageSize,Sort.by(Sort.Order.by(sortBy)).descending());

        List<LoanDetail> loanDetails = loanDetailRepository.findAllByIdAndCreatedBy(id,"sjain",pageable);



        return loanDetails;
    }

    @Override
    public List<LoanDetail> findAll() {
        return loanDetailRepository.findAll();
    }
}
