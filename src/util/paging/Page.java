package util.paging;
import java.io.Serializable;  
import java.util.ArrayList;  
import java.util.List;
import com.google.gson.Gson;

/** 
 * 	
 * @Copyright 
 * @author hzw
 * @Date:2015年9月10日
 * 储存分页处理工具类   在调用此类的方法之前需设置总页数(即得先从数据库查询到相应数据的数据量)
 */
public class Page implements Serializable {  
  
	/**
	 * 
	 */
	private static final long serialVersionUID = -4076251710795431210L;
	
	private Integer showCount = 10;//获取查询数来的总数目
    private int totalPage;// 总的页数
    private int totalResult;// 总的数目
    private int currentPage=1;// 当前页 
    private int currentResult;// 当前记录数 
    private List list;
    private String listJson;// listJson字符串
    
    // private int page=1;

    public List getList() {
		return list;
	}
	public void setList(List list) {
		this.list = list;
	}
	private String sortField;
    private String order;
    
    // private Map<String,Object> params= new HashMap<String,Object>();//其他的参数我们把它分装成一个Map对象  
  
  /*  
    public PageInfo(){
    	this(1);
	}
    public PageInfo(int currentPage){
    	//默认每页显示10条记录
    	this(currentPage, 10);
    }
  */
    
