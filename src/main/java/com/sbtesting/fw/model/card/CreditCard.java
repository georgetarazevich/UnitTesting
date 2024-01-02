package com.sbtesting.fw.model.card;

import com.sbtesting.fw.model.absractModel.BankCard;

import java.math.BigDecimal;

public class CreditCard extends BankCard {
    public final BigDecimal interestRate;

    public CreditCard(String name, String currency, BigDecimal balance, BigDecimal interestRate) {
        super(name, currency, balance);
        this.interestRate = interestRate;
    }

    public BigDecimal getDebt() {

        if (balance.signum() < 0) return balance;
        else
            return BigDecimal.ZERO;
    }
}
