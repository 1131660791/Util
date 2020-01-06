package util.uuid;

import java.util.UUID;

/**
 * UUID 工具类
 * @author hzw
 */
public class UUIDUtil {

	/**
	 * 创建UUId
	 * @return
	 */
	public static UUID getUUID(){
	 	UUID Uuid= UUID.randomUUID();
		return Uuid ;
	}
	
}
