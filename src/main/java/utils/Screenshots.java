package utils;

import io.cucumber.java.Scenario;
import managers.DriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;

public class Screenshots {

    /**
     * Method to take an screenshot and attach it in the report file.
     * @param scn Scenario
     * @param name Screenshot name
     */
    public static void takeScreenshot(Scenario scn, String name) {
        try{
            byte[] screenshot = ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.BYTES);
            scn.attach(screenshot, "image/png", name + ".png");
        }
        catch (Exception e){
            System.out.println("Exception while taking ScreenShot "+e.getMessage());
        }
    }

    /**
     * Method to take a screenshot and save it as a File.
     * @param name Screenshot name
     * @throws IOException
     */
    public static void takeScreenshot(String name) throws IOException {
        TakesScreenshot scrShot =((TakesScreenshot)DriverManager.getDriver());
        File srcFile = scrShot.getScreenshotAs(OutputType.FILE);
        File destFile = new File("screenshots/" + name + ".png");
        FileUtils.copyFile(srcFile, destFile);
    }
}
