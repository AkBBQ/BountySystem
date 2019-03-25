<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html lang="en">
  
  <head>
    <meta charset="UTF-8">
    <title>欢迎页面-X-admin2.0</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
    <link rel="shortcut icon" href="/favicon.ico" type="image/x-icon" />
    <link rel="stylesheet" href="static/css/font.css">
    <link rel="stylesheet" href="static/css/xadmin.css">
    <script type="text/javascript" src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
    <script type="text/javascript" src="static/lib/layui/layui.js" charset="utf-8"></script>
    <script type="text/javascript" src="static/js/xadmin.js"></script>
    <!-- 让IE8/9支持媒体查询，从而兼容栅格 -->
    <!--[if lt IE 9]>
      <script src="https://cdn.staticfile.org/html5shiv/r29/html5.min.js"></script>
      <script src="https://cdn.staticfile.org/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
  </head>
  
  <body>
    <div class="x-body">
        <form class="layui-form" action="../mission/addMission" method="post" >
          <div class="layui-form-item">
              <label for="title" class="layui-form-label">
                  <span class="x-red">*</span>标题
              </label>
              <div class="layui-input-inline">
                  <input type="text" id="title" name="title" required="" lay-verify="required"
                  autocomplete="off" class="layui-input">
              </div>
          </div>
            <div class="layui-form-item">
                <label for="type" class="layui-form-label">
                    <span class="x-red">*</span>类型
                </label>
                <div class="layui-input-inline">
                    <select name="type" id="type">
                        <option value="0">代拿外卖</option>
                        <option value="1">代拿快递</option>
                        <option value="2">组队学习</option>
                        <option value="3">游戏开黑</option>
                        <option value="4">情感咨询</option>
                        <option value="5">就业指导</option>
                        <option value="6">技能培训</option>
                        <option value="7">寻找真爱</option>

                    </select>
                </div>
            </div>

            <%--<div class="layui-form-item">--%>
                <%--<label for="type" class="layui-form-label">--%>
                    <%--<span class="x-red">*</span>类型--%>
                <%--</label>--%>
                <%--<div class="layui-input-inline">--%>
                    <%--<select name="type" id="type">--%>
                    <%--</select>--%>
                <%--</div>--%>
            <%--</div>--%>
          <div class="layui-form-item">
              <label for="place" class="layui-form-label">
                  <span class="x-red">*</span>地点
              </label>
              <div class="layui-input-inline">
                  <input type="text" id="place" name="place" required=""
                  autocomplete="off" class="layui-input">
              </div>
          </div>
          <div class="layui-form-item">
              <label for="startTime" class="layui-form-label">
                  <span class="x-red">*</span>开始时间
              </label>
              <div class="layui-input-inline">
                  <input class="layui-input" placeholder="开始日" name="startTime" id="startTime">
              </div>
          </div>
            <div class="layui-form-item">
                <label for="startTime" class="layui-form-label">
                    <span class="x-red">*</span>结束时间
                </label>
                <div class="layui-input-inline">
                    <input class="layui-input" placeholder="结束日" name="endTime" id="endTime">
                </div>
            </div>
          <div class="layui-form-item layui-form-text">
              <label for="content" class="layui-form-label">
                  任务描述
              </label>
              <div class="layui-input-block">
                  <textarea placeholder="请输入内容" id="content" name="content" class="layui-textarea"></textarea>
              </div>
          </div>
          <div class="layui-form-item">
              <button  class="layui-btn" lay-filter="add" lay-submit="" type="submit" id="add">
                  增加
              </button>
          </div>
      </form>
    </div>
    <script>
        layui.use(['form','layer'], function(){
            $ = layui.jquery;
          var form = layui.form
          ,layer = layui.layer;
        
          //自定义验证规则
          form.verify({
            nikename: function(value){
              if(value.length < 5){
                return '昵称至少得5个字符啊';
              }
            }
            ,pass: [/(.+){6,12}$/, '密码必须6到12位']
            ,repass: function(value){
                if($('#L_pass').val()!=$('#L_repass').val()){
                    return '两次密码不一致';
                }
            }
          });

          //监听提交
          form.on('submit(add)', function(data){
            console.log(data);
            //发异步，把数据提交给php
            layer.alert("增加成功", {icon: 6},function () {
                // 获得frame索引
                var index = parent.layer.getFrameIndex(window.name);
                //关闭当前frame
                parent.layer.close(index);
            });
            return false;
          });
          
          
        });
    </script>
    <script>var _hmt = _hmt || []; (function() {
        var hm = document.createElement("script");
        hm.src = "https://hm.baidu.com/hm.js?b393d153aeb26b46e9431fabaf0f6190";
        var s = document.getElementsByTagName("script")[0];
        s.parentNode.insertBefore(hm, s);
      })();</script>


  <%--<script>--%>
      <%--$(document).ready(function(){--%>
          <%--loadDepartmentName();--%>
      <%--});--%>

      <%--function loadDepartmentName() {--%>
          <%--//alert("初始化正常")--%>
          <%--$.ajax({--%>
              <%--url:"/mission/missionTypeQuery",--%>
              <%--type:"get",--%>
              <%--success: function(result){--%>

                  <%--var data = eval(result)--%>
                  <%--var nameOpt = "<option value='' selected='selected'>--请选择--</option>";--%>
                  <%--for(var k in data) {--%>
                          <%--nameOpt+="<option value='"+k+"'>"+data[k]+"</option>";--%>
                  <%--}--%>
                  <%--$('#type').html(nameOpt);--%>
              <%--},--%>
              <%--error: function(){}--%>
          <%--});--%>
      <%--}--%>

  <%--</script>--%>

    <script>
        layui.use('laydate', function () {
            var laydate = layui.laydate;

            //执行一个laydate实例
            laydate.render({
                elem: '#startTime' //指定元素
            });

            //执行一个laydate实例
            laydate.render({
                elem: '#endTime' //指定元素
            });
        });
    </script>

  <script>
      $('#add').click(function () {
          var title=$('#title').val();
          var type=$('#type').val();
          var place = $('#place').val();
          var startTime = $('#startTime').val();
          var endTime = $('#endTime').val();
          var content = $('#content').val();
          $.ajax({
           type: "post",
           url : "../mission/addMission",
           data:{title:title,type:type,place:place,startTime:startTime,endTime:endTime,content:content},
           success:function (result){

           },
           error:function () {
             alert("失败")
           }
          })
      });



  </script>
  </body>

</html>