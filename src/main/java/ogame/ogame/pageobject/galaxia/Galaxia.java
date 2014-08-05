package ogame.ogame.pageobject.galaxia;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Galaxia {
	
	public List<WebElement> hallarInactivos(WebDriver driver) {
		List<WebElement> filas = driver.findElements(By.className("row"));
		List<WebElement> inactivos = new ArrayList<WebElement>();
		for (WebElement fila : filas) {
			if (fila.findElement(By.className("status")).getText() == "(i)") {
				inactivos.add(fila);
			}
		}
		return inactivos;
	}
	
	public WebElement avanzarGalaxia(WebDriver driver) {
		return driver.findElement(By.className("forwardGalaxy"));
	}
	
	public WebElement retrocederGalaxia(WebDriver driver) {
		return driver.findElement(By.className("backGalaxy"));
	}

}
