//package ogame.ogame.pageobject.recursos;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//
//import ogame.ogame.pageobject.AllPages;
//import ogame.ogame.pageobject.VisionGeneral;
//import ogame.ogame.parameters.Parameters;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//
//public class Recursos extends AllPages{
//	
//	Parameters params = new Parameters();
//
//	private HashMap<String,Mina> minas;
//	
//	private final String minaMetal = "Mina de metal";
//	private final String minaCristal = "Mina de cristal";
//	private final String minaDeuterio = "Sintetizador de deuterio";
//	private final String minaSolar = "Planta de energía solar";
//	private final String fusion = "Planta de fusión";
//	private final String satelite = "Satélite solar";
//	private final String almacenMetal = "Almacén de metal";
//	private final String almacenCristal = "Almacén de cristal";
//	private final String almacenDeuterio = "Contenedor de deuterio";
//	private final String esconditeMetal = "Escondite blindado de metal";
//	private final String esconditeCristal = "Escondite subterráneo de cristal";
//	private final String esconditeDeuterio = "Escondite marítimo de deuterio";
//	private static List<String> objetos;
//	
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
//	public String getMinaMetal() {
//		return minaMetal;
//	}
//
//	public String getMinaCristal() {
//		return minaCristal;
//	}
//
//	public String getMinaDeuterio() {
//		return minaDeuterio;
//	}
//
//	public String getMinaSolar() {
//		return minaSolar;
//	}
//
//	public String getFusion() {
//		return fusion;
//	}
//
//	public String getSatelite() {
//		return satelite;
//	}
//
//	public String getAlmacenMetal() {
//		return almacenMetal;
//	}
//
//	public String getAlmacenCristal() {
//		return almacenCristal;
//	}
//
//	public String getAlmacenDeuterio() {
//		return almacenDeuterio;
//	}
//
//	public String getEsconditeMetal() {
//		return esconditeMetal;
//	}
//
//	public String getEsconditeCristal() {
//		return esconditeCristal;
//	}
//
//	public String getEsconditeDeuterio() {
//		return esconditeDeuterio;
//	}
//
//	public static List<String> getObjetos() {
//		return objetos;
//	}
//
//	public Integer getCapacidadCristal() {
//		return capacidadCristal;
//	}
//
//	public Integer getCapacidadDeuterio() {
//		return capacidadDeuterio;
//	}
//
//	public HashMap<String, Mina> getMinas() {
//		return minas;
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
//	public void setMinas(HashMap<String, Mina> minas) {
//		this.minas = minas;
//	}
//
//	public void subir(WebDriver driver, String what) throws InterruptedException {
//		List<WebElement> recursos = driver.findElements(By.id("details")); 
//		for (WebElement instalacion : recursos) {
//			instalacion.click();
//			if (driver.findElement(By.id("content")).getText().contains(what)) {
//				driver.findElement(By.className("build-it")).click();
//				break;
//			}
//		}
//	}
//	
//	public void setValues(WebDriver driver) {
//		List<WebElement> recursos = driver.findElements(By.id("details"));
//		HashMap<String,Mina> map = new HashMap<String, Mina>();
//		int i = 0;
//		for (WebElement instalacion : recursos) {
//			instalacion.click();
//			Mina mina = new Mina();
//			mina.setNombre(driver,i);
//			mina.setNivel(driver);
//			mina.setMetalRequerido(driver);
//			mina.setCristalRequerido(driver);
//			mina.setSegundosInicialRequerido(mina.getNombre());
//			mina.setConstant(mina.getNombre());
//			mina.setSegundosRequeridos(mina.getNombre());
////			map.put(params.getElementos().get(i), mina);
//			i = i+1;
//			if (i == 4) {
//				break;
//			}
//		setMinas(map);
//		}
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
//	public boolean convieneMetal(WebDriver driver, VisionGeneral pageVG) { 
//		//Revisar que se haya ejecutado setValues
//		// Revisar que se haya ejecutado setProducciones
//		// Revisar que se haya ejecutado set Resources
//		List<WebElement> recursos = driver.findElements(By.id("details")); 
//		Double metal = 0.0;													
//		Double cristal = 0.0;
//		int i = 0;
//		for (WebElement instalacion : recursos) {
//			if (i==0 || i ==1 || i ==3) {
//				instalacion.click();
////				metal = metal + getMinas().get(params.getElementos().get(i)).getMetalRequerido();
////				cristal = cristal + getMinas().get(params.getElementos().get(i)).getCristalRequerido();
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
//	public boolean convieneCristal(WebDriver driver, VisionGeneral pageVG) {
//		if (convieneMetal(driver, pageVG)) {
//			return false;
//		} else {
//			return true;
//		}
//	}
//	
//	public boolean convieneAlmacenMetal(WebDriver driver) {
//		// Revisar que se haya ejecutado setValues
////		List<WebElement> recursos = driver.findElements(By.id("details"));
////		int i=0;
//		Integer metal = 0;
//		setCapacidadMetal(driver);
////		for (WebElement instalacion : recursos) {
//		for (int i = 0; i<4 ; i++) {
//			if (i==0 || i ==1 || i==3) {
////				instalacion.click();
////				Integer metal1 = getMinas().get(params.getElementos().get(i)).getMetalRequerido();
////				if (metal1 > metal) {
////					metal = metal1;
//				}
//			}
////			if (i==3) {
////				break;
////			}
////			i = i+1;
//		}
////		if (metal > getCapacidadMetal()) {
////			return true;
////		} else {
////			return false;
//		}
//	}
//	
//	public boolean convieneAlmacenCristal(WebDriver driver) {
//		// Revisar que se haya ejecutado setValues
////		List<WebElement> recursos = driver.findElements(By.id("details"));
////		int i=0;
//		Integer cristal = 0;
//		setCapacidadCristal(driver);
////		for (WebElement instalacion : recursos) {
//		for (int i = 0; i < 4; i++) {
//			if (i==0 || i ==1 || i==3) {
////				instalacion.click();
//				Integer cristal1 = getMinas().get(params.getElementos().get(i)).getCristalRequerido();
//				if (cristal1 > cristal) {
//					cristal = cristal1;
//				}
//			}
////			if (i==3) {
////				break;
////			}
////			i = i+1;
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
//	public void setObjetos(){
//		List<String> aux = new ArrayList<String>();
//		aux.add(getMinaMetal()); //0
//		aux.add(getMinaCristal()); //1
//		aux.add(getMinaDeuterio()); //2
//		aux.add(getMinaSolar()); //3
//		aux.add(getFusion()); //4
//		aux.add(getSatelite()); //5
//		aux.add(getAlmacenMetal()); //6
//		aux.add(getAlmacenCristal()); //7
//		aux.add(getAlmacenDeuterio()); //8
//		aux.add(getEsconditeMetal()); //9
//		aux.add(getEsconditeCristal()); // 10
//		aux.add(getEsconditeDeuterio()); //11
//		this.objetos = aux;
//	}
//
//
//}
