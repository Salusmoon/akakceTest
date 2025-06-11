package steps;


import static Locater.LoginLocater.*;

public class LoginSteps extends BaseSteps{

    public void continuesWithoutLogin() {
        if (isDisplayed(btnCountinueWithoutRegister)) {
            clickElement(btnCountinueWithoutRegister);
        }
    }
}
