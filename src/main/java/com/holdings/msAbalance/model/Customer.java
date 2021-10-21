package com.holdings.msAbalance.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
    private long id;
    private String name;
    private Map<Stock, Integer> holdings;
}
