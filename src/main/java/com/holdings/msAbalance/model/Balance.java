package com.holdings.msAbalance.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Map;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Balance {
    private Customer customer;
    private Map<Stock, BigDecimal> holdingsBalance;
}
