import com.nest5.Nest5Client.Seller
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_nest5Empresas_sellershow_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/seller/show.gsp" }
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
invokeTag('set','g',7,['var':("entityName"),'value':(message(code: 'seller.label', default: 'Seller'))],-1)
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
invokeTag('link','g',15,['class':("list"),'action':("index")],2)
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
if(true && (sellerInstance?.username)) {
printHtmlPart(14)
invokeTag('message','g',28,['code':("seller.username.label"),'default':("Username")],-1)
printHtmlPart(15)
invokeTag('fieldValue','g',30,['bean':(sellerInstance),'field':("username")],-1)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (sellerInstance?.password)) {
printHtmlPart(18)
invokeTag('message','g',37,['code':("seller.password.label"),'default':("Password")],-1)
printHtmlPart(19)
invokeTag('fieldValue','g',39,['bean':(sellerInstance),'field':("password")],-1)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (sellerInstance?.accountExpired)) {
printHtmlPart(20)
invokeTag('message','g',46,['code':("seller.accountExpired.label"),'default':("Account Expired")],-1)
printHtmlPart(21)
invokeTag('formatBoolean','g',48,['boolean':(sellerInstance?.accountExpired)],-1)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (sellerInstance?.accountLocked)) {
printHtmlPart(22)
invokeTag('message','g',55,['code':("seller.accountLocked.label"),'default':("Account Locked")],-1)
printHtmlPart(23)
invokeTag('formatBoolean','g',57,['boolean':(sellerInstance?.accountLocked)],-1)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (sellerInstance?.active)) {
printHtmlPart(24)
invokeTag('message','g',64,['code':("seller.active.label"),'default':("Active")],-1)
printHtmlPart(25)
invokeTag('formatBoolean','g',66,['boolean':(sellerInstance?.active)],-1)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (sellerInstance?.company)) {
printHtmlPart(26)
invokeTag('message','g',73,['code':("seller.company.label"),'default':("Company")],-1)
printHtmlPart(27)
createTagBody(3, {->
expressionOut.print(sellerInstance?.company?.encodeAsHTML())
})
invokeTag('link','g',75,['controller':("company"),'action':("show"),'id':(sellerInstance?.company?.id)],3)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (sellerInstance?.email)) {
printHtmlPart(28)
invokeTag('message','g',82,['code':("seller.email.label"),'default':("Email")],-1)
printHtmlPart(29)
invokeTag('fieldValue','g',84,['bean':(sellerInstance),'field':("email")],-1)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (sellerInstance?.enabled)) {
printHtmlPart(30)
invokeTag('message','g',91,['code':("seller.enabled.label"),'default':("Enabled")],-1)
printHtmlPart(31)
invokeTag('formatBoolean','g',93,['boolean':(sellerInstance?.enabled)],-1)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (sellerInstance?.identification)) {
printHtmlPart(32)
invokeTag('message','g',100,['code':("seller.identification.label"),'default':("Identification")],-1)
printHtmlPart(33)
invokeTag('fieldValue','g',102,['bean':(sellerInstance),'field':("identification")],-1)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (sellerInstance?.name)) {
printHtmlPart(34)
invokeTag('message','g',109,['code':("seller.name.label"),'default':("Name")],-1)
printHtmlPart(35)
invokeTag('fieldValue','g',111,['bean':(sellerInstance),'field':("name")],-1)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (sellerInstance?.passwordExpired)) {
printHtmlPart(36)
invokeTag('message','g',118,['code':("seller.passwordExpired.label"),'default':("Password Expired")],-1)
printHtmlPart(37)
invokeTag('formatBoolean','g',120,['boolean':(sellerInstance?.passwordExpired)],-1)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (sellerInstance?.registerDate)) {
printHtmlPart(38)
invokeTag('message','g',127,['code':("seller.registerDate.label"),'default':("Register Date")],-1)
printHtmlPart(39)
invokeTag('formatDate','g',129,['date':(sellerInstance?.registerDate)],-1)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (sellerInstance?.telephone)) {
printHtmlPart(40)
invokeTag('message','g',136,['code':("seller.telephone.label"),'default':("Telephone")],-1)
printHtmlPart(41)
invokeTag('fieldValue','g',138,['bean':(sellerInstance),'field':("telephone")],-1)
printHtmlPart(16)
}
printHtmlPart(42)
createTagBody(2, {->
printHtmlPart(43)
createTagBody(3, {->
invokeTag('message','g',146,['code':("default.button.edit.label"),'default':("Edit")],-1)
})
invokeTag('link','g',146,['class':("edit"),'action':("edit"),'resource':(sellerInstance)],3)
printHtmlPart(44)
invokeTag('actionSubmit','g',147,['class':("delete"),'action':("delete"),'value':(message(code: 'default.button.delete.label', default: 'Delete')),'onclick':("return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');")],-1)
printHtmlPart(45)
})
invokeTag('form','g',149,['url':([resource:sellerInstance, action:'delete']),'method':("DELETE")],2)
printHtmlPart(46)
})
invokeTag('captureBody','sitemesh',151,[:],1)
printHtmlPart(47)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1407989749349L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
