package ogame.ogame.pageobject;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Metodos {
	
	public static void addScreenshot(WebDriver driver) {
		String path;
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		path = "./target/screenshots/" + "ogame.png";
		try {
			FileUtils.copyFile(scrFile, new File(path));
			FileUtils.copyFile(scrFile, new File("output/" + File.separator + "OGAME" + ".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
