<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="snsPath" value="${pageContext.request.contextPath}/static" />
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8">
    <link rel="icon" href="${snsPath}/images/bgi_images/title_logo.png" type="image/x-icon"/>
    <title>校园资讯</title>
    <link href="${snsPath}/css/common/reset.css" rel="stylesheet" type="text/css"/>
    <link href="${snsPath}/css/compusInfo.css" rel="stylesheet" type="text/css"/>
  </head>
  <body>
    <script type="text/javascript" src="${snsPath}/js/common/jquery-1.4.3.js"></script>
  
    <!-- 头部 -->
    <jsp:include page="../common/header.jsp"></jsp:include>
    <div class="hidden"></div>
    <!-- 主题部分 -->
    <div class="main clearfix">
      <div class="tab_nav">
        <ul class="clearfix">
          <li><a href="javascript:void(0);" class="active" data-id="academic">教务通知</a></li>
          <li><a href="javascript:void(0);" class="" data-id="life">后勤讯息</a></li>
          <li><a href="javascript:void(0);" class="" data-id="news">校园新闻</a></li>
        </ul>
      </div>
      <div class="tab academic">
        <c:choose>
          <c:when test="${academicList.size() == 0}">
            <div class="lineInfo">暂时没有教务讯息哦！</div>
          </c:when>
          <c:otherwise>
            <c:forEach items="${academicList}" var="academic">
              <div class="item clearfix">
                <div class="info">
                  <img alt="..." src="${snsPath}/images/insert_images/${academic.logoURL}" class="userLogo"/>
                  <span class="info_nickName">${academic.issueName}</span>
                  <span class="info_time">${academic.issueTime}</span>
                </div>
                <div class="article">${academic.text}</div>
              </div>
            </c:forEach>
          </c:otherwise>
        </c:choose>
      </div>
      
      <div class="tab life">
        <c:choose>
          <c:when test="${lifeList.size() == 0}">
            <div class="lineInfo">暂时没有后勤通知哦！</div>
          </c:when>
          <c:otherwise>
            <c:forEach items="${lifeList}" var="life">
              <div class="item clearfix">
                <div class="info">
                  <img alt="..." src="${snsPath}/images/insert_images/${life.logoURL}" class="userLogo"/>
                  <span class="info_nickName">${life.issueName}</span>
                  <span class="info_time">${life.issueTime}</span>
                </div>
                <div class="article">${life.text}</div>
              </div>
            </c:forEach>
          </c:otherwise>
        </c:choose>
      </div>
      
      <div class="tab news">
        <c:choose>
          <c:when test="${newsList.size() == 0}">
            <div class="lineInfo">暂时没有校园新闻哦！</div>
          </c:when>
          <c:otherwise>
            <c:forEach items="${newsList}" var="news">
              <div class="item clearfix">
                <div class="info">
                  <img alt="..." src="${snsPath}/images/insert_images/${news.logoURL}" class="userLogo"/>
                  <span class="info_nickName">${news.issueName}</span>
                  <span class="info_time">${news.issueTime}</span>
                </div>
                <div class="article">${news.text}</div>
              </div>
            </c:forEach>
          </c:otherwise>
        </c:choose>
      </div>
    </div>
    
    <!-- 脚头部分 -->
    <jsp:include page="../common/footer.jsp"></jsp:include>
    
  </body>
  <script type="text/javascript" src="${snsPath}/js/compusInfo.js"></script>
</html>