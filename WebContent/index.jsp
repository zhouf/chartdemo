<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
<script src="https://cdn.bootcss.com/echarts/3.7.1/echarts.min.js"></script>
<!-- <script src="js/echarts.min.js"></script> -->
<!-- echarts.min.js是定制下载的，echarts.simple.min.js是精简版，体积更小，没有标题和图例 -->
<script src="js/mychart.js"></script>
<title>EChart示例</title>
</head>
<body>
	<h1>图表</h1>
	<hr>
	<div id="bar" style="width: 600px; height: 400px;border:1px solid green"></div>
	<div id="bar2" style="width: 600px; height: 400px;border:1px solid green"></div>
	<div id="linechar" style="width: 600px; height: 400px;border:1px solid blue"></div>
	<div id="linechar2" style="width: 600px; height: 400px;border:1px solid blue"></div>
	<div id="pie" style="width: 600px; height: 450px;border:1px solid red"></div>
	<script type="text/javascript">
	barChart('bar','这里是标题111','bardata.json');
	barChart('bar2','这里是标题2111','select username,count(*) from applyrecord group by username limit 5');
	lineChart('linechar','这里是标题222','GetCharData');
	lineChart('linechar2','这里是标题333','select username,count(*) from applyrecord group by username limit 5');
	//select username,count(*) from applyrecord group by username limit 5;
	pieChart('pie','这里是标题333','GetPieData');
	</script>
</body>
</html>