package ogame.ogame.pageobject.flota;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Flota2 {
	
	public void setVelocidad(WebDriver driver, Integer porcentaje) {
		List<WebElement> speeds = driver.findElement(By.id("speedLinks")).findElements(By.className("dark_highlight_tablet"));
		for (WebElement speed : speeds) {
			if (Integer.parseInt(speed.getText()) == porcentaje) {
				speed.click();
				break;
			}
		}
	}
	
	public void botonSiguiente(WebDriver driver) {
		driver.findElement(By.id("continue")).click();
	}
	
	public WebElement findSistemaElement(WebDriver driver) {
		return driver.findElement(By.id("system"));
	}
	
	public WebElement findPositionElement(WebDriver driver) {
		return driver.findElement(By.id("position"));
	}
	
	public void seleccionarSistema(WebDriver driver, Integer sistema) {
		findSistemaElement(driver).sendKeys(sistema.toString());;
	}
	
	public void seleccionarPosicion(WebDriver driver, Integer posicion) {
		findPositionElement(driver).sendKeys(posicion.toString());
	}
	
	public Integer findPosition(WebDriver driver) {
		return 0;
	}

}
