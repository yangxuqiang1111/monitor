<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/8/31
  Time: 9:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <c:set var="ctx" value="${pageContext.request.contextPath}" />
    <link rel="shortcut icon" href="${ctx}/images/favicon.png" type="image/png">

    <title>监控系统</title>
    <link href="${ctx}/css/bootstrap.min.css" rel="stylesheet">
    <link href="${ctx}/css/font-awesome.min.css" rel="stylesheet">
    <link href="${ctx}/css/bootstrap-datetimepicker.css" rel="stylesheet">
    <link href="${ctx}/css/your_style.css" rel="stylesheet">
</head>

<body>

<div id="preloader">
    <div id="status"><i class="fa fa-spinner fa-spin"></i></div>
</div>

<div class="line-wrap">
    <span class="close"><i class="fa fa-times" aria-hidden="true"></i></span>
    <div id="line-picture" style="width: 700px;height: 400px;"></div>
    <input type="hidden" id="onclickId">
    <button class="btn refresh">刷 新</button>
</div>

<section>
    <nav class="navbar-default navbar-static-side">
        <ul class="nav" id="sys">
            <li class="nav-header">
                <div class="logo-element">
                    <h1><span>[</span> yangxq <span>]</span></h1>
                </div>
            </li>
            <c:forEach items="${sys}" var="sys" varStatus="status">
                <c:choose>
                    <c:when test="${sysId==sys.id}">
                        <li class="active" data-id=${sys.id}><a href="${ctx}/sys/list?sysId=${sys.id}"><i
                                class="fa fa-home"></i> <span>${sys.name}</span></a></li>
                    </c:when>
                    <c:otherwise>
                        <li data-id=${sys.id}><a href="${ctx}/sys/list?sysId=${sys.id}"><i class="fa fa-home"></i>
                            <span>${sys.name}</span></a></li>
                    </c:otherwise>
                </c:choose>
            </c:forEach>
        </ul>
    </nav>
    <div class="page-wrapper gray-bg">
        <div class="row page-head white-bg boder-bottom">
            <div class="col-lg-10">
                <h3>业务类型</h3>
            </div>
            <div class="col-lg-2">
                <div class="datetime">
                    <input type="text" readonly class="form_datetime" id="date">
                    <span class="add-on"><i class="fa fa-calendar" aria-hidden="true"></i></span>
                </div>
            </div>
        </div>

        <div class="wrap-content">
            <div class="row title"><h4>调用量</h4></div>
            <div class="row">
                <c:forEach items="${business}" var="business">
                    <c:if test="${business.type==1}">
                        <div class="col-xs-6 col-sm-4 col-md-3 col-lg-3 item">
                            <a href="javascript:void(0);" class="item-link businessItem"
                               data-id="${business.id}">${business.title}</a>
                        </div>
                    </c:if>

                </c:forEach>
            </div>
            <div class="row title"><h4>耗时数</h4></div>
            <div class="row">
                <c:forEach items="${business}" var="business">
                    <c:if test="${business.type==2}">
                        <div class="col-xs-6 col-sm-4 col-md-3 col-lg-3 item">
                            <a href="javascript:void(0);" class="item-link businessItem"
                               data-id="${business.id}">${business.title}</a>
                        </div>
                    </c:if>
                </c:forEach>
            </div>
            <div class="row title"><h4>失败量</h4></div>
            <div class="row">
                <c:forEach items="${business}" var="business">
                    <c:if test="${business.type==3}">
                        <div class="col-xs-6 col-sm-4 col-md-3 col-lg-3 item">
                            <a href="javascript:void(0);" class="item-link businessItem"
                               data-id="${business.id}">${business.title}</a>
                        </div>
                    </c:if>
                </c:forEach>
            </div>
        </div>
    </div>
</section>

<script src="${ctx}/js/jquery-1.8.3.min.js"></script>
<script src="${ctx}/js/bootstrap.min.js"></script>
<script src="${ctx}/js/highCharts/highcharts.js"></script>
<%--<script src="${ctx}/js/highCharts/dark-unica.js"></script>--%>
<script src="${ctx}/js/bootstrap-datetimepicker.js"></script>
<script src="${ctx}/js/custom.js"></script>
<script src="${ctx}/js/dateFormat.js"></script>

<script type="text/javascript">
    $(".form_datetime").datetimepicker({
        format: 'yyyy-mm-dd',
        autoclose: true,
        minView: 2,
        fontAwesome: true
    });
    $("#date").val(new Date().format("yyyy-MM-dd"));
</script>

<%--<script>--%>
<%--var id= $("#sys").find("li.active").attr("data-id");--%>
<%--$.post("${ctx}/business/list",{"id":id},function(data){--%>
<%--if(data.status==0){--%>
<%--var business=data.data["business"];--%>
<%--for (var i=0;i<business.length;i++){--%>
<%--console.log(business[i]);--%>
<%--$("#rowId").append("<div class='col-xs-6 col-sm-4 col-md-3 col-lg-3 item'><a href='javascript:void(0);' class='item-link businessItem' data-id="+ business[i].id +">"+business[i].title+"</a></div>");--%>
<%--}--%>
<%--}--%>
<%--});--%>
<%--</script>--%>
<script>
    $(".businessItem").live('click', function () {
        getStatistic($(this).attr("data-id"));
    });

    $(".close").click(function () {
        $(".line-wrap").hide();
    });

    $(".refresh").click(function () {
        getStatistic($("#onclickId").val());
    });

    function getStatistic(id) {
//        $("#onclickId").val(id);
        var date = $('#date').val();
        $.post("${ctx}/statistic/get", {"id": id, "date": date}, function (rs) {
            if (rs.status == 0) {
                $(".line-wrap").show();
                $("#onclickId").val(id);
                var title = rs.data.title;
                var subTitle = rs.data.subTitle;
                var yTitle = rs.data.yTitle;
                var name = rs.data.name;
                var data = rs.data.data;
                var timeStart = rs.data.timeStart;
                var xTitle = rs.data.xTitle;
//                Highcharts.setOptions(Highcharts.theme);
                $('#line-picture').highcharts({
                    chart: {
                        zoomType: 'x',
                        spacingRight: 20
                    },
                    title: {
                        text: title
                    },
                    subtitle: {
                        text: subTitle
                    },
                    xAxis: {
                        dateTimeLabelFormats : {
                            minute: '%H:%M',
                        },
                        type: 'datetime',
                        title: {
                            text: xTitle
                        }
                    },
                    yAxis: {
                        min : 0,
                        title: {
                            text: yTitle
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
            }else{
                alert("业务无数据");
            }
        },'json');
    }
</script>
</body>
</html>