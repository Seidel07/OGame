package Ogame.ogame;

import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import ogame.ogame.pageobject.LoginPage;
import ogame.ogame.pageobject.Mina;
import ogame.ogame.pageobject.Recursos;
import ogame.ogame.pageobject.VisionGeneral;
import ogame.ogame.parameters.Parameters;


public class App 
{
	public static void sleep(WebDriver driver, Recursos pageR, String mina) throws InterruptedException {
		Thread.sleep(pageR.getMinas().get(mina).getSegundosRequeridos()*1000);
	}
	
    public static void main( String[] args ) throws InterruptedException
    {
    	WebDriver driver = new FirefoxDriver();
    	try {
        	
        	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        	Parameters params = new Parameters();
        	driver.get(params.getUrl());
        	params.setElementos();
        	LoginPage loginPage = new LoginPage();
        	loginPage.login(driver, params.getUniverso(), params.getUserName(), params.getPassword());
        	VisionGeneral pageVG = new VisionGeneral();
        	pageVG.goTo(driver, params.getRecursos());
        	Recursos pageR = new Recursos();
        	pageVG.setResources(driver);
        	for (int i=1; i<100;i++) {
        		pageR.setValues(driver);
        		pageR.setProducciones(driver);
        		
        		if (pageR.convieneAlmacenMetal(driver)) {
        			pageR.subir(driver, pageR.getMetalAlmacen());
        			sleep(driver,pageR,params.getAlmacenMetal());
        		}
        		
        		if (pageR.convieneAlmacenCristal(driver)) {
        			pageR.subir(driver, pageR.getCristalAlmacen());
        			sleep(driver,pageR,params.getAlmacenCristal());
        		}
        		if (pageVG.getEnergia()<0) {
        			pageR.subir(driver, pageR.getEnergiaSolarMine());
        			sleep(driver,pageR,params.getMinaSolar());
        		} else if (pageR.convieneMetal(driver, pageVG) ){
        			pageR.subir(driver, pageR.getMetalMine());
        			sleep(driver, pageR, params.getMinaMetal());
        		} else {
        			pageR.subir(driver, pageR.getCristalMine());
        			sleep(driver, pageR, params.getMinaCristal());
        		}
        		if (pageR.convieneDeuterio(driver)) {
        			pageR.subir(driver, pageR.getDeuterioMine());
        			sleep(driver,pageR,params.getMinaDeuterio());
        		}
        	}
        	
        	
//        	pageVG.printResources();
//        	pageR.printInfo();
//        	pageR.setProducciones(driver);
//        	pageR.printProducciones();
//        	pageR.printValues(driver.findElement(By.id("content")).getText());
        	System.out.println("Terminado");
        	
        } catch (Exception e) {
        	e.printStackTrace();
        } finally {
        	if (driver != null) {
        		driver.close();
        	}
        }
    }
}
