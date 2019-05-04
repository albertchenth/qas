package com.cth.qas.relation;

import java.math.BigDecimal;
import java.util.Date;

import org.neo4j.ogm.annotation.EndNode;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.Property;
import org.neo4j.ogm.annotation.RelationshipEntity;
import org.neo4j.ogm.annotation.StartNode;
import org.springframework.stereotype.Repository;

import com.cth.qas.base.BaseEntity;
import com.cth.qas.base.RelationType;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Repository
@RelationshipEntity(type=RelationType.LENDING_TO)
public class LendingTo {
	
	@Id @GeneratedValue
	private Long relationshipId;
	
	@Property(name="start_date")
	private Date startDate;
	
	@Property(name="end_date")
	private Date endDate;
	
	@Property(name="period")
	private int period;
	
	@Property(name="amount")
	private BigDecimal amount;
	
	@Property(name="rate")
	private BigDecimal rate;
	
	@JsonIgnore
	@StartNode private BaseEntity lender;
	
	@JsonIgnore
	@EndNode private BaseEntity borrower;

	public Long getRelationshipId() {
		return relationshipId;
	}

	public void setRelationshipId(Long relationshipId) {
		this.relationshipId = relationshipId;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public int getPeriod() {
		return period;
	}

	public void setPeriod(int period) {
		this.period = period;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public BigDecimal getRate() {
		return rate;
	}

	public void setRate(BigDecimal rate) {
		this.rate = rate;
	}

	public BaseEntity getLender() {
		return lender;
	}

	public void setLender(BaseEntity lender) {
		this.lender = lender;
	}

	public BaseEntity getBorrower() {
		return borrower;
	}

	public void setBorrower(BaseEntity borrower) {
		this.borrower = borrower;
	}

	public static void main(String[] args) {

	}

}
