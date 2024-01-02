package com.sbtesting.fw.model.card;

import java.math.BigDecimal;

public class CurrencyDebitCard extends DebitCard {
    public CurrencyDebitCard(String name, String currency, BigDecimal balance) {
        super(name, currency, balance);
    }
}
