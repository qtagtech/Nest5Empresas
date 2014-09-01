import com.nest5.Nest5Client.Seller
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_nest5Empresas_seller_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/seller/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
expressionOut.print(hasErrors(bean: sellerInstance, field: 'username', 'error'))
printHtmlPart(1)
invokeTag('message','g',7,['code':("seller.username.label"),'default':("Username")],-1)
printHtmlPart(2)
invokeTag('textField','g',10,['name':("username"),'required':(""),'value':(sellerInstance?.username)],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: sellerInstance, field: 'password', 'error'))
printHtmlPart(4)
invokeTag('message','g',16,['code':("seller.password.label"),'default':("Password")],-1)
printHtmlPart(2)
invokeTag('textField','g',19,['name':("password"),'required':(""),'value':(sellerInstance?.password)],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: sellerInstance, field: 'accountExpired', 'error'))
printHtmlPart(5)
invokeTag('message','g',25,['code':("seller.accountExpired.label"),'default':("Account Expired")],-1)
printHtmlPart(6)
invokeTag('checkBox','g',28,['name':("accountExpired"),'value':(sellerInstance?.accountExpired)],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: sellerInstance, field: 'accountLocked', 'error'))
printHtmlPart(7)
invokeTag('message','g',34,['code':("seller.accountLocked.label"),'default':("Account Locked")],-1)
printHtmlPart(6)
invokeTag('checkBox','g',37,['name':("accountLocked"),'value':(sellerInstance?.accountLocked)],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: sellerInstance, field: 'active', 'error'))
printHtmlPart(8)
invokeTag('message','g',43,['code':("seller.active.label"),'default':("Active")],-1)
printHtmlPart(6)
invokeTag('checkBox','g',46,['name':("active"),'value':(sellerInstance?.active)],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: sellerInstance, field: 'company', 'error'))
printHtmlPart(9)
invokeTag('message','g',52,['code':("seller.company.label"),'default':("Company")],-1)
printHtmlPart(2)
invokeTag('select','g',55,['id':("company"),'name':("company.id"),'from':(com.nest5.Nest5Client.Company.list()),'optionKey':("id"),'required':(""),'value':(sellerInstance?.company?.id),'class':("many-to-one")],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: sellerInstance, field: 'email', 'error'))
printHtmlPart(10)
invokeTag('message','g',61,['code':("seller.email.label"),'default':("Email")],-1)
printHtmlPart(2)
invokeTag('textField','g',64,['name':("email"),'required':(""),'value':(sellerInstance?.email)],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: sellerInstance, field: 'enabled', 'error'))
printHtmlPart(11)
invokeTag('message','g',70,['code':("seller.enabled.label"),'default':("Enabled")],-1)
printHtmlPart(6)
invokeTag('checkBox','g',73,['name':("enabled"),'value':(sellerInstance?.enabled)],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: sellerInstance, field: 'identification', 'error'))
printHtmlPart(12)
invokeTag('message','g',79,['code':("seller.identification.label"),'default':("Identification")],-1)
printHtmlPart(2)
invokeTag('textField','g',82,['name':("identification"),'required':(""),'value':(sellerInstance?.identification)],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: sellerInstance, field: 'name', 'error'))
printHtmlPart(13)
invokeTag('message','g',88,['code':("seller.name.label"),'default':("Name")],-1)
printHtmlPart(2)
invokeTag('textField','g',91,['name':("name"),'required':(""),'value':(sellerInstance?.name)],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: sellerInstance, field: 'passwordExpired', 'error'))
printHtmlPart(14)
invokeTag('message','g',97,['code':("seller.passwordExpired.label"),'default':("Password Expired")],-1)
printHtmlPart(6)
invokeTag('checkBox','g',100,['name':("passwordExpired"),'value':(sellerInstance?.passwordExpired)],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: sellerInstance, field: 'registerDate', 'error'))
printHtmlPart(15)
invokeTag('message','g',106,['code':("seller.registerDate.label"),'default':("Register Date")],-1)
printHtmlPart(2)
invokeTag('datePicker','g',109,['name':("registerDate"),'precision':("day"),'value':(sellerInstance?.registerDate)],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: sellerInstance, field: 'telephone', 'error'))
printHtmlPart(16)
invokeTag('message','g',115,['code':("seller.telephone.label"),'default':("Telephone")],-1)
printHtmlPart(2)
invokeTag('textField','g',118,['name':("telephone"),'required':(""),'value':(sellerInstance?.telephone)],-1)
printHtmlPart(17)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1407989749323L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
