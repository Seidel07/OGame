package ogame.ogame.pageobject.recursos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import ogame.ogame.pageobject.AllPages;
import ogame.ogame.pageobject.VisionGeneral;
import ogame.ogame.pageobject.instalaciones.Instalaciones;
import ogame.ogame.pageobject.instalaciones.Objetos;
import ogame.ogame.parameters.Parameters;

public class Recursos extends AllPages{
	
	Instalaciones instl = new Instalaciones();
	Parameters params = new Parameters();
	VisionGeneral pageVG = new VisionGeneral();
	
	private final String minaMetal = "Mina de metal";
	private final String minaCristal = "Mina de cristal";
	private final String minaDeuterio = "Sintetizador de deuterio";
	private final String minaSolar = "Planta de energía solar";
	private final String fusion = "Planta de fusión";
	private final String satelite = "Satélite solar";
	private final String almacenMetal = "Almacén de metal";
	private final String almacenCristal = "Almacén de cristal";
	private final String almacenDeuterio = "Contenedor de deuterio";
	private final String esconditeMetal = "Escondite blindado de metal";
	private final String esconditeCristal = "Escondite subterráneo de cristal";
	private final String esconditeDeuterio = "Escondite marítimo de deuterio";
	private static List<String> objetosList;
	private static HashMap<String, Objetos> objetosMap;
	private static Integer prodMetal;
	private static Integer prodCristal;
	private static Integer prodDeuterio;
	
	public static Integer getProdMetal() {
		return prodMetal;
	}

	public static Integer getProdCristal() {
		return prodCristal;
	}

	public static Integer getProdDeuterio() {
		return prodDeuterio;
	}
	
	public static List<String> getObjetosList() {
		return objetosList;
	}
	
	public static HashMap<String, Objetos> getObjetosMap() {
		return objetosMap;
	}
	public static void setObjetosMap(HashMap<String, Objetos> objetosMap) {
		Recursos.objetosMap = objetosMap;
	}
	public String getMinaMetal() {
		return minaMetal;
	}
	public String getMinaCristal() {
		return minaCristal;
	}
	public String getMinaDeuterio() {
		return minaDeuterio;
	}
	public String getMinaSolar() {
		return minaSolar;
	}
	public String getFusion() {
		return fusion;
	}
	public String getSatelite() {
		return satelite;
	}
	public String getAlmacenMetal() {
		return almacenMetal;
	}
	public String getAlmacenCristal() {
		return almacenCristal;
	}
	public String getAlmacenDeuterio() {
		return almacenDeuterio;
	}
	public String getEsconditeMetal() {
		return esconditeMetal;
	}
	public String getEsconditeCristal() {
		return esconditeCristal;
	}
	public String getEsconditeDeuterio() {
		return esconditeDeuterio;
	}
	
	public void setObjetosList() {
		List<String> aux = new ArrayList<String>();
		aux.add(getMinaMetal());
		aux.add(getMinaCristal());
		aux.add(getMinaDeuterio());
		aux.add(getMinaSolar());
		aux.add(getFusion());
		aux.add(getSatelite());
		aux.add(getAlmacenMetal());
		aux.add(getAlmacenCristal());
		aux.add(getAlmacenDeuterio());
		aux.add(getEsconditeMetal());
		aux.add(getEsconditeCristal());
		aux.add(getEsconditeDeuterio());
		Recursos.objetosList = aux;
	}
	
//	public void setWebElements(WebDriver driver) {
//		goTo(driver, params.getRecursos());
//		List<WebElement> elements = driver.findElements(By.id("details"));
//		HashMap<String,Objetos> map = new HashMap<String,Objetos>();
//		Objetos obj = new Objetos();
//		int i = 0;
//		for (WebElement element : elements) {
//			obj.setWebElement(element);
//			String nombre = getObjetosList().get(i);
//			map.put(nombre, obj);
//		}
//		Recursos2.objetosMap = map;
//	}
	
