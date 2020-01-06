package util.paging;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.BodyContent;
import javax.servlet.jsp.tagext.BodyTagSupport;



/**
 * @author desert
 * 
 */
public class TagLibLimit extends BodyTagSupport{

	private static final long serialVersionUID = 1L;
	private String  userId="0"; //获取外部参数
	private String  organizId=""; //组织机构ID
	private String  schoolAreaId = "";//校区属性
	private String  type = "";//add,delete,update
	
	public int doStartTag()throws JspTagException{
		return EVAL_BODY_BUFFERED;	
	}
	public void setBodyContent(BodyContent bodyContent){ 
	  this.bodyContent =bodyContent;
	} 

	/**
	 * @see 执行完BODY后要干的事情
	 */
	public int doAfterBody()throws JspTagException{
		
		 HttpServletRequest request = (HttpServletRequest) pageContext
		    .getRequest();
		HttpSession session = request.getSession();
		
		boolean   limit_state = false;
         
		int  weight = 0 ;
		Object weight_object = session.getAttribute("navigaitWeight");
		if(weight_object!=null){
			weight = Integer.valueOf(weight_object.toString());
		}
         
		if(weight<4){
			limit_state = true;
		}
		
		if(limit_state){
			JspWriter  jw = this.bodyContent.getEnclosingWriter();
		    String content = this.bodyContent.getString();
		    System.out.println("标签体中的内容"+content);
		    
		    
		     //???匹配字符串有问题
		    Pattern p_input = Pattern.compile("<input(.|\\s)+/?>",Pattern.CASE_INSENSITIVE); //过滤input字符串
		    Matcher  matcher_input = p_input.matcher(content);
		    StringBuffer  sb_input = new StringBuffer();
		    while(matcher_input.find()){
		    	/* String  match_str = matcher_input.group();
			   match_str = match_str.replaceAll("onclick","style='display:none' id");
			   System.out.println("_________"+match_str);*/
			   matcher_input.appendReplacement(sb_input, ""); 
		    }
		    matcher_input.appendTail(sb_input);
		    
		    System.out.println("sb_input过滤后的字符串 "+sb_input);
		    
		    Pattern p_image = Pattern.compile("<img(.|\\s)+/?>"); //过滤input字符串
		    Matcher  matcher_image = p_image.matcher(sb_input);
		    StringBuffer  sb_image = new StringBuffer();
		    while(matcher_image.find()){
			/*   String  match_str = matcher_image.group();
			   match_str = match_str.replaceAll("onclick","style='display:none' id");*/
			   matcher_image.appendReplacement(sb_image, ""); 
		    }
		    matcher_image.appendTail(sb_image);
		    
		     System.out.println("sb_image过滤后的字符串 "+sb_image);
		    
		    
		    Pattern p_a = Pattern.compile("<a.+>(.|\\s)+</a>");//过滤a的字符串
		    Matcher  matcher_a = p_a.matcher(sb_image);
		    StringBuffer  sb_a = new StringBuffer();
		    while(matcher_a.find()){
		    	  String  match_str = matcher_a.group();
		    	 //  log.info("子串的内容........"+match_str);
				   match_str = match_str.replaceAll("href","style='color:gray;text-decoration:none;' id");
				   match_str = match_str.replaceAll("onclick", "name");
				   matcher_a.appendReplacement(sb_a, match_str); 
		    }
		    
		    matcher_a.appendTail(sb_a);

		     System.out.println("最后输出的字符串 "+sb_a);
		    
		    try {
				 jw.println(sb_a);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}else{
			JspWriter  jw = this.bodyContent.getEnclosingWriter();
		    String content = this.bodyContent.getString();
		    try {
				 jw.println(content);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    
		}
	
		return SKIP_BODY ;
	}
   
	public int doEndTag()throws JspTagException{
			
		return EVAL_PAGE;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getOrganizId() {
		return organizId;
	}
	public void setOrganizId(String organizId) {
		this.organizId = organizId;
	}
	public String getSchoolAreaId() {
		return schoolAreaId;
	}
	public void setSchoolAreaId(String schoolAreaId) {
		this.schoolAreaId = schoolAreaId;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
}
