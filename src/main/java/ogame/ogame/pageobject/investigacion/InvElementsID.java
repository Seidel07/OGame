package ogame.ogame.pageobject.investigacion;

import java.util.ArrayList;
import java.util.List;

import ogame.ogame.parameters.Parameters;

public class InvElementsID {
	
	private final String idEnergia = "details113";
	private final String idLaser = "details120";
	private final String idIonica = "details121";
	private final String idHiperespacio = "details114";
	private final String idPlasma = "details122";
	private final String idCombustion = "details115";
	private final String idImpulso = "details117";
	private final String idHiperespacial = "details118";
	private final String idEspionaje = "details106";
	private final String idComputacion = "details108";
	private final String idAstrofisica = "details124";
	private final String idIntergalactica = "details123";
	private final String idGraviton = "details199";
	private final String idMilitar = "details109";
	private final String idDefensa = "details110";
	private final String idBlindaje = "details111";
	private static List<String> IdElements;
	
	public static List<String> getIdElements() {
		return IdElements;
	}
	public void setIdElements() {
		List<String> aux = new ArrayList<String>();
		aux.add(getIdEnergia()); // 0
		aux.add(getIdLaser()); // 1
		aux.add(getIdIonica()); // 2
		aux.add(getIdHiperespacio()); // 3
		aux.add(getIdPlasma()); // 4
		aux.add(getIdCombustion()); // 5
		aux.add(getIdImpulso()); // 6
		aux.add(getIdHiperespacial()); // 7
		aux.add(getIdEspionaje()); // 8
		aux.add(getIdComputacion()); // 9
		aux.add(getIdAstrofisica()); // 10
		aux.add(getIdIntergalactica()); // 11
		aux.add(getIdGraviton()); // 12
		aux.add(getIdMilitar()); // 13
		aux.add(getIdDefensa()); // 14
		aux.add(getIdBlindaje()); // 15
		InvElementsID.IdElements = aux;
	}
	public String getIdEnergia() {
		return idEnergia;
	}
	public String getIdLaser() {
		return idLaser;
	}
	public String getIdIonica() {
		return idIonica;
	}
	public String getIdHiperespacio() {
		return idHiperespacio;
	}
	public String getIdPlasma() {
		return idPlasma;
	}
	public String getIdCombustion() {
		return idCombustion;
	}
	public String getIdImpulso() {
		return idImpulso;
	}
	public String getIdHiperespacial() {
		return idHiperespacial;
	}
	public String getIdEspionaje() {
		return idEspionaje;
	}
	public String getIdComputacion() {
		return idComputacion;
	}
	public String getIdAstrofisica() {
		return idAstrofisica;
	}
	public String getIdIntergalactica() {
		return idIntergalactica;
	}
	public String getIdGraviton() {
		return idGraviton;
	}
	public String getIdMilitar() {
		return idMilitar;
	}
	public String getIdDefensa() {
		return idDefensa;
	}
	public String getIdBlindaje() {
		return idBlindaje;
	}

}
