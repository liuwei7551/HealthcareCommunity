<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
  <script src="${pageContext.request.contextPath}/js/jquery-3.2.1.min.js"></script>
  <script type="text/javascript">
    $(document).ready(function(){
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
        },
        error: function(data){
          alert("error")
        }
      });
    });
  });

  function checkUserName() {
    var userName = $("#userName").val();
    alert(userName);
    $.ajax({
      type: "GET",
      url: "api/v1/user/checkUserName?userName="+userName,
      dataType: "json",
      success: function(result){
    	alert(result.responseCode);
        if (result.responseCode == "000") {
          alert("ok");
          $("#tip").html("<img src='image/ok.png'>&nbsp;&nbsp;该用户名可用！");
        } else {
          alert("no");
          $("#tip").html("<img src='image/no.png'>&nbsp;&nbsp;该用户名已经存在！");
        }
      }
    });
  }
  </script>
<body>
  <h2>Hello World!</h2>
  <h3>测试</h3>
  <h4>hasdaqqqq</h4>
  <%-- <button id="b3">跳转到echarts</button> --%>
  <button id="b2">点我</button>
  <input id="b1" type="button" value="Load加载"/>
  <div id="d1">aaa</div>
  <div id="d2"></div>
  <hr/>
  <form id="submitForm" action="${pageContext.request.contextPath}/api/v1/user/login" method="post">
    <div>
       用户名： <input type="text"  id="userName" name="userName" class="username"  value="${user.userName }" onblur="checkUserName()"/>
       &nbsp;&nbsp;<font id="tip"></font>
    </div>
    <div>
      密&nbsp;&nbsp;&nbsp;&nbsp;码：<input type="password"  id="password"  name="password" class="pwd"  value="${user.pwd }">
    </div>
    <div id="btn_area">
      <input type="submit" class="login_btn" id="login_sub"  value="登  录">
      <input type="reset" class="login_btn" id="login_ret" value="重 置">
    </div>
  </form>

  <div id="echarts" style="margin-top: 20px;">
    <jsp:include page="echarts1.jsp" flush="true"/>
  </div>

</body>
</html>
