<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="snsPath" value="${pageContext.request.contextPath}/static" />
<c:set var="curUserId" value="${sessionScope.USER.id}"/>
<!DOCTYPE html>
<link href="${snsPath}/css/common/dynamic.css" rel="stylesheet" type="text/css"/>
<link href="${snsPath}/css/common/pagination.css" rel="stylesheet" type="text/css"/>
<script type="text/javascript" src="${snsPath}/js/common/jquery-1.4.3.js"></script>
<div class="comment_message"></div>
<div class="right clearfix">
  <span>${TitleName}</span>
  <!-- 测试个人档动态节点 -->
  <c:if test="${DynamicList.size() == 0}">
    <c:choose>
      <c:when test="${isOtherMainPage}">
        <div class="lineInfo">您的好友很懒，还没有发布过动态哦！</div>
      </c:when>
      <c:otherwise>
        <div class="lineInfo">您暂时还没有动态！赶快去发表吧！</div>
      </c:otherwise>
    </c:choose>
  </c:if>
  <c:forEach items="${DynamicList}" var="dynamic">
    <div class="item clearfix">
      <div class="info">
        <img alt="..." src="${snsPath}/images/${dynamic.issueUser.logoUrl}" class="userLogo"/>
        <span class="info_nickName">${dynamic.issueUser.nickName}</span>
        <span class="info_time">${dynamic.issueTime}</span>
        <c:if test="${TitleName == '我的动态' }">
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
                  <a href="javascript:void(0);" title="回复" class="sub-reply" data-dynamicId="${dynamic.id}" data-userId="${curUserId}" data-commentId="${parComment.id}" data-toUserName="${parComment.commentUser.nickName}"></a>
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
                    <a href="javascript:void(0);" title="回复" class="sub-reply" data-dynamicId="${dynamic.id}" data-userId="${curUserId}" data-commentId="${parComment.id}" data-toUserName="${subComment.commentUser.nickName}"></a>
                  </div>
                </div>
              </div>
            </c:forEach>
          </div>
        </c:forEach>
        <div class="s_comments clearfix">
          <input type="text" name="comment" id="comment${dynamic.id}" placeholder="评论" autocomplete="off" />
          <a href="javascript:void(0);" data-type="par-comment-reply" data-dynamicId="${dynamic.id}" data-userId="${curUserId}" >发表</a>
        </div>
      </div>
    </div>
  </c:forEach>
  <!-- 分页部分 -->
<%--   <nav class="page_navigation">
    <ul class="pagination clearfix">
      <c:choose>
        <c:when test="${pagination.currentPage < 2}">
          <li class="unactive_li">&laquo;</li>
          <li class="unactive_li">Prev</li>
        </c:when>
        <c:otherwise>
          <li class="active_li"><a href="userMain.do?currentPage=1">&laquo;</a></li>
          <li class="active_li"><a href="userMain.do?currentPage=${pagination.currentPage-1}">Prev</a></li>
        </c:otherwise>
      </c:choose>

      <c:choose>
        <c:when test="${pagination.currentPage > pagination.pageCount-1}">
          <li class="unactive_li">Next</li>
          <li class="unactive_li">&raquo;</li>
        </c:when>
        <c:otherwise>
          <li class="active_li"><a href="userMain.do?currentPage=${pagination.currentPage+1}">Next</a></li>
          <li class="active_li"><a href="userMain.do?currentPage=${pagination.pageCount}">&raquo;</a></li>
        </c:otherwise>
      </c:choose>
    </ul>
    <div class="page_count">总页数：<font>${pagination.pageCount} </font>页</div>
  </nav> --%>
</div>
<script type="text/javascript" src="${snsPath}/js/common/dynamic.js"></script>


