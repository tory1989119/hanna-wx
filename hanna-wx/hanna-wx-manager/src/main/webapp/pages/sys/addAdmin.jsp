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
		系统管理>管理员管理>新增管理员
	</div>
	<div class="rightMain p10">
		<div class="rightMain p10 w600 autoCenter">
				<div>
					<form id="mainform" name="mainform" method="post" action="insertAdminInfo.htm">
						<div class="lh35 mb20">
							<span class="fl wp16 tr">昵称：</span>
							<input type="text" class="input-control h35  pl5 pr5 wp80" name="nickName" id="nickName">
						</div>
						<div class="lh35 mb20">
							<span class="fl wp16 tr">性别：</span>
							<span>
　　　　　　						　男　<input name="sex" type="radio" id="men" checked=" checked" value="1"/>　　
				 　　　　　　		　女　<input name="sex" type="radio" id="women" value="2"/>
							</span>
						</div>
						<div class="lh35 mb20">
							<span class="fl wp16 tr">年龄：</span>
							<input type="text" class="input-control h35  pl5 pr5 wp80" name="age" value="1" id="age">
						</div>
						<div class="lh35 mb20">
							<span class="fl wp16 tr">地址：</span>
							<input type="text" class="input-control h35  pl5 pr5 wp80" name="address" id="address">
						</div>
						<div class="lh35 mb20">
							<span class="fl wp16 tr">手机号码：</span>
							<input type="text" class="input-control h35  pl5 pr5 wp80" name="phoneNumber" id="phoneNumber">
						</div>
						<div class="lh35 mb20">
							<span class="fl wp16 tr">用户名：</span>
							<input type="text" class="input-control h35  pl5 pr5 wp80" name="username" id="username">
						</div>
						<div class="lh35 mb20">
							<span class="fl wp16 tr">密码：</span>
							<input type="password" class="input-control h35  pl5 pr5 wp80" name="password" id="password">
						</div>
						<div class="tc lh35 mt20">　　　　
							<span class="btnGriy Blackdetail cursor mr20" onclick="closeIf();">
									取消
							</span>　　　　　　　　　
							<span class="btnBlue Blackdetail whitefc cursor mr20" onclick="add();">
									添加
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
	function add(){
		
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
		if(username.length<6){ 
 			layer.tips('用户名至少6位', '#username', {
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
 		if(password.length<6){ 
 			layer.tips('密码至少6位', '#password', {
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
 		var sex = $('input[name="sex"]:checked').val();
 		var address = document.getElementById("address").value;
		$.ajax({
			url: "insertAdminInfo.htm",
			datatype: 'json',
			type: "post",
			data: {
				nickName:nickName,
				sex:sex,
				age:age,
				address:address,
				phoneNumber:phoneNumber,
				username:username,
				password:password
				
			},
			success: function (data) {
				if (data.flag == '1' && data.errorCode == '10000') {
					closeIf();
				}else{
					layer.alert(data.content, {icon: 6});
				}
			}
		});
	}
	
</script>
</body>
</html>