package ogame.ogame.pageobject.instalaciones;

import org.openqa.selenium.WebElement;

public class Objetos {
	
	private  String nombre;
	private  Integer metalRequerido = 0;
	private  Integer cristalRequerido = 0;
	private  Integer deuterioRequerido = 0;
	private Integer energiaRequerida = 0;
	private  Integer tiempoInicialRequerido = 0;
	private  Double tiempoRequerido = 0.0;
	private  Double constante = 2.0;
	private  Integer nivel = 0;
	private  WebElement webElement;
	private  Integer index;
	private boolean conviene;
	private boolean puedo;
	
	public Integer getEnergiaRequerida() {
		return energiaRequerida;
	}
	public void setEnergiaRequerida(Integer energiaRequerida) {
		this.energiaRequerida = energiaRequerida;
	}
	public boolean isPuedo() {
		return puedo;
	}
	public void setPuedo(boolean puedo) {
		this.puedo = puedo;
	}
	
	public boolean isConviene() {
		return conviene;
	}
	public void setConviene(boolean conviene) {
		this.conviene = conviene;
	}
	public Integer getIndex() {
		return index;
	}
	public void setIndex(Integer index) {
		this.index = index;
	}
	public  String getNombre() {
		return nombre;
	}
	public  void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public  Integer getMetalRequerido() {
		return metalRequerido;
	}
	public  void setMetalRequerido(Integer metalRequerido) {
		this.metalRequerido = metalRequerido;
	}
	public  Integer getCristalRequerido() {
		return cristalRequerido;
	}
	public  void setCristalRequerido(Integer cristalRequerido) {
		this.cristalRequerido = cristalRequerido;
	}
	public  Integer getDeuterioRequerido() {
		return deuterioRequerido;
	}
	public  void setDeuterioRequerido(Integer deuterioRequerido) {
		this.deuterioRequerido = deuterioRequerido;
	}
	public  Integer getTiempoInicialRequerido() {
		return tiempoInicialRequerido;
	}
	public  void setTiempoInicialRequerido(Integer tiempoInicialRequerido) {
		this.tiempoInicialRequerido = tiempoInicialRequerido;
	}
	public  Double getTiempoRequerido() {
		return tiempoRequerido;
	}
	public  void setTiempoRequerido(Double tiempoRequerido) {
		this.tiempoRequerido = tiempoRequerido/5;
	}
	public  Integer getNivel() {
		return nivel;
	}
	public  void setNivel(Integer nivel) {
		this.nivel = nivel;
	}
	public  WebElement getWebElement() {
		return webElement;
	}
	public  void setWebElement(WebElement webElement) {
		this.webElement = webElement;
	}
	public Double getConstante() {
		return constante;
	}
	
	public void setConstante(Double constante) {
		this.constante = constante;
	}

}
