import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_nest5Empresas_companyreport_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/company/report.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',4,['gsp_sm_xmlClosingForEmptyTag':("/"),'name':("layout"),'content':("dashboardLayout")],-1)
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
expressionOut.print(resource(dir: 'dashboard/plugins/tables/dataTables',file: 'jquery.dataTables.css'))
printHtmlPart(6)
expressionOut.print(resource(dir: 'js/dashboard/plugins/tables/dataTables',file: 'TableTools.css'))
printHtmlPart(7)
invokeTag('require','r',20,['modules':("jquerydatatables,tabletools,zeroclipboard,responsivetables,uniform,datatables,datepicker,accounting,printing")],-1)
printHtmlPart(8)
})
invokeTag('captureHead','sitemesh',22,[:],1)
printHtmlPart(8)
createTagBody(1, {->
printHtmlPart(9)
expressionOut.print(youarehere)
printHtmlPart(10)
expressionOut.print(youarehere)
printHtmlPart(11)
expressionOut.print(resource(dir: 'dashboard/images/loaders/circular',file:'059.gif'))
printHtmlPart(12)
expressionOut.print(picture)
printHtmlPart(13)
invokeTag('formatDate','g',110,['date':(new Date()),'type':("datetime"),'dateStyle':("SHORT"),'timeStyle':("SHORT"),'locale':("es_CO")],-1)
printHtmlPart(14)
invokeTag('formatDate','g',111,['date':(new Date()),'type':("date"),'dateStyle':("SHORT"),'locale':("en_US")],-1)
printHtmlPart(15)
invokeTag('formatDate','g',111,['date':(new Date()),'type':("date"),'dateStyle':("SHORT"),'locale':("en_US")],-1)
printHtmlPart(16)
expressionOut.print(user?.name)
printHtmlPart(17)
expressionOut.print(user?.nit)
printHtmlPart(18)
expressionOut.print(user?.address)
printHtmlPart(19)
expressionOut.print(user?.telephone)
printHtmlPart(20)
expressionOut.print(user?.email)
printHtmlPart(21)
invokeTag('formatDate','g',129,['date':(new Date()),'type':("date"),'dateStyle':("SHORT"),'locale':("en_US")],-1)
printHtmlPart(22)
invokeTag('formatNumber','g',144,['number':(data?.ventas ?: 0),'type':("currency"),'currencyCode':("COP"),'locale':("es_CO")],-1)
printHtmlPart(23)
invokeTag('formatNumber','g',148,['number':(data?.descuentos ?: 0),'type':("currency"),'currencyCode':("COP"),'locale':("es_CO")],-1)
printHtmlPart(24)
invokeTag('formatNumber','g',152,['number':(data?.impuestos ?: 0),'type':("currency"),'currencyCode':("COP"),'locale':("es_CO")],-1)
printHtmlPart(25)
invokeTag('formatNumber','g',157,['number':((data?.ventas ?: 0) - (data?.descuentos ?: 0) + (data?.impuestos ?: 0)),'type':("currency"),'currencyCode':("COP"),'locale':("es_CO")],-1)
printHtmlPart(26)
invokeTag('formatNumber','g',175,['number':((data?.ventas ?: 0) - (data?.descuentos ?: 0)),'type':("currency"),'currencyCode':("COP"),'locale':("es_CO")],-1)
printHtmlPart(27)
invokeTag('formatNumber','g',183,['number':((data?.propinas ?: 0)),'type':("currency"),'currencyCode':("COP"),'locale':("es_CO")],-1)
printHtmlPart(28)
invokeTag('formatNumber','g',188,['number':((data?.ventas ?: 0) - (data?.descuentos ?: 0) + (data?.propinas ?: 0)),'type':("currency"),'currencyCode':("COP"),'locale':("es_CO")],-1)
printHtmlPart(29)
invokeTag('formatNumber','g',200,['number':((data?.domicilios ?: 0)),'type':("currency"),'currencyCode':("COP"),'locale':("es_CO")],-1)
printHtmlPart(30)
invokeTag('formatNumber','g',204,['number':((data?.llevar ?: 0)),'type':("currency"),'currencyCode':("COP"),'locale':("es_CO")],-1)
printHtmlPart(31)
invokeTag('formatNumber','g',208,['number':((data?.efectivo ?: 0)),'type':("currency"),'currencyCode':("COP"),'locale':("es_CO")],-1)
printHtmlPart(32)
invokeTag('formatNumber','g',212,['number':((data?.tarjeta ?: 0)),'type':("currency"),'currencyCode':("COP"),'locale':("es_CO")],-1)
printHtmlPart(33)
invokeTag('formatNumber','g',217,['number':((data?.ventas ?: 0)),'type':("currency"),'currencyCode':("COP"),'locale':("es_CO")],-1)
printHtmlPart(34)
invokeTag('formatNumber','g',220,['number':((data?.domicilios ?: 0) + (data?.llevar ?: 0) + (data?.efectivo ?: 0) + (data?.tarjeta ?: 0)),'type':("currency"),'currencyCode':("COP"),'locale':("es_CO")],-1)
printHtmlPart(35)
invokeTag('formatNumber','g',232,['number':((data?.contDomicilio ?: 0)),'type':("number"),'maxFractionDigits':("0")],-1)
printHtmlPart(36)
invokeTag('formatNumber','g',236,['number':((data?.contLlevar ?: 0)),'type':("number"),'maxFractionDigits':("0")],-1)
printHtmlPart(37)
invokeTag('formatNumber','g',240,['number':((data?.contEfectivo ?: 0)),'type':("number"),'maxFractionDigits':("0")],-1)
printHtmlPart(38)
invokeTag('formatNumber','g',244,['number':((data?.contTarjeta ?: 0)),'type':("number"),'maxFractionDigits':("0")],-1)
printHtmlPart(39)
invokeTag('formatNumber','g',249,['number':((data?.contEfectivo ?: 0)+(data?.contTarjeta ?: 0)),'type':("number"),'maxFractionDigits':("0")],-1)
printHtmlPart(40)
expressionOut.print(data?.consecutivos?.size() > 0 ? data?.consecutivos?.first() : 0)
printHtmlPart(41)
expressionOut.print(data?.consecutivos?.size() > 0 ? data?.consecutivos?.last() : 0)
printHtmlPart(42)
invokeTag('formatNumber','g',256,['number':(data?.consecutivos.size() > 0 ? data?.consecutivos?.size() : 0),'type':("number"),'maxFractionDigits':("0")],-1)
printHtmlPart(43)
createTagBody(2, {->
printHtmlPart(44)
expressionOut.print(createLink(controller: 'company', action: 'reportRequest'))
printHtmlPart(45)
})
invokeTag('script','r',406,[:],2)
printHtmlPart(46)
})
invokeTag('captureBody','sitemesh',407,[:],1)
printHtmlPart(47)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1407989749159L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
