<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="snsPath" value="${pageContext.request.contextPath}/static" />
<!DOCTYPE html>
<link rel="stylesheet" href="${snsPath}/common/upload/control/css/zyUpload.css" type="text/css">
<script src="http://www.jq22.com/jquery/jquery-1.10.2.js"></script>
<!-- 引用核心层插件 -->
<script src="${snsPath}/common/upload/core/zyFile.js"></script>

<!-- 引用控制层插件 -->
<script src="${snsPath}/common/upload/control/js/zyUpload.js"></script>

<!-- 引用初始化JS -->
<script src="${snsPath}/common/upload/core/jq22.js"></script>

<div style="text-align:center; font-size: 15px;">上传图片</div>

<div id="demo" class="demo"></div>

