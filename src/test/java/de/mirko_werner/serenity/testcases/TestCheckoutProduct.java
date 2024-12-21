package de.mirko_werner.serenity.testcases;

import de.mirko_werner.serenity.TestMaster;
import de.mirko_werner.serenity.steps.CheckoutAProductSteps;
import net.serenitybdd.annotations.Steps;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TestCheckoutProduct extends TestMaster {

    @Steps
    CheckoutAProductSteps checkoutAProductSteps;

    @DisplayName("Checkout a product as guest customer")
    @Test
    public void testCheckoutAProductAsGuestCustomer() {
        checkoutAProductSteps.iAmGuestCustomer("Harry", "Potter");
        checkoutAProductSteps.aProductIsInTheCart(1);
        checkoutAProductSteps.onTheCheckoutPage();
        checkoutAProductSteps.iEnterMyBillingDetails();
        checkoutAProductSteps.placeAnOrder();
        checkoutAProductSteps.theOrderShouldBePlacedSuccessfully();
    }
}
