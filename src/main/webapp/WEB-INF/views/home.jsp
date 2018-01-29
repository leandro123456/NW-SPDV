<%@ page isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>

<!DOCTYPE html>
<html lang="en">

<head>
 	<title>Pantalla Principal</title>
	<meta charset="utf-8">
   	<meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    
    
    <link href="../resources/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="../resources/dist/css/sb-admin-2.css" rel="stylesheet">
    <link href="../resources/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    
    
        <link rel="apple-touch-icon" href="apple-touch-icon.png">
        <link href='<c:url value="/resources/assets/css/bootstrap.min.css"/>' rel="stylesheet">
        <link rel="stylesheet" type="text/css" href='<c:url value="/resources/assets/css/plugins.css" />'>
        <link rel="stylesheet" type="text/css" href='<c:url value="/resources/assets/css/raleway-webfont.css" />'>
        <link rel="stylesheet" type="text/css" href='<c:url value="/resources/assets/css/style.css"/>'>
        <link rel="stylesheet" type="text/css" href='<c:url value="/resources/assets/css/responsive.css" />'>
        <script src='<c:url value="/resources/assets/js/vendor/modernizr-2.8.3-respond-1.4.2.min.js" />'></script>    
</head>

<body>
  <div class='preloader'><div class='loaded'>&nbsp;</div></div>
    <script src="../resources/vendor/jquery/jquery.min.js"></script>
    <script src="../resources/vendor/bootstrap/js/bootstrap.min.js"></script>

        <nav class="navbar navbar-default navbar-fixed-top">
                

            <div class="container">


                <div class="navbar-header">
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="<c:url value='/home/' />"><img alt="Nticxs" width="50%" 
                    src='<c:url value="/resources/images/nticxs-logo.png" />'></a>
                </div>


                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                    <ul class="nav navbar-nav navbar-right">                      

                        <li><a href="#home">Inicio</a></li>
                        <li class="active" id="provisioning">
                            <a href="<c:url value='/home/provisioning'/>" data-toggle="tooltip" title="Profile templates and output files upload">Clases</a>
                        </li>

                        <li id="templateExplorer">
                            <a href="<c:url value='/home/template/explorer'/>" data-toggle="tooltip" title="Edit template parameters">Foro</a>
                        </li>

                        <li id="ippGeneration">
                            <a href="<c:url value='/home/ipp/generation'/>" title="Generate new IPPs">Notas</a>
                        </li>

                        <li id="ippExplorer">
                            <a href="<c:url value='/home/ipp/explorer'/>">Faltas</a>
                        </li>

                        <li id="amdDP">
                            <a href="<c:url value='/home/amddp' />">Contacto </a>
                        </li>                                    
                    </ul>
                </div>

                

           <ul class="navbar-top-links navbar-right"> 
                <li class="navbar-top-links navbar-right">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                        <i class="fa fa-envelope fa-fw"></i> Mensajes <i class="fa fa-caret-down"></i>
                    </a>
                    <ul class="dropdown-menu dropdown-messages">
                        <li>
                            <a href="#">
                                <div>
                                    <strong>DE quien vino</strong>
                                    <span class="pull-right text-muted">
                                        <em>Dia</em>
                                    </span>
                                </div>
                                <div>Contenido del mail</div>
                            </a>
                        </li>
                       
                        <li class="divider"></li>
                        <li>
                            <a class="text-center" href="#">
                                <strong>Leer todos los mensajes</strong>
                                <i class="fa fa-angle-right"></i>
                            </a>
                        </li>
                    </ul>
                </li>


                <li class="navbar-top-links navbar-right">
					<a href="#" class="dropdown-toggle" data-toggle="dropdown">
						<i class="fa fa-user"></i>   ${pageContext.request.userPrincipal.name} <i class="fa fa-caret-down"></i>
					</a>
                    <ul class="dropdown-menu dropdown-user">
                        <li><a href="#"><i class="fa fa-user fa-fw"></i> Perfil</a>
                        </li>
                        <li><a href="<c:url value='/home/general/configuration' />" data-toggle="tooltip" title="General settings"><i class="fa fa-gear fa-fw"></i> Configuracion</a>
                        </li>
                        <li class="divider"></li>
                        <li>
                        	 <a href="<c:url value="/logoutsession" />"><i class="fa fa-fw fa-power-off"></i>Salir</a>
                        </li>
                    </ul>
                </li>
            </ul>
                
            </div>

        </nav>

        <header id="home" class="home">
            <div class="overlay-img">
                <div class="container">

                    <div class="row">
                        <div class="col-md-12">
                            <div class="home-content">
                                <h1>Materia <span>NTICXs</span></h1>
                                <h4>Ser Piero Da Vinci</h4>
                                <h5>Curso  <span>4to</span></h5>
                                <h6>Docente Guzman Leandro</h6>      
                            </div>
                        </div>
                    </div>
                </div>
            </div>	
        </header>

        <section id="about" class="sections">

            <div class="heading-content text-center">

                <h3>Know About Us</h3>

                <div class="separator"></div>

                <p>Nam liber tempor cum soluta nobis eleifend option congue nihil imperdiet doming id quod mazim </p>

            </div>

            <div class="about-bg">
                <div class="container">

                    <!-- Example row of columns -->
                    <div class="row">
                        <div class="col-md-6 col-sm-6 col-xs-6">
                            <div class="about-content">

                                <h3>We Are the best</h3>
                                <p>Consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat </p>
                                <p>Volutpat wisi enim ad minim veniam, quis nostrud exerci tation ullamcorper suscipit lobortis nisl ut aliquip ex ea commodo consequat. Duis autem vel eum iriure dolor in hendrerit in vulputate velit esse molestie consequat, vel illum dolore eu feugiat nulla facilisis at vero eros et accumsan et iusto odio dignissim qui blandit praesent luptatum zzril delenit augue duis dolore te feugait nulla facilisi. Nam liber tempor cum </p>


                                <a target="_blank" href="#"><button class="btn btn-default abt-btn">Read More<span><i class="fa fa-long-arrow-right"></i></span></button></a>
                            </div>
                        </div>

                        <div class="col-md-6 col-sm-6 col-xs-6">
                            <div class="about-img">
                                <img src="/resources/assets/images/about-img.jpg" alt="" />
                            </div>
                        </div>

                    </div>
                </div> <!-- /container -->   
            </div>

        </section>

        <!-- Sections -->
        <section id="service" class="sections">
            <div class="container text-center">
                <div class="heading-content2">

                    <h4>Services We provide</h4>

                    <p>
                        Volutpat wisi enim ad minim veniam, quis nostrud exerci tation ullamcorper suscipit lobortis nisl ut aliquip ex ea commodo 
                        consequat. Duis autem vel eum iriure dolor in hendrerit in vulputate velit esse molestie consequat, vel illum dolore eu 
                        feugiat nulla facilisis at vero eros et accumsan et iusto odio dignissim qui blandit praesent  
                    </p>

                </div>
                <!-- Example row of columns -->
                <div class="row">
                    <div class="col-md-4 col-sm-12 col-xs-12">
                        <div class="service-content">
                            <i class="fa fa-users"></i>
                            <h5>Consultancy</h5>
                            <p>Caritas aritas est etiam processus dynaicus qui sequitur mutationem consuetudium lectorum. Mirum est notare quam </p>
                        </div>
                    </div>

                    <div class="col-md-4 col-sm-12 col-xs-12">
                        <div class="service-content">
                            <i class="fa fa-camera"></i>
                            <h5>Marketing</h5>
                            <p>Caritas aritas est etiam processus dynaicus qui sequitur mutationem consuetudium lectorum. Mirum est notare quam </p>
                        </div>
                    </div>

                    <div class="col-md-4 col-sm-12 col-xs-12">
                        <div class="service-content">
                            <i class="fa fa-database"></i>
                            <h5>Research</h5>
                            <p>Caritas aritas est etiam processus dynaicus qui sequitur mutationem consuetudium lectorum. Mirum est notare quam </p>
                        </div>
                    </div>

                </div>
            </div> <!-- /container -->       
        </section>

        <!-- Sections -->
        <section id="our-skills" class=" skills skill-bg">
            <div class="overlay-img">
                <div class="container sections text-center">
                    <div class="skill-heading">

                        <h4>Our Skills</h4>

                    </div>
                    <!-- Example row of columns -->
                    <div class="row">
                            <div class="col-sm-3 text-center">
								<div class="main-skill">
									<div class="chart-round">
										<div class="chart" data-percent="86">
											<span class="percent"></span>
										</div>
									</div>
									<div class="skills-text">Marketing</div>
								</div>
                            </div>
							
                            <div class="col-sm-3 text-center">
								<div class="main-skill">
									<div class="chart-round">
										<div class="chart" data-percent="86">
											<span class="percent"></span>
										</div>
									</div>
									<div class="skills-text">Marketing</div>
								</div>
                            </div>
							
                            <div class="col-sm-3 text-center">
								<div class="main-skill">
									<div class="chart-round">
										<div class="chart" data-percent="86">
											<span class="percent"></span>
										</div>
									</div>
									<div class="skills-text">Marketing</div>
								</div>
                            </div>
							
                            <div class="col-sm-3 text-center">
								<div class="main-skill">
									<div class="chart-round">
										<div class="chart" data-percent="86">
											<span class="percent"></span>
										</div>
									</div>
									<div class="skills-text">Marketing</div>
								</div>
                            </div>

                        </div> 

                </div>
            </div> <!-- /container -->  
        </div>		
    </section>


    <!-- Sections -->
    <section id="project" class="sections">
        <div class="container text-center">

            <div class="heading-content text-center">

                <h3>Some Recent Project</h3>

                <div class="separator"></div>

                <p>Nam liber tempor cum soluta nobis eleifend option congue nihil imperdiet doming id quod mazim </p>

            </div>
            <!-- Example row of columns -->
            <div class="row">
			
                <div class="col-md-3 col-sm-6 col-xs-12">
				
                    <div class="project-item">
						<img src="/resources/assets/images/project/1.png" alt="" />
					
						<div class="project-overlay"></div>
						<div class="project-content">
							<h5>PaperClips</h5>
							<div class="project-separator"></div>
							<h6>Branding</h6>
						</div>
					</div>	
                    
                </div>

                <div class="col-md-3 col-sm-6 col-xs-12">
                    <div class="project-item">
						<img src="/resources/assets/images/project/2.png" alt="" />
					
						<div class="project-overlay"></div>
						<div class="project-content">
							<h5>PaperClips</h5>
							<div class="project-separator"></div>
							<h6>Branding</h6>
						</div>
					</div>
                </div>

                <div class="col-md-3 col-sm-6 col-xs-12">
                    <div class="project-item">
						<img src="/resources/assets/images/project/3.png" alt="" />
					
						<div class="project-overlay"></div>
						<div class="project-content">
							<h5>PaperClips</h5>
							<div class="project-separator"></div>
							<h6>Branding</h6>
						</div>
					</div>
                </div>

                <div class="col-md-3 col-sm-6 col-xs-12">
                    <div class="project-item">
						<img src="/resources/assets/images/project/4.png" alt="" />
					
						<div class="project-overlay"></div>
						<div class="project-content">
							<h5>PaperClips</h5>
							<div class="project-separator"></div>
							<h6>Branding</h6>
						</div>
					</div>
                </div>

                <div class="col-md-3 col-sm-6 col-xs-12">
                    <div class="project-item">
						<img src="/resources/assets/images/project/1.png" alt="" />
					
						<div class="project-overlay"></div>
						<div class="project-content">
							<h5>PaperClips</h5>
							<div class="project-separator"></div>
							<h6>Branding</h6>
						</div>
					</div>
                </div>

                <div class="col-md-3 col-sm-6 col-xs-12">
                    <div class="project-item">
						<img src="/resources/assets/images/project/2.png" alt="" />
					
						<div class="project-overlay"></div>
						<div class="project-content">
							<h5>PaperClips</h5>
							<div class="project-separator"></div>
							<h6>Branding</h6>
						</div>
					</div>
                </div>

                <div class="col-md-3 col-sm-6 col-xs-12">
                    <div class="project-item">
						<img src="/resources/assets/images/project/3.png" alt="" />
					
						<div class="project-overlay"></div>
						<div class="project-content">
							<h5>PaperClips</h5>
							<div class="project-separator"></div>
							<h6>Branding</h6>
						</div>
					</div>
                </div>

                <div class="col-md-3 col-sm-6 col-xs-12">
                    <div class="project-item">
						<img src="resources/assets/images/project/4.png" alt="" />
					
						<div class="project-overlay"></div>
						<div class="project-content">
							<h5>PaperClips</h5>
							<div class="project-separator"></div>
							<h6>Branding</h6>
						</div>
					</div>
                </div>

            </div>
			
			<div class="project-button">
				<a target="_blank" href="#"><button class="btn btn-default">See All<span><i class="fa fa-long-arrow-right"></i></span></button></a>
			</div>

        </div> <!-- /container -->       
    </section>

    <!-- Sections -->
    <section id="twitter" class="sections different-bg">
        <div class="container text-center">

            <!-- Example row of columns -->
            <div class="row">
                <div class="col-md-8 col-md-offset-2 col-sm-12 col-xs-12">
                    <div class="twitter-content">
                        <h5>LATEST FROM TWITTER</h5>
                        <p>Trying out velositey - a simple website building extension for Photoshop.</p>
                        <a target="_blank" href="#">buff.ly/NC8gog</a>
                    </div>
                </div>


            </div>

        </div> <!-- /container -->       
    </section>

    <!-- Sections -->
    <section id="team" class="sections lightbg">
        <div class="container text-center">
            <div class="heading-content text-center">

                <h3>Our Team Members</h3>

                <div class="separator"></div>

                <p>Nam liber tempor cum soluta nobis eleifend option congue nihil imperdiet doming id quod mazim </p>

            </div>
            <!-- Example row of columns -->
            <div class="row">
                <div class="col-md-4 col-sm-6 col-xs-12">
					<div class="main-team">
						<div class="team-details">

						  <img src="/resources/assets/images/team-img.jpg" alt="" />
							<div class="team-overlay"></div>
							
							<div class="social">
								<a href="#"><i class="fa fa-twitter"></i></a>
								<a href="#"><i class="fa fa-facebook"></i></a>
								<a href="#"><i class="fa fa-linkedin"></i></a>
							</div>

						</div>
						
						<div class="members-info">
							<h4>Mitchell Anderson</h4>
							<h6>Creative Director</h6>
						</div>
					</div>
                </div>
				
				<div class="col-md-4 col-sm-6 col-xs-12">
					<div class="main-team">
						<div class="team-details">

						  <img src="/resources/assets/images/team-img.jpg" alt="" />
							<div class="team-overlay"></div>
							
							<div class="social">
								<a href="#"><i class="fa fa-twitter"></i></a>
								<a href="#"><i class="fa fa-facebook"></i></a>
								<a href="#"><i class="fa fa-linkedin"></i></a>
							</div>

						</div>
						
						<div class="members-info">
							<h4>Mitchell Anderson</h4>
							<h6>Creative Director</h6>
						</div>
					</div>
                </div>
				
				<div class="col-md-4 col-sm-6 col-xs-12">
					<div class="main-team">
						<div class="team-details">

						  <img src="/resources/assets/images/team-img.jpg" alt="" />
							<div class="team-overlay"></div>
							
							<div class="social">
								<a href="#"><i class="fa fa-twitter"></i></a>
								<a href="#"><i class="fa fa-facebook"></i></a>
								<a href="#"><i class="fa fa-linkedin"></i></a>
							</div>

						</div>
						
						<div class="members-info">
							<h4>Mitchell Anderson</h4>
							<h6>Creative Director</h6>
						</div>
					</div>
                </div>
				
				


            </div>
        </div> <!-- /container -->       
    </section>


    <!-- Sections -->
    <section id="our-client" class="sections different-bg">
        <div class="container text-center">

            <!-- Example row of columns -->
            <div class="row">
                <div class="col-md-8 col-md-offset-2 col-sm-12 col-xs-12">


                    <div id="carousel-example-generic" class="carousel slide" data-ride="carousel" data-interval="3000">
                        

                        <!-- Wrapper for slides -->
                        <div class="carousel-inner" role="listbox">

                            <div class="item active">
                                <div class="client-content">
                                    <h3>What Our Clients are saying</h3>
                                    <p>
                                        “It was a pleasure to work with Imran. He is very dedicated and professional. 
                                        He worked very hard to satisfy our requirements and the communication was great.”
                                    </p>

                                    <div class="client-basicinfo">
                                        <h6>John Doe</h6>
                                        <a href="#">www.yourwebsite.zt</a>
                                    </div>

                                </div>
                            </div>
							
							<div class="item">
                                <div class="client-content">
                                    <h3>What Our Clients are saying</h3>
                                    <p>
                                        “It was a pleasure to work with Imran. He is very dedicated and professional. 
                                        He worked very hard to satisfy our requirements and the communication was great.”
										
                                    </p>

                                    <div class="client-basicinfo">
                                        <h6>John Doe</h6>
                                        <a href="#">www.yourwebsite.zt</a>
                                    </div>

                                </div>
                            </div>
							
							<div class="item">
                                <div class="client-content">
                                    <h3>What Our Clients are saying</h3>
                                    <p>
                                        “It was a pleasure to work with Imran. He is very dedicated and professional. 
                                        He worked very hard to satisfy our requirements and the communication was great.”
                                    </p>

                                    <div class="client-basicinfo">
                                        <h6>John Doe</h6>
                                        <a href="#">www.yourwebsite.zt</a>
                                    </div>

                                </div>
                            </div>

                            

                        </div>
						
						<!-- Indicators -->
                        <ol class="carousel-indicators">
                            <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
                            <li data-target="#carousel-example-generic" data-slide-to="1"></li>
                            <li data-target="#carousel-example-generic" data-slide-to="2"></li>
                        </ol>

                    </div>



                </div>

            </div>
        </div> <!-- /container -->       
    </section>

    <section id="blog" class="sections">

        <div class="heading-content text-center">
                <div class="heading-title">
                    <h3>Our Blog</h3>
					<div class="separator"></div>
                </div>

                <div class="heading-separator"></div>

                <div class="heading-details">
                    <p>Nam liber tempor cum soluta nobis eleifend option congue nihil imperdiet doming id quod mazim </p>
                </div>
        </div>


		<div id="cd-timeline" class="cd-container">

            <div class="cd-timeline-block">
                <div class="cd-timeline-img cd-location">
                </div> <!-- cd-timeline-img -->

                <div class="cd-timeline-content">
					<p>10 January, 2016</p>
                    <h2>Typi non habent claritatem insitam</h2>
                    <p>Duis autem vel eum iriure dolor in hendrerit in vulputate velit esse molestie consequat, vel illum dolore eu feugiat nulla facilisis at vero eros et accumsan et iusto odio dignissim qui</p>
                    <a href="#0" class="cd-read-more">Read more</a>
                    <span class="cd-date"><img src="/resources/assets/images/timeline/timeline.png" alt="timeline" /></span>
                </div> <!-- cd-timeline-content -->
            </div> <!-- cd-timeline-block -->

            <div class="cd-timeline-block">
                <div class="cd-timeline-img cd-location">
                </div> <!-- cd-timeline-img -->

                <div class="cd-timeline-content">
					<p>10 January, 2016</p>
                    <h2>Typi non habent claritatem insitam</h2>
                    <p>Duis autem vel eum iriure dolor in hendrerit in vulputate velit esse molestie consequat, vel illum dolore eu feugiat nulla facilisis at vero eros et accumsan et iusto odio dignissim qui</p>
                    <a href="#0" class="cd-read-more">Read more</a>
                    <span class="cd-date"><img src="/resources/assets/images/timeline/timeline.png" alt="timeline" /></span>
                </div> <!-- cd-timeline-content -->
            </div> <!-- cd-timeline-block -->
			
			<div class="cd-timeline-block">
                <div class="cd-timeline-img cd-location">
                </div> <!-- cd-timeline-img -->

                <div class="cd-timeline-content">
                    <p>10 January, 2016</p>
                    <h2>Typi non habent claritatem insitam</h2>
                    <p>Duis autem vel eum iriure dolor in hendrerit in vulputate velit esse molestie consequat, vel illum dolore eu feugiat nulla facilisis at vero eros et accumsan et iusto odio dignissim qui</p>
                    <a href="#0" class="cd-read-more">Read more</a>
                    <span class="cd-date"><img src="/resources/assets/images/timeline/timeline.png" alt="timeline" /></span>
                </div> <!-- cd-timeline-content -->
            </div> <!-- cd-timeline-block -->

           
        </div> <!-- cd-timeline -->

    </section>

    <section id="contact" class="sections lightbg">
        <div class="container">

            <div class="heading-content text-center">
                <div class="heading-title">
                    <h3>Contact</h3>
                </div>

            </div>

            <div class="row">
                <div class="col-md-8 col-md-offset-2 col-sm-12 col-xs-12">

                    <form>
                        <div class="col-md-6 col-sm-12 col-xs-12">
                            <div class="form-group">
                                <input type="text" class="form-control" id="exampleInputEmail1" placeholder="Name*">
                            </div>
                        </div>

                        <div class="col-md-6 col-sm-12 col-xs-12">
                            <div class="form-group">
                                <input type="email" class="form-control" id="exampleInputEmail1" placeholder="Email*">
                            </div>
                        </div>

                        <div class="col-md-12 col-sm-12 col-xs-12">
                            <div class="form-group">
                                <textarea class="form-control txt-area" rows="5" placeholder="Message . . ."></textarea>
                            </div>
                        </div>

                        <div class="submit-btn"><button type="submit" class="btn btn-default abt-btn">Submit Query</button></div>
                    </form>

                </div>
            </div>
        </div>
    </section>


    <!--Footer-->
    <footer id="footer" class="sections footer different-bg">

        <div class="container">
            <div class="row">
                <div class="col-md-3 col-sm-6 col-xs-12">
                    <div class="footer-first-content">
                        <div class="logo"><img src="/resources/assets/images/footer-logo.png" alt="Company Logo" /></div>
                        <p>Duis autem vel eum iriure dolor in hendrerit in vulputate velit esse molestie consequat, vel illum dolore.</p>
                        <p>eugiat nulla facilisis at vero eros et accumsan et iusto odio dignissim qui blandit praesent luptatum zzril delenit augue duis dolore te feugait nulla facilisi. Nam liber tempor cum soluta</p>
                    </div>
                </div>

                <div class="col-md-3 col-sm-6 col-xs-12">
                    <div class="footer-mid-content">
                        <h4>Recent Posts</h4>

                        <div class="post">
							<div class="post-item">
								<h6>March 30, 2014</h6>
								<a href="#">Duis autem vel eum iriure dolor</a>
							</div>
                        </div>

                        <div class="post">
							<div class="post-item">
								<h6>March 30, 2014</h6>
								<a href="#">Duis autem vel eum iriure dolor</a>
							</div>
                        </div>

                        <div class="post">
							<div class="post-item">
								<h6>March 30, 2014</h6>
								<a href="#">Duis autem vel eum iriure dolor</a>
							</div>
                        </div>

                    </div>
                </div>

                <div class="col-md-3 col-sm-6 col-xs-12">
                    <div class="footer-mid-content">
                        <h4>Twitter Feeds</h4>

                        <div class="post">
							<div class="post-item">
								<h6>March 30, 2014</h6>
								<a href="#">Good work buddy</a>
							</div>
                        </div>

                        <div class="post">
							<div class="post-item">
								<h6>March 30, 2014</h6>
								<a href="#">Good work buddy</a>
							</div>
                        </div>

                        <div class="post">
							<div class="post-item">
								<h6>March 30, 2014</h6>
								<a href="#">Good work buddy</a>
							</div>
                        </div>

                    </div>
                </div>

                <div class="col-md-3 col-sm-6 col-xs-12">
                    <div class="footer-last-content">
                        <h4>Our Address</h4>
                        <p>Investigationes demonstraverunt lectores legere me lius quod ii legunt saepius. Claritas est etiam processus dynamicus,luptatum zzril delenit augue duis dolore te feugait nulla facilisi. Nam liber tempor cum soluta </p>

                        <div class="contact-info">
                            <p><i class="fa fa-map-marker"></i>Moonshine St. 14/05 Light</p>
                            <p><i class="fa fa-phone"></i>+00 (123) 456 78 90</p>
                            <p><i class="fa fa-envelope"></i>first.last@email.com</p>
                        </div>

                    </div>
                </div>

            </div>
			
		

        </div>

    </footer>
	
	<div class="scroll-top">
		
		<div class="scrollup">
			<i class="fa fa-angle-double-up"></i>
		</div>
			
	</div>
	
