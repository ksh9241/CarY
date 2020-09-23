<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="/top1.jsp" />
<style>
.carousel-item{
	text-align: center;
}
	.carousel-item img{
		width:70%;
		margin:auto;
	}
</style>
<div class="text-left p-5">
	<h1>차종</h1><br>
	<h2>${DetailList.car_num}|${DetailList.car_age}|${DetailList.car_km}|${DetailList.car_color}|${DetailList.car_price}</h2><br>
	
	<div id="demo" class="carousel slide" data-ride="carousel">

  <!-- Indicators -->
  <ul class="carousel-indicators" id="carousel">
    <li data-target="#demo" data-slide-to="0" class="active"></li>
    <li data-target="#demo" data-slide-to="1"></li>
    <li data-target="#demo" data-slide-to="2"></li>
  </ul>

  <!-- The slideshow -->
  <div class="carousel-inner">
    <div class="carousel-item active">
      <img src="images/${DetailList.car_img1}" alt="Los Angeles">
    </div>
    <div class="carousel-item">
      <img src="images/${DetailList.car_img2}" alt="Chicago">
    </div>
    <div class="carousel-item">
      <img src="images/${DetailList.car_img3}" alt="New York">
    </div>
  </div>

  <!-- Left and right controls -->
  <a class="carousel-control-prev" href="#demo" data-slide="prev">
    <span class="carousel-control-prev-icon"></span>
  </a>
  <a class="carousel-control-next" href="#demo" data-slide="next">
    <span class="carousel-control-next-icon"></span>
  </a>

</div>
	
</div>

<jsp:include page="/foot1.jsp" />