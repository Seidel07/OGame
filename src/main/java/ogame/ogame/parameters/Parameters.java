package ogame.ogame.parameters;

import java.util.ArrayList;
import java.util.List;

public class Parameters {
	
	private final String url = "http://www.ogame.com.ar";
	private final String universo = "Kassiopeia";
	private final String userName = "seidel07";
	private final String password = "28971091dns";
	
	private final String visionGeneral = "Visión general";
	private final String recursos = "Recursos";
	private final String instalaciones = "Instalaciones";
	private final String investigacion = "Investigación";
	private final String hangar = "Hangar";
	private final String defensa ="Defensa";
	private final String flota = "Flota";
	private final String galaxia = "Galaxia";
	
	private final String minaMetal = "Mina de metal";
	private final String minaCristal = "Mina de cristal";
	private final String minaDeuterio = "Sintetizador de deuterio";
	private final String minaSolar = "Planta de energía solar";
	private final String almacenMetal = "Almacén de metal";
	private final String almacenCristal = "Almacén de cristal";
	private final String almacenDeuterio = "Contenedor de deuterio";
	private static List<String> elementos;
	
	public List<String> getElementos(){
		return elementos;
	}
	
	public void setElementos(){
		List<String> objects = new ArrayList<String>();
		objects.add(getMinaMetal()); //0
		objects.add(getMinaCristal()); //1
		objects.add(getMinaDeuterio()); //2
		objects.add(getMinaSolar()); //3
		objects.add(getAlmacenMetal()); //4
		objects.add(getAlmacenCristal()); //5
		objects.add(getAlmacenDeuterio()); //6
		Parameters.elementos = objects;
	}
	
	public String getUrl() {
		return url;
	}
	public String getUniverso() {
		return universo;
	}
	public String getUserName() {
		return userName;
	}
	public String getPassword() {
		return password;
	}
	
	public String getVisionGeneral() {
		return visionGeneral;
	}
	public String getRecursos() {
		return recursos;
	}
	public String getInstalaciones() {
		return instalaciones;
	}
	public String getInvestigacion() {
		return investigacion;
	}
	public String getHangar() {
		return hangar;
	}
	public String getDefensa() {
		return defensa;
	}
	public String getFlota() {
		return flota;
	}
	public String getGalaxia() {
		return galaxia;
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
	public String getAlmacenMetal() {
		return almacenMetal;
	}
	public String getAlmacenCristal() {
		return almacenCristal;
	}
	public String getAlmacenDeuterio() {
		return almacenDeuterio;
	}

}
