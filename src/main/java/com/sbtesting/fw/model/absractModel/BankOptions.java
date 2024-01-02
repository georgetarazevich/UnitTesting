package com.sbtesting.fw.model.absractModel;

import java.math.BigDecimal;

public abstract class BankOptions {

    public final String name, currency;
    protected BigDecimal balance;

    public BankOptions(String name, String currency, BigDecimal balance) {
        this.name = name;
        this.currency = currency;
        this.balance = balance;
    }
}
