package com.desafio.orders.services;

import com.desafio.orders.entities.Order;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    private ShippingService shippingService;

    public OrderService(ShippingService shippingService) {
        this.shippingService = shippingService;
    }

    public double total(Order order){
        double basicPrice = order.getBasic();
        double discountValue =  basicPrice * order.getDiscount() / 100.0;
        double shipmentFee = shippingService.shipment(order);
        return basicPrice - discountValue + shipmentFee ;
    }
}
