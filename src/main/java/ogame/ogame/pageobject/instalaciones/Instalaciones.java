package ogame.ogame.pageobject.instalaciones;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import ogame.ogame.pageobject.AllPages;
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
		Objetos obj = new Objetos();
		setObjetosList();
		HashMap<String, Objetos> map = new HashMap<String, Objetos>();
		for (int i=0; i< 1/*Parameters.getInstlIdElements().size()*/; i++) {
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
	
//	public void setRobotObjeto(WebDriver driver) {
//		Objetos robots = getObjetosMap().get(getRobots());
//		WebElement robotsElement = robots.getWebElement();
//		robotsElement.click();
//		WebElement content = findContent(driver);
//		robots.setNombre(getRobots());
//		robots.setMetalRequerido(Integer.parseInt(content.findElement(By.className("metal")).findElement(By.className("cost")).getText()));
//		robots.setCristalRequerido(Integer.parseInt(content.findElement(By.className("crystal")).findElement(By.className("cost")).getText()));
//		robots.setDeuterioRequerido(Integer.parseInt(content.findElement(By.className("deuterio")).findElement(By.className("cost")).getText()));
//		robots.setTiempoInicialRequerido(53);
//		robots.setNivel(Integer.parseInt(content.findElement(By.className("level")).getText().replace("Nivel ","")));
//		robots.setTiempoRequerido(setTiempoRequerido(getRobots()));
//	}
	
	public Double setTiempoRequerido(String nombre) {
		Integer tir = getObjetosMap().get(nombre).getTiempoInicialRequerido();
		Integer nivel = getObjetosMap().get(nombre).getNivel();
		Integer nivelRobots = getObjetosMap().get(getRobots()).getNivel();
		Double constante = getObjetosMap().get(nombre).getConstante();
		return tir*Math.pow(constante, nivel)/(nivelRobots+1);
	}
	
//	public void setHangarObjeto(WebDriver driver) {
//		Objetos hangar = getObjetosMap().get(getHangar());
//		WebElement hangarElement = hangar.getWebElement();
//		hangarElement.click();
//		WebElement content = findContent(driver);
//		hangar.setNombre(getHangar());
//		hangar.setMetalRequerido(Integer.parseInt(content.findElement(By.className("metal")).findElement(By.className("cost")).getText().replace(".", "")));
//		hangar.setCristalRequerido(Integer.parseInt(content.findElement(By.className("crystal")).findElement(By.className("cost")).getText().replace(".", "")));
//		hangar.setDeuterioRequerido(Integer.parseInt(content.findElement(By.className("deuterio")).findElement(By.className("cost")).getText().replace(".", "")));
//		hangar.setTiempoInicialRequerido(61);
//		hangar.setNivel(Integer.parseInt(content.findElement(By.className("level")).getText().replace("Nivel ","")));
//		hangar.setTiempoRequerido(setTiempoRequerido(getHangar()));
//	}
//	
//	public void setInvestigacionObjeto(WebDriver driver) {
//		Objetos investigacion = getObjetosMap().get(getInvestigacion());
//		WebElement investigacionElement = investigacion.getWebElement();
//		investigacionElement.click();
//		WebElement content = findContent(driver);
//		investigacion.setNombre(getHangar());
//		investigacion.setMetalRequerido(Integer.parseInt(content.findElement(By.className("metal")).findElement(By.className("cost")).getText()));
//		investigacion.setCristalRequerido(Integer.parseInt(content.findElement(By.className("crystal")).findElement(By.className("cost")).getText()));
//		investigacion.setDeuterioRequerido(Integer.parseInt(content.findElement(By.className("deuterio")).findElement(By.className("cost")).getText()));
//		investigacion.setTiempoInicialRequerido(61);
//		investigacion.setNivel(Integer.parseInt(content.findElement(By.className("level")).getText().replace("Nivel ","")));
//		investigacion.setTiempoRequerido(setTiempoRequerido(getInvestigacion()));
//	}
//	
//	public void setAlianzaObjeto(WebDriver driver) {
//		Objetos alianza = getObjetosMap().get(getAlianza());
//		WebElement alianzaElement = alianza.getWebElement();
//		alianzaElement.click();
//		WebElement content = findContent(driver);
//		alianza.setNombre(getHangar());
//		alianza.setMetalRequerido(Integer.parseInt(content.findElement(By.className("metal")).findElement(By.className("cost")).getText()));
//		alianza.setCristalRequerido(Integer.parseInt(content.findElement(By.className("crystal")).findElement(By.className("cost")).getText()));
//		alianza.setDeuterioRequerido(Integer.parseInt(content.findElement(By.className("deuterio")).findElement(By.className("cost")).getText()));
//		alianza.setTiempoInicialRequerido(6171);
//		alianza.setNivel(Integer.parseInt(content.findElement(By.className("level")).getText().replace("Nivel ","")));
//		alianza.setTiempoRequerido(setTiempoRequerido(getInvestigacion()));
//	}
	
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
		goTo(driver, params.getInstalaciones());
		setIndexes();
		setObjetoMCD(driver, getRobots(), 53);
		setObjetoMCD(driver, getHangar(), 61);
		setObjetoMCD(driver, getInvestigacion(), 61);
		setObjetoMC(driver, getAlianza(), 6171);
		setObjetoMCD(driver, getSilo(), 4114);
		setObjetoMCD(driver, getNanobots(), 540000);
		setObjetoMCD(driver, getTerraformer(), 5142);
	}
	
	public boolean puedoSubirlo (WebDriver driver, String cual) {
		setObjetos(driver);
		pageVG.setResources(driver);
		Integer metal = getMetal() - getObjetosMap().get(cual).getMetalRequerido();
		Integer cristal = getCristal() - getObjetosMap().get(cual).getCristalRequerido();
		Integer deuterio = getDeuterio() - getObjetosMap().get(cual).getDeuterioRequerido();
		if (metal >=0 && cristal>=0 && deuterio >=0) {
			return true;
		} else {
			System.out.println(cual);
			System.out.println("Metal: " + metal);
			System.out.println("Cristal: " + cristal);
			System.out.println("Deuterio: " + deuterio);
			return false;
		}
	}
	
	public void subir(WebDriver driver, String cual) throws InterruptedException {
		goTo(driver, params.getInstalaciones());
		getObjetosMap().get(cual).getWebElement().click();
		findContent(driver).findElement(By.className("build-it")).click();
		Thread.sleep((long) (getObjetosMap().get(cual).getTiempoRequerido()*1000));
	}

}
