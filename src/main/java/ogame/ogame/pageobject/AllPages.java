package Ogame.ogame.pageobject;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AllPages {
	
	private static Integer metal;
	private static Integer cristal;
	private static Integer deuterio;
	private static Integer energia;
	private final String coordenadasPlaneta0 = "[1:147:6]";
	private static List<String> coordenadasPlanetas;
	
	
	public Integer getMetal() {
		return AllPages.metal;
	}
	public Integer getCristal() {
		return cristal;
	}
	public Integer getDeuterio() {
		return deuterio;
	}
	
	public Integer getEnergia() {
		return energia;
	}
		
	public void setMetal(WebDriver driver) {
		String metalText = driver.findElement(By.id("resources_metal")).getText().replace(".","");
		AllPages.metal = Integer.parseInt(metalText);
	}
	
	public void setCristal(WebDriver driver) {
		String cristalText = driver.findElement(By.id("resources_crystal")).getText().replace(".","");
		AllPages.cristal = Integer.parseInt(cristalText);
	}
	
	public void setDeuterio(WebDriver driver) {
		String deuterioText = driver.findElement(By.id("resources_deuterium")).getText().replace(".","");
		AllPages.deuterio = Integer.parseInt(deuterioText);
	}
	
	public void setEnergia(WebDriver driver) {
		String energyText = driver.findElement(By.id("resources_energy")).getText().replace(".","");
		AllPages.energia = Integer.parseInt(energyText);
	}
	
	public void setResources(WebDriver driver) {
		this.setMetal(driver);
		this.setCristal(driver);
		this.setDeuterio(driver);
		this.setEnergia(driver);
	}
	
	public void printResources() {
		System.out.println("Metal disponible " + getMetal());
		System.out.println("Cristal disponible " + getCristal());
		System.out.println("Deuterio disponible " + getDeuterio());
		System.out.println("Energia disponible " + getEnergia());
	}
	
	public void goTo(WebDriver driver, String where) {
		List<WebElement> menuOptions = driver.findElements(By.className("menubutton"));
		for (WebElement opt : menuOptions) {
			if (opt.findElement(By.className("textlabel")).getText().equals(where)) {
				opt.click();
				break;
			} 
		}
	}
	
	public String getCoordenadasPlaneta0() {
		return coordenadasPlaneta0;
	}
	
	public static List<String> getCoordenadasPlanetas() {
		return coordenadasPlanetas;
	}
	public void setCoordenadasPlanetas() {
		List<String> aux = new ArrayList<String>();
		aux.add(getCoordenadasPlaneta0());
		AllPages.coordenadasPlanetas = aux;
	}

}
