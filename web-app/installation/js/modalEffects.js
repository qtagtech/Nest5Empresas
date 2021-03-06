/**
 * modalEffects.js v1.0.0
 * http://www.codrops.com
 *
 * Licensed under the MIT license.
 * http://www.opensource.org/licenses/mit-license.php
 * 
 * Copyright 2013, Codrops
 * http://www.codrops.com
 */
var ModalEffects = (function() {

	function init() {

		var overlay = document.querySelector( '.md-overlay' );

		[].slice.call( document.querySelectorAll( '.md-trigger' ) ).forEach( function( el, i ) {

			var modal = document.querySelector( '#' + el.getAttribute( 'data-modal' ) ),
				close = modal.querySelector( '.md-close');
                closewithjuridic = modal.querySelector('#juridicperson');
			function removeModal( hasPerspective ) {
				classie.remove( modal, 'md-show' );

				if( hasPerspective ) {
					classie.remove( document.documentElement, 'md-perspective' );
				}
			}

			function removeModalHandler() {
				removeModal( classie.has( el, 'md-setperspective' ) ); 
			}

			el.addEventListener( 'click', function( ev ) {
				classie.add( modal, 'md-show' );
				overlay.removeEventListener( 'click', removeModalHandler );
				overlay.addEventListener( 'click', removeModalHandler );

				if( classie.has( el, 'md-setperspective' ) ) {
					setTimeout( function() {
						classie.add( document.documentElement, 'md-perspective' );
					}, 25 );
				}
			});

			close.addEventListener( 'click', function( ev ) {
                ev.preventDefault();
				ev.stopPropagation();
				removeModalHandler();
                if(regimensimplificado){
                    $(".definenaturalperson").each(function(){
                        if(!$(this).is(":checked")){
                            changeRegimen(false);
                            return false;
                        }
                    });
                }
                showRegimenChangeFromNatural();
                $("#doyouknow").addClass('hidden');
			});
            closewithjuridic.addEventListener( 'click', function( ev ) {
                ev.preventDefault();
				ev.stopPropagation();
                $('.md-naturalpersonform').hide();
				removeModalHandler();
                changeRegimen(false);
                showRegimenChangeFromJuridic();
                $("#doyouknow").addClass('hidden');
                $("#pressedjuridic").val(true);
			});

		} );

	}

	init();

})();