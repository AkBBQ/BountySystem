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
        <form action="../mission/updateMission" method="post">
          <div class="layui-form-item">
              <input type="hidden" name="id" value="${Mission.id}" id="id">
              <label for="title" class="layui-form-label">
                  <span class="x-red">*</span>任务标题
              </label>
              <div class="layui-input-inline">
                  <input type="text" id="title" name="title" required="" lay-verify="required"
                  autocomplete="off" value="${Mission.title}" class="layui-input">
              </div>
          </div>
          <div class="layui-form-item">
              <label for="type" class="layui-form-label">
                  <span class="x-red">*</span>任务类型
              </label>
              <div class="layui-input-inline">
                  <select id="type" name="type">
                   <option value="${Mission.type}" selected="selected">${Mission.typeDesc}</option>
                  </select>
              </div>
          </div>
          <div class="layui-form-item">
              <label for="place" class="layui-form-label">
                  <span class="x-red">*</span>任务地点
              </label>
              <div class="layui-input-inline">
                  <input type="text" value="${Mission.place}" id="place" name="place"
                  class="layui-input">
              </div>
          </div>
            <div class="layui-form-item">
                <label for="content" class="layui-form-label">
                    <span class="x-red">*</span>任务描述
                </label>
                <div class="layui-input-inline">
                    <input type="text" value="${Mission.content}" id="content" name="content"
                           class="layui-input">
                </div>
            </div>
            <div class="layui-form-item">
                <label for="startTime" class="layui-form-label">
                    <span class="x-red">*</span>任务开始时间
                </label>
                <div class="layui-input-inline">

                    <input class="layui-input"  placeholder="开始日" name="startTime" id="startTime"
                            <c:if test="${null != Mission.startTime}">
                                value="<fmt:formatDate value="${Mission.startTime}" pattern="yyyy-MM-dd"/>"
                            </c:if>
                    />

                </div>
            </div>
            <div class="layui-form-item">
                <label for="endTime" class="layui-form-label">
                    <span class="x-red">*</span>任务结束时间
                </label>
                <div class="layui-input-inline">
                    <input class="layui-input"  placeholder="截止日" name="endTime" id="endTime"
                            <c:if test="${ null != Mission.endTime}">
                                value="<fmt:formatDate value="${Mission.endTime}" pattern="yyyy-MM-dd"/>"
                            </c:if>
                    />
                </div>
            </div>
          <div class="layui-form-item">
              <button type="submit" class="layui-btn" onclick="x_admin_close()" id="update">
                  修改
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

  <script>
      $('#type').click(function () {
          $.ajax({
              url:"/mission/missionTypeQuery",
              type:"get",
              success: function(result){

                  var data = eval(result)
                  var nameOpt = "<option value='' selected='selected'>--请选择--</option>";
                  for(var k in data) {
                      nameOpt+="<option value='"+k+"'>"+data[k]+"</option>";
                  }
                  $('#type').html(nameOpt);
              },
              error: function(){}
          });
      })
  </script>
  </body>

</html>