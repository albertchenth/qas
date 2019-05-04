package com.cth.qas.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cth.qas.entity.BaseEntity;

@Repository
public interface BaseEntityRepository extends CrudRepository<BaseEntity, Long> {

}
