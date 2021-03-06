<%@ page isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<head>
  <meta charset="utf-8">
  <title>Ser Piero DaVinci</title>
  <meta content="width=device-width, initial-scale=1.0" name="viewport">
  <meta content="" name="keywords">
  <meta content="" name="description">

  <!-- Favicons -->
  <link href="/serpierodavinci-web/resources/eBusiness/img/favicon.png" rel="icon">
  <link href="/serpierodavinci-web/resources/eBusiness/img/apple-touch-icon.png" rel="apple-touch-icon">

  <!-- Bootstrap CSS File -->
  <link rel="stylesheet" type="text/css" href='<c:url value="/resources/eBusiness/lib/bootstrap/css/bootstrap.min.css" />'>
  <!-- Libraries CSS Files -->
  <link rel="stylesheet" type="text/css" href='<c:url value="/resources/eBusiness/lib/nivo-slider/css/nivo-slider.css" />'>
  <link rel="stylesheet" type="text/css" href='<c:url value="/resources/eBusiness/lib/owlcarousel/owl.carousel.css" />'>
  <link rel="stylesheet" type="text/css" href='<c:url value="/resources/eBusiness/lib/owlcarousel/owl.transitions.css"/>'>
  <link rel="stylesheet" type="text/css" href='<c:url value="/resources/eBusiness/lib/font-awesome/css/font-awesome.min.css" />'>
  <link rel="stylesheet" type="text/css" href='<c:url value="/resources/eBusiness/lib/animate/animate.min.css" />'>
  <link rel="stylesheet" type="text/css" href='<c:url value="/resources/eBusiness/lib/venobox/venobox.css" />'>

  <!-- Nivo Slider Theme -->
 <link rel="stylesheet" type="text/css" href='<c:url value="/resources/eBusiness/css/nivo-slider-theme.css"/>'>

  <!-- Main Stylesheet File -->
  <link rel="stylesheet" type="text/css" href='<c:url value="/resources/eBusiness/css/style.css" />'>

  <!-- Responsive Stylesheet File -->
  <link rel="stylesheet" type="text/css" href='<c:url value="/resources/eBusiness/css/responsive.css" />'>

</head>

<body data-spy="scroll" data-target="#navbar-example">

  <div id="preloader"></div>

  <header>
    <!-- header-area start -->
    <div id="sticker" class="header-area">
      <div class="container">
        <div class="row">
          <div class="col-md-12 col-sm-12">

            <!-- Navigation -->
            <nav class="navbar navbar-default">
              <!-- Brand and toggle get grouped for better mobile display -->
              <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target=".bs-example-navbar-collapse-1" aria-expanded="false">
										<span class="sr-only">Toggle navigation</span>
										<span class="icon-bar"></span>
										<span class="icon-bar"></span>
										<span class="icon-bar"></span>
									</button>
                <!-- Brand -->
                <a class="navbar-brand page-scroll sticky-logo" href="index.html">
                  <h1><span></span>Ser Piero Da Vinci</h1>
                  <!-- Uncomment below if you prefer to use an image logo -->
                  <!-- <img src="img/logo.png" alt="" title=""> -->
								</a>
              </div>
              <!-- Collect the nav links, forms, and other content for toggling -->
              <div class="collapse navbar-collapse main-menu bs-example-navbar-collapse-1" id="navbar-example">
                <ul class="nav navbar-nav navbar-right">
                  <li class="active">
                    <a class="page-scroll" href="#home">Inicio</a>
                  </li>
                  <li>
                    <a class="page-scroll" href="#portfolio">Materias</a>
                  </li>

                  <li class="dropdown"><ion-icon name="cog"></ion-icon><a href="#" class="dropdown-toggle" data-toggle="dropdown"><span class="caret"></span></a>
                    <ul class="dropdown-menu" role="menu">
                      <li><a href=# >Configurar</a></li>
                      <li><a href=# >Salir</a></li>
                    </ul> 
                  </li>
                </ul>
              </div>
              <!-- navbar-collapse -->
            </nav>
            <!-- END: Navigation -->
          </div>
        </div>
      </div>
    </div>
    <!-- header-area end -->
  </header>
  <!-- header end -->

  <!-- Start Slider Area -->
  <div id="home" class="slider-area">
    <div class="bend niceties preview-2">
      <div id="ensign-nivoslider" class="slides">
        <img alt="" title="#slider-direction-1" src='<c:url value="/resources/eBusiness/img/slider/sliderdavinci1.jpg"  />'/>
        <img alt="" title="#slider-direction-2" src='<c:url value="/resources/eBusiness/img/slider/slider2.jpg"  />'/>
        <img alt="" title="#slider-direction-3" src='<c:url value="/resources/eBusiness/img/slider/slider3.jpg"/>'/>
      </div>

      <!-- direction 1 -->
      <div id="slider-direction-1" class="slider-direction slider-one">
        <div class="container">
          <div class="row">
            <div class="col-md-12 col-sm-12 col-xs-12">
              <div class="slider-content">
                <!-- layer 1 -->
                <div class="layer-1-1 hidden-xs wow slideInDown" data-wow-duration="2s" data-wow-delay=".2s">
                  <h2 class="title1">Libertad de Expresión y Pensamiento</h2>
                </div>
                <!-- layer 2 -->
