package com.mysap.sd.priceguide.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mysap.sd.priceguide.entity.StandardPrice;
import com.mysap.sd.priceguide.service.StandardPriceService;

@RestController
@RequestMapping("/priceguide/standard-prices")
public class StandardPriceController {

    @Autowired
    private StandardPriceService service;

    @PostMapping
    public ResponseEntity<StandardPrice> create(@RequestBody StandardPrice price) {
        return ResponseEntity.ok(service.create(price));
    }

    @PutMapping("/{id}")
    public ResponseEntity<StandardPrice> update(@PathVariable Long id, @RequestBody StandardPrice price) {
        return ResponseEntity.ok(service.update(id, price));
    }

    @CrossOrigin(origins = "*") // or specific origin
    @GetMapping("/priceguide/{productId}")
    public ResponseEntity<StandardPrice> getByProductId(@PathVariable Long productId) {
        return service.getByProductId(productId)
                      .map(ResponseEntity::ok)
                      .orElse(ResponseEntity.notFound().build());
    }
}
