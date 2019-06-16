<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="snsPath" value="${pageContext.request.contextPath}/static" />
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8">
    <title>${otherUser.nickName}的主页</title>
    <link rel="icon" href="${snsPath}/images/bgi_images/title_logo.png" type="image/x-icon"/>
    <link href="${snsPath}/css/common/reset.css" rel="stylesheet" type="text/css"/>
    <link href="${snsPath}/css/common/model.css" rel="stylesheet" type="text/css"/>
    <link href="${snsPath}/css/userMain.css" rel="stylesheet" type="text/css"/>
  </head>
  <body>
    <script type="text/javascript" src="${snsPath}/js/common/jquery-1.4.3.js"></script>

    <!-- 头部左边 -->
    <jsp:include page="../common/header.jsp"></jsp:include>
    <!-- 标题部分 -->
    <jsp:include page="../common/banner.jsp"></jsp:include>

    <!-- 主题部分 -->
    <div class="main clearfix">
      <!-- 左边用户信息部分 -->
      <div class="left">
        <div class="self">
          <ul class="clearfix">
            <li><span>个人档案</span>
            <li class="selfLi"><label>昵称&nbsp;&nbsp;</label><span>${otherUser.nickName }</span></li>
            <li class="selfLi"><label>学院&nbsp;&nbsp;</label><span>${otherUser.college }</span></li>
            <li class="selfLi"><label>邮箱&nbsp;&nbsp;</label><span>${otherUser.email }</span></li>
          </ul>
        </div>
        <div class="friend">
          <!-- 测试个人档动态节点 -->
          <ul class="clearfix">
            <li>热门关注</li>
            <c:if test="${FriendList.size() == 0}">
              <li class="lineInfo">暂时还没有关注的人</li>
            </c:if>
            <c:forEach items="${FriendList}" var="friend">
              <li class="friLi">
                <img alt="正在加载..." src="${snsPath}/images/${friend.logoUrl}">
                <span class="f_nickName">${friend.nickName}</span>
                <span class="f_college">${friend.college}</span>
              </li>
            </c:forEach>
          </ul>
        </div>
      </div>
      <!-- 右边动态部分 -->
      <jsp:include page="/otherDynamic.do?friendId=${otherUser.nickName }"/>
    </div>
      
      
    <!-- 脚头部分 -->
    <jsp:include page="../common/footer.jsp"></jsp:include>
    
    <script type="text/javascript" src="${snsPath}/js/userMain.js"></script>
    <script type="text/javascript" src="${snsPath}/js/common/search.js"></script>
  </body>
</html>