package com.bms.loanservice.service;

import com.bms.loanservice.common.APIResponse;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;


public interface LoanService {

    ResponseEntity<APIResponse> getLoans(Long id, int pageNo,int pageSize, String sortBy,String sortOrder);
}
