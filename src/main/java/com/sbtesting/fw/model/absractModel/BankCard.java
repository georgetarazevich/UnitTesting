package com.sbtesting.fw.model.absractModel;

import java.math.BigDecimal;

public abstract class BankCard extends BankMethods {
    public BankCard(String name, String currency, BigDecimal balance) {
        super(name, currency, balance);
    }

    public BigDecimal writeOff(BigDecimal withdrawValue) {
        this.balance = balance.subtract(withdrawValue);
        return this.balance;
    }
}
