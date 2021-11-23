package com.fission.market.market.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fission.market.market.entity.Customers;

@Repository
public interface CustomerRepository extends JpaRepository<Customers, Integer>{

}
