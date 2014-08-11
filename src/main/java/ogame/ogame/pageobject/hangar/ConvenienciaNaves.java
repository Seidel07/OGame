package ogame.ogame.pageobject.hangar;

// This class has things TODO

public class ConvenienciaNaves extends Hangar{
	
	CondicionesNaves cond = new CondicionesNaves();
	
	public boolean convienePequena() {
		if (!cond.puedoGrande()) {
			Integer metal = pageVG.getMetal();
			Integer cristal = pageVG.getCristal();
			Integer deuterio = pageVG.getDeuterio();
			Integer recursos = metal + cristal + deuterio;
			if (recursos > getObjetosMap().get(getPequena()).getNivel() * 5000) {
				System.out.println("Es conveniente construir naves pequeñas de carga");
				return true;
			} else {
				System.out.println("No es conveniente construir naves pequeñas de carga");
				return false;
			}
		} else {
			System.out.println("No es conveniente construir naves pequeñas de carga");
			return false;
		}
	}
	
	public boolean convieneGrande() {
		Integer metal = pageVG.getMetal();
		Integer cristal = pageVG.getCristal();
		Integer deuterio = pageVG.getDeuterio();
		Integer recursos = metal + cristal + deuterio;
		if (recursos > getObjetosMap().get(getGrande()).getNivel() * 25000) {
			System.out.println("Es conveniente construir naves grandes de carga");
			return true;
		} else {
			System.out.println("No es conveniente construir naves grandes de carga");
			return false;
		}
	}
	
	public boolean convieneEstrella() {
		return true;
	}
	
	public boolean convieneLigero() {
		if (!cond.puedoPesado()) {
			Integer ligeros = getObjetosMap().get(getLigero()).getNivel();
			Integer pequenos = getObjetosMap().get(getPequena()).getNivel();
			Integer grandes = getObjetosMap().get(getGrande()).getNivel();
			if (ligeros < pequenos + grandes*5) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
	
	public boolean convienePesado() {
		if (!cond.puedoCrucero()) {
			Integer pesados = getObjetosMap().get(getPesado()).getNivel();
			Integer pequenos = getObjetosMap().get(getPequena()).getNivel();
			Integer grandes = getObjetosMap().get(getGrande()).getNivel();
			if (pesados < pequenos + grandes * 5) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
	
	public boolean convieneCrucero() {
		if (!cond.puedoBatalla()) {
			Integer cruceros = getObjetosMap().get(getCrucero()).getNivel();
			Integer pequenos = getObjetosMap().get(getPequena()).getNivel();
			Integer grandes = getObjetosMap().get(getGrande()).getNivel();
			if (cruceros < pequenos + grandes * 5) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
	
	public boolean convieneBatalla() {
		if (!cond.puedoAcorazado()) {
			Integer navesDeBatalla = getObjetosMap().get(getBatalla()).getNivel();
			Integer pequenos = getObjetosMap().get(getPequena()).getNivel();
			Integer grandes = getObjetosMap().get(getGrande()).getNivel();
			if (navesDeBatalla < pequenos + grandes * 5) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
	
	public boolean convieneAcorazado() {
		if (!cond.puedoBombardero()) {
			Integer acorazados = getObjetosMap().get(getAcorazado()).getNivel();
			Integer pequenos = getObjetosMap().get(getPequena()).getNivel();
			Integer grandes = getObjetosMap().get(getGrande()).getNivel();
			if (acorazados < pequenos + grandes * 5) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
	
	public boolean convieneBombardero() {
		if (!cond.puedoDestructor()) {
			Integer bombarderos = getObjetosMap().get(getBombardero()).getNivel();
			Integer pequenos = getObjetosMap().get(getPequena()).getNivel();
			Integer grandes = getObjetosMap().get(getGrande()).getNivel();
			if (bombarderos < pequenos + grandes * 5) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
	
	public boolean convieneDestructor() {
		if (!cond.puedoEstrella()) {
			Integer destructores = getObjetosMap().get(getDestructor()).getNivel();
			Integer pequenos = getObjetosMap().get(getPequena()).getNivel();
			Integer grandes = getObjetosMap().get(getGrande()).getNivel();
			if (destructores < pequenos + grandes * 5) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
	
	public boolean convieneSonda() {
		Integer sondas = getObjetosMap().get(getSonda()).getNivel();
		Integer pequenos = getObjetosMap().get(getPequena()).getNivel();
		Integer grandes = getObjetosMap().get(getGrande()).getNivel();
		if (sondas < pequenos + grandes * 5) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean convieneSatelite() {
		return false;
	}
	
	public boolean convieneReciclador() {
		// TODO
		return false;
	}
	
	public boolean convieneColonizador() {
		// TODO
		return false;
	}

}
