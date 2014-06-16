import com.nest5.Nest5Client.Company
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_nest5Empresas_companyshow_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/company/show.gsp" }
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
invokeTag('message','g',8,['code':("default.show.label"),'args':([entityName])],-1)
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
invokeTag('message','g',15,['code':("default.list.label"),'args':([entityName])],-1)
})
invokeTag('link','g',15,['class':("list"),'action':("list")],2)
printHtmlPart(8)
createTagBody(2, {->
invokeTag('message','g',16,['code':("default.new.label"),'args':([entityName])],-1)
})
invokeTag('link','g',16,['class':("create"),'action':("create")],2)
printHtmlPart(9)
invokeTag('message','g',20,['code':("default.show.label"),'args':([entityName])],-1)
printHtmlPart(10)
if(true && (flash.message)) {
printHtmlPart(11)
expressionOut.print(flash.message)
printHtmlPart(12)
}
printHtmlPart(13)
if(true && (companyInstance?.username)) {
printHtmlPart(14)
invokeTag('message','g',28,['code':("company.username.label"),'default':("Username")],-1)
printHtmlPart(15)
invokeTag('fieldValue','g',30,['bean':(companyInstance),'field':("username")],-1)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (companyInstance?.password)) {
printHtmlPart(18)
invokeTag('message','g',37,['code':("company.password.label"),'default':("Password")],-1)
printHtmlPart(19)
invokeTag('fieldValue','g',39,['bean':(companyInstance),'field':("password")],-1)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (companyInstance?.accountExpired)) {
printHtmlPart(20)
invokeTag('message','g',46,['code':("company.accountExpired.label"),'default':("Account Expired")],-1)
printHtmlPart(21)
invokeTag('formatBoolean','g',48,['boolean':(companyInstance?.accountExpired)],-1)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (companyInstance?.accountLocked)) {
printHtmlPart(22)
invokeTag('message','g',55,['code':("company.accountLocked.label"),'default':("Account Locked")],-1)
printHtmlPart(23)
invokeTag('formatBoolean','g',57,['boolean':(companyInstance?.accountLocked)],-1)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (companyInstance?.address)) {
printHtmlPart(24)
invokeTag('message','g',64,['code':("company.address.label"),'default':("Address")],-1)
printHtmlPart(25)
invokeTag('fieldValue','g',66,['bean':(companyInstance),'field':("address")],-1)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (companyInstance?.category)) {
printHtmlPart(26)
invokeTag('message','g',73,['code':("company.category.label"),'default':("Category")],-1)
printHtmlPart(27)
createTagBody(3, {->
expressionOut.print(companyInstance?.category?.encodeAsHTML())
})
invokeTag('link','g',75,['controller':("category"),'action':("show"),'id':(companyInstance?.category?.id)],3)
printHtmlPart(16)
}
printHtmlPart(28)
if(true && (companyInstance?.contactName)) {
printHtmlPart(29)
invokeTag('message','g',86,['code':("company.contactName.label"),'default':("Contact Name")],-1)
printHtmlPart(30)
invokeTag('fieldValue','g',88,['bean':(companyInstance),'field':("contactName")],-1)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (companyInstance?.email)) {
printHtmlPart(31)
invokeTag('message','g',95,['code':("company.email.label"),'default':("Email")],-1)
printHtmlPart(32)
invokeTag('fieldValue','g',97,['bean':(companyInstance),'field':("email")],-1)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (companyInstance?.enabled)) {
printHtmlPart(33)
invokeTag('message','g',104,['code':("company.enabled.label"),'default':("Enabled")],-1)
printHtmlPart(34)
invokeTag('formatBoolean','g',106,['boolean':(companyInstance?.enabled)],-1)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (companyInstance?.logo)) {
printHtmlPart(35)
invokeTag('message','g',113,['code':("company.logo.label"),'default':("Logo")],-1)
printHtmlPart(36)
invokeTag('fieldValue','g',115,['bean':(companyInstance),'field':("logo")],-1)
printHtmlPart(16)
}
printHtmlPart(37)
if(true && (companyInstance?.name)) {
printHtmlPart(38)
invokeTag('message','g',125,['code':("company.name.label"),'default':("Name")],-1)
printHtmlPart(39)
invokeTag('fieldValue','g',127,['bean':(companyInstance),'field':("name")],-1)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (companyInstance?.nit)) {
printHtmlPart(40)
invokeTag('message','g',134,['code':("company.nit.label"),'default':("Nit")],-1)
printHtmlPart(41)
invokeTag('fieldValue','g',136,['bean':(companyInstance),'field':("nit")],-1)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (companyInstance?.passwordExpired)) {
printHtmlPart(42)
invokeTag('message','g',143,['code':("company.passwordExpired.label"),'default':("Password Expired")],-1)
printHtmlPart(43)
invokeTag('formatBoolean','g',145,['boolean':(companyInstance?.passwordExpired)],-1)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (companyInstance?.registerDate)) {
printHtmlPart(44)
invokeTag('message','g',152,['code':("company.registerDate.label"),'default':("Register Date")],-1)
printHtmlPart(45)
invokeTag('formatDate','g',154,['date':(companyInstance?.registerDate)],-1)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (companyInstance?.telephone)) {
printHtmlPart(46)
invokeTag('message','g',161,['code':("company.telephone.label"),'default':("Telephone")],-1)
printHtmlPart(47)
invokeTag('fieldValue','g',163,['bean':(companyInstance),'field':("telephone")],-1)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (companyInstance?.url)) {
printHtmlPart(48)
invokeTag('message','g',170,['code':("company.url.label"),'default':("Url")],-1)
printHtmlPart(49)
invokeTag('fieldValue','g',172,['bean':(companyInstance),'field':("url")],-1)
printHtmlPart(16)
}
printHtmlPart(50)
createTagBody(2, {->
printHtmlPart(51)
invokeTag('hiddenField','g',180,['name':("id"),'value':(companyInstance?.id)],-1)
printHtmlPart(52)
createTagBody(3, {->
invokeTag('message','g',181,['code':("default.button.edit.label"),'default':("Edit")],-1)
})
invokeTag('link','g',181,['class':("edit"),'action':("edit"),'id':(companyInstance?.id)],3)
printHtmlPart(52)
invokeTag('actionSubmit','g',182,['class':("delete"),'action':("delete"),'value':(message(code: 'default.button.delete.label', default: 'Delete')),'onclick':("return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');")],-1)
printHtmlPart(53)
})
invokeTag('form','g',184,[:],2)
printHtmlPart(54)
})
invokeTag('captureBody','sitemesh',186,[:],1)
printHtmlPart(55)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1402794527497L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
