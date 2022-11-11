package com.lucasferreira.dsvendas.controllers;

import com.lucasferreira.dsvendas.dto.SaleDTO;
import com.lucasferreira.dsvendas.dto.SaleSuccessDTO;
import com.lucasferreira.dsvendas.dto.SaleSumDTO;
import com.lucasferreira.dsvendas.entities.Sale;
import com.lucasferreira.dsvendas.mapper.SaleMapper;
import com.lucasferreira.dsvendas.services.SaleService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/sales")
public class SaleController {
    private final SaleService saleService;
    private final SaleMapper saleMapper;

    @GetMapping
    public ResponseEntity<Page<Sale>> findAll(Pageable pageable) {
        return ResponseEntity.ok(saleService.findAll(pageable));
    }

    @GetMapping(path = "/all")
    public ResponseEntity<List<Sale>> findAllNonPageable() {
        return ResponseEntity.ok(saleService.findAllNonPageable());
    }

    @GetMapping(value = "/amount-by-seller")
    public ResponseEntity<List<SaleSumDTO>> amountGroupedBySeller() {
        List<SaleSumDTO> list = saleService.amountGroupedBySeller();
        return ResponseEntity.ok(list);
    }

    @GetMapping(value = "/success-by-seller")
    public ResponseEntity<List<SaleSuccessDTO>> successGroupedBySeller() {
        List<SaleSuccessDTO> list = saleService.successGroupedBySeller();
        return ResponseEntity.ok(list);
    }
}