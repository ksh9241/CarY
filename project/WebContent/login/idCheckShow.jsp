<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:if test="${user eq null}">
	<p id="null" style="color:green; font-weight:bold;">��� ������ ���̵� �Դϴ�.</p>
</c:if>

<c:if test="${user ne null}">
	<p id="notNull" style="color:red; font-weight:bold;">�̹� �ִ� ���̵� �Դϴ�.</p>
</c:if>
