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
    <link href="${snsPath}/css/admin/photo.css" rel="stylesheet" type="text/css"/>
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
        <div class="content-wrapper">
          <div class="model"></div>
          <jsp:include page="../common/delete-confirm.jsp"></jsp:include>

          <div class="slogan clearfix">
            <span>照片浏览</span>
            <a href="javascript:void(0)" id="manage">批量管理</a>
            <a href="javascript:void(0)" id="finish">操作完成</a>
            <a href="javascript:void(0)" id="delete">删除</a>
          </div>
          <c:if test="${userAlbum.size() > 0 }">
            <div class="photos">
              <!-- 模拟动态循环 -->
              <c:forEach items="${userAlbum}" var="picture">
                <div class="picture_wrapper">
                  <input type="checkbox" class="select" value="${picture.id}" />
                  <img alt="正在加载..." src="${snsPath}/images/user_images/${picture.picURL}" />
                  <span>${picture.name}</span>
                  <a href="javascript:void(0);" class="delete_picture" title="删除该图片" data-picture-id="${picture.id}"></a>
                </div>
              </c:forEach>
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
                    <li class="active_li"><a href="photoManage.do?currentPage=1">&laquo;</a></li>
                    <li class="active_li"><a href="photoManage.do?currentPage=${pagination.currentPage-1}">Prev</a></li>
                  </c:otherwise>
                </c:choose>
          
                <c:choose>
                  <c:when test="${pagination.currentPage > pagination.pageCount-1}">
                    <li class="unactive_li">Next</li>
                    <li class="unactive_li">&raquo;</li>
                  </c:when>
                  <c:otherwise>
                    <li class="active_li"><a href="photoManage.do?currentPage=${pagination.currentPage+1}">Next</a></li>
                    <li class="active_li"><a href="photoManage.do?currentPage=${pagination.pageCount}">&raquo;</a></li>
                  </c:otherwise>
                </c:choose>
              </ul>
              <div class="page_count">总页数：<font>${pagination.pageCount} </font>页</div>
            </nav>
          </c:if>
          <c:if test="${userAlbum.size() == 0 }">
            <div class="lineInfo">暂时没有用户存储照片！</div>
          </c:if>
        </div>
      </div>
    </div>

    <!-- 脚头部分 -->
    <jsp:include page="../common/footer.jsp"></jsp:include>
    
    <script type="text/javascript" src="${snsPath}/js/userAlbum.js"></script>
  </body>
</html>