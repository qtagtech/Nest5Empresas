import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_nest5Empresas_companyeditIngredientCategory_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/company/editIngredientCategory.gsp" }
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
expressionOut.print(resource(dir:'dashboard/plugins/misc/qtip',file:'jquery.qtip.css'))
printHtmlPart(6)
expressionOut.print(resource(dir:'dashboard/plugins/forms/uniform',file:'uniform.default.css'))
printHtmlPart(7)
expressionOut.print(resource(dir:'dashboard/plugins/forms/select',file:'select2.css'))
printHtmlPart(7)
expressionOut.print(resource(dir:'dashboard/plugins/forms/validate',file:'validate.css'))
printHtmlPart(8)
invokeTag('require','r',23,['modules':("uniform,select2,validate,bbq,form,formwizard,formvalidation")],-1)
printHtmlPart(9)
})
invokeTag('captureHead','sitemesh',25,[:],1)
printHtmlPart(10)
createTagBody(1, {->
printHtmlPart(11)
expressionOut.print(youarehere)
printHtmlPart(12)
expressionOut.print(youarehere)
printHtmlPart(13)
expressionOut.print(youarehere)
printHtmlPart(14)
expressionOut.print(element?.fields?.name ?: "Sin Nombre")
printHtmlPart(15)
expressionOut.print(element?.table ?: 'ingredient_category')
printHtmlPart(16)
expressionOut.print(element?.rowId ?: 0)
printHtmlPart(17)
expressionOut.print(element?.syncId ?: 0)
printHtmlPart(18)
createTagBody(2, {->
printHtmlPart(19)
expressionOut.print(createLink(controller: 'company',action: 'saveRow'))
printHtmlPart(20)
})
invokeTag('script','r',140,[:],2)
printHtmlPart(1)
})
invokeTag('captureBody','sitemesh',141,[:],1)
printHtmlPart(21)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1407989749063L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
