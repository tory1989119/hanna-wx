<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="description" content="海象网络科技(杭州)有限公司" />
	<meta name="robots" content="All|None|Index|Noindex|Follow|Nofollow" />
	<meta name="author" content="海象网络科技(杭州)有限公司" />
	<meta name="copyright" content="© Walrushz.com All rights reserved" />
	<title>物流APP后台管理系统</title>
	<link rel="stylesheet" href="$request.getContextPath()/css/rightCommon.css">
	<link rel="stylesheet" href="$request.getContextPath()/css/common.css">
	
	<script type="text/javascript" src="$request.getContextPath()/js/jquery.min.js"></script>
	<script type="text/javascript" src="$request.getContextPath()/plugin/layer/layer.js"></script>
</head>
<body>
<div class="mainSemt">
	<div class="navigateItem pl20">
		系统管理>管理员管理>管理员详情
	</div>
	<div class="rightMain p10">
		<table width="100%" class="detailBus">
			<tr>
				<td>昵称：$adminInfo.nickName</td>
				
				#if($adminInfo.sex == 1)
					<td>性别：男</td>
				#elseif($adminInfo.sex==2)
					<td>性别：女</td>
				#elseif($adminInfo.sex==$null)
					<td>性别：无</td>
				#end
					
				#if($adminInfo.age != $null)
					<td>年龄：$adminInfo.age</td>
				#else
					<td>年龄：无</td>
				#end
				<td>创建时间：$adminInfo.createTime</td>
			</tr>
			<tr>
				#if($adminInfo.address != $null)
					<td colspan="2">地址：$adminInfo.address</td>
				#else
					<td colspan="2">地址：无</td>
				#end
				#if($adminInfo.phoneNumber != $null)
					<td colspan="2">手机号码：$adminInfo.phoneNumber</td>
				#else
					<td colspan="2">手机号码：无</td>
				#end
			</tr>
			<tr>
				#if($adminInfo.username != $null)
    				<td colspan="2">用户名：$adminInfo.username</td>
				#else
					<td colspan="2">用户名：无</td>
				#end
				
				#if($adminInfo.password != $null)
    				<td colspan="2">密码：$adminInfo.password</td>
    			#else	
    				<td colspan="2">密码：无</td>
    			#end
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