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

    <title>Bracket Responsive Bootstrap3 Admin</title>

    <link href="${ctx}/css/style.default.css" rel="stylesheet">
    <link href="${ctx}/css/your_style.css" rel="stylesheet">

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="${ctx}/js/html5shiv.js"></script>
    <script src="${ctx}/js/respond.min.js"></script>
    <![endif]-->
</head>

<body>
<!-- Preloader -->
<div id="preloader">
    <div id="status"><i class="fa fa-spinner fa-spin"></i></div>
</div>

<div id="content" style="display:none; width:700px;height:400px;">
    <div id="container"></div>
</div>

<section>

    <div class="leftpanel">

        <div class="logopanel">
            <h1><span>[</span> bracket <span>]</span></h1>
        </div>
        <!-- logopanel -->

        <div class="leftpanelinner">

            <h5 class="sidebartitle">Navigation</h5>

            <ul class="nav nav-pills nav-stacked nav-bracket" id="sys">
                <c:forEach items="${sys}" var="sys" varStatus="status">
                    <c:choose>
                        <c:when test="${status.index==0}">
                            <li class="active"><span style="display: none;">${sys.id}</span><a href="javascript:void(0);"><i class="fa fa-home"></i> <span>${sys.name}</span></a></li>
                        </c:when>
                        <c:otherwise>
                            <li><a href="javascript:void(0);"><span style="display: none;">${sys.id}</span><i class="fa fa-home"></i> <span>菜单二</span></a></li>
                        </c:otherwise>
                    </c:choose>

                </c:forEach>
                <%--<li><a href="index.html"><i class="fa fa-home"></i> <span>菜单二</span></a></li>--%>
                <%--<li><a href="index.html"><i class="fa fa-home"></i> <span>菜单三</span></a></li>--%>
                <%--<li><a href="index.html"><i class="fa fa-home"></i> <span>菜单四</span></a></li>--%>
            </ul>

        </div>
        <!-- leftpanelinner -->
    </div>
    <!-- leftpanel -->

    <div class="mainpanel">
        <div class="headerbar"></div>

        <div class="pageheader">
            <h2><i class="fa fa-home"></i> 菜单一</h2>
        </div>

        <div class="contentpanel">

            <div class="row" id="rowId">
            </div>
            <!-- row -->

        </div>
        <!-- contentpanel -->

    </div>
    <!-- mainpanel -->


</section>


<script src="${ctx}/js/jquery-1.11.1.min.js"></script>

<script src="${ctx}/js/highCharts/highcharts.js"></script>

<script src="${ctx}/js/jquery-migrate-1.2.1.min.js"></script>
<script src="${ctx}/js/jquery-ui-1.10.3.min.js"></script>
<script src="${ctx}/js/bootstrap.min.js"></script>
<script src="${ctx}/js/modernizr.min.js"></script>
<script src="${ctx}/js/jquery.sparkline.min.js"></script>
<script src="${ctx}/js/toggles.min.js"></script>
<script src="${ctx}/js/retina.min.js"></script>
<script src="${ctx}/js/jquery.cookies.js"></script>

<script src="${ctx}/js/flot/jquery.flot.min.js"></script>
<script src="${ctx}/js/flot/jquery.flot.resize.min.js"></script>
<script src="${ctx}/js/flot/jquery.flot.spline.min.js"></script>
<script src="${ctx}/js/morris.min.js"></script>
<script src="${ctx}/js/raphael-2.1.0.min.js"></script>

<script src="${ctx}/js/custom.js"></script>
<script src="${ctx}/js/dashboard.js"></script>

<script>
    console.log($("#sys").children("li.active"));
   var id= $("#sys").children("li.active").children("span").text();
    $.post("${ctx}/business/list",{"id":id},function(data){
       if(data.status==0){
           var business=data.data["business"];
           for (var i=0;i<business.length;i++){
                console.log(business[i]);
               $("#rowId").append(" <div class='col-xs-6 col-sm-4 col-md-3 col-lg-3'><span style='display: none'>"+business[i].id+"</span><a href='javascript:void(0);' class='item businessItem'>"+business[i].title+"</a></div>");

           }
       }
    });
</script>
<script>

    $(".businessItem").click(function(){
       console.log($(this).pre().text());
    });
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
                var title = e.data.title;
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