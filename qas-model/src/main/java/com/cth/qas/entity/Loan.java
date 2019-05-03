package com.cth.qas.entity;

import java.math.BigDecimal;
import java.util.Date;

import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Property;
import org.springframework.stereotype.Repository;

@Repository
@NodeEntity(label="Loan")
public class Loan {
	
	@Id @GeneratedValue
	private Long id;
	
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

	public static void main(String[] args) {

	}

}
