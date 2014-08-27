import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_nest5Empresas_companyeditCombo_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/company/editCombo.gsp" }
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
invokeTag('require','r',18,['modules':("elastic,inputlimiter,maskedinput,bootstrapswitch,uniform,globalize,colorpicker,timentry,select2,duallistboxnew,duallistbox,bbq,formwizard,formvalidation")],-1)
printHtmlPart(6)
})
invokeTag('captureHead','sitemesh',18,[:],1)
printHtmlPart(7)
createTagBody(1, {->
printHtmlPart(8)
expressionOut.print(youarehere)
printHtmlPart(9)
expressionOut.print(youarehere)
printHtmlPart(10)
expressionOut.print(youarehere?: "Edición de Combo")
printHtmlPart(11)
expressionOut.print(element?.fields?.name ?: "Sin Nombre")
printHtmlPart(12)
expressionOut.print(element?.table ?: "combo")
printHtmlPart(13)
expressionOut.print(element?.row_id ?:0)
printHtmlPart(14)
expressionOut.print(element?.syncId ?: 0)
printHtmlPart(15)
createTagBody(2, {->
printHtmlPart(16)
for( ingrediente in (element?.fields?.ingredients) ) {
printHtmlPart(17)
expressionOut.print(ingrediente?.sync_id)
printHtmlPart(18)
expressionOut.print(ingrediente?.qty)
printHtmlPart(19)
expressionOut.print(ingrediente?.sync_id)
printHtmlPart(20)
expressionOut.print(ingrediente?.sync_id)
printHtmlPart(21)
}
printHtmlPart(22)
for( ingrediente in (element?.fields?.products) ) {
printHtmlPart(17)
expressionOut.print(ingrediente?.sync_id)
printHtmlPart(18)
expressionOut.print(ingrediente?.qty)
printHtmlPart(23)
}
printHtmlPart(24)
expressionOut.print(createLink(controller: 'company',action: 'addMeasuramentUnit'))
printHtmlPart(25)
expressionOut.print(createLink(controller: 'company',action: 'addMeasuramentUnit'))
printHtmlPart(26)
expressionOut.print(createLink(controller: 'company',action: 'addMeasuramentUnit'))
printHtmlPart(27)
expressionOut.print(createLink(controller: 'company',action: 'addMeasuramentUnit'))
printHtmlPart(28)
expressionOut.print(createLink(controller: 'company',action: 'addMeasuramentUnit'))
printHtmlPart(29)
expressionOut.print(createLink(controller: 'company',action: 'addTax'))
printHtmlPart(30)
expressionOut.print(createLink(controller: 'company',action: 'addTax'))
printHtmlPart(31)
expressionOut.print(createLink(controller: 'company',action: 'addIngredient'))
printHtmlPart(32)
expressionOut.print(createLink(controller: 'company',action: 'addIngredient'))
printHtmlPart(33)
for( ingrediente in (element?.fields?.ingredients) ) {
printHtmlPart(34)
expressionOut.print(ingrediente?.sync_id)
printHtmlPart(35)
}
printHtmlPart(36)
expressionOut.print(createLink(controller: 'company',action: 'addProduct'))
printHtmlPart(37)
expressionOut.print(createLink(controller: 'company',action: 'addProduct'))
printHtmlPart(38)
for( ingrediente in (element?.fields?.products) ) {
printHtmlPart(39)
expressionOut.print(ingrediente?.sync_id)
printHtmlPart(35)
}
printHtmlPart(40)
expressionOut.print(createLink(controller: 'company',action: 'saveRow'))
printHtmlPart(41)
expressionOut.print(createLink(controller: 'company',action: 'saveRow'))
printHtmlPart(42)
expressionOut.print(createLink(controller: 'company',action: 'fetchProperty'))
printHtmlPart(43)
})
invokeTag('script','r',564,[:],2)
printHtmlPart(1)
})
invokeTag('captureBody','sitemesh',565,[:],1)
printHtmlPart(44)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1407989749047L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
