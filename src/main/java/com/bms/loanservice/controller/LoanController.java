package com.bms.loanservice.controller;

import com.bms.loanservice.common.APIResponse;
import com.bms.loanservice.service.LoanService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.*;

@RestController
@RequestMapping(LoanController.ENDPOINT)
public class LoanController {

    public static final String ENDPOINT = "api/v1/loan";


    private final LoanService loanService;

    public LoanController(LoanService loanService) {
        this.loanService = loanService;
    }


    @GetMapping(
            value = "/view",
            consumes = {APPLICATION_JSON_VALUE},
            produces = {APPLICATION_JSON_VALUE}
    )
    public ResponseEntity<APIResponse> viewLoans(@RequestParam(name = "id",defaultValue = "0") Long id,
                                                 @RequestParam(name = "pageNo", defaultValue = "1") int pageNo,
                                                 @RequestParam(name = "pageSize", defaultValue = "10") int pageSize,
                                                 @RequestParam(name = "sortBy", defaultValue = "id") String sortBy,
                                                 @RequestParam(name = "sortOrder", defaultValue = "desc") String sortOrder){
        return loanService.getLoans(id,pageNo,pageSize,sortBy,sortOrder);
    }


}
