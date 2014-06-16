modules = {
    /*images*/

    nextindom{
        resource id: 'nextindom',url: 'js/libs/nextindom.js'
    }
    underscore{
        resource id: 'underscore',url: 'js/libs/underscore.js'
    }
    plugins {
        resource url:'js/plugins.js'
    }
    /*'jquerynew'{
        resource id: 'jqnewuery', url: 'jquery-ui/js/jquery-2.0.3.min.js', disposition: 'head'
    }*/
    jquerybrowserfix{
//        dependsOn('jquerynew')
        resource id: 'jquerybrowserfix', url:'js/libs/jquery.mb.browser.min.js', disposition: 'head'
    }
    /*Form scripts*/

    elastic{
        resource id: 'elastic', url:'dashboard/plugins/forms/elastic/jquery.elastic.js'
    }   
    inputlimiter{
        dependsOn('elastic')
        resource id: 'inputlimiter',url: 'dashboard/plugins/forms/inputlimiter/jquery.inputlimiter.1.3.min.js'
        resource id: 'inputlimitercss', url: 'dashboard/plugins/forms/inputlimiter/jquery.inputlimiter.css', disposition: 'head'
    }
    maskedinput{
        dependsOn('inputlimiter')
        resource id: 'maskedinput',url: 'dashboard/plugins/forms/maskedinput/jquery.maskedinput-1.3.min.js'
    }
    bootstrapswitch{
        dependsOn('maskedinput')
        resource id: 'bootstrapswitch',url: 'dashboard/libs/bootstrapswitch/js/bootstrap-switch.min.js'
        resource id: 'bootstrapswitchcss', url: 'dashboard/libs/bootstrapswitch/css/bootstrap3/bootstrap-switch.min.css', disposition: 'head'
    }
    uniform{
        dependsOn('bootstrapswitch')
        resource id: 'uniform',url: 'dashboard/plugins/forms/uniform/jquery.uniform.min.js'
        resource id: 'uniformcss', url: 'dashboard/plugins/forms/uniform/uniform.default.css', disposition: 'head'
    }
    globalize{
        dependsOn('uniform')
        resource id: 'globalize',url: 'dashboard/plugins/forms/globalize/globalize.js'
    }
    colorpicker{
        dependsOn('globalize')
        resource id: 'colorpicker',url: 'dashboard/plugins/forms/color-picker/colorpicker.js'
        resource id: 'colorpickercss', url: 'dashboard/plugins/forms/color-picker/color-picker.css', disposition: 'head'
    }
    timentry{
        dependsOn('colorpicker')
        resource id: 'timentry',url: 'dashboard/plugins/forms/timeentry/jquery.timeentry.min.js'
        resource id: 'timentrypack', url: 'dashboard/plugins/forms/timeentry/jquery.timeentry.pack.js'
    }
    select2{
        dependsOn('timentry')
        resource id: 'select2',url: 'dashboard/plugins/forms/select/select2.min.js'
        resource id: 'select2css', url: 'dashboard/plugins/forms/select/select2.css', disposition: 'head'
    }
    duallistbox{
        dependsOn('select2')
        resource id: 'duallistbox',url: 'dashboard/plugins/forms/dualselect/jquery.dualListBox-1.3.min.js'
    }
    duallistboxnew{
        dependsOn('select2')
        resource id: 'duallistboxnew',url: 'dashboard/plugins/forms/duallistbox/jquery.bootstrap-duallistbox.js'
        resource id: 'select2css', url: 'dashboard/plugins/forms/duallistbox/bootstrap-duallistbox.css', disposition: 'head'
    }
    uitimepicker{
        dependsOn('duallistbox')
        resource id: 'uitimepicker',url: 'dashboard/supr-theme/jquery-ui-timepicker-addon.js'
    }
    uislider{
        dependsOn('uitimepicker')
        resource id: 'uislider',url: 'dashboard/supr-theme/jquery-ui-sliderAccess.js'
    }
    //Otros de formulario que estoy usando
    validate{

        dependsOn('uislider')
        resource id: 'validate', url:'dashboard/plugins/forms/validate/jquery.validate.min.js'
        resource id: 'validatecss', url:'dashboard/plugins/forms/validate/validate.css'
    }
    bbq{

        dependsOn('validate')
        resource id: 'bbq', url:'dashboard/plugins/forms/wizard/jquery.bbq.js'
    }
    form{
        dependsOn('bbq')
        resource id: 'form', url:'dashboard/plugins/forms/wizard/jquery.form.js'
    }
    formwizard{
        dependsOn('form')
        resource id: 'formwizard', url:'dashboard/plugins/forms/wizard/jquery.form.wizard.js'
    }
    //main.js, script ppal de todas las pagina

    mainscript{
        dependsOn('plugins')
        resource id: 'mainscript', url:'dashboard/main.js'
    }

    //pagina crear ingredientes, productos, etc
    formvalidation{
        dependsOn('mainscript')
        resource id: 'formvalidation', url:'dashboard/form-validation.js'
    }

    /*Pagina dashboard*/

    dashboard{
        dependsOn("mainscript")
        resource id: 'dashboard', url:'dashboard/dashboard.js'
    }
    tables{

        resource id: 'tables', url:'dashboard/tables.js'
    }

    jquerydatatables{

        resource id: 'jquerydatatables', url:'dashboard/plugins/tables/dataTables/jquery.dataTables.min.js'
    }
    datepicker{

        dependsOn("mainscript")
        resource id: 'datepicker', url:'dashboard/libs/datepicker/js/bootstrap-datepicker.js'
        resource id: 'datepickercss', url:'dashboard/libs/datepicker/css/datepicker3.css'
    }
    tabletools{

        dependsOn('jquerydatatables')
        resource id: 'tabletools', url:'dashboard/plugins/tables/dataTables/TableTools.min.js'
    }
    zeroclipboard{

        dependsOn('tabletools')
        resource id: 'zeroclipboard', url:'dashboard/plugins/tables/dataTables/ZeroClipboard.js'
    }
    responsivetables{

        dependsOn('zeroclipboard')
        resource id: 'responsivetables', url:'dashboard/plugins/tables/responsive-tables/responsive-tables.js'
    }
    datatables{
        dependsOn("mainscript")
        resource id: 'datatables', url:'dashboard/datatable.js'
    }

    accounting{
        resource id: 'accounting',url: 'js/libs/accounting.min.js'
    }

    printing{
        dependsOn('jquerydatatables')
        resource id: 'printing',url: 'js/libs/jQuery.print.js'
    }








}