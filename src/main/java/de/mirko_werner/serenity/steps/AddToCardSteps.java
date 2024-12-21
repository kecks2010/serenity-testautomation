package de.mirko_werner.serenity.steps;

import de.mirko_werner.serenity.pages.CartPage;
import de.mirko_werner.serenity.pages.HomePage;
import de.mirko_werner.serenity.pages.StorePage;
import de.mirko_werner.serenity.pages.components.ProductComponent;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.core.steps.UIInteractions;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class AddToCardSteps extends UIInteractions {

    HomePage homePage;
    StorePage storePage;
    CartPage cartPage;
    ProductComponent productComponent;

    @Step("I'm on the store page")
    public void iMOnTheStorePage() {
        storePage.open();
    }

    @Step("I'm on the home page")
    public void iMOnTheHomePage() {
        homePage.open();
    }

    @Step("I add '{productName}' to the Cart")
    public void iAddToTheCart(String productName) {
        productComponent.addToCart(productName);
    }

    @Step("I see '{quantity' '{productName}' with '{price}' in the Cart")
    public void iSeeOneInTheCart(int quantity, String productName, String price) {
        assertThat(cartPage.getProductName(), is(productName));
        assertThat(cartPage.getProductPrice(), is(price));
        assertThat(Integer.parseInt(cartPage.getProductQuantity()), is(quantity));
    }

    @Step("The total price is '{totalPrice}'")
    public void theTotalPriceIs(String totalprice) {
        assertThat(cartPage.getTotalPrice(), is(totalprice));
    }
}