<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
  <script src="${pageContext.request.contextPath}/js/jquery-3.2.1.min.js"></script>
  <script type="text/javascript">
    // $(document).ready(function(){
    //   $("button").click(function(){
    //     $("#d1").hide();
    //   });
    // });

    $(document).ready(function(){
      var r = "";
    //   $("#b1").click(function(){
    // 		$.ajax({
    //       type: "GET",
    //       url: "${pageContext.request.contextPath}/api/v1/user",
    //       dataType: "json",
    //       success: function(result){
    //         alert();
    //         var html="<ul>";
    //         //i表示在data中的索引位置，n表示包含的信息的对象
    //         $.each(result,function(i,n){
    //         //获取对象中属性为optionsValue的值
    //         html+="<li>"+n["optionValue"]+"</li>";
    //         });
    //         html+="</ul>";
    //         $('#d2').append(html);
    // 		    }
    //     });
    // 	});
    // });

    $("#b2").click(function(){
      $.ajax({
        type: "GET",
        url: "${pageContext.request.contextPath}/api/v1/user/1",
        dataType: "json",
        // async: false,
        success: function(result){
          $.each( result, function(index, content)
            {
             alert( "the man's no. is: " + index + ",and " + content.userName + " is learning " + content.pwd );
            });
          // r="<ul>";
          // //i表示在data中的索引位置，n表示包含的信息的对象
          // $.each(result,function(i,n){
          // //获取对象中属性为optionsValue的值
          // r+="<li>"+n["optionValue"]+"</li>";
          // });
          // r+="</ul>";
          $('#d2').append(r);
          alert("2");
        },
        error: function(data){
          alert("1")
        }
      });
    });
  });
  </script>
<body>
<h2>Hello World!</h2>
<h3>测试</h3>
<button id="b2">点我</button>
  <input id="b1" type="button" value="Load加载"/>
  <div id="d1">aaa</div>
  <div id="d2"></div>
  <hr/>
  <form id="submitForm" action="${pageContext.request.contextPath}/api/v1/user/login" method="post">
    <div>
       用户名： <input type="text"  id="userName" name="userName" class="username"  value="${user.userName }" />
    </div>
    <div>
      密&nbsp;&nbsp;&nbsp;&nbsp;码：<input type="password"  id="password"  name="password" class="pwd"  value="${user.pwd }">
    </div>
    <div id="btn_area">
      <input type="submit" class="login_btn" id="login_sub"  value="登  录">
      <input type="reset" class="login_btn" id="login_ret" value="重 置">
    </div>
  </form>
</body>
</html>
