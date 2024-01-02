package com.sbtesting.fw.model.card;

import com.sbtesting.fw.model.absractModel.BankCard;

import java.math.BigDecimal;

public class DebitCard extends BankCard {
    public DebitCard(String name, String currency, BigDecimal balance) {
        super(name, currency, balance);
    }

    @Override
    public BigDecimal writeOff(BigDecimal withdrawValue) {

        if (balance.compareTo(withdrawValue) >= 0) {
            balance = balance.subtract(withdrawValue);
        }
        return balance;
    }
}
