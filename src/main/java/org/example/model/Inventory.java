package org.example.model;

import java.math.BigDecimal;
import java.util.Map;

public class Inventory {

    private Inventory() {
        throw new IllegalStateException("Utility class!");
    }

    public static Map<String, BigDecimal> getProducts() {
        return Map.of(
                "GR1", BigDecimal.valueOf(3.11),
                "SR1", BigDecimal.valueOf(5.00),
                "CF1", BigDecimal.valueOf(11.23)
        );
    }
}
