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
      <ul class="clearfix">
        <li class="title active" id="userMain"><a href="userMain.do#userMain" >个人主页</a></li>
        <li class="title" id="compusInfo"><a href="compusInfo.do#compusInfo">校园资讯</a></li>
      </ul>
    </div>
    <!-- 头部右边 -->
    <div class="selfInfo">
      <input type="file" name="user-logo" class="user-logo"/>
      <input type="text" name="search" placeholder="根据邮箱查找用户" spellcheck="false" autocomplete="off" value="${searchKey}" />
      <a href="javascript:void(0);" class="searchLogo"><img alt="正在加载..." src="${snsPath}/images/insert_images/search_logo.png" /></a>
      <img alt="正在加载..." src="${snsPath}/images/${USER.logoUrl}" title="点击更换图像" class="userLogo" />
      <a href="exit.do" id="exit">退出</a>
    </div>
  </div>
</div>
<script type="text/javascript" src="${snsPath}/js/common/header.js"></script>