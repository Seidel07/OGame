//package Ogame.ogame.pageobject;
//
//import java.util.HashMap;
//import java.util.List;
//
//import Ogame.ogame.parameters.Parameters;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//
//public class Recursos extends AllPages{
//	
//	Parameters params = new Parameters();
//
//	private HashMap<String,Mina> Minas;
//	private final String metalMine = "Mina de metal";
//	private final String cristalMine = "Mina de cristal";
//	private final String deuterioMine = "Sintetizador de deuterio";
//	private final String energiaSolarMine = "Planta de energía solar";
//	private final String metalAlmacen = "Almacén de metal";
//	private final String cristalAlmacen = "Almacén de cristal";
//	private final String deuterioalmacen = "Contenedor de deuterio";
//	private String duracion;
//	private String energiaNecesaria;
//	private static Integer produccionMetal;
//	private static Integer produccionCristal;
//	private static Integer produccionDeuterio;
//	private static Integer capacidadMetal;
//	private static Integer capacidadCristal;
//	private static Integer capacidadDeuterio;
//	
//	public Integer getCapacidadMetal() {
//		return capacidadMetal;
//	}
//
//	public void setCapacidadMetal(WebDriver driver) {
//		List<WebElement> recursos = driver.findElements(By.id("details")); 
//		for (WebElement instalacion : recursos) {
//			instalacion.click();
//			if (driver.findElement(By.id("content")).getText().contains(params.getAlmacenMetal())) {
//				Recursos.capacidadMetal = Integer.parseInt(driver.findElement(By.id("maxresources")).getText().replace(".", ""));
//				break;
//			}
//		}
//	}
//	
//	public Integer getCapacidadCristal() {
//		return capacidadCristal;
//	}
//
//	public void setCapacidadCristal(WebDriver driver) {
//		List<WebElement> recursos = driver.findElements(By.id("details")); 
//		for (WebElement instalacion : recursos) {
//			instalacion.click();
//			if (driver.findElement(By.id("content")).getText().contains("Almacén de cristal")) {
//				Recursos.capacidadCristal = Integer.parseInt(driver.findElement(By.id("maxresources")).getText().replace(".", ""));
//			}
//		}
//	}
//
//	public Integer getCapacidadDeuterio() {
//		return capacidadDeuterio;
//	}
//
//	public void setCapacidadDeuterio(WebDriver driver) {
//		List<WebElement> recursos = driver.findElements(By.id("details")); 
//		for (WebElement instalacion : recursos) {
//			instalacion.click();
//			if (driver.findElement(By.id("content")).getText().contains("Contenedor de deuterio")) {
//				Recursos.capacidadDeuterio = Integer.parseInt(driver.findElement(By.id("maxresources")).getText().replace(".", ""));
//			}
//		}
//	}
//
//
//
//	public HashMap<String, Mina> getMinas() {
//		return Minas;
//	}
//
//	public void setMinas(HashMap<String, Mina> minas) {
//		Minas = minas;
//	}
//
//	public String getMetalMine() {
//		return metalMine;
//	}
//
//	public String getCristalMine() {
//		return cristalMine;
//	}
//
//	public String getDeuterioMine() {
//		return deuterioMine;
//	}
//
//	public String getEnergiaSolarMine() {
//		return energiaSolarMine;
//	}
//	
//	public String getDuracion() {
//		return duracion;
//	}
//
//	public String getEnergiaNecesaria() {
//		return energiaNecesaria;
//	}
//	
//	public void setDuracion(WebDriver driver) {
//		this.duracion = driver.findElement(By.id("buildDuration")).getText();
//	}
//	
//	public void setEnergiaNecesaria(WebDriver driver) {
//		this.energiaNecesaria = driver.findElements(By.className("time")).get(1).getText();
//	}
//	
////	public void setInfo(WebDriver driver) {
////		setDuracion(driver);
////		setEnergiaNecesaria(driver);
////	}
//	
////	public void printInfo() {
////		System.out.println("Duracion: " + getDuracion());
////		System.out.println("Energia necesaria: " + getEnergiaNecesaria());
////	}
//
//	
//	
//	public void subir(WebDriver driver, String what) throws InterruptedException {
//		List<WebElement> recursos = driver.findElements(By.id("details")); 
//		for (WebElement instalacion : recursos) {
//			instalacion.click();
//			if (driver.findElement(By.id("content")).getText().contains(what)) {
////				setInfo(driver);
//				driver.findElement(By.className("build-it")).click();
////				printInfo();
//				break;
//			}
//		}
//	}
//	
//	public String getMetalAlmacen() {
//		return metalAlmacen;
//	}
//
//	public String getCristalAlmacen() {
//		return cristalAlmacen;
//	}
//
//	public String getDeuterioalmacen() {
//		return deuterioalmacen;
//	}
//	
//	public Integer getProduccionMetal() {
//		return produccionMetal;
//	}
//
//	public Integer getProduccionCristal() {
//		return produccionCristal;
//	}
//
//	public Integer getProduccionDeuterio() {
//		return produccionDeuterio;
//	}
//
//	
//	public void setValues(WebDriver driver) {
//		List<WebElement> recursos = driver.findElements(By.id("details"));
//		HashMap<String,Mina> map = new HashMap<String, Mina>();
//		int i = 0;
//		for (WebElement instalacion : recursos) {
//			instalacion.click();
//			Mina mina = new Mina();
//			mina.setNombre(driver);
//			mina.setNivel(driver);
//			mina.setMetalRequerido(driver);
//			mina.setCristalRequerido(driver);
//			mina.setSegundosInicialRequerido(mina.getNombre());
//			mina.setConstant(mina.getNombre());
//			mina.setSegundosRequeridos(mina.getNombre());
//			map.put(params.getElementos().get(i), mina);
//			i = i+1;
//			if (i == 4) {
//				break;
//			}
//		setMinas(map);
//		}
//	}
//	
//	public void printValues(String mina) {
//		System.out.println("Constante " + getMinas().get(mina).getConstant());
//		System.out.println("Nivel " + getMinas().get(mina).getNivel());
//		System.out.println("Metal requerido" + getMinas().get(mina).getMetalRequerido());
//		System.out.println("Cristal requerido " + getMinas().get(mina).getCristalRequerido());
//		System.out.println("Segundos requeridos " + getMinas().get(mina).getSegundosRequeridos());
//	}
//	
//	public void setProducciones(WebDriver driver) {
//		List<WebElement> producciones = driver.findElements(By.className("label"));
//		for (WebElement minas : producciones) {
//			if (minas.getText().contains("Mina de metal")) {
//				Recursos.produccionMetal = Integer.parseInt(minas.findElements(By.tagName("span")).get(3).getText().replace(".", ""));
//			} else if (minas.getText().contains("Mina de cristal")) {
//				Recursos.produccionCristal = Integer.parseInt(minas.findElements(By.tagName("span")).get(3).getText().replace(".", ""));
//			} else if (minas.getText().contains("Sintetizador de deuterio")) {
//				Recursos.produccionDeuterio = Integer.parseInt(minas.findElements(By.tagName("span")).get(3).getText().replace(".", ""));
//			}
//		}
//	}
//	
//	public void printProducciones(){
//		System.out.println(produccionMetal);
//		System.out.println(produccionCristal);
//		System.out.println(produccionDeuterio);
//	}
//	
//	public boolean convieneMetal(WebDriver driver, VisionGeneral pageVG) {
//		List<WebElement> recursos = driver.findElements(By.id("details"));
//		Double metal = 0.0;
//		Double cristal = 0.0;
//		int i = 0;
//		for (WebElement instalacion : recursos) {
//			if (i==0 || i ==1 || i ==3) {
//				instalacion.click();
//				metal = metal + getMinas().get(params.getElementos().get(i)).getMetalRequerido();
//				cristal = cristal + getMinas().get(params.getElementos().get(i)).getCristalRequerido();
//			}
//			i = i+1;
//			if (i ==4) {
//				break;
//			}
//		}
//		metal = (metal - pageVG.getMetal()) / getProduccionMetal();
//		cristal = (cristal - pageVG.getCristal()) / getProduccionCristal();
//		if (metal > cristal) {
//			return true;
//		} else {
//			return false;
//		}
//	}
//	
//	public boolean convieneAlmacenMetal(WebDriver driver) {
//		List<WebElement> recursos = driver.findElements(By.id("details"));
//		int i=0;
//		Integer metal = 0;
//		setCapacidadMetal(driver);
//		for (WebElement instalacion : recursos) {
//			if (i==0 || i ==1 || i==3) {
//				instalacion.click();
//				Integer metal1 = getMinas().get(params.getElementos().get(i)).getMetalRequerido();
//				if (metal1 > metal) {
//					metal = metal1;
//				}
//			}
//			if (i==3) {
//				break;
//			}
//			i = i+1;
//		}
//		if (metal > getCapacidadMetal()) {
//			return true;
//		} else {
//			return false;
//		}
//	}
//	
//	public boolean convieneAlmacenCristal(WebDriver driver) {
//		List<WebElement> recursos = driver.findElements(By.id("details"));
//		int i=0;
//		Integer cristal = 0;
//		setCapacidadCristal(driver);
//		for (WebElement instalacion : recursos) {
//			if (i==0 || i ==1 || i==3) {
//				instalacion.click();
//				Integer cristal1 = getMinas().get(params.getElementos().get(i)).getCristalRequerido();
//				if (cristal1 > cristal) {
//					cristal = cristal1;
//				}
//			}
//			if (i==3) {
//				break;
//			}
//			i = i+1;
//		}
//		if (cristal > getCapacidadCristal()) {
//			return true;
//		} else {
//			return false;
//		}
//	
//	}
//
//	public boolean convieneDeuterio(WebDriver driver) {
//		int n = (getMinas().get(params.getElementos().get(0)).getNivel() + getMinas().get(params.getElementos().get(1)).getNivel())/10;
//		if (n>(getMinas().get(params.getElementos().get(2)).getNivel())) {
//			return true;
//		} else {
//			return false;
//		}
//	}
//}
