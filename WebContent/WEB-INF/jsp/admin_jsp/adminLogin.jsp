<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="snsPath" value="${pageContext.request.contextPath}/static" />
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8">
    <title>管理员登录</title>
    <link rel="icon" href="${snsPath}/images/bgi_images/title_logo.png" type="image/x-icon"/>
    <link href="${snsPath}/css/common/reset.css" rel="stylesheet" type="text/css"/>
    <link href="${snsPath}/css/common/model.css" rel="stylesheet" type="text/css"/>
    <link href="${snsPath}/css/userLogin.css" rel="stylesheet" type="text/css"/>
  </head>
  <body style="background-color: rgba(0,0,0,0.8);">
    <script type="text/javascript" src="${snsPath}/js/common/jquery-1.4.3.js"></script>

    <div class="appTitle">
      <div class="logo"><span>校园社交</span></div>
      <div class="title">
        <span>分&nbsp;&nbsp;享&nbsp;&nbsp;生&nbsp;&nbsp;活</span>
        <span>丰&nbsp;&nbsp;富&nbsp;&nbsp;校&nbsp;&nbsp;园</span>
      </div>
    </div>
    
    <!-- 登录表单 -->
    <div class="loginForm">
      <span>后台管理员登录</span>
      <form action="checkAdmin.do" method="post" id="login">
        <div class="line">
          <label>邮&nbsp;&nbsp;箱</label>
          <input type="text" name="email" id="email" placeholder="请输入邮箱号"/>
          <a href="#" class="link"><img alt="正在加载..." src="${snsPath}/images/insert_images/link_cancel.png"></a>
        </div>
        <div class="line">
          <label>密&nbsp;&nbsp;码</label>
          <input type="password" name="password" id="password" placeholder="请输入密码"/>
          <a href="#" class="link"><img alt="正在加载..." src="${snsPath}/images/insert_images/link_cancel.png" /></a>
        </div>
        <span class="errorInfo"></span>
        <div class="line submit">登 &nbsp;&nbsp;录</div>
      </form>
      <span class="errorInfo2">${ErrorMessage}</span>
    </div>
    <script type="text/javascript" src="${snsPath}/js/userLogin.js"></script>
  </body>
</html>