package Ogame.ogame.pageobject.hangar;

// This class has methods TODO

public class CantidadesAConstruir extends Hangar{
	
	public Integer cuantasPequeñas() {
		Integer metal = pageVG.getMetal();
		Integer cristal = pageVG.getCristal();
		Integer deuterio = pageVG.getDeuterio();
		Integer recursos = metal + cristal + deuterio;
		return (int) Math.ceil((recursos - getObjetosMap().get(getPequena()).getNivel()*5000)/(5000 + 2000 + 2000));
	}
	
	public Integer cuantasGrandes() {
		Integer metal = pageVG.getMetal();
		Integer cristal = pageVG.getCristal();
		Integer deuterio = pageVG.getDeuterio();
		Integer recursos = metal + cristal + deuterio;
		return (int) Math.ceil((recursos - getObjetosMap().get(getGrande()).getNivel()*25000)/(25000 + 6000 + 6000));
	}
	
	public Integer cuantas(String nave) {
		Integer navesCantidad = getObjetosMap().get(nave).getNivel();
		Integer pequenasCantidad = getObjetosMap().get(getPequena()).getNivel();
		Integer grandesCantidad = getObjetosMap().get(getGrande()).getNivel();
		return (int) Math.ceil(pequenasCantidad + grandesCantidad*5 - navesCantidad);
	}
	
	public Integer cuantosRecicladores() {
		// TODO
		return 0;
	}
	
	public Integer cuantasSondas() {
		// TODO
		return 0;
	}

}
