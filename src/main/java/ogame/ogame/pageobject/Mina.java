package ogame.ogame.pageobject;

import ogame.ogame.parameters.Parameters;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Mina {
	
	private String nombre;
	private Integer nivel;
	private Integer metalRequerido;
	private Integer cristalRequerido;
	private Integer deuterioRequerido;
	private Integer segundosRequeridos;
	private Integer energia;
	private Double constant;
	private Integer segundosInicialRequerido;
	
	Parameters params = new Parameters();
	
	public Integer getNivel() {
		return nivel;
	}
	public void setNivel(WebDriver driver) {
		this.nivel = Integer.parseInt(driver.findElement(By.id("content")).findElement(By.className("level")).getText().split(" ")[1]);
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(WebDriver driver) {
		this.nombre = driver.findElement(By.id("content")).getText();
	}
	public Integer getMetalRequerido() {
		return metalRequerido;
	}
	public void setMetalRequerido(WebDriver driver) {
		this.metalRequerido = Integer.parseInt(driver.findElement(By.id("content")).findElement(By.className("metal")).findElement(By.className("cost")).getText().replace(".", ""));
	}
	public Integer getCristalRequerido() {
		return cristalRequerido;
	}
	public void setCristalRequerido(WebDriver driver) {
		this.cristalRequerido = Integer.parseInt(driver.findElement(By.id("content")).findElement(By.className("crystal")).findElement(By.className("cost")).getText().replace(".", ""));
	}
	public Integer getDeuterioRequerido() {
		return deuterioRequerido;
	}
	public void setDeuterioRequerido(Integer deuterioRequerido) {
		this.deuterioRequerido = deuterioRequerido;
	}
	public Integer getSegundosRequeridos() {
		return segundosRequeridos;
	}
	public void setSegundosRequeridos(String mina) {
		this.segundosRequeridos = (int) Math.ceil(getSegundosInicialRequerido()*Math.pow(getConstant(), getNivel()));
	}
	public Integer getEnergia() {
		return energia;
	}
	public void setEnergia(Integer energia) {
		this.energia = energia;
	}
	
	public Double getConstant() {
		return constant;
	}
	public void setConstant(String mina) {
		if (mina.contains("Mina de metal")) {
			constant = 1.5;
		} else if (mina.contains("Mina de cristal")) {
			constant = 1.6;
		} else if (mina.contains("Sintetizador de deuterio")) {
			constant = 2.0;
		} else if (mina.contains("Planta de energía solar")) {
			constant = 1.5;
		} else {
			constant = 0.0;
		}
		
	}
	
	public Integer getSegundosInicialRequerido() {
		return segundosInicialRequerido;
	}
	public void setSegundosInicialRequerido(String mina) {
		if (mina.contains("Mina de metal")) {
			segundosInicialRequerido = 108;
		} else if (mina.contains("Mina de cristal")) {
			segundosInicialRequerido = 103;
		} else if (mina.contains("Sintetizador de deuterio")) {
			segundosInicialRequerido = 432;
		} else if (mina.contains("Planta de energía solar")) {
			segundosInicialRequerido = 151;
		} else {
			segundosInicialRequerido = 0;
		}
		
	}
	
//	public void subirMina()
	
	
}
