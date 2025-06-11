package steps;

import org.junit.jupiter.api.Assertions;

import static Locater.ProductLocater.*;

public class ProductSteps extends BaseSteps{

    public void checkbtnGoToSeller() {
        Assertions.assertTrue(isDisplayed(btnGotoSeller));
    }
}
