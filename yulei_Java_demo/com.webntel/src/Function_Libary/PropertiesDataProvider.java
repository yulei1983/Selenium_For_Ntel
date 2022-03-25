package Function_Libary;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @Description 从.properties文件中读取相关测试数据
 */
public class PropertiesDataProvider {

	/**
	 * @param args
	 * @throws Exception
	 */
	public static String getTestData(String configFilePath, String key) {
		String configValue = null;
		InputStream iStream = null;
		Properties config = new Properties();

		try {
			iStream = new FileInputStream(configFilePath);
			config.load(iStream);
			configValue = String.valueOf(config.getProperty(key));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				iStream.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return configValue;

	}

	public static void main(String[] args) {

		String mm = PropertiesDataProvider.getTestData("config/config.properties", "sourcecodedir");
		System.out.println(mm);

	}

}
