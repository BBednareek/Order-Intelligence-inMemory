package service;

import domain.Order;
import domain.OrderItem;
import domain.exceptions.*;

import java.math.BigDecimal;
import java.util.List;

public final class OrderValidator {
    private void checkOrderId(Order order) {
        if (order.id() <= 0)
            throw new InvalidOrderIdException();
    }

    private void checkCustomerId(Order order) {
        if (
                order
                        .customerId() == null
                        ||
                        order
                                .customerId()
                                .isBlank()

        )
            throw new InvalidCustomerIdException();
    }

    private void checkQuantityCount(List<OrderItem> items) {
        if (
                items
                        .stream()
                        .anyMatch(
                                orderItem ->
                                        orderItem
                                                .quantity() <= 0
                        )
        )
            throw new InvalidQuantityCountException();
    }

    private void checkIfOrderIsEmpty(List<OrderItem> items) {
        if (

                items == null ||
                        items
                                .isEmpty()

        )
            throw new EmptyOrderItemsException();
    }

    private void checkUnitPrice(List<OrderItem> items) {
        if (items
                .stream()
                .anyMatch(
                        orderItem ->
                                orderItem
                                        .unitPrice()
                                        .compareTo(BigDecimal.ZERO) < 0
                )
        )
            throw new InvalidUnitPriceException();
    }

    public void validate(Order order) {
        checkOrderId(order);
        checkCustomerId(order);
        checkIfOrderIsEmpty(order.items());
        checkQuantityCount(order.items());
        checkUnitPrice(order.items());
    }

}