<!-- 	<footer class="copyright-footer"> -->
<!-- 		<div class="container"> -->
<!-- 			<div class="row"> -->
<!-- 				<div class="col-md-12"> -->
<!-- 					<div class="copyright text-center"> -->
<!-- 						<p>Made with <i class="fa fa-heart"></i> by <a target="_blank" href="http://bootstrapthemes.co"> Bootstrap Themes </a>2016. All rights reserved.</p> -->
<!-- 					</div> -->
<!-- 				</div> -->
<!-- 			</div> -->
<!-- 		</div>		 -->
<!-- 	</footer> -->
    

    <script src='<c:url value="/resources/js/jqueryHeader.js" />'></script>
    <script src='<c:url value="/resources/assets/js/vendor/jquery-1.11.2.min.js" />'></script>
    <script src='<c:url value="/resources/assets/js/vendor/bootstrap.min.js" />'></script>
    <script src='<c:url value="/resources/assets/js/jquery.easypiechart.min.js" />'></script>
    <script src='<c:url value="/resources/assets/js/plugins.js" />'></script>
    <script src='<c:url value="/resources/assets/js/modernizr.js" />'></script>
    <script src='<c:url value="/resources/assets/js/main.js" />'></script>
   
           <script type="text/javascript">
            // Check login
            var notEmptyUser = ${not empty pageContext.request.userPrincipal};

            // Load administrator category

            var roleAdmin = ${roleAdmin};
            var roleAdminDP = ${roleAdminDP};
            var roleAdminDPPlus = ${roleAdminDPPlus};
            var roleAdminSR = ${roleAdminSR};

            // Load operetor category
            var roleOper = ${roleOper};
            var roleOperDP = ${roleOperDP};
            var roleOperDPPlus = ${roleOperDPPlus};
            var roleOperSR = ${roleOperSR};

            // Load user category
            var roleUser = ${roleUser};
            var roleUserDP = ${roleUserDP};
            var roleUserDPPlus = ${roleUserDPPlus};
            var roleUserSR = ${roleUserSR};
        </script>


</body>
<jsp:include page="footer.jsp" />
</html>
