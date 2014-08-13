package Ogame.ogame.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class LoginPage {
	
	
	public void setUniverso(WebDriver driver, String universo) {
		WebElement universos = driver.findElement(By.id("serverLogin"));
		Select seleccionador = new Select(universos);
//		seleccionador.selectByValue(universo);
		seleccionador.selectByIndex(8);
		universos.click();
	}
	
	public void botonEntrar(WebDriver driver) {
		WebElement entrar = driver.findElement(By.id("loginBtn"));
		entrar.click();
	}
	
	public void setUserName(WebDriver driver, String userName) {
		WebElement userNameField = driver.findElement(By.id("usernameLogin"));
		userNameField.sendKeys(userName);
	}
	
	public void setPassword(WebDriver driver, String password) {
		WebElement passwordField = driver.findElement(By.id("passwordLogin"));
		passwordField.sendKeys(password);
	}
	
	public void submitButton(WebDriver driver) {
		WebElement submit = driver.findElement(By.id("loginSubmit"));
		submit.click();
	}
	
	public void login(WebDriver driver, String universo, String userName, String password) {
		this.botonEntrar(driver);
		this.setUniverso(driver, universo);
		this.setUserName(driver, userName);
		this.setPassword(driver, password);
		this.submitButton(driver);
	}

}
