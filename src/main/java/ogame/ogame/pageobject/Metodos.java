package ogame.ogame.pageobject;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import ogame.ogame.pageobject.instalaciones.Instalaciones;
import ogame.ogame.pageobject.investigacion.CondicionesInvestigacion;
import ogame.ogame.pageobject.investigacion.ConvenienciasInvestigacion;
import ogame.ogame.pageobject.investigacion.InvElementsID;
import ogame.ogame.pageobject.investigacion.Investigacion;
import ogame.ogame.pageobject.recursos.Recursos;
import ogame.ogame.parameters.Parameters;

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
	private static LoginPage loginPage = new LoginPage();
	private static Recursos pageR = new Recursos();
	private static Instalaciones pageIns = new Instalaciones();
	private static Investigacion pageInv = new Investigacion();
	private static ConvenienciasInvestigacion pageConvInv= new ConvenienciasInvestigacion();
	private static CondicionesInvestigacion pageCondInv = new CondicionesInvestigacion();
	private static InvElementsID investigacionId = new InvElementsID();
	private static AllPages allPages = new AllPages();
	
	public void manejoBrowser(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(params.getUrl());
		loginPage.login(driver, params.getUniverso(), params.getUserName(), params.getPassword());
	}
	
	public void setTodo(WebDriver driver) {
		setIds();
		setObjetos(driver);
		pageR.setCapacidades(driver);
	}
	
	public void setIds() {
		params.setInstlIdElements();
		investigacionId.setIdElements();
	}
	
	public void setObjetos(WebDriver driver) {
		setObjetosInstalaciones(driver);
		setObjetosRecursos(driver);
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

}
