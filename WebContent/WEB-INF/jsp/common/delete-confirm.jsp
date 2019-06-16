<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="snsPath" value="${pageContext.request.contextPath}/static" />
<!DOCTYPE html>
<link type="text/css" rel="styleSheet" href="${snsPath}/css/common/delete-confirm.css" />
<div class="alert-close">
  <label class="message"></label>
  <img alt="loading..." src="${snsPath}/images/insert_images/BTN_Close_16x16.png">
  <span>你确定删除所选的选项?</span>
  <div class="bt-yes">Yes</div>
  <div class="bt-no">No</div>
</div>
<script type="text/javascript" src="${snsPath}/js/common/delete-comfirm.js"></script>
