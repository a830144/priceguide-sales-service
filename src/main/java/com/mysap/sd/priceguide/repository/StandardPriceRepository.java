package com.mysap.sd.priceguide.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mysap.sd.priceguide.entity.StandardPrice;

public interface StandardPriceRepository extends JpaRepository<StandardPrice, Long> {
    Optional<StandardPrice> findByProductIdAndActiveTrue(Long productId);
}