	public int getShowCount() {
		return showCount;
	}
	public void setShowCount(Integer showCount) {
		if(showCount!=null){
			this.showCount = showCount;
		}
	}
	public int getTotalPage() {
		totalPage = (totalResult+showCount-1)/showCount;
		return totalPage;
	}
	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}
	public int getTotalResult() {
		return totalResult;
	}
	public void setTotalResult(Integer totalResult) {
		this.totalResult = totalResult;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(Integer currentPage) {
		if(currentPage!=null){
			if(currentPage<=0){
				this.currentPage = 1;
			}else{
				this.currentPage = currentPage;
			}
		}
	}
	public int getCurrentResult() {
		return (currentPage-1)*showCount;
	}
	public void setCurrentResult(Integer currentResult) {
		this.currentResult = currentResult;
	}
	public String getSortField() {
		return sortField;
	}
	public void setSortField(String sortField) {
		this.sortField = sortField;
	}
	public String getOrder() {
		return order;
	}
	public void setOrder(String order) {
		this.order = order;
	}
	
	/*public Map<String, Object> getParams() {
		return params;
	}
	public void setParams(Map<String, Object> params) {
		this.params = params;
	}*/
	/*public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}*/
	
	public String toString(){
		StringBuilder builder = new StringBuilder();
		builder.append("Page [currentPage=")
				.append(currentPage).append(", showCount=")
				.append(showCount).append(",currentResult=")
				.append(currentResult).append(", totalPage=")
				.append(totalPage).append(", totalResult=")
				.append(totalResult).append("]");
		return builder.toString();
	}
	public String getListJson() {
		return listJson;
	}
	public void setListJson(String listJson) {
		this.listJson = listJson;
	}
	
	public static void main(String[] args) {
		StringBuffer str = new StringBuffer();
		str.append(" {'showCount':10,'totalPage':0,'totalResult':33,'currentPage':1,'currentResult':0,'list':[{'minicourseId':164,'level':1,'minicourseName':'测试视频（指定到初二二班）','fileUrl':'6\\minicourse\\2015-06-26\\ee913a6a-276f-4190-84cf-840540a24c98.mp4','browserUrl':'/file/6/minicourse/2015-06-26/ee913a6a-276f-4190-84cf-840540a24c98.mp4','browserCoverImageUrl':'/file/null','fileName':'测试视频','suffix':'mp4','fileSize':18084.0,'totalTime':0,'sysSubject':{'subjectName':'语文'},'ttKnowledge':{'knowledgeName':'hello world2','childTtKnowledges':[]},'playnum':7,'iscollect':0,'collectnum':2,'publishTime':'Jun 29, 2015 3:03:35 PM','createTeacherId':'344861e0-b0d4-4be4-ad34-cec5988c8e4c','createTeacherName':'Teacher03','introduction':'测试视频（指定到初二二班）','readrecordId':135,'submitQuestionNum':0,'questionNum':0,'attachmentNum':0},{'minicourseId':176,'level':1,'minicourseName':'hello world1','fileUrl':'1\\minicourse\\2015-06-26\\a478c98a-85c3-4caf-be83-861adf44107c\\345fcb91-92eb-498e-b131-ee4bd9ac5247.mp4','browserUrl':'/file/1/minicourse/2015-06-26/a478c98a-85c3-4caf-be83-861adf44107c/345fcb91-92eb-498e-b131-ee4bd9ac5247.mp4','browserCoverImageUrl':'/file/1/minicourse/2015-06-26/a478c98a-85c3-4caf-be83-861adf44107c/c2561035-a130-40b0-8bca-acaa777cee89_VedioThumb.jpg','fileName':'345fcb91-92eb-498e-b131-ee4bd9ac5247.mp4','suffix':'mp4','fileSize':348163.0,'totalTime':0,'sysSubject':{'subjectName':'语文'},'ttKnowledge':{'knowledgeName':'hello world1','childTtKnowledges':[]},'playnum':28,'iscollect':1,'collectnum':2,'publishTime':'Jun 26, 2015 2:28:56 PM','createTeacherId':'8b69010d-c6f4-453e-94c6-857e6b5fa1e0','createTeacherName':'刘邯亮','introduction':'edtgdfgdfg','readrecordId':126,'submitQuestionNum':0,'questionNum':2,'attachmentNum':4},{'minicourseId':175,'level':1,'minicourseName':'语文知识点2','fileUrl':'1\\minicourse\\2015-06-26\\8b6b6315-65a1-4fb4-8e88-e60ff9000d91\\5ae90fe9-2181-4cd4-adc8-f7b19ee75f99.mp4','browserUrl':'/file/1/minicourse/2015-06-26/8b6b6315-65a1-4fb4-8e88-e60ff9000d91/5ae90fe9-2181-4cd4-adc8-f7b19ee75f99.mp4','browserCoverImageUrl':'/file/','fileName':'5ae90fe9-2181-4cd4-adc8-f7b19ee75f99.mp4','suffix':'mp4','fileSize':97861.0,'totalTime':0,'sysSubject':{'subjectName':'语文'},'ttKnowledge':{'knowledgeName':'语文知识点2','childTtKnowledges':[]},'playnum':2,'iscollect':0,'collectnum':1,'publishTime':'Jun 26, 2015 2:25:04 PM','createTeacherId':'8b69010d-c6f4-453e-94c6-857e6b5fa1e0','createTeacherName':'刘邯亮','introduction':'sdfsdfsdf','readrecordId':128,'submitQuestionNum':0,'questionNum':0,'attachmentNum':9},{'minicourseId':174,'level':1,'minicourseName':'hello world1','fileUrl':'1\\minicourse\\2015-06-26\\0b2e4346-937a-4faf-8e4e-5eb74ba65f9e.mp4','browserUrl':'/file/1/minicourse/2015-06-26/0b2e4346-937a-4faf-8e4e-5eb74ba65f9e.mp4','browserCoverImageUrl':'/file/','fileName':'0b2e4346-937a-4faf-8e4e-5eb74ba65f9e.mp4','suffix':'mp4','fileSize':197099.0,'totalTime':0,'sysSubject':{'subjectName':'语文'},'ttKnowledge':{'knowledgeName':'hello world1','childTtKnowledges':[]},'playnum':1,'iscollect':0,'collectnum':1,'publishTime':'Jun 26, 2015 2:15:45 PM','createTeacherId':'8b69010d-c6f4-453e-94c6-857e6b5fa1e0','createTeacherName':'刘邯亮','introduction':'\n ','readrecordId':136,'submitQuestionNum':0,'questionNum':0,'attachmentNum':3},{'minicourseId':173,'level':1,'minicourseName':'做了个复杂查询的页面，字段太多了，填了一次，想清空挺麻烦的','fileUrl':'1\\minicourse\\2015-06-26\\a148557d-041d-4463-9c01-d61a476af9b5.mp4','browserUrl':'/file/1/minicourse/2015-06-26/a148557d-041d-4463-9c01-d61a476af9b5.mp4','browserCoverImageUrl':'/file/null','fileName':'a148557d-041d-4463-9c01-d61a476af9b5.mp4','suffix':'mp4','fileSize':110114.0,'totalTime':0,'sysSubject':{'subjectName':'语文'},'ttKnowledge':{'knowledgeName':'做了个复杂查询的页面，字段太多了，填了一次，想清空挺麻烦的22','childTtKnowledges':[]},'playnum':4,'iscollect':0,'collectnum':2,'publishTime':'Jun 26, 2015 12:03:46 PM','createTeacherId':'8b69010d-c6f4-453e-94c6-857e6b5fa1e0','createTeacherName':'刘邯亮','introduction':'\n ','readrecordId':130,'submitQuestionNum':0,'questionNum':0,'attachmentNum':7},{'minicourseId':172,'level':1,'minicourseName':'hello world1','fileUrl':'1\\minicourse\\2015-06-26\\e628332a-0cd4-4c01-aed8-fc952c5161e1.mp4','browserUrl':'/file/1/minicourse/2015-06-26/e628332a-0cd4-4c01-aed8-fc952c5161e1.mp4','browserCoverImageUrl':'/file/null','fileName':'e628332a-0cd4-4c01-aed8-fc952c5161e1.mp4','suffix':'mp4','fileSize':386211.0,'totalTime':0,'sysSubject':{'subjectName':'语文'},'ttKnowledge':{'knowledgeName':'hello world1','childTtKnowledges':[]},'playnum':1,'iscollect':0,'collectnum':1,'publishTime':'Jun 26, 2015 12:00:57 PM','createTeacherId':'8b69010d-c6f4-453e-94c6-857e6b5fa1e0','createTeacherName':'刘邯亮','introduction':'sdssfsdf','readrecordId':137,'submitQuestionNum':0,'questionNum':0,'attachmentNum':6},{'minicourseId':171,'level':1,'minicourseName':'语文知识点3','fileUrl':'1\\minicourse\\2015-06-26\\3b020925-691f-4158-b5c5-701ce296aa7f.mp4','browserUrl':'/file/1/minicourse/2015-06-26/3b020925-691f-4158-b5c5-701ce296aa7f.mp4','browserCoverImageUrl':'/file/null','fileName':'3b020925-691f-4158-b5c5-701ce296aa7f.mp4','suffix':'mp4','fileSize':348163.0,'totalTime':0,'sysSubject':{'subjectName':'语文'},'ttKnowledge':{'knowledgeName':'语文知识点3','childTtKnowledges':[]},'playnum':2,'iscollect':0,'collectnum':2,'publishTime':'Jun 26, 2015 11:54:27 AM','createTeacherId':'8b69010d-c6f4-453e-94c6-857e6b5fa1e0','createTeacherName':'刘邯亮','introduction':'\n ','readrecordId':138,'submitQuestionNum':0,'questionNum':0,'attachmentNum':2}]} ");

//		Page page = new Gson().fromJson(str.toString(), com.sclbxx.util.page.Page.class);
	//	System.out.println(page);
		
	}
}  