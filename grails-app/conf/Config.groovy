// locations to search for config files that get merged into the main config;
// config files can be ConfigSlurper scripts, Java properties files, or classes
// in the classpath in ConfigSlurper format

// grails.config.locations = [ "classpath:${appName}-config.properties",
//                             "classpath:${appName}-config.groovy",
//                             "file:${userHome}/.grails/${appName}-config.properties",
//                             "file:${userHome}/.grails/${appName}-config.groovy"]

// if (System.properties["${appName}.config.location"]) {
//    grails.config.locations << "file:" + System.properties["${appName}.config.location"]
// }

grails.project.groupId = appName // change this to alter the default package name and Maven publishing destination

// The ACCEPT header will not be used for content negotiation for user agents containing the following strings (defaults to the 4 major rendering engines)
grails.mime.disable.accept.header.userAgents = ['Gecko', 'WebKit', 'Presto', 'Trident']
grails.mime.types = [ // the first one is the default format
    all:           '*/*', // 'all' maps to '*' or the first available format in withFormat
    atom:          'application/atom+xml',
    css:           'text/css',
    csv:           'text/csv',
    form:          'application/x-www-form-urlencoded',
    html:          ['text/html','application/xhtml+xml'],
    js:            'text/javascript',
    json:          ['application/json', 'text/json'],
    multipartForm: 'multipart/form-data',
    rss:           'application/rss+xml',
    text:          'text/plain',
    hal:           ['application/hal+json','application/hal+xml'],
    xml:           ['text/xml', 'application/xml']
]

// URL Mapping Cache Max Size, defaults to 5000
//grails.urlmapping.cache.maxsize = 1000

// What URL patterns should be processed by the resources plugin
grails.resources.adhoc.patterns = ['/images/*', '/css/*', '/js/*', '/plugins/*']
grails.resources.adhoc.includes = ['/images/**', '/css/**', '/js/**', '/plugins/**']

// Legacy setting for codec used to encode data with ${}
grails.views.default.codec = "html"

// The default scope for controllers. May be prototype, session or singleton.
// If unspecified, controllers are prototype scoped.
grails.controllers.defaultScope = 'singleton'

// GSP settings
grails {
    views {
        gsp {
            encoding = 'UTF-8'
            htmlcodec = 'xml' // use xml escaping instead of HTML4 escaping
            codecs {
                expression = 'html' // escapes values inside ${}
                scriptlet = 'html' // escapes output from scriptlets in GSPs
                taglib = 'none' // escapes output from taglibs
                staticparts = 'none' // escapes output from static template parts
            }
        }
        // escapes all not-encoded output at final stage of outputting
        // filteringCodecForContentType.'text/html' = 'html'
    }
}


grails.converters.encoding = "UTF-8"
// scaffolding templates configuration
grails.scaffolding.templates.domainSuffix = 'Instance'

// Set to false to use the new Grails 1.2 JSONBuilder in the render method
grails.json.legacy.builder = false
// enabled native2ascii conversion of i18n properties files
grails.enable.native2ascii = true
// packages to include in Spring bean scanning
grails.spring.bean.packages = []
// whether to disable processing of multi part requests
grails.web.disable.multipart=false

// request parameters to mask when logging exceptions
grails.exceptionresolver.params.exclude = ['password']

// configure auto-caching of queries by default (if false you can cache individual queries with 'cache: true')
grails.hibernate.cache.queries = false

// configure passing transaction's read-only attribute to Hibernate session, queries and criterias
// set "singleSession = false" OSIV mode in hibernate configuration after enabling
grails.hibernate.pass.readonly = false
// configure passing read-only to OSIV session by default, requires "singleSession = false" OSIV mode
grails.hibernate.osiv.readonly = false

environments {
    development {
        grails.logging.jul.usebridge = true
        grails.serverURL = "http://hookthemapp.localhost.com:8080"
        grails.app.context = "/"
        grails.plugin.springsecurity.facebook.appId='171676339619557'
        grails.plugin.springsecurity.facebook.secret='c75f74270ce8dfdb455f05304fa68fc1'
        com.nest5.Nest5Client.bigDataServerURL = "http://hookthemapp.localhost.com:8090"
        com.nest5.Nest5Client.bigDataPath = "/Nest5BusinessData/"
    }
    staging{
        grails.logging.jul.usebridge = true
        grails.serverURL = "http://staging.nest5.com"
        grails.app.context = "/"
        grails.plugin.springsecurity.facebook.appId='171676339619557'
        grails.plugin.springsecurity.facebook.secret='c75f74270ce8dfdb455f05304fa68fc1'
        com.nest5.Nest5Client.bigDataServerURL = "http://bigdatastaging.nest5.com"
        com.nest5.Nest5Client.bigDataPath = "/"
    }
    production {
        grails.logging.jul.usebridge = true
        grails.serverURL = "http://www.nest5.com"
        grails.app.context = "/"
        grails.plugin.springsecurity.facebook.appId='550109801691585'
        grails.plugin.springsecurity.facebook.secret='513001ad6358dbb1cadedc820bd56b07'
        com.nest5.Nest5Client.bigDataServerURL = "http://bigdata.nest5.com"
        com.nest5.Nest5Client.bigDataPath = "/"

    }
}
//Email Server Configuration
grails {
    mail {
        host = "smtp.gmail.com"
        port = 465
        username = "multimedia@nest5.com"
        password = "farroyavefami"
        props = ["mail.smtp.auth":"true",
                 "mail.smtp.socketFactory.port":"465",
                 "mail.smtp.socketFactory.class":"javax.net.ssl.SSLSocketFactory",
                 "mail.smtp.socketFactory.fallback":"false"]
    }
}

