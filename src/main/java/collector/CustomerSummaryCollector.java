package collector;

import domain.CustomerSummary;
import domain.Order;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class CustomerSummaryCollector {
    public static void accumulate(Map<String, BigDecimal> result, Order order) {
        result.merge(
                order.customerId(),
                order
                        .items()
                        .stream()
                        .map(
                                item ->
                                        item
                                                .unitPrice()
                                                .multiply(
                                                        BigDecimal.valueOf(
                                                                item.quantity()
                                                        )
                                                )
                        )
                        .reduce(BigDecimal.ZERO, BigDecimal::add),
                BigDecimal::add
        );
    }

    public static Map<String, BigDecimal> combine(Map<String, BigDecimal> first, Map<String, BigDecimal> second) {
        for (Map.Entry<String, BigDecimal> entry : second.entrySet()) {
            first.merge(
                    entry.getKey(),
                    entry.getValue(),
                    BigDecimal::add
            );
        }

        return first;
    }

    public static Map<String, BigDecimal> supplier() {
        return new HashMap<>();
    }

    public static List<CustomerSummary> finish(Map<String, BigDecimal> result) {
        return result
                .entrySet()
                .stream()
                .map(
                        entry ->
                                new CustomerSummary(entry.getKey(), entry.getValue())
                ).toList();
    }

    public Collector<Order, Map<String, BigDecimal>, List<CustomerSummary>> collectCustomerTotalPayment() {
        return Collector.of(
                CustomerSummaryCollector::supplier,
                CustomerSummaryCollector::accumulate,
                CustomerSummaryCollector::combine,
                CustomerSummaryCollector::finish
        );
    }
}
