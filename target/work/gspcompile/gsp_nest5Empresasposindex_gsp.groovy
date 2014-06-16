import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_nest5Empresasposindex_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/posindex.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',8,['gsp_sm_xmlClosingForEmptyTag':(""),'charset':("utf-8")],-1)
printHtmlPart(1)
createTagBody(2, {->
createClosureForHtmlPart(2, 3)
invokeTag('captureTitle','sitemesh',9,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',9,[:],2)
printHtmlPart(3)
invokeTag('captureMeta','sitemesh',15,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("description"),'content':("")],-1)
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',16,['gsp_sm_xmlClosingForEmptyTag':("/"),'content':("yes"),'name':("apple-mobile-web-app-capable")],-1)
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',17,['gsp_sm_xmlClosingForEmptyTag':("/"),'name':("viewport"),'content':("minimum-scale=1.0, width=device-width, maximum-scale=1, user-scalable=no")],-1)
printHtmlPart(4)
expressionOut.print(resource(dir:'posfiles/css',file:'bootstrap.min.css'))
printHtmlPart(5)
expressionOut.print(resource(dir:'posfiles/css',file:'font-awesome.min.css'))
printHtmlPart(5)
expressionOut.print(resource(dir:'posfiles/css',file:'flexslider.css'))
printHtmlPart(5)
expressionOut.print(resource(dir:'posfiles/css',file:'animate.css'))
printHtmlPart(5)
expressionOut.print(resource(dir:'posfiles/css',file:'prettyPhoto.css'))
printHtmlPart(6)
expressionOut.print(resource(dir:'posfiles/css',file:'main.css'))
printHtmlPart(7)
expressionOut.print(resource(dir: 'posfiles/img', file: 'favicon.ico'))
printHtmlPart(8)
expressionOut.print(resource(dir:'posfiles/js',file:'modernizr-2.6.2-respond-1.1.0.min.js'))
printHtmlPart(9)
})
invokeTag('captureHead','sitemesh',35,[:],1)
printHtmlPart(1)
createTagBody(1, {->
printHtmlPart(10)
expressionOut.print(message(code:'pos.menu.inicio', default:"Translating please change your browser language"))
printHtmlPart(11)
expressionOut.print(message(code:'pos.menu.nosotros', default:"Translating please change your browser language"))
printHtmlPart(12)
expressionOut.print(message(code:'pos.menu.servicios', default:"Translating please change your browser language"))
printHtmlPart(13)
expressionOut.print(message(code:'pos.menu.precio', default:"Translating please change your browser language"))
printHtmlPart(14)
expressionOut.print(message(code:'pos.menu.equipo', default:"Translating please change your browser language"))
printHtmlPart(15)
expressionOut.print(message(code:'pos.menu.contacto', default:"Translating please change your browser language"))
printHtmlPart(16)
expressionOut.print(message(code:'pos.menu.panel', default:"Translating please change your browser language"))
printHtmlPart(17)
expressionOut.print(message(code:'pos.intro.title', default:"Translating please change your browser language"))
printHtmlPart(18)
expressionOut.print(message(code:'pos.intro.text', default:"Translating please change your browser language"))
printHtmlPart(19)
expressionOut.print(resource(dir:'posfiles/img/slider',file:'1.png'))
printHtmlPart(20)
expressionOut.print(resource(dir:'posfiles/img/slider',file:'2.png'))
printHtmlPart(20)
expressionOut.print(resource(dir:'posfiles/img/slider',file:'3.png'))
printHtmlPart(21)
expressionOut.print(message(code:'pos.about.title', default:"Translating please change your browser language"))
printHtmlPart(22)
expressionOut.print(message(code:'pos.about.text', default:"Translating please change your browser language"))
printHtmlPart(23)
expressionOut.print(message(code:'pos.about.controltitle', default:"Translating please change your browser language"))
printHtmlPart(24)
expressionOut.print(message(code:'pos.about.controltext', default:"Translating please change your browser language"))
printHtmlPart(25)
expressionOut.print(message(code:'pos.about.controlback', default:"Translating please change your browser language"))
printHtmlPart(26)
expressionOut.print(message(code:'pos.about.botonhazlo', default:"Translating please change your browser language"))
printHtmlPart(27)
expressionOut.print(message(code:'pos.about.recibostitle', default:"Translating please change your browser language"))
printHtmlPart(24)
expressionOut.print(message(code:'pos.about.recibostext', default:"Translating please change your browser language"))
printHtmlPart(25)
expressionOut.print(message(code:'pos.about.recibosback', default:"Translating please change your browser language"))
printHtmlPart(28)
expressionOut.print(message(code:'pos.about.botonhazlo', default:"Translating please change your browser language"))
printHtmlPart(29)
expressionOut.print(message(code:'pos.about.reportestitle', default:"Translating please change your browser language"))
printHtmlPart(24)
expressionOut.print(message(code:'pos.about.reportestext', default:"Translating please change your browser language"))
printHtmlPart(25)
expressionOut.print(message(code:'pos.about.reportesback', default:"Translating please change your browser language"))
printHtmlPart(30)
expressionOut.print(message(code:'pos.about.botonhazlo', default:"Translating please change your browser language"))
printHtmlPart(31)
expressionOut.print(message(code:'pos.about.clientestitle', default:"Translating please change your browser language"))
printHtmlPart(24)
expressionOut.print(message(code:'pos.about.clientestext', default:"Translating please change your browser language"))
printHtmlPart(25)
expressionOut.print(message(code:'pos.about.clientesback', default:"Translating please change your browser language"))
printHtmlPart(32)
expressionOut.print(message(code:'pos.about.botonhazlo', default:"Translating please change your browser language"))
printHtmlPart(33)
expressionOut.print(message(code:'pos.facilidades.title', default:"Translating please change your browser language"))
printHtmlPart(34)
expressionOut.print(message(code:'pos.facilidades.disenotitle', default:"Translating please change your browser language"))
printHtmlPart(35)
expressionOut.print(message(code:'pos.facilidades.disenotext', default:"Translating please change your browser language"))
printHtmlPart(36)
expressionOut.print(message(code:'pos.facilidades.nubetitle', default:"Translating please change your browser language"))
printHtmlPart(35)
expressionOut.print(message(code:'pos.facilidades.nubetext', default:"Translating please change your browser language"))
printHtmlPart(37)
expressionOut.print(message(code:'pos.facilidades.conectividadtitle', default:"Translating please change your browser language"))
printHtmlPart(35)
expressionOut.print(message(code:'pos.facilidades.conectividadtext', default:"Translating please change your browser language"))
printHtmlPart(38)
expressionOut.print(message(code:'pos.facilidades.economicotitle', default:"Translating please change your browser language"))
printHtmlPart(35)
expressionOut.print(message(code:'pos.facilidades.economicotext', default:"Translating please change your browser language"))
printHtmlPart(39)
expressionOut.print(message(code:'pos.trabajo.title', default:"Translating please change your browser language"))
printHtmlPart(40)
expressionOut.print(message(code:'pos.trabajo.tazas', default:"Translating please change your browser language"))
printHtmlPart(41)
expressionOut.print(message(code:'pos.trabajo.horas', default:"Translating please change your browser language"))
printHtmlPart(42)
expressionOut.print(message(code:'pos.trabajo.almuerzos', default:"Translating please change your browser language"))
printHtmlPart(43)
expressionOut.print(message(code:'pos.trabajo.sonrisas', default:"Translating please change your browser language"))
printHtmlPart(44)
expressionOut.print(message(code:'pos.banner.text', default:"Translating please change your browser language"))
printHtmlPart(45)
expressionOut.print(message(code:'pos.banner.button', default:"Translating please change your browser language"))
printHtmlPart(46)
expressionOut.print(message(code:'pos.equipo.title', default:"Translating please change your browser language"))
printHtmlPart(47)
expressionOut.print(resource(dir:'posfiles/img/team',file:'1.png'))
printHtmlPart(48)
expressionOut.print(message(code:'pos.equipo.julian', default:"Translating please change your browser language"))
printHtmlPart(49)
expressionOut.print(resource(dir:'posfiles/img/team',file:'2.png'))
printHtmlPart(50)
expressionOut.print(message(code:'pos.equipo.juan', default:"Translating please change your browser language"))
printHtmlPart(51)
expressionOut.print(resource(dir:'posfiles/img/team',file:'3.png'))
printHtmlPart(52)
expressionOut.print(message(code:'pos.equipo.sebastian', default:"Translating please change your browser language"))
printHtmlPart(49)
expressionOut.print(resource(dir:'posfiles/img/team',file:'4.png'))
printHtmlPart(53)
expressionOut.print(message(code:'pos.equipo.sara', default:"Translating please change your browser language"))
printHtmlPart(54)
expressionOut.print(message(code:'pos.clientes.title', default:"Translating please change your browser language"))
printHtmlPart(55)
expressionOut.print(resource(dir:'posfiles/img/Our_Clients',file:'1.png'))
printHtmlPart(56)
expressionOut.print(message(code:'pos.clientes.perumix', default:"Translating please change your browser language"))
printHtmlPart(57)
expressionOut.print(resource(dir:'posfiles/img/Our_Clients',file:'2.png'))
printHtmlPart(56)
expressionOut.print(message(code:'pos.clientes.mrpastor', default:"Translating please change your browser language"))
printHtmlPart(58)
expressionOut.print(resource(dir:'posfiles/img/Our_Clients',file:'3.png'))
printHtmlPart(56)
expressionOut.print(message(code:'pos.clientes.dueamici', default:"Translating please change your browser language"))
printHtmlPart(59)
expressionOut.print(resource(dir:'posfiles/img/Our_Clients',file:'4.png'))
printHtmlPart(56)
expressionOut.print(message(code:'pos.clientes.espacio', default:"Translating please change your browser language"))
printHtmlPart(60)
expressionOut.print(message(code:'pos.contacto.nosotrostitle', default:"Translating please change your browser language"))
printHtmlPart(24)
expressionOut.print(message(code:'pos.contacto.nosotrostext', default:"Translating please change your browser language"))
printHtmlPart(61)
expressionOut.print(message(code:'pos.contacto.social', default:"Translating please change your browser language"))
printHtmlPart(62)
expressionOut.print(message(code:'pos.contacto.map', default:"Translating please change your browser language"))
printHtmlPart(63)
expressionOut.print(message(code:'pos.contacto.hello', default:"Translating please change your browser language"))
printHtmlPart(64)
expressionOut.print(message(code:'pos.contacto.nombre', default:"Translating please change your browser language"))
printHtmlPart(65)
expressionOut.print(message(code:'pos.contacto.correo', default:"Translating please change your browser language"))
printHtmlPart(66)
expressionOut.print(message(code:'pos.contacto.asunto', default:"Translating please change your browser language"))
printHtmlPart(67)
expressionOut.print(message(code:'pos.contacto.mensaje', default:"Translating please change your browser language"))
printHtmlPart(68)
expressionOut.print(message(code:'pos.contacto.button', default:"Translating please change your browser language"))
printHtmlPart(69)
expressionOut.print(message(code:'pos.contacto.invalid', default:"Translating please change your browser language"))
printHtmlPart(70)
expressionOut.print(message(code:'pos.footer.copy', default:"Translating please change your browser language"))
printHtmlPart(71)
expressionOut.print(resource(dir:'posfiles/js',file:'jquery-1.9.js'))
printHtmlPart(72)
expressionOut.print(resource(dir:'posfiles/js',file:'bootstrap.min.js'))
printHtmlPart(72)
expressionOut.print(resource(dir:'posfiles/js',file:'jquery.easing-1.3.pack.js'))
printHtmlPart(72)
expressionOut.print(resource(dir:'posfiles/js',file:'jquery.sticky.js'))
printHtmlPart(72)
expressionOut.print(resource(dir:'posfiles/js',file:'jquery.inview.js'))
printHtmlPart(72)
expressionOut.print(resource(dir:'posfiles/js',file:'jquery.flexslider-min.js'))
printHtmlPart(72)
expressionOut.print(resource(dir:'posfiles/js',file:'masonry.pkgd.min.js'))
printHtmlPart(72)
expressionOut.print(resource(dir:'posfiles/js',file:'jquery.mixitup.min.js'))
printHtmlPart(72)
expressionOut.print(resource(dir:'posfiles/js',file:'jquery.carouFredSel-6.2.1-packed.js'))
printHtmlPart(73)
expressionOut.print(resource(dir:'posfiles/js',file:'jquery.prettyPhoto.js'))
printHtmlPart(72)
expressionOut.print(resource(dir:'posfiles/js',file:'main.js'))
printHtmlPart(74)
})
invokeTag('captureBody','sitemesh',426,['data-spy':("scroll"),'data-target':("#sticktop"),'data-offset':("70")],1)
printHtmlPart(75)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1402794527571L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
