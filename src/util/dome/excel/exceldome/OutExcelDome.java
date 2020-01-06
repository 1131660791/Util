package util.dome.excel.exceldome;

import java.io.File;
import java.util.Date;
import java.util.List;

import util.dome.excel.OutExcelUtil;

public class OutExcelDome {
	
	public static void outExcelDome(String args[]){
		OutExcelUtil outXls = new OutExcelUtil();
		String saveUrl = "D:/savePath/"; // 将生成的 Excel 文件 保存到  D 盘
		
		File f = new File(saveUrl);
		
		if(!f.exists()){ 	// 判断是否创建本文件夹
			f.mkdir();
		}
		String fileName; //下载地址

		fileName = saveUrl + "教师报表统计" + "["+outXls.toDateStr(new Date(), "yyMMddHHmmss")+"].xls";

	  	List list = null; // 列 - 需要导出的数据集合

	  	// 调用导出 excel 方法
	  	outXls.outXlsDome(fileName,list);
	}
	
	
}
