package util.properties;

import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.Properties;

/**
 * properties 工具类
 * @author hzw
 */
public class PropertiesUtil {
	
	/**
	 * 随意获取 properties key 相关值
	 * @param parm			- 配置文件定义的 key 
	 * @param propertiename - 配置文件名称
	 * @return
	 * @throws IOException
	 */
	public String  getProperties(String parm,String propertiename) throws IOException {
		Properties pps = new Properties();
		InputStream is = this.getClass().getResourceAsStream(propertiename);
		pps.load(is);
		String returnStr ="";
		@SuppressWarnings("rawtypes")
		Enumeration enum1 = pps.propertyNames();// 得到配置文件的名字
		while (enum1.hasMoreElements()) {
			String strKey = (String) enum1.nextElement();
			if (strKey.equals(parm)) {
				returnStr = pps.getProperty(strKey);
			}
		}
		return returnStr ;
	}
	
	// main 主 方法 Dome
	public static void main(String[] args) throws IOException {
		PropertiesUtil propertiesUtil = new PropertiesUtil();
		// 获取propertes 文件  key 对应的值
		String value = propertiesUtil.getProperties("CascadeApproval.Ip", "/application.properties");
		
		
	}
	
}
