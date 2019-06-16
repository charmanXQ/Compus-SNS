<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="snsPath" value="${pageContext.request.contextPath}/static" />
<!DOCTYPE html>
<link href="${snsPath}/css/common/reset.css" rel="stylesheet" type="text/css"/>
<link href="${snsPath}/css/common/banner.css" rel="stylesheet" type="text/css"/>
<script type="text/javascript" src="${snsPath}/js/common/jquery-1.4.3.js"></script>
<c:choose>
  <c:when test="${isOtherMainPage}">
    <div class="banner">
      <img alt="正在加载..." src="${snsPath}/images/${otherUser.logoUrl}" class="userLogo" />
      <div>
        <span class="nickName">
          ${otherUser.nickName }
          <c:choose>
            <c:when test="${otherUser.sex == false}">
              <img alt="正在加载..." src="${snsPath}/images/insert_images/bwoman_logo.png" class="sexLogo"/>
            </c:when>
            <c:when test="${otherUser.sex == true}">
              <img alt="正在加载..." src="${snsPath}/images/insert_images/bman_logo.png" class="sexLogo"/>
            </c:when>
          </c:choose>
        </span>
      </div>
    </div>
  </c:when>
  <c:otherwise>
    <div class="banner">
      <img alt="正在加载..." src="${snsPath}/images/${USER.logoUrl}" class="userLogo" />
      <div>
        <span class="nickName">
          ${USER.nickName }
          <c:choose>
            <c:when test="${USER.sex == false}">
              <img alt="正在加载..." src="${snsPath}/images/insert_images/bwoman_logo.png" class="sexLogo"/>
            </c:when>
            <c:when test="${USER.sex == true}">
              <img alt="正在加载..." src="${snsPath}/images/insert_images/bman_logo.png" class="sexLogo"/>
            </c:when>
          </c:choose>
        </span>
        <!-- 测试 模拟动态操作节点 -->
        <ul class="clearfix">
          <c:forEach items="${USER.funcs}" var="func">
            <li class="barItem" id="${func.funcLink}_func">
              <a href="${func.funcLink}.do#${func.funcLink}" title="${func.funcName}">${func.funcName}</a>
            </li>
          </c:forEach>
        </ul>
      </div>
    </div>
  </c:otherwise>
</c:choose>
<script type="text/javascript" src="${snsPath}/js/common/banner.js"></script>