<!--                 <div class="layer-1-2 wow slideInUp" data-wow-duration="2s" data-wow-delay=".1s"> -->
<!--                   <h1 class="title2">We're In The Business Of Helping You Start Your Business</h1> -->
<!--                 </div> -->
                <!-- layer 3 -->
<!--                 <div class="layer-1-3 hidden-xs wow slideInUp" data-wow-duration="2s" data-wow-delay=".2s"> -->
<!--                   <a class="ready-btn right-btn page-scroll" href="#services">See Services</a> -->
<!--                   <a class="ready-btn page-scroll" href="#about">Learn More</a> -->
<!--                 </div> -->
              </div>
            </div>
          </div>
        </div>
      </div>

      <!-- direction 2 -->
      <div id="slider-direction-2" class="slider-direction slider-two">
        <div class="container">
          <div class="row">
            <div class="col-md-12 col-sm-12 col-xs-12">
              <div class="slider-content text-center">
                <!-- layer 1 -->
                <div class="layer-1-1 hidden-xs wow slideInUp" data-wow-duration="2s" data-wow-delay=".2s">
                  <h2 class="title1">Libertad de Expresión y Pensamiento</h2>
                </div>
                <!-- layer 2 -->
<!--                 <div class="layer-1-2 wow slideInUp" data-wow-duration="2s" data-wow-delay=".1s"> -->
<!--                   <h1 class="title2">We're In The Business Of Get Quality Business Service</h1> -->
<!--                 </div> -->
                <!-- layer 3 -->
<!--                 <div class="layer-1-3 hidden-xs wow slideInUp" data-wow-duration="2s" data-wow-delay=".2s"> -->
<!--                   <a class="ready-btn right-btn page-scroll" href="#services">See Services</a> -->
<!--                   <a class="ready-btn page-scroll" href="#about">Learn More</a> -->
<!--                 </div> -->
              </div>
            </div>
          </div>
        </div>
      </div>

      <!-- direction 3 -->
      <div id="slider-direction-3" class="slider-direction slider-two">
        <div class="container">
          <div class="row">
            <div class="col-md-12 col-sm-12 col-xs-12">
              <div class="slider-content">
                <!-- layer 1 -->
                <div class="layer-1-1 hidden-xs wow slideInUp" data-wow-duration="2s" data-wow-delay=".2s">
                  <h2 class="title1">Libertad de Expresión y Pensamiento</h2>
                </div>
                <!-- layer 2 -->
<!--                 <div class="layer-1-2 wow slideInUp" data-wow-duration="2s" data-wow-delay=".1s"> -->
<!--                   <h1 class="title2">Helping Business Security  & Peace of Mind for Your Family</h1> -->
<!--                 </div> -->
                <!-- layer 3 -->
