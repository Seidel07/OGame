package Ogame.ogame;

import java.util.concurrent.TimeUnit;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import ogame.ogame.pageobject.LoginPage;
import ogame.ogame.pageobject.VisionGeneral;
import ogame.ogame.pageobject.instalaciones.Instalaciones;
import ogame.ogame.pageobject.recursos.Recursos2;
import ogame.ogame.parameters.Parameters;


public class App 
{
	
    public static void main( String[] args ) throws InterruptedException
    {
    	WebDriver driver = new FirefoxDriver();
    	try {
        	
        	driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        	Parameters params = new Parameters();
        	driver.get(params.getUrl());
        	LoginPage loginPage = new LoginPage();
        	loginPage.login(driver, params.getUniverso(), params.getUserName(), params.getPassword());
        	VisionGeneral pageVG = new VisionGeneral();
        	Recursos2 pageR = new Recursos2();
        	Instalaciones pageIns = new Instalaciones();
        	params.setInstlIdElements();
        	for (int i=1; i<100; i++) {
        		pageIns.setObjetos(driver);
        		pageR.setObjetos(driver);
        		pageVG.setResources(driver);
        		if (pageIns.puedoSubirlo(driver, pageIns.getRobots())) { // Robots
        			pageIns.subir(driver, pageIns.getRobots());
        		}
        		if (pageR.puedoSubirlo(driver, pageR.getMinaSolar()) && pageVG.getEnergia()<0) { // Energia solar
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
        	}
   	
        	
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
