<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="snsPath" value="${pageContext.request.contextPath}/static" />
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8">
    <title>用户登录</title>
    <link rel="icon" href="${snsPath}/images/bgi_images/title_logo.png" type="image/x-icon"/>
    <link href="${snsPath}/css/common/reset.css" rel="stylesheet" type="text/css"/>
    <link href="${snsPath}/css/common/model.css" rel="stylesheet" type="text/css"/>
    <link href="${snsPath}/css/userLogin.css" rel="stylesheet" type="text/css"/>
  </head>
  <body>
    <script type="text/javascript" src="${snsPath}/js/common/jquery-1.4.3.js"></script>

    <img alt="正在加载..." src="${snsPath}/images/insert_images/bgi_login.jpg" class="bgiLogin">
    <div class="appTitle">
      <div class="logo"><span>校园社交</span></div>
      <div class="title">
        <span>分&nbsp;&nbsp;享&nbsp;&nbsp;生&nbsp;&nbsp;活</span>
        <span>丰&nbsp;&nbsp;富&nbsp;&nbsp;校&nbsp;&nbsp;园</span>
      </div>
    </div>
    
    <!-- 登录表单 -->
    <div class="loginForm">
      <span>校&nbsp;园&nbsp;社&nbsp;交&nbsp;应&nbsp;用</span>
      <form action="checkUser.do" method="post" id="login">
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
      <span><a href="#" id="register">还没有账号，注册！</a></span>
    </div>
    
    <!-- 注册模态框 -->
    <div class="model"></div>
    <div class="registerForm">
      
      <span>欢&nbsp;迎&nbsp;注&nbsp;册</span>
      <form action="userRegister.do" method="post" id="register2">
        <div class="register">
          <input type="text" name="nickName" id="r_nickName" placeholder="请输入昵称" autocomplete="off"/>
          <label id="nickError">昵称长度为4-20位！</label>
        </div>
        <div class="register">
          <input type="text" name="email" id="r_email" placeholder="请输入邮箱" autocomplete="off"/>
          <label id="emailError">注意邮箱格式哦！</label>
        </div>
        <div class="register">
          <input type="text" name="college" id="r_college" placeholder="请输入学院" autocomplete="off"/>
          <label id="collegeError">学院长度为3 -10位！</label>
        </div>
        <div class="register">
          <input type="radio" name="sex" id="boy" value="true" checked/> <span class="fboy">男</span>
          <input type="radio" name="sex" id="girl" value="false"/> <span class="fgirl">女</span>
          <label id="sexError">此项注册后不能修改！</label>
        </div>
        <div class="register">
          <input type="password" name="password" id="r_pwd" placeholder="请输入密码" autocomplete="off"/>
          <label id="pwdError">密码长度为6-20位！</label>
        </div>
        <div class="register">
          <input type="password" name="password2" id="r_pwd2" placeholder="请确认密码" autocomplete="off"/>
          <label id="pwd2Error">确认输入的密码！</label>
        </div>
        <div class="register code">
          <input type="text" name="verifyCode" id="r_code" placeholder="请输入验证码" autocomplete="off"/>
          <img alt="正在加载..." id="codeImg" src="getVerifyCode.do" />
          <label id="codeError">输入图片中的4位码！</label>
        </div>
        <div class="register r_submit">立&nbsp;&nbsp;即&nbsp;&nbsp;提&nbsp;&nbsp;交</div>
      </form>
      <a href="#" class="cancel"><img alt="" src="${snsPath}/images/insert_images/register_cancel.png"/></a>
    </div>
    <script type="text/javascript" src="${snsPath}/js/common/model.js"></script>
    <script type="text/javascript" src="${snsPath}/js/userLogin.js"></script>
  </body>
</html>