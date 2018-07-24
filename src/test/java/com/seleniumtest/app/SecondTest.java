package com.seleniumtest.app;

import org.junit.Test;

public class SecondTest extends FirstTest {
    @Test
    public void secondtTestCase() throws Exception {
        goToYandexPage();
        switchToYandexMarketTab();
        sweetchToElectronicks();
        selectSecrion("Наушники и Bluetooth-гарнитуры");
        searchIfNotHiddenAndSelect("Beats");
        setPriceFrom(5000);
        pushTheApplyButton(); // sometimes button does'nt works
        Thread.sleep(3000);
        countAndVerifyElementsOnThePage();
    }
}
