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
    <link href="${snsPath}/css/admin/publish.css" rel="stylesheet" type="text/css"/>
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
        </div>
        <div class="content-wrapper">
          <span>发表资讯</span>
          <div class="errorMeg">发表内容不能为空哦！</div>
          <div>
            <div>
              <input type="text" name="issueName" class="issueName" placeholder="填写发表单位名称" spellcheck="false"/>
            </div>
            <div class="choose-type">
              <label>选择发表类型：</label>
              <input type="radio" name="issueType" value="1" checked/> <span>教务通知</span>
              <input type="radio" name="issueType" value="2"/> <span>后勤讯息</span>
              <input type="radio" name="issueType" value="3"/> <span>校园新闻</span>
            </div>
            <div class="edit">
              <div class="content" contenteditable="true" id="divEdit" data-placeholder="请在这里输入......" spellcheck="false"></div>
              <div class="push">发布</div>
            </div>
          </div>
        </div>
      </div>
    </div>

    <!-- 脚头部分 -->
    <jsp:include page="../common/footer.jsp"></jsp:include>
    
    <!-- 控制文本编辑框 -->
    <script type="text/javascript" src="${snsPath}/js/admin/adminPublish.js"></script>
  </body>
</html>