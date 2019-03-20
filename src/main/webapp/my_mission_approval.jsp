<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%><!DOCTYPE html>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>


  <head>
    <meta charset="UTF-8">
    <title>欢迎页面-X-admin2.0</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
    <link rel="shortcut icon" href="/favicon.ico" type="image/x-icon" />
    <link rel="stylesheet" href="../static/css/font.css">
    <link rel="stylesheet" href="../static/css/xadmin.css">
    <script type="text/javascript" src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
    <script type="text/javascript" src="../static/lib/layui/layui.js" charset="utf-8"></script>
    <script type="text/javascript" src="../static/js/xadmin.js"></script>
    <!-- 让IE8/9支持媒体查询，从而兼容栅格 -->
    <!--[if lt IE 9]>
      <script src="https://cdn.staticfile.org/html5shiv/r29/html5.min.js"></script>
      <script src="https://cdn.staticfile.org/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
  </head>
  <body>
    <div class="x-body">
        <form action="../deal/doApproval" method="post">
          <div class="layui-form-item">
              <input type="hidden" name="mid" value="${missionId}" id="id">
              <label  class="layui-form-label">
                  <span class="x-red">*</span>是否通过
              </label>
              <div class="layui-input-inline">
                  <div class="layui-input-inline">

                  <label><input type="radio"  value = "通过"  name="isPass" checked="checked">通过</label>
                  <label><input type="radio"  value = "不通过" name="isPass" >不通过</label>
                  </div>
              </div>
          </div>
          <div class="layui-form-item">
              <label for="type" class="layui-form-label">
                  <span class="x-red">*</span>任务评星
              </label>
              <div class="layui-input-inline">
                  <select id="type" name="star">
                      <option>一星</option>
                      <option>二星</option>
                      <option>三星</option>
                      <option>四星</option>
                      <option>五星</option>
                  </select>
              </div>
          </div>
            <div class="layui-form-item">
                <label for="content" class="layui-form-label">
                    <span class="x-red">*</span>任务评价
                </label>
                <div class="layui-input-inline">
                    <textarea name="starDesc" id="content" rows="5" cols="60">

                    </textarea>
                </div>
            </div>
          <div class="layui-form-item">
              <button type="submit" class="layui-btn" onclick="x_admin_close()" id="update">
                  审批
              </button>
          </div>
      </form>
    </div>
  <script>
      layui.use('laydate', function () {
          var laydate = layui.laydate;

          //执行一个laydate实例
          laydate.render({
              elem: '#startTime' //指定元素
              ,format: 'yyyy-MM-dd'
          });

          //执行一个laydate实例
          laydate.render({
              elem: '#endTime' //指定元素
              ,format: 'yyyy-MM-dd'
          });
      });
  </script>

  </body>

</html>