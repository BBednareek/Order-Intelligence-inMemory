package domain;

import java.util.List;
import java.util.Objects;

public record Order(
        Long id,
        String customerId,
        List<OrderItem> items
) {
    public Order {
        Objects.requireNonNull(
                id,
                "Order id cannot be empty."
        );

        Objects.requireNonNull(
                customerId,
                "Customer id cannot be empty."
        );

        Objects.requireNonNull(
                items,
                "Item list cannot be empty"
        );
    }
}
