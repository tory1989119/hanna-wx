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
		<link rel="stylesheet" href="$request.getContextPath()/css/login.css">
		<link rel="stylesheet" href="$request.getContextPath()/css/common.css">
			
		<script type="text/javascript" src="$request.getContextPath()/js/jquery.min.js"></script>
		<script type="text/javascript" src="$request.getContextPath()/js/login.js"></script>
		<script type="text/javascript" src="$request.getContextPath()/plugin/layer/layer.js"></script>
		<!–[if lt IE 9]> 	
    		<style>
    			html,body{
    				filter:progid:DXImageTransform.Microsoft.AlphaImageLoader(src=images/loginBg.jpg,sizingMethod=scale)
    			}
    		</style>
    	<![endif]–>

	</head>
	<body>
	<div class="loginMain">
		<h1 class="f26 whitefc">
			易货物流app后台管理系统
		</h1>
		<div class="loginBgbody pr">
			<div class="loginLogo pa">
				<img src="images/logoAdmin.png" class="img-responsive">
			</div>
			<div class="pa loginUsr">
				<div class="namefc f24 mb10">
					用户名/username
				</div>
				<div>
					<input type="text" class="w300 p10" id="username" name="username" value="888888"/>
				</div>
				<div class="namefc f24 mt20 mb10">
					密码/password
				</div>
				<div>
					<input type="password" class="w300 p10" id="password" name="password" value="888888"/>
				</div>
				<div class="mt30">
					<span class="loginApp whitefc f18 cursor" id="dologin">
						立即登录
					</span>
				</div>
			</div>
		</div>
	</div>
	<form action="$request.getContextPath()/main.htm" method="get" id="main" >
                
    </form>
	<script>
		if (window != top) 
		top.location.href = location.href; 
    </script>
</body>
	
</html>