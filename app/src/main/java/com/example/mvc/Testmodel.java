package com.example.mvc;

public class Testmodel {

    private String testName;
    private String testPrice;
    private String testuid;
    private String type;

    public Testmodel(String testName, String testPrice, String testuid, String type) {
        this.testName = testName;
        this.testPrice = testPrice;
        this.testuid = testuid;
        this.type = type;
    }

    public Testmodel() {
    }

    public String getTestName() {
        return testName;
    }

    public void setTestName(String testName) {
        this.testName = testName;
    }

    public String getTestPrice() {
        return testPrice;
    }

    public void setTestPrice(String testPrice) {
        this.testPrice = testPrice;
    }

    public String getTestuid() {
        return testuid;
    }

    public void setTestuid(String testuid) {
        this.testuid = testuid;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Testmodel{" +
                "testName='" + testName + '\'' +
                ", testPrice='" + testPrice + '\'' +
                ", testuid='" + testuid + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
