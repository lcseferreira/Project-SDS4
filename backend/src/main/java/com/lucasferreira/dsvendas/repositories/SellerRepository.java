package com.lucasferreira.dsvendas.repositories;

import com.lucasferreira.dsvendas.entities.Seller;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SellerRepository extends JpaRepository<Seller, Long> {

}
