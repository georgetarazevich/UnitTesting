package com.sbtesting.fw.model.absractModel;

import java.math.BigDecimal;

public abstract class BankDeposit extends BankMethods {
    private boolean activeDepositStatus = true;

    public BankDeposit(String name, String currency, BigDecimal balance) {
        super(name, currency, balance);
    }

    public Boolean closeDeposit() {
        activeDepositStatus = false;
        return activeDepositStatus;
    }
}
