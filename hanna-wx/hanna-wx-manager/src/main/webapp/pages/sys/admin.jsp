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
	<link rel="stylesheet" href="$request.getContextPath()/css/bootstrap.min.css" />
	
	<script type="text/javascript" src="$request.getContextPath()/js/jquery.min.js"></script>
	<script type="text/javascript" src="$request.getContextPath()/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="$request.getContextPath()/plugin/layer/layer.js"></script>
	<script type="text/javascript" src="$request.getContextPath()/plugin/My97DatePicker/WdatePicker.js"></script>
	<script type="text/javascript" src="$request.getContextPath()/plugin/jqPaginator/jqPaginator.js"></script>
	
	<script type="text/javascript" src="$request.getContextPath()/js/sys/admin.js"></script>
</head>
<body>
<div class="mainSemt">
	<div class="navigateItem pl20">
		系统管理>管理员管理
	</div>
	<div class="search">
		<ul class="mb20 overflow">
			<li>
				<select class="form-control select145 h30" id="type">
					<option value="0">搜索类型</option>
					<option value="1">昵称</option>
			        <option value="2">手机号码</option>
				</select>
			</li>
			<li>
				<input type="text" class="form-control text250 h30" id="typeValue"/>
			</li>
			<li>
				<span class="fl">开始时间：</span>
				<input type="text" class="form-control selec110 h30 fl" readonly  id="startDate" onClick="WdatePicker()"/>
			</li>
			<li>
				<span class="fl">结束时间：</span>
				<input type="text" class="form-control selec110 h30 fl" readonly  id="endDate" onClick="WdatePicker()"/>
			</li>
			<li>
				<span class="btnSearch whitefc f14 mt5 clearfix cursor" onclick="search(1);">
					搜索
				</span>
			</li>
			<li>
				<span class="btnSearch whitefc f14 mt5 clearfix cursor" onclick="add();">
					新增
				</span>
			</li>
		</ul>
	</div>
	<div class="rightMain tc p10">
		<table width="100%">
			<tr>
				<td>管理员ID</td>
				<td>昵称</td>
				<td>性别</td>
				<td>年龄</td>
				<td>手机号码</td>
				<td>创建时间</td>
				<td>操作</td>
			</tr>
			<tbody id="tbodyId">
				<tr >
					<td colspan="6">无数据</td>
				</tr>
            </tbody>
		</table>
		<div class="page tc f14 mt20 customBootstrap" id="pageId" style="display:none">
			<div class="fl">共<span class="bluefc" id="showPageCount"></span>页记录</div><ul class="pagination" id="paginationId"></ul>
		</div>
	</div>
</div>
</body>
</html>