package Ogame.ogame.pageobject;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import Ogame.ogame.pageobject.hangar.Hangar;
import Ogame.ogame.pageobject.instalaciones.Instalaciones;
import Ogame.ogame.pageobject.investigacion.CondicionesInvestigacion;
import Ogame.ogame.pageobject.investigacion.ConvenienciasInvestigacion;
import Ogame.ogame.pageobject.investigacion.InvElementsID;
import Ogame.ogame.pageobject.investigacion.Investigacion;
import Ogame.ogame.pageobject.recursos.Recursos;
import Ogame.ogame.parameters.Parameters;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Metodos {
	
	public static void addScreenshot(WebDriver driver) {
		String path;
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		path = "./target/screenshots/" + "ogame.png";
		try {
			FileUtils.copyFile(scrFile, new File(path));
			FileUtils.copyFile(scrFile, new File("output/" + File.separator + "OGAME" + ".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private static Parameters params = new Parameters();
	private static VisionGeneral pageVG = new VisionGeneral();
	private static LoginPage loginPage = new LoginPage();
	private static Recursos pageR = new Recursos();
	private static Instalaciones pageIns = new Instalaciones();
	private static Investigacion pageInv = new Investigacion();
	private static Hangar pageH = new Hangar();
	private static ConvenienciasInvestigacion pageConvInv= new ConvenienciasInvestigacion();
	private static CondicionesInvestigacion pageCondInv = new CondicionesInvestigacion();
	private static InvElementsID investigacionId = new InvElementsID();
	private static AllPages allPages = new AllPages();
	
	public void manejoBrowser(WebDriver driver) {
		System.out.println("Se procedera a entrar a la cuenta");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(params.getUrl());
		loginPage.login(driver, params.getUniverso(), params.getUserName(), params.getPassword());
		System.out.println("Se ha entrado a la cuenta");
	}
	
	public void setTodo(WebDriver driver) {
		System.out.println("Se procedera a setearle los valores a los elementos");
		setIds();
		setObjetos(driver);
		pageR.setCapacidades(driver);
		pageR.setProducciones(driver);
		System.out.println("Todos los valores fueron seteados");
	}
	
	public void setIds() {
		params.setInstlIdElements();
		investigacionId.setIdElements();
	}
	
	public void setObjetos(WebDriver driver) {
		
		while (!pageVG.sePuedeConstruirEdifcios(driver)) {
			try {
				Thread.sleep(TimeUnit.MINUTES.toMillis(1));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		setObjetosInstalaciones(driver);
		setObjetosRecursos(driver);
		setObjetosHangar(driver);
		while (!pageVG.sePuedeInvestigar(driver)) {
			try {
				Thread.sleep(TimeUnit.MINUTES.toMillis(1));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		setObjetosInvestigacion(driver);
	}
	
	public void setObjetosInstalaciones(WebDriver driver) {
		allPages.goTo(driver, params.getInstalaciones());
		pageIns.setObjetos(driver);
	}
	
	public void setObjetosRecursos(WebDriver driver) {
		allPages.goTo(driver, params.getRecursos());
		pageR.setObjetos(driver);
	}
	
	public void setObjetosInvestigacion(WebDriver driver) {
		allPages.goTo(driver, params.getInvestigacion());
		pageInv.setObjetos(driver);
	}
	
	public void setObjetosHangar(WebDriver driver) {
		allPages.goTo(driver, params.getHangar());
		pageH.setObjetos(driver);
	}

}
