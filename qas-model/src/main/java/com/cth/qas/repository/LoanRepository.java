package com.cth.qas.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cth.qas.entity.Loan;

@Repository
public interface LoanRepository extends CrudRepository<Loan, Long> {

}
