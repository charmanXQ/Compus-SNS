<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="snsPath" value="${pageContext.request.contextPath}/static" />
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8">
    <link rel="icon" href="${snsPath}/images/bgi_images/title_logo.png" type="image/x-icon"/>
    <title>我的相册</title>
    <link href="${snsPath}/css/common/reset.css" rel="stylesheet" type="text/css"/>
    <link href="${snsPath}/css/userAlbum.css" rel="stylesheet" type="text/css"/>
    <link href="${snsPath}/css/common/pagination.css" rel="stylesheet" type="text/css"/>
  </head>
  <body>
    <script type="text/javascript" src="${snsPath}/js/common/jquery-1.4.3.js"></script>

    <!-- 头部 -->
    <jsp:include page="../common/header.jsp"></jsp:include>

    <!-- 标题部分 -->
    <jsp:include page="../common/banner.jsp"></jsp:include>

    <!-- 主题部分 -->
    <div class="main clearfix">
      <div class="model"></div>
      <jsp:include page="../common/delete-confirm.jsp"></jsp:include>
      
      <!-- 上传部分 -->
      <div class="upload_pic">
        <a href="javascript:void(0)" class="cancel_upload">取消上传</a>
        <jsp:include page="../common/upload.jsp"></jsp:include>
      </div>
    
      <div class="slogan clearfix">
        <span>相册</span>
        <a href="javascript:void(0)" class="btn-upload">上传照片</a>
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
                <li class="active_li"><a href="userAlbum.do?currentPage=1">&laquo;</a></li>
                <li class="active_li"><a href="userAlbum.do?currentPage=${pagination.currentPage-1}">Prev</a></li>
              </c:otherwise>
            </c:choose>
      
            <c:choose>
              <c:when test="${pagination.currentPage > pagination.pageCount-1}">
                <li class="unactive_li">Next</li>
                <li class="unactive_li">&raquo;</li>
              </c:when>
              <c:otherwise>
                <li class="active_li"><a href="userAlbum.do?currentPage=${pagination.currentPage+1}">Next</a></li>
                <li class="active_li"><a href="userAlbum.do?currentPage=${pagination.pageCount}">&raquo;</a></li>
              </c:otherwise>
            </c:choose>
          </ul>
          <div class="page_count">总页数：<font>${pagination.pageCount} </font>页</div>
        </nav>
      </c:if>
      <c:if test="${userAlbum.size() == 0 }">
        <div class="lineInfo">您的相册还是空的哦！赶快去上传吧！</div>
      </c:if>
    </div>
    
    <!-- 脚头部分 -->
    <jsp:include page="../common/footer.jsp"></jsp:include>

    <script type="text/javascript" src="${snsPath}/js/userAlbum.js"></script>
    <script type="text/javascript" src="${snsPath}/js/common/search.js"></script>
  </body>
</html>