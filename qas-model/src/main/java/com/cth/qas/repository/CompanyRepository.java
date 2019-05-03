package com.cth.qas.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cth.qas.entity.Company;

@Repository
public interface CompanyRepository extends CrudRepository<Company, Long> {

}
