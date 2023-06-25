package com.keberlabs.drivers;

public class DriverStrategySelector {
    public static DriverStrategy chooseStrategy(String browser) {
        switch(browser){
            case "Chrome":
                return new Chrome();
            case "ChromeWindows":
                return new ChromeWindows();
            case "Firefox":
                return new Firefox();
            default:
                return null;
        }
    }
}
