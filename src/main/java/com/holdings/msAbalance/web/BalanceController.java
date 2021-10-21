package com.holdings.msAbalance.web;

import com.holdings.msAbalance.model.Balance;
import com.holdings.msAbalance.service.HoldingsCalculator;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BalanceController {
        private HoldingsCalculator holdingsCalculator;

    public BalanceController(HoldingsCalculator holdingsCalculator) {
        this.holdingsCalculator = holdingsCalculator;
    }

    @GetMapping(path = "customer/{id}",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public Balance getBalance(@PathVariable("id")String id) {
        return holdingsCalculator.calculateBalance(id);
    }
}
