package com.sbtesting.tests.cardTest;

import com.sbtesting.fw.model.card.CurrencyDebitCard;
import com.sbtesting.tests.BaseTest;
import org.apache.log4j.Logger;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

public class CurrencyDebitCardTest extends BaseTest {
    private static Logger log = Logger.getLogger(CurrencyDebitCardTest.class.getName());

    CurrencyDebitCard currencyDebitCard = null;

    @Test
    public void getCurrencyDebitCardBalance() {
        BigDecimal balanceValue = currencyDebitCard.getBalance();
        assertThat(balanceValue).isEqualTo(new BigDecimal(10));
    }

    @Test
    public void currencyDebitCardCurrencyCheck() {
        assertThat(currencyDebitCard.currency).isEqualTo("NameOfTheCurrency");
    }

    @Test
    public void currencyDebitCardNameCheck() {
        assertThat(currencyDebitCard.name).isEqualTo("CurrencyDebitCardName");
    }

    @Test
    public void refillCurrencyDebitCardCheckSucceed() {
        currencyDebitCard.refill(new BigDecimal(2));
        assertThat(currencyDebitCard.getBalance()).isEqualTo(new BigDecimal(12));
    }

    @Test
    public void writeOffCurrencyDebitCardCheckBalanceZero() {
        currencyDebitCard.writeOff(new BigDecimal(10));
        assertThat(currencyDebitCard.getBalance()).isEqualTo(new BigDecimal(0));
    }

    @Test
    public void writeOffCurrencyDebitCardCheckBalanceUnchanged() {
        currencyDebitCard.writeOff(new BigDecimal(15));
        assertThat(currencyDebitCard.getBalance()).isEqualTo(new BigDecimal(10));
    }

    @Test
    public void writeOffCurrencyDebitCardCheckSucceed() {
        currencyDebitCard.writeOff(new BigDecimal(2));
        assertThat(currencyDebitCard.getBalance()).isEqualTo(new BigDecimal(8));
    }

    @BeforeMethod
    public void setup(Method method) {
        log.info("Running Test: " + method.getName());
        currencyDebitCard = new CurrencyDebitCard("CurrencyDebitCardName", "NameOfTheCurrency", new BigDecimal(10));
    }

    @AfterMethod
    public void teardown(ITestResult result) {
        log.info("Done\n\n");
    }
}
