var page = "Index";

$(function()
{
  $.ajax({
    type: "post",
    url: 'user/login',
    dataType: "json",
    success: function (data) {
      if(data.exist){
        document.getElementById("tip").innerHTML="<img src='no.png'/>&nbsp;该用户名已经存在";
      }else{
        document.getElementById("tip").innerHTML="<img src='ok.png'/>&nbsp;该用户名可用";
      }
    }
  });
}
)
