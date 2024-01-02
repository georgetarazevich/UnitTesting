package com.sbtesting.fw.model.deposit;

import com.sbtesting.fw.model.absractModel.BankDeposit;

import java.math.BigDecimal;

public class Deposit extends BankDeposit {
    public Deposit(String name, String currency, BigDecimal balance) {
        super(name, currency, balance);
    }
}
