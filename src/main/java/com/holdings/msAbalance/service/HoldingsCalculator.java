package com.holdings.msAbalance.service;

import com.holdings.msAbalance.model.Balance;
import com.holdings.msAbalance.model.Customer;
import com.holdings.msAbalance.model.Stock;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@Service
public class HoldingsCalculator {

    public Balance calculateBalance(String id) {
        Customer customer = getCustomer(id); // this should call to msB -> REST API with data from DynamoDB
        Map<Stock, Integer> holdings = customer.getHoldings();
        Map<Stock, BigDecimal> holdingsBalance = calculateHoldingsBalance(holdings);

        return new Balance(customer,holdingsBalance);
    }

    private Map<Stock, BigDecimal> calculateHoldingsBalance(Map<Stock, Integer> holdings) {
        Map<Stock, BigDecimal> holdingsBalance = new HashMap<>();
        holdings.forEach((stock, volume) -> holdingsBalance.put(stock, getStockPrice(stock.getId(), volume)));

        return holdingsBalance;
    }

    private BigDecimal getStockPrice(long id, Integer volume) {
        BigDecimal price = getStockPrice(id);   // this should be call to msC-> REST API with stock prices
        return price.multiply(BigDecimal.valueOf(volume));
    }

    private BigDecimal getStockPrice(long id) {
        return new BigDecimal(10);
    }

    private Customer getCustomer(String id) {
        return new Customer();
    }

}
