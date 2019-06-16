<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="snsPath" value="${pageContext.request.contextPath}/static" />
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8">
    <link rel="icon" href="${snsPath}/images/bgi_images/title_logo.png" type="image/x-icon"/>
    <title>好友动态</title>
    <link href="${snsPath}/css/common/reset.css" rel="stylesheet" type="text/css"/>
    <link href="${snsPath}/css/friendDynamic.css" rel="stylesheet" type="text/css"/>
  </head>
  <body>
    <!-- 头部 -->
    <jsp:include page="../common/header.jsp"></jsp:include>
    <!-- 标题部分 -->
    <jsp:include page="../common/banner.jsp"></jsp:include>
    <!-- 主题部分 -->
    <div class="main clearfix">
      <jsp:include page="/addFriendDynamic.do"></jsp:include>
    </div>
    
    <!-- 脚头部分 -->
    <jsp:include page="../common/footer.jsp"></jsp:include>
    
  </body>
</html>