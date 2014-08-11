package ogame.ogame.pageobject.investigacion;

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
import ogame.ogame.parameters.Parameters;

public class Investigacion extends AllPages{
	
	Instalaciones instl = new Instalaciones();
	Parameters params = new Parameters();
	VisionGeneral pageVG = new VisionGeneral();
	InvElementsID investigacionId = new InvElementsID();
	
	private final String tEnergia = "Tecnología de energía";
	private final String laser = "Tecnología láser";
	private final String ionica = "Tecnología iónica";
	private final String hiperespacio = "Tecnología de hiperespacio";
	private final String plasma = "Tecnología de plasma";
	private final String combustion = "Motor de combustion";
	private final String impulso = "Motor de impulso";
	private final String hiperespacial = "Propulsor hiperespacial";
	private final String espionaje = "Tecnología de espionaje";
	private final String computacion = "Tecnología de computacion";
	private final String astrofisica = "Astrofísica";
	private final String intergalactica = "Red de investigación intergaláctica";
	private final String graviton = "Tecnología de graviton";
	private final String militar = "Tecnología militar";
	private final String defensa = "Tecnología de defensa";
	private final String blindaje = "Tecnología de blindaje";
	private static List<String> objetosList;
	private static HashMap<String, Objetos> objetosMap;

	public static List<String> getObjetosList() {
		return objetosList;
	}
	public static void setObjetosList(List<String> objetosList) {
		Investigacion.objetosList = objetosList;
	}
	public static HashMap<String, Objetos> getObjetosMap() {
		return objetosMap;
	}
	public static void setObjetosMap(HashMap<String, Objetos> objetosMap) {
		Investigacion.objetosMap = objetosMap;
	}
	public String getTEnergia() {
		return tEnergia;
	}
	public String getLaser() {
		return laser;
	}
	public String getIonica() {
		return ionica;
	}
	public String getHiperespacio() {
		return hiperespacio;
	}
	public String getPlasma() {
		return plasma;
	}
	public String getCombustion() {
		return combustion;
	}
	public String getImpulso() {
		return impulso;
	}
	public String getHiperespacial() {
		return hiperespacial;
	}
	public String getEspionaje() {
		return espionaje;
	}
	public String getComputacion() {
		return computacion;
	}
	public String getAstrofisica() {
		return astrofisica;
	}
	public String getIntergalactica() {
		return intergalactica;
	}
	public String getGraviton() {
		return graviton;
	}
	public String getMilitar() {
		return militar;
	}
	public String getDefensa() {
		return defensa;
	}
	public String getBlindaje() {
		return blindaje;
	}
	
	public void setObjetosList() {
		List<String> aux = new ArrayList<String>();
		aux.add(getTEnergia()); //0
		aux.add(getLaser()); // 1
		aux.add(getIonica()); //2
		aux.add(getHiperespacio()); //3
		aux.add(getPlasma()); //4
		aux.add(getCombustion()); //5
		aux.add(getImpulso()); //6
		aux.add(getHiperespacial()); // 7
		aux.add(getEspionaje()); // 8
		aux.add(getComputacion()); // 9
		aux.add(getAstrofisica()); // 10
		aux.add(getIntergalactica()); // 11
		aux.add(getGraviton()); // 12
		aux.add(getMilitar()); // 13
		aux.add(getDefensa()); // 14
		aux.add(getBlindaje()); // 15
		Investigacion.objetosList = aux;
	}
	
	public void setIndexes() {
		setObjetosList();
		HashMap<String, Objetos> map = new HashMap<String, Objetos>();
		for (int i=0; i< getObjetosList().size(); i++) {
			Objetos obj = new Objetos();
			String nombre = getObjetosList().get(i);
			obj.setIndex(i);
			map.put(nombre, obj);
		}
		setObjetosMap(map);
	}
	
	public void setWebElement(WebDriver driver, String cual) {
		Integer index = getObjetosMap().get(cual).getIndex();
		getObjetosMap().get(cual).setWebElement(driver.findElement(By.id(InvElementsID.getIdElements().get(index))));
	}
	
	public WebElement findContent(WebDriver driver) {
		return driver.findElement(By.id("content"));
	}
	
	public Double setTiempoRequerido(String nombre) {
		Integer tiempoInicialRequerido = getObjetosMap().get(nombre).getTiempoInicialRequerido();
		Integer nivel = getObjetosMap().get(nombre).getNivel();
		Integer nivelInvestigacion = Instalaciones.getObjetosMap().get(instl.getInvestigacion()).getNivel();
		Double constante = getObjetosMap().get(nombre).getConstante();
		return tiempoInicialRequerido*Math.pow(constante, nivel)/(nivelInvestigacion+1);
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
	
	public void setObjetoMD(WebDriver driver, String nombre, Integer tiempoInicial) {
		setWebElement(driver, nombre);
		Objetos obj = getObjetosMap().get(nombre);
		WebElement objElement = obj.getWebElement();
		objElement.click();
		WebElement content = findContent(driver);
		obj.setNombre(nombre);
		obj.setMetalRequerido(Integer.parseInt(content.findElement(By.className("metal")).findElement(By.className("cost")).getText().replace(".", "").replace("M", "000000")));
		obj.setDeuterioRequerido(Integer.parseInt(content.findElement(By.className("deuterium")).findElement(By.className("cost")).getText().replace(".", "").replace("M", "000000")));
		obj.setTiempoInicialRequerido(tiempoInicial);
		obj.setNivel(Integer.parseInt(content.findElement(By.className("level")).getText().replace("Nivel ","")));
		obj.setTiempoRequerido(setTiempoRequerido(nombre));
	}
	
	public void setObjetos (WebDriver driver) {
		setIndexes();
		setObjetoCD(driver, getTEnergia(), 24*60);
		setObjetoMC(driver, getLaser(), 9*60);
		setObjetoMCD(driver, getIonica(), 39*60);
		setObjetoCD(driver, getHiperespacio(), 2*3600);
		setObjetoMCD(driver, getPlasma(), 3*3600);
		setObjetoMD(driver, getCombustion(), 12*60);
		setObjetoMCD(driver, getImpulso(), 3*3600);
		setObjetoMCD(driver, getHiperespacial(), 3*3600);
		setObjetoMCD(driver, getEspionaje(), 36*60);
		setObjetoCD(driver, getComputacion(), 12*60);
		setObjetoMCD(driver, getAstrofisica(), 6*3600);
		setObjetoMCD(driver, getIntergalactica(), 1*7*24*3600 + 6*24*3600 + 8*3600);
		setObjetoM(driver, getGraviton(), 1);
		setObjetoMC(driver, getMilitar(), 30*60);
		setObjetoMC(driver, getDefensa(), 24*60);
		setObjetoM(driver, getBlindaje(), 30*60);
	}
	
	public boolean puedoSubirlo (WebDriver driver, String cual) {
		goTo(driver, params.getInvestigacion());
//		setObjetos(driver);
		pageVG.setResources(driver);
		Integer metal = getMetal() - getObjetosMap().get(cual).getMetalRequerido();
		Integer cristal = getCristal() - getObjetosMap().get(cual).getCristalRequerido();
		Integer deuterio = getDeuterio() - getObjetosMap().get(cual).getDeuterioRequerido();
		System.out.println(cual.toUpperCase());
		if (metal >=0 && cristal>=0 && deuterio >=0) {
			System.out.println("Es posible subir " + cual);
			return true;
		} else {
			System.out.println("No se puede subir " + cual);
			return false;
		}
	}
	
	public void subir(WebDriver driver, String cual) throws InterruptedException {
		goTo(driver, params.getInvestigacion());
		setWebElement(driver, cual);
		getObjetosMap().get(cual).getWebElement().click();
		findContent(driver).findElement(By.className("build-it")).click();
	}
	
//	public boolean sePuedeConstruir(WebDriver driver) {
//		goTo(driver, params.getInvestigacion());
//		driver.findElement(By.id("details113")).click();
//		WebElement buildIt = driver.findElement(By.className("build-it_wrap"));
//		if (buildIt.getText() == "Investigar") {
//			return true;
//		} else {
//			return false;
//		}
//	}
	
}
