package util.excel.out;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

/**
 * Excel 工具 - 将流 写入 浏览器 实现 导出
 * @author hzw
 */
public class ExcelOutUtil {
	
	/**
	 * Excel 导出 工具
	 * @param fileName  - 文件名称
	 * @param sheetName - 
	 * @param title     - 列标题
	 * @param values    - 列值
	 * @param wb   	    - 
	 * @param response  - 
	 * @return
	 * @throws IOException 
	 */
	public static void getHSSFWorkbook(String fileName, String sheetName, String[] title, String[][] values,
			 HttpServletResponse response) {
		try {
			HSSFWorkbook wb = new HSSFWorkbook();
			HSSFSheet sheet = wb.createSheet(sheetName);
			HSSFRow row = sheet.createRow(0);
			HSSFCellStyle style = wb.createCellStyle();
			style.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 居中格式
			HSSFCell cell = null;
			// 标题
			for (int i = 0; i < title.length; i++) {
				cell = row.createCell(i);
				cell.setCellValue(title[i]);
				cell.setCellStyle(style);
			}
			// 内容
			for (int i = 0; i < values.length; i++) {
				row = sheet.createRow(i + 1);
				for (int j = 0; j < values[i].length; j++) {
					row.createCell(j).setCellValue(values[i][j]);
				}
			}
			fileName = new String(fileName.getBytes(), "ISO8859-1");
			response.setContentType("application/octet-stream;charset=ISO8859-1");
			response.setHeader("Content-Disposition", "attachment;filename=" + fileName);
			response.addHeader("Pargam", "no-cache");
			response.addHeader("Cache-Control", "no-cache");
			OutputStream os = response.getOutputStream();
			wb.write(os);
			os.flush();
			os.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	// Excel导出Dome
	public static void downWorkExcelDome(HttpServletResponse response) throws IOException{
        String fileName = "工作量指标统计"+System.currentTimeMillis()+".xls"; //文件名 
        String sheetName = "工作量指标统计"; //sheet 名
        // 标题
        String [] title = new String[]{"序列","项目名称","咨询件数"};
        
        // 模拟数据
        List<Map<String, Object>> list =  new ArrayList<Map<String, Object>>();
        Map<String, Object> s= new HashMap();
        s.put("1", 111);
        list.add(s);
        s.put("aa", "sss");
        list.add(s);
        s.put("dd", "999");
        list.add(s);
        
        String [][]values = new String[3][];
        for(int i=0;i<list.size();i++){
            values[i] = new String[title.length];
            // 将对象内容转换成string
            Map<String, Object> obj = list.get(i);
            values[i][0] = obj.get("1").toString();
            values[i][1] = obj.get("aa").toString();
            values[i][2] = obj.get("dd").toString();
        }
        ExcelOutUtil.getHSSFWorkbook(fileName,sheetName, title, values,response);
	}
	
	
	// test
	public static void main(String[] args,HttpServletResponse response) throws IOException {
		ExcelOutUtil.downWorkExcelDome(response);
	}
	
}
