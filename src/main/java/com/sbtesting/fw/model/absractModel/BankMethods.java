package com.sbtesting.fw.model.absractModel;

import java.math.BigDecimal;

public abstract class BankMethods extends BankOptions {
    public BankMethods(String name, String currency, BigDecimal balance) {
        super(name, currency, balance);
    }

    public BigDecimal refill(BigDecimal increaseValue) {
        this.balance = balance.add(increaseValue);
        return this.balance;
    }

    public BigDecimal getBalance() {
        return this.balance;
    }
}
