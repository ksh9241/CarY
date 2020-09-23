<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:forEach var="bL" items="${blist}">
<div class="option company-option">
    <input type="radio" name="maker" id="company" class="radio" value="${bL.b_name}">
       <label>${bL.b_name}</label>
</div>
</c:forEach>