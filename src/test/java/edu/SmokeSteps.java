package edu;

import com.codeborne.selenide.Selenide;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;


public class SmokeSteps {

	@Given("^ingreso a la tienda virtual$")
	public void ingreso_a_la_tienda_virtual() throws Throwable {
		 Selenide.open("http://localhost:4567/");
	}

	@Then("^veo el mensaje \"([^\"]*)\"$")
	public void veo_el_mensaje(String mensaje) throws Throwable {
		$(By.id("welcome")).shouldHave(text(mensaje));
	}
	
	@When("^ingrese mi usuario \"([^\"]*)\" y mi password \"([^\"]*)\"$")
	public void ingrese_mi_mi_usuario_y_mi_password(String usuario, String password) throws Throwable {
		 $(By.id("usuario")).setValue(usuario);
		 $(By.id("password")).setValue(password);
	}

	@When("^hago login$")
	public void hago_login() throws Throwable {
		$(By.id("login")).click();
	}

	@Then("^debo ver \"([^\"]*)\"$")
	public void debo_ver(String mensaje) throws Throwable {
		$(By.id("saludo")).shouldHave(text(mensaje));
	}


}
