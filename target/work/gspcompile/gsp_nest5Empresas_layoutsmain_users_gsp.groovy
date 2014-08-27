import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_nest5Empresas_layoutsmain_users_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/layouts/main_users.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',8,['gsp_sm_xmlClosingForEmptyTag':(""),'http-equiv':("Content-Type"),'content':("text/html; charset=UTF-8")],-1)
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',9,['gsp_sm_xmlClosingForEmptyTag':(""),'http-equiv':("X-UA-Compatible"),'content':("IE=edge,chrome=1")],-1)
printHtmlPart(1)
createTagBody(2, {->
createTagBody(3, {->
invokeTag('layoutTitle','g',10,['default':("Nest5")],-1)
})
invokeTag('captureTitle','sitemesh',10,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',10,[:],2)
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',11,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("viewport"),'content':("width=device-width, initial-scale=1.0")],-1)
printHtmlPart(2)
expressionOut.print(resource(dir:'bootstrap/css', file: 'bootstrap.min.css'))
printHtmlPart(3)
expressionOut.print(resource(dir:'feed/css', file: 'main.css'))
printHtmlPart(4)
invokeTag('require','r',18,['module':("jquerybrowserfix")],-1)
printHtmlPart(5)
invokeTag('layoutResources','r',18,[:],-1)
printHtmlPart(6)
invokeTag('layoutHead','g',20,[:],-1)
printHtmlPart(7)
expressionOut.print(resource(dir:'feed/js', file: 'jquery.masonry.min.js'))
printHtmlPart(8)
expressionOut.print(resource(dir:'feed/js', file: 'script.js'))
printHtmlPart(8)
expressionOut.print(resource(dir:'feed/js', file: 'spin.min.js'))
printHtmlPart(9)
expressionOut.print(resource(dir: 'images', file: 'favicon.ico'))
printHtmlPart(10)
expressionOut.print(resource(dir: 'images', file: 'apple-touch-icon-57x57-precomposed.png'))
printHtmlPart(11)
expressionOut.print(resource(dir: 'images', file: 'apple-touch-icon-72x72-precomposed.png'))
printHtmlPart(12)
expressionOut.print(resource(dir: 'images', file: 'apple-touch-icon-114x114-precomposed.png'))
printHtmlPart(13)
})
invokeTag('captureHead','sitemesh',38,[:],1)
printHtmlPart(14)
createTagBody(1, {->
printHtmlPart(15)
expressionOut.print(userPicture)
printHtmlPart(16)
invokeTag('layoutBody','g',93,[:],-1)
printHtmlPart(17)
expressionOut.print(resource(dir: 'bootstrap/js', file: 'bootstrap.min.js'))
printHtmlPart(18)
invokeTag('javascript','g',118,['library':("application")],-1)
printHtmlPart(1)
invokeTag('layoutResources','r',118,[:],-1)
printHtmlPart(14)
})
invokeTag('captureBody','sitemesh',119,[:],1)
printHtmlPart(19)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1407989749244L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
