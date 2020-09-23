<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%-- MAPPER에서 조건에 맞게 검색 --%>
<%-- 동시에 페이징 --%>

<c:if test="${carList eq null || empty carList }">
	<div id='nodata' style="text-align:center">데이터가 없습니다.</div>
</c:if>
		
<c:if test="${carList ne null && not empty carList }">
	<c:forEach items="${carList}" var="car">
		<div class="list_box clfixed">
			<div class="list_img">
			    <a href="#;"><img src="" alt="차량이미지"></a>
			</div>
			
			<div class="list_center">
			    <span class="tag">보험이력無</span>
			    <br />
			    <br />
			    <h3><a href="#;">${car.m_code}(${car.b_code}) ${car.s_code} </a></h3>
			    <br />
			    <ul class="list_car_info">
			        <li>${car.car_age}</li>
			        <li>${car.car_km}km</li>
			        <li>${car.car_fuel}</li>
			        <li>경기서부</li>
			        <li>무사고</li>
			    </ul>
			</div>
			
			<div class="list_right">
			    <span class="tag">홈서비스</span>
			    <br />
			    <br />
			    <h2 style="color: red;">${car.car_price}<small style="font-size: 0.8em;">만원</small>
			    </h2>
			</div>
		</div>
	</c:forEach>
<div class="table_list_paging_wrap">
	<div class="paging">
		<c:if test="${prevBlock>0}"> <!-- 이전 5개 -->
			<a class="page-link" href="#" onclick="executeCarList('1')">&laquo;</a>
			<a class="page-link" href="#" onclick="executeCarList('${prevBlock}')">&lt;</a>
		</c:if>
		
		<c:forEach var="i" begin="${prevBlock+1}" end="${nextBlock-1}" step="1">
		  <c:if test="${i<=pageCount}">	
			<a class="page-link" href="#" onclick="executeCarList('${i}')">${i}</a>
		  </c:if>	
		</c:forEach>
		
		<c:if test="${nextBlock<=pageCount}"> <!-- 이후 5개  ${nextBlock}-->
			<a class="page-link" href="#" onclick="executeCarList('${nextBlock}')">&gt;</a>
			<a class="page-link" href="#" onclick="executeCarList('${pageCount}')">&raquo;</a>
		</c:if>
	</div>
</div>	
</c:if>

<script type="text/javascript">
	new numCnt("sise_min", '${sise_min}');   	 
	new numCnt("sise_max", ${sise_max});
	$('#totalCar').text('${totalCount}');
</script>


