import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_nest5Empresas_loginauth_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/login/auth.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
createTagBody(2, {->
createClosureForHtmlPart(2, 3)
invokeTag('captureTitle','sitemesh',4,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',4,[:],2)
printHtmlPart(3)
invokeTag('captureMeta','sitemesh',6,['gsp_sm_xmlClosingForEmptyTag':(""),'charset':("utf-8")],-1)
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',7,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("viewport"),'content':("width=device-width, initial-scale=1.0, minimum-scale=1.0")],-1)
printHtmlPart(4)
expressionOut.print(resource(dir: 'dashboard/css/bootstrap', file: 'bootstrap.min.css'))
printHtmlPart(5)
expressionOut.print(resource(dir: 'dashboard/css/bootstrap', file: 'bootstrap_custom.css'))
printHtmlPart(6)
invokeTag('require','r',11,['module':("jquerybrowserfix")],-1)
printHtmlPart(7)
expressionOut.print(resource(dir: 'sky_forms/css', file: 'sky-forms.css'))
printHtmlPart(8)
expressionOut.print(resource(dir: 'sky_forms/css', file: 'sky-forms-ie8.css'))
printHtmlPart(9)
expressionOut.print(resource(dir: 'sky_forms/js', file: 'jquery.placeholder.min.js'))
printHtmlPart(10)
expressionOut.print(resource(dir: 'sky_forms/js', file: 'sky-forms-ie8.js'))
printHtmlPart(11)
invokeTag('layoutResources','r',24,[:],-1)
printHtmlPart(12)
})
invokeTag('captureHead','sitemesh',27,[:],1)
printHtmlPart(13)
createTagBody(1, {->
printHtmlPart(14)
expressionOut.print(postUrl)
printHtmlPart(15)
if(true && (flash.message)) {
printHtmlPart(16)
expressionOut.print(flash.message)
printHtmlPart(17)
}
printHtmlPart(18)
})
invokeTag('captureBody','sitemesh',72,[:],1)
printHtmlPart(19)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1402795868364L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
