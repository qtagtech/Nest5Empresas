<!DOCTYPE html>
<html>
<head>
    <title>Nest5 - Empresas</title>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0">

    <link href="${resource(dir: 'dashboard/css/bootstrap', file: 'bootstrap.min.css')}" rel="stylesheet">
    <link href="${resource(dir: 'dashboard/css/bootstrap', file: 'bootstrap_custom.css')}" rel="stylesheet">
    <link href="${resource(dir: 'hover-effects', file: 'style_common.css')}" rel="stylesheet">
    <r:require module="jquerybrowserfix"/>
    <link rel="stylesheet" href="${resource(dir: 'sky_forms/css', file: 'sky-forms.css')}">
    <!--[if lt IE 9]>
			<link rel="stylesheet" href="${resource(dir: 'sky_forms/css', file: 'sky-forms-ie8.css')}">
		<![endif]-->

    <!--[if lt IE 10]>

			<script src="${resource(dir: 'sky_forms/js', file: 'jquery.placeholder.min.js')}"></script>
		<![endif]-->
    <!--[if lt IE 9]>
			<script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
			<script src="${resource(dir: 'sky_forms/js', file: 'sky-forms-ie8.js')}"></script>
			<r:layoutResources/>

		<![endif]-->
    %{--<link rel="stylesheet" href="${resource(dir: 'sky_forms/css', file: 'sky-forms-orange.css')}">--}%
</head>
<body>
<div class="body body-s">
   <div class="container-fluid">
       <div class="row-fluid">
           <div class="col-md-8 col-md-offset-2">
               <div class="span4 offset4" >
                   <form action='${postUrl}' method='POST' id='loginForm' class="sky-form">
                       <header>Inicia Sesión en tu Cuenta</header>

                       <fieldset>
                           <section>
                               <div class="row">
                                   <label class="label col col-4">Usuario</label>
                                   <div class="col col-8">
                                       <label class="input">
                                           <i class="icon-append icon-user login"></i>
                                           <input type="text" name="j_username" id="username">
                                       </label>
                                   </div>
                               </div>
                           </section>

                           <section>
                               <div class="row">
                                   <label class="label col col-4">Contraseña</label>
                                   <div class="col col-8">
                                       <label class="input">
                                           <i class="icon-append icon-lock login"></i>
                                           <input type="password" name="j_password" id="password">
                                       </label>
                                       <div class="note"><a href="#">¿Olvidaste tu Contraseña?</a></div>
                                   </div>
                               </div>
                           </section>

                           %{--<section>
                               <div class="row">
                                   <div class="col col-4"></div>
                                   <div class="col col-8">
                                       <label class="checkbox"><input type="checkbox"  name="checkbox-inline" checked><i></i>Mantenerme conectado</label>
                                   </div>
                               </div>
                           </section>--}%
                       </fieldset>
                       <footer>
                           <button type="submit" class="loginButton button" style="font-size: 1.5em;">¡Conéctate!</button>
                           %{--<a href="#" class="button button-secondary">Register</a>--}%
                       </footer>
                   </form>
               </div>
               <g:if test='${flash.message}'>
                   <div class="span4 offset4">
                       <h3 style="color: red;">${flash.message}</h3>
                   </div>

               </g:if>
           </div>

       </div>


   </div>
   </div>

</body>
</html>