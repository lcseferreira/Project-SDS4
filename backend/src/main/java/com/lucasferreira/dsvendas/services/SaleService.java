package com.lucasferreira.dsvendas.services;

import com.lucasferreira.dsvendas.dto.SaleSuccessDTO;
import com.lucasferreira.dsvendas.dto.SaleSumDTO;
import com.lucasferreira.dsvendas.entities.Sale;
import com.lucasferreira.dsvendas.repositories.SaleRepository;
import com.lucasferreira.dsvendas.repositories.SellerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@RequiredArgsConstructor
public class SaleService {
    private final SaleRepository saleRepositoryepository;
    private final SellerRepository sellerRepository;

    public Page<Sale> findAll(Pageable pageable) {
        return saleRepositoryepository.findAll(pageable);
    }

    public List<Sale> findAllNonPageable() {
        return saleRepositoryepository.findAll();
    }

    @Transactional(readOnly = true)
    public List<SaleSumDTO> amountGroupedBySeller() {
        return saleRepositoryepository.amountGroupedBySeller();
    }

    @Transactional(readOnly = true)
    public List<SaleSuccessDTO> successGroupedBySeller() {
        return saleRepositoryepository.successGroupedBySeller();
    }
}
