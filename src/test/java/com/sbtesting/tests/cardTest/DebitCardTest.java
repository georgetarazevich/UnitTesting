package com.sbtesting.tests.cardTest;

import com.sbtesting.fw.model.card.DebitCard;
import com.sbtesting.tests.BaseTest;
import org.apache.log4j.Logger;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

public class DebitCardTest extends BaseTest {

    private static Logger log = Logger.getLogger(DebitCardTest.class.getName());

    DebitCard debitCard = null;

    @Test
    public void getDebitCardBalance() {
        BigDecimal balanceValue = debitCard.getBalance();
        assertThat(balanceValue).isEqualTo(new BigDecimal(10));
    }

    @Test
    public void debitCardCurrencyCheck() {
        assertThat(debitCard.currency).isEqualTo("NameOfTheCurrency");
    }

    @Test
    public void debitCardNameCheck() {
        assertThat(debitCard.name).isEqualTo("debitCard");
    }

    @Test
    public void refillDebitCardCheckSucceed() {
        debitCard.refill(new BigDecimal(2));
        assertThat(debitCard.getBalance()).isEqualTo(new BigDecimal(12));
    }

    @Test
    public void writeOffDebitCardCheckBalanceZero() {
        debitCard.writeOff(new BigDecimal(10));
        assertThat(debitCard.getBalance()).isEqualTo(new BigDecimal(0));
    }

    @Test
    public void writeOffDebitCardCheckBalanceUnchanged() {
        debitCard.writeOff(new BigDecimal(15));
        assertThat(debitCard.getBalance()).isEqualTo(new BigDecimal(10));
    }

    @Test
    public void writeOffDebitCardCheckSucceed() {
        debitCard.writeOff(new BigDecimal(2));
        assertThat(debitCard.getBalance()).isEqualTo(new BigDecimal(8));
    }

    @BeforeMethod
    public void setup(Method method) {
        log.info("Running Test: " + method.getName());
        debitCard = new DebitCard("debitCard", "NameOfTheCurrency", new BigDecimal(10));
    }

    @AfterMethod
    public void teardown(ITestResult result) {
        log.info("Done\n\n");
    }
}
