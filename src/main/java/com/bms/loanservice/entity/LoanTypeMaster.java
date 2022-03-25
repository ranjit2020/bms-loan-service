package com.bms.loanservice.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class LoanTypeMaster extends BaseEntity{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO,generator = "native")
	private int id;
	
	@Column(unique = true)
	private String loanType;

	public LoanTypeMaster(){}

	public LoanTypeMaster( String loanType) {
		super();
//		this.loanId = loanId;
		this.loanType = loanType;
	}


	public int getLoanId() {
		return id;
	}


	public void setLoanId(int loanId) {
		this.id = loanId;
	}


	public String getLoanType() {
		return loanType;
	}


	public void setLoanType(String loanType) {
		this.loanType = loanType;
	}
	
	@Override
	public String toString() {
		return "LoanTypeMaster [loanId=" + id + ", loanType=" + loanType + "]";
	}


}
