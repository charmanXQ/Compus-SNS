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
    <link href="${snsPath}/css/common/dynamic.css" rel="stylesheet" type="text/css"/>
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
          <input type="text" name="dynamicKey" class="userKey" value="${dynamicKey}" placeholder="根据关键字搜索动态" spellcheck="false"/>
          <a href="javascript:void(0);" class="searchLogo_body"><img alt="正在加载..." src="${snsPath}/images/insert_images/search_logo.png" /></a>
        </div>
        <div class="content-wrapper">
          <div class="right clearfix" style="float: left;">
            <c:forEach items="${DynamicList}" var="dynamic">
              <div class="item clearfix">
                <div class="info">
                  <img alt="..." src="${snsPath}/images/${dynamic.issueUser.logoUrl}" class="userLogo"/>
                  <span class="info_nickName">${dynamic.issueUser.nickName}</span>
                  <span class="info_time">${dynamic.issueTime}</span>
                  <c:if test="${curTab == 'dynamicManagementTab'}">
                    <a href="javascript:void(0);" class="delete_dynamic" title="删除该动态" data-dynamic-id="${dynamic.id}"></a>
                  </c:if>
                </div>
                <div class="article">${dynamic.txtWords}</div>
                <div class="comment">
                  <c:forEach items="${dynamic.parComment}" var="parComment">
                    <div class="par_comments">
                      <div class="txt_comment clearfix">
                        <img alt="..." src="${snsPath}/images/${parComment.commentUser.logoUrl}" class="userLogo"/>
                        <div class="userInfo">
                          <div class="info_nickName">
                            <span>${parComment.commentUser.nickName}</span>
                            <span class="words">:&nbsp;${parComment.txtComment}</span>
                          </div>
                          <div class="info_time">
                            <span>${parComment.commentTime}</span>
                          </div>
                        </div>
                      </div>
                      <c:forEach items="${parComment.subComment}" var="subComment">
                        <div class="sub_comments clearfix">
                          <img alt="..." src="${snsPath}/images/${subComment.commentUser.logoUrl}" class="userLogo"/>
                          <div class="userInfo">
                            <div class="info_nickName">
                              <span>
                                ${subComment.commentUser.nickName}
                                <font>&nbsp;回复&nbsp;</font>
                                ${subComment.replyToUserName}
                                <font>&nbsp;:&nbsp;</font>
                              </span>
                              <span class="words">${subComment.txtComment}</span>
                            </div>
                            <div class="info_time">
                              <span>${subComment.commentTime}</span>
                            </div>
                          </div>
                        </div>
                      </c:forEach>
                    </div>
                  </c:forEach>
                </div>
              </div>
            </c:forEach>
            <!-- 分页部分 -->
            <nav class="page_navigation">
              <ul class="pagination clearfix">
                <c:choose>
                  <c:when test="${pagination.currentPage < 2}">
                    <li class="unactive_li">&laquo;</li>
                    <li class="unactive_li">Prev</li>
                  </c:when>
                  <c:otherwise>
                    <li class="active_li"><a href="dynamicManage.do?currentPage=1&dynamicKey=${dynamicKey}">&laquo;</a></li>
                    <li class="active_li"><a href="dynamicManage.do?currentPage=${pagination.currentPage-1}&dynamicKey=${dynamicKey}">Prev</a></li>
                  </c:otherwise>
                </c:choose>
          
                <c:choose>
                  <c:when test="${pagination.currentPage > pagination.pageCount-1}">
                    <li class="unactive_li">Next</li>
                    <li class="unactive_li">&raquo;</li>
                  </c:when>
                  <c:otherwise>
                    <li class="active_li"><a href="dynamicManage.do?currentPage=${pagination.currentPage+1}&dynamicKey=${dynamicKey}">Next</a></li>
                    <li class="active_li"><a href="dynamicManage.do?currentPage=${pagination.pageCount}&dynamicKey=${dynamicKey}">&raquo;</a></li>
                  </c:otherwise>
                </c:choose>
              </ul>
              <div class="page_count">总页数：<font>${pagination.pageCount} </font>页</div>
            </nav>
          </div>
          <script type="text/javascript" src="${snsPath}/js/common/dynamic.js"></script>
        </div>
      </div>
    </div>

    <!-- 脚头部分 -->
    <jsp:include page="../common/footer.jsp"></jsp:include>
    <script type="text/javascript" src="${snsPath}/js/admin/adminDynamic.js"></script>
  </body>
</html>