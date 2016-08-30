<%--
  Created by IntelliJ IDEA.
  User: yangxq
  Date: 16/7/19
  Time: 17:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="utf-8">
    <c:set var="ctx" value="${pageContext.request.contextPath}" />
    <script src="${ctx}/js/highCharts/jquery-1.8.3.min.js"></script>
    <script src="${ctx}/js/highCharts/highcharts.js"></script>
</head>
<body>
<div id="content" class="windows" style="">
    <div id="container" style="width:700px;height:400px;"></div>
</div>
<script>
    function refresh(){
        var id = $("#onclickId").val();
        $('#'+id).click();
    }
    getStatistic(875,1,"1");
    function getStatistic(id,type,desc){
//        $("#onclickId").val(id);
        var date = $('#date').val();
        $.post("${ctx}/statistic/get",{"id":id,"type":type,"desc":desc,"date":date},function(e){
            if(e.status == 0){
                var title = e.data.title
                var subtitle = e.data.subtitle;
                var ytitle = e.data.ytitle;
                var name = e.data.name;
                var data = e.data.data;
                var timeStart = e.data.timeStart;
                $('#container').highcharts({
                    chart: {
                        zoomType: 'x',
                        spacingRight: 20
                    },
                    title: {
                        text: title
                    },
                    subtitle: {
                        text: subtitle
                    },
                    xAxis: {
                        dateTimeLabelFormats : {
                            minute: '%H:%M',
                        },
                        type: 'datetime',
                        title: {
                            text: null
                        }
                    },
                    yAxis: {
                        min : 0,
                        title: {
                            text: ytitle
                        }
                    },
                    tooltip: {
                        shared: true
                    },
                    legend: {
                        enabled: false
                    },
                    plotOptions: {
                        area: {
                            fillColor: {
                                linearGradient: { x1: 0, y1: 0, x2: 0, y2: 1},
                                stops: [
                                    [0, Highcharts.getOptions().colors[0]],
                                    [1, Highcharts.Color(Highcharts.getOptions().colors[0]).setOpacity(0).get('rgba')]
                                ]
                            },
                            lineWidth: 1,
                            marker: {
                                enabled: false
                            },
                            shadow: false,
                            states: {
                                hover: {
                                    lineWidth: 1
                                }
                            },
                            threshold: null
                        }
                    },

                    series: [{
                        type: 'area',
                        name: name,
//                        pointInterval:  60 * 1000 ,
//                        pointStart: new Date(2016,8,1),
                        pointInterval:  60 * 1000 ,
                        pointStart: timeStart*1000,
                        data: data
                    }]
                });
                $("#content").show();
            }else{
                alert("系统繁忙");
            }
        },'json');
    }
</script>
</body>
</html>
