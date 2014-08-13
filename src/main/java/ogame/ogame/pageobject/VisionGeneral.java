package Ogame.ogame.pageobject;

import Ogame.ogame.parameters.Parameters;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class VisionGeneral extends AllPages{
	
	Parameters params = new Parameters();
	
	public boolean sePuedeInvestigar(WebDriver driver) {
		goTo(driver, params.getVisionGeneral());
		String texto = driver.findElements(By.className("content-box-s")).get(1).findElement(By.className("construction")).findElements(By.tagName("tr")).get(0).getText();
		if (texto.contains("No hay ninguna investigación en progreso")) {
			System.out.println("$$$$$$$No se esta investigando$$$$$$$$");
			return true;
		} else {
			System.out.println("######Se esta investigando###########");
			return false;
		}
	}
	
	public boolean sePuedeConstruirEdifcios(WebDriver driver) {
		goTo(driver, params.getVisionGeneral());
		String texto = driver.findElements(By.className("content-box-s")).get(0).findElement(By.className("construction")).findElements(By.tagName("tr")).get(0).getText();
		if (texto.contains("No hay edificios en construcción.")) {
			System.out.println("$$$$$$$No se estan construyendo edificios$$$$$$$$");
			return true;
		} else {
			System.out.println("######Se esta construyendo un edificio###########");
			return false;
		}
	}
	
	public boolean sePuedeConstruirNaves(WebDriver driver) {
		goTo(driver, params.getVisionGeneral());
		String texto = driver.findElements(By.className("content-box-s")).get(2).findElement(By.className("construction")).findElements(By.tagName("tr")).get(0).getText();
		if (texto.contains("No se está construyendo ninguna nave o defensa en este momento.")) {
			System.out.println("$$$$$$$No se estan construyendo navess$$$$$$$$");
			return true;
		} else {
			System.out.println("######Se esta construyendo naves###########");
			return false;
		}
	}

}
