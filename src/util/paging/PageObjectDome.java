package util.paging;

import javax.servlet.http.HttpServletRequest;

import com.google.gson.Gson;

/**
 * 分页用列类
 * @author hzw
 */
public class PageObjectDome {
	
	
	// 分页dome 调用后台类
	public void forwardPageGridDome(Integer currentPage,Integer showCount,HttpServletRequest request){
		Page page = new Page();
		page.setCurrentPage(currentPage); // 开始页
		page.setShowCount(showCount); // 每页显示条数 
		// 查询分页语句
		// ...
		
		
		// 查询出 总页数 并 传入
		page.setTotalResult(100);
		
		// 此分页 方法 只能 接收 json 类型的 分页信息
		request.setAttribute("page", new Gson().toJson(page));
	}
	
}
