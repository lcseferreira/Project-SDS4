package com.lucasferreira.dsvendas.repositories;

import com.lucasferreira.dsvendas.entities.Sale;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SaleRepository extends JpaRepository<Sale, Long> {
}
