package domain;

import java.math.BigDecimal;
import java.util.Objects;

public record OrderItem(
        String productName,
        String productCategory,
        Integer quantity,
        BigDecimal unitPrice
) {
    public OrderItem {
        Objects.requireNonNull(
                productName,
                "Product name cannot be empty."
        );

        Objects.requireNonNull(
                productCategory,
                "Product category cannot be empty."
        );

        Objects.requireNonNull(
                quantity,
                "Quantity cannot be empty."
        );

        Objects.requireNonNull(
                unitPrice,
                "Unit price cannot be empty."
        );
    }
}
