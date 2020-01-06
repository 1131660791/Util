package util.commoncheck;

import java.util.regex.Pattern;

/**
 * 常见检查工具类
 * @author yixin
 */
public class CommoncheckUtil {
	
	/**
	 * 验证文件是否为 否个类型  这里截取 .后缀	<br/>
	 * 使用方法:<br/>
	 * 	  if(CommoncheckUtil.checkFileType(文件地址).equals("xls")){}<br/>
	 * 结果：判断后 如果 返回 结果与 判断相等 判断为 : true
	 */
	public static String checkFileType(String path){
		if(path ==null || path.trim() ==""){
			return "";
		}
		if(path.contains(".")){
			String pp =  path.substring(path.lastIndexOf(".")+1, path.length());
			return pp;
		}
		return "";
	}

	/**
     * 验证中文 
     * @param chinese 中文字符
     * @return 验证成功返回true，验证失败返回false 
     */   
    public static boolean checkChinese(String chinese) {   
        String regex = "^[\u4E00-\u9FA5]+$";   
        return Pattern.matches(regex,chinese);   
    }
    
    /** 
     * 验证URL地址 
     * @param url 格式：http://blog.csdn.net:80/xyang81/article/details/7705960?
     * 				 或    http://www.csdn.net:80 
     * @return 验证成功返回true，验证失败返回false 
     */   
    public static boolean checkURL(String url) {   
        String regex = "(https?://(w{3}\\.)?)?\\w+\\.\\w+(\\.[a-zA-Z]+)*(:\\d{1,5})?(/\\w*)*(\\??(.+=.*)?(&.+=.*)?)?";   
        return Pattern.matches(regex, url);
    }   
    
    /** 
     * 匹配中国邮政编码 
     * @param  postcode 邮政编码 
     * @return 验证成功返回true，验证失败返回false 
     */   
    public static boolean checkPostcode(String postcode) {   
        String regex = "[1-9]\\d{5}";   
        return Pattern.matches(regex, postcode);   
    }   
    
}
