import static org.testng.Assert.assertTrue;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import autoitx4java.AutoItX;
import objectRepository.AppElements;
import utils.Lib;
import utils.PropertiesDataProvider;

import com.jacob.com.LibraryLoader;

public class Try_Testing {

	public
	static String jvmBitVersion(){
	 return System.getProperty("sun.arch.data.model");
	}
	
	public static void main(String[] args) throws Exception {
		String string = PropertiesDataProvider.getTestData("config/config.properties", "Debug");
		int i = Integer.parseInt(string);
		assertTrue(i==0);
		
		
		
		
		WebDriver driver = new ChromeDriver();
		Lib.login_AppBuilder(driver, "uitest@cyberobject.com.cn", "123456");
		Lib.SwitchToFrame(driver, "moduleFrame");

//        driver.findElement(AppElements.Menu_bar_Build).click();
//
//        driver.findElement(AppElements.Build_Menu_Web).click();


		 if (!Lib.isExist(driver, AppElements.Console_expand)) {
		 	  driver.findElement(AppElements.Console_arrow_left).click();
		 }  
		  Lib.wait_Sleep(3000);
		  Lib.chkIsDisplayed(driver, AppElements.Console_Window , true);
		  
		  Lib.mouseRightClick(driver, Lib.DirFile(driver,"Data/UI_Data_folder_02/UI_Data_file_termdef.xlsx"));
		  driver.findElement(AppElements.Menu_bar_ExcelTrain).click();
		  Lib.CheckConsoleMsg(driver, "Train");
        
        
        
        
        
        
		     Lib.TableCheckPoint(driver.findElement(AppElements.WebTable_BuildWebWindow), "TestCase_01", "CheckPoint_1");

		     Lib.SetInputBoxValue(driver, AppElements.BuildWebWindow_input_height, "300");

		     Lib.wait_Sleep(3000);
		     Lib.TableCheckPoint(driver.findElement(AppElements.WebTable_BuildWebWindow), "TestCase_01", "CheckPoint_2");


		        
		
		// TODO Auto-generated method stub
//		String jacobDllVersionToUse = "AutoIt/jacob-1.19-x64.dll";
//		File file = new File("lib", jacobDllVersionToUse);
//		System.setProperty(LibraryLoader.JACOB_DLL_PATH, file.getAbsolutePath());
//		AutoItX x = new AutoItX();
//		x.run("calc.exe");
//		x.winActivate("计算器");
//		x.winWaitActive("计算器");
//		//Enter 3
//		x.controlClick("计算器", "", "133") ;
//		Thread.sleep(1000);
//		//Enter +
//		x.controlClick("计算器", "", "93") ;
//		Thread.sleep(1000);
//		//Enter 3
//		x.controlClick("计算器", "", "133") ;
//		Thread.sleep(1000);
//		//Enter =
//		x.controlClick("计算器", "", "121") ;
//		x.run("notepad.exe");
//		x.winActive("无标题 - 记事本");
//		x.winWaitActive("无标题 - 记事本");
//		x.send("123");
//	       List<String> paramterNames = getParameterNameJava8(Try_Testing.class, "fun1");
//	        for (String p : paramterNames) {
//          System.out.println("parameter: "+ p);
//      }
//        Method method = Try_Testing.class.getMethod("fun1",String.class,int.class);
//        for (Parameter p : method.getParameters()) {
//            System.out.println("parameter: "+p.getName());
//        }
//        Parameter[] p = method.getParameters();
//        System.out.println("parameter: "+p[0].getName());
//		AppElements t = new AppElements();
        	
		System.out.println(Lib.getCurrentLocalDateTime());
		driver.close();
		
//		  for(Field f : t.getClass().getFields()) {
//		   System.out.println(f.getName());
//		  }
        
	}
	

	/**
     * A hashing method that changes a string (like a URL) into a hash suitable for using as a
     * disk filename.
     */
    public static String hashKeyForDisk(String key) {
        String cacheKey;
        try {
            final MessageDigest mDigest = MessageDigest.getInstance("MD5");
            mDigest.update(key.getBytes());
            
            
            
            cacheKey = bytesToHexString(mDigest.digest());
        } catch (NoSuchAlgorithmException e) {
            cacheKey = String.valueOf(key.hashCode());
        }
        return cacheKey;
    }

    private static String bytesToHexString(byte[] bytes) {
        // http://stackoverflow.com/questions/332079
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < bytes.length; i++) {
            String hex = Integer.toHexString(0xFF & bytes[i]);
            if (hex.length() == 1) {
                sb.append('0');
            }
            sb.append(hex);
        }
        return sb.toString();
    }
	
	
	
	
	
	
	
	
    public static String GetMethodParaName(String MethodName) throws NoSuchMethodException, SecurityException {
		String ParaName = "";	
		Method method = Lib.class.getMethod(MethodName , String.class);
		Parameter[] p = method.getParameters();
		ParaName = p[0].getName();
		
        return ParaName;
	}
    
    
    public static List<String> getParameterNameJava8(Class clazz, String methodName) {
        List<String> paramterList = new ArrayList<>();
        Method[] methods = clazz.getDeclaredMethods();
        for (Method method : methods) {
            if (methodName.equals(method.getName())) {
                //直接通过method就能拿到所有的参数
                Parameter[] params = method.getParameters();
                for (Parameter parameter : params) {
                    paramterList.add(parameter.getName());
                }
            }
        }
        return paramterList;
    }

	

}
