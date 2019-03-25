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
  <meta name="viewport"
        content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi"/>
  <link rel="shortcut icon" href="/favicon.ico" type="image/x-icon"/>
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
<div class="x-nav">
      <span class="layui-breadcrumb">
        <a href="">首页</a>
        <a href="">演示</a>
        <a>
          <cite>导航元素</cite></a>
      </span>
  <a class="layui-btn layui-btn-small" style="line-height:1.6em;margin-top:3px;float:right"
     href="javascript:location.replace(location.href);" title="刷新" id="reflash">
    <i class="layui-icon" style="line-height:30px">ဂ</i></a>
</div>
<div class="x-body">
  <div class="layui-row">
    <form action="/mission/queryMyMission" method="post" name="postRequest">
      <input type="hidden" name="pageNo" id="pageNo" value="${queryModel.pageNo}">
      <div class="layui-input-inline">
        <input type="text" name="id" placeholder="需求编号" class="layui-input" value="${queryModel.id}">
      </div>
      <div class="layui-input-inline">
        <select name="statusDesc" value="${queryModel}">
          <option>任务状态</option>
          <option value="未完成" <c:if test="${'未完成' eq queryModel.statusDesc}">selected</c:if> >未完成</option>
          <option value="已完成" <c:if test="${'已完成' eq queryModel.statusDesc}">selected</c:if>>已完成</option>
          <option value="待审核" <c:if test="${'待审核' eq queryModel.statusDesc}">selected</c:if>>待审核</option>
        </select>
      </div>
      <div class="layui-input-inline">
        <select name="lockDesc">
          <option>是否可接</option>
          <option value="锁定" <c:if test="${'锁定' eq queryModel.lockDesc}"> selected </c:if> >锁定</option>
          <option value="可接" <c:if test="${'可接' eq queryModel.lockDesc}"> selected</c:if> >可接</option>
        </select>
      </div>

      <div class="layui-input-inline">

        <input class="layui-input"  placeholder="开始日" name="startTime" id="startTime"
        <c:if test="${null != queryModel.startTime}">
          value="<fmt:formatDate value="${queryModel.startTime}" pattern="yyyy-MM-dd"/>"
        </c:if>
        />

      </div>
      <div class="layui-input-inline">
        <input class="layui-input"  placeholder="截止日" name="endTime" id="endTime"
        <c:if test="${ null != queryModel.endTime}">
          value="<fmt:formatDate value="${queryModel.endTime}" pattern="yyyy-MM-dd"/>"
        </c:if>
        />
      </div>
      <button class="layui-btn" type="submit"><i class="layui-icon">&#xe615;</i></button>
    </form>

  </div>
  <xblock>

    <button class="layui-btn" onclick="x_admin_show('发布需求','../mission_add.jsp')"><i class="layui-icon"></i>发布求助
    </button>
    <span class="x-right" style="line-height:40px">共有数据：${count} 条 </span>
  </xblock>
  <table class="layui-table">
    <thead>
    <tr>
      <%--<th>--%>
      <%--<div class="layui-unselect header layui-form-checkbox" lay-skin="primary"><i--%>
        <%--class="layui-icon">&#xe605;</i></div>--%>
      <%--</th>--%>
      <th>编号</th>
      <th>标题</th>
      <th>类型</th>
      <th>地点</th>
      <th>开始时间</th>
      <th>结束时间</th>
      <th>任务状态</th>
      <th>是否可接</th>
      <th>详细说明</th>
      <%--<th>任务发起人</th>--%>
      <th>任务接受人</th>
      <th>操作</th>
    </tr>
    </thead>
    <tbody>

    <c:forEach items="${missions}" var="items" varStatus = "status">
      <tr>
        <%--<td>--%>
        <%--<div class="layui-unselect layui-form-checkbox" lay-skin="primary" data-id='2'><i--%>
          <%--class="layui-icon">&#xe605;</i></div>--%>
        <%--</td>--%>
          <%--<td>${status.count}</td>--%>
        <td>${items.id}</td>
        <td>${items.title}</td>
        <td>${items.typeDesc}</td>
        <td>${items.place}</td>
        <td><fmt:formatDate value="${items.startTime}" pattern="yyyy-MM-dd"/></td>
        <td><fmt:formatDate value="${items.endTime}" pattern="yyyy-MM-dd"/></td>
        <td>${items.statusDesc}</td>
        <td>${items.lockDesc}</td>
        <td>${items.content}</td>
        <%--<td>${items.pidName}</td>--%>
        <td>
        <c:if test="${null eq items.aidName}">
          暂无
        </c:if>
          <c:if test="${null ne items.aidName}">
            ${items.aidName}
          </c:if>

        </td>
        <td class="td-manage">
            <a title="编辑"  onclick="x_admin_show('编辑','../mission/beforeUpdate?id=${items.id}')" href="javascript:;">
              <i class="layui-icon">&#xe642;</i>
            </a>

          <a title="删除"  onclick="member_del('删除','../mission/delete?mid=${items.id}')" href="../mission/delete?mid=${items.id}">
          <i class="layui-icon">&#xe640;</i>
        </a>
          <c:if test="${'待审核' eq items.statusDesc}">

          <a title="审核"  onclick="x_admin_show('审核','../mission/approval?mid=${items.id}')" href="../mission/approval?id=${items.id}">
          <button class="layui-btn">审批</button>
          </c:if>
          </a>
        </td>
      </tr>
    </c:forEach>
    </tbody>
  </table>
  <div class="page">
    <div>
      <a class="num" href="javascript:go(1)">首页</a>
      <c:if test="${currPage - 1 > 0}">
        <a class="prev" href="javascript:go(${currPage - 1})">
      </c:if>
      上一页
      </a>
      <c:if test="${currPage + 1 <= pages}">
        <a class="prev" href="javascript:go(${currPage + 1})">
      </c:if>
      下一页
      </a>
      <a class="num" href="javascript:go(${pages})">末页</a>
    </div>
  </div>
  <div class="page">
    共${pages}页 ，当前第${currPage}页
  </div>

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

    /*用户-停用*/
    function member_stop(obj, id) {
        layer.confirm('确认要停用吗？', function (index) {

            if ($(obj).attr('title') == '启用') {

                //发异步把用户状态进行更改
                $(obj).attr('title', '停用')
                $(obj).find('i').html('&#xe62f;');

                $(obj).parents("tr").find(".td-status").find('span').addClass('layui-btn-disabled').html('已停用');
                layer.msg('已停用!', {icon: 5, time: 1000});

            } else {
                $(obj).attr('title', '启用')
                $(obj).find('i').html('&#xe601;');

                $(obj).parents("tr").find(".td-status").find('span').removeClass('layui-btn-disabled').html('已启用');
                layer.msg('已启用!', {icon: 5, time: 1000});
            }

        });
    }

    /*用户-删除*/
    function member_del(obj, id) {
        layer.confirm('确认要删除吗？', function (index) {
            //发异步删除数据
            $(obj).parents("tr").remove();
            layer.msg('已删除!', {icon: 1, time: 1000});
            document.getElementById("reflash").click();
        });
    }

    /*用户-抢单*/
    function member_xiadan(obj, id) {
        layer.confirm('确认要抢单吗？', function (index) {
            //发异步删除数据
            $(obj).parents("tr").remove();
            layer.msg('已抢到该任务!', {icon: 1, time: 1000});
        });
    }


    function delAll(argument) {

        var data = tableCheck.getData();

        layer.confirm('确认要删除吗？' + data, function (index) {
            //捉到所有被选中的，发异步进行删除
            layer.msg('删除成功', {icon: 1});
            $(".layui-form-checked").not('.header').parents('tr').remove();
        });
    }
</script>
<script>var _hmt = _hmt || [];
(function () {
    var hm = document.createElement("script");
    hm.src = "https://hm.baidu.com/hm.js?b393d153aeb26b46e9431fabaf0f6190";
    var s = document.getElementsByTagName("script")[0];
    s.parentNode.insertBefore(hm, s);
})();</script>

<%--分页查询页码参数--%>
<script>
    function go(currPage){
        $('#pageNo').val(currPage)
        document.postRequest.submit();
    }

</script>
</body>

</html>