package com.mysap.sd.priceguide.service;


import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mysap.sd.priceguide.entity.CustomerPrice;
import com.mysap.sd.priceguide.repository.CustomerPriceRepository;

@Service
public class CustomerPriceService {

    @Autowired
    private CustomerPriceRepository repository;

    public CustomerPrice getPrice(String productId, String customerId) {
        return repository.findByProductIdAndCustomerId(productId, customerId);
    }

    public CustomerPrice save(CustomerPrice price) {
        price.setUpdatedAt(LocalDateTime.now());
        return repository.save(price);
    }
}
