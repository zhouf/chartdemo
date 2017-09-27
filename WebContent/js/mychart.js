/*
 * 这是为封装EChart图表做的一个js方法
 * zhouf_t@sohu.com
 * */

function barChart(objid,title,dataurl) {
	var myChart = echarts.init(document.getElementById(objid));

	// 指定图表的配置项和数据
	baroption={
		title : {
			text : title
		},
		xAxis : {
			data : []
		},
		yAxis : {},
		series : [ {
			name : '',
			type : 'bar',
			label : {
				normal : {
					show : true,
					formatter : '{c}'
				}
			},
			data : []
		} ]
	};
	myChart.setOption(baroption,true);
	myChart.showLoading();

	$.get(dataurl).done(function(data) {
		myChart.hideLoading();
		baroption.xAxis.data = data.categories;
		baroption.series[0].data = data.data;
		myChart.setOption(baroption,true);
	});

}

function lineChart(objid,title,dataurl) {
	var lineChart = echarts.init(document.getElementById(objid));
	lineoption = {
		    title: {
		        text: title
		    },
		    tooltip: {
		        trigger: 'axis'
		    },
		    xAxis:  {
		        type: 'category',
		        boundaryGap: false,
		        data: []
		    },
		    yAxis: {
		        type: 'value',
		        axisLabel: {
		            formatter: '{value}'
		        },
		        boundaryGap: ['10%', '20%']
		    },
		    series: [
		        {
		            name:'',
		            type:'line',
		            label:{
		            	normal:{
		            		show: true,
		            		position: 'top'
		            	}
		            },
		            data:[]
		        }
		    ]
		};

	lineChart.setOption(lineoption,true);
	lineChart.showLoading();
	$.get(dataurl).done(function(data) {
		lineChart.hideLoading();
		lineoption.xAxis.data = data.categories;
		lineoption.series[0].data = data.data;
		lineChart.setOption(lineoption, true);
	});
}


function pieChart(objid,title,dataurl) {
	var pieChart = echarts.init(document.getElementById(objid));
	pieoption = {
		    title : {
		        text: title,
		        x: 'center'
		    },
		    tooltip : {
		        trigger: 'item',
		        formatter: "{a} <br/>{b} : {c} ({d}%)"
		    },
		    legend: {
		        orient: 'vertical',
		        left: 'left',
		        data: []
		    },
		    series : [
		        {
		            name: '',
		            type: 'pie',
		            radius : '75%',
		            center: ['50%', '55%'],
		            data:[],
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
	
	$.get(dataurl).done(function(data) {
		pieoption.legend.data = data.legend;
		pieoption.series[0].data = data.data;
		pieChart.setOption(pieoption, true);
	});
}