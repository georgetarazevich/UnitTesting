package com.sbtesting.tests.depositTest;

import com.sbtesting.fw.model.deposit.Deposit;
import com.sbtesting.tests.BaseTest;
import org.apache.log4j.Logger;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

public class DepositTest extends BaseTest {

    private static Logger log = Logger.getLogger(DepositTest.class.getName());
    Deposit deposit = null;


    @Test
    public void getDepositStatus() {
        Boolean activeStatus = deposit.closeDeposit();
        assertThat(activeStatus).isEqualTo(false);
    }

    @Test
    public void getBalance() {
        BigDecimal balanceValue = deposit.getBalance();
        assertThat(balanceValue).isEqualTo(new BigDecimal(10));
    }

    @Test
    public void refillBalanceSucceed() {
        BigDecimal valueToRefill = new BigDecimal(10);
        BigDecimal balanceValue = deposit.refill(valueToRefill);
        assertThat(balanceValue).isEqualTo(new BigDecimal(20));
    }

    @Test
    public void depositNameCheck() {
        assertThat(deposit.name).isEqualTo("depositName");
    }

    @Test
    public void depositCurrencyCheck() {
        assertThat(deposit.currency).isEqualTo("NameOfTheCurrency");
    }

    @BeforeMethod
    public void setup(Method method) {
        log.info("Running Test: " + method.getName());
        deposit = new Deposit("depositName", "NameOfTheCurrency", new BigDecimal(10));
    }

    @AfterMethod
    public void teardown(ITestResult result) {
        log.info("Done\n\n");
    }
}
