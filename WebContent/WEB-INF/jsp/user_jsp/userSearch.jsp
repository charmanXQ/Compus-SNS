<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="snsPath" value="${pageContext.request.contextPath}/static" />
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8">
    <link rel="icon" href="${snsPath}/images/bgi_images/title_logo.png" type="image/x-icon"/>
    <title>查找用户</title>
    <link href="${snsPath}/css/common/reset.css" rel="stylesheet" type="text/css"/>
    <link href="${snsPath}/css/userSearch.css" rel="stylesheet" type="text/css"/>
    <link href="${snsPath}/css/common/pagination.css" rel="stylesheet" type="text/css"/>
  </head>
  <body>
    <script type="text/javascript" src="${snsPath}/js/common/jquery-1.4.3.js"></script>
  
    <!-- 头部 -->
    <jsp:include page="../common/header.jsp"></jsp:include>
    <div class="hidden"></div>
    <!-- 主题部分 -->
    <div class="main clearfix">
      <span class="title">搜索结果</span>
      <c:if test="${searchUsers.size() > 0 }">
          <c:forEach items="${searchUsers}" var="searchUser">
            <div class="item">
              <img alt="正在加载..." src="${snsPath}/images/${searchUser.logoUrl}" class="userLogo"/>
              <div class="name">
                <b>${searchUser.nickName}</b>
                <c:set var="isFriend" value="false" />
                <c:forEach items="${friendIds}" var="friendId">
                  <c:if test="${friendId == searchUser.id && searchUser.id != USER.id}">
                    <a href="javascript:void(0);" class="cancel_focus" data-user-id="${USER.id}" data-friend-id="${searchUser.id}">取消关注</a>
                    <c:set var="isFriend" value="true" />
                  </c:if>
                </c:forEach>
                <c:if test="${isFriend == false && searchUser.id != USER.id }">
                  <a href="javascript:void(0);" class="add_focus" data-user-id="${USER.id}" data-friend-id="${searchUser.id}">关注</a>
                </c:if>
              </div>
              <div class="sex">
                <c:choose>
                  <c:when test="${searchUser.sex == false}">
                    <img alt="正在加载..." src="${snsPath}/images/insert_images/woman_logo.png" class="sexLogo"/>
                  </c:when>
                  <c:when test="${searchUser.sex == true}">
                    <img alt="正在加载..." src="${snsPath}/images/insert_images/man_logo.png" class="sexLogo"/>
                  </c:when>
                </c:choose>
                <c:if test="${searchUser.id != USER.id }">
                  <a href="friendMain.do?friendId=${searchUser.id}">查看他的主页</a>
                </c:if>
              </div>
              <span class="info">邮箱：
                <strong>${searchUser.email}</strong>&nbsp;&nbsp;|&nbsp;&nbsp;学院：
                <strong>${searchUser.college}</strong>&nbsp;&nbsp;|&nbsp;&nbsp;动态&nbsp;
                <strong>${searchUser.dynamicCount}</strong>
              </span>
            </div>
          </c:forEach>
          <!-- 分页部分 -->
          <nav class="page_navigation">
            <ul class="pagination clearfix">
              <c:choose>
                <c:when test="${pagination.currentPage < 2}">
                  <li class="unactive_li">&laquo;</li>
                  <li class="unactive_li">Prev</li>
                </c:when>
                <c:otherwise>
                  <li class="active_li"><a href="searchUserByKey.do?searchKey=${searchKey}&currentPage=1">&laquo;</a></li>
                  <li class="active_li"><a href="searchUserByKey.do?searchKey=${searchKey}&currentPage=${pagination.currentPage-1}">Prev</a></li>
                </c:otherwise>
              </c:choose>
      
              <c:choose>
                <c:when test="${pagination.currentPage > pagination.pageCount-1}">
                  <li class="unactive_li">Next</li>
                  <li class="unactive_li">&raquo;</li>
                </c:when>
                <c:otherwise>
                  <li class="active_li"><a href="searchUserByKey.do?searchKey=${searchKey}&currentPage=${pagination.currentPage+1}">Next</a></li>
                  <li class="active_li"><a href="searchUserByKey.do?searchKey=${searchKey}&currentPage=${pagination.pageCount}">&raquo;</a></li>
                </c:otherwise>
              </c:choose>
            </ul>
            <div class="page_count">总页数：<font>${pagination.pageCount} </font>页</div>
          </nav>
        </c:if>
        <c:if test="${searchUsers.size() <= 0 }">
          <div class="lineInfo">您搜索的关键字无结果！</div>
        </c:if>
    </div>

    <!-- 脚头部分 -->
    <jsp:include page="../common/footer.jsp"></jsp:include>
  </body>
  <script type="text/javascript" src="${snsPath}/js/common/search.js"></script>
</html>