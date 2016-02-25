<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="content-type" content="text/html; charset=utf-8" />
    <title>报名俱乐部</title>
	<link rel="stylesheet" href="$request.getContextPath()/css/common.css">
	<link rel="stylesheet" href="$request.getContextPath()/css/rightCommon.css">
		
	<script type="text/javascript" src="$request.getContextPath()/js/jquery.min.js"></script>
</head>
<body>
<div class="mainSemt">
	<ul id="rightIndex">
		<li>
			<h2 class="f20 fb">今日新增用户</h2>
			<div class="redfc f20">$sysStatistics.userToday</div>
			#if($sysStatistics.userPercentage >= 0)
				<div>日：<span class="redfc">↑</span> $sysStatistics.userPercentage%</div>
			#else
				<div>日：<span class="redfc">↓</span> $math.abs($sysStatistics.userPercentage)%</div>
			#end
			<div>总：$sysStatistics.userTotal</div>
		</li>
		<li>
			<h2 class="f20 fb">今日新增司机</h2>
			<div class="redfc f20">$sysStatistics.truckOwnerToday</div>
			#if($sysStatistics.truckOwnerPercentage >= 0)
				<div>日：<span class="redfc">↑</span> $sysStatistics.truckOwnerPercentage%</div>
			#else
				<div>日：<span class="redfc">↓</span> $math.abs($sysStatistics.truckOwnerPercentage)%</div>
			#end
			<div>总：$sysStatistics.truckOwnerTotal</div>
		</li>
		<li>
			<h2 class="f20 fb">今日新增企业</h2>
			<div class="redfc f20">$sysStatistics.logisticsToday</div>
			#if($sysStatistics.logisticsPercentage >= 0)
				<div>日：<span class="redfc">↑</span> $sysStatistics.logisticsPercentage%</div>
			#else
				<div>日：<span class="redfc">↓</span> $math.abs($sysStatistics.logisticsPercentage)%</div>
			#end
			<div>总：$sysStatistics.logisticsTotal</div>
		</li>
		<li>
			<h2 class="f20 fb">今日新增车辆</h2>
			<div class="redfc f20">$sysStatistics.truckToday</div>
			#if($sysStatistics.truckPercentage >= 0)
				<div>日：<span class="redfc">↑</span> $sysStatistics.truckPercentage%</div>
			#else
				<div>日：<span class="redfc">↓</span> $math.abs($sysStatistics.truckPercentage)%</div>
			#end
			<div>总：$sysStatistics.truckTotal</div>
		</li>
		<li>
			<h2 class="f20 fb">今日订单成交量</h2>
			<div class="redfc f20">$sysStatistics.orderToday</div>
			#if($sysStatistics.orderPercentage >= 0)
				<div>日：<span class="redfc">↑</span> $sysStatistics.orderPercentage%</div>
			#else
				<div>日：<span class="redfc">↓</span> $math.abs($sysStatistics.orderPercentage)%</div>
			#end
			<div>总：$sysStatistics.orderTotal</div>
		</li>
		<li>
			<h2 class="f20 fb">今日运输总量</h2>
			<div class="redfc f20">$sysStatistics.orderWeightToday</div>
			#if($sysStatistics.orderWeightPercentage >= 0)
				<div>日：<span class="redfc">↑</span> $sysStatistics.orderWeightPercentage%</div>
			#else
				<div>日：<span class="redfc">↓</span> $math.abs($sysStatistics.orderWeightPercentage)%</div>
			#end
			<div>总：$sysStatistics.orderWeightTotal</div>
		</li>
	</ul>
</div>
</body>
</html>