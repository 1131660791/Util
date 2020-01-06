package util.dome.json.gsondome;

import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

/**
 * 使用  Gson 工具包 
 * @author yixin
 */
public class GsonDome {
	
	/**
	 * 传入 json 字符串 集合  对json字符串 集合  进行 解析 
	 * 注: 传入的每个  json 字符串 字符 都不能为空
	 * [{"classroomapId":1,"fkEquipmentId":1,"apname":"ApName","apipsite":"192.12.2","apport":5120,"aploginname":"aploginName","aploginpass":"aploginpass","note":"备注信息"},{..},{..},..]
	 * @param jsonCollection   json 字符串集合
	 */
	public void analysisJsonCollection(String jsonCollection){
		Gson gson = new Gson();		   // 创建  Gson 对象
		List objectCollection = null;  // 创建类型返回集合  
		if(jsonCollection != null){
														  // new TypeToken<List<需要解析集合的 类 对象>>()
			objectCollection = gson.fromJson(jsonCollection, new TypeToken<List<Object>>(){}.getType());
		}
		// 遍历  对象 集合
		if(objectCollection.size()>0){
			
		}
	}
	
	/**
	 * 
	 */
	
	
}