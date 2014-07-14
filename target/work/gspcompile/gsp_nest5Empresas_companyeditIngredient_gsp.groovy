import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_nest5Empresas_companyeditIngredient_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/company/editIngredient.gsp" }
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
printHtmlPart(1)
invokeTag('require','r',16,['modules':("elastic,inputlimiter,maskedinput,bootstrapswitch,uniform,globalize,colorpicker,timentry,select2,duallistbox,bbq,formwizard,formvalidation")],-1)
printHtmlPart(5)
})
invokeTag('captureHead','sitemesh',18,[:],1)
printHtmlPart(6)
createTagBody(1, {->
printHtmlPart(7)
expressionOut.print(youarehere)
printHtmlPart(8)
expressionOut.print(youarehere)
printHtmlPart(9)
expressionOut.print(youarehere?: "Edición de Ingrediente")
printHtmlPart(10)
expressionOut.print(element?.fields?.name ?: "Sin Nombre")
printHtmlPart(11)
expressionOut.print(element?.fields?.cost_per_unit ?: 0)
printHtmlPart(12)
expressionOut.print(element?.fields?.price_per_unit ?: 0)
printHtmlPart(13)
expressionOut.print(element?.table ?: "ingredient")
printHtmlPart(14)
expressionOut.print(element?.row_id ?:0)
printHtmlPart(15)
expressionOut.print(element?.syncId ?: 0)
printHtmlPart(16)
createTagBody(2, {->
printHtmlPart(17)
expressionOut.print(createLink(controller: 'company',action: 'addIngredientCategory'))
printHtmlPart(18)
expressionOut.print(createLink(controller: 'company',action: 'addIngredientCategory'))
printHtmlPart(19)
expressionOut.print(createLink(controller: 'company',action: 'addMeasuramentUnit'))
printHtmlPart(20)
expressionOut.print(createLink(controller: 'company',action: 'addMeasuramentUnit'))
printHtmlPart(21)
expressionOut.print(createLink(controller: 'company',action: 'addMeasuramentUnit'))
printHtmlPart(22)
expressionOut.print(createLink(controller: 'company',action: 'addMeasuramentUnit'))
printHtmlPart(23)
expressionOut.print(createLink(controller: 'company',action: 'addTax'))
printHtmlPart(24)
expressionOut.print(createLink(controller: 'company',action: 'addTax'))
printHtmlPart(25)
expressionOut.print(element?.fields?.category_id)
printHtmlPart(26)
expressionOut.print(element?.fields?.unit_id)
printHtmlPart(27)
expressionOut.print(element?.fields?.unit_id)
printHtmlPart(28)
expressionOut.print(element?.fields?.price_per_unit ?: 0)
printHtmlPart(29)
expressionOut.print(element?.fields?.unit_id)
printHtmlPart(30)
expressionOut.print(createLink(controller: 'company',action: 'saveRow'))
printHtmlPart(31)
expressionOut.print(createLink(controller: 'company',action: 'fetchProperty'))
printHtmlPart(32)
})
invokeTag('script','r',421,[:],2)
printHtmlPart(1)
})
invokeTag('captureBody','sitemesh',421,[:],1)
printHtmlPart(33)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1402794527461L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}