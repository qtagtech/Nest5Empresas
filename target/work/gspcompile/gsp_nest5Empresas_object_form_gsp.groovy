import com.nest5.Nest5Client.Object
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_nest5Empresas_object_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/object/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
expressionOut.print(hasErrors(bean: objectInstance, field: 'categories', 'error'))
printHtmlPart(1)
invokeTag('message','g',7,['code':("object.categories.label"),'default':("Categories")],-1)
printHtmlPart(2)
invokeTag('select','g',10,['name':("categories"),'from':(com.nest5.Nest5Client.Category.list()),'multiple':("multiple"),'optionKey':("id"),'size':("5"),'value':(objectInstance?.categories*.id),'class':("many-to-many")],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: objectInstance, field: 'description', 'error'))
printHtmlPart(4)
invokeTag('message','g',15,['code':("object.description.label"),'default':("Description")],-1)
printHtmlPart(2)
invokeTag('textField','g',18,['name':("description"),'value':(objectInstance?.description)],-1)
printHtmlPart(5)
expressionOut.print(objectInstance?.icon?.id)
printHtmlPart(6)
expressionOut.print(hasErrors(bean: objectInstance, field: 'name', 'error'))
printHtmlPart(7)
invokeTag('message','g',26,['code':("object.name.label"),'default':("Name")],-1)
printHtmlPart(2)
invokeTag('textField','g',27,['name':("name"),'value':(objectInstance?.name)],-1)
printHtmlPart(8)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1407989749273L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
