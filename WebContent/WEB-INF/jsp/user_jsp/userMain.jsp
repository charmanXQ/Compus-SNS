<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="snsPath" value="${pageContext.request.contextPath}/static" />
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8">
    <title>${USER.nickName}的主页</title>
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
      <!-- 左边用户编辑信息 -->
      <div class="edit_user_message">
        <span class="edit_message">信息编辑</span>
        <form action="editUserInfo.do" method="post">
          <label></label>
          <input type="text" name="nickName" value="${USER.nickName }" /><br/>
          <label></label>
          <input type="text" name="college" value="${USER.college }" /><br/>
          <input type="submit" value="提交" />
          <input type="button" value="取消" class="edit_cancel"/>
        </form>
      </div>
      <!-- 左边用户信息部分 -->
      <div class="left">
        <div class="self">
          <ul class="clearfix">
            <li><span>个人档案</span><a href="javascript:void(0);" title="编辑个人信息" id="editSelf"></a></li>
            <li class="selfLi"><label>昵称&nbsp;&nbsp;</label><span>${USER.nickName }</span></li>
            <li class="selfLi"><label>学院&nbsp;&nbsp;</label><span>${USER.college }</span></li>
            <li class="selfLi"><label>邮箱&nbsp;&nbsp;</label><span>${USER.email }</span></li>
          </ul>
        </div>
        <div class="friend">
          <!-- 测试个人档动态节点 -->
          <ul class="clearfix">
            <li>我的关注</li>
            <c:if test="${FriendList.size() == 0}">
              <li class="lineInfo">您暂时还没有好友哟！赶快去关注吧！</li>
            </c:if>
            <c:forEach items="${FriendList}" var="friend">
              <li class="friLi">
                <img alt="正在加载..." src="${snsPath}/images/${friend.logoUrl}">
                <span class="f_nickName">${friend.nickName}</span>
                <span class="f_college">${friend.college}</span>
                <a href="javascript:void(0);" title="取消关注" class="cancel_focus" data-user-id="${USER.id}" data-friend-id="${friend.id}"></a>
              </li>
            </c:forEach>
            <c:if test="${FriendList.size() > 0}">
              <li class="more_link"><a href="moreFriends.do">更多...</a></li>
            </c:if>
          </ul>
        </div>
      </div>
      <!-- 右边动态部分 -->
      <jsp:include page="/dynamic.do"/>
    </div>
      
      
    <!-- 脚头部分 -->
    <jsp:include page="../common/footer.jsp"></jsp:include>
    
    <script type="text/javascript" src="${snsPath}/js/common/model.js"></script>
    <script type="text/javascript" src="${snsPath}/js/userMain.js"></script>
    <script type="text/javascript" src="${snsPath}/js/common/search.js"></script>
  </body>
</html>