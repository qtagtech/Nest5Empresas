<!DOCTYPE html>
<html lang="en" class="no-js">
<head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Registro de Administrador - Instalación Nest5</title>
    <meta name="description" content="Fullscreen Form Interface: A distraction-free form concept with fancy animations" />
    <meta name="keywords" content="fullscreen form, css animations, distraction-free, web design" />
    <meta name="author" content="Codrops" />
    <link rel="shortcut icon" href="${resource(dir:'images',file: 'favicon.ico')}">
    <link rel="stylesheet" type="text/css" href="${resource(dir:'installation/css',file: 'normalize.css')}" />
    <link rel="stylesheet" type="text/css" href="${resource(dir:'installation/css',file: 'default.css')}" />
    <link rel="stylesheet" type="text/css" href="${resource(dir:'installation/css',file: 'component.css')}" />
    <link rel="stylesheet" type="text/css" href="${resource(dir:'installation/css',file: 'cs-select.css')}" />
    <link rel="stylesheet" type="text/css" href="${resource(dir:'installation/css',file: 'cs-skin-boxes.css')}" />
    <script src="${resource(dir:'installation/js',file: 'modernizr.custom.js')}"></script>
</head>
<body>
<div class="container">
    <div class="fs-form-wrap" id="fs-form-wrap">
        <div class="fs-title">
            <h1><img src="https://s3-us-west-2.amazonaws.com/com.nest5.assets/user-profile/letras_nest5_low.png" alt="Nest5, administra ventas, inventarios y clientes." /> - Registro de Administrador <a class="nest5-icon nest5-icon-info" href="#"><span>El primer paso consiste en registrar al usuario principal, quién controlará todos los aspectos de la empresa o negocio.</span></a></h1>
            <div class="nest5-top">

            </div>
        </div>
        <form id="myform" class="fs-form fs-form-full" autocomplete="off">
            <ol class="fs-fields">
                <li>
                    <label class="fs-field-label fs-anim-upper" for="q1">¿Cuál es tu Nombre Completo?</label>
                    <input class="fs-anim-lower" id="q1" name="q1" type="text" placeholder="Juancho Pérez" required/>
                </li>
                <li>
                    <label class="fs-field-label fs-anim-upper" for="q2" data-info="No enviaremos SPAM ni Basura, lo prometemos...">¿Cuál es tu Correo Electrónico?</label>
                    <input class="fs-anim-lower" id="q2" name="q2" type="email" placeholder="juancho@nest5.com" required/>
                </li>
                <li>
                    <label class="fs-field-label fs-anim-upper" for="q3" data-info="No te llamaremos si no nos das tu permiso, el cual puedes negar desde tu panel de control en cualquier momento...">¿Tienes un Número celular o fijo de Contacto</label>
                    <input class="fs-anim-lower" id="q3" name="q3" type="text" placeholder="3335555555" required/>
                </li>
                <!--<li data-input-trigger>
                    <label class="fs-field-label fs-anim-upper" for="q3" data-info="This will help us know what kind of service you need">What's your priority for your new website?</label>
                    <div class="fs-radio-group fs-radio-custom clearfix fs-anim-lower">
                        <span><input id="q3b" name="q3" type="radio" value="conversion"/><label for="q3b" class="radio-conversion">Sell things</label></span>
                        <span><input id="q3c" name="q3" type="radio" value="social"/><label for="q3c" class="radio-social">Become famous</label></span>
                        <span><input id="q3a" name="q3" type="radio" value="mobile"/><label for="q3a" class="radio-mobile">Mobile market</label></span>
                    </div>
                </li>
                <li data-input-trigger>
                    <label class="fs-field-label fs-anim-upper" data-info="We'll make sure to use it all over">Choose a color for your website.</label>
                    <select class="cs-select cs-skin-boxes fs-anim-lower">
                        <option value="" disabled selected>Pick a color</option>
                        <option value="#588c75" data-class="color-588c75">#588c75</option>
                        <option value="#b0c47f" data-class="color-b0c47f">#b0c47f</option>
                        <option value="#f3e395" data-class="color-f3e395">#f3e395</option>
                        <option value="#f3ae73" data-class="color-f3ae73">#f3ae73</option>
                        <option value="#da645a" data-class="color-da645a">#da645a</option>
                        <option value="#79a38f" data-class="color-79a38f">#79a38f</option>
                        <option value="#c1d099" data-class="color-c1d099">#c1d099</option>
                        <option value="#f5eaaa" data-class="color-f5eaaa">#f5eaaa</option>
                        <option value="#f5be8f" data-class="color-f5be8f">#f5be8f</option>
                        <option value="#e1837b" data-class="color-e1837b">#e1837b</option>
                        <option value="#9bbaab" data-class="color-9bbaab">#9bbaab</option>
                        <option value="#d1dcb2" data-class="color-d1dcb2">#d1dcb2</option>
                        <option value="#f9eec0" data-class="color-f9eec0">#f9eec0</option>
                        <option value="#f7cda9" data-class="color-f7cda9">#f7cda9</option>
                        <option value="#e8a19b" data-class="color-e8a19b">#e8a19b</option>
                        <option value="#bdd1c8" data-class="color-bdd1c8">#bdd1c8</option>
                        <option value="#e1e7cd" data-class="color-e1e7cd">#e1e7cd</option>
                        <option value="#faf4d4" data-class="color-faf4d4">#faf4d4</option>
                        <option value="#fbdfc9" data-class="color-fbdfc9">#fbdfc9</option>
                        <option value="#f1c1bd" data-class="color-f1c1bd">#f1c1bd</option>
                    </select>
                </li>-->
                <li>
                    <label class="fs-field-label fs-anim-upper" for="q4" data-info="Para encontrar tu número de serie, busca un Sticker en la caja que te llegó tu kit Nest5. Si no lo encuentras, escribe a soporte@nest5.com con tu nombre y empresa y te lo enviarán para continuar con el registro.">Ingresa el número de serie de tu paquete Nest5</label>
                <input class="fs-anim-lower" type="pid"  id="q4" maxlength="23" name="q4" pattern="^\w{5}\-\w{5}\-\w{5}\-\w{5}$" required placeholder="123AB-BCXH3-778F2-90763" size="35"/>
                </li>
            </ol><!-- /fs-fields -->
            <button class="fs-submit" type="submit">¡Ir a Paso 2!</button>
        </form><!-- /fs-form -->
    </div><!-- /fs-form-wrap -->

</div><!-- /container -->
<script src="${resource(dir:'installation/js',file: 'classie.js')}"></script>
<script src="${resource(dir:'installation/js',file: 'selectFx.js')}"></script>
<script src="${resource(dir:'installation/js',file: 'fullscreenForm.js')}"></script>
<script>
    (function() {
        var formWrap = document.getElementById( 'fs-form-wrap' );

        [].slice.call( document.querySelectorAll( 'select.cs-select' ) ).forEach( function(el) {
            new SelectFx( el, {
                stickyPlaceholder: false,
                onChange: function(val){
                    document.querySelector('span.cs-placeholder').style.backgroundColor = val;
                }
            });
        } );

        new FForm( formWrap, {
            onReview : function() {
                classie.add( document.body, 'overview' ); // for demo purposes only
            }
        } );
    })();
</script>
</body>
</html>