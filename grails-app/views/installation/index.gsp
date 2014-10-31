<!DOCTYPE html>
<html lang="en" class="no-js">
	<head>
		<meta charset="UTF-8" />
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"> 
		<meta name="viewport" content="width=device-width, initial-scale=1.0"> 
		<title>Bienvenido a La Instalación de Nest5</title>
		<meta name="description" content="Text Opening Sequence with CSS Animations" />
		<meta name="keywords" content="text, opening sequence, opening credits, css animations, typography, lettering.js" />
		<meta name="author" content="Nest5" />
		<link rel="shortcut icon" href="${resource(dir:'images', file: 'favicon.ico')}">
        <link rel="stylesheet" type="text/css" href="${resource(dir:'installation/css', file: 'default.css')}" />
		<link rel="stylesheet" type="text/css" href="${resource(dir:'installation/css', file: 'component.css')}" />
		<script src="${resource(dir:'installation/js', file: 'modernizr.custom.js')}"></script>
	</head>
	<body>
		<div class="container">
            <header>
                <p><button class="btn btn-3 btn-3e icon-arrow-right">¡Empezar Ya!</button></p>
            </header>
            <section>
                <div class="os-phrases" id="os-phrases">
                    <h2>¡HOLA!</h2>
                    <h2>¡Estamos felices de que estés aquí!</h2>
                    <h2>Instalaremos Nest5 en unos minutos</h2>
                    <h2>Y comenzaráras a controlar tu Empresa</h2>
                    <h2>Tus Ventas...</h2>
                    <h2>Tus Clientes...</h2>
                    <h2>y tus Inventarios.</h2>
                    <h2>¡Empecemos!</h2>
                </div>
            </section>



		</div><!-- /container -->
        <script src="${resource(dir:'posfiles/js',file:'jquery-1.9.js')}"></script>
		<script src="${resource(dir:'installation/js',file:'jquery.lettering.js')}"></script>
    <script src="${resource(dir:'installation/js',file:'classie.js')}"></script>
		<script>
			$(document).ready(function() {
				$("#os-phrases > h2").lettering('words').children("span").lettering().children("span").lettering(); 
			})
		</script>
	</body>
</html>