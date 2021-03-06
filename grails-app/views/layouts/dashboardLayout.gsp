<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta name="layout" content=""/>
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
    <!-- Headings -->
    <link href='http://fonts.googleapis.com/css?family=Open+Sans:400,700' rel='stylesheet' type='text/css' />
    <!-- Text -->
    <link href='http://fonts.googleapis.com/css?family=Droid+Sans:400,700' rel='stylesheet' type='text/css' />
    <!--[if lt IE 9]>
    <link href="http://fonts.googleapis.com/css?family=Open+Sans:400" rel="stylesheet" type="text/css" />
    <link href="http://fonts.googleapis.com/css?family=Open+Sans:700" rel="stylesheet" type="text/css" />
    <link href="http://fonts.googleapis.com/css?family=Droid+Sans:400" rel="stylesheet" type="text/css" />
    <link href="http://fonts.googleapis.com/css?family=Droid+Sans:700" rel="stylesheet" type="text/css" />
    <![endif]-->

    <!-- Core stylesheets do not remove -->
    <link id="bootstrap" href="${resource(dir:'dashboard/css/bootstrap',file: 'bootstrap.css')}" rel="stylesheet" type="text/css" />
    <link href="${resource(dir:'dashboard/css/bootstrap',file: 'bootstrap-theme.css')}" rel="stylesheet" type="text/css" />
    <link href="${resource(dir:'dashboard/css/supr-theme',file: 'jquery.ui.supr.css')}" rel="stylesheet" type="text/css"/>
    <link href="${resource(dir:'dashboard/css',file: 'icons.css')}" rel="stylesheet" type="text/css" />

    <!-- Plugins stylesheets -->
    <link href="${resource(dir:'dashboard/plugins/misc/qtip',file: 'jquery.qtip.css')}" rel="stylesheet" type="text/css" />
    <link href="${resource(dir:'dashboard/plugins/misc/fullcalendar',file: 'fullcalendar.css')}" rel="stylesheet" type="text/css" />
    <link href="${resource(dir:'dashboard/plugins/misc/search',file: 'tipuesearch.css')}" type="text/css" rel="stylesheet" />
    <link href="${resource(dir:'dashboard/plugins/misc/pnotify',file: 'jquery.pnotify.default.css')}" type="text/css" rel="stylesheet" />
    <r:layoutResources/>
    <!-- Main stylesheets -->
    <link href="${resource(dir:'dashboard/css',file: 'main.css')}" rel="stylesheet" type="text/css" />

    <!-- Custom stylesheets ( Put your own changes here ) -->
    <link href="${resource(dir:'dashboard/css',file: 'custom.css')}" rel="stylesheet" type="text/css" />


    <!--[if IE 8]><link href="${resource(dir:'dashboard/css',file: 'ie8.css')}" rel="stylesheet" type="text/css" /><![endif]-->

    <!-- Le HTML5 shim, for IE6-8 support of HTML5 elements -->
    <!--[if lt IE 9]>
      <script type="text/javascript" src="${resource(dir:'dashboard/libs',file: 'excanvas.min.js')}"></script>
      <script type="text/javascript" src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
      <script type="text/javascript" src="${resource(dir:'dashboard/libs',file: 'respond.min.js')}"></script>
    <![endif]-->

    <!-- Le fav and touch icons -->
    <link rel="shortcut icon" href="${resource(dir:'images',file: 'favicon.ico')}" />
    %{--<link rel="apple-touch-icon-precomposed" sizes="144x144" href="images/apple-touch-icon-144-precomposed.png" />--}%
    %{--<link rel="apple-touch-icon-precomposed" sizes="114x114" href="images/apple-touch-icon-114-precomposed.png" />--}%
    %{--<link rel="apple-touch-icon-precomposed" sizes="72x72" href="images/apple-touch-icon-72-precomposed.png" />--}%
    %{--<link rel="apple-touch-icon-precomposed" href="images/apple-touch-icon-57-precomposed.png" />--}%

    <!-- Windows8 touch icon ( http://www.buildmypinnedsite.com/ )-->
    <meta name="application-name" content="Nest5"/>
    <meta name="msapplication-TileColor" content="#3399cc"/>

    <!-- Load modernizr first -->
    <script type="text/javascript" src="${resource(dir:'dashboard/libs',file: 'modernizr.js')}"></script>
    <g:layoutHead/>
</head>
	<body>
    <!-- loading animation -->
    <div id="qLoverlay"></div>
    <div id="qLbar"></div>

    <div id="header">
        <nav class="navbar navbar-default" role="navigation">
            <div class="navbar-header">
                <a class="navbar-brand" href="${createLink(controller: 'company', action:'panel')}">Nest5<span class="slogan">.dashboard</span></a>
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse">
                    <span class="sr-only">Mostrar/Esconder Men&uacute;</span>
                    <span class="icon16 icomoon-icon-arrow-4"></span>
                </button>
            </div>
            <div class="collapse navbar-collapse navbar-ex1-collapse">
                <ul class="nav navbar-nav">
                    <li class="active">
                        <a href="${createLink(controller: 'company', action:'panel')}"><span class="icon16 icomoon-icon-screen-2"></span> <span class="txt">Dashboard</span></a>
                    </li>
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                            <span class="icon16 icomoon-icon-cog"></span><span class="txt"> Configuraci&oacute;n</span>
                            <b class="caret"></b>
                        </a>
                       %{-- <ul class="dropdown-menu">
                            <li class="menu">
                                <ul>
                                    <li><a href="#"><span class="icon16 icomoon-icon-equalizer"></span>Site config</a></li>
                                    <li><a href="#"><span class="icon16 icomoon-icon-wrench"></span>Plugins</a></li>
                                    <li><a href="#"><span class="icon16 icomoon-icon-image-2"></span>Themes</a></li>
                                </ul>
                            </li>
                        </ul>--}%
                    </li>
                    %{--<li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                            <span class="icon16 icomoon-icon-envelop"></span><span class="txt">Mensajes</span><span class="notification"></span>
                        </a>
                        <ul class="dropdown-menu">
                            <li class="menu">
                                <ul class="messages">
                                    <li class="header"><strong>Messages</strong> (10) emails and (2) PM</li>
                                    <li>
                                        <span class="icon"><span class="icon16 icomoon-icon-user-plus"></span></span>
                                        <span class="name"><a data-toggle="modal" href="#myModal1"><strong>Sammy Morerira</strong></a><span class="time">35 min ago</span></span>
                                        <span class="msg">I have question about new function ...</span>
                                    </li>
                                    <li>
                                        <span class="icon avatar"><img src="${resource(dir:'dashboard/images',file: 'avatar.jpg')}" alt="" /></span>
                                        <span class="name"><a data-toggle="modal" href="#myModal1"><strong>George Michael</strong></a><span class="time">1 hour ago</span></span>
                                        <span class="msg">I need to meet you urgent please call me ...</span>
                                    </li>
                                    <li>
                                        <span class="icon"><span class="icon16 icomoon-icon-envelop"></span></span>
                                        <span class="name"><a data-toggle="modal" href="#myModal1"><strong>Ivanovich</strong></a><span class="time">1 day ago</span></span>
                                        <span class="msg">I send you my suggestion, please look and ...</span>
                                    </li>
                                    <li class="view-all"><a href="#">View all messages <span class="icon16 icomoon-icon-arrow-right-8"></span></a></li>
                                </ul>
                            </li>
                        </ul>
                    </li>--}%
                </ul>

                <ul class="nav navbar-right usernav">
                    %{--<li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                            <span class="icon16 icomoon-icon-bell"></span><span class="notification"></span>
                        </a>
                        <ul class="dropdown-menu">
                            <li class="menu">
                                <ul class="notif">
                                    <li class="header"><strong>Notificaciones</strong> (3) items</li>
                                    <li>
                                        <a href="#">
                                            <span class="icon"><span class="icon16 icomoon-icon-user-plus"></span></span>
                                            <span class="event">1 User is registred</span>
                                        </a>
                                    </li>
                                    <li>
                                        <a href="#">
                                            <span class="icon"><span class="icon16 icomoon-icon-bubble-3"></span></span>
                                            <span class="event">Jony add 1 comment</span>
                                        </a>
                                    </li>
                                    <li>
                                        <a href="#">
                                            <span class="icon"><span class="icon16 icomoon-icon-new"></span></span>
                                            <span class="event">admin Julia added post with a long description</span>
                                        </a>
                                    </li>
                                    <li class="view-all"><a href="#">Ver todas las notificaciones <span class="icon16 icomoon-icon-arrow-right-8"></span></a></li>
                                </ul>
                            </li>
                        </ul>
                    </li>--}%
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle avatar" data-toggle="dropdown">
                            <img src="${picture}" alt="" class="image" />
                            <span class="txt">${user?.email}</span>
                            <b class="caret"></b>
                        </a>
                        <ul class="dropdown-menu">
                            <li class="menu">
                                <ul>
                                    <li><a href="${createLink(controller: 'company', action:'createSeller')}"><span class="icon16 icomoon-icon-user-4"></span>Agregar / Editar Vendedor</a></li>
                                    <li><a href="#" class="avatar_change"><span class="icon16 icomoon-icon-image-4"></span>Editar Imagen</a></li>
                                    <li><a href="#"><span class="icon16 icomoon-icon-user-plus"></span>Editar Perfil</a></li>
                                    %{--<li><a href="#"><span class="icon16 icomoon-icon-plus"></span>Add user</a></li>--}%
                                </ul>
                            </li>
                        </ul>
                    </li>
                    <li><a href="${createLink(controller: 'logout',action: 'index')}"><span class="icon16 icomoon-icon-exit"></span><span class="txt"> Logout</span></a></li>
                </ul>
            </div><!-- /.nav-collapse -->
        </nav><!-- /navbar -->

    </div><!-- End #header -->

    <div id="wrapper">

    <!--Responsive navigation button-->
    <div class="resBtn">
        <a href="#"><span class="icon16 minia-icon-list-3"></span></a>
    </div>

    <!--Left Sidebar collapse button-->
    <div class="collapseBtn leftbar">
        <a href="#" class="tipR" title="Hide Left Sidebar"><span class="icon12 minia-icon-layout"></span></a>
    </div>

    <!--Sidebar background-->
    <div id="sidebarbg"></div>
    <!--Sidebar content-->
    <div id="sidebar">

        <div class="shortcuts">
            <ul>
                <li><a href="http://soporte.nest5.com" target="_blank" title="Soporte Nest5" class="tip"><span class="icon24 icomoon-icon-support"></span></a></li>
                %{--<li><a href="#" title="Exportar Base de Datos" class="tip"><span class="icon24 icomoon-icon-database"></span></a></li>--}%
                <li><a href="#" title="Estad&iacute;sticas" class="tip"><span class="icon24 icomoon-icon-pie-2"></span></a></li>
                <li class="dropdown"><a href="#" title="Agregar Elemento" class="tip"><span class="icon24 icomoon-icon-pencil"></span></a></li>
            </ul>
        </div><!-- End search -->

        <div class="sidenav">

            <div class="sidebar-widget" style="margin: -1px 0 0 0;">
                <h5 class="title" style="margin-bottom:0">Men&uacute; Nest5</h5>
            </div><!-- End .sidenav-widget -->

            <div class="mainnav">
                <ul>
                    <li><a href="${createLink(controller: 'company',action: 'dashboard')}"><span class="icon16 icomoon-icon-stats-up"></span>Panel Principal</a></li>
                    <li><a href="#"><span class="icon16 icomoon-icon-file"></span>Categor&iacute;as</a>
                        <ul class="sub">
                            <li><a href="#"><span class="icon16  brocco-icon-basket"></span>Ingredientes</a>
                                <ul class="sub">
                                    <li><a href="${createLink(controller: 'company',action:'addIngredientCategory')}"><span class="icon16 icomoon-icon-plus-circle"></span>Agregar Nueva</a></li>
                                    <li><a href="${createLink(controller: 'company',action:'ingredientCategories')}"><span class="icon16 icomoon-icon-folder-open"></span>Ver Todas</a></li>
                                </ul>
                            </li>
                            <li><a href="#"><span class="icon16  brocco-icon-coffee"></span>Productos</a>
                                <ul class="sub">
                                    <li><a href="${createLink(controller: 'company',action:'addProductCategory')}"><span class="icon16 icomoon-icon-plus-circle-2"></span>Agregar Nueva</a></li>
                                    <li><a href="${createLink(controller: 'company',action:'productCategories')}"><span class="icon16 icomoon-icon-folder-open"></span>Ver Todas</a></li>
                                </ul>
                            </li>
                        </ul>
                    </li>
                    <li>
                        <a href="#"><span class="icon16  entypo-icon-shopping"></span>Inventario</a>
                        <ul class="sub">
                            <li><a href="#"><span class="icon16  brocco-icon-basket"></span>Ingredientes</a>
                                <ul class="sub">
                                    <li><a href="${createLink(controller: 'company',action:'addIngredient')}"><span class="icon16 icomoon-icon-plus-circle"></span>Agregar Nuevo</a></li>
                                    <li><a href="${createLink(controller: 'company',action:'ingredients')}"><span class="icon16 icomoon-icon-folder-open"></span>Ver Inventario</a></li>
                                </ul>
                            </li>
                            <li><a href="#"><span class="icon16  brocco-icon-coffee"></span>Productos</a>
                                <ul class="sub">
                                    <li><a href="${createLink(controller: 'company',action:'addProduct')}"><span class="icon16 icomoon-icon-plus-circle-2"></span>Agregar Nuevo</a></li>
                                    <li><a href="${createLink(controller: 'company',action:'products')}"><span class="icon16 icomoon-icon-folder-open"></span>Ver Inventario</a></li>
                                </ul>
                            </li>
                            <li><a href="#"><span class="icon16  iconic-icon-layers"></span>Combos</a>
                                <ul class="sub">
                                    <li><a href="${createLink(controller: 'company',action:'addCombo')}"><span class="icon16 icomoon-icon-plus-circle-2"></span>Agregar Nuevo</a></li>
                                    %{--<li><a href=""><span class="icon16 icomoon-icon-folder-open"></span>Ver Inventario</a></li>--}%
                                </ul>
                            </li>
                        </ul>
                    </li>
                    <li>
                        <a href="#"><span class="icon16 icomoon-icon-table-2"></span>Reportes</a>
                        <ul class="sub">
                            <li><a href="${createLink(controller: 'company',action:'report')}"><span class="icon16  icomoon-icon-coin"></span>Cierre Diario</a></li>
                            <li><a href="${createLink(controller: 'company',action:'invoices')}"><span class="icon16  icomoon-icon-coin"></span>Detalle de Ventas</a></li>
                        </ul>
                    </li>
                    <li>
                        <a href="${createLink(controller: 'company',action: 'devices')}"><span class="icon16 brocco-icon-mobile"></span>Dispositivos</a></li>
                    <li>
                        <a href="#"><span class="icon16 icomoon-icon-settings"></span>Configuraciones</a>
                        <ul class="sub">
                            <li><a href="${createLink(controller: 'company',action:'information')}"><span class="icon16  icomoon-icon-profile"></span>Perfil de Empresa</a></li>
                            <li><a href="#"><span class="icon16  icomoon-icon-balance"></span>Unidades</a>
                                <ul class="sub">
                                    <li><a href="${createLink(controller: 'company',action:'addMeasuramentUnit')}"><span class="icon16 icomoon-icon-plus-circle-2"></span>Agregar Nueva</a></li>
                                    <li><a href="#"><span class="icon16 icomoon-icon-folder-open"></span>Ver Todas</a></li>
                                </ul>
                            </li>
                            <li><a href="#"><span class="icon16  icomoon-icon-coin"></span>Impuestos</a>
                                <ul class="sub">
                                    <li><a href="${createLink(controller: 'company',action:'addTax')}"><span class="icon16 icomoon-icon-plus-circle-2"></span>Agregar Nuevo</a></li>
                                    <li><a href="#"><span class="icon16 icomoon-icon-folder-open"></span>Ver Todos</a></li>
                                </ul>
                            </li>
                        </ul>
                    </li>
                </ul>
            </div>
        </div><!-- End sidenav -->

        <div class="sidebar-widget">
            <h5 class="title">Meta de Ventas</h5>
            <div class="content">
                <span class="icon16 icomoon-icon-loop left"></span>
                <div class="progress progress-mini left tip" title="87%">
                    <div class="progress-bar progress-bar-danger" style="width: 87%;"></div>
                </div>
                <span class="percent">87%</span>
                <div class="stat">19419.94 / 12000 MB</div>
            </div>

        </div><!-- End .sidenav-widget -->

        <div class="sidebar-widget">
            <h5 class="title">Meta de Nuevos Clientes</h5>
            <div class="content">
                <span class="icon16  icomoon-icon-storage-2 left"></span>
                <div class="progress progress-mini left tip" title="16%">
                    <div class="progress-bar progress-bar-success" style="width: 16%;"></div>
                </div>
                <span class="percent">16%</span>
                <div class="stat">304.44 / 8000 MB</div>
            </div>

        </div><!-- End .sidenav-widget -->

        <div class="sidebar-widget">
            <h5 class="title">Datos Divertidos</h5>
            <div class="content">

                <div class="stats">
                    <div class="item">
                        <div class="head clearfix">
                            <div class="txt">Clientes Únicos</div>
                        </div>
                        <span class="icon16 icomoon-icon-eye left"></span>
                        <div class="number">21,501</div>
                        <div class="change">
                            <span class="icon24 icomoon-icon-arrow-up-2 green"></span>
                            5%
                        </div>
                        <span id="stat1" class="spark"></span>
                    </div>
                    <div class="item">
                        <div class="head clearfix">
                            <div class="txt">Ventas</div>
                        </div>
                        <span class="icon16 icomoon-icon-thumbs-up left"></span>
                        <div class="number">308</div>
                        <div class="change">
                            <span class="icon24 icomoon-icon-arrow-down-2 red"></span>
                            8%
                        </div>
                        <span id="stat2" class="spark"></span>
                    </div>
                    <div class="item">
                        <div class="head clearfix">
                            <div class="txt">Me Gusta</div>
                        </div>
                        <span class="icon16 icomoon-icon-heart left"></span>
                        <div class="number">4%</div>
                        <div class="change">
                            <span class="icon24 icomoon-icon-arrow-down-2 red"></span>
                            1%
                        </div>
                        <span id="stat3" class="spark"></span>
                    </div>
                    <div class="item">
                        <div class="head clearfix">
                            <div class="txt">Ventas Totales</div>
                        </div>
                        <span class="icon16 icomoon-icon-coin left"></span>
                        <div class="number">$376</div>
                        <div class="change">
                            <span class="icon24 icomoon-icon-arrow-up-2 green"></span>
                            26%
                        </div>
                        <span id="stat4" class="spark"></span>
                    </div>
                </div>

            </div>

        </div><!-- End .sidenav-widget -->

        <div class="sidebar-widget">
            <h5 class="title">Resumen de Inventario</h5>
            <div class="content">
                <div class="rightnow">
                    <ul class="list-unstyled">
                        <li><span class="number">34</span><span class="icon16 icomoon-icon-new"></span>Agotándose</li>
                        <li><span class="number">7</span><span class="icon16 icomoon-icon-file"></span>En Exceso</li>
                        <li><span class="number">14</span><span class="icon16 icomoon-icon-list-2"></span>Ingredientes</li>
                        <li><span class="number">14</span><span class="icon16 icomoon-icon-list-2"></span>Productos</li>
                        <li><span class="number">201</span><span class="icon16 icomoon-icon-tag"></span>Combos</li>
                    </ul>
                </div>
            </div>

        </div><!-- End .sidenav-widget -->

    </div><!-- End #sidebar -->

     <g:layoutBody/>

    </div><!-- End #wrapper -->



    <form name="file_upload_form" id="file_upload_form" action="#" enctype="multipart/form-data" style="position: absolute; top: -500px; left: -500px;">
        <input type="file" id="fileselect" name="fileselect[]" />
        <input type="hidden" name="company" value="${user?.id}" />
        <input type="hidden" name="position" value="" id="positionField" />

    </form>

    <!-- Le javascript
    ================================================== -->
    <!-- Important plugins put in all pages -->
    <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
    <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.10.2/jquery-ui.min.js"></script>
    <script type="text/javascript" src="http://code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
    <script type="text/javascript" src="${resource(dir:'dashboard/bootstrap',file: 'bootstrap.js')}"></script>
    <script type="text/javascript" src="${resource(dir:'dashboard',file: 'jquery.mousewheel.js')}"></script>
    <script type="text/javascript" src="${resource(dir:'dashboard/libs',file: 'jRespond.min.js')}"></script>

    <!-- Charts plugins -->
    <script type="text/javascript" src="${resource(dir:'dashboard/plugins/charts/flot',file: 'jquery.flot.js')}"></script>
    <script type="text/javascript" src="${resource(dir:'dashboard/plugins/charts/flot',file: 'jquery.flot.grow.js')}"></script>
    <script type="text/javascript" src="${resource(dir:'dashboard/plugins/charts/flot',file: 'jquery.flot.pie.js')}"></script>
    <script type="text/javascript" src="${resource(dir:'dashboard/plugins/charts/flot',file: 'jquery.flot.resize.js')}"></script>
    <script type="text/javascript" src="${resource(dir:'dashboard/plugins/charts/flot',file: 'jquery.flot.tooltip_0.4.4.js')}"></script>
    <script type="text/javascript" src="${resource(dir:'dashboard/plugins/charts/flot',file: 'jquery.flot.orderBars.js')}"></script>
    <script type="text/javascript" src="${resource(dir:'dashboard/plugins/charts/sparkline',file:'jquery.sparkline.js')}"></script><!-- Sparkline plugin -->
    <script type="text/javascript" src="${resource(dir: 'dashboard/plugins/charts/knob',file: 'jquery.knob.js')}"></script><!-- Circular sliders and stats -->

    <!-- Misc plugins -->
    <script type="text/javascript" src="${resource(dir: 'dashboard/plugins/misc/nicescroll',file:'jquery.nicescroll.min.js')}"></script>

    <script type="text/javascript" src="${resource(dir:'dashboard/plugins/misc/fullcalendar',file:'fullcalendar.min.js')}"></script><!-- Calendar plugin -->
    <script type="text/javascript" src="${resource(dir:'dashboard/plugins/misc/qtip',file:'jquery.qtip.min.js')}"></script><!-- Custom tooltip plugin -->
    <script type="text/javascript" src="${resource(dir:'dashboard/plugins/misc/totop',file:'jquery.ui.totop.min.js')}"></script> <!-- Back to top plugin -->
    <script type="text/javascript" src="${resource(dir:'dashboard/plugins/misc/pnotify',file:'jquery.pnotify.min.js')}"></script> <!-- Pin Notify Plugin -->

    <!-- Search plugin -->
    <script type="text/javascript" src="${resource(dir:'dashboard/plugins/misc/search',file:'tipuesearch_set.js')}"></script>
    <script type="text/javascript" src="${resource(dir:'dashboard/plugins/misc/search',file:'tipuesearch_data.js')}"></script><!-- JSON for searched results -->
    <script type="text/javascript" src="${resource(dir:'dashboard/plugins/misc/search',file:'tipuesearch.js')}"></script>




    <!-- Form plugins -->
    <r:script>
var loading1;
function loadContent(){

    var html = "<img src='${resource(dir: 'images',file: 'preloader.gif')}' alt='Loading Content' />";
    $("#pageBody").html(html);
}



        $(document).ready(function(){

            $("body").on('click',".avatar_change",function(e){
                  e.preventDefault();
                 $("#fileselect").click();
             });

             $("body").on('click',".delete-item",function(e){
                  e.preventDefault();
                  var r = confirm("¿Estás Seguro de Borrar este Elemento?");
                    if (r == true) {
                         var value = $(this).data("elementid");
                          $.when(saveRowDelete(value))
                            .then(function(response){
                                if(response.status == 1){
                                    window.location.reload();

                                }
                                else{

                                }
                            })
                    .fail(callError);
                    }


             });

            $("#fileselect").change(function(){
//            console.log("aca");
                    var opts = {
                lines: 9, // The number of lines to draw
                length: 0, // The length of each line
                width: 8, // The line thickness
                radius: 4, // The radius of the inner circle
                corners: 1, // Corner roundness (0..1)
                rotate: 90, // The rotation offset
                direction: 1, // 1: clockwise, -1: counterclockwise
                color: '#000', // #rgb or #rrggbb
                speed: 1.6, // Rounds per second
                trail: 45, // Afterglow percentage
                shadow: true, // Whether to render a shadow
                hwaccel: true, // Whether to use hardware acceleration
                className: 'spinner', // The CSS class to assign to the spinner
                zIndex: 2e9, // The z-index (defaults to 2000000000)
                top: 'auto', // Top position relative to parent in px
                left: 'auto' // Left position relative to parent in px
            };

            var target = $("#companyAvatar");
            var spinner1 = new Spinner(opts).spin();
//            $(spinner1.el).css("marginLeft", "50%");
            target.html(spinner1.el);
            loading1 = spinner1;
                uploadFile();
              });
        });


        // file selection
       function uploadFile()
       {
           var formData = new FormData($('#file_upload_form')[0]);
           $.ajax({
               url: '${createLink(controller: 'imageuploader', action: 'companyUploadMain')}', //server script to process data
               type: 'POST',
               xhr: function() {  // custom xhr
                   myXhr = $.ajaxSettings.xhr();
                   if(myXhr.upload){ // check if upload property exists
                       // for handling the progress of the upload
                       myXhr.upload.addEventListener('progress',progressHandlingFunction, false);
                   }
                   return myXhr;
               },
               success: function(result)
               {
                console.log(result);
                   //console.log($.ajaxSettings.xhr().upload);
                   //alert(result);
                   if(result.success)
                   {
                     $("#companyAvatar").html('<img src="'+resulApplicationResources.groovyt.ruta+'" style="max-width: 32px; height: auto;"/>');
                    //alert("Subida con éxito");
                   }


               },
               // Form data
               data: formData,
               //Options to tell JQuery not to process data or worry about content-type
               cache: false,
               contentType: false,
               processData: false
           });


       }
        function progressHandlingFunction(e){
            if(e.lengthComputable){
//            console.log("Porcentaje: "+e.loaded+"/"+e.total);
//                $("#progress").text(e.loaded + " / " e.total);
            var perc = (e.loaded / e.total) * 100;
            }
        }
function saveRowDelete(sync){
            var url = "${createLink(controller: 'company',action: 'saveRow')}";
            var rowid = sync;
            var syncrowid = sync;
            var fields = "{" +
              "\"name\":"+$("[name='name']").val()+
              ",\"category_id\":"+$("#select-category option:selected").val()+
              ",\"cost_per_unit\":"+null+
              ",\"quantity\":"+null+
              ",\"unit_id\":"+null+
              ",\"price_measure\":"+null+
              ",\"price_per_unit\":"+null+
              ",\"tax_id\":"+null+
              "}";

            return  $.ajax({
                type: "POST",
                url: url,
                data:{table:"",row_id:rowid,sync_id:syncrowid,sync_row_id:syncrowid,fields:fields,isdeleting: true},
                dataType: 'json'
            }).promise();
        }

        function callError(response){
            console.log("error ajax");
            console.log(response);
        }

    </r:script>


    <!-- Init plugins -->

        <g:javascript library="underscore"/>
        <g:javascript library="nextindom"/>
        <g:javascript library="plugins"/>
        <g:javascript library="mainscript"/>

    <r:layoutResources />





	</body>
</html>