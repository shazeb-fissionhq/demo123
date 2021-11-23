package com.fission.market.market.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fission.market.market.entity.Products;

@Repository
public interface ProductRepository extends JpaRepository<Products, String> {

}
