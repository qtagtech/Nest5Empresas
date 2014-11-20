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
    <link rel="stylesheet" type="text/css" href="${resource(dir:'installation/css',file: 'tooltip-sharp.css')}" />
    <link rel="stylesheet" type="text/css" href="${resource(dir:'installation/css',file: 'ns-default.css')}" />
    <link rel="stylesheet" type="text/css" href="${resource(dir:'installation/css',file: 'ns-style-attached.css')}" />
    <link rel="stylesheet" type="text/css" href="${resource(dir:'installation/css',file: 'ns-style-bar.css')}" />
    <script src="${resource(dir:'installation/js',file: 'modernizr.custom.js')}"></script>
    <script type="text/javascript" src="https://maps.googleapis.com/maps/api/js?libraries=places&sensor=true"></script>
</head>
<body>
<div id="google"></div>
<div class="md-modal md-effect-17" id="modal-17">
    <div class="md-content">
        <h3>¡Clasifiquemos tu Empresa!</Clasifi></h3>
        <div class="md-form-container">
            <p><strong>Con unas simples preguntas, podremos decir si tu empresa pertenece al Régimen Común o al Simplificado y además si debes facturar con IVA o no.</strong></p>
            <form id="" name="" class="" autocomplete="off">
             <ul class="tg-list">
                 <li class="tg-list-item">
                     <label class="fs-anim-upper" for="" >¿Qué tipo de persona eres?</label>
                     <button class="btn btn-1 btn-1a" id="naturalperson">Natural</button>
                     <button class="btn btn-1 btn-1a" id="juridicperson">Jurídica</button>
                 </li>
             </ul>


            </form>
                <form class="ac-custom ac-checkbox ac-checkmark md-naturalpersonform" autocomplete="off">
                    <h2>Si eres Persona Natural, lo más probable es que seas Régimen Simplificado, sin embargo debemos asegurarnos que cumplas todos los siguientes requisitos de la DIAN para mantenerte como tal y no tener que facturar Impuesto a las Ventas (IVA).</h2>
                    <h3>Chequea el cuadro de la izquierda si estas de acuerdo con la frase de la derecha. Si al final, tienes todas chequeadas, pereteneces al Régimen Simplificado.</h3>
                    <ul>
                        <li><input class="definenaturalperson" id="np1" name="np1" type="checkbox" ><label for="np1">El año anterior obtuve ingresos inferiores a <strong>COP$107.364.000</strong></label></li>
                        <li><input class="definenaturalperson" id="np2" name="np2" type="checkbox" ><label for="np2">Solo tengo un Establecimiento de Comercio u Oficina</label></li>
                        <li><input class="definenaturalperson" id="np3" name="np3" type="checkbox" ><label for="np3">No soy usuario aduanero</label></li>
                        <li><input class="definenaturalperson" id="np4" name="np4" type="checkbox" ><label for="np4">El año anterior no firmé contratos de venta, sean bienes o servicios superiores a <strong>COP$88.575.000</strong></label></li>
                        <li><input class="definenaturalperson" id="np5" name="np5" type="checkbox" ><label for="np5">Durante este año, no firmo contratos, sea de bienes o servicios superiores a <strong>COP$90.701.000</strong></label></li>
                        <li><input class="definenaturalperson" id="np6" name="np6" type="checkbox" ><label for="np6">Las consignaciones que me hicieron a cualesquiera de mis cuentas durante el año anterior no superaron <strong>COP$120.785.000</strong></label></li>
                        <li><input class="definenaturalperson" id="np7" name="np7" type="checkbox" ><label for="np7">Las consignaciones que me han hecho a cualesquiera de mis cuentas durante este año no superan <strong>COP$123.683.000</strong></label></li>
                    </ul>
                </form>
            <button class="btn btn-3 btn-3d md-close icon-arrow-right">¡Listo!</button>
        </div>
    </div>
</div>
<div class="container">
    <div class="fs-form-wrap main clearfix" id="fs-form-wrap">
        <div class="fs-title">
            <h1><img src="https://s3-us-west-2.amazonaws.com/com.nest5.assets/user-profile/letras_nest5_low.png" alt="Nest5, administra ventas, inventarios y clientes." /> - Registro de Empresa <a class="nest5-icon nest5-icon-info" href="#"><span>El primer paso consiste en registrar al usuario principal, quién controlará todos los aspectos de la empresa o negocio.</span></a></h1>
            <div class="nest5-top">

            </div>
        </div>
        <form id="stepTwoFillForm" name="stepTwoFillForm" class="fs-form fs-form-full" autocomplete="off">
            <ol class="fs-fields">
                <li data-input-trigger>
                    <label class="fs-field-label fs-anim-upper" for="q1" data-info="Con esto se configurará tu Tablet y muchas de las opciones como impuestos, medidas y demás.">¿Que tipo de Empresa o Negocio tienes?</label>
                    <div class="fs-radio-group fs-radio-custom clearfix fs-anim-lower">
                        <span><input data-trigger-inc="true" id="q1a" name="q1" type="radio" value="restaurant"/><label for="q1a" class="radio-restaurant">Restaurante</label></span>
                        <span><input data-trigger-inc="true" id="q1b" name="q1" type="radio" value="bar"/><label for="q1b" class="radio-bar">Bar</label></span>
                        <span><input data-trigger-inc="true" id="q1c" name="q1" type="radio" value="cafe"/><label for="q1c" class="radio-cafe">Café</label></span>
                        <span><input data-trigger-inc="true" id="q1d" name="q1" type="radio" value="hotel"/><label for="q1d" class="radio-hotel">Hotel/Hostal</label></span>
                        <span><input data-trigger-inc="false" id="q1e" name="q1" type="radio" value="fashion"/><label for="q1e" class="radio-fashion">Moda</label></span>
                        <span><input data-trigger-inc="false" id="q1f" name="q1" type="radio" value="store"/><label for="q1f" class="radio-store">Tienda de Barrio</label></span>
                        <span><input data-trigger-inc="false" id="q1g" name="q1" type="radio" value="minimarket"/><label for="q1g" class="radio-minimarket">Minimercado</label></span>
                        <span><input data-trigger-inc="false" id="q1h" name="q1" type="radio" value="saloon"/><label for="q1h" class="radio-saloon">Peluquería/Spa</label></span>
                        <span><input data-trigger-inc="false" id="q1i" name="q1" type="radio" value="nursery"/><label for="q1i" class="radio-nursery">Vivero</label></span>
                        <span><input data-trigger-inc="false" id="q1j" name="q1" type="radio" value="sports"/><label for="q1j" class="radio-sports">Canchas Deportivas</label></span>
                        <span><input data-trigger-inc="false" id="q1k" name="q1" type="radio" value="entertainment"/><label for="q1k" class="radio-entertainment">Entretenimiento</label></span>
                    </div>
                </li>
                <li class="cbp-mc-form" data-input-trigger>

                        <div class="cbp-mc-column">
                            <label class=" fs-anim-upper" for="name">Nombre o Marca</label>
                            <input class="fs-anim-lower" type="text" id="name" name="name" placeholder="ACME S.A.S" required>
                            <label class=" fs-anim-upper" for="address">Dirección Postal</label>
                            <input class="fs-anim-lower" type="text" id="address" name="address" placeholder="Calle 10 #5-25 Of. 301" required>
                            <label class=" fs-anim-upper" for="identification">N.I.T./Cédula</label>
                            <input class="fs-anim-lower" type="text" id="identification" name="identification" placeholder="1234567890-3" required>
                            <label class=" fs-anim-upper" for="web">Pagina Web</label>
                            <input class="fs-anim-lower" type="url" id="web" name="web" placeholder="http://www.acme.com">
                            <label class=" fs-anim-upper" for="telephone">Telefono</label>
                            <input class="fs-anim-lower" type="text" id="telephone" name="telephone" placeholder="555 55 55" required>
                            <input type="hidden" name="regimensimplificadohidden" id="regimensimplificadohidden"/>
                            <input type="hidden" name="inchidden" id="inchidden"/>
                            <input type="hidden" name="incbighidden" id="incbighidden"/>
                            <input type="hidden" name="knewregimen" id="knewregimen"/>
                            <input type="hidden" name="pressedjuridic" id="pressedjuridic"/>

                        </div>
                        <div class="cbp-mc-column">
                            <p class="fs-anim-upper description">Categoriza tu empresa o negocio con el fin de determinar que tipo de impuestos debes presentar o cobrar.</p>
                            <ul class="tg-list">
                                <li class="tg-list-item">
                                    <label class="fs-anim-upper" for="franchise" >¿Eres una Franquicia?<span class="tooltip tooltip-turnleft"><span class="tooltip-item tooltip-helper-icon"></span><span class="tooltip-content">La franquicia es un tipo de contrato utilizado en el comercio mediante el cual una parte llamada franquiciador cede a otra llamada franquiciado la licencia de una marca para su explotación comercial así como los métodos, procedimientos y tecnología a cambio de pagos periódicos.
                                    La franquicia consiste en aprovechar la experiencia de una empresa ya posicionada que ha conseguido una ventaja competitiva destacable y un gran reconocimiento en el mercado. Dicha ventaja puede consistir en una marca de prestigio, productos o métodos patentados o, simplemente, un profundo conocimiento del negocio que le hace conocedor de la fórmula de obtener beneficios.</span></span></label>
                                    <input class="tgl tgl-flip fs-anim-lower" id="franchise" name="franchise" type="checkbox" />
                                    <label class="tgl-btn fs-anim-upper" data-tg-off="No" data-tg-on="Si" for="franchise"></label>
                                </li>
                                <li class="tg-list-item" id="doyouknow">
                                    <label class="fs-anim-upper" for="knowregimen" >¿Conoces si perteneces a Régimen Común o Simplificado?<span class="tooltip tooltip-turnright"><span class="tooltip-item tooltip-helper-icon"></span><span class="tooltip-content">Al régimen común pueden pertenecer personas naturales y personas jurídicas. Toda persona jurídica, pertenece al régimen común. Los responsables del régimen común deben solicitar autorización para facturar. Los responsables del régimen simplificado no (a excepción de los litógrafos pertenecientes al régimen simplificado). Los responsables del régimen común deben declarar renta, los responsables del régimen simplificado no. Pertenecer al régimen común implica estar formalizado, entre tanto el régimen simplificado se caracteriza por ser informal.</span></span></label>
                                    <button class="btn btn-2 btn-2i fs-anim-upper" id="knowregimensi">Sí</button>
                                    <button class="btn btn-2 btn-2j fs-anim-upper md-trigger md-setperspective" id="knowregimenno" data-modal="modal-17">No</button>
                                </li>
                                <li class="tg-list-item hidden" id="selectregimen">
                                    <label class="fs-anim-upper" for="" >¿A qué Régimen perteneces?</label>
                                    <button class="btn-1a-big btn-1 btn-1a" id="btn-regimensimplificado">Simplificado</button>
                                    <button class="btn-1a-big btn-1 btn-1a" id="btn-regimencomun">Común</button>
                                </li>
                                <li class="tg-list-item" id="selectregimen">
                                    <label class="fs-anim-upper" for="" >Con lo que has seleccionado, estás clasificado como Régimen:</label>
                                    <button class="btn-1a-big btn-1 btn-1a fs-anim-upper" id="btn-regimenselected" disabled></button><button class="btn btn-7 btn-7d btn-icon-only icon-remove fs-anim-upper" id="resetregimen">Cambiar</button>
                                </li>
                                <li class="tg-list-item hidden" id="incCheck">
                                    <h3 class="special-info fs-anim-lower">Al ser un negocio donde transformas comida, es probable que te toque declarar Inpuesto Nacional al Consumo (INC), equivalente al 8% de las ventas e independiente de si eres Régimen Común o Simplificado para Ventas. &nbsp; $nbsp; </h3>
                                    <label class="fs-anim-upper" for="inc" >¿En 2013, vendiste más de $107.364.000?<span class="tooltip tooltip-turnleft"><span class="tooltip-item tooltip-helper-icon"></span><span class="tooltip-content">Si superaste este valor quiere decir que en 2014 perteneces al régimen común para el Impuesto Nacional al Consumo [INC], que para el tipo de negocio que indicas que tienes, es del 8% y por lo tanto, en los productos y servicios que registres con Nest5, se cobrará y tendrás que declararlo. Esta es la razón por la que te lo preguntamos, para hacerte más fácil la clasificación de tu empresa y su administración.</span></span></label>
                                    <input class="tgl tgl-flip fs-anim-lower" id="inc" name="inc" type="checkbox" />
                                    <label class="tgl-btn fs-anim-upper" data-tg-off="No" data-tg-on="Si" for="inc"></label>
                                </li>
                            </ul>
                        </div>


                </li>


            </ol><!-- /fs-fields -->
            <button class="fs-submit" type="submit" id="goToStep3">¡Ir a Paso 3!</button>
        </form><!-- /fs-form -->
    </div><!-- /fs-form-wrap -->
</div><!-- /container -->
<div class="md-overlay"></div><!-- the overlay element -->

<script src="${resource(dir:'js/libs',file: 'fingerprint.js')}"></script>
<script src="${resource(dir:'js/libs',file: 'jquery-2.1.0.min.js')}"></script>
<script src="${resource(dir:'js/libs',file: 'jquery-migrate-1.2.1.min.js')}"></script>
<script src="${resource(dir:'js/libs',file: 'ajaxq.js')}"></script>
<script src="${resource(dir:'js/libs',file: 'jquery.pulse.min.js')}"></script>
<script src="${resource(dir:'installation/js',file: 'classie.js')}"></script>
<script src="${resource(dir:'installation/js',file: 'modalEffects.js')}"></script>
<script src="${resource(dir:'installation/js',file: 'selectFx.js')}"></script>
<script src="${resource(dir:'installation/js',file: 'svgcheckbx.js')}"></script>
<script src="${resource(dir:'installation/js',file: 'notificationFx.js')}"></script>
<script src="${resource(dir:'installation/js',file: 'fullscreenForm.js')}"></script>
<script src="${resource(dir:'js/libs/sayt/dependencies',file: 'jquery-cookie.js')}"></script>
<script src="${resource(dir:'js/libs/sayt/source',file: 'sayt.jquery.js')}"></script>
<script>
    var nest5Installation = {};
    nest5Installation.indexedDB = {};
    nest5Installation.indexedDB.db = null;
    var userFingerprint = new Fingerprint({screen_resolution: true,canvas: true,ie_activex: true});
    var itemLocality='';
    var itemCountry='';
    var companyPaysINC = false;
    var regimensimplificado;
    var isFranchise;
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
    var timerTask = function(){
        // do some stuff
        nest5Installation.indexedDB.updateFingerPrint();
        setTimeout(timerTask, 5000);
    };
    var triggerElement
    $(function(){
        //check if the fingerprint has completed this step
        try{
            $.ajaxq ("savingInstallation", {
                url: "${createLink(controller: 'installation', action: 'checkStep')}",
                type: 'post',
                dataType: "jsonp",
                data: {fingerprint: userFingerprint.get()},
                complete: function(result){
                    if(result.status == 200){
                        var json
                        try{
                            json = jQuery.parseJSON(result.responseText)
                        }catch(e){
                            console.log(e);
                        }
                        if(json.step != "two"){
                            if (!window.location.origin)
                                window.location.origin = window.location.protocol+"//"+window.location.host;
                            //borrar cookie de autocomplete
                            window.location = window.location.origin + "/installation/"+json.step;
                        }
                        // jQuery.parseJSON(result.)
                    }
                },
                error: function(request,status,errorThrown) {
                    // There's been an error, do something with it!
                    // Only use status and errorThrown.
                    // Chances are request will not have anything in it.
                }

            });
        }catch(exc){}





        nest5Installation.indexedDB.open(); // open displays the data previously saved
        $("#stepTwoFillForm").sayt();
        if (navigator.geolocation) {
            navigator.geolocation.getCurrentPosition(addressToCode);
        }
        $('.triggerAjax').each(function() {
            var elem = $(this);

            // Save current value of element
            elem.data('oldVal', elem.val());

            // Look for changes in the value
            elem.bind("blur paste", function(event){
                // If value has changed...
                if (elem.data('oldVal') != elem.val()) {
                    // Updated stored value
                    elem.data('oldVal', elem.val());
                    triggerElement = elem;
                    nest5Installation.indexedDB.findByFingerPrint(saveInstallation); //hallar valores y de alla enviar a guardar
                    //console.log("cambió");
                }
            });
        });

        $('form').on('click', "#goToStep3",function(e){
            e.preventDefault();
            $(this).html("Guardando...");
            $(this).attr("disabled","disabled");
            nest5Installation.indexedDB.findByFingerPrint(endSecondStep);

        });

    });

    var saveInstallation = function(result){
        $.ajaxq ("savingInstallation", {
            url: "${createLink(controller: 'installation', action: 'secondStepInstallation')}",
            type: 'post',
            dataType: "jsonp",
            data: {email: triggerElement.data('oldVal'), fingerprint: result.fingerprint, city: result.city, country: result.country, initTime: result.initTime, endTime: result.endTime}
        });
    };
    var endSecondStep = function(result){
        var tipo = $("#q1").val();
        var name = $("#name").val();
        var address = $("#address").val();
        var identification = $("#identification").val();
        var web = $("#web").val();
        var telephone = $("#telephone").val();
        var regimensimp = $("#regimensimp").val();
        var inchidden = $("#inchidden").val();
        var incbighidden = $("#incbighidden").val();
        var isfran = isFranchise;
        var knewregimen = $("#knewregimen").val();
        var aantveninf = $("#np1").prop("checked");
        var uncomercio = $("#np2").prop("checked");
        var noadua = $("#np3").prop("checked");
        var aantcontinf = $("#np4").prop("checked");
        var aactcontinf = $("#np5").prop("checked");
        var aantconsinf = $("#np6").prop("checked");
        var aactconsinf = $("#np7").prop("checked");
        var pressedjuridic = $("#pressedjuridic").val();

        $.ajaxq ("savingInstallation", {
            url: "${createLink(controller: 'installation', action: 'endStepTwo')}",
            type: 'post',
            dataType: "jsonp",
            data: {tipo: tipo, fingerprint: result.fingerprint, city: result.city, country: result.country, initTime: result.initTime, endTime: result.endTime, name: name, telephone: telephone,web:web,address:address,identification:identification,simplified:regimensimplificado,inc:inchidden,incvalue:incbighidden,isfranchise:isfran,knewregimen:knewregimen,aantventinf:aantveninf,uncomercio:uncomercio,noadua: noadua,aantcontinf: aantcontinf,aactcontinf:aactcontinf,aantconsinf: aantconsinf,aactconsinf:aactconsinf,pressedjuridic:pressedjuridic},
            complete: function(result){
                if(result.status == 200){
                    //alert("Guardado con éxito")
                    if (!window.location.origin)
                        window.location.origin = window.location.protocol+"//"+window.location.host;
                    //borrar cookie de autocomplete
                    $('#stepTwoFillForm').sayt({'erase': true});
                    window.location = window.location.origin + "${createLink(controller: 'installation',action: 'three')}";
                }
                else{
                    if(result.status == 303){
                        //borrar cookie de autocomplete
                        $('#stepOneFillForm').sayt({'erase': true}); //en caso que haya lleno algo del formulario 1, borrarlo
                        $('#stepTwoFillForm').sayt({'erase': true});
                        if (!window.location.origin)
                            window.location.origin = window.location.protocol+"//"+window.location.host;
                        window.location = window.location.origin + "${createLink(controller: 'installation',action: 'one')}";
                    }else{
                        $("#goToStep3").html("¡Ir a Paso 3!");
                        $("#goToStep3").removeAttr("disabled");
                    }

                }
            }
        });
    };

    var addressToCode = function (position) {
        var url = "http://maps.googleapis.com/maps/api/geocode/json?latlng=" + position.coords.latitude + "," + position.coords.longitude + "&sensor=false";
        $.getJSON(url, function (json) {
            if (json.status == 'OK') {
                //console.log(json);
                var arrAddress = json.results[0].address_components;


// iterate through address_component array
                $.each(arrAddress, function (i, address_component) {
                    //console.log('address_component:'+i);

                    if (address_component.types[0] == "route"){
                        //console.log(i+": route:"+address_component.long_name);
                        //itemRoute = address_component.long_name;
                    }

                    if (address_component.types[0] == "locality"){
                        //console.log("town:"+address_component.long_name);
                        itemLocality = address_component.long_name;
                    }

                    if (address_component.types[0] == "country"){
                        //console.log("country:"+address_component.long_name);
                        itemCountry = address_component.long_name;
                    }

                    if (address_component.types[0] == "postal_code_prefix"){
                        //console.log("pc:"+address_component.long_name);
                        //itemPc = address_component.long_name;
                    }

                    if (address_component.types[0] == "street_number"){
                        // console.log("street_number:"+address_component.long_name);
                        //itemSnumber = address_component.long_name;
                    }
                    //return false; // break the loop
                });
                //json.results[0].formatted_address;
            } else {
                //alert("Geocode was not successful for the following reason: " + json.status);
            }
        });
    };
    nest5Installation.indexedDB.open = function() {
        var version = 3;
        var request = indexedDB.open("Nest5Installation", version);

        // We can only create Object stores in a versionchange transaction.
        request.onupgradeneeded = function(e) {
            var db = e.target.result;

            // A versionchange transaction is started automatically.
            e.target.transaction.onerror = nest5Installation.indexedDB.onerror;

            if(db.objectStoreNames.contains("steptwo")) {
                db.deleteObjectStore("steptwo");
            }

            var store = db.createObjectStore("steptwo",{keyPath: "fingerprint"});
        };

        request.onsuccess = function(e) {
            nest5Installation.indexedDB.db = e.target.result;
            nest5Installation.indexedDB.getByFingerPrint();
        };

        request.onerror = nest5Installation.indexedDB.onerror;
    };
    nest5Installation.indexedDB.getByFingerPrint = function() {

        var db = nest5Installation.indexedDB.db;
        var trans = db.transaction(["steptwo"], "readwrite");
        var store = trans.objectStore("steptwo");
        var request = store.get(userFingerprint.get());
        request.onerror = function(e) {
            console.log(e.value);
        };
        request.onsuccess = function(e) {
            // Do something with the request.result!
            var result = request.result;
            if(!!result == false){
                //console.log("GETBYFINGERPRINT --> No hay valor para fingerprint: "+userFingerprint.get());
                //guardar valor porque empieza nuevo proceso
                nest5Installation.indexedDB.addFingerPrint();
                return;
            }
            //console.log("GETBYFINGERPRINT --> Encontrado valor para fingerprint: "+result.fingerprint);
        };
        trans.oncomplete = function(e) {
            //console.log("Empieza el contador");
            timerTask(); //empieza el contador para mantener actualizando contador
        };
    };
    nest5Installation.indexedDB.findByFingerPrint = function(callback) {

        var db = nest5Installation.indexedDB.db;
        var trans = db.transaction(["steptwo"], "readwrite");
        var store = trans.objectStore("steptwo");
        var request = store.get(userFingerprint.get());
        request.onerror = function(e) {
            console.log(e.value);
        };
        request.onsuccess = function(e) {
            // Do something with the request.result!
            var result = request.result;
            if(!!result == false){
                //console.log("GETBYFINGERPRINT --> No hay valor para fingerprint: "+userFingerprint.get());
                //guardar valor porque empieza nuevo proceso
                nest5Installation.indexedDB.addFingerPrint();
                return;
            }
            //console.log("GETBYFINGERPRINT --> Encontrado valor para fingerprint: "+result.fingerprint);
        };
        trans.oncomplete = function(e) {
            //console.log("Empieza el contador");
            //timerTask(); //empieza el contador para mantener actualizando contador
            if(typeof callback == "function")
                callback( request.result );
        };
    };
    nest5Installation.indexedDB.addFingerPrint = function() {
        var db = nest5Installation.indexedDB.db;
        var trans = db.transaction(["steptwo"], "readwrite");
        var store = trans.objectStore("steptwo");
        var request = store.put({
            "fingerprint": userFingerprint.get(),
            "initTime" : new Date().getTime(),
            "endTime"   : new Date().getTime(),
            "city"      : itemLocality,
            "country"   : itemCountry
        });

        request.onerror = function(e) {
            console.log(e.value);
        };
    };
    nest5Installation.indexedDB.updateFingerPrint = function() {

        var db = nest5Installation.indexedDB.db;
        var trans = db.transaction(["steptwo"], "readwrite");
        var store = trans.objectStore("steptwo");
        var request = store.get(userFingerprint.get());
        request.onsuccess = function(e){
            var data = request.result;
            if(!!data == false) {
                //console.log("UPDATEFINGERPRINT -->  No hay valor para fingerprint: " + userFingerprint.get());
                nest5Installation.indexedDB.addFingerPrint();
                return;
            }

            // update the value(s) in the object that you want to change
            data.endTime = new Date().getTime();
            data.city = itemLocality;
            data.country = itemCountry;

            // Put this updated object back into the database.
            var requestUpdate = store.put(data);
            requestUpdate.onsuccess = function(event) {
                //console.log("UPDATEFINGERPRINT -->  Actualizado valor final de fingerprint: "+userFingerprint.get());
            };
            requestUpdate.onerror = function(e) {
                console.log(e.value);
            };
        };
        request.onerror = function(e){
            console.log(e.value);
        }
    };

    $(document).ready(function(){
        changeRegimen();
        companyPaysINC = $('input[name=q1]:checked').data('trigger-inc');
        $("#inchidden").val(companyPaysINC);
        isFranchise = $("#franchise").prop('checked');
        if(companyPaysINC && !isFranchise){
            $("#incCheck").removeClass('hidden');
            $("#doyouknow").removeClass('hidden');
        }
        if(!companyPaysINC && !isFranchise){
            $("#doyouknow").removeClass('hidden');
        }
        if(isFranchise){
            changeRegimen(false);
            $("#incCheck").addClass('hidden');
            $("#doyouknow").addClass('hidden');
        }
        //when a type of company is selected, check if it should generate Impo consumo
        $('body').on('click','input:radio',function(e){
            if($(this).data("trigger-inc")){
                $("#inchidden").val(true);
                companyPaysINC = true;
            }
            else{
                $("#inchidden").val(false);
                companyPaysINC = false;
            }
            if(companyPaysINC && !isFranchise){
                $("#incCheck").removeClass('hidden');
            }
            if(!companyPaysINC){
                $("#incCheck").addClass('hidden');
            }
            if((isFranchise)){
                $("#doyouknow").addClass('hidden');
            }
            if(!isFranchise){
                $("#doyouknow").removeClass('hidden');
            }

        });
        //if it is a franchise, régimen común, else, ask for all other stuff
        //check if when loaded is checked

        //check change event
        $("#franchise").change(function() {
            if(this.checked) {
                isFranchise = true;
                changeRegimen(false);
                showRegimenChangeFranchise();
                if(companyPaysINC)
                    $("#incCheck").addClass('hidden');
                $("#doyouknow").addClass('hidden');
                $("#selectregimen").addClass('hidden');
            }
            else{
                isFranchise = false;
                if(companyPaysINC)
                    $("#incCheck").removeClass('hidden');
                //$("#doyouknow").removeClass('hidden');
            }

        });
        $("#inc").change(function() {
            if(this.checked) {
                //obligatoriamente paga nc porque vendio mas de eso el año pasado
                $("#inchidden").val(true);
                $("#incbighidden").val(true);
                companyPaysINC = true;

            }
            else{
                //no necesariamente quiere decir que no paga inc, solo que no gano mas de eso el año pasado
                $("#incbighidden").val(false);
            }
            showIncChange();
        });

        $("form").on('click',".btn-2i, .btn-2j",function(e){
            e.preventDefault();
        });

        $('form').on('click','#knowregimensi',function(e){
            e.preventDefault();
            $("#selectregimen").removeClass('hidden');
            $("#knewregimen").val(true);
        });
        $('form').on('click','#knowregimenno',function(e){
            e.preventDefault();
            $("#selectregimen").addClass('hidden');
            $("#knewregimen").val(false);
            $("#pressedjuridic").val(false);
        });

        $('form').on('click','#btn-regimensimplificado',function(e){
            e.preventDefault();
            changeRegimen(true);
            showRegimenChange();
            $("#doyouknow").addClass('hidden');
            $("#selectregimen").addClass('hidden');
        });
        $('form').on('click','#btn-regimencomun',function(e){
            e.preventDefault();
            changeRegimen(false);
            showRegimenChange();
            $("#doyouknow").addClass('hidden');
            $("#selectregimen").addClass('hidden');
        });

        $('form').on('click','#resetregimen',function(e){
            e.preventDefault();
            $("#franchise").prop('checked',false);
            $("#doyouknow").removeClass('hidden');
            $("#selectregimen").removeClass('hidden');
            $("#pressedjuridic").val(false);

            changeRegimen(true);
            showRegimenChangeReset();


        });

/*
* functions for when categorizing company in natural or juridic persona
*
*
*
*
* */
    $('body').on('click','#naturalperson',function(e){
         e.preventDefault();
        $('.md-naturalpersonform').show();
    });
        $('body').on('click','#juridicperson',function(e){
            e.preventDefault();
        });
        /*var notification = new NotificationFx({
            message : '<span class="icon icon-asterisk"></span><p>Has sido clasificado como una Persona o Empresa en Régimen Común.</p>',
            layout : 'attached',
            effect : 'bouncyflip',
            type : 'notice', // notice, warning or error
            onClose : function() {

            }
        });*/
        $('.definenaturalperson').change(function() {
            if($(this).is(":checked")) {
                changeRegimen(true);
            }else{
                changeRegimen(false);
            }
        });


     });

    function changeRegimen(value){
        if(typeof value === "undefined"){// significa que es cuando se catga la pagina o se quiere tomar el valor que tiene el valor del formulario por si lo tiene precargado con el plugin de form precargadp
            console.log("sin value");
            value = $("#regimensimplificadohidden").val();
            console.log("value tomado del campo hidden: "+value);
            if(typeof value === "undefined" || value == null || value == ""){
                value = true;
                console.log("value no estaba puesto guardado por plugin: "+value);
            }else{
                console.log("value guardado por plugin con valor: "+value);
            }
            regimensimplificado = value;
            changeLabel();


        }
        else{
            console.log("llamada con value en valor: "+value);
            $("#regimensimplificadohidden").val(value);
            regimensimplificado = value;
            changeLabel();

        }

    };
    function changeLabel(){
        var cont = regimensimplificado ? 'Simplificado' : 'Común';
        $("#btn-regimenselected").html(cont);
    }
function showRegimenChange(){
    var regimen = regimensimplificado ? 'Simplificado' : 'Común';
    var notification = new NotificationFx({
        message : '<span class="icones icon-megaphone"></span><p>Has cambiado a Régimen: <strong>'+regimen+'</strong>.</p>',
        layout : 'bar',
        effect : 'slidetop',
        type : 'notice', // notice, warning or error
        onClose : function() {
        }
    });
    notification.show();
};
function showIncChange(){
    var regimen = companyPaysINC ? ' ' : 'NO ';
    var notification = new NotificationFx({
        message : '<span class="icones icon-megaphone"></span><p>Por el valor de tus ventas el año anterior <strong>'+regimen+'DEBES</strong> declarar Inpuesto Nacional al Consumo del 8%. Nest5 '+regimen+'lo creará automáticamente.</p>',
        layout : 'bar',
        effect : 'slidetop',
        type : 'notice', // notice, warning or error
        onClose : function() {
        }
    });
    notification.show();
};
    function showRegimenChangeReset(){
    var regimen = regimensimplificado ? 'Simplificado' : 'Común';
    var notification = new NotificationFx({
        message : '<span class="icones icon-megaphone"></span><p>Has Reseteado toda la configuración de Régimen y se te ha puesto por defecto en Régimen: <strong>'+regimen+'</strong>.</p><p>Vuelve a seleccionar lo que desees para clasificarte de nuevo o dejála así si consideras que está bien.</p>',
        layout : 'bar',
        effect : 'slidetop',
        type : 'notice', // notice, warning or error
        onClose : function() {
        }
    });
    notification.show();
};
    function showRegimenChangeFranchise(){
    var regimen = regimensimplificado ? 'Simplificado' : 'Común';
    var notification = new NotificationFx({
        message : '<span class="icones icon-megaphone"></span><p>Al declararte como <srong>Franquicia</strong> automáticamente cambias a Régimen: <strong>'+regimen+'</strong>.</p>',
        layout : 'bar',
        effect : 'slidetop',
        type : 'notice', // notice, warning or error
        onClose : function() {
        }
    });
    notification.show();
};

    function showRegimenChangeFromJuridic(){
        var regimen = regimensimplificado ? 'Simplificado' : 'Común';
        var notification = new NotificationFx({
            message : '<span class="icones icon-megaphone"></span><p>Por ser persona <strong>Jurídica</strong> automáticamente perteneces al Régimen: <strong>'+regimen+'</strong>.</p>',
            layout : 'bar',
            effect : 'slidetop',
            type : 'notice', // notice, warning or error
            onClose : function() {
            }
        });
        notification.show();
    };

    function showRegimenChangeFromNatural(){
        var regimen = regimensimplificado ? 'Simplificado' : 'Común';
        var nosi = regimensimplificado ? 'NO ' : ' ';
        var notification = new NotificationFx({
            message : '<span class="icones icon-megaphone"></span><p>¡Ya te hemos clasificado! Perteneces al Régimen: <strong>'+regimen+'</strong> y <strong>'+nosi+'DEBES</strong> declarar IVA.</p>',
            layout : 'bar',
            effect : 'slidetop',
            type : 'notice', // notice, warning or error
            onClose : function() {
            }
        });
        notification.show();
    };
</script>
<!-- for the blur effect -->
<!-- by @derSchepp https://github.com/Schepp/CSS-Filters-Polyfill -->
<script>
    // this is important for IEs
    var polyfilter_scriptpath = '/';
</script>
<script src="${resource(dir:'installation/js',file: 'cssParser.js')}"></script>
<script src="${resource(dir:'installation/js',file: 'css-filters-polyfill.js')}"></script>
</body>
</html>