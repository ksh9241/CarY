<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="row-5">
	<div class="col-md-10 offset-md-1">
		<ul class="pagination justify-content-center">
			<c:forEach var="i" begin="1" end="${pageCount}" step="1">
				<li class="page-item <c:if test="${cpage==i}">active</c:if>">
					<a class="page-link" href="postList.do?cpage=${i}">${i}</a>
				</li>
			</c:forEach>
		</ul>
	</div>	
</div>