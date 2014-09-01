<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
    <meta name="layout" content="dashboardLayout"/>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>Nest5 Admin</title>
    <meta name="author" content="Nest5.com" />
    <meta name="description" content="" />
    <meta name="keywords" content="" />
    <meta name="application-name" content="Nest5" />

    <!-- Mobile Specific Metas -->
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <!-- Force IE9 to render in normal mode -->
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />


        <r:require modules="dashboard,uniform"/>
    </head>
      
    <body>


        <!--Body content-->
        <div id="content" class="clearfix">
            <div class="contentwrapper"><!--Content wrapper-->

                <div class="heading">

                    <h3>Dashboard</h3>                    

                    <div class="resBtnSearch">
                        <a href="#"><span class="icon16 icomoon-icon-search-3"></span></a>
                    </div>

                    <div class="search">

                        <form id="searchform" action="search.html">
                            <input type="text" id="tipue_search_input" class="top-search" placeholder="Search here ..." />
                            <input type="submit" id="tipue_search_button" class="search-btn" value=""/>
                        </form>
                
                    </div><!-- End search -->
                    
                    <ul class="breadcrumb">
                        <li>Te encuentras en:</li>
                        <li>
                            <a href="#" class="tip" title="back to dashboard">
                                <span class="icon16 icomoon-icon-screen-2"></span>
                            </a> 
                            <span class="divider">
                                <span class="icon16 icomoon-icon-arrow-right-3"></span>
                            </span>
                        </li>
                        <li class="active">${youarehere}</li>
                    </ul>

                </div><!-- End .heading-->
                <div id="mainDashboard" >
                <!-- Build page from here: -->
                    <div class="row">

                        <div class="col-lg-5">
                            <div class="reminder">
                                <h4>Editar Vededores</h4>
                                <ul>
                                    <li class="clearfix">
                                        <div class="icon">
                                            <span class="icon32 icomoon-icon-user-4 red"></span>
                                        </div>
                                        <span class="number"></span>
                                        <span class="txt">Julanito Perez Correa</span>
                                        <a class="btn btn-danger delete_seller">Eliminar</a>
                                        <a class="btn btn-info">Editar</a>
                                    </li>
                                    <li class="clearfix">
                                        <div class="icon">
                                            <span class="icon32 icomoon-icon-user-4 red"></span>
                                        </div>
                                        <span class="number"></span>
                                        <span class="txt">Julanito Perez Correa</span>
                                        <a class="btn btn-danger delete_seller">Eliminar</a>
                                        <a class="btn btn-info">Editar</a>
                                    </li>
                                    <li class="clearfix">
                                        <div class="icon">
                                            <span class="icon32 icomoon-icon-user-4 red"></span>
                                        </div>
                                        <span class="number"></span>
                                        <span class="txt">Julanito Perez Correa</span>
                                        <a class="btn btn-danger delete_seller">Eliminar</a>
                                        <a class="btn btn-info">Editar</a>
                                    </li>
                                </ul>
                            </div><!-- End .reminder -->
                        </div>
                        <div class="col-lg-7">
                            <div class="panel panel-default">
                                <div class="panel-heading">
                                    <h4>
                                        <span>Agregar Vendedor</span>
                                    </h4>
                                </div>
                                <div class="panel-body">
                                    <form class="form-horizontal" id="create_seller" role="form" action="${createLink(controller: 'seller', action: 'saveFromCompany')}" method="post">
                                        <g:if test="${flash.message}">
                                            <div class="message" style="display: block">${flash.message}</div>
                                        </g:if>
                                        <div class="form-group">
                                        <label class="col-lg-3 control-label" for="normalInput">Nombre Completo</label>
                                        <div class="col-lg-9">
                                            <input type="text" class="form-control" name="name">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-lg-3 control-label" for="normalInput">Cédula</label>
                                        <div class="col-lg-9">
                                            <input type="text" class="form-control" name="identification">
                                        </div>
                                    </div><!-- End .form-group  -->
                                    <div class="form-group">
                                        <label class="col-lg-3 control-label" for="normalInput">Username</label>
                                        <div class="col-lg-9">
                                            <input type="text" class="form-control" name="username">
                                        </div>
                                    </div><!-- End .form-group  -->
                                    <div class="form-group">
                                        <label class="col-lg-3 control-label" for="password">Password</label>
                                        <div class="col-lg-9">
                                            <input type="password" class="form-control" name="password">
                                        </div>
                                    </div><!-- End .form-group  -->
                                    <div class="form-group">
                                        <label class="col-lg-3 control-label" for="password">Telefóno</label>
                                        <div class="col-lg-9">
                                            <input type="text" class="form-control" name="telephone">
                                        </div>
                                    </div><!-- End .form-group  -->
                                    <div class="form-group">
                                        <label class="col-lg-3 control-label" for="password">Email</label>
                                        <div class="col-lg-9">
                                            <input type="email" class="form-control" name="email">
                                        </div>
                                    </div><!-- End .form-group  -->
                                    <div class="form-group">
                                         <div class="col-lg-9 btn_seller">
                                             <button type="submit" id="save_seller" class="btn btn-info">Guardar Vendedor</button>
                                         </div>
                                    </div>
                                </form>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div><!-- End contentwrapper -->
        </div><!-- End #content -->
    <r:script>
        /*$('#save_seller').on('click',function(){
            $.ajax({
                url: '${createLink(controller: 'seller', action: 'saveFromCompany')}',
                type: "POST",
                data: $( "#create_seller" ).serialize(),
                success: function(data, textStatus, jqXHR){
                    console.log(data);
                }
            });
        });
    </r:script>



    </body>
</html>
