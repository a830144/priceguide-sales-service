package com.mysap.sd.priceguide.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mysap.sd.priceguide.entity.StandardPrice;
import com.mysap.sd.priceguide.repository.StandardPriceRepository;

@Service
public class StandardPriceService {

    @Autowired
    private StandardPriceRepository repository;

    public StandardPrice create(StandardPrice price) {
        return repository.save(price);
    }

    public StandardPrice update(Long id, StandardPrice updated) {
        return repository.findById(id).map(existing -> {
            existing.setPrice(updated.getPrice());
            existing.setCurrency(updated.getCurrency());
            existing.setStartDate(updated.getStartDate());
            existing.setEndDate(updated.getEndDate());
            existing.setActive(updated.isActive());
            existing.setUpdatedAt(LocalDateTime.now());
            return repository.save(existing);
        }).orElseThrow(() -> new RuntimeException("Price not found"));
    }

    public Optional<StandardPrice> getByProductId(Long productId) {
        return repository.findByProductIdAndActiveTrue(productId);
    }
}
