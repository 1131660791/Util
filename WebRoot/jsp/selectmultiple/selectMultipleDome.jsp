<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String fileUrl = request.getScheme() + "://"
		+ request.getServerName() + ":" + request.getServerPort();
%>
<script type="text/javascript" src="<%=path%>/js/lib/jquery-1.11.1.js"></script>

<!-- select框架  多选框 按 ctrl 多选 -->
	<div>
  		<table>
		    <tr>
		        <td>
		           <select id="k1" size="10" style="width:200px;height:268px;" multiple="multiple">
		                <option ondblclick="addOpt(this)" value="1" id="p1">名称1</option>
		                <option ondblclick="addOpt(this)" value="2" id="p1">名称2</option>
		           </select>
		      </td>
		
		      <td>
		          <input type="button" id="b3" onclick="addAllOpt()" value="==>>"/>
		          <br/><br/>
		          <input type="button" id="b4" onclick="removeAllOpt()" value="<<=="/>
		      </td>

		      <td> 
		           <select id="k2" size="10" style="width:200px;height:268px;" multiple="multiple">
		              	<option ondblclick="removeOpt(this)" value="3">名称5</option> 
		              	<option ondblclick="removeOpt(this)" value="4">名称6</option> 
			    </select>  
		   </td>
		 </tr>
	 </table>
</div>

<script language="javascript">
		// 添加单个为选择信息
	 	function addOpt(sub){
			name = $("#k1").find("option:selected").text();
            if(name!=null){
             	$("#k2").append("<option ondblclick='removeOpt(this)' value="+sub.value+">"+sub.innerHTML+"</option>");
              	$("#k1 option:selected").remove()
            }
	 	}
	 	
	 	// 移除已选择的信息  -- 已选中的信息
	 	function removeOpt(sub){
	 		name= $("#k2").find("option:selected").text();
	         if(name!=null){
		         $("#k1").append("<option ondblclick='addOpt(this)' value="+sub.value+">"+sub.innerHTML+"</option>");
		         $("#k2 option:selected").remove();
	         }
	 	}
	 	
	 	// 添加选中所有信息
	 	function addAllOpt(){
	 		 var objSelect = document.getElementById("k1");
	 		 var delNum = 0;
 		     if (null != objSelect && typeof(objSelect) != "undefined") {
 		        for(var i=0;i<objSelect.options.length;i=i+1) {  
 		            if(objSelect.options[i].selected) {  
 		                $("#k2").append("<option ondblclick='removeOpt(this)' value="+objSelect.options[i].value+">"+objSelect.options[i].innerHTML+"</option>");
 		                objSelect.options.remove(i);
 		                i = i - 1;
 		            }
 		        }
 		     }
	 	}

	 	// 移除已选择选中所有信息
	 	function removeAllOpt(){
	 		var objSelect = document.getElementById("k2");
	 		 var delNum = 0;
		     if (null != objSelect && typeof(objSelect) != "undefined") {
		        for(var i=0;i<objSelect.options.length;i=i+1) {  
		            if(objSelect.options[i].selected) {  
		                $("#k1").append("<option ondblclick='addOpt(this)' value="+objSelect.options[i].value+">"+objSelect.options[i].innerHTML+"</option>");
		                objSelect.options.remove(i);
		                i = i - 1;
		            }
		        }
		     }
	 	}
	 	
		
		// 选中的数据 组合 处理
		function selectOption(){
			var campusIds = "";  // 选中的id 值
			var objSelect = document.getElementById("k2");
			if (null != objSelect && typeof(objSelect) != "undefined") {
		        for(var i=0;i<objSelect.options.length;i=i+1) {
	            	if(i==0){
	            		campusIds = campusIds + objSelect.options[i].value;
	            	}else{
		            	campusIds = campusIds +","+ objSelect.options[i].value;
	            	}
		        }
			}
		}
	</script>

