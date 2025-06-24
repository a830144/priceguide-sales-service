package com.mysap.sd.priceguide.service;


import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mysap.sd.priceguide.entity.CustomerPrice;
import com.mysap.sd.priceguide.entity.CustomerPriceId;
import com.mysap.sd.priceguide.repository.CustomerPriceRepository;

@Service
public class CustomerPriceService {

    @Autowired
    private CustomerPriceRepository repository;

    public Optional<CustomerPrice> getPrice(String productId, String customerId) {
        CustomerPriceId id = new CustomerPriceId(productId, customerId);
        return repository.findById(id);  // 保持 Optional，避免 .get() NPE
    }

    public CustomerPrice save(CustomerPrice price) {
        if (price.getCreatedAt() == null) {
            price.setCreatedAt(LocalDateTime.now());
        }
        price.setUpdatedAt(LocalDateTime.now());
        return repository.save(price);
    }
}

