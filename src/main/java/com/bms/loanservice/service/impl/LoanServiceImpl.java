package com.bms.loanservice.service.impl;

import com.bms.loanservice.common.APIResponse;
import com.bms.loanservice.repository.LoanDetailRepository;
import com.bms.loanservice.repository.LoanTypeRepository;
import com.bms.loanservice.service.LoanService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;



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


    @Override
    @Transactional(readOnly = true)
    public ResponseEntity<APIResponse> getLoans(Long id, int pageNo, int pageSize, String sortBy, String sortOrder) {

        apiResponse = new APIResponse();


        // TODO: Write Logic for getting applied loans by using pagination with help of using all the params


        return ResponseEntity
                .status(apiResponse.getStatusCode())
                .body(apiResponse);
    }


}