	public void setWebElement(WebDriver driver, String cual) {
		Integer index = getObjetosMap().get(cual).getIndex();
		getObjetosMap().get(cual).setWebElement(driver.findElements(By.id("details")).get(index));
	}
	
	public WebElement findContent(WebDriver driver) {
		return driver.findElement(By.id("content"));
	}
	
	public Double setTiempoRequerido(String nombre) {
		// Pasar primero por instalaciones
		Integer tir = getObjetosMap().get(nombre).getTiempoInicialRequerido();
		Integer nivel = getObjetosMap().get(nombre).getNivel();
		Integer nivelRobots = Instalaciones.getObjetosMap().get(instl.getRobots()).getNivel();
		Double constante = getObjetosMap().get(nombre).getConstante();
		return tir*Math.pow(constante, nivel)/(nivelRobots+1);
	}
	
	public void setIndexes() {
		setObjetosList();
		HashMap<String, Objetos> map = new HashMap<String, Objetos>();
		for (int i=0; i< Recursos.getObjetosList().size(); i++) {
			Objetos obj = new Objetos();
			String nombre = getObjetosList().get(i);
			obj.setIndex(i);
			map.put(nombre, obj);
		}
		
		Recursos.objetosMap = map; 
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
	
	public void setObjetoCD(WebDriver driver, String nombre, Integer tiempoInicial) {
		setWebElement(driver, nombre);
		Objetos obj = getObjetosMap().get(nombre);
		WebElement objElement = obj.getWebElement();
		objElement.click();
		WebElement content = findContent(driver);
		obj.setNombre(nombre);
		obj.setCristalRequerido(Integer.parseInt(content.findElement(By.className("crystal")).findElement(By.className("cost")).getText().replace(".", "").replace("M", "000000")));
		obj.setDeuterioRequerido(Integer.parseInt(content.findElement(By.className("deuterium")).findElement(By.className("cost")).getText().replace(".", "").replace("M", "000000")));
		obj.setTiempoInicialRequerido(tiempoInicial);
		obj.setNivel(Integer.parseInt(content.findElement(By.className("level")).getText().replace("Nivel ","").replace("Número: ","")));
		obj.setTiempoRequerido(setTiempoRequerido(nombre));
	}
	
	public void setObjetoM(WebDriver driver, String nombre, Integer tiempoInicial) {
		setWebElement(driver, nombre);
		Objetos obj = getObjetosMap().get(nombre);
		WebElement objElement = obj.getWebElement();
		objElement.click();
		WebElement content = findContent(driver);
		obj.setNombre(nombre);
		obj.setMetalRequerido(Integer.parseInt(content.findElement(By.className("metal")).findElement(By.className("cost")).getText().replace(".", "").replace("M", "000000")));
		obj.setTiempoInicialRequerido(tiempoInicial);
		obj.setNivel(Integer.parseInt(content.findElement(By.className("level")).getText().replace("Nivel ","")));
		obj.setTiempoRequerido(setTiempoRequerido(nombre));
	}
	
	public void setObjetos(WebDriver driver) {
		// Buscar los WebElements primero
		goTo(driver, params.getRecursos());
		setIndexes();
		setObjetoMC(driver, getMinaMetal(), 15);
		setObjetoMC(driver, getMinaCristal(), 14);
		setObjetoMC(driver, getMinaDeuterio(), 61);
		setObjetoMC(driver, getMinaSolar(), 21);
		setObjetoMCD(driver, getFusion(), 259);
		setObjetoCD(driver, getSatelite(), 0);
		setObjetoM(driver, getAlmacenMetal(), 205);
		setObjetoMC(driver, getAlmacenCristal(), 308);
		setObjetoMC(driver, getAlmacenDeuterio(), 411);
		setObjetoM(driver, getEsconditeMetal(), 454);
		setObjetoMC(driver, getEsconditeCristal(), 816);
		setObjetoMC(driver, getEsconditeDeuterio(), 1088);
		setProducciones(driver);
	}
	
	public boolean puedoSubirlo (WebDriver driver, String cual) {
		pageVG.setResources(driver);
		setObjetos(driver);
		Integer metal = getMetal() - getObjetosMap().get(cual).getMetalRequerido();
		Integer cristal = getCristal() - getObjetosMap().get(cual).getCristalRequerido();
		Integer deuterio = getDeuterio() - getObjetosMap().get(cual).getDeuterioRequerido();
		if (metal >=0 && cristal>=0 && deuterio >=0) {
			return true;
		} else {
			System.out.println(cual.toUpperCase());
			System.out.println("Metal: " + metal);
			System.out.println("Cristal: " + cristal);
			System.out.println("Deuterio: " + deuterio);
			return false;
		}
	}
	
	public void subir(WebDriver driver, String cual) throws InterruptedException {
		goTo(driver, params.getRecursos());
		setWebElement(driver, cual);
		getObjetosMap().get(cual).getWebElement().click();
		findContent(driver).findElement(By.className("build-it")).click();
		Thread.sleep((long) (getObjetosMap().get(cual).getTiempoRequerido()*1000));
	}
	
	public void setProducciones(WebDriver driver) {
		List<WebElement> producciones = driver.findElements(By.className("label"));
		for (WebElement minas : producciones) {
			if (minas.getText().contains("Mina de metal")) {
				Recursos.prodMetal = 60 + Integer.parseInt(minas.findElements(By.tagName("span")).get(3).getText().replace(".", ""));
			} else if (minas.getText().contains("Mina de cristal")) {
				Recursos.prodCristal = 30 + Integer.parseInt(minas.findElements(By.tagName("span")).get(3).getText().replace(".", ""));
			} else if (minas.getText().contains("Sintetizador de deuterio")) {
				Recursos.prodDeuterio = 1 + Integer.parseInt(minas.findElements(By.tagName("span")).get(3).getText().replace(".", ""));
			}
		}
	}
	
	public boolean convieneMetal() {
		Integer metal = getObjetosMap().get(getMinaMetal()).getMetalRequerido() + getObjetosMap().get(getMinaCristal()).getMetalRequerido() + getObjetosMap().get(getMinaSolar()).getMetalRequerido();
		Integer cristal = getObjetosMap().get(getMinaMetal()).getCristalRequerido() + getObjetosMap().get(getMinaCristal()).getCristalRequerido() + getObjetosMap().get(getMinaSolar()).getCristalRequerido();
		Double mc = (double) ((metal - getMetal())/getProdMetal()); 
		Double cc = (double) ((cristal - getCristal()) / getProdCristal());
		if (mc > cc) {
			System.out.println("Se intentara subir " + getMinaMetal());
			return true;
		} else {
			System.out.println(getMinaMetal().toUpperCase());
			System.out.println("No conviene subir " + getMinaMetal());
		return false;
		}
	}
	
	public boolean convieneCristal() {
		if (convieneMetal()) {
			System.out.println(getMinaCristal().toUpperCase());
			System.out.println("No conviene subir " + getMinaCristal());
			return false;
		} else {
			System.out.println("Se intentara subir " + getMinaCristal());
			return true;
		}
	}
	
	public boolean convieneDeuterio() {
		Integer NivMet = getObjetosMap().get(getMinaMetal()).getNivel();
		Integer NivCris = getObjetosMap().get(getMinaCristal()).getNivel();
		Integer NivDeu = getObjetosMap().get(getMinaDeuterio()).getNivel();
		if (NivDeu < (NivMet + NivCris)/10) {
			System.out.println("Se intentara subir " + getMinaDeuterio());
			return true;
		} else {
			System.out.println(getMinaDeuterio().toUpperCase());
			System.out.println("No conviene subir " + getMinaDeuterio());
			return false;
		}
	}
	
	public boolean convieneSolar() {
		if (pageVG.getEnergia() < 0) {
			System.out.println("Se intentara subir " + getMinaSolar());
			return true;
		} else {
			System.out.println(getMinaSolar().toUpperCase());
			System.out.println("No conviene subir " + getMinaSolar());
			return false;
		}
	}

}
