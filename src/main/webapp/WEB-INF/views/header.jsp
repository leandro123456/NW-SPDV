<%@ page isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>

<!-- <!DOCTYPE html> -->
<!-- <html lang="en"> -->

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>eReach Campaign Service</title>

    <!-- Favicon -->
    <link rel='shortcut icon' href='<c:url value="/resources/images/favicon.ico" />' type="image/x-icon"/>

    <!-- Bootstrap Core CSS -->
    <link href='<c:url value="/resources/css/bootstrap.min.css" />' rel="stylesheet">

    <!-- Custom CSS -->
	<link href='<c:url value="/resources/css/test.css" />' rel="stylesheet">
	
    <!-- Custom Fonts -->
    <link href='<c:url value="/resources/font-awesome/css/font-awesome.min.css" />' rel="stylesheet" type="text/css">

	<!-- Custom jQuery -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="<c:url value="/resources/js/html5shiv.js" />"></script>
        <script src="<c:url value="/resources/js/respond.min.js" />"></script>
    <![endif]-->

</head>

<body>

    <div id="wrapper">

        <!-- Navigation -->
        <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="<c:url value='/home/' />"><img alt="Nticxs" width="50%" src='<c:url value="/resources/images/logo.png" />'></a>
            </div>
            <!-- Top Menu Items -->
            <ul class="nav navbar-right top-nav">
                <li class="dropdown">
                    <c:set var = "roleAndNameComplete" value="${pageContext.request.userPrincipal.authorities}"/>
                    <c:set var = "roleAndNameCompleteSubA" value="${fn:substringAfter(roleAndNameComplete, '[')}"/>
                    <c:set var = "roleAndNameCompleteSubB" value="${fn:substringBefore(roleAndNameCompleteSubA, ']')}"/>
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-user"></i>
                    ${pageContext.request.userPrincipal.name} ROLE: ${roleAndNameCompleteSubB}
                    <b class="caret"></b></a>
                    <ul class="dropdown-menu">
                        <!--<li>
                            <a href="#"><i class="fa fa-fw fa-user"></i> Profile</a>
                        </li>
                        <li class="divider"></li>-->
                        <li>
                            <a href="<c:url value="/logoutsession" />"><i class="fa fa-fw fa-power-off"></i> Log Out</a>
                        </li>
                    </ul>
                </li>
            </ul>
            <!-- Sidebar Menu Items - These collapse to the responsive navigation menu on small screens -->
            <div class="collapse navbar-collapse navbar-ex1-collapse">
                <ul class="nav navbar-nav side-nav">
                    <li id="provisioning">
                        <a href="<c:url value='/home/provisioning' />" data-toggle="tooltip" title="Profile templates and output files upload"><i class="fa fa-fw fa-plus-square-o"></i> Aprovisionamiento</a>
                    </li>

		            <li id="documentExplorer">
		                <a href="<c:url value="/home/" />${materia}/explorer/document"  data-toggle="tooltip" title="Edit template parameters" ><i class="fa fa-fw fa-file-text-o"></i> Documentos</a>
		            </li>

		            <li id="ippGeneration">
		                <a href="<c:url value='/home/ipp/generation' />" title="Generate new IPPs" ><i class="fa fa-fw fa-lightbulb-o"></i> IPP Generation</a>
		            </li>

		            <li id="ippExplorer">
		                <a href="<c:url value='/home/ipp/explorer' />"><i class="fa fa-fw fa-expand" data-toggle="tooltip" title="IPP administration tool"></i> IPP Explorer</a>
		            </li>

                    <li id="amdDP">
                        <a href="<c:url value='/home/amddp' />"><i class="fa fa-fw fa-arrows-alt"  data-toggle="tooltip" title="SM-SRs"></i> AMD DP</a>
                    </li>

		            <li id="generalConfiguration">
		                <a href="<c:url value='/home/general/configuration' />" data-toggle="tooltip" title="General settings"><i class="fa fa-fw fa-cogs"></i> General Configuration</a>
		            </li>
	                	
                    <script src='<c:url value="/resources/js/jqueryHeader.js" />'></script>
                    
                    <c:if test="${not empty pageContext.request.userPrincipal}">
                        <c:if test="${pageContext.request.isUserInRole('SUPERADMIN')}">
                            <li>
                                <a href="<c:url value='/home/send/command' />" data-toggle="tooltip" title="Profile templates and output files upload"><i class="fa fa-fw fa-paper-plane-o"></i> Send Command</a>
                            </li>   
                            <li>
                                <a href="<c:url value='/home/view/instance/logs' />" data-toggle="tooltip" title="Profile templates and output files upload"><i class="fa fa-fw fa-building-o"></i> Set Preset Commands</a>
                            </li>   
                        </c:if>
                    </c:if>
                </ul>
                
            </div>    
            <!-- /.navbar-collapse -->
        </nav>

        <c:set var = "auth" value = "${pageContext.request.userPrincipal.authorities}" />

        <c:set var = "roleAdmin" value = "false"/>
        <c:set var = "roleAdminDP" value = "false"/>
        <c:set var = "roleAdminDPPlus" value = "false"/>
        <c:set var = "roleAdminSR" value = "false"/>

        <c:set var = "roleOper" value = "false"/>
        <c:set var = "roleOperDP" value = "false"/>
        <c:set var = "roleOperDPPlus" value = "false"/>
        <c:set var = "roleOperSR" value = "false"/>

        <c:set var = "roleUser" value = "false"/>
        <c:set var = "roleUserDP" value = "false"/>
        <c:set var = "roleUserDPPlus" value = "false"/>
        <c:set var = "roleUserSR" value = "false"/>

        <!-- Set administrator category -->
        <c:if test = "${auth == '[ADMIN]'}">
            <c:set var = "roleAdmin" value = "true"/>
        </c:if>

        <c:if test = "${auth == '[ADMINDP]'}">
            <c:set var = "roleAdminDP" value = "true"/>
        </c:if>

        <c:if test = "${auth == '[ADMINDP+]'}">
            <c:set var = "roleAdminDPPlus" value = "true"/>
        </c:if>

        <c:if test = "${auth == '[ADMINSR]'}">
            <c:set var = "roleAdminSR" value = "true"/>
        </c:if>


        <!-- Set operetor category -->
        <c:if test = "${auth == '[OPER]'}">
            <c:set var = "roleOper" value = "true"/>
        </c:if>

        <c:if test = "${auth == '[OPERDP]'}">
            <c:set var = "roleOperDP" value = "true"/>
        </c:if>

        <c:if test = "${auth == '[OPERDP+]'}">
            <c:set var = "roleOperDPPlus" value = "true"/>
        </c:if>

        <c:if test = "${auth == '[OPERSR]'}">
            <c:set var = "roleOperSR" value = "true"/>
        </c:if>


        <!-- Set user category -->
        <c:if test = "${auth == '[USER]'}">
            <c:set var = "roleUser" value = "true"/>
        </c:if>

        <c:if test = "${auth == '[USERDP]'}">
            <c:set var = "roleUserDP" value = "true"/>
        </c:if>

        <c:if test = "${auth == '[USERDP+]'}">
            <c:set var = "roleUserDPPlus" value = "true"/>
        </c:if>

        <c:if test = "${auth == '[USERSR]'}">
            <c:set var = "roleUserSR" value = "true"/>
        </c:if>

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

        <div id="page-wrapper">
          <div class="container-fluid">
            <!-- jQuery -->
