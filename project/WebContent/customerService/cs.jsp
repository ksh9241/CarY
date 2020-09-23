<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<jsp:include page="/top1.jsp" />

<style>
.top-margin {
	margin-top: 40px;
}

.button_box {
	width: 100%;
}

.qa_btn_box {
	margin: 12px 0;
}

a {
	color: inherit;
}

.table_tit {
	width: 100%;
}

button:hover {
	color: #fff;
}

.table_list>.tbody .table_tit:hover {
	text-decoration: underline;
}

.table_list_paging_wrap .paging {
	text-align: center;
	font-size: 0;
}

.table_list_paging_wrap .paging a {
	display: inline-block;
	margin-left: 10px;
	padding: 5px 10px;
	font-size: 12px;
}

.table_list_paging_wrap .paging a:first-child {
	margin-left: 0;
}

.table_list_paging_wrap .paging a.num {
	border: 1px solid #e66b27;
	font-weight: 600;
	color: #e66b27;
}

.table_list_paging_wrap .paging a.num.on {
	background: #e66b27;
	color: #fff;
}

@media all and (max-width:767px) {
	.thead {
		display: none;
	}
	.table_num {
		display: none;
	}
	hr.table_divider {
		width: 100%;
		border-bottom: 1px solid #ededed;
		height: 1px;
	}
	hr.table_list {
		width: 100%;
		background: #e66b27;
		height: 2px;
	}
	h2.tit {
		font-size: 28px;
		float: left;
	}
	.header_tit {
		margin: 8px 0;
	}
	.qa_btn {
		float: right;
		font-size: 12px;
		/* margin-top: 4px !important; */
		background: #2f3640;
		border: 1px solid black;
		border: none;
		color: #fff;
		padding: 4px 8px;
	}
	hr.table_divider {
		border-bottom: 1px solid #ededed;
	}
	.table_writer, .table_date {
		float: left;
		display: block;
		font-size: 12px;
		margin-right: 8px;
	}
	.table_list .tbody>div {
		padding-left: 8px;
	}
	.table_tit {
		padding-top: 12px;
		padding-bottom: 8px;
	}
	.table_date, .table_writer {
		padding-bottom: 12px;
	}
	.table_list_paging_wrap {
		margin-top: 14px;
	}
}

@media all and (min-width:768px) {
	.top-margin {
		margin-top: 80px;
	}
	hr.table_list {
		display: none;
	}
	hr.table_divider {
		display: none;
	}
	.table_list_paging_wrap {
		margin-top: 18px;
	}
	h2.tit {
		font-size: 36px;
		float: left;
	}
	.header_tit {
		margin: 12px 0;
	}
	.qa_btn_box {
		margin-top: 8px;
	}
	.qa_btn {
		float: right;
		font-size: 14px;
		/* margin-top: 24px; */
		background: #2f3640;
		border: 1px solid black;
		border: none;
		color: #fff;
		padding: 6px 14px;
	}
	a {
		text-decoration: none;
		color: inherit;
	}
	.table_list {
		width: 100%;
		border-top: 2px solid #e66b27;
	}
	.thead, .tbody {
		width: 100%;
		display: block;
	}
	.table_list .thead>div, .table_list .tbody>div {
		text-align: center;
		padding: 24px 10px;
		box-sizing: border-box;
	}
	.table_list {
		width: 100%;
		margin-bottom: 36px;
	}
	.table_num, .table_writer {
		width: 10%;
	}
	.table_date {
		width: 20%;
	}
	.table_tit {
		width: 60%;
	}
	.table_tit a {
		text-align: center;
		display: block;
	}
	.table_list div>div {
		border-bottom: 1px solid #ededed;
		/* display: inline-block; */
		float: left;
	}
}
</style>

<div class="top-margin"></div>
<section class="container">
	<form action="cswrite.do">
		<div class="header_tit cfixed">
			<h2 class="tit">문의하기</h2>
		</div>
		<div class="table_list_wrap">
			<hr class="table_list">
			<div class="table_list">
				<div class="thead cfixed">
					<div class="table_num">번호</div>
					<div class="table_tit">제목</div>
					<div class="table_writer">글쓴이</div>
					<div class="table_date">작성일</div>
				</div>
				<c:if test="${csList ==null || empty csList }">
					<div>데이터가 없어요</div>
				</c:if>
				<c:if test="${csList !=null && not empty csList}">
					<c:forEach var="cs" items="${csList}">
						<div class="tbody cfixed">
							<div class="table_num">${cs.cs_idx}</div>
							<div class="table_tit">
								<a href="csdetail.do?idx=${cs.cs_idx}">${cs.cs_tit}</a>
							</div>
							<div class="table_writer">${cs.cs_writer}</div>
							<div class="table_date">
								<fmt:formatDate value="${cs.cs_date}" pattern="yyyy-MM-dd" />
							</div>
							<hr class="table_divider">
						</div>
					</c:forEach>
				</c:if>
			</div>
		</div>
		<div class="cfixed qa_btn_box">
			<button class="qa_btn">글쓰기</button>
		</div>
		
		
		
		<div class="table_list_paging_wrap cfixed">
			<div class="paging"> 
			 	<c:if test="${prevBlock>0}">
					<a class="num" href="cshome.do?page=${prevBlock}">＜＜</a>
				 </c:if> 
			
				<c:forEach var="i" begin="${prevBlock+1}" end="${nextBlock-1}" step="1">
					<c:if test="${i <= pageCount}">
					<div class="num <c:if test="${page==i}">active</c:if>">
						<a class="num" href="cshome.do?page=${i}">${i}</a>
					</div>
					</c:if>
				</c:forEach>

				<c:if test="${nextBlock<=pageCount}">
					<a class="num" href="cshome.do?page=${nextBlock}">＞＞</a>
				</c:if>
				
				</div>
			</div>

	</form>
	<!-- detail을 보여주는 form 시작  -->
		<!-- <form action="detail.do" id="cf">
			<input name="idx" type="text"> secret이 설정되어있으면 history.back()한다. 
		</form> -->
		<!-- detail을 보여주는 form 끝 -->
</section>
<script>
	
</script>

<jsp:include page="/foot1.jsp" />