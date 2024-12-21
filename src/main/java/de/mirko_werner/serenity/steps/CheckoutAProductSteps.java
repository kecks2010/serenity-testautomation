package de.mirko_werner.serenity.steps;

import de.mirko_werner.serenity.api.AddToCartInterface;
import de.mirko_werner.serenity.pages.CartPage;
import de.mirko_werner.serenity.pages.CheckoutPage;
import de.mirko_werner.testdata.persistence.models.Customer;
import de.mirko_werner.testdata.repositories.CustomerRepository;
import io.restassured.http.Cookies;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.core.steps.UIInteractions;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class CheckoutAProductSteps extends UIInteractions {

    Customer customer;
    AddToCartInterface addToCart;
    CartPage cartPage;
    CheckoutPage checkoutPage;
    Cookies cookies;

    @Step("I'm a guest customer")
    public void iAmGuestCustomer(String firstName, String lastName) {
        customer = CustomerRepository.getInstance().getCustomer(firstName, lastName);
    }

    @Step("'{quantity}' product is in the cart")
    public void aProductIsInTheCart(int quantity) {
        cookies = addToCart.addRandomProductToCart(quantity);
    }

    @Step("on the checkout page")
    public void onTheCheckoutPage() {
        cartPage.open();
        cartPage.setCookies(cookies);
        cartPage.proceedToCheckout();
    }

    @Step("I enter my billing details")
    public void iEnterMyBillingDetails() {
        checkoutPage.addBillingDetails(customer);
    }

    @Step("place an order")
    public void placeAnOrder() {
        checkoutPage.placeOrder();
    }

    @Step("the order should be placed successfully")
    public void theOrderShouldBePlacedSuccessfully() {
        assertThat(checkoutPage.checkThankYouOrderText(),is("Thank you. Your order has been received."));
    }
}
