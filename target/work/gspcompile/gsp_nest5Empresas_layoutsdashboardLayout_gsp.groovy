import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_nest5Empresas_layoutsdashboardLayout_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/layouts/dashboardLayout.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',4,['gsp_sm_xmlClosingForEmptyTag':("/"),'name':("layout"),'content':("")],-1)
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',5,['gsp_sm_xmlClosingForEmptyTag':("/"),'http-equiv':("Content-Type"),'content':("text/html; charset=utf-8")],-1)
printHtmlPart(1)
createTagBody(2, {->
createClosureForHtmlPart(2, 3)
invokeTag('captureTitle','sitemesh',6,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',6,[:],2)
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',7,['gsp_sm_xmlClosingForEmptyTag':("/"),'name':("author"),'content':("Nest5.com")],-1)
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',8,['gsp_sm_xmlClosingForEmptyTag':("/"),'name':("description"),'content':("")],-1)
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',9,['gsp_sm_xmlClosingForEmptyTag':("/"),'name':("keywords"),'content':("")],-1)
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',10,['gsp_sm_xmlClosingForEmptyTag':("/"),'name':("application-name"),'content':("Nest5")],-1)
printHtmlPart(3)
invokeTag('captureMeta','sitemesh',13,['gsp_sm_xmlClosingForEmptyTag':("/"),'name':("viewport"),'content':("width=device-width, initial-scale=1.0")],-1)
printHtmlPart(4)
invokeTag('captureMeta','sitemesh',15,['gsp_sm_xmlClosingForEmptyTag':("/"),'http-equiv':("X-UA-Compatible"),'content':("IE=edge")],-1)
printHtmlPart(5)
expressionOut.print(resource(dir:'dashboard/css/bootstrap',file: 'bootstrap.css'))
printHtmlPart(6)
expressionOut.print(resource(dir:'dashboard/css/bootstrap',file: 'bootstrap-theme.css'))
printHtmlPart(6)
expressionOut.print(resource(dir:'dashboard/css/supr-theme',file: 'jquery.ui.supr.css'))
printHtmlPart(7)
expressionOut.print(resource(dir:'dashboard/css',file: 'icons.css'))
printHtmlPart(8)
expressionOut.print(resource(dir:'dashboard/plugins/misc/qtip',file: 'jquery.qtip.css'))
printHtmlPart(6)
expressionOut.print(resource(dir:'dashboard/plugins/misc/fullcalendar',file: 'fullcalendar.css'))
printHtmlPart(6)
expressionOut.print(resource(dir:'dashboard/plugins/misc/search',file: 'tipuesearch.css'))
printHtmlPart(9)
expressionOut.print(resource(dir:'dashboard/plugins/misc/pnotify',file: 'jquery.pnotify.default.css'))
printHtmlPart(10)
invokeTag('layoutResources','r',38,[:],-1)
printHtmlPart(11)
expressionOut.print(resource(dir:'dashboard/css',file: 'main.css'))
printHtmlPart(12)
expressionOut.print(resource(dir:'dashboard/css',file: 'custom.css'))
printHtmlPart(13)
expressionOut.print(resource(dir:'dashboard/css',file: 'ie8.css'))
printHtmlPart(14)
expressionOut.print(resource(dir:'dashboard/libs',file: 'excanvas.min.js'))
printHtmlPart(15)
expressionOut.print(resource(dir:'dashboard/libs',file: 'respond.min.js'))
printHtmlPart(16)
expressionOut.print(resource(dir:'images',file: 'favicon.ico'))
printHtmlPart(17)
invokeTag('captureMeta','sitemesh',58,['gsp_sm_xmlClosingForEmptyTag':("/"),'name':("application-name"),'content':("Nest5")],-1)
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',59,['gsp_sm_xmlClosingForEmptyTag':("/"),'name':("msapplication-TileColor"),'content':("#3399cc")],-1)
printHtmlPart(18)
expressionOut.print(resource(dir:'dashboard/libs',file: 'modernizr.js'))
printHtmlPart(19)
invokeTag('layoutHead','g',60,[:],-1)
printHtmlPart(20)
})
invokeTag('captureHead','sitemesh',62,[:],1)
printHtmlPart(21)
createTagBody(1, {->
printHtmlPart(22)
expressionOut.print(createLink(controller: 'company', action:'panel'))
printHtmlPart(23)
expressionOut.print(createLink(controller: 'company', action:'panel'))
printHtmlPart(24)
expressionOut.print(picture)
printHtmlPart(25)
expressionOut.print(user?.email)
printHtmlPart(26)
expressionOut.print(createLink(controller: 'logout',action: 'index'))
printHtmlPart(27)
expressionOut.print(createLink(controller: 'company',action: 'dashboard'))
printHtmlPart(28)
expressionOut.print(createLink(controller: 'company',action:'addIngredientCategory'))
printHtmlPart(29)
expressionOut.print(createLink(controller: 'company',action:'ingredientCategories'))
printHtmlPart(30)
expressionOut.print(createLink(controller: 'company',action:'addProductCategory'))
printHtmlPart(31)
expressionOut.print(createLink(controller: 'company',action:'productCategories'))
printHtmlPart(32)
expressionOut.print(createLink(controller: 'company',action:'addIngredient'))
printHtmlPart(33)
expressionOut.print(createLink(controller: 'company',action:'ingredients'))
printHtmlPart(34)
expressionOut.print(createLink(controller: 'company',action:'addProduct'))
printHtmlPart(35)
expressionOut.print(createLink(controller: 'company',action:'products'))
printHtmlPart(36)
expressionOut.print(createLink(controller: 'company',action:'addCombo'))
printHtmlPart(37)
expressionOut.print(createLink(controller: 'company',action:'report'))
printHtmlPart(38)
expressionOut.print(createLink(controller: 'company',action:'invoices'))
printHtmlPart(39)
expressionOut.print(createLink(controller: 'company',action: 'devices'))
printHtmlPart(40)
expressionOut.print(createLink(controller: 'company',action:'information'))
printHtmlPart(41)
expressionOut.print(createLink(controller: 'company',action:'addMeasuramentUnit'))
printHtmlPart(42)
expressionOut.print(createLink(controller: 'company',action:'addTax'))
printHtmlPart(43)
invokeTag('layoutBody','g',279,[:],-1)
printHtmlPart(44)
expressionOut.print(user?.id)
printHtmlPart(45)
expressionOut.print(resource(dir:'dashboard/bootstrap',file: 'bootstrap.js'))
printHtmlPart(46)
expressionOut.print(resource(dir:'dashboard',file: 'jquery.mousewheel.js'))
printHtmlPart(46)
expressionOut.print(resource(dir:'dashboard/libs',file: 'jRespond.min.js'))
printHtmlPart(47)
expressionOut.print(resource(dir:'dashboard/plugins/charts/flot',file: 'jquery.flot.js'))
printHtmlPart(46)
expressionOut.print(resource(dir:'dashboard/plugins/charts/flot',file: 'jquery.flot.grow.js'))
printHtmlPart(46)
expressionOut.print(resource(dir:'dashboard/plugins/charts/flot',file: 'jquery.flot.pie.js'))
printHtmlPart(46)
expressionOut.print(resource(dir:'dashboard/plugins/charts/flot',file: 'jquery.flot.resize.js'))
printHtmlPart(46)
expressionOut.print(resource(dir:'dashboard/plugins/charts/flot',file: 'jquery.flot.tooltip_0.4.4.js'))
printHtmlPart(46)
expressionOut.print(resource(dir:'dashboard/plugins/charts/flot',file: 'jquery.flot.orderBars.js'))
printHtmlPart(46)
expressionOut.print(resource(dir:'dashboard/plugins/charts/sparkline',file:'jquery.sparkline.js'))
printHtmlPart(48)
expressionOut.print(resource(dir: 'dashboard/plugins/charts/knob',file: 'jquery.knob.js'))
printHtmlPart(49)
expressionOut.print(resource(dir: 'dashboard/plugins/misc/nicescroll',file:'jquery.nicescroll.min.js'))
printHtmlPart(50)
expressionOut.print(resource(dir:'dashboard/plugins/misc/fullcalendar',file:'fullcalendar.min.js'))
printHtmlPart(51)
expressionOut.print(resource(dir:'dashboard/plugins/misc/qtip',file:'jquery.qtip.min.js'))
printHtmlPart(52)
expressionOut.print(resource(dir:'dashboard/plugins/misc/totop',file:'jquery.ui.totop.min.js'))
printHtmlPart(53)
expressionOut.print(resource(dir:'dashboard/plugins/misc/pnotify',file:'jquery.pnotify.min.js'))
printHtmlPart(54)
expressionOut.print(resource(dir:'dashboard/plugins/misc/search',file:'tipuesearch_set.js'))
printHtmlPart(46)
expressionOut.print(resource(dir:'dashboard/plugins/misc/search',file:'tipuesearch_data.js'))
printHtmlPart(55)
expressionOut.print(resource(dir:'dashboard/plugins/misc/search',file:'tipuesearch.js'))
printHtmlPart(56)
createTagBody(2, {->
printHtmlPart(57)
expressionOut.print(resource(dir: 'images',file: 'preloader.gif'))
printHtmlPart(58)
expressionOut.print(createLink(controller: 'imageuploader', action: 'companyUploadMain'))
printHtmlPart(59)
})
invokeTag('script','r',423,[:],2)
printHtmlPart(60)
invokeTag('javascript','g',424,['library':("underscore")],-1)
printHtmlPart(61)
invokeTag('javascript','g',424,['library':("nextindom")],-1)
printHtmlPart(61)
invokeTag('javascript','g',424,['library':("plugins")],-1)
printHtmlPart(61)
invokeTag('javascript','g',425,['library':("mainscript")],-1)
printHtmlPart(62)
invokeTag('layoutResources','r',425,[:],-1)
printHtmlPart(63)
})
invokeTag('captureBody','sitemesh',425,[:],1)
printHtmlPart(64)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1402802120967L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}