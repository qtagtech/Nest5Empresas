import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_nest5Empresas_companyproductCategories_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/company/productCategories.gsp" }
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
invokeTag('require','r',20,['modules':("jquerydatatables,tabletools,zeroclipboard,responsivetables,uniform,datatables")],-1)
printHtmlPart(8)
})
invokeTag('captureHead','sitemesh',22,[:],1)
printHtmlPart(9)
createTagBody(1, {->
printHtmlPart(10)
expressionOut.print(youarehere)
printHtmlPart(11)
expressionOut.print(youarehere)
printHtmlPart(12)
loop:{
int i = 0
for( element in (elements) ) {
printHtmlPart(13)
if(true && (i % 2 == 0)) {
printHtmlPart(14)
}
else {
printHtmlPart(15)
}
printHtmlPart(16)
expressionOut.print(element?.fields?.name)
printHtmlPart(17)
invokeTag('formatDate','g',86,['date':(element?.timeCreated),'type':("datetime"),'style':("LONG"),'timeStyle':("SHORT"),'locale':("es_CO")],-1)
printHtmlPart(17)
invokeTag('formatDate','g',87,['date':(element?.timeReceived),'type':("datetime"),'style':("LONG"),'timeStyle':("SHORT"),'locale':("es_CO")],-1)
printHtmlPart(18)
expressionOut.print(createLink(controller: 'company',action: 'editProductCategory',params: [id: element?.syncId]))
printHtmlPart(19)
i++
}
}
printHtmlPart(20)
})
invokeTag('captureBody','sitemesh',123,[:],1)
printHtmlPart(21)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1402794527489L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
