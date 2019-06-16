<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="snsPath" value="${pageContext.request.contextPath}/static" />
<!DOCTYPE html>
<link href="${snsPath}/css/common/reset.css" rel="stylesheet" type="text/css"/>
<link href="${snsPath}/css/common/header.css" rel="stylesheet" type="text/css"/>
<script type="text/javascript" src="${snsPath}/js/common/jquery-1.4.3.js"></script>
<div class="headerWarpper">
  <div class="header">
    <!-- 头部左边 -->
    <div class="logoTitle">
      <img alt="正在加载..." src="${snsPath}/images/insert_images/main_logo.png"/>
      <span>校园社交</span>
    </div>
    <!-- 头部右边 -->
    <div class="selfInfo">
      <span class="admin-welcome">欢迎管理员！ <font>${Admin.nickName}</font></span>
      <img alt="正在加载..." src="${snsPath}/images/${Admin.logoUrl}" class="userLogo" />
      <a href="exitAdmin.do" id="exit">退出</a>
    </div>
  </div>
</div>
<script type="text/javascript" src="${snsPath}/js/common/header.js"></script>