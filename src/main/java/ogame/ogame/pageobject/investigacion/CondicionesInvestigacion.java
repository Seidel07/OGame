package ogame.ogame.pageobject.investigacion;

import ogame.ogame.pageobject.instalaciones.Instalaciones;

public class CondicionesInvestigacion extends Investigacion{

	Investigacion inv = new Investigacion();
	Instalaciones instl = new Instalaciones();
	
	public boolean puedoEnergia() {
		Integer investigacionNivel = instl.getObjetosMap().get(instl.getInvestigacion()).getNivel();
		if (investigacionNivel >=1) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean puedoLaser() {
		Integer energiaNivel = inv.getObjetosMap().get(getTEnergia()).getNivel();
		if (energiaNivel >=2) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean puedoIonica() {
		Integer investigacionNivel = instl.getObjetosMap().get(instl.getInvestigacion()).getNivel();
		Integer energiaNivel = getObjetosMap().get(getTEnergia()).getNivel();
		Integer laserNivel = getObjetosMap().get(getLaser()).getNivel();
		if (investigacionNivel >= 4 && energiaNivel >=4 && laserNivel >= 5) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean puedoHiperespacio() {
		Integer investigacionNivel = instl.getObjetosMap().get(instl.getInvestigacion()).getNivel();
		Integer energiaNivel = getObjetosMap().get(getTEnergia()).getNivel();
		Integer defensaNivel = getObjetosMap().get(getDefensa()).getNivel();
		if (investigacionNivel >= 7 && energiaNivel >=5 && defensaNivel >= 5) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean puedoPlasma() {
		Integer energiaNivel = getObjetosMap().get(getTEnergia()).getNivel();
		Integer laserNivel = getObjetosMap().get(getLaser()).getNivel();
		Integer ionicaNivel = getObjetosMap().get(getIonica()).getNivel();
		if (energiaNivel >=8 && laserNivel >= 10 && ionicaNivel >= 5) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean puedoCombustion() {
		Integer energiaNivel = getObjetosMap().get(getTEnergia()).getNivel();
		if (energiaNivel >=1) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean puedoImpulso() {
		Integer investigacionNivel = instl.getObjetosMap().get(instl.getInvestigacion()).getNivel();
		Integer energiaNivel = getObjetosMap().get(getTEnergia()).getNivel();
		if (investigacionNivel >= 2 && energiaNivel >=1) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean puedoHiperespacial() {
		Integer hiperespacioNivel = getObjetosMap().get(getHiperespacio()).getNivel();
		if (hiperespacioNivel >= 3) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean puedoEspionaje() {
		Integer investigacionNivel = instl.getObjetosMap().get(instl.getInvestigacion()).getNivel();
		if (investigacionNivel >= 3) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean puedoComputacion() {
		Integer investigacionNivel = instl.getObjetosMap().get(instl.getInvestigacion()).getNivel();
		if (investigacionNivel >= 1) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean puedoAstrofisica() {
		Integer espionajeNivel = getObjetosMap().get(getEspionaje()).getNivel();
		Integer impulsoNivel = getObjetosMap().get(getImpulso()).getNivel();
		if (espionajeNivel >= 4 && impulsoNivel >=3) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean puedoIntergalactica() {
		Integer investigacionNivel = instl.getObjetosMap().get(instl.getInvestigacion()).getNivel();
		Integer computacionNivel = getObjetosMap().get(getComputacion()).getNivel();
		Integer hiperespacioNivel = getObjetosMap().get(getHiperespacio()).getNivel();
		if (investigacionNivel >= 10 && computacionNivel >=8 && hiperespacioNivel >= 8) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean puedoGraviton() {
		System.out.println("No, no podés");
		return false;
	}
	
	public boolean puedoGravitonPosta() {
		Integer investigacionNivel = instl.getObjetosMap().get(instl.getInvestigacion()).getNivel();
		Integer energia = pageVG.getEnergia();
		if (investigacionNivel >0 && energia >= 300000) {
			System.out.println("Ya te dije que... disculpame. Sí, podés");
			return true;
		} else {
			System.out.println("¡Ya te dije que no! Andate a freir churros mejor");
			return false;
		}
	}
	
	public boolean puedoMilitar() {
		Integer investigacionNivel = instl.getObjetosMap().get(instl.getInvestigacion()).getNivel();
		if (investigacionNivel >= 4) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean puedoDefensa() {
		Integer investigacionNivel = instl.getObjetosMap().get(instl.getInvestigacion()).getNivel();
		Integer energiaNivel = getObjetosMap().get(getTEnergia()).getNivel();
		if (investigacionNivel >= 6 && energiaNivel >= 3) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean puedoBlindaje() {
		Integer investigacionNivel = instl.getObjetosMap().get(instl.getInvestigacion()).getNivel();
		if (investigacionNivel >= 2) {
			return true;
		} else {
			return false;
		}
	}
	
}
