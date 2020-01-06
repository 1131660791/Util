<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
<!--  一: 加载文本编辑器css 样式 -->
<link rel="stylesheet" href="../../../extend/zj/kindeditor-4.1.10/themes/default/default.css" />

<title>首页</title>
</head>
<body>

<!-- 二: 引入以下 两个 文本编辑器 的 两个 js 引入时注意放到 body 标签下 才能够 读取  -->
<script charset="utf-8" src="../../../extend/zj/kindeditor-4.1.10/kindeditor-min.js"></script>
<script charset="utf-8" src="../../../extend/zj/kindeditor-4.1.10/lang/zh_CN.js"></script>

	<div align="center">
				<table class="tableForm">
					<tr>
						<th style="padding-bottom: 200px;">内&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;容：</th>
						 <td>
											<!-- 文本编辑器:: 使用方式 -->
											<textarea id="contents" name="content" style="width: 800px; height: 400px;"></textarea>
						 </td>
					</tr>
				</table>
	</div>

<!-- 三: 加入生成 文本编辑器js 方法 -->
 	<script type="text/javascript">
		 $(function(){
		    var editor;
		    window.editor = KindEditor.create("#contents",{
	            resizeType:1,
	            uploadJson: "<%=request.getContextPath()%>/static/kindeditor-4.1.10/jsp/upload_json.jsp",  // 上传 图片 功能需要加入
	           	fileManagerJson:"<%=request.getContextPath()%>/static/kindeditor-4.1.10/jsp/file_manager_json.jsp", // 上传图片功能需要加入
	          	allowFileManager : true,
	          	afterBlur: function(){  // 编辑器市区焦点，同步数据
	          		this.sync();
	          	} 
			});
		 });
	</script> 


</body>
</html>