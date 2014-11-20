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
    <script type="text/javascript" src="https://maps.googleapis.com/maps/api/js?libraries=places&sensor=true"></script>
</head>
<body>
<div id="google"></div>
<div class="container">
    <div class="fs-form-wrap" id="fs-form-wrap">
        <div class="fs-title">
            <h1><img src="https://s3-us-west-2.amazonaws.com/com.nest5.assets/user-profile/letras_nest5_low.png" alt="Nest5, administra ventas, inventarios y clientes." /> - Registro de Administrador <a class="nest5-icon nest5-icon-info" href="#"><span>El primer paso consiste en registrar al usuario principal, quién controlará todos los aspectos de la empresa o negocio.</span></a></h1>
            <div class="nest5-top">

            </div>
        </div>
        <form id="stepOneFillForm" name="stepOneFillForm" class="fs-form fs-form-full" autocomplete="off">
            <ol class="fs-fields">
                <li>
                    <label class="fs-field-label fs-anim-upper" for="q1">¿Cuál es tu Nombre Completo?</label>
                    <input class="fs-anim-lower" id="q1" name="q1" type="text" placeholder="Juancho Pérez" required/>
                </li>
                <li>
                    <label class="fs-field-label fs-anim-upper" for="q2" data-info="No enviaremos SPAM ni Basura, lo prometemos...">¿Cuál es tu Correo Electrónico?</label>
                    <input class="fs-anim-lower triggerAjax" id="q2" name="q2" type="email" placeholder="juancho@nest5.com" required/>
                </li>
                <li>
                    <label class="fs-field-label fs-anim-upper" for="q3" data-info="No te llamaremos si no nos das tu permiso, el cual puedes negar desde tu panel de control en cualquier momento...">¿Tienes un Número celular o fijo de Contacto?</label>
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
                <!--<li>
                    <label class="fs-field-label fs-anim-upper" for="q4" data-info="Para encontrar tu número de serie, busca un Sticker en la caja que te llegó tu kit Nest5. Si no lo encuentras, escribe a soporte@nest5.com con tu nombre y empresa y te lo enviarán para continuar con el registro.">Ingresa el número de serie de tu paquete Nest5</label>
                <input class="fs-anim-lower" type="pid"  id="q4" maxlength="23" name="q4" pattern="^\w{5}\-\w{5}\-\w{5}\-\w{5}$" required placeholder="123AB-BCXH3-778F2-90763" size="35"/>
                </li>-->
            </ol><!-- /fs-fields -->
            <button class="fs-submit" type="submit" id="goToStep2">¡Ir a Paso 2!</button>
        </form><!-- /fs-form -->
    </div><!-- /fs-form-wrap -->

</div><!-- /container -->
<script src="${resource(dir:'js/libs',file: 'fingerprint.js')}"></script>
<script src="${resource(dir:'js/libs',file: 'jquery-2.1.0.min.js')}"></script>
<script src="${resource(dir:'js/libs',file: 'jquery-migrate-1.2.1.min.js')}"></script>
<script src="${resource(dir:'js/libs',file: 'ajaxq.js')}"></script>
<script src="${resource(dir:'js/libs',file: 'jquery.pulse.min.js')}"></script>
<script src="${resource(dir:'installation/js',file: 'classie.js')}"></script>
<script src="${resource(dir:'installation/js',file: 'selectFx.js')}"></script>
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
                        if(json.step != "one"){
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
        $("#stepOneFillForm").sayt();
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

        $('form').on('click', "#goToStep2",function(e){
            e.preventDefault();
            $(this).html("Guardando...");
            $(this).attr("disabled","disabled");
            nest5Installation.indexedDB.findByFingerPrint(endFirstStep)

        });

    });

    var saveInstallation = function(result){
        $.ajaxq ("savingInstallation", {
            url: "${createLink(controller: 'installation', action: 'beginInstallation')}",
            type: 'post',
            dataType: "jsonp",
            data: {email: triggerElement.data('oldVal'), fingerprint: result.fingerprint, city: result.city, country: result.country, initTime: result.initTime, endTime: result.endTime}
        });
    };
    var endFirstStep = function(result){
        var name = $("#q1").val();
        var email = $("#q2").val();
        var telephone = $("#q3").val();
         $.ajaxq ("savingInstallation", {
            url: "${createLink(controller: 'installation', action: 'endStepOne')}",
            type: 'post',
            dataType: "jsonp",
            data: {email: email, fingerprint: result.fingerprint, city: result.city, country: result.country, initTime: result.initTime, endTime: result.endTime, name: name, telephone: telephone},
            complete: function(result){
               if(result.status == 200){
                   //alert("Guardado con éxito")
                   if (!window.location.origin)
                       window.location.origin = window.location.protocol+"//"+window.location.host;
                   //borrar cookie de autocomplete
                   $('#stepOneFillForm').sayt({'erase': true});
                   window.location = window.location.origin + "${createLink(controller: 'installation',action: 'two')}";
               }
                else{
                    $("#goToStep2").html("¡Ir a Paso 2!");
                    $("#goToStep2").removeAttr("disabled");
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

            if(db.objectStoreNames.contains("stepone")) {
                db.deleteObjectStore("stepone");
            }

            var store = db.createObjectStore("stepone",{keyPath: "fingerprint"});
        };

        request.onsuccess = function(e) {
            nest5Installation.indexedDB.db = e.target.result;
            nest5Installation.indexedDB.getByFingerPrint();
        };

        request.onerror = nest5Installation.indexedDB.onerror;
    };
    nest5Installation.indexedDB.getByFingerPrint = function() {

        var db = nest5Installation.indexedDB.db;
        var trans = db.transaction(["stepone"], "readwrite");
        var store = trans.objectStore("stepone");
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
        var trans = db.transaction(["stepone"], "readwrite");
        var store = trans.objectStore("stepone");
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
        var trans = db.transaction(["stepone"], "readwrite");
        var store = trans.objectStore("stepone");
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
        var trans = db.transaction(["stepone"], "readwrite");
        var store = trans.objectStore("stepone");
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

    nest5Installation.indexedDB.deleteTodo = function(id) {
        var db = nest5Installation.indexedDB.db;
        var trans = db.transaction(["stepone"], "readwrite");
        var store = trans.objectStore("stepone");

        var request = store.delete(id);

        trans.oncomplete = function(e) {
            nest5Installation.indexedDB.getAllTodoItems();  // Refresh the screen
        };

        request.onerror = function(e) {
            console.log(e);
        };
    };
</script>
</body>
</html>