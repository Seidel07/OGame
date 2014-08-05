package ogame.ogame.pageobject.flota;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import ogame.ogame.pageobject.AllPages;
import ogame.ogame.pageobject.hangar.Hangar;
import ogame.ogame.parameters.Parameters;

public class Flota1 extends AllPages{
	
	Parameters params = new Parameters();
	
	public void seleccionarTodas(WebDriver driver) {
		driver.findElement(By.id("sendall")).click();
	}
	
	public void botonSiguiente(WebDriver driver){
		driver.findElement(By.id("continue")).click();
	}
	
	public void getObjetosList() {
		Hangar.getObjetosList();
	}
	
	public void setWebElement(WebDriver driver, String cual) {
		Integer index = Hangar.getObjetosMap().get(cual).getIndex();
		Integer elem = index + 202;
		Hangar.getObjetosMap().get(cual).setWebElement(driver.findElement(By.id("ship_" + elem)));
	}
	
	public void mandarTodas(WebDriver driver) {
		goTo(driver, params.getFlota());
		seleccionarTodas(driver);
		botonSiguiente(driver);
	}

}
