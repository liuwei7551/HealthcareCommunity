<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
  <script src="${pageContext.request.contextPath}/js/jquery-3.2.1.min.js"></script>
  <script type="text/javascript">
    $(document).ready(function(){
      $("button").click(function(){
        $("#d1").hide();
      });
    });
  </script>
<body>
<h2>Hello World!</h2>
<h3>测试</h3>
<button>点我</button>
  <input id="b1" type="button" value="Load加载"/>
  <div id="d1">aaa</div>
  <hr/>
  <form id="submitForm"  action="${pageContext.request.contextPath}/api/v1/user/login"  method="post" />
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
