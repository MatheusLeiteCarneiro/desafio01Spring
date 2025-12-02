package com.desafio.orders.services;

import com.desafio.orders.entities.Order;
import org.springframework.stereotype.Service;

@Service
public class ShippingService {
    private static final double shippingFeeUnder100 = 20.00;
    private static final double shippingFeeUnder200 = 12.00;

    public double shipment(Order order) {
        double basicPrice = order.getBasic();

        if (basicPrice < 100.00) {
            return shippingFeeUnder100;
        } else if (basicPrice >= 100.00 && basicPrice < 200.00) {
            return shippingFeeUnder200;
        } else {
            return 0.0;
        }

    }
}
