<%--
  Created by IntelliJ IDEA.
  User: yangxq
  Date: 16/7/19
  Time: 17:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>线图</title>
    <script src="/js/jquery-3.1.0.min.js"></script>
    <script src="/js/echarts.min.js"></script>
    <script src="/js/dark.js"></script>
</head>
<body>
<div>测试</div>
<!-- 为ECharts准备一个具备大小（宽高）的Dom -->
<div align="center" id="main" style="width: 90%;height:90%;"></div>

<script>

    var date = [];

    var data = "${datas}";

    for (var i = 1; i < data.length; i++) {
        var now = new Date();
        date.push([now.getFullYear(), now.getMonth() + 1, now.getDate()].join('/'));
    }
    console.log(console.log(data[0]));

    option = {
        tooltip: {
            trigger: 'axis',
            position: function (pt) {
                return [pt[0], '10%'];
            }
        },
        title: {
            left: 'center',
            text: '大数据量面积图',
        },
        legend: {
            top: 'bottom',
            data:['意向']
        },
        toolbox: {
            feature: {
                dataZoom: {
                    yAxisIndex: 'none'
                },
                restore: {},
                saveAsImage: {}
            }
        },
        xAxis: {
            type: 'category',
            boundaryGap: false,
            data: date
        },
        yAxis: {
            type: 'value',
            boundaryGap: [0, '100%']
        },
        dataZoom: [{
            type: 'inside',
            start: 0,
            end: 10
        }, {
            start: 0,
            end: 10,
            handleIcon: 'M10.7,11.9v-1.3H9.3v1.3c-4.9,0.3-8.8,4.4-8.8,9.4c0,5,3.9,9.1,8.8,9.4v1.3h1.3v-1.3c4.9-0.3,8.8-4.4,8.8-9.4C19.5,16.3,15.6,12.2,10.7,11.9z M13.3,24.4H6.7V23h6.6V24.4z M13.3,19.6H6.7v-1.4h6.6V19.6z',
            handleSize: '80%',
            handleStyle: {
                color: '#fff',
                shadowBlur: 3,
                shadowColor: 'rgba(0, 0, 0, 0.6)',
                shadowOffsetX: 2,
                shadowOffsetY: 2
            }
        }],
        series: [
            {
                name:'模拟数据',
                type:'line',
                smooth:true,
                symbol: 'none',
                sampling: 'average',
                itemStyle: {
                    normal: {
                        color: 'rgb(255, 70, 131)'
                    }
                },
                areaStyle: {
                    normal: {
                        color: new echarts.graphic.LinearGradient(0, 0, 0, 1, [{
                            offset: 0,
                            color: 'rgb(255, 158, 68)'
                        }, {
                            offset: 1,
                            color: 'rgb(255, 70, 131)'
                        }])
                    }
                },
                data: data
            }
        ]
    };


    // 基于准备好的dom，初始化echarts实例
    //    var myChart = echarts.init(document.getElementById('main'));
    myChart = echarts.init(document.getElementById('main'));// 设置主题

//    // 自适应屏幕
//    window.onresize = myChart.resize;
//
    //    // 使用刚指定的配置项和数据显示图表。
       myChart.setOption(option);
//
//    //查询
//    function loadDrugs() {
//        myChart.clear();
//        myChart.showLoading({text: '正在努力的读取数据中...'});
//        $.getJSON('line', function (data) {
//            console.log(data);
//            myChart.setOption(data, true);
//            myChart.hideLoading();
//        });
//    }
//    //载入图表
//    loadDrugs();


</script>

</body>
</html>
