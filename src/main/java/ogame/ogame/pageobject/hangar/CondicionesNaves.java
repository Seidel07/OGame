package ogame.ogame.pageobject.hangar;

import ogame.ogame.pageobject.instalaciones.Instalaciones;
import ogame.ogame.pageobject.investigacion.Investigacion;

public class CondicionesNaves {
	
	Instalaciones instl = new Instalaciones();
	Investigacion inv = new Investigacion();
	
	public boolean puedoPequena(){
		Integer hangarNivel = instl.getObjetosMap().get(instl.getHangar()).getNivel();
		Integer combustionNivel = inv.getObjetosMap().get(inv.getCombustion()).getNivel();
		if (hangarNivel >=2 && combustionNivel >= 2) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean puedoGrande() {
		Integer hangarNivel = instl.getObjetosMap().get(instl.getHangar()).getNivel();
		Integer combustionNivel = inv.getObjetosMap().get(inv.getCombustion()).getNivel();
		if (hangarNivel >=4 && combustionNivel >= 6) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean puedoLigero() {
		Integer hangarNivel = instl.getObjetosMap().get(instl.getHangar()).getNivel();
		Integer combustionNivel = inv.getObjetosMap().get(inv.getCombustion()).getNivel();
		if (hangarNivel >=1 && combustionNivel >= 1) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean puedoCrucero() {
		Integer hangarNivel = instl.getObjetosMap().get(instl.getHangar()).getNivel();
		Integer impulsoNivel = inv.getObjetosMap().get(inv.getImpulso()).getNivel();
		Integer ionicaNivel = inv.getObjetosMap().get(inv.getIonica()).getNivel();
		if (hangarNivel >=5 && impulsoNivel >= 4 && ionicaNivel >= 2) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean puedoPesado() {
		Integer hangarNivel = instl.getObjetosMap().get(instl.getHangar()).getNivel();
		Integer impulsoNivel = inv.getObjetosMap().get(inv.getImpulso()).getNivel();
		Integer blindajeNivel = inv.getObjetosMap().get(inv.getBlindaje()).getNivel();
		if (hangarNivel >=3 && impulsoNivel >= 2 && blindajeNivel >= 2) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean puedoBatalla() {
		Integer hangarNivel = instl.getObjetosMap().get(instl.getHangar()).getNivel();
		Integer impulsoNivel = inv.getObjetosMap().get(inv.getImpulso()).getNivel();
		if (hangarNivel >=7 && impulsoNivel >= 4) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean puedoColonizador() {
		Integer hangarNivel = instl.getObjetosMap().get(instl.getHangar()).getNivel();
		Integer impulsoNivel = inv.getObjetosMap().get(inv.getImpulso()).getNivel();
		if (hangarNivel >=4 && impulsoNivel >= 3) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean puedoAcorazado() {
		Integer hangarNivel = instl.getObjetosMap().get(instl.getHangar()).getNivel();
		Integer hiperespacialNivel = inv.getObjetosMap().get(inv.getHiperespacial()).getNivel();
		Integer hiperespacioNivel = inv.getObjetosMap().get(inv.getHiperespacio()).getNivel();
		Integer laserNivel = inv.getObjetosMap().get(inv.getLaser()).getNivel();
		if (hangarNivel >=8 && hiperespacialNivel >= 5 && hiperespacioNivel >= 5 && laserNivel >= 12) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean puedoBombardero() {
		Integer hangarNivel = instl.getObjetosMap().get(instl.getHangar()).getNivel();
		Integer impulsoNivel = inv.getObjetosMap().get(inv.getImpulso()).getNivel();
		Integer plasmaNivel = inv.getObjetosMap().get(inv.getPlasma()).getNivel();
		if (hangarNivel >=8 && impulsoNivel >= 6 && plasmaNivel >= 5) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean puedoDestructor() {
		Integer hangarNivel = instl.getObjetosMap().get(instl.getHangar()).getNivel();
		Integer hiperespacialNivel = inv.getObjetosMap().get(inv.getHiperespacial()).getNivel();
		Integer hiperespacioNivel = inv.getObjetosMap().get(inv.getHiperespacio()).getNivel();
		if (hangarNivel >=9 && hiperespacialNivel >= 6 && hiperespacioNivel >= 5) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean puedoEstrella() {
		Integer hangarNivel = instl.getObjetosMap().get(instl.getHangar()).getNivel();
		Integer hiperespacialNivel = inv.getObjetosMap().get(inv.getHiperespacial()).getNivel();
		Integer hiperespacioNivel = inv.getObjetosMap().get(inv.getHiperespacio()).getNivel();
		Integer gravitonNivel = inv.getObjetosMap().get(inv.getGraviton()).getNivel();
		if (hangarNivel >=12 && hiperespacialNivel >= 7 && hiperespacioNivel >= 6 && gravitonNivel >=1) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean puedoReciclador() {
		Integer hangarNivel = instl.getObjetosMap().get(instl.getHangar()).getNivel();
		Integer combustionNivel = inv.getObjetosMap().get(inv.getCombustion()).getNivel();
		Integer defensaNivel = inv.getObjetosMap().get(inv.getDefensa()).getNivel();
		if (hangarNivel >=4 && combustionNivel >= 6 && defensaNivel >= 2) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean puedoSonda() {
		Integer hangarNivel = instl.getObjetosMap().get(instl.getHangar()).getNivel();
		Integer combustionNivel = inv.getObjetosMap().get(inv.getCombustion()).getNivel();
		Integer espionajeNivel = inv.getObjetosMap().get(inv.getEspionaje()).getNivel();
		if (hangarNivel >=3 && combustionNivel >= 3 && espionajeNivel >= 2) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean puedoSatelite() {
		Integer hangarNivel = instl.getObjetosMap().get(instl.getHangar()).getNivel();
		if (hangarNivel >=1) {
			return true;
		} else {
			return false;
		}
	}

}
