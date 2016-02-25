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
	<link rel="stylesheet" href="$request.getContextPath()/css/common.css">
	
	<script type="text/javascript" src="$request.getContextPath()/js/jquery.min.js"></script>
	<script type="text/javascript" src="$request.getContextPath()/js/main.js"></script>
	<script type="text/javascript" src="$request.getContextPath()/plugin/layer/layer.js"></script>
	<!–[if lt IE 9]> <script src="http://cdn.staticfile.org/html5shiv/r29/html5.min.js"></script> <![endif]–>
</head>
<body>
	<header class="head whitefc">
		<div class="logo pl20 fl">
			<img src="images/logo.png" alt="logo" class="fl mr10 mt15"/>
			<span class="fl f20 mr5">物流APP后台</span> 
			<span class="fl f16">版本号 1.1</span>
		</div>
		<div class="headLink fr f14">
			<ul>
				<li><img src="images/portrait.png" class="pt10"/></li>
				<li>你好，$!logisticsAdminInfo.nickName  |</li>
				<li class="cursor" onclick="loginOut()">退出</li>
			</ul>
		</div>
	</header>
	<section>
		<div class="left f14 tc">
			<h2 class="bluefc menu f20 whitebg" onclick="goTo('$request.getContextPath()/mianStatistics.htm');" style="cursor:pointer;">
				主菜单
			</h2>
			$menuStr
		</div>
		<div class="right">
			<iframe id="iframeid" name="iframename" frameborder="no" src="$request.getContextPath()/mianStatistics.htm" style="width:100%;height:100%;"></iframe>
        </div>
	</section>
</body>
</html>