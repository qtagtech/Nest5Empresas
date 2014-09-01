import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_nest5Empresas_layoutsmain_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/layouts/main.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',33,['gsp_sm_xmlClosingForEmptyTag':(""),'http-equiv':("Content-Type"),'content':("text/html; charset=UTF-8")],-1)
printHtmlPart(2)
invokeTag('captureMeta','sitemesh',34,['gsp_sm_xmlClosingForEmptyTag':(""),'http-equiv':("X-UA-Compatible"),'content':("IE=edge,chrome=1")],-1)
printHtmlPart(2)
createTagBody(2, {->
createTagBody(3, {->
invokeTag('layoutTitle','g',35,['default':("Nest5, Tu cupón de descuentos en las mejores Marcas")],-1)
})
invokeTag('captureTitle','sitemesh',35,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',35,[:],2)
printHtmlPart(2)
invokeTag('captureMeta','sitemesh',36,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("viewport"),'content':("width=device-width, initial-scale=1.0")],-1)
printHtmlPart(3)
expressionOut.print(resource(dir: 'images', file: 'favicon.ico'))
printHtmlPart(4)
expressionOut.print(resource(dir: 'images', file: 'apple-touch-icon.png'))
printHtmlPart(5)
expressionOut.print(resource(dir: 'images', file: 'apple-touch-icon-retina.png'))
printHtmlPart(6)
expressionOut.print(resource(dir: 'jquery-ui/css/ui-lightness', file: 'jquery-ui-1.10.3.custom.min.css'))
printHtmlPart(7)
expressionOut.print(resource(dir: 'css', file: 'style.css'))
printHtmlPart(8)
expressionOut.print(resource(dir:'css',file:'twitter-auth.css'))
printHtmlPart(9)
expressionOut.print(resource(dir: 'css', file: 'MyFontsWebfontsKit.css'))
printHtmlPart(10)
invokeTag('require','r',44,['modules':("jquerybrowserfix")],-1)
printHtmlPart(11)
invokeTag('captureMeta','sitemesh',45,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("robots"),'content':("no-index,no-follow")],-1)
printHtmlPart(12)
expressionOut.print(resource(dir: 'js/libs', file: 'modernizr-2.5.3-respond-1.1.0.min.js'))
printHtmlPart(13)
invokeTag('layoutHead','g',55,[:],-1)
printHtmlPart(14)
invokeTag('layoutResources','r',56,[:],-1)
printHtmlPart(15)
expressionOut.print(resource(dir: 'jquery-ui/js', file: 'jquery-ui-1.10.3.custom.min.js'))
printHtmlPart(16)
})
invokeTag('captureHead','sitemesh',58,[:],1)
printHtmlPart(17)
createTagBody(1, {->
printHtmlPart(18)
expressionOut.print(createLink(uri: "/user/account"))
printHtmlPart(19)
expressionOut.print(resource(dir:'images', file: 'logo.png'))
printHtmlPart(20)
invokeTag('layoutBody','g',68,[:],-1)
printHtmlPart(21)
expressionOut.print(createLink([uri: '/privacy']))
printHtmlPart(22)
expressionOut.print(resource(dir:'images', file: 'pinterest.png'))
printHtmlPart(23)
expressionOut.print(resource(dir:'images', file: 'facebook.png'))
printHtmlPart(24)
expressionOut.print(resource(dir:'images', file: 'twitter.png'))
printHtmlPart(25)
expressionOut.print(resource(dir:'images', file: 'phone.png'))
printHtmlPart(26)
invokeTag('javascript','g',93,['library':("application")],-1)
printHtmlPart(14)
invokeTag('javascript','g',93,['library':("plugins")],-1)
printHtmlPart(14)
invokeTag('javascript','g',93,['library':("script")],-1)
printHtmlPart(27)
invokeTag('layoutResources','r',100,[:],-1)
printHtmlPart(28)
expressionOut.print(createLink(controller: 'imageuploader', action: 'iconUpload'))
printHtmlPart(29)
})
invokeTag('captureBody','sitemesh',163,[:],1)
printHtmlPart(30)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1407989749232L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
