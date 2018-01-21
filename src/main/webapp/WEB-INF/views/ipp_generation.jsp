<%@ page isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:include page="header.jsp" />

            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">
                        eReach - IPP Generation
                    </h1>
                </div>
            </div>

            <script src='<c:url value="/resources/js/jqueryIppGeneration.js" />'></script>

            <div class="row" id="divIppGeneration">
                <c:if test="${not empty msg1}">
                    <div class="alert alert-warning">
                        ${msg1}
                    </div>
                </c:if>
                <form role="form" action="<c:url value="/home/ipp/generation" />" method="post" enctype="multipart/form-data">
                    <div class="row">
                        <div class="col-lg-4">
                            <div class="panel panel-default">
                                <div class="panel-heading">
                                    <h3 class="panel-title">Select profile template</h3>
                                </div>
                                <div class="panel-body">
                                    <div class="form-group">
                                        <div>
                                            <select name="listTemplate" class="form-control" required>
                                                <option value="none">Select</option>
                                                <c:forEach items="${templateFound}" var="template">
                                                    <option value="${template.name}">${template.name}</option>
                                                </c:forEach>
                                            </select>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div>
                                            <a href="<c:url value="/home/template/explorer" />" data-toggle="tooltip" title="Profile templates and output files upload"><i class="fa fa-search"></i> Template Explorer</a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-lg-4">
                            <div class="panel panel-default">
                                <div class="panel-heading">
                                    <h3 class="panel-title">Select MNO-Id</h3>
                                </div>
                                <div class="panel-body">
                                    <div class="form-group">
                                        <div >
                                            <select name="listMno" class="form-control" required>
                                                <option value="none">Select</option>
                                                <c:forEach items="${mnoid}" var="mnoid">
                                                    <option value="${mnoid}">${mnoid}</option>
                                                </c:forEach>
                                            </select>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div >
                                            <a href="<c:url value="/home/amddp" />" data-toggle="tooltip" title="Profile templates and output files upload"><i class="fa fa-search"></i> MNO Explorer</a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        
                        <div class="col-lg-4">
                            <div class="panel panel-default">
                                <div class="panel-heading">
                                    <h3 class="panel-title">Asign the following group to the new(s) IPPs</h3>
                                </div>
                                <div class="panel-body">
                                    <div class="form-group">
                                        <div c>
                                             <select name="listGroup" class="form-control">
                                                <option value="none">Select</option>
                                                <c:forEach items="${groupFound}" var="group">
                                                    <option value="${group.name}">${group.name}</option>
                                                </c:forEach>
                                            </select>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div >
                                         <a href="<c:url value="/home/template/explorer" />" data-toggle="tooltip" title="Profile templates and output files upload"><i class="fa fa-search"></i> Group management</a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-lg-12">
                            <div class="panel panel-default">
                            <div class="panel-heading">
                                <h3 class="panel-title">Personalization information</h3>
                            </div>
                                <div class="panel-body">
                                	<div class="form-group">
                                        <label>Description</label>
                                        <input name="description" class="form-control" required>
                                    </div>
                                    <div class="form-group">
                                        <div class="row">
                                            <div class="col-md-2">
                                                <div class="radio">
                                                  <label>
                                                    <input type="radio" name="filter" id="1" value="generate" checked>
                                                    Generate
                                                  </label>
                                                </div>
                                            </div>
                                            <div class="col-md-2">
                                                <input type="number" id="textBox" name="quantity" min="0">
                                            </div>
                                            <div class="col-md-3">
                                                 <center><p>IPPs with random available iccid</p></center>
                                            </div>
                                            <div class="col-md-2">
                                            </div>
                                             <div class="col-md-3">
                                                <label class="checkbox-inline">
                                                <input  name="available" id="checkBox" type="checkbox"  onclick="enableDisable(this.checked, 'textBox')">Use all available iccid
                                            </label>
                                             </div>
                                        </div>
                                        <div class="row">
                                            <p> </p>
                                        </div>
                                        <!--<div class="row">
                                            <div class="col-md-3">
                                                <div class="radio">
                                                  <label>
                                                    <input type="radio" name="filter" id="2" value="generate-for">
                                                    Generate for
                                                  </label>
                                                </div>
                                            </div>
                                            <div class="col-md-2">
                                                <select name="paramGenerateFor" class="form-control">
                                                    <option value="none">Select</option>
                                                    <option value="iccid">ICCID</option>
                                                    <option value="imsi">IMSI</option>
                                                </select>
                                            </div>
                                            <div class="col-md-3">
                                                <input class="form-control" name="searchTextStart" placeholder="8954078144136121321">
                                            </div>
                                             <div class="col-md-1">
                                                <label> to</label>
                                             </div>
                                            <div class="col-md-3">
                                                <input class="form-control" name="searchTextEnd" placeholder="8954078144136121321">
                                            </div>
                                        </div>-->
                                        <div class="row">
                                            <p> </p>
                                        </div>
                                        <fieldset disabled>
                                        <div class="row">
                                            <div class="col-md-4">
                                                <div class="radio">
                                                  <label>
                                                    <input type="radio" name="filter" id="3" value="generate-one">
                                                    Genereate 1 IPP with this particular
                                                  </label>
                                                </div>
                                            </div>
                                            <div class="col-md-2">
                                                <select name="paramGenerateOne" class="form-control">
                                                    <option value="none">Select</option>
                                                    <option value="iccid">ICCID</option>
                                                    <option value="imsi">IMSI</option>
                                                </select>
                                            </div>
                                            <div class="col-md-6">
                                                <input class="form-control" name="searchTextParticular" placeholder="8954078144136121321">
                                            </div>
                                        </div>
                                        </fieldset>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                         <div  class="col-md-10">
                            <p> </p>
                         </div>
                        <div  class="col-md-2">
                          <button type="submit" class="btn-group btn-group-justified" aria-label="...">Generate</button>
                        </div>
                    </row>
                </form>
            </div>
            </div>
                <!-- /.row -->

<jsp:include page="footer.jsp" />
<script type="text/javascript">
    function enableDisable(bEnable, textBoxID)
    {
         document.getElementById(textBoxID).disabled = bEnable;
         document.getElementById(textBoxID).value=0;
    }
</script>
