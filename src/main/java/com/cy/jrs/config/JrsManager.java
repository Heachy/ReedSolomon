package com.cy.jrs.config;

/**
 * @author Haechi
 */
public class JrsManager {
    public volatile static CodingConfig config;

    public static void setConfig(CodingConfig config) {
        setConfigMethod(config);
    }
    private static void setConfigMethod(CodingConfig config) {
        JrsManager.config = config;
    }
}
