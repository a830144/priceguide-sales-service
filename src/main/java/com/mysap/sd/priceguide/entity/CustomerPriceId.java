package com.mysap.sd.priceguide.entity;


import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class CustomerPriceId implements Serializable {

    @Column(name = "product_id", length = 50)
    private String productId;

    @Column(name = "customer_id", length = 50)
    private String customerId;

    public CustomerPriceId() {}

    public CustomerPriceId(String productId, String customerId) {
        this.productId = productId;
        this.customerId = customerId;
    }

    public String getProductId() { return productId; }
    public void setProductId(String productId) { this.productId = productId; }

    public String getCustomerId() { return customerId; }
    public void setCustomerId(String customerId) { this.customerId = customerId; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CustomerPriceId)) return false;
        CustomerPriceId that = (CustomerPriceId) o;
        return Objects.equals(productId, that.productId) &&
               Objects.equals(customerId, that.customerId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId, customerId);
    }
}
