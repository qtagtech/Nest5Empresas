import com.nest5.Nest5Client.Family
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_nest5Empresas_family_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/family/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
expressionOut.print(hasErrors(bean: familyInstance, field: 'description', 'error'))
printHtmlPart(1)
invokeTag('message','g',7,['code':("family.description.label"),'default':("Description")],-1)
printHtmlPart(2)
invokeTag('textField','g',10,['name':("description"),'value':(familyInstance?.description)],-1)
printHtmlPart(3)
expressionOut.print(familyInstance?.icon?.id)
printHtmlPart(4)
expressionOut.print(hasErrors(bean: familyInstance, field: 'name', 'error'))
printHtmlPart(5)
invokeTag('message','g',18,['code':("family.name.label"),'default':("Name")],-1)
printHtmlPart(2)
invokeTag('textField','g',19,['name':("name"),'value':(familyInstance?.name)],-1)
printHtmlPart(6)
expressionOut.print(hasErrors(bean: familyInstance, field: 'universe', 'error'))
printHtmlPart(7)
invokeTag('message','g',23,['code':("family.universe.label"),'default':("Universe")],-1)
printHtmlPart(8)
invokeTag('select','g',31,['id':("universe"),'name':("universe.id"),'from':(com.nest5.Nest5Client.Universe.list()),'optionKey':("id"),'required':(""),'value':(familyInstance?.universe?.id),'class':("many-to-one")],-1)
printHtmlPart(9)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1407989749185L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
