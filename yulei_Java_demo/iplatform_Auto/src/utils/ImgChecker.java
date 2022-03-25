package utils;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

//import com.sun.jna.platform.win32.OaIdl.DATE;

import jxl.write.DateTime;
import prepare.MMDriver;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;

public class ImgChecker {
	private static String UpdateExceptedImg =  PropertiesDataProvider.getTestData("config/config.properties", "UpdateExceptedImg");
	private static String ExpectedImgPath = PropertiesDataProvider.getTestData("config/config.properties", "ExpectedImgPath");
	private static String ActualImgPath = PropertiesDataProvider.getTestData("config/config.properties", "ActualImgPath");
	private static WebDriver driver;
	
	public ImgChecker(WebDriver driver) {
		this.driver = driver;
		driver.switchTo().defaultContent();
	}
	public void CheckImg(WebElement ele , String CheckPoint) {
		boolean DoUpdate = Boolean.valueOf(UpdateExceptedImg);
		if(DoUpdate){
			Screenshot ScreenshotImg = new AShot().takeScreenshot(driver, ele);
			try {
				ImageIO.write(ScreenshotImg.getImage() , "png" , new File(ExpectedImgPath + CheckPoint +".png"));
				return;
			} catch (Exception e) {
				Lib.assertNull(ScreenshotImg.getImage(), "Update Img failed!");
			}
		}
		Screenshot ScreenshotImg = new AShot().takeScreenshot(driver, ele);
        ImageDiffer imgDiff = new ImageDiffer();
        try {
           ImageDiff diff = imgDiff.makeDiff(ScreenshotImg.getImage(), ImageIO.read(new File(ExpectedImgPath + CheckPoint +".png")));
		   if (diff.hasDiff()) {
			   LocalDateTime myDateObj = LocalDateTime.now();
			   DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
			   String formattedDate = myDateObj.format(myFormatObj);
	           ImageIO.write(ScreenshotImg.getImage(),"png",new File(ActualImgPath + CheckPoint + "_" + formattedDate + ".png"));
	           ImageIO.write(diff.getMarkedImage(), "png", new File(ActualImgPath + CheckPoint + "_" + formattedDate + "_diff" + ".png"));   
		       Lib.assertfail(ActualImgPath + CheckPoint + "_" + formattedDate + "_diff" + ".png", ExpectedImgPath + CheckPoint + ".png" , "CheckImg");
		   }
        } catch (Exception e) {
			Lib.assertNull(ScreenshotImg.getImage(), "Get Img failed!");
		}
	}
	
	public void CheckImg(By by , String CheckPoint) {
		boolean DoUpdate = Boolean.valueOf(UpdateExceptedImg);
		if(DoUpdate){
			Screenshot ScreenshotImg = new AShot().takeScreenshot(driver, driver.findElement(by));
			try {
				ImageIO.write(ScreenshotImg.getImage() , "png" , new File(ExpectedImgPath + CheckPoint +".png"));
				return;
			} catch (Exception e) {
				Lib.assertNull(ScreenshotImg.getImage(), "Update Img failed!");
			}
		}
		Screenshot ScreenshotImg = new AShot().takeScreenshot(driver, driver.findElement(by));
        ImageDiffer imgDiff = new ImageDiffer();
        try {
           ImageDiff diff = imgDiff.makeDiff(ScreenshotImg.getImage(), ImageIO.read(new File(ExpectedImgPath + CheckPoint +".png")));
		   if (diff.hasDiff()) {
			   LocalDateTime myDateObj = LocalDateTime.now();
			   DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
			   String formattedDate = myDateObj.format(myFormatObj);
	           ImageIO.write(ScreenshotImg.getImage(),"png",new File(ActualImgPath + CheckPoint + "_" + formattedDate + ".png"));
	           ImageIO.write(diff.getMarkedImage(), "png", new File(ActualImgPath + CheckPoint + "_" + formattedDate + "_diff" + ".png"));   
		       Lib.assertfail(ActualImgPath + CheckPoint + "_" + formattedDate + "_diff" + ".png", ExpectedImgPath + CheckPoint + ".png" , "CheckImg");
		   }
        } catch (Exception e) {
			Lib.assertNull(ScreenshotImg.getImage(), "Get Img failed!");
		}
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
