package org.selenium.pom.tests;

import org.testng.annotations.Test;
import org.selenium.pom.base.BaseTest;
import org.selenium.pom.objects.CreditCard;
import org.selenium.pom.objects.Products;
import org.selenium.pom.pages.CheckOut;
import org.selenium.pom.pages.HomePage;
import org.selenium.pom.pages.Payment;
import org.selenium.pom.utils.ConfigLoader;
import org.selenium.pom.utils.JacksonUtils;
import org.testng.annotations.Test;

public class sanityTestCases extends BaseTest {

	@Test
	public void testLogin() throws InterruptedException {
		Products firstproduct = new Products(1215);
		Products secondproduct = new Products(1216);
		CreditCard creditCard = JacksonUtils.deserializeJson("carddetails.json", CreditCard.class);
		CheckOut homePage = new HomePage(getDriver()).load().closeCurWindow().verifyTitle()
				.navigateToLoginPageUsingLoginBtn().enterUserNameInFld(ConfigLoader.getInstance().getUsername())
				.enterPasswordInFld(ConfigLoader.getInstance().getPassword()).clickOnLoginBtn()
				.fetchPriceOfFeatureItems().clickOnTopsUsingWomensCategory().addToCartBtn(firstproduct.getName())
				.verifyAlert().verifyNotification().addToCartBtn(secondproduct.getName()).verifyAlert().clickOnCart()
				.verifyProduct(firstproduct.getName()).verifyProduct(secondproduct.getName()).clickOnCheckout();
		Payment checkOut = new CheckOut(getDriver()).enterComment(ConfigLoader.getInstance().getComment())
				.clickPlaceOrder().enterCardDetailsandverifyConfirmMessage(creditCard);
	}

}
