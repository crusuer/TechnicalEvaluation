package org.example.service;

import org.example.model.Inventory;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class PriceService {

    private final Map<String, BigDecimal> products = Inventory.getProducts();

    public BigDecimal getPrice(String[] input) {
        BigDecimal result = BigDecimal.ZERO;
        Map<String, Integer> basket = new HashMap<>();

        if (input != null) {
            Arrays.stream(input).forEach(product -> basket.put(product, basket.getOrDefault(product, 0) + 1));

            result = result.add(buyXChargeY(products.get("GR1"), basket.getOrDefault("GR1", 0), 2, 1));

            result = result.add(forEachXDropTo(products.get("SR1"), basket.getOrDefault("SR1", 0), 3, 4.5F));

            result = result.add(forEachXDropBy(products.get("CF1"), basket.getOrDefault("CF1", 0), 3, 2 / 3F));
        }
        return result.setScale(2, RoundingMode.HALF_UP);
    }

    private BigDecimal buyXChargeY(BigDecimal initialPrice, Integer qtd, Integer x, Integer y) {
        return initialPrice.multiply(new BigDecimal(y * Math.floorDiv(qtd, x) + qtd % x));
    }

    private BigDecimal forEachXDropTo(BigDecimal initialPrice, Integer qtd, Integer x, Float dropTo) {
        return qtd >= x ? BigDecimal.valueOf(qtd * dropTo) : initialPrice.multiply(new BigDecimal(qtd));
    }

    private BigDecimal forEachXDropBy(BigDecimal initialPrice, Integer qtd, Integer x, Float dropBy) {
        return initialPrice.multiply(qtd >= x ? BigDecimal.valueOf(qtd * dropBy) : new BigDecimal(qtd));
    }
}
