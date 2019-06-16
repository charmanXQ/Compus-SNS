<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<div class="left-tab">
  <ul>
    <li><a class="${curTab == 'userManagementTab' ? 'active' : '' }" href="adminMain.do">用户管理</a></li>
    <li><a class="${curTab == 'dynamicManagementTab' ? 'active' : '' }" href="dynamicManage.do">动态审核</a></li>
    <li><a class="${curTab == 'photoManagementTab' ? 'active' : '' }" href="photoManage.do">照片审核</a></li>
    <li><a class="${curTab == 'noticePublishTab' ? 'active' : '' }" href="noticePublish.do">发布通知</a></li>
    <li><a class="${curTab == 'noticeManagementTab' ? 'active' : '' }" href="noticeManage.do">通知管理</a></li>
  </ul>
</div>

