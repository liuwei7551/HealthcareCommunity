<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
  <script src="${pageContext.request.contextPath}/js/jquery-3.2.1.min.js"></script>
  <script src="${pageContext.request.contextPath}/js/echarts.js"></script>

<body>
    <div id="main" style="width: 1000px;height:600px;"></div>

    <script type="text/javascript">
        // 基于准备好的dom，初始化echarts实例
        var myChart = echarts.init(document.getElementById('main'));

        function randomData() {
            now = new Date(+now + oneDay);
            value = value + Math.random() * 21 - 10;
            return {
                name: now.toString(),
                value: [
                    [now.getFullYear(), now.getMonth() + 1, now.getDate()].join('/'),
                    Math.round(value)
                ]
            }
        }

        var data = [];
        var now = +new Date(1997, 9, 3);
        var oneDay = 24 * 3600 * 1000;
        var value = Math.random() * 1000;
        for (var i = 0; i < 1000; i++) {
            data.push(randomData());
        }

        option = {
            title: {
                text: '动态数据 + 时间坐标轴'
            },
            tooltip: {
                trigger: 'axis',
                formatter: function (params) {
                    params = params[0];
                    var date = new Date(params.name);
                    return date.getDate() + '/' + (date.getMonth() + 1) + '/' + date.getFullYear() + ' : ' + params.value[1];
                },
                axisPointer: {
                    animation: false
                }
            },
            xAxis: {
                type: 'time',
                splitLine: {
                    show: false
                }
            },
            yAxis: {
                type: 'value',
                boundaryGap: [0, '100%'],
                splitLine: {
                    show: false
                }
            },
            series: [{
                name: '模拟数据',
                type: 'line',
                showSymbol: false,
                hoverAnimation: false,
                data: data
            }]
        };

        setInterval(function () {

            for (var i = 0; i < 5; i++) {
                data.shift();
                data.push(randomData());
            }

            myChart.setOption({
                series: [{
                    data: data
                }]
            });
        }, 1000);

        myChart.setOption(option);
    </script>
</body>
</html>
