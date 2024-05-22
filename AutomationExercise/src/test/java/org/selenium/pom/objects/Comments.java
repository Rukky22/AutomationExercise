package org.selenium.pom.objects;

public class Comments {
    private String checkoutcomment;

    public Comments(){}

    public Comments(String checkoutcomment){
        this.checkoutcomment = checkoutcomment;
    }
    public String getCheckoutcomment() {
        return checkoutcomment;
    }

    public void setCheckoutcomment(String checkoutcomment) {
        this.checkoutcomment = checkoutcomment;
    }
}
