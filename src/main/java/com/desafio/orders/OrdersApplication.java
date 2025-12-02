package com.desafio.orders;

import com.desafio.orders.entities.Order;
import com.desafio.orders.services.OrderService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Locale;
import java.util.Scanner;

@SpringBootApplication
public class OrdersApplication implements CommandLineRunner {

    private final OrderService orderService;

    public OrdersApplication(OrderService orderService) {
        this.orderService = orderService;
    }

    public static void main(String[] args) {

        SpringApplication.run(OrdersApplication.class, args);
	}


    @Override
    public void run(String... args) throws Exception {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        int code = sc.nextInt();
        double basic = sc.nextDouble();
        double discount = sc.nextDouble();
        Order order = new Order(code, basic, discount);
        System.out.println("Pedido código " + order.getCode());
        System.out.printf("Valor total: R$%.2f%n", orderService.total(order));
        sc.close();
    }
}
