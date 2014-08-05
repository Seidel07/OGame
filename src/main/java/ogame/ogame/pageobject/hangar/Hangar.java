package ogame.ogame.pageobject.hangar;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import ogame.ogame.pageobject.AllPages;
import ogame.ogame.pageobject.Objetos;
import ogame.ogame.pageobject.VisionGeneral;
import ogame.ogame.pageobject.instalaciones.Instalaciones;
import ogame.ogame.pageobject.recursos.Recursos;
import ogame.ogame.parameters.Parameters;

public class Hangar extends AllPages{
	
	Instalaciones instl = new Instalaciones();
	Parameters params = new Parameters();
	VisionGeneral pageVG = new VisionGeneral();
	
	private final String ligero = "Cazador ligero";
	private final String pesado = "Cazador pesado";
	private final String crucero = "Crucero";
	private final String batalla = "Nave de batalla";
	private final String pequena = "Nave pequeña de carga";
	private final String grande = "Nave grande de carga";
	private final String colonizador = "Nave colonizadora";
	private final String acorazado = "Acorazado";
	private final String bombardero = "Bombardero";
	private final String destructor = "Destructor";
	private final String estrella = "Estrella de la muerte";
	private final String reciclador = "Reciclador";
	private final String sonda = "Sonda de espionaje";
	private final String satelite = "Satélite solar";
	private static List<String> objetosList;
	private static HashMap<String, Objetos> objetosMap;
	
	public static List<String> getObjetosList() {
		return objetosList;
	}
	public void setObjetosList() {
		List<String> aux = new ArrayList<String>();
		aux.add(getPequena()); // 202
		aux.add(getGrande()); // 203
		aux.add(getLigero()); // 204
		aux.add(getPesado()); // 205
		aux.add(getCrucero()); // 206
		aux.add(getBatalla()); // 207
		aux.add(getColonizador());  // 208
		aux.add(getReciclador()); // 209
		aux.add(getSonda()); // 210
		aux.add(getBombardero()); // 211
		aux.add(getSatelite()); // 212
		aux.add(getDestructor()); // 213
		aux.add(getEstrella()); // 214
		aux.add(getAcorazado()); // 215
		Hangar.objetosList = aux;		
	}
	public static HashMap<String, Objetos> getObjetosMap() {
		return objetosMap;
	}
	public static void setObjetosMap(HashMap<String, Objetos> objetosMap) {
		Hangar.objetosMap = objetosMap;
	}
	public String getLigero() {
		return ligero;
	}
	public String getPesado() {
		return pesado;
	}
	public String getCrucero() {
		return crucero;
	}
	public String getBatalla() {
		return batalla;
	}
	public String getPequena() {
		return pequena;
	}
	public String getGrande() {
		return grande;
	}
	public String getColonizador() {
		return colonizador;
	}
	public String getAcorazado() {
		return acorazado;
	}
	public String getBombardero() {
		return bombardero;
	}
	public String getDestructor() {
		return destructor;
	}
	public String getEstrella() {
		return estrella;
	}
	public String getReciclador() {
		return reciclador;
	}
	public String getSonda() {
		return sonda;
	}
	public String getSatelite() {
		return satelite;
	}
	
	public void setWebElement(WebDriver driver, String cual) {
		Integer index = getObjetosMap().get(cual).getIndex();
		Integer elem = index + 202;
		getObjetosMap().get(cual).setWebElement(driver.findElement(By.id("details" + elem)));
	}
	
	public WebElement findContent(WebDriver driver) {
		return driver.findElement(By.id("content"));
	}
	
	public Double setTiempoRequerido(String nombre) {
		Integer tir = getObjetosMap().get(nombre).getTiempoInicialRequerido();
		Integer nivelHangar = Instalaciones.getObjetosMap().get(instl.getHangar()).getNivel();
		return (double) (tir/(nivelHangar+1));
	}
	
	public void setIndexes() {
		// Solo es necesario realizarlo una vez
		setObjetosList();
		HashMap<String, Objetos> map = new HashMap<String, Objetos>();
		for (int i=0; i< Recursos.getObjetosList().size(); i++) {
			Objetos obj = new Objetos();
			String nombre = getObjetosList().get(i);
			obj.setIndex(i);
			map.put(nombre, obj);
		}
		
		Hangar.objetosMap = map; 
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
		obj.setNivel(Integer.parseInt(content.findElement(By.className("level")).getText().replace("Número: ","")));
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
		obj.setNivel(Integer.parseInt(content.findElement(By.className("level")).getText().replace("Número: ","")));
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
		obj.setNivel(Integer.parseInt(content.findElement(By.className("level")).getText().replace("Número: ","").replace("Número: ","")));
		obj.setTiempoRequerido(setTiempoRequerido(nombre));
	}
	
	public void setObjetoC(WebDriver driver, String nombre, Integer tiempoInicial) {
		setWebElement(driver, nombre);
		Objetos obj = getObjetosMap().get(nombre);
		WebElement objElement = obj.getWebElement();
		objElement.click();
		WebElement content = findContent(driver);
		obj.setNombre(nombre);
		obj.setMetalRequerido(Integer.parseInt(content.findElement(By.className("crystal")).findElement(By.className("cost")).getText().replace(".", "").replace("M", "000000")));
		obj.setTiempoInicialRequerido(tiempoInicial);
		obj.setNivel(Integer.parseInt(content.findElement(By.className("level")).getText().replace("Número: ","")));
		obj.setTiempoRequerido(setTiempoRequerido(nombre));
	}
	
	public void setObjetos(WebDriver driver) {
		// Buscar los WebElements primero
		goTo(driver, params.getHangar());
		setIndexes();
		setObjetoMC(driver, getLigero(), 15);
		setObjetoMC(driver, getPesado(), 14);
		setObjetoMCD(driver, getCrucero(), 61);
		setObjetoMC(driver, getBatalla(), 21);
		setObjetoMC(driver, getPequena(), 259);
		setObjetoMC(driver, getGrande(), 205);
		setObjetoMCD(driver, getColonizador(), 308);
		setObjetoMCD(driver, getAcorazado(), 411);
		setObjetoMCD(driver, getBombardero(), 454);
		setObjetoMCD(driver, getDestructor(), 816);
		setObjetoMCD(driver, getEstrella(), 1088);
		setObjetoMCD(driver, getReciclador(), 1088);
		setObjetoC(driver, getSonda(), 1088);
		setObjetoCD(driver, getSatelite(), 0);
	}
	
	public boolean puedoCrearlo (WebDriver driver, String cual) {
		pageVG.setResources(driver);
		setObjetos(driver);
		Integer metal = getMetal() - getObjetosMap().get(cual).getMetalRequerido();
		Integer cristal = getCristal() - getObjetosMap().get(cual).getCristalRequerido();
		Integer deuterio = getDeuterio() - getObjetosMap().get(cual).getDeuterioRequerido();
		if (metal >=0 && cristal>=0 && deuterio >=0) {
			System.out.println("Se intentara crear " + cual);
			return true;
		} else {
			System.out.println(cual.toUpperCase());
			System.out.println("Metal: " + metal);
			System.out.println("Cristal: " + cristal);
			System.out.println("Deuterio: " + deuterio);
			return false;
		}
	}
	
	public void crear(WebDriver driver, String cual, Integer cuantos) throws InterruptedException {
		goTo(driver, params.getHangar());
		setWebElement(driver, cual);
		getObjetosMap().get(cual).getWebElement().click();
		findContent(driver).findElement(By.id("number")).sendKeys(cuantos.toString());
		findContent(driver).findElement(By.className("build-it")).click();
		System.out.println("Sleep por: " + getObjetosMap().get(cual).getTiempoRequerido()*cuantos + " segundos");
		Thread.sleep((long) (getObjetosMap().get(cual).getTiempoRequerido()*1000*cuantos));
		System.out.println("Sleep finalizado. Se seguira con el programa");
	}
	
	
	
	

}
