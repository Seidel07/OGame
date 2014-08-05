package Ogame.ogame;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import ogame.ogame.pageobject.AllPages;
import ogame.ogame.pageobject.LoginPage;
import ogame.ogame.pageobject.Metodos;
import ogame.ogame.pageobject.VisionGeneral;
import ogame.ogame.pageobject.instalaciones.Instalaciones;
import ogame.ogame.pageobject.investigacion.CondicionesInvestigacion;
import ogame.ogame.pageobject.investigacion.ConvenienciasInvestigacion;
import ogame.ogame.pageobject.investigacion.InvElementsID;
import ogame.ogame.pageobject.investigacion.Investigacion;
import ogame.ogame.pageobject.recursos.Recursos;
import ogame.ogame.parameters.Parameters;


public class App 
{
	
	private static Parameters params = new Parameters();
	private static LoginPage loginPage = new LoginPage();
	private static Recursos pageR = new Recursos();
	private static Instalaciones pageIns = new Instalaciones();
	private static Investigacion pageInv = new Investigacion();
	private static VisionGeneral pageVG = new VisionGeneral();
	private static ConvenienciasInvestigacion pageConvInv= new ConvenienciasInvestigacion();
	private static CondicionesInvestigacion pageCondInv = new CondicionesInvestigacion();
	private static InvElementsID investigacionId = new InvElementsID();
	private static Metodos metodos = new Metodos();
	
	public static void main( String[] args ) throws InterruptedException
    {
    	for (int j=1; j < 100; j++) {
    		WebDriver driver = new FirefoxDriver();
    		metodos.manejoBrowser(driver);
    		try {
    			metodos.setTodo(driver);
    			for (int i=1; i<1000; i++) {
    				System.out.println("**********************************************" + i);
    				   				
    				if (pageVG.sePuedeConstruirEdifcios(driver)) {
    					if (pageIns.puedoSubirlo(driver, pageIns.getRobots()) && pageIns.convieneRobots()) { // Robots
        					pageIns.subir(driver, pageIns.getRobots());
        				} else if (pageIns.puedoSubirlo(driver, pageIns.getHangar()) && pageIns.convieneHangar()) {
        					pageIns.subir(driver, pageIns.getHangar());
        				} else if (pageIns.puedoSubirlo(driver, pageIns.getInvestigacion()) && pageIns.convieneInvestigacion()) {
        					pageIns.subir(driver, pageIns.getInvestigacion());
        				} else 	if (pageR.puedoSubirlo(driver, pageR.getMinaSolar()) && pageR.convieneSolar()) { // Energia solar
        					pageR.subir(driver, pageR.getMinaSolar());
        					
        				} else if (pageR.puedoSubirlo(driver, pageR.getMinaMetal()) && pageR.convieneMetal()) { // Mina metal
        					pageR.subir(driver, pageR.getMinaMetal());
        					
        				} else if (pageR.puedoSubirlo(driver, pageR.getMinaCristal()) && pageR.convieneCristal()) { // Mina cristal
        					pageR.subir(driver, pageR.getMinaCristal());
        					
        				} else if (pageR.puedoSubirlo(driver, pageR.getMinaDeuterio()) && pageR.convieneDeuterio()) { // Mina deuterio
        					pageR.subir(driver, pageR.getMinaDeuterio());
        					
        				} else if (pageR.puedoSubirlo(driver, pageR.getAlmacenMetal()) && pageR.convieneAlmacenMetal()) {
        					pageR.subir(driver, pageR.getAlmacenMetal());
        					
        				} else if (pageR.puedoSubirlo(driver, pageR.getAlmacenCristal()) && pageR.convieneAlmacenCristal()) {
        					pageR.subir(driver, pageR.getAlmacenCristal());
        					
        				} else if (pageR.puedoSubirlo(driver, pageR.getAlmacenDeuterio()) && pageR.convieneAlmacenDeuterio()) {
        					pageR.subir(driver, pageR.getAlmacenDeuterio());
        					
        				}
    				}
    				    				
    				if (pageVG.sePuedeInvestigar(driver)) {
    					if (pageInv.puedoSubirlo(driver, pageInv.getTEnergia()) && pageConvInv.convieneEnergia() && pageCondInv.puedoEnergia()) {
        					pageInv.subir(driver, pageInv.getTEnergia());
        				} else if (pageInv.puedoSubirlo(driver, pageInv.getBlindaje()) && pageConvInv.convieneBlindaje() && pageCondInv.puedoBlindaje()) {
        					pageInv.subir(driver, pageInv.getBlindaje());
        				}
    				}
    				
//    				Thread.sleep(5*60*1000);
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