// log4j configuration
log4j = {
    // Example of changing the log pattern for the default console appender:
    //
    //appenders {
    //    console name:'stdout', layout:pattern(conversionPattern: '%c{2} %m%n')
    //}

    error  'org.codehaus.groovy.grails.web.servlet',        // controllers
           'org.codehaus.groovy.grails.web.pages',          // GSP
           'org.codehaus.groovy.grails.web.sitemesh',       // layouts
           'org.codehaus.groovy.grails.web.mapping.filter', // URL mapping
           'org.codehaus.groovy.grails.web.mapping',        // URL mapping
           'org.codehaus.groovy.grails.commons',            // core / classloading
           'org.codehaus.groovy.grails.plugins',            // plugins
           'org.codehaus.groovy.grails.orm.hibernate',      // hibernate integration
           'org.springframework',
           'org.hibernate',
           'net.sf.ehcache.hibernate'
}



grails.plugin.springsecurity.controllerAnnotations.staticRules = [
	'/':                              ['permitAll'],
	'/index':                         ['permitAll'],
    '/posindex':                      ['permitAll'],
	'/index.gsp':                     ['permitAll'],
    '/posindex.gsp':                  ['permitAll'],
	'/**/js/**':                      ['permitAll'],
    '/**/js/dashboard/**':                      ['permitAll'],
	'/**/css/**':                     ['permitAll'],
	'/**/images/**':                  ['permitAll'],
    '/**/posfiles/**':                ['permitAll'],
    '/**/dashboard/**':               ['permitAll'],
    '/**/sky_forms/**':               ['permitAll'],
    '/company/**':                      ['ROLE_ADMIN'],
    '/company/dashboard/**':          ['ROLE_COMPANY'],
    '/company/addCombo/**':          ['ROLE_COMPANY'],
    '/company/addIngredient/**':          ['ROLE_COMPANY'],
    '/company/addIngredientCategory/**':          ['ROLE_COMPANY'],
    '/company/addMeasuramentUnit/**':          ['ROLE_COMPANY'],
    '/company/addProduct/**':          ['ROLE_COMPANY'],
    '/company/addProductCategory/**':          ['ROLE_COMPANY'],
    '/company/addTax/**':          ['ROLE_COMPANY'],
    '/company/combos/**':          ['ROLE_COMPANY'],
    '/company/devices/**':          ['ROLE_COMPANY'],
    '/company/editCombos/**':          ['ROLE_COMPANY'],
    '/company/editDevice/**':          ['ROLE_COMPANY'],
    '/company/editIngredient/**':          ['ROLE_COMPANY'],
    '/company/editIngredientCategory/**':          ['ROLE_COMPANY'],
    '/company/editProduct/**':          ['ROLE_COMPANY'],
    '/company/editProductCategory/**':          ['ROLE_COMPANY'],
    '/company/fetchProperty/**':          ['ROLE_COMPANY'],
    '/company/history/**':          ['ROLE_COMPANY'],
    '/company/information/**':          ['ROLE_COMPANY'],
    '/company/ingredientCategories/**':          ['ROLE_COMPANY'],
    '/company/ingredients/**':          ['ROLE_COMPANY'],
    '/company/invoice/**':          ['ROLE_COMPANY'],
    '/company/invoiceRequest/**':          ['ROLE_COMPANY'],
    '/company/invoices/**':          ['ROLE_COMPANY'],
    '/company/productCategories/**':          ['ROLE_COMPANY'],
    '/company/products/**':          ['ROLE_COMPANY'],
    '/company/report/**':          ['ROLE_COMPANY'],
    '/company/reportRequest/**':          ['ROLE_COMPANY'],
    '/company/saveDevice/**':          ['ROLE_COMPANY'],
    '/company/saveInfo/**':          ['ROLE_COMPANY'],
    '/company/saveRow/**':          ['ROLE_COMPANY'],
    '/company/tables/**':          ['ROLE_COMPANY'],
	'/**/favicon.ico':                ['permitAll'],
    '/api/**':                ['permitAll'],
    '/company/createSeller/**':     ['ROLE_COMPANY'],
    '/seller/saveFromCompany/**':     ['ROLE_COMPANY'],
    '/seller/**':           ['ROLE_ADMIN']



]



grails.plugin.springsecurity.facebook.domain.classname='com.nest5.Nest5Client.FacebookUser'



// Added by the Spring Security Core plugin:
grails.plugin.springsecurity.userLookup.userDomainClassName = 'com.nest5.Nest5Client.SecUser'
grails.plugin.springsecurity.userLookup.authorityJoinClassName = 'com.nest5.Nest5Client.SecUserSecRole'
grails.plugin.springsecurity.authority.className = 'com.nest5.Nest5Client.SecRole'


