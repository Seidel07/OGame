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
	
	private final String idRobot = "details14";
	private final String idHangar = "details21";
	private final String idInvestigacion = "details31";
	private final String idAlianza = "details34";
	private final String idSilo = "details44";
	private final String idNanobots = "details15";
	private final String idTerraformer = "details33";
	private static List<String> InstlIdElements;
	
	public static List<String> getInstlIdElements() {
		return InstlIdElements;
	}
	public void setInstlIdElements() {
		List<String> aux = new ArrayList<String>();
		aux.add(getIdRobot()); // 0
		aux.add(getIdHangar()); // 1
		aux.add(getIdInvestigacion()); // 2
		aux.add(getIdAlianza()); // 3
		aux.add(getIdSilo()); // 4
		aux.add(getIdNanobots()); // 5
		aux.add(getIdTerraformer()); //6
		Parameters.InstlIdElements = aux;
	}
	public String getIdRobot() {
		return idRobot;
	}
	public String getIdHangar() {
		return idHangar;
	}
	public String getIdInvestigacion() {
		return idInvestigacion;
	}
	public String getIdAlianza() {
		return idAlianza;
	}
	public String getIdSilo() {
		return idSilo;
	}
	public String getIdNanobots() {
		return idNanobots;
	}
	public String getIdTerraformer() {
		return idTerraformer;
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
	
}
