package Ogame.ogame;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import ogame.ogame.pageobject.LoginPage;
import ogame.ogame.pageobject.Metodos;
import ogame.ogame.pageobject.VisionGeneral;
import ogame.ogame.pageobject.instalaciones.Instalaciones;
import ogame.ogame.pageobject.recursos.Recursos;
import ogame.ogame.parameters.Parameters;


public class App 
{
	
	
	
    public static void main( String[] args ) throws InterruptedException
    {
    	for (int j=1; j < 100; j++) {
    		WebDriver driver = new FirefoxDriver();
    		try {
        	
    			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    			Parameters params = new Parameters();
    			driver.get(params.getUrl());
    			LoginPage loginPage = new LoginPage();
    			loginPage.login(driver, params.getUniverso(), params.getUserName(), params.getPassword());
//        		VisionGeneral pageVG = new VisionGeneral();
    			Recursos pageR = new Recursos();
    			Instalaciones pageIns = new Instalaciones();
    			params.setInstlIdElements();
    			for (int i=1; i<1000; i++) {
    				System.out.println("**********************************************" + i);
    				   				
    				if (pageIns.puedoSubirlo(driver, pageIns.getRobots()) && pageIns.convieneRobots()) { // Robots
    					pageIns.subir(driver, pageIns.getRobots());
    				}
    				if (pageR.puedoSubirlo(driver, pageR.getMinaSolar()) && pageR.convieneSolar()) { // Energia solar
    					pageR.subir(driver, pageR.getMinaSolar());
    				}
    				if (pageR.puedoSubirlo(driver, pageR.getMinaMetal()) && pageR.convieneMetal()) { // Mina metal
    					pageR.subir(driver, pageR.getMinaMetal());
    				} 
    				if (pageR.puedoSubirlo(driver, pageR.getMinaCristal()) && pageR.convieneCristal()) { // Mina cristal
    					pageR.subir(driver, pageR.getMinaCristal());
    				}
    				if (pageR.puedoSubirlo(driver, pageR.getMinaDeuterio()) && pageR.convieneDeuterio()) { // Mina deuterio
    					pageR.subir(driver, pageR.getMinaDeuterio());
    				}
    				
    				pageR.setCapacidades(driver);
    				
    				if (pageR.puedoSubirlo(driver, pageR.getAlmacenMetal()) && pageR.convieneAlmacenMetal()) {
    					pageR.subir(driver, pageR.getAlmacenMetal());
    				}
    				if (pageR.puedoSubirlo(driver, pageR.getAlmacenCristal()) && pageR.convieneAlmacenCristal()) {
    					pageR.subir(driver, pageR.getAlmacenCristal());
    				}
    				if (pageR.puedoSubirlo(driver, pageR.getAlmacenDeuterio()) && pageR.convieneAlmacenDeuterio()) {
    					pageR.subir(driver, pageR.getAlmacenDeuterio());
    				}
    				if (pageIns.puedoSubirlo(driver, pageIns.getHangar()) && pageIns.convieneHangar()) {
    					pageIns.subir(driver, pageIns.getHangar());
    				}
    				if (pageIns.puedoSubirlo(driver, pageIns.getInvestigacion()) && pageIns.convieneInvestigacion()) {
    					pageIns.subir(driver, pageIns.getInvestigacion());
    				}
    				Thread.sleep(5*60*1000);
    			}
    			
        	
    			System.out.println("Terminado");
        	
    		} catch (Exception e) {
    			e.printStackTrace();
    			Metodos.addScreenshot(driver);
    		} finally {
    			if (driver != null) {
    				driver.close();
    			}
    		}
    	}
    }
}
