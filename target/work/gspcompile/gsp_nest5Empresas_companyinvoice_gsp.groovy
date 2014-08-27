import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_nest5Empresas_companyinvoice_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/company/invoice.gsp" }
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
invokeTag('captureMeta','sitemesh',12,['gsp_sm_xmlClosingForEmptyTag':("/"),'name':("viewport"),'content':("width=device-width, initial-scale=1.0")],-1)
printHtmlPart(4)
invokeTag('captureMeta','sitemesh',14,['gsp_sm_xmlClosingForEmptyTag':("/"),'http-equiv':("X-UA-Compatible"),'content':("IE=edge")],-1)
printHtmlPart(5)
expressionOut.print(resource(dir: 'dashboard/plugins/tables/dataTables',file: 'jquery.dataTables.css'))
printHtmlPart(6)
expressionOut.print(resource(dir: 'js/dashboard/plugins/tables/dataTables',file: 'TableTools.css'))
printHtmlPart(7)
invokeTag('require','r',17,['modules':("jquerydatatables,tabletools,zeroclipboard,responsivetables,uniform,datatables,datepicker,accounting,printing")],-1)
printHtmlPart(8)
})
invokeTag('captureHead','sitemesh',18,[:],1)
printHtmlPart(9)
createTagBody(1, {->
printHtmlPart(8)
invokeTag('set','g',21,['var':("factura"),'value':(data[0] ?: [:])],-1)
printHtmlPart(8)
loop:{
int k = 0
for( este in (data) ) {
invokeTag('set','g',22,['var':("factura"),'value':(este)],-1)
k++
}
}
printHtmlPart(10)
expressionOut.print(picture)
printHtmlPart(11)
invokeTag('formatNumber','g',75,['number':((factura?.key ?: 0)),'type':("number"),'maxFractionDigits':("0"),'minIntegerDigits':("9")],-1)
printHtmlPart(12)
expressionOut.print(factura?.value?.date ?: formatDate(date: new Date(),type: 'datetime',dateStyle: 'LONG',timeStyle: 'SHORT',locale: 'es_CO'))
printHtmlPart(13)
expressionOut.print(user?.name)
printHtmlPart(14)
expressionOut.print(user?.nit)
printHtmlPart(15)
expressionOut.print(user?.address)
printHtmlPart(16)
expressionOut.print(user?.telephone)
printHtmlPart(17)
expressionOut.print(user?.email)
printHtmlPart(18)
loop:{
int j = 0
for( item in (factura?.value?.items) ) {
printHtmlPart(19)
invokeTag('formatNumber','g',117,['number':((item?.cantidad ?: 0)),'type':("number"),'maxFractionDigits':("0")],-1)
printHtmlPart(20)
expressionOut.print(item?.item ?: "Sin Nombre")
printHtmlPart(20)
invokeTag('formatNumber','g',119,['number':((item?.precio ?: 0)),'type':("currency"),'currencyCode':("COP"),'locale':("es_CO")],-1)
printHtmlPart(20)
invokeTag('formatNumber','g',120,['number':((item?.precio ?: 0) * (item?.cantidad ?: 0)),'type':("currency"),'currencyCode':("COP"),'locale':("es_CO")],-1)
printHtmlPart(20)
invokeTag('formatNumber','g',121,['number':((item?.impuestos ?: 0) * ((item?.cantidad ?: 0)*(item?.precio ?: 0))),'type':("currency"),'currencyCode':("COP"),'locale':("es_CO")],-1)
printHtmlPart(20)
invokeTag('formatNumber','g',122,['number':((item?.precio ?: 0) * (item?.cantidad ?: 0) + ((item?.impuestos ?: 0) * ((item?.cantidad ?: 0)*(item?.precio ?: 0)))),'type':("currency"),'currencyCode':("COP"),'locale':("es_CO")],-1)
printHtmlPart(21)
j++
}
}
printHtmlPart(22)
expressionOut.print(factura?.value?.method)
printHtmlPart(23)
expressionOut.print(user?.email)
printHtmlPart(24)
invokeTag('formatNumber','g',137,['number':((factura?.value?.venta ?: 0) + (factura?.value?.impuestos ?: 0) + (factura?.value?.propinas ?: 0)),'type':("currency"),'currencyCode':("COP"),'locale':("es_CO")],-1)
printHtmlPart(25)
invokeTag('formatNumber','g',140,['number':((factura?.value?.propinas ?: 0)),'type':("currency"),'currencyCode':("COP"),'locale':("es_CO")],-1)
printHtmlPart(26)
invokeTag('formatNumber','g',143,['number':((factura?.value?.impuestos ?: 0)),'type':("currency"),'currencyCode':("COP"),'locale':("es_CO")],-1)
printHtmlPart(27)
invokeTag('formatNumber','g',146,['number':((factura?.value?.venta ?: 0)),'type':("currency"),'currencyCode':("COP"),'locale':("es_CO")],-1)
printHtmlPart(28)
expressionOut.print(factura?.value?.device?.resolution)
printHtmlPart(29)
expressionOut.print(user?.tipMessage)
printHtmlPart(29)
expressionOut.print(user?.invoiceMessage)
printHtmlPart(30)
createClosureForHtmlPart(31, 2)
invokeTag('script','r',193,[:],2)
printHtmlPart(8)
})
invokeTag('captureBody','sitemesh',194,[:],1)
printHtmlPart(32)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1407989749112L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
