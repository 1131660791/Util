package util.ajax;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.UUID;

import javax.servlet.http.HttpServletResponse;

public class AjaxUtil {
	/**
	 * Ajax 将输出的内容编码指定为UTF-8
	 * @param message
	 * @param response
	 * @return
	 */
	public static String ajaxResponse(String message,HttpServletResponse response) {
		try {
			 response.setContentType("text/html;UTF-8");
			 response.setCharacterEncoding("UTF-8");
			 PrintWriter w = response.getWriter();
			 w.write(message);
			 w.flush();
			 w.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		 return null;
	}
	
	public static void main(String[] args) {
		UUID uuid = UUID.randomUUID();
		System.out.println(uuid);
	}
}
