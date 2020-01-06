package util.dome.excel.exceldome;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

/**
 * 传入Excel 并 获取 Excel 中的数据
 * 基于 jxl.jar
 * @author hzw
 */
public class InputExcelDome {
	
	public void inputExcelDome(File excelPath) throws Exception{
		// 将文件读取到项目
		FileInputStream is = new FileInputStream(excelPath);
		// 创建 map 把解析的值放到 map 里
		Map<String,String> map =new HashMap<String, String>();
		// 解析传入的Excel 文件
		Workbook excel=Workbook.getWorkbook(is);
		
		// 遍历 Excel 所有 行
		for(int i=0;i<excel.getNumberOfSheets();i++){
			// 获取第i个子表对象
			Sheet sheet=excel.getSheet(i);
			// 获取当前子表总行数
			int rows = sheet.getRows(); // 每个表格的总行数
			// 如果第一行为标题 对标题行单独处理  通过标题行 获取每个列的内容
			Cell[] rowTile = sheet.getRow(0);
			// 从第二行开始遍历
			for(int j = 1; j<rows;j++){
				// 获取当前行对象
				Cell[] row = sheet.getRow(j);
				// 获取行的总列数
				int rowLeng = row.length;
				for(int f =0;f<rowLeng;f++){
					// 标题对应的数据 标题 key 数据 value
					map.put(rowTile[f].getContents(), row[f].getContents());
				}
				/*********** 
				   	根据标题来获取对应列的值 将通过标题获取到的值 set 到对应 字段 
				   	再调用保存方法传入保存值后的对象 将Excel 数据保存到数据库
				***********/
				/* 列 : map.get("Excel中的列标题名")  取出 第  j 行 对应标题名中的值
				 *  	if(map.get("Excel中的列标题名") != null){
				 * 			
				 * 		}
				 */
			}
		}
		is.close(); // 关闭输入流
	}
	
}
