import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_nest5Empresas_companyinvoices_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/company/invoices.gsp" }
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
expressionOut.print(data.size())
printHtmlPart(23)
loop:{
int i = 0
for( factura in (data) ) {
printHtmlPart(24)
expressionOut.print(createLink(controller: 'company',action: 'invoice',params: [id: factura?.key ?: 0]))
printHtmlPart(25)
invokeTag('formatNumber','g',138,['number':((factura?.key ?: 0)),'type':("number"),'maxFractionDigits':("0"),'minIntegerDigits':("9")],-1)
printHtmlPart(26)
loop:{
int j = 0
for( item in (factura?.value?.items) ) {
printHtmlPart(27)
expressionOut.print(item?.item ?: "Sin Nombre")
printHtmlPart(28)
invokeTag('formatNumber','g',155,['number':((item?.cantidad ?: 0)),'type':("number"),'maxFractionDigits':("0")],-1)
printHtmlPart(28)
invokeTag('formatNumber','g',156,['number':((item?.precio ?: 0)),'type':("currency"),'currencyCode':("COP"),'locale':("es_CO")],-1)
printHtmlPart(28)
invokeTag('formatNumber','g',157,['number':((item?.precio ?: 0) * (item?.cantidad ?: 0)),'type':("currency"),'currencyCode':("COP"),'locale':("es_CO")],-1)
printHtmlPart(28)
invokeTag('formatNumber','g',158,['number':((item?.impuestos ?: 0) * ((item?.cantidad ?: 0)*(item?.precio ?: 0))),'type':("currency"),'currencyCode':("COP"),'locale':("es_CO")],-1)
printHtmlPart(28)
invokeTag('formatNumber','g',159,['number':((item?.precio ?: 0) * (item?.cantidad ?: 0) + ((item?.impuestos ?: 0) * ((item?.cantidad ?: 0)*(item?.precio ?: 0)))),'type':("currency"),'currencyCode':("COP"),'locale':("es_CO")],-1)
printHtmlPart(29)
j++
}
}
printHtmlPart(30)
invokeTag('formatNumber','g',166,['number':((factura?.value?.venta ?: 0) + (factura?.value?.impuestos ?: 0) + (factura?.value?.propinas ?: 0)),'type':("currency"),'currencyCode':("COP"),'locale':("es_CO")],-1)
printHtmlPart(31)
invokeTag('formatNumber','g',169,['number':((factura?.value?.propinas ?: 0)),'type':("currency"),'currencyCode':("COP"),'locale':("es_CO")],-1)
printHtmlPart(32)
invokeTag('formatNumber','g',172,['number':((factura?.value?.impuestos ?: 0)),'type':("currency"),'currencyCode':("COP"),'locale':("es_CO")],-1)
printHtmlPart(33)
invokeTag('formatNumber','g',175,['number':((factura?.value?.venta ?: 0)),'type':("currency"),'currencyCode':("COP"),'locale':("es_CO")],-1)
printHtmlPart(34)
i++
}
}
printHtmlPart(35)
createTagBody(2, {->
printHtmlPart(36)
expressionOut.print(createLink(controller: 'company', action: 'invoiceRequest'))
printHtmlPart(37)
})
invokeTag('script','r',324,[:],2)
printHtmlPart(38)
})
invokeTag('captureBody','sitemesh',328,[:],1)
printHtmlPart(39)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1402794527485L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
