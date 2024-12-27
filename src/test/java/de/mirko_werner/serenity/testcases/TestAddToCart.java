package de.mirko_werner.serenity.testcases;

import de.mirko_werner.serenity.TestMaster;
import de.mirko_werner.serenity.steps.AddToCardSteps;
import net.serenitybdd.annotations.Steps;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("test")
public class TestAddToCart extends TestMaster {

    @Steps
    AddToCardSteps addToCardSteps;

    @Tag("Debug")
    @DisplayName("Add one product to the cart from home page")
    @Test
    public void testAddOneProductToCartFromHomePage() {
        String productName = "Denim Blue Jeans";

        addToCardSteps.iMOnTheHomePage();
        addToCardSteps.iAddToTheCart(productName);
        addToCardSteps.iSeeOneInTheCart(1, productName, "$100.00");
        addToCardSteps.theTotalPriceIs("$112.50");
    }

    @Tag("Debug")
    @Tag("Smoke")
    @DisplayName("Add one product to the cart from store page")
    @Test
    public void testAddOneProductToCartFromStorePage() {
        String productName = "Basic Blue Jeans";

        addToCardSteps.iMOnTheStorePage();
        addToCardSteps.iAddToTheCart(productName);
        addToCardSteps.iSeeOneInTheCart(1, productName, "$30.00");
        addToCardSteps.theTotalPriceIs("$37.25");
    }
}
