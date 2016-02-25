<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="content-type" content="text/html; charset=utf-8" />
    <title>微信管理后台</title>
	<link rel="stylesheet" href="<%=request.getContextPath()%>/css/rightCommon.css">
	<link rel="stylesheet" href="<%=request.getContextPath()%>/css/common.css">
	
	<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery.min.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/plugin/layer/layer.js"></script>
</head>
<body>
<div class="mainSemt">
	<div class="navigateItem pl20">
		系统管理>管理员管理>管理员详情
	</div>
	<div class="rightMain p10">
		<table width="100%" class="detailBus">
			<tr>
				<td>昵称：${adminInfo.nickName}</td>
				<td>性别：<c:if test="${adminInfo.sex == '0'}">男</c:if><c:if test="${adminInfo.sex == '1'}">女</c:if></td>
				<td>年龄：${adminInfo.age}</td>
				<td>创建时间：${adminInfo.createTime}</td>
			</tr>
			<tr>
				<td colspan="2">地址：${adminInfo.address}</td>
				<td colspan="2">手机号码：${adminInfo.phoneNumber}</td>
			</tr>
			<tr>
    			<td colspan="2">用户名：${adminInfo.username}</td>
    			<td colspan="2">密码：${adminInfo.password}</td>
			</tr>
		</table>
		<div class="tc lh30 mt20">
    		<span class="btnBlue Blackdetail whitefc cursor" onclick="closeIf();">关闭</span>
    	</div>
	</div>
</div>
<script>
	var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
	//关闭窗口并刷新页面
	function closeIf(){
        parent.layer.close(index);
	}
	
	
</script>
</body>
</html>