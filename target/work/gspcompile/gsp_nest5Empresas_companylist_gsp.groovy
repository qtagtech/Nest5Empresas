import com.nest5.Nest5Client.Company
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_nest5Empresas_companylist_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/company/list.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(1)
createTagBody(1, {->
printHtmlPart(2)
invokeTag('captureMeta','sitemesh',6,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main_users_new")],-1)
printHtmlPart(2)
invokeTag('set','g',7,['var':("entityName"),'value':(message(code: 'company.label', default: 'Company'))],-1)
printHtmlPart(2)
createTagBody(2, {->
createTagBody(3, {->
invokeTag('message','g',8,['code':("default.list.label"),'args':([entityName])],-1)
})
invokeTag('captureTitle','sitemesh',8,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',8,[:],2)
printHtmlPart(3)
})
invokeTag('captureHead','sitemesh',9,[:],1)
printHtmlPart(3)
createTagBody(1, {->
printHtmlPart(4)
invokeTag('message','g',11,['code':("default.link.skip.label"),'default':("Skip to content&hellip;")],-1)
printHtmlPart(5)
expressionOut.print(createLink(uri: '/'))
printHtmlPart(6)
invokeTag('message','g',14,['code':("default.home.label")],-1)
printHtmlPart(7)
createTagBody(2, {->
invokeTag('message','g',15,['code':("default.new.label"),'args':([entityName])],-1)
})
invokeTag('link','g',15,['class':("create"),'action':("create")],2)
printHtmlPart(8)
invokeTag('message','g',19,['code':("default.list.label"),'args':([entityName])],-1)
printHtmlPart(9)
if(true && (flash.message)) {
printHtmlPart(10)
expressionOut.print(flash.message)
printHtmlPart(11)
}
printHtmlPart(12)
invokeTag('sortableColumn','g',27,['property':("username"),'title':(message(code: 'company.username.label', default: 'Username'))],-1)
printHtmlPart(13)
invokeTag('sortableColumn','g',29,['property':("password"),'title':(message(code: 'company.password.label', default: 'Password'))],-1)
printHtmlPart(13)
invokeTag('sortableColumn','g',31,['property':("accountExpired"),'title':(message(code: 'company.accountExpired.label', default: 'Account Expired'))],-1)
printHtmlPart(13)
invokeTag('sortableColumn','g',33,['property':("accountLocked"),'title':(message(code: 'company.accountLocked.label', default: 'Account Locked'))],-1)
printHtmlPart(13)
invokeTag('sortableColumn','g',35,['property':("address"),'title':(message(code: 'company.address.label', default: 'Address'))],-1)
printHtmlPart(14)
invokeTag('message','g',37,['code':("company.category.label"),'default':("Category")],-1)
printHtmlPart(15)
loop:{
int i = 0
for( companyInstance in (companyInstanceList) ) {
printHtmlPart(16)
expressionOut.print((i % 2) == 0 ? 'even' : 'odd')
printHtmlPart(17)
createTagBody(3, {->
expressionOut.print(fieldValue(bean: companyInstance, field: "username"))
})
invokeTag('link','g',45,['action':("show"),'id':(companyInstance.id)],3)
printHtmlPart(18)
expressionOut.print(fieldValue(bean: companyInstance, field: "password"))
printHtmlPart(18)
invokeTag('formatBoolean','g',49,['boolean':(companyInstance.accountExpired)],-1)
printHtmlPart(18)
invokeTag('formatBoolean','g',51,['boolean':(companyInstance.accountLocked)],-1)
printHtmlPart(18)
expressionOut.print(fieldValue(bean: companyInstance, field: "address"))
printHtmlPart(18)
expressionOut.print(fieldValue(bean: companyInstance, field: "category"))
printHtmlPart(19)
i++
}
}
printHtmlPart(20)
invokeTag('paginate','g',62,['total':(companyInstanceTotal)],-1)
printHtmlPart(21)
})
invokeTag('captureBody','sitemesh',65,[:],1)
printHtmlPart(22)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1402794527488L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
