import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_nest5Empresas_emailsinvite_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/emails/invite.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
createTagBody(2, {->
createTagBody(3, {->
expressionOut.print(user?.name)
printHtmlPart(2)
})
invokeTag('captureTitle','sitemesh',7,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',7,[:],2)
printHtmlPart(3)
invokeTag('captureMeta','sitemesh',8,['gsp_sm_xmlClosingForEmptyTag':("/"),'name':("viewport"),'content':("width=device-width, initial-scale=1.0")],-1)
printHtmlPart(4)
})
invokeTag('captureHead','sitemesh',614,[:],1)
printHtmlPart(1)
createTagBody(1, {->
printHtmlPart(5)
expressionOut.print(user?.name)
printHtmlPart(6)
expressionOut.print(grailsApplication.config.grails.serverURL)
printHtmlPart(7)
expressionOut.print(invitation?.id)
printHtmlPart(8)
expressionOut.print(picture)
printHtmlPart(9)
expressionOut.print(user?.name)
printHtmlPart(10)
expressionOut.print(grailsApplication.config.grails.serverURL)
printHtmlPart(7)
expressionOut.print(invitation?.id)
printHtmlPart(11)
expressionOut.print(grailsApplication.config.grails.serverURL)
printHtmlPart(7)
expressionOut.print(invitation?.id)
printHtmlPart(12)
expressionOut.print(user?.name)
printHtmlPart(13)
expressionOut.print(grailsApplication.config.grails.serverURL)
printHtmlPart(7)
expressionOut.print(invitation?.id)
printHtmlPart(14)
expressionOut.print(user?.name)
printHtmlPart(15)
expressionOut.print(grailsApplication.config.grails.serverURL)
printHtmlPart(7)
expressionOut.print(invitation?.id)
printHtmlPart(16)
})
invokeTag('captureBody','sitemesh',1099,['style':("background-color: #ffffff; font-family: 'Open Sans'; font-size: 12px; color: #4c595c; margin: 0;")],1)
printHtmlPart(17)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html'
public static final long LAST_MODIFIED = 1402794527502L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
