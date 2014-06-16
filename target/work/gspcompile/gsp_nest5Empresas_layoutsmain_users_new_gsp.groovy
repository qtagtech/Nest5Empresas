import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_nest5Empresas_layoutsmain_users_new_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/layouts/main_users_new.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',5,['gsp_sm_xmlClosingForEmptyTag':(""),'charset':("utf-8")],-1)
printHtmlPart(1)
createTagBody(2, {->
createClosureForHtmlPart(2, 3)
invokeTag('captureTitle','sitemesh',6,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',6,[:],2)
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',7,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("viewport"),'content':("width=device-width, initial-scale=1.0")],-1)
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',8,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("description"),'content':("")],-1)
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',9,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("author"),'content':("")],-1)
printHtmlPart(3)
expressionOut.print(resource(dir: 'dashboard/css/bootstrap', file: 'bootstrap.min.css'))
printHtmlPart(4)
expressionOut.print(resource(dir: 'dashboard/css/bootstrap', file: 'bootstrap_custom.css'))
printHtmlPart(5)
invokeTag('require','r',14,['module':("jquery")],-1)
printHtmlPart(1)
invokeTag('layoutResources','r',15,[:],-1)
printHtmlPart(1)
invokeTag('layoutHead','g',16,[:],-1)
printHtmlPart(6)
expressionOut.print(resource(dir: 'images', file: 'favicon.ico'))
printHtmlPart(7)
expressionOut.print(resource(dir: 'images', file: 'apple-touch-icon-57x57-precomposed.png'))
printHtmlPart(8)
expressionOut.print(resource(dir: 'images', file: 'apple-touch-icon-72x72-precomposed.png'))
printHtmlPart(9)
expressionOut.print(resource(dir: 'images', file: 'apple-touch-icon-114x114-precomposed.png'))
printHtmlPart(10)
})
invokeTag('captureHead','sitemesh',45,[:],1)
printHtmlPart(11)
createTagBody(1, {->
printHtmlPart(12)
expressionOut.print(createLink(uri: '/user/feed'))
printHtmlPart(13)
if(true && (vUser != null)) {
printHtmlPart(14)
expressionOut.print(createLink(controller: 'user', action: 'profile'))
printHtmlPart(15)
expressionOut.print(vUser?.name)
printHtmlPart(16)
expressionOut.print(createLink(controller: 'logout', action: 'index'))
printHtmlPart(17)
}
else {
printHtmlPart(18)
}
printHtmlPart(19)
invokeTag('layoutBody','g',67,[:],-1)
printHtmlPart(20)
expressionOut.print(resource(dir: 'dashboard/bootstrap', file: 'bootstrap.min.js'))
printHtmlPart(21)
expressionOut.print(createLink(controller: 'user', action: 'myBrands'))
printHtmlPart(22)
invokeTag('layoutResources','r',164,[:],-1)
printHtmlPart(23)
})
invokeTag('captureBody','sitemesh',166,[:],1)
printHtmlPart(24)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1402797147682L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
