package com.mysap.sd.priceguide.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.mysap.sd.priceguide.entity.CustomerPrice;

public interface CustomerPriceRepository extends JpaRepository<CustomerPrice, String> {
    CustomerPrice findByProductIdAndCustomerId(String productId, String customerId);
}
