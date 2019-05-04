package com.cth.qas.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cth.qas.entity.Company;

@Repository
public interface CompanyRepository extends CrudRepository<Company, Long> {
	
	List<Company> findByName(String name);
	
	List<Company> findByTelephoneOrAddress(String telephone,String address);

}
