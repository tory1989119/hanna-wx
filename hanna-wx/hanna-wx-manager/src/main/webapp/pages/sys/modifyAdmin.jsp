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
	<script type="text/javascript" src="$request.getContextPath()/js/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="$request.getContextPath()/plugin/layer/layer.js"></script>
</head>
<body>
<div class="mainSemt">
	<div class="navigateItem pl20">
		系统管理>管理员管理>修改管理员信息
	</div>
	<div class="rightMain p10">
		<div class="rightMain p10 w600 autoCenter">
				<div>
					<form id="mainform" name="mainform" method="post" action="insertAdminInfo.htm">
						<div class="lh35 mb20">
							<input type="hidden" class="input-control h35  pl5 pr5 wp80" name="id" id="id" value="$adminInfo.id">
							<input type="hidden" class="input-control h35  pl5 pr5 wp80" name="isDeleted" id="isDeleted" value="0">
							<span class="fl wp16 tr">昵称：</span>
							<input type="text" class="input-control h35  pl5 pr5 wp80" name="nickName" id="nickName" value="$adminInfo.nickName">
						</div>
						<div class="lh35 mb20">
							<span class="fl wp16 tr">性别：</span>
							<span>
								 #if($adminInfo.sex == 1)
　　　　　　						　	男　<input name="sex" type="radio" id="men" checked=" checked" value="1"/>　　
				 　　　　　　		　	女　<input name="sex" type="radio" id="women" value="2"/>
								 #else
			　　　　　　　				男　<input name="sex" type="radio" id="men"  value="1"/>　　
				 　　　　　　		　	女　<input name="sex" type="radio" id="women" checked=" checked" value="2"/>
								 #end
							</span>
						</div>
						<div class="lh35 mb20">
							<span class="fl wp16 tr">年龄：</span>
							<input type="text" class="input-control h35  pl5 pr5 wp80" name="age" value="$adminInfo.age" id="age">
						</div>
						<div class="lh35 mb20">
							<span class="fl wp16 tr">地址：</span>
							<input type="text" class="input-control h35  pl5 pr5 wp80" name="address" value="$adminInfo.address">
						</div>
						<div class="lh35 mb20">
							<span class="fl wp16 tr">手机号码：</span>
							<input type="text" class="input-control h35  pl5 pr5 wp80" name="phoneNumber" id="phoneNumber" value="$adminInfo.phoneNumber">
						</div>
						<div class="lh35 mb20">
							<span class="fl wp16 tr">用户名：</span>
							<input type="text" class="input-control h35  pl5 pr5 wp80" name="username" id="username" value="$adminInfo.username">
						</div>
						<div class="lh35 mb20">
							<span class="fl wp16 tr">密码：</span>
							<input type="password" class="input-control h35  pl5 pr5 wp80" name="password" id="password" value="$adminInfo.password">
						</div>
						<div class="tc lh35 mt20">　　　　
							<span class="btnGriy Blackdetail cursor mr20" onclick="closeIf();">
									取消
							</span>　　　　　　　　　
							<span class="btnBlue Blackdetail whitefc cursor mr20" onclick="modify();">
									修改
							</span>
						</div>
					</form>	
				</div>
    	</div>
	</div>
</div>
<script>
	var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
	//关闭窗口并刷新页面
	function closeIf(){
		parent.search(parseInt(parent.$('.active').attr('jp-data')));
        parent.layer.close(index);
	}
	function modify(){
		var nickName = document.getElementById("nickName").value;
		if(nickName==''){ 
 			layer.tips('请输入昵称', '#nickName', {
				tipsMore: true,
			    tips: [2, '#3E7FE7']
			}); 
			return false; 
 		}
		var username = document.getElementById("username").value;
		if(username==''){ 
 			layer.tips('请输入用户名', '#username', {
				tipsMore: true,
			    tips: [2, '#3E7FE7']
			}); 
			return false; 
 		}
		var password = document.getElementById("password").value;
		if(password==''){ 
 			layer.tips('请输入密码', '#password', {
				tipsMore: true,
			    tips: [2, '#3E7FE7']
			}); 
			return false; 
 		}
		var age = document.getElementById("age").value;
		if(age==''){ 
 			document.getElementById("age").value = 1;
 		}
 		var phoneNumber = document.getElementById("phoneNumber").value;
 		if(phoneNumber!=''){
			if(!(/^1\d{10}$/.test(phoneNumber))){ 
	 			layer.tips('请输入正确的手机号码', '#phoneNumber', {
					tipsMore: true,
				    tips: [2, '#3E7FE7']
				}); 
				return false; 
	 		}
 		}
 		$('#mainform').form('submit', {
			url:"updateAdminInfo.htm", 
			success:function(data){  
			    closeIf();
			}
		});
	}
	
</script>
</body>
</html>