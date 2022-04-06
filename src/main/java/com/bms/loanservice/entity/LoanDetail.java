package com.bms.loanservice.entity;

import java.util.Date;

import javax.persistence.*;

//
//@Entity
//@Table(name = "LOAN_DETAIL")
//public class LoanDetail extends BaseEntity {
//
//	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO,generator = "native")
//	private long id;
//
//
//	@OneToOne
//	private LoanTypeMaster loanTypeMaster;
//
//	@Column(name = "LOAN_AMOUNT")
//	private double loanAmount;
//
//	@Column(name = "LOAN_DATE")
//	private Date loanDate;
//
//	@Column(name = "INTEREST_RATE")
//	private double interestRate;
//
//	@Column(name = "LOAN_DURATION")
//	private int loanDuration;
//
//	public LoanDetail(){}
//
//	public LoanDetail(long id, LoanTypeMaster loanTypeMaster, double loanAmount, Date loanDate, double interestRate, int loanDuration) {
//		this.id = id;
//		this.loanTypeMaster = loanTypeMaster;
//		this.loanAmount = loanAmount;
//		this.loanDate = loanDate;
//		this.interestRate = interestRate;
//		this.loanDuration = loanDuration;
//	}
//
//	public LoanDetail(LoanTypeMaster loanTypeMaster, double loanAmount, Date loanDate,
//					  double interestRate, int loanDuration) {
//		super();
//		this.loanTypeMaster = loanTypeMaster;
//		this.loanAmount = loanAmount;
//		this.loanDate = loanDate;
//		this.interestRate = interestRate;
//		this.loanDuration = loanDuration;
//	}
//
//	public long getId() {
//		return id;
//	}
//
//	public void setId(long loanId) {
//		this.id = loanId;
//	}
//
//	public LoanTypeMaster getLoanTypeMaster() {
//		return loanTypeMaster;
//	}
//
//	public void setLoanTypeMaster(LoanTypeMaster loanTypeMaster) {
//		this.loanTypeMaster = loanTypeMaster;
//	}
//
//	public double getLoanAmount() {
//		return loanAmount;
//	}
//
//	public void setLoanAmount(double loanAmount) {
//		this.loanAmount = loanAmount;
//	}
//
//	public Date getLoanDate() {
//		return loanDate;
//	}
//
//	public void setLoanDate(Date loanDate) {
//		this.loanDate = loanDate;
//	}
//
//	public double getInterestRate() {
//		return interestRate;
//	}
//
//	public void setInterestRate(double interestRate) {
//		this.interestRate = interestRate;
//	}
//
//	public int getLoanDuration() {
//		return loanDuration;
//	}
//
//	public void setLoanDuration(int loanDuration) {
//		this.loanDuration = loanDuration;
//	}
//
//	@Override
//	public String toString() {
//		return "LoanDetail [Id=" + id + ", loanTypeMaster=" + loanTypeMaster
//				+ ", loanAmount=" + loanAmount + ", loanDate=" + loanDate + ", intrestRate=" + interestRate
//				+ ", loanDuration=" + loanDuration + "]";
//	}
//
//}
@Entity
@Table(name = "LOAN_DETAIL")
public class LoanDetail {



	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	long loanId;

	@Column
	long customerId;

	@OneToOne
	@JoinColumn(name = "loan_type_id")
	LoanTypeMaster loanTypeMaster;

	@Column(name = "LOAN_AMOUNT")
	double loanAmount;

	@Column(name = "LOAN_DATE")
	Date loanDate;

	@Column(name = "INTEREST_RATE")
	double intrestRate;

	@Column(name = "LOAN_DURATION")
	int loanDuration;

	public LoanDetail() {
		super();
	}
	public LoanDetail(long loanId, long customerId, LoanTypeMaster loanTypeMaster, double loanAmount, Date loanDate,
					  double intrestRate, int loanDuration) {
		super();
		this.loanId = loanId;
		this.customerId = customerId;
		this.loanTypeMaster = loanTypeMaster;
		this.loanAmount = loanAmount;
		this.loanDate = loanDate;
		this.intrestRate = intrestRate;
		this.loanDuration = loanDuration;
	}

	public long getLoanId() {
		return loanId;
	}

	public void setLoanId(long loanId) {
		this.loanId = loanId;
	}

	public long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}

	public LoanTypeMaster getLoanTypeMaster() {
		return loanTypeMaster;
	}

	public void setLoanTypeMaster(LoanTypeMaster loanTypeMaster) {
		this.loanTypeMaster = loanTypeMaster;
	}

	public double getLoanAmount() {
		return loanAmount;
	}

	public void setLoanAmount(double loanAmount) {
		this.loanAmount = loanAmount;
	}

	public Date getLoanDate() {
		return loanDate;
	}

	public void setLoanDate(Date loanDate) {
		this.loanDate = loanDate;
	}

	public double getIntrestRate() {
		return intrestRate;
	}

	public void setIntrestRate(double intrestRate) {
		this.intrestRate = intrestRate;
	}

	public int getLoanDuration() {
		return loanDuration;
	}

	public void setLoanDuration(int loanDuration) {
		this.loanDuration = loanDuration;
	}

	@Override
	public String toString() {
		return "LoanDetail [loanId=" + loanId + ", customerId=" + customerId + ", loanTypeMaster=" + loanTypeMaster
				+ ", loanAmount=" + loanAmount + ", loanDate=" + loanDate + ", intrestRate=" + intrestRate
				+ ", loanDuration=" + loanDuration + "]";
	}



}