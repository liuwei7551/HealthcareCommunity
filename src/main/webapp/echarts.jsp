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

        var option={
            backgroundColor: '#2c343c',
            textStyle: {
                        color: 'rgba(255, 255, 255, 0.3)'
                    },
            series : [
                {
                    name: '访问来源',
                    type: 'pie',
                    radius: '55%',
                    data:[
                        {value:400, name:'搜索引擎'},
                        {value:335, name:'直接访问'},
                        {value:310, name:'邮件营销'},
                        {value:274, name:'联盟广告'},
                        {value:235, name:'视频广告'}
                      ],
                    roseType: 'angle',

                    itemStyle: {
                        emphasis: {
                            shadowBlur: 200,
                            shadowColor: 'rgba(0, 0, 0, 0.5)'
                        }
                    },
                    label: {
                        normal: {
                            textStyle: {
                                color: 'rgba(255, 255, 255, 0.3)'
                            }
                        }
                    },
                    labelLine: {
                        normal: {
                            lineStyle: {
                                color: 'rgba(255, 255, 255, 0.3)'
                            }
                        }
                    }

                }
            ]
        }

        // $.ajax({
        //   // async: "false",
        //   type: "GET",
        //   url: "api/v1/test/data",
        //   dataType: "json",
        //   success:function(result){
        // 	alert(result.length);
        //     var data = [];
        //     $.each( result, function(index, content)
        //       {
        //         data[index] = {name: result[index]["name"], value: result[index]["value"]};
        //       //  alert( "the man's no. is: " + index + ",and " + result[index].name + " is learning " + result[index].value );
        //       });
        //     // for (var i = 0; i <= result.length; i++){
        //     //   alert(result[0].name);
        //     // }
        //     option.series[0].data = data;
        //     myChart.setOption(option);
        //     }
        // });

        $.ajax({
          // async: "false",
          type: "GET",
          url: "api/v1/test/data",
          dataType: "json",
          success:function(result){
        	alert(result.length);
            var r = JSON.stringify(result);
            alert(r);
            var obj = JSON.parse(r);
            var data = [];
            $.each( obj, function(index, content)
              {
                data[index] = {name: obj[index].name, value: obj[index].value};
              //  alert( "the man's no. is: " + index + ",and " + result[index].name + " is learning " + result[index].value );
              });
            // for (var i = 0; i <= result.length; i++){
            //   alert(result[0].name);
            // }
            option.series[0].data = data;
            myChart.setOption(option);
            }
        });

    </script>
</body>
</html>
