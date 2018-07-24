package com.seleniumtest.seleniumhq;


public interface AnyPage {
    LoginPage typeUsername(String username);

    LoginPage typePassword(String password);

    LoginPage submitLogin();

    LoginPage submitLoginExpectingFailure();

    LoginPage loginAs(String username, String password);
}
