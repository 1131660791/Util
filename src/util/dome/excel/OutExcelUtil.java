package util.dome.excel;

import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

/**
 * 数据导出为Excel 工具类 Dome 需要自己修改
 * @author yixin
 */
public class OutExcelUtil {
	// 时间转换工具
	public String toDateStr(Date date,String format){
		if(date == null) return "";
		SimpleDateFormat sdf=new SimpleDateFormat(format);
		return sdf.format(date);
	}
	// Integer 转  String 
	public String toIntegerStr(Integer integer){
		if(integer == null){
			return "0";
		}else{
			return integer.toString();
		}
	}
	
	/**
	 * 
	 * @param fileName 保存路径
	 * @param teacherWorkStatisticsList 需要导出数据 集合
	 */
	// 列表导出
	public void outXlsDome(String fileName, List<Object> teacherWorkStatisticsList){
		try {
			String switchStr ="";
			Object teacherWorkStatisticsVo; // 老师工作统计
			File outfile = new File(fileName);
			if(outfile.exists()){
				outfile.delete();
			}
			// 标题
			String[] headerNames={
				"姓名/项目","智慧课堂使用","备课次数","作业布置次数",
				"微课制作个数","微课堂布置","试题上传次数"
			};
			//Excel 文件名称  开始输出Execl
			String sheetName="教师统计报表信息";
			HSSFWorkbook workbook =new HSSFWorkbook();
			HSSFSheet sheet = workbook.createSheet();
			workbook.setSheetName(0, sheetName);
			// 风格
			HSSFCellStyle cs =workbook.createCellStyle();
			HSSFCellStyle csdate = workbook.createCellStyle();
			// 字体
			HSSFFont font = workbook.createFont();
			font.setFontHeightInPoints((short)9);
			font.setFontName("宋体");
			cs.setFont(font);
			csdate.setFont(font);
			//日期格式
			short df =workbook.createDataFormat().getFormat("yyy-MM-dd HH:mm:ss");
			csdate.setDataFormat(df);
			//
			HSSFRow row = sheet.createRow((short)0);
			HSSFCell cell;
			int iColumn=0;
			
			iColumn = headerNames.length;
			for(int i=0;i< iColumn; i++){
				cell = row.createCell((short)i);
				cell.setCellType(HSSFCell.CELL_TYPE_STRING);
				cell.setCellStyle(cs);
				cell.setCellValue(headerNames[i]);
			}
			// 遍历出集合的列  -作为内容放入 Excel 字段
			String ConllectionContent = "遍历出集合的列";
			// 写入表格内容
			int j= 0;
			for(int i=0;i<teacherWorkStatisticsList.size();i++){
				 teacherWorkStatisticsVo = teacherWorkStatisticsList.get(i);
				 row = sheet.createRow((short)i+1);
				 j=0;
				 // 姓名/项目
				 switchStr = ConllectionContent;
				 cell=row.createCell((short) j++);
				 cell.setCellStyle(cs);
				 cell.setCellType(HSSFCell.CELL_TYPE_STRING);
				 cell.setCellValue(switchStr);
				 
				 // 智慧课堂使用
				 switchStr = ConllectionContent;
				 cell=row.createCell((short) j++);
				 cell.setCellStyle(cs);
				 cell.setCellType(HSSFCell.CELL_TYPE_STRING);
				 cell.setCellValue(switchStr);
				 
				 // 备课次数
				 switchStr = ConllectionContent;
				 cell=row.createCell((short) j++);
				 cell.setCellStyle(cs);
				 cell.setCellType(HSSFCell.CELL_TYPE_STRING);
				 cell.setCellValue(switchStr);
				 
				 // 作业布置次数
				 switchStr = ConllectionContent;
				 cell=row.createCell((short) j++);
				 cell.setCellStyle(cs);
				 cell.setCellType(HSSFCell.CELL_TYPE_STRING);
				 cell.setCellValue(switchStr);
				 
				 //	微课制作个数
				 switchStr = ConllectionContent;
				 cell=row.createCell((short) j++);
				 cell.setCellStyle(cs);
				 cell.setCellType(HSSFCell.CELL_TYPE_STRING);
				 cell.setCellValue(switchStr);
				
				 // 微课堂布置
				 switchStr = ConllectionContent;
				 cell=row.createCell((short) j++);
				 cell.setCellStyle(cs);
				 cell.setCellType(HSSFCell.CELL_TYPE_STRING);
				 cell.setCellValue(switchStr);
				 
				 // 试题上传次数
				 switchStr = ConllectionContent;
				 cell=row.createCell((short) j++);
				 cell.setCellStyle(cs);
				 cell.setCellType(HSSFCell.CELL_TYPE_STRING);
				 cell.setCellValue(switchStr);
			}
			
				FileOutputStream fileOut = new FileOutputStream(fileName);
				workbook.write(fileOut);// 将数据写出到 
				fileOut.flush();
				fileOut.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
