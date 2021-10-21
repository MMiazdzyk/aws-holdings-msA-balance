package com.holdings.msAbalance.model;

import lombok.*;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Stock {
    private long id;
    private String name;
    private BigDecimal price;
}
