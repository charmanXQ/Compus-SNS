<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="snsPath" value="${pageContext.request.contextPath}/static" />
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8">
    <title>管理员-${Admin.nickName}</title>
    <link rel="icon" href="${snsPath}/images/bgi_images/title_logo.png" type="image/x-icon"/>
    <link href="${snsPath}/css/common/reset.css" rel="stylesheet" type="text/css"/>
    <link href="${snsPath}/css/common/admin-common.css" rel="stylesheet" type="text/css"/>
    <link href="${snsPath}/css/admin/main.css" rel="stylesheet" type="text/css"/>
    <link href="${snsPath}/css/common/pagination.css" rel="stylesheet" type="text/css"/>
  </head>
  <body>
    <script type="text/javascript" src="${snsPath}/js/common/jquery-1.4.3.js"></script>

    <!-- 头部 -->
    <jsp:include page="../common/admin-header.jsp"></jsp:include>
    <!-- 头部空白-->
    <jsp:include page="../common/admin-empty.jsp"></jsp:include>

    <!-- 主题部分 -->
    <div class="main clearfix">
      <!-- 左边导航部分 -->
      <jsp:include page="../common/admin-tab.jsp"></jsp:include>
     
      <!-- 右边内容部分 -->
      <div class="right-content">
        <div class="search-wrapper clearfix">
          <input type="text" name="userKey" class="userKey" value="${userKey}"  placeholder="根据昵称或邮箱查找用户" spellcheck="false"/>
          <a href="javascript:void(0);" class="searchLogo_body"><img alt="正在加载..." src="${snsPath}/images/insert_images/search_logo.png" /></a>
        </div>
        <div class="content-wrapper">
          <table>
            <tr>
                <td class="table-header num">
                    <b>序号</b>
                </td>
                <td class="table-header nickName">
                    <b>昵称</b>
                </td>
                <td class="table-header sex">
                    <b>性别</b>
                </td>
                <td class="table-header email">
                    <b>邮箱</b>
                </td>
                <td class="table-header college">
                    <b>学院</b>
                </td>
                <td class="table-header count">
                    <b>动态数</b>
                </td>
                <td class="table-header action">
                    <b>操作</b>
                </td>
            </tr>

            <!-- 用户信息  -->
            <c:forEach items="${searchUsers}" var="searchUser" varStatus="i">
              <tr>
                <td class="table-body num">${i.index+1}</td>
                <td class="table-body nickName">${searchUser.nickName}</td>
                <c:choose>
                  <c:when test="${searchUser.sex}">
                    <td class="table-body sex">男</td>
                  </c:when>
                  <c:otherwise>
                    <td class="table-body sex">女</td>
                  </c:otherwise>
                </c:choose>
                <td class="table-body email">${searchUser.email}</td>
                <td class="table-body college">${searchUser.college}</td>
                <td class="table-body count">${searchUser.dynamicCount}</td>
                <td class="table-body action"><a href="javascript:void(0);" class="func-operate" data-userId="${searchUser.id}">重置权限</a></td>
              </tr>
            </c:forEach>
          </table>
        </div>
        <!-- 分页部分 -->
        <nav class="page_navigation">
          <ul class="pagination clearfix">
            <c:choose>
              <c:when test="${pagination.currentPage < 2}">
                <li class="unactive_li">&laquo;</li>
                <li class="unactive_li">Prev</li>
              </c:when>
              <c:otherwise>
                <li class="active_li"><a href="adminMain.do?currentPage=1&userKey=${userKey}">&laquo;</a></li>
                <li class="active_li"><a href="adminMain.do?currentPage=${pagination.currentPage-1}&userKey=${userKey}">Prev</a></li>
              </c:otherwise>
            </c:choose>
      
            <c:choose>
              <c:when test="${pagination.currentPage > pagination.pageCount-1}">
                <li class="unactive_li">Next</li>
                <li class="unactive_li">&raquo;</li>
              </c:when>
              <c:otherwise>
                <li class="active_li"><a href="adminMain.do?currentPage=${pagination.currentPage+1}&userKey=${userKey}">Next</a></li>
                <li class="active_li"><a href="adminMain.do?currentPage=${pagination.pageCount}&userKey=${userKey}">&raquo;</a></li>
              </c:otherwise>
            </c:choose>
          </ul>
          <div class="page_count">总页数：<font>${pagination.pageCount} </font>页</div>
        </nav>
      </div>
    </div>

    <!-- 权限操作部分-->
    <div class="message">删除成功</div>
    <div class="func-action">
      <span class="title">重置权限</span><br/>
      <input name="function" class="function" value="1" type="checkbox"/><span class="item-name">个人中心</span><br/><br/>
      <input name="function" class="function" value="2" type="checkbox"/><span class="item-name">私人相册</span><br/><br/>
      <input name="function" class="function" value="3" type="checkbox"/><span class="item-name">发布动态</span><br/><br/>
      <input name="function" class="function" value="4" type="checkbox"/><span class="item-name">好友动态</span><br/><br/>
      <a href="javascript:void(0);" class="comfirm">确认重置</a>
      <a href="javascript:void(0);" class="cancel" data-userId="">取消重置</a>
    </div>

    <!-- 脚头部分 -->
    <jsp:include page="../common/footer.jsp"></jsp:include>

    <script type="text/javascript" src="${snsPath}/js/admin/adminMain.js"></script>
  </body>
</html>