package domain;

import java.math.BigDecimal;
import java.util.Objects;

public record CustomerSummary(
        String customerId,
        BigDecimal totalPayment
) {
    public CustomerSummary {
        Objects.requireNonNull(
                customerId,
                "Customer id cannot be empty."
        );

        Objects.requireNonNull(
                totalPayment,
                "Total payment cannot be empty."
        );
    }
}
