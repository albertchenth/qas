package com.cth.qas.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cth.qas.relation.LendingTo;

@Repository
public interface LendingToRepository extends CrudRepository<LendingTo, Long> {

}
