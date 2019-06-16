<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="snsPath" value="${pageContext.request.contextPath}/static" />
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8">
    <title>管理员-${Admin.nickName}</title>
    <link rel="icon" href="${snsPath}/images/bgi_images/title_logo.png" type="image/x-icon"/>
    <link href="${snsPath}/css/common/reset.css" rel="stylesheet" type="text/css"/>
    <link href="${snsPath}/css/common/admin-common.css" rel="stylesheet" type="text/css"/>
    <link href="${snsPath}/css/admin/notice.css" rel="stylesheet" type="text/css"/>
    <link href="${snsPath}/css/common/pagination.css" rel="stylesheet" type="text/css"/>
  </head>
  <body>
    <script type="text/javascript" src="${snsPath}/js/common/jquery-1.4.3.js"></script>

    <!-- 头部 -->
    <jsp:include page="../common/admin-header.jsp"></jsp:include>
    <!-- 头部空白-->
    <jsp:include page="../common/admin-empty.jsp"></jsp:include>

    <!-- 主题部分 -->
    <div class="main clearfix">
      <!-- 左边导航部分 -->
      <jsp:include page="../common/admin-tab.jsp"></jsp:include>
     
      <!-- 右边内容部分 -->
      <div class="right-content">
        <div class="search-wrapper clearfix">
          <input type="text" name="noticeKey" class="userKey" value="${noticeKey}" placeholder="根据关键字搜索通知" spellcheck="false"/>
          <a href="javascript:void(0);" class="searchLogo_body"><img alt="正在加载..." src="${snsPath}/images/insert_images/search_logo.png" /></a>
        </div>
        <div class="content-wrapper">
          <div class="tab">
            <c:choose>
              <c:when test="${noticeList.size() == 0}">
                <div class="lineInfo">暂时没有发布过关于此关键字的动态哦！</div>
              </c:when>
              <c:otherwise>
                <c:forEach items="${noticeList}" var="notice">
                  <div class="item clearfix">
                    <div class="info">
                      <img alt="..." src="${snsPath}/images/insert_images/${notice.logoURL}" class="userLogo"/>
                      <span class="info_nickName">${notice.issueName}</span>
                      <span class="info_time">${notice.issueTime}</span>
                      <a href="javascript:void(0);" class="delete_notice" title="删除该通知" data-notice-id="${notice.id}"></a>
                    </div>
                    <div class="article">${notice.text}</div>
                  </div>
                </c:forEach>
              </c:otherwise>
            </c:choose>
          </div>
          <!-- 分页部分 -->
          <nav class="page_navigation">
            <ul class="pagination clearfix">
              <c:choose>
                <c:when test="${pagination.currentPage < 2}">
                  <li class="unactive_li">&laquo;</li>
                  <li class="unactive_li">Prev</li>
                </c:when>
                <c:otherwise>
                  <li class="active_li"><a href="noticeManage.do?currentPage=1&noticeKey=${noticeKey}">&laquo;</a></li>
                  <li class="active_li"><a href="noticeManage.do?currentPage=${pagination.currentPage-1}&noticeKey=${noticeKey}">Prev</a></li>
                </c:otherwise>
              </c:choose>
        
              <c:choose>
                <c:when test="${pagination.currentPage > pagination.pageCount-1}">
                  <li class="unactive_li">Next</li>
                  <li class="unactive_li">&raquo;</li>
                </c:when>
                <c:otherwise>
                  <li class="active_li"><a href="noticeManage.do?currentPage=${pagination.currentPage+1}&noticeKey=${noticeKey}">Next</a></li>
                  <li class="active_li"><a href="noticeManage.do?currentPage=${pagination.pageCount}&noticeKey=${noticeKey}">&raquo;</a></li>
                </c:otherwise>
              </c:choose>
            </ul>
            <div class="page_count">总页数：<font>${pagination.pageCount} </font>页</div>
          </nav>
        </div>
      </div>
    </div>

    <!-- 脚头部分 -->
    <jsp:include page="../common/footer.jsp"></jsp:include>
    <script type="text/javascript" src="${snsPath}/js/admin/adminNotice.js"></script>
  </body>
</html>