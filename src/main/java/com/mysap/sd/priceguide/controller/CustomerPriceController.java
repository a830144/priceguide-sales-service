package com.mysap.sd.priceguide.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mysap.sd.priceguide.entity.CustomerPrice;
import com.mysap.sd.priceguide.service.CustomerPriceService;

@RestController
@RequestMapping("/priceguide/customer-prices")
public class CustomerPriceController {

    @Autowired
    private CustomerPriceService service;

    @GetMapping("/{productId}/{customerId}")
    public ResponseEntity<CustomerPrice> getPrice(
            @PathVariable String productId,
            @PathVariable String customerId) {

    	 return service.getPrice(productId,customerId)
                 .map(ResponseEntity::ok)
                 .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<CustomerPrice> createOrUpdate(@RequestBody CustomerPrice price) {
        return ResponseEntity.ok(service.save(price));
    }
}