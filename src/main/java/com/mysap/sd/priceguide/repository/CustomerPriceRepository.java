package com.mysap.sd.priceguide.repository;



import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mysap.sd.priceguide.entity.CustomerPrice;
import com.mysap.sd.priceguide.entity.CustomerPriceId;

public interface CustomerPriceRepository extends JpaRepository<CustomerPrice, CustomerPriceId> {
	Optional<CustomerPrice> findById(CustomerPriceId id);
}