<!--                 <div class="layer-1-3 hidden-xs wow slideInUp" data-wow-duration="2s" data-wow-delay=".2s"> -->
<!--                   <a class="ready-btn right-btn page-scroll" href="#services">See Services</a> -->
<!--                   <a class="ready-btn page-scroll" href="#about">Learn More</a> -->
<!--                 </div> -->
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
  <!-- End Slider Area -->
  
  <c:set var = "roleAndNameComplete" value="${pageContext.request.userPrincipal.authorities}"/>
  <c:set var = "roleAndNameCompleteSubA" value="${fn:substringAfter(roleAndNameComplete, '[')}"/>
  <c:set var = "roleComplete" value="${fn:substringBefore(roleAndNameCompleteSubA, ']')}"/>
                    

  <!-- Start portfolio Area -->
  <div id="portfolio" class="portfolio-area area-padding fix">
    <div class="container">
      <div class="row">
        <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
          <div class="section-headline text-center">
            <h2>Materias</h2>
          </div>
        </div>
      </div>
      <div class="row">
        <div class="awesome-project-1 fix">
          <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
            <div class="awesome-menu ">
              <ul class="project-menu">
                <li>
                  <a href="#" class="active" data-filter="*">Todas las materias</a>
                </li>
                	<c:if test ="${roleComplete == 'PADRE'}">
               			<c:forEach items="${hijos}" var="hijos">
			                <li>
			                  <a href="#" data-filter=".${hijos.nameforfilter}">${hijos.nombre}</a>
			                </li>
               			</c:forEach>
               		</c:if>
               	</ul>
            </div>
          </div>
        </div>
        <div class="awesome-project-content">
       			<c:choose>
       			<c:when test = "${roleComplete == 'PADRE'}">
					<c:forEach items="${hijoMateria}" var="hijoMateria">
			          	<div class="col-md-4 col-sm-4 col-xs-4 ${hijoMateria.nombre}" style='height: 288px;'>
			            	<div class="single-awesome-project">
				              <div class="awesome-img">
				                <a href="#"><img src='<c:url value="/resources/eBusiness/img/portfolio/${hijoMateria.image}.jpg"/>' alt="" /></a>
				                <div class="add-actions text-center">
				                  <div class="project-dec">
				                    <form role="form"
										action="<c:url value="/usuario/${usuario}/role/${roleComplete}/alumno/${hijoMateria.nameforfilter}/materias/${hijoMateria.matterforfilter}" />"
										method="post" enctype="multipart/form-data">
			                    		<a class="venobox" data-gall="myGallery" href="javascript:;" onclick="parentNode.submit();">
				                      	<h4>${hijoMateria.materia}</h4>
				                       	<span>${hijoMateria.materia}</span>
				                    </a>
				                    </form>
				                  </div>
				                </div>
				              </div>
			            	</div>
			          	</div>
					</c:forEach>
				</c:when>
				<c:otherwise>
						<c:forEach items="${materias}" var="materias">
				          	<div class="col-md-4 col-sm-4 col-xs-4 style='height: 288px;'">
				            	<div class="single-awesome-project">
					              <div class="awesome-img">
					                <a href="#"><img src='<c:url value="/resources/eBusiness/img/portfolio/${materias.image}.jpg"/>' alt="" /></a>
					                <div class="add-actions text-center">
					                  <div class="project-dec">
					                  <!-- class="venobox" data-gall="myGallery"  -->
					                  <form role="form"
										action="<c:url value="/usuario/${usuario}/role/${role}/materias/${materias.matterforfilter}" />"
										method="post" enctype="multipart/form-data">
					                    <a href="javascript:;" onclick="parentNode.submit();">
					                      <h4>${materias.materia}</h4>
					                       <span>${materias.materia}</span>
					                    </a>
					                    </form>
					                  </div>
					                </div>
					              </div>
					            </div>
				          	</div>
						</c:forEach>
				</c:otherwise>
			</c:choose>
      	</div>
      </div>
    </div>
  </div>
			<div>
				<form role="form"
					action="<c:url value="/usuario/vava/role/PADRE/materias/Matematica1" />"
					method="post" enctype="multipart/form-data">
					<button type="submit" class="btn btn-default">Enviar</button>
				</form>
			</div>
  <a href="#" class="back-to-top"><i class="fa fa-chevron-up"></i></a>

  <!-- JavaScript Libraries -->
  <script src='<c:url value="/resources/eBusiness/lib/jquery/jquery.min.js" />'></script>
  <script src='<c:url value="/resources/eBusiness/lib/bootstrap/js/bootstrap.min.js" />'></script>
  <script src='<c:url value="/resources/eBusiness/lib/owlcarousel/owl.carousel.min.js" />'></script>
  <script src='<c:url value="/resources/eBusiness/lib/venobox/venobox.min.js" />'></script>
  <script src='<c:url value="/resources/eBusiness/lib/knob/jquery.knob.js" />'></script>
  <script src='<c:url value="/resources/eBusiness/lib/wow/wow.min.js" />'></script>
  <script src='<c:url value="/resources/eBusiness/lib/parallax/parallax.js" />'></script>
  <script src='<c:url value="/resources/eBusiness/lib/easing/easing.min.js" />'></script>
  <script src='<c:url value="/resources/eBusiness/lib/nivo-slider/js/jquery.nivo.slider.js" />'></script>
  <script src='<c:url value="/resources/eBusiness/lib/appear/jquery.appear.js" />'></script>
  <script src='<c:url value="/resources/eBusiness/lib/isotope/isotope.pkgd.min.js" />'></script>

  <!-- Contact Form JavaScript File -->
  <script src='<c:url value="/resources/eBusiness/contactform/contactform.js" />'></script>

  <script src='<c:url value="/resources/eBusiness/js/main.js" />'></script>
</body>
<jsp:include page="footer.jsp" /> 

