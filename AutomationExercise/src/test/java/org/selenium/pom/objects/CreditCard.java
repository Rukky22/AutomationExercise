package org.selenium.pom.objects;

public class CreditCard {
    private String cardName;
    private String cardNumber;
    private String expiration;
    private String month;
    private String year;

    public CreditCard(){}

    public CreditCard(String cardName, String cardNumber,String expiration,String month,String year){
        this.cardName = cardName;
        this.cardNumber = cardNumber;
        this.expiration = expiration;
        this.month = month;
        this.year = year;
    }

    public String getCardName() {
        return cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getExpiration() {
        return expiration;
    }

    public void setExpiration(String expiration) {
        this.expiration = expiration;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

}
