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

        option = {
        	    title: {
        	        text: '折线图堆叠'
        	    },
        	    tooltip: {
        	        trigger: 'axis'
        	    },
        	    grid: {
        	        left: '3%',
        	        right: '4%',
        	        bottom: '3%',
        	        containLabel: true
        	    },
        	    toolbox: {
        	        feature: {
        	            saveAsImage: {}
        	        }
        	    },
        	    xAxis: {
        	        type: 'category',
        	        boundaryGap: false,
        	        data: []
        	    },
        	    yAxis: {
        	        type: 'value'
        	    },
        	    series:
        	        {
        	            name:'心率模拟数据',
        	            type:'line',
        	            data:[]
        	        }
        	};
        $.ajax({
          type: "GET",
          url: "api/v1/heartRate",
          dataType: "json",
          success:function(result){
            var rData = result.data;
            var r = JSON.stringify(rData);
            var obj = JSON.parse(r);
            var times = [];
            var rates = [];
            $.each( obj, function(index, content)
              {
                times.push(obj[index].dateTime.toString());
                rates.push(obj[index].rate);
              });
              myChart.setOption({
                  xAxis: {
                      data: times
                  },
                  series: [{
                      data: rates
                  }]
              });
            }
        });

        myChart.setOption(option);
    </script>
</body>
</html>
