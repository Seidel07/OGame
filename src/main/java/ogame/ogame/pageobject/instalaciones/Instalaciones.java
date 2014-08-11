package ogame.ogame.pageobject.instalaciones;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import ogame.ogame.pageobject.AllPages;
import ogame.ogame.pageobject.Objetos;
import ogame.ogame.pageobject.VisionGeneral;
import ogame.ogame.parameters.Parameters;

public class Instalaciones extends AllPages{
	
	Parameters params = new Parameters();
	VisionGeneral pageVG = new VisionGeneral();
	
	private final String robots = "Fábrica de Robots";
	private final String hangar = "Hangar";
	private final String investigacion = "Laboratorio de investigación";
	private final String alianza = "Depósito de la Alianza";
	private final String silo = "Silo";
	private final String nanobots = "Fábrica de Nanobots";
	private final String terraformer = "Terraformer";
	private static List<String> objetosList;
	private static HashMap<String, Objetos> objetosMap;
	
	public static HashMap<String, Objetos> getObjetosMap() {
		return objetosMap;
	}
	public static List<String> getObjetosList() {
		return objetosList;
	}
	public String getRobots() {
		return robots;
	}
	public String getHangar() {
		return hangar;
	}
	public String getInvestigacion() {
		return investigacion;
	}
	public String getAlianza() {
		return alianza;
	}
	public String getSilo() {
		return silo;
	}
	public String getNanobots() {
		return nanobots;
	}
	public String getTerraformer() {
		return terraformer;
	}
	
	public void setObjetosList() {
		List<String> aux = new ArrayList<String>();
		aux.add(getRobots()); //0
		aux.add(getHangar()); // 1
		aux.add(getInvestigacion()); //2
		aux.add(getAlianza()); //3
		aux.add(getSilo()); //4
		aux.add(getNanobots()); //5
		aux.add(getTerraformer()); //6
		Instalaciones.objetosList = aux;
	}
	
//	public void setWebElementsMap(WebDriver driver) {
//		goTo(driver, params.getInstalaciones());
//		params.setInstlIdElements();
//		setObjetosList();
//		HashMap<String, Objetos> map = new HashMap<String, Objetos>();
//		Objetos obj = new Objetos();
//		for (int i=0; i<=6;i++) {
//			obj.setWebElement(driver.findElement(By.id(Parameters.getInstlIdElements().get(i))));
//			String nombre = getObjetosList().get(i);
//			driver.findElement(By.id(Parameters.getInstlIdElements().get(i))).click(); //added
//			map.put(nombre, obj);
//		}
//		Instalaciones.objetosMap = map; 
//	}
	
	public void setIndexes() {
		setObjetosList();
		HashMap<String, Objetos> map = new HashMap<String, Objetos>();
		for (int i=0; i< Parameters.getInstlIdElements().size(); i++) {
			Objetos obj = new Objetos();
			String nombre = getObjetosList().get(i);
			obj.setIndex(i);
			map.put(nombre, obj);
		}
		
		Instalaciones.objetosMap = map; 
	}
	
	public void setWebElement(WebDriver driver, String cual) {
		Integer index = getObjetosMap().get(cual).getIndex();
		getObjetosMap().get(cual).setWebElement(driver.findElement(By.id(Parameters.getInstlIdElements().get(index))));
	}
	
	public WebElement findContent(WebDriver driver) {
		return driver.findElement(By.id("content"));
	}
	
	public Double setTiempoRequerido(String nombre) {
		Integer tir = getObjetosMap().get(nombre).getTiempoInicialRequerido();
		Integer nivel = getObjetosMap().get(nombre).getNivel();
		Integer nivelRobots = getObjetosMap().get(getRobots()).getNivel();
		Double constante = getObjetosMap().get(nombre).getConstante();
		return tir*Math.pow(constante, nivel)/(nivelRobots+1);
	}
	
	public void setObjetoMCD(WebDriver driver, String nombre, Integer tiempoInicial) {
		setWebElement(driver, nombre);
		Objetos obj = getObjetosMap().get(nombre);
		WebElement objElement = obj.getWebElement();
		objElement.click();
		WebElement content = findContent(driver);
		obj.setNombre(nombre);
		obj.setMetalRequerido(Integer.parseInt(content.findElement(By.className("metal")).findElement(By.className("cost")).getText().replace(".", "").replace("M", "000000")));
		obj.setCristalRequerido(Integer.parseInt(content.findElement(By.className("crystal")).findElement(By.className("cost")).getText().replace(".", "").replace("M", "000000")));
		obj.setDeuterioRequerido(Integer.parseInt(content.findElement(By.className("deuterium")).findElement(By.className("cost")).getText().replace(".", "").replace("M", "000000")));
		obj.setTiempoInicialRequerido(tiempoInicial);
		obj.setNivel(Integer.parseInt(content.findElement(By.className("level")).getText().replace("Nivel ","")));
		obj.setTiempoRequerido(setTiempoRequerido(nombre));
	}
	
	public void setObjetoMC(WebDriver driver, String nombre, Integer tiempoInicial) {
		setWebElement(driver, nombre);
		Objetos obj = getObjetosMap().get(nombre);
		WebElement objElement = obj.getWebElement();
		objElement.click();
		WebElement content = findContent(driver);
		obj.setNombre(nombre);
		obj.setMetalRequerido(Integer.parseInt(content.findElement(By.className("metal")).findElement(By.className("cost")).getText().replace(".", "").replace("M", "000000")));
		obj.setCristalRequerido(Integer.parseInt(content.findElement(By.className("crystal")).findElement(By.className("cost")).getText().replace(".", "").replace("M", "000000")));
		obj.setTiempoInicialRequerido(tiempoInicial);
		obj.setNivel(Integer.parseInt(content.findElement(By.className("level")).getText().replace("Nivel ","")));
		obj.setTiempoRequerido(setTiempoRequerido(nombre));
	}
	
	public void setObjetos (WebDriver driver) {
		setIndexes();
		setObjetoMCD(driver, getRobots(), 106);
		setObjetoMCD(driver, getHangar(), 123);
		setObjetoMCD(driver, getInvestigacion(), 123);
		setObjetoMC(driver, getAlianza(), 12342);
		setObjetoMCD(driver, getSilo(), 8228);
		setObjetoMCD(driver, getNanobots(), 1098000);
		setObjetoMCD(driver, getTerraformer(), 10285);
	}
	
	public boolean puedoSubirlo (WebDriver driver, String cual) {
//		setObjetos(driver);
		pageVG.setResources(driver);
		Integer metal = getMetal() - getObjetosMap().get(cual).getMetalRequerido();
		Integer cristal = getCristal() - getObjetosMap().get(cual).getCristalRequerido();
		Integer deuterio = getDeuterio() - getObjetosMap().get(cual).getDeuterioRequerido();
		System.out.println(cual.toUpperCase());
		if (metal >=0 && cristal>=0 && deuterio >=0) {
			System.out.println("Se puede subir " + cual);
			return true;
		} else {
			System.out.println("No se puede subir " + cual);
			return false;
		}
	}
	
	public void subir(WebDriver driver, String cual) throws InterruptedException {
		goTo(driver, params.getInstalaciones());
		setWebElement(driver, cual);
		getObjetosMap().get(cual).getWebElement().click();
		findContent(driver).findElement(By.className("build-it")).click();
//		Thread.sleep((long) (getObjetosMap().get(cual).getTiempoRequerido()*1000));
	}
	
	public boolean convieneRobots() {
		if (getObjetosMap().get(getRobots()).getNivel() <= 10) {
			System.out.println("Es conveniente subir " + getRobots());
			return true;
		} else {
			System.out.println("No conviene subir " + getRobots());
			return false;
		}
	}
	
	public boolean convieneHangar() {
		if (getObjetosMap().get(getHangar()).getNivel() <= 12  && getObjetosMap().get(getRobots()).getNivel() >= 2) {
			System.out.println("Es conveniente subir " + getHangar());
			return true;
		} else {
			System.out.println("No conviene subir " + getHangar());
			return false;
		}
	}
	
	public boolean convieneInvestigacion() {
		if (getObjetosMap().get(getInvestigacion()).getNivel() <= 12) {
			return true;
		} else {
			System.out.println("No conviene subir " + getInvestigacion());
			return false;
		}
	}
	
//	public boolean sePuedeConstruir(WebDriver driver) {
//		goTo(driver, params.getInstalaciones());
//		driver.findElement(By.id("details14")).click();
//		WebElement buildIt = driver.findElement(By.className("build-it_wrap"));
//		if (buildIt.getText() == "Mejorar" || buildIt.getText() == "Comprar Materia Oscura") {
//			return true;
//		} else {
//			return false;
//		}
//	}

}
