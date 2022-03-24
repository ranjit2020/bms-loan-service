package com.bms.loanservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bms.loanservice.entity.LoanDetail;

@Repository
public interface LoanDetailRepository extends JpaRepository<LoanDetail, Long> {

}
