<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="https://cdn.bootcss.com/echarts/3.7.1/echarts.min.js"></script>
<script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
<title>EChart示例</title>
</head>
<body>
	<h1>图表</h1>
	<hr>
	<div id="main" style="width: 600px; height: 400px;"></div>
	<div id="linechar" style="width: 600px; height: 400px;"></div>
	<div id="pie" style="width: 600px; height: 600px;"></div>
	<div id="char2" style="width: 300px; height: 300px;display:none"></div>
	<script type="text/javascript">
		// 基于准备好的dom，初始化echarts实例
		var myChart = echarts.init(document.getElementById('main'));

		// 指定图表的配置项和数据
		myChart.setOption({
			title : {
				text : '异步数据加载示例'
			},
			tooltip : {},
			xAxis : {
				data : []
			},
			yAxis : {},
			series : [ {
				name : '销量',
				type : 'bar',
	            label: {
	                normal: {
	                    show: true,
	                    formatter: '{c}'
	                }
	            },
				data : []
			} ]
		});

		myChart.showLoading();
		setInterval("getBarData()", 10000);

		function getBarData() {
			$.get('GetCharData').done(function(data) {
				myChart.hideLoading();
				// 填入数据
				myChart.setOption({
					xAxis : {
						data : data.categories
					},
					series : [ {
						// 根据名字对应到相应的系列
						name : '销量',
						data : data.data
					} ]
				});
			});
		}

		getBarData();
		

		//------------------------------------拆线图------------------------------------
		var lineChart = echarts.init(document.getElementById('linechar'));
		lineoption = {
			    title: {
			        text: '未来一周气温变化',
			        subtext: '纯属虚构'
			    },
			    tooltip: {
			        trigger: 'axis'
			    },
			    toolbox: {
			        show: true,
			        feature: {
			            dataView: {readOnly: false},
			            magicType: {type: ['line', 'bar']},
			            restore: {},
			            saveAsImage: {}
			        }
			    },
			    xAxis:  {
			        type: 'category',
			        boundaryGap: false,
			        data: ['周一','周二','周三','周四','周五','周六','周日']
			    },
			    yAxis: {
			        type: 'value',
			        axisLabel: {
			            formatter: '{value} °C'
			        },
			        boundaryGap: [0, '20%']
			    },
			    series: [
			        {
			            name:'最高气温',
			            type:'line',
			            data:[11, 11, 15, 13, 12, 13, 10],
			            markLine: {
			                data: [
			                    {type: 'average', name: '平均值'}
			                ]
			            }
			        }
			    ]
			};

		lineChart.setOption(lineoption,true);
		setInterval(function() {

			$.get('GetCharData').done(function(data) {

				
				console.info("get line data" + data.categories);
				console.info("get line data" + data.data);
				lineoption.xAxis.data = data.categories;
				lineoption.series[0].data = data.data;
				// 填入数据
				lineChart.setOption(lineoption, true);
			});
		}, 10000);
		
		
		
		
		
		//------------------------------------饼图------------------------------------
		var pieChart = echarts.init(document.getElementById('pie'));
		pieoption = {
			    title : {
			        text: '某站点用户访问来源',
			        subtext: '纯属虚构',
			        x:'center'
			    },
			    tooltip : {
			        trigger: 'item',
			        formatter: "{a} <br/>{b} : {c} ({d}%)"
			    },
			    legend: {
			        orient: 'vertical',
			        left: 'left',
			        data: ['直接访问','邮件营销','联盟广告','视频广告','搜索引擎']
			    },
			    series : [
			        {
			            name: '访问来源',
			            type: 'pie',
			            radius : '55%',
			            center: ['50%', '60%'],
			            data:[
			                {value:335, name:'直接访问'},
			                {value:310, name:'邮件营销'},
			                {value:234, name:'联盟广告'},
			                {value:135, name:'视频广告'},
			                {value:1548, name:'搜索引擎'}
			            ],
			            itemStyle: {
			                emphasis: {
			                    shadowBlur: 10,
			                    shadowOffsetX: 0,
			                    shadowColor: 'rgba(0, 0, 0, 0.5)'
			                }
			            }
			        }
			    ]
			};

		pieChart.setOption(pieoption, true);
		
		setInterval(function() {

			$.get('GetPieData').done(function(data) {

				pieoption.legend.data = data.legend;
				pieoption.series[0].data = data.data;
				// 填入数据
				pieChart.setOption(pieoption, true);
			});
		}, 10000);
		
		//------------------------------------仪表盘------------------------------------
		var gauge = echarts.init(document.getElementById('char2'));
		option = {
			tooltip : {
				formatter : "{a} <br/>{b} : {c}%"
			},
			series : [ {
				name : '业务指标',
				type : 'gauge',
				detail : {
					formatter : '{value}%'
				},
				data : [ {
					value : 50,
					name : '完成率'
				} ]
			} ]
		};
		gauge.setOption(option, true);

		setInterval(function() {

			$.get('GetGaugeData').done(function(data) {

				option.series[0].data[0].value = data.value;
				option.series[0].data[0].name = data.name;
				// 填入数据
				gauge.setOption(option, true);
			});
		}, 2000);
	</script>
</body>
</html>