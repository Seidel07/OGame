package Ogame.ogame;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import ogame.ogame.pageobject.AllPages;
import ogame.ogame.pageobject.LoginPage;
import ogame.ogame.pageobject.Metodos;
import ogame.ogame.pageobject.VisionGeneral;
import ogame.ogame.pageobject.hangar.CantidadesAConstruir;
import ogame.ogame.pageobject.hangar.CondicionesNaves;
import ogame.ogame.pageobject.hangar.ConvenienciaNaves;
import ogame.ogame.pageobject.hangar.Hangar;
import ogame.ogame.pageobject.instalaciones.Instalaciones;
import ogame.ogame.pageobject.investigacion.CondicionesInvestigacion;
import ogame.ogame.pageobject.investigacion.ConvenienciasInvestigacion;
import ogame.ogame.pageobject.investigacion.InvElementsID;
import ogame.ogame.pageobject.investigacion.Investigacion;
import ogame.ogame.pageobject.recursos.Recursos;
import ogame.ogame.parameters.Parameters;


public class App 
{

	private static Parameters params = new Parameters();
	private static LoginPage loginPage = new LoginPage();
	private static Recursos pageR = new Recursos();
	private static Instalaciones pageIns = new Instalaciones();

	private static Hangar pageH = new Hangar();
	private static CondicionesNaves pageCondicionesNaves = new CondicionesNaves();
	private static ConvenienciaNaves pageConvenienciaNaves = new ConvenienciaNaves();
	private static CantidadesAConstruir pageCantidadNaves = new CantidadesAConstruir();

	private static Investigacion pageInv = new Investigacion();
	private static ConvenienciasInvestigacion pageConvInv= new ConvenienciasInvestigacion();
	private static CondicionesInvestigacion pageCondInv = new CondicionesInvestigacion();
	private static InvElementsID investigacionId = new InvElementsID();

	private static VisionGeneral pageVG = new VisionGeneral();
	private static Metodos metodos = new Metodos();

	public static void main( String[] args ) throws InterruptedException
	{
		for (int j=1; j < 100; j++) {
			WebDriver driver = new FirefoxDriver();
			metodos.manejoBrowser(driver);
			try {
				metodos.setTodo(driver);
				for (int i=1; i<1000; i++) {
					System.out.println("********************************************" + i);

					if (pageVG.sePuedeConstruirEdifcios(driver)) {
						if (pageIns.puedoSubirlo(driver, pageIns.getRobots()) && pageIns.convieneRobots()) { // Robots
							pageIns.subir(driver, pageIns.getRobots());

						} else if (pageIns.puedoSubirlo(driver, pageIns.getHangar()) && pageIns.convieneHangar()) {
							pageIns.subir(driver, pageIns.getHangar());

						} else if (pageIns.puedoSubirlo(driver, pageIns.getInvestigacion()) && pageIns.convieneInvestigacion()) {
							pageIns.subir(driver, pageIns.getInvestigacion());

						} else 	if (pageR.puedoSubirlo(driver, pageR.getMinaSolar()) && pageR.convieneSolar()) { // Energia solar
							pageR.subir(driver, pageR.getMinaSolar());

						} else if (pageR.puedoSubirlo(driver, pageR.getMinaMetal()) && pageR.convieneMetal()) { // Mina metal
							pageR.subir(driver, pageR.getMinaMetal());

						} else if (pageR.puedoSubirlo(driver, pageR.getMinaCristal()) && pageR.convieneCristal()) { // Mina cristal
							pageR.subir(driver, pageR.getMinaCristal());

						} else if (pageR.puedoSubirlo(driver, pageR.getMinaDeuterio()) && pageR.convieneDeuterio()) { // Mina deuterio
							pageR.subir(driver, pageR.getMinaDeuterio());

						} else if (pageR.puedoSubirlo(driver, pageR.getAlmacenMetal()) && pageR.convieneAlmacenMetal()) {
							pageR.subir(driver, pageR.getAlmacenMetal());

						} else if (pageR.puedoSubirlo(driver, pageR.getAlmacenCristal()) && pageR.convieneAlmacenCristal()) {
							pageR.subir(driver, pageR.getAlmacenCristal());

						} else if (pageR.puedoSubirlo(driver, pageR.getAlmacenDeuterio()) && pageR.convieneAlmacenDeuterio()) {
							pageR.subir(driver, pageR.getAlmacenDeuterio());

						}
					}

					if (pageVG.sePuedeInvestigar(driver)) {
/*Energia*/				if (pageInv.puedoSubirlo(driver, pageInv.getTEnergia()) && pageConvInv.convieneEnergia() && pageCondInv.puedoEnergia() && pageCondInv.puedoEnergia()) {
							pageInv.subir(driver, pageInv.getTEnergia());
/*Hiperespacial*/		} else if (pageInv.puedoSubirlo(driver, pageInv.getHiperespacial()) && pageConvInv.convieneHiperespacial() && pageCondInv.puedoHiperespacial()) {
							pageInv.subir(driver, pageInv.getHiperespacial());
/*Impulso*/				} else if (pageInv.puedoSubirlo(driver, pageInv.getImpulso()) && pageConvInv.convieneImpulso() && pageCondInv.puedoImpulso()) {
							pageInv.subir(driver, pageInv.getImpulso());
/*Combustion*/			} else if (pageInv.puedoSubirlo(driver, pageInv.getCombustion()) && pageConvInv.convieneCombustion() && pageCondInv.puedoCombustion()) {
							pageInv.subir(driver, pageInv.getCombustion());
/*Computacion*/			} else if (pageInv.puedoSubirlo(driver, pageInv.getComputacion()) && pageConvInv.convieneComputacion() && pageCondInv.puedoComputacion()) {
							pageInv.subir(driver, pageInv.getComputacion());
/*Espionaje*/			} else if (pageInv.puedoSubirlo(driver, pageInv.getEspionaje()) && pageConvInv.convieneEspionaje() && pageCondInv.puedoEspionaje()) {
							pageInv.subir(driver, pageInv.getEspionaje());
/*Astrofisica*/			} else if (pageInv.puedoSubirlo(driver, pageInv.getAstrofisica()) && pageConvInv.convieneAstrofisica() && pageCondInv.puedoAstrofisica()) {
							pageInv.subir(driver, pageInv.getAstrofisica());
/*Militar*/				} else if (pageInv.puedoSubirlo(driver, pageInv.getMilitar()) && pageConvInv.convieneMilitar() && pageCondInv.puedoMilitar()) {
							pageInv.subir(driver, pageInv.getMilitar());
/*Defensa*/				} else if (pageInv.puedoSubirlo(driver, pageInv.getDefensa()) && pageConvInv.convieneDefensa() && pageCondInv.puedoDefensa()) {
							pageInv.subir(driver, pageInv.getDefensa());
/*Blindaje*/			} else if (pageInv.puedoSubirlo(driver, pageInv.getBlindaje()) && pageConvInv.convieneBlindaje() && pageCondInv.puedoBlindaje()) {
							pageInv.subir(driver, pageInv.getBlindaje());
/*Intergalactica*/		} else if (pageInv.puedoSubirlo(driver, pageInv.getIntergalactica()) && pageConvInv.convieneIntergalactica() && pageCondInv.puedoIntergalactica()) {
							pageInv.subir(driver, pageInv.getIntergalactica());
/*Hiperespacio*/		} else if (pageInv.puedoSubirlo(driver, pageInv.getHiperespacio()) && pageConvInv.convieneHiperespacio() && pageCondInv.puedoHiperespacio()) {
							pageInv.subir(driver, pageInv.getHiperespacio());
/*Plasma*/				} else if (pageInv.puedoSubirlo(driver, pageInv.getPlasma()) && pageConvInv.convienePlasma() && pageCondInv.puedoPlasma()) {
							pageInv.subir(driver, pageInv.getPlasma());
/*Graviton*/			} else if (pageInv.puedoSubirlo(driver, pageInv.getGraviton()) && pageConvInv.convieneGraviton() && pageCondInv.puedoGraviton()) {
							pageInv.subir(driver, pageInv.getGraviton());
/*Ionica*/				} else if (pageInv.puedoSubirlo(driver, pageInv.getIonica()) && pageConvInv.convieneIonica() && pageCondInv.puedoIonica()) {
							pageInv.subir(driver, pageInv.getIonica());
/*Laser*/				} else if (pageInv.puedoSubirlo(driver, pageInv.getLaser()) && pageConvInv.convieneLaser() && pageCondInv.puedoLaser()) {
							pageInv.subir(driver, pageInv.getLaser());
						}
					}

					if (pageVG.sePuedeConstruirNaves(driver)) {
						if (pageConvenienciaNaves.convienePequena() && pageCondicionesNaves.puedoPequena()) {
							Integer cantidadPequeñasAConstruir = pageCantidadNaves.cuantasPequeñas();
							pageH.crear(driver, pageH.getPequena(), cantidadPequeñasAConstruir);
						}
					}


					System.out.println("Se hara un sleep de 1 minuto");
					Thread.sleep(1000*60);
					System.out.println("Sleep finalizado");
				}


				System.out.println("Terminado");

			} catch (Exception e) {
				e.printStackTrace();
				Metodos.addScreenshot(driver);
			} finally {
				if (driver != null) {
					driver.close();
				}
			}
		}
	}
}
