<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="snsPath" value="${pageContext.request.contextPath}/static" />
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8">
    <link rel="icon" href="${snsPath}/images/bgi_images/title_logo.png" type="image/x-icon"/>
    <title>发布动态</title>
    <link href="${snsPath}/css/common/reset.css" rel="stylesheet" type="text/css"/>
    <link href="${snsPath}/css/userIssue.css" rel="stylesheet" type="text/css"/>
  </head>
  <body>
    <script type="text/javascript" src="${snsPath}/js/common/jquery-1.4.3.js"></script>
    <!-- 头部 -->
    <jsp:include page="../common/header.jsp"></jsp:include>
    <!-- 标题部分 -->
    <jsp:include page="../common/banner.jsp"></jsp:include>
    <!-- 主题部分 -->
    <div class="main clearfix">
      <span>发表说说</span>
      <div class="errorMeg">发表内容不能为空哦！</div>
      <div>
        <div class="edit">
          <div class="content" contenteditable="true" id="divEdit" data-placeholder="我想在这里说..." spellcheck="false"></div>
          <div class="push" data-id="${USER.id}">发表</div>
        </div>
        <div class="count">
          <img alt="正在加载..." src="${snsPath}/images/${USER.logoUrl}" />
          <span>${USER.nickName }</span>
          <span><strong>${DyCount}</strong>&nbsp;条动态</span>
        </div>
      </div>
    </div>
    
    <!-- 脚头部分 -->
    <jsp:include page="../common/footer.jsp"></jsp:include>
    
    <!-- 控制文本编辑框 -->
    <script type="text/javascript" src="${snsPath}/js/userIssue.js"></script>
  </body>
</html>