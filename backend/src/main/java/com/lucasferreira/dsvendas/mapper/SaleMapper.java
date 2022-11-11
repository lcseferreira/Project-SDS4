package com.lucasferreira.dsvendas.mapper;

import com.lucasferreira.dsvendas.dto.SaleDTO;
import com.lucasferreira.dsvendas.entities.Sale;
import lombok.RequiredArgsConstructor;
import org.h2.mvstore.Page;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class SaleMapper {

    private final ModelMapper modelMapper;

    public SaleDTO toSaleDto(Sale sale) {
        return modelMapper.map(sale, SaleDTO.class);
    }

    public List<SaleDTO> toCollectionSaleDTO(List<Sale> sales) {
        return sales.stream()
                .map(this::toSaleDto)
                .collect(Collectors.toList());
    }
}
