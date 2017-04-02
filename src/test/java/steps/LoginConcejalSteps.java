package steps;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginConcejalSteps {

	@When("^un usuario de tipo concejal se loguea con usuario \"(.+)\" y password \"(.+)\"$")
	public void i_login_with_name_and_password(String name, String password) throws Throwable {
		// Implementar
	}

	@Then("^el usuario recibe la pantalla inicial$")
	public void i_receive_a_welcome_message() throws Throwable {
		// Implementar
	}

}