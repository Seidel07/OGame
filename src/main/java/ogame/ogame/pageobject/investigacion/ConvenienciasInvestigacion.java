package ogame.ogame.pageobject.investigacion;

public class ConvenienciasInvestigacion extends Investigacion{
	
	public boolean convieneEnergia() {
		Integer energiaNivel = getObjetosMap().get(getEnergia()).getNivel();
		if (energiaNivel <8) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean convieneLaser() {
		Integer laserNivel = getObjetosMap().get(getLaser()).getNivel();;
		if (laserNivel < 12) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean convieneIonica() {
		Integer ionicaNivel = getObjetosMap().get(getIonica()).getNivel();
		if (ionicaNivel <  5) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean convieneHiperespacio() {
		Integer hiperespacioNivel = getObjetosMap().get(getHiperespacio()).getNivel();
		if (hiperespacioNivel < 8) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean convienePlasma() {
		Integer plasmaNivel = getObjetosMap().get(getPlasma()).getNivel();
		if (plasmaNivel < 5) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean convieneCombustion() {
		return true;
	}
	
	public boolean convieneImpulso() {
		return true;
	}
	
	public boolean convieneHiperespacial() {
		return true;
	}
	
	public boolean convieneEspionaje() {
		return true;
	}
	
	public boolean convieneComputacion() {
		return true;
	}
	
	public boolean convieneAstrofisica() {
		return true;
	}
	
	public boolean convieneIntergalactica() {
		return true;
	}
	
	public boolean convieneGraviton() {
		Integer gravitonNivel = getObjetosMap().get(getGraviton()).getNivel();
		if (gravitonNivel < 1) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean convieneDefensa() {
		return true;
	}
	
	public boolean convieneMilitar() {
		return true;
	}
	
	public boolean convieneBlindaje() {
		return true;
	}

}
