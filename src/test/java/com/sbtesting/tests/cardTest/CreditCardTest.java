package com.sbtesting.tests.cardTest;

import com.sbtesting.fw.model.card.CreditCard;
import com.sbtesting.tests.BaseTest;
import org.apache.log4j.Logger;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

public class CreditCardTest extends BaseTest {

    private static Logger log = Logger.getLogger(CreditCardTest.class.getName());
    CreditCard creditCard = null;

    @Test
    public void getCreditCardBalance() {
        BigDecimal balanceValue = creditCard.getBalance();
        assertThat(balanceValue).isEqualTo(new BigDecimal(10));
    }

    @Test
    public void creditCardCurrencyCheck() {
        assertThat(creditCard.currency).isEqualTo("CurrencyCreditCard");
    }

    @Test
    public void creditCardNameCheck() {
        assertThat(creditCard.name).isEqualTo("creditCard");
    }

    @Test
    public void debtCreditCardCheckDebtYes() {
        creditCard.writeOff(new BigDecimal(40));
        assertThat(creditCard.getDebt()).isEqualTo(new BigDecimal(-30));
    }

    @Test
    public void debtCreditCardCheckDebtZero() {
        creditCard.writeOff(new BigDecimal(5));
        assertThat(creditCard.getDebt()).isEqualTo(new BigDecimal(0));
    }

    @Test
    public void refillCreditCardCheckSucceed() {
        creditCard.refill(new BigDecimal(2));
        assertThat(creditCard.getBalance()).isEqualTo(new BigDecimal(12));
    }

    @Test
    public void writeOffCreditCardCheckSucceed() {
        creditCard.writeOff(new BigDecimal(2));
        assertThat(creditCard.getBalance()).isEqualTo(new BigDecimal(8));
    }

    @Test
    public void interestRateCreditCardCheck() {
        assertThat(creditCard.interestRate).isEqualTo(new BigDecimal(5));
    }

    @BeforeMethod
    public void setup(Method method) {
        log.info("Running Test: " + method.getName());
        creditCard = new CreditCard("creditCard", "CurrencyCreditCard", new BigDecimal(10), new BigDecimal(5));
    }

    @AfterMethod
    public void teardown(ITestResult result) {
        log.info("Done\n\n");
    }
}
