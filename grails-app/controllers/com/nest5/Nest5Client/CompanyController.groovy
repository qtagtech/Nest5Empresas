package com.nest5.Nest5Client

import com.nest5.Nest5Client.SecRole
import com.nest5.Nest5Client.SecUserSecRole
import grails.converters.JSON
import grails.transaction.Transactional
import groovy.time.TimeCategory
import groovyx.net.http.ContentType
import groovyx.net.http.HTTPBuilder
import groovyx.net.http.Method
import org.joda.time.format.DateTimeFormat
import org.joda.time.format.DateTimeFormatter
import org.springframework.dao.DataIntegrityViolationException

class CompanyController {
    def springSecurityService
    def userAgentIdentService
    def userService
    def companyService
    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    //def beforeInterceptor = [action:this.&registerDevice,except:'chat,clients,complementary,create,delete,demographics,edit,findCompanies,firstInteraction,index,interactions,list,manualSave,messages,messageUser,panel,save,selectUsers,show,showAllClients,showClients,showCompanies,update']

     //only admin
    def index() {
        redirect(action: "list", params: params)
    }

   //only admin
    def list() {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        [companyInstanceList: Company.list(params), companyInstanceTotal: Company.count()]
    }

    //only admin
    def create() {

        println "asca"
        [companyInstance: new Company(params)/*,promoInstance: new Promo(params)*/,storeInstance: new Store(params)]
    }

    //only admin
    def save() {
        //println(params.terms)

        if (params.terms != "accepted")
        {
            def data =  [errors: "1", errorType: "2",companyId: null, messages: [[id:13 , value: message(code: 'user.accept.terms', args: [],default: "You didn´t accept the terms and conditions.")]] ]
            render data  as JSON
            return
        }
        def cantUser = Company.countByEmail(params.email)

        if(cantUser > 0) {
            def data =  [errors: "1", errorType: "2",companyId: null, messages: [[id:3 , value: message(code: 'user.email.taken', args: [params.email],default: "The Email {0} is already registered.")]] ]
            render data  as JSON
            return
        }

        def user = new Company()
        user.properties = params
        def userRole = SecRole.findByAuthority('ROLE_COMPANY')
        userService.sendCompanyInitMail(user.email,user.name,user.address,user.telephone,user.contactName)

        user.username = params.email
        user.accountExpired = false
        user.enabled = true
        user.logo = "" //poner imagen de poner logo
        user.nit = "XXXXXXXX-X"

        if(user.save(flush: true))
        {
//            userService.sendWelcomeMail(user,randomString)  //Mandar correo a empresa
            SecUserSecRole.create user,userRole
            /*def referer = session.getAttribute("NEST5_REFERER")
            session.removeAttribute("NEST5_REFERER")
            if (referer)
            {
                def refCode =  RefCodes.findByCode(referer)
                if(refCode)
                {
                    def dummy = User.findByUsername("dummyNest5")
                    if(refCode.refered == dummy)
                    {
                        refCode.refered =  user
                        refCode.save(flush: true)
                        achievementsService.createAchievement("03_refe",refCode.referer)
                        //falta guardar un achievement al usuario que se registra con los 10 iniciales

                    }

                }
            }*/
            def data =  [errors: "0", errorType: "0",companyId: user.id, messages: [[id:4 , value: message(code: 'company.register.success', args: ["<h2>${user.name}</h2>"],default: "{0}, <br>Thank You!, Your brand's one step closer to getting ready with <b>Nest5</b><br>Continue with designing benefits for your customers: <br><br><button id='gosteptwo'>Go To Step 2</button>")] ] ]
            render data  as JSON
            return

        }
        else
        {
            def data =  [errors: "1", errorType: "1",companyId: null, messages: [id: "NA",value:  user.errors] ]
            render data  as JSON
            return
        }
    }
    @Transactional
    def manualSave() {
        def companyInstance = new Company(params)
        if (!companyInstance.save(flush: true)) {
            render(view: "create", model: [companyInstance: companyInstance])
            return
        }
          println companyInstance
        def companyRole = SecRole.findByAuthority('ROLE_COMPANY') ?: new SecRole(authority: 'ROLE_COMPANY').save(failOnError: true)
        if (!companyInstance.authorities.contains(companyRole)) {
            println "no teniar rol"
            SecUserSecRole.create companyInstance, companyRole
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'company.label', default: 'Company'), companyInstance.id])
        redirect(action: "show", id: companyInstance.id)
    }

//    @Secured(["ROLE_ADMIN"])
    def show() {
        def companyInstance = Company.get(params.id)
        if (!companyInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'company.label', default: 'Company'), params.id])
            redirect(action: "list")
            return
        }

        [companyInstance: companyInstance]
    }

//    @Secured(["ROLE_ADMIN"])
    def edit() {
        def companyInstance = Company.get(params.id)
        if (!companyInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'company.label', default: 'Company'), params.id])
            redirect(action: "list")
            return
        }

        [companyInstance: companyInstance]
    }

//    @Secured(["ROLE_ADMIN"])
    def update() {
        def companyInstance = Company.get(params.id)
        if (!companyInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'company.label', default: 'Company'), params.id])
            redirect(action: "list")
            return
        }

        if (params.version) {
            def version = params.version.toLong()
            if (companyInstance.version > version) {
                companyInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                        [message(code: 'company.label', default: 'Company')] as java.lang.Object[],
                        "Another user has updated this Company while you were editing")
                render(view: "edit", model: [companyInstance: companyInstance])
                return
            }
        }

        companyInstance.properties = params

        if (!companyInstance.save(flush: true)) {
            render(view: "edit", model: [companyInstance: companyInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'company.label', default: 'Company'), companyInstance.id])
        redirect(action: "show", id: companyInstance.id)
    }

//    @Secured(["ROLE_ADMIN"])
    def delete() {
        def companyInstance = Company.get(params.id)
        if (!companyInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'company.label', default: 'Company'), params.id])
            redirect(action: "list")
            return
        }

        try {
            companyInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'company.label', default: 'Company'), params.id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'company.label', default: 'Company'), params.id])
            redirect(action: "show", id: params.id)
        }
    }



//    @Secured(['ROLE_COMPANY'])
    def dashboard(){
        def user = springSecurityService.currentUser as Company
        def youarehere = "Dashboard"

        //Register Web as a device with the user id as device_id in the big data server
        /*try{
            registerDevice(user)

        }catch (Exception e){}*/  //If the is an error registering web panel as a device, it just goes on with the login process, it retries in other parts of the flow.

        [user: user,picture: companyService.companyImageUrl(user),youarehere: youarehere]
    }

//    @Secured(['ROLE_COMPANY'])
    def tables(){
        def user = springSecurityService.currentUser
        def youarehere = "Tablas Generales"
        [user: user,picture: companyService.companyImageUrl(user),youarehere: youarehere]
    }

    /*@Secured(['ROLE_COMPANY'])
    def datatable(){
        def user = springSecurityService.currentUser as Company
        def youarehere = "Tablas Generales"
        *//*try{
            registerDevice(user)
        }catch(Exception e){}*//*
        //check nest5 server since it hasn't synced
        def http = new HTTPBuilder( grailsApplication.config.com.nest5.Nest5Client.bigDataServerURL )
        def jsonData
        // perform a GET request, expecting JSON response data
        http.request( GET, TEXT ) {

            uri.path = grailsApplication.config.com.nest5.Nest5Client.bigDataPath+'databaseOps/allSales'
            uri.query = [company: user.id]
            println uri

            headers.'User-Agent' = 'Mozilla/5.0 Ubuntu/8.10 Firefox/3.0.4'

            // response handler for a success response code:
            response.success = { resp, json ->
                println resp.statusLine
                println resp.contentType

                // parse the JSON response object:
                jsonData = JSON.parse(json)
                println jsonData
            }

            // handler for any failure status code:
            response.failure = { resp,json ->
                println "Unexpected error: ${resp.statusLine.statusCode} : ${resp.statusLine.reasonPhrase}"
                //resp.setStatus(400)

                println JSON.parse(json)

                return
            }
        }
        //println jsonData
        if(jsonData?.status != 1){

        }
        [user: user,picture: companyService.companyImageUrl(user),youarehere: youarehere,sales: jsonData?.payload ?: []]

    }*/
//    @Secured(['ROLE_COMPANY'])
    def history(){
        def user = springSecurityService.currentUser as Company
        def youarehere = "Tablas Generales"
        /*try{
            registerDevice(user)
        }catch(Exception e){}*/
        //check nest5 server since it hasn't synced
        def http = new HTTPBuilder( grailsApplication.config.com.nest5.Nest5Client.bigDataServerURL )
        def jsonData
        // perform a GET request, expecting JSON response data
        http.request( Method.GET, ContentType.TEXT ) {
            uri.path = grailsApplication.config.com.nest5.Nest5Client.bigDataPath+'databaseOps/allSales'
            uri.query = [company: user.id]
            headers.'User-Agent' = 'Mozilla/5.0 Ubuntu/8.10 Firefox/3.0.4'
            // response handler for a success response code:
            response.success = { resp, json ->
                // parse the JSON response object:
                jsonData = ContentType.JSON.parse(json)
            }

            // handler for any failure status code:
            response.failure = { resp,json ->
                println "Unexpected error: ${resp.statusLine.statusCode} : ${resp.statusLine.reasonPhrase}"
                //resp.setStatus(400)
                println ContentType.JSON.parse(json)
                return
            }
        }
        //println jsonData
        if(jsonData?.status != 1){

        }
        [user: user,picture: companyService.companyImageUrl(user),youarehere: youarehere,sales: jsonData?.payload ?: []]

    }
//    @Secured(['ROLE_COMPANY'])
    def report(){
        def user = springSecurityService.currentUser as Company
        def youarehere = "Tablas Generales"
        /*try{
            registerDevice(user)
        }catch(Exception e){}*/
        //check nest5 server since it hasn't synced
        def http = new HTTPBuilder( grailsApplication.config.com.nest5.Nest5Client.bigDataServerURL )
        def jsonData
        // perform a GET request, expecting JSON response data
                 http.request( Method.GET, ContentType.TEXT ) {

            uri.path = grailsApplication.config.com.nest5.Nest5Client.bigDataPath+'databaseOps/zReport'
            uri.query = [company: user.id]


            headers.'User-Agent' = 'Mozilla/5.0 Ubuntu/8.10 Firefox/3.0.4'

            // response handler for a success response code:
            response.success = { resp, json ->


                // parse the JSON response object:
                jsonData = ContentType.JSON.parse(json)

            }

            // handler for any failure status code:
            response.failure = { resp,json ->
                println "Unexpected error: ${resp.statusLine.statusCode} : ${resp.statusLine.reasonPhrase}"
                println ContentType.JSON.parse(json)
                return
            }
        }
        if(jsonData?.status != 1){

        }
        [user: user,picture: companyService.companyImageUrl(user),youarehere: youarehere,data: jsonData?.pay ?: []]

    }
//    @Secured(['ROLE_COMPANY'])
    def invoices(){
        def user = springSecurityService.currentUser as Company
        def youarehere = "Detalle de Ventas"
        /*try{
            registerDevice(user)
        }catch(Exception e){}*/
        //check nest5 server since it hasn't synced
        def http = new HTTPBuilder( grailsApplication.config.com.nest5.Nest5Client.bigDataServerURL )
        def jsonData
        // perform a GET request, expecting JSON response data
        http.request( Method.GET, ContentType.TEXT ) {

            uri.path = grailsApplication.config.com.nest5.Nest5Client.bigDataPath+'databaseOps/saleDetails'
            uri.query = [company: user.id]
            println uri

            headers.'User-Agent' = 'Mozilla/5.0 Ubuntu/8.10 Firefox/3.0.4'

            // response handler for a success response code:
            response.success = { resp, json ->
                // parse the JSON response object:
                jsonData = ContentType.JSON.parse(json)
            }

            // handler for any failure status code:
            response.failure = { resp,json ->
                println "Unexpected error: ${resp.statusLine.statusCode} : ${resp.statusLine.reasonPhrase}"
                //resp.setStatus(400)
                println ContentType.JSON.parse(json)
                return
            }
        }
        //println jsonData
        if(jsonData?.status != 1){

        }
        [user: user,picture: companyService.companyImageUrl(user),youarehere: youarehere,data: jsonData?.payload ?: []]

    }
//    @Secured(['ROLE_COMPANY'])
    def invoice(){
        def user = springSecurityService.currentUser as Company
        def youarehere = "Factura de Ventas"
        def numb =  (params?.id ?: "0") as Integer
        def http = new HTTPBuilder( grailsApplication.config.com.nest5.Nest5Client.bigDataServerURL )
        def jsonData
        // perform a GET request, expecting JSON response data
        http.request( Method.GET, ContentType.TEXT ) {

            uri.path = grailsApplication.config.com.nest5.Nest5Client.bigDataPath+'databaseOps/fetchInvoice'
            uri.query = [company: user.id, invoice: numb]
            headers.'User-Agent' = 'Mozilla/5.0 Ubuntu/8.10 Firefox/3.0.4'
            response.success = { resp, json ->
                jsonData = ContentType.JSON.parse(json)
            }
            response.failure = { resp,json ->
                println "Unexpected error: ${resp.statusLine.statusCode} : ${resp.statusLine.reasonPhrase}"
                println ContentType.JSON.parse(json)
                return
            }
        }
        println jsonData
        if(jsonData?.status != 1){
        }
        [user: user,picture: companyService.companyImageUrl(user),youarehere: youarehere,data: jsonData?.payload ?: []]

    }
//    @Secured(['ROLE_COMPANY'])
    def reportRequest(){
        def user = springSecurityService.currentUser as Company
        def http = new HTTPBuilder( grailsApplication.config.com.nest5.Nest5Client.bigDataServerURL )
        def jsonData
        // perform a GET request, expecting JSON response data
        http.request( Method.GET, ContentType.TEXT ) {

            uri.path = grailsApplication.config.com.nest5.Nest5Client.bigDataPath+'databaseOps/zReport'
            uri.query = [company: user.id,reportDate: params?.reportDate]
            println uri

            headers.'User-Agent' = 'Mozilla/5.0 Ubuntu/8.10 Firefox/3.0.4'

            // response handler for a success response code:
            response.success = { resp, json ->
                //println resp.statusLine
                //println resp.contentType

                // parse the JSON response object:
                jsonData = ContentType.JSON.parse(json)
                //println jsonData
            }

            // handler for any failure status code:
            response.failure = { resp,json ->
                println "Unexpected error: ${resp.statusLine.statusCode} : ${resp.statusLine.reasonPhrase}"
                //resp.setStatus(400)

                println ContentType.JSON.parse(json)

                return
            }
        }
        //println jsonData
        if(jsonData?.status == 416){
            //empty result set
            def result = [status: 1,code: 0, message: "No hay registros en las fechas seleccionadas"]
            render result as JSON
            return
        }
        if(jsonData?.status != 200){
            def result = [status: 0,code: 0, message: "There was an error with the request"]
            render result as JSON
            return
        }
        def result = [status : 1,code: 1, data: jsonData?.pay ?: []]
        render result as JSON
        return

    }
//    @Secured(['ROLE_COMPANY'])
    def invoiceRequest(){
        def user = springSecurityService.currentUser as Company
        def http = new HTTPBuilder( grailsApplication.config.com.nest5.Nest5Client.bigDataServerURL )
        def jsonData
        // perform a GET request, expecting JSON response data
        http.request( Method.GET, ContentType.TEXT ) {

            uri.path = grailsApplication.config.com.nest5.Nest5Client.bigDataPath+'databaseOps/saleDetails'
            uri.query = [company: user.id,reportDate: params?.reportDate]
            println uri

            headers.'User-Agent' = 'Mozilla/5.0 Ubuntu/8.10 Firefox/3.0.4'

            // response handler for a success response code:
            response.success = { resp, json ->
                //println resp.statusLine
                //println resp.contentType

                // parse the JSON response object:
                jsonData = ContentType.JSON.parse(json)
                //println jsonData
            }

            // handler for any failure status code:
            response.failure = { resp,json ->
                println "Unexpected error: ${resp.statusLine.statusCode} : ${resp.statusLine.reasonPhrase}"
                //resp.setStatus(400)

                println ContentType.JSON.parse(json)

                return
            }
        }
        //println jsonData
        if(jsonData?.status == 416){
            //empty result set
            def result = [status: 1,code: 0, message: "No hay registros en las fechas seleccionadas"]
            render result as JSON
            return
        }
        if(jsonData?.status != 200){
            def result = [status: 0,code: 0, message: "There was an error with the request"]
            render result as JSON
            return
        }
        def result = [status : 1,code: 1, data: jsonData?.payload ?: []]
        render result as JSON
        return

    }

//    @Secured(["ROLE_COMPANY"])
    def ingredientCategories(){
        def user = springSecurityService.currentUser
        def youarehere = "Categor&iacute;as de Ingrediente"
        def http = new HTTPBuilder( grailsApplication.config.com.nest5.Nest5Client.bigDataServerURL )
        def jsonData
        def result
        http.request( Method.GET, ContentType.TEXT ) {
            uri.path = grailsApplication.config.com.nest5.Nest5Client.bigDataPath+'rowOps/fetchProperty'
            uri.query = [company:user.id,table: 'ingredient_category']
            headers.'User-Agent' = 'Mozilla/5.0 Ubuntu/8.10 Firefox/3.0.4'
            response.success = { resp, json ->
                jsonData = ContentType.JSON.parse(json)
            }
            response.failure = { resp,json ->
                println "Unexpected error: ${resp.statusLine.statusCode} : ${resp.statusLine.reasonPhrase}"
                println ContentType.JSON.parse(json)
                result = [status: 404, message: json]
            }
        }

        if(jsonData?.status != 200){
            result = [status: jsonData?.status, message: jsonData?.message]
        }
        result = [status: jsonData.status, elements: jsonData.payload]
        //println result
        DateTimeFormatter dtf = DateTimeFormat.forPattern("yyyy-MM-dd'T'HH:mm:ss'Z'");
        result.elements.each{
            it.timeCreated =   dtf.parseDateTime(it.timeCreated).toDate();
            it.timeReceived =   dtf.parseDateTime(it.timeReceived).toDate();
        }

        [user: user,picture: companyService.companyImageUrl(user),youarehere: youarehere,elements: result.elements]
    }
//    @Secured(["ROLE_COMPANY"])
    def productCategories(){
        def user = springSecurityService.currentUser
        def youarehere = "Categor&iacute;as de Producto"
        def http = new HTTPBuilder( grailsApplication.config.com.nest5.Nest5Client.bigDataServerURL )
        def jsonData
        def result
        http.request( Method.GET, ContentType.TEXT ) {
            uri.path = grailsApplication.config.com.nest5.Nest5Client.bigDataPath+'rowOps/fetchProperty'
            uri.query = [company:user.id,table: 'product_category']
            headers.'User-Agent' = 'Mozilla/5.0 Ubuntu/8.10 Firefox/3.0.4'
            response.success = { resp, json ->
                jsonData = ContentType.JSON.parse(json)
            }
            response.failure = { resp,json ->
                println "Unexpected error: ${resp.statusLine.statusCode} : ${resp.statusLine.reasonPhrase}"
                println ContentType.JSON.parse(json)
                result = [status: 404, message: json]
            }
        }

        if(jsonData?.status != 200){
            result = [status: jsonData?.status, message: jsonData?.message]
        }
        result = [status: jsonData.status, elements: jsonData.payload]
        //println result
        DateTimeFormatter dtf = DateTimeFormat.forPattern("yyyy-MM-dd'T'HH:mm:ss'Z'");
        result.elements.each{
            it.timeCreated =   dtf.parseDateTime(it.timeCreated).toDate();
            it.timeReceived =   dtf.parseDateTime(it.timeReceived).toDate();
        }

        [user: user,picture: companyService.companyImageUrl(user),youarehere: youarehere,elements: result.elements]
    }
//    @Secured(["ROLE_COMPANY"])
    def ingredients(){
        def user = springSecurityService.currentUser
        def youarehere = "Todos los Ingredients"
        def http = new HTTPBuilder( grailsApplication.config.com.nest5.Nest5Client.bigDataServerURL )
        def jsonData
        def result
        http.request( Method.GET, ContentType.TEXT ) {
            uri.path = grailsApplication.config.com.nest5.Nest5Client.bigDataPath+'rowOps/fetchProperty'
            uri.query = [company:user.id,table: 'ingredient']
            headers.'User-Agent' = 'Mozilla/5.0 Ubuntu/8.10 Firefox/3.0.4'
            response.success = { resp, json ->
                jsonData = ContentType.JSON.parse(json)
            }
            response.failure = { resp,json ->
                println "Unexpected error: ${resp.statusLine.statusCode} : ${resp.statusLine.reasonPhrase}"
                println ContentType.JSON.parse(json)
                result = [status: 404, message: json]
            }
        }

        if(jsonData?.status != 200){
            result = [status: jsonData?.status, message: jsonData?.message]
        }
        result = [status: jsonData.status, elements: jsonData.payload]
        //println result
        DateTimeFormatter dtf = DateTimeFormat.forPattern("yyyy-MM-dd'T'HH:mm:ss'Z'");
        result.elements.each{
            it.timeCreated =   dtf.parseDateTime(it.timeCreated).toDate();
            it.timeReceived =   dtf.parseDateTime(it.timeReceived).toDate();
        }
        //println result
        [user: user,picture: companyService.companyImageUrl(user),youarehere: youarehere,elements: result.elements]
    }
//    @Secured(["ROLE_COMPANY"])
    def products(){
        def user = springSecurityService.currentUser
        def youarehere = "Todos los Productos"
        def http = new HTTPBuilder( grailsApplication.config.com.nest5.Nest5Client.bigDataServerURL )
        def jsonData
        def result
        http.request( Method.GET, ContentType.TEXT ) {
            uri.path = grailsApplication.config.com.nest5.Nest5Client.bigDataPath+'rowOps/fetchProperty'
            uri.query = [company:user.id,table: 'product']
            headers.'User-Agent' = 'Mozilla/5.0 Ubuntu/8.10 Firefox/3.0.4'
            response.success = { resp, json ->
                jsonData = ContentType.JSON.parse(json)
            }
            response.failure = { resp,json ->
                println "Unexpected error: ${resp.statusLine.statusCode} : ${resp.statusLine.reasonPhrase}"
                println ContentType.JSON.parse(json)
                result = [status: 404, message: json]
            }
        }

        if(jsonData?.status != 200){
            result = [status: jsonData?.status, message: jsonData?.message]
        }
        result = [status: jsonData.status, elements: jsonData.payload]
        //println result
        DateTimeFormatter dtf = DateTimeFormat.forPattern("yyyy-MM-dd'T'HH:mm:ss'Z'");
        result.elements.each{
            it.timeCreated =   dtf.parseDateTime(it.timeCreated).toDate();
            it.timeReceived =   dtf.parseDateTime(it.timeReceived).toDate();
        }
        //println result
        [user: user,picture: companyService.companyImageUrl(user),youarehere: youarehere,elements: result.elements]
    }

//    @Secured(["ROLE_COMPANY"])
    def combos(){
        def user = springSecurityService.currentUser
        def youarehere = "Todos los Combos"
        def http = new HTTPBuilder( grailsApplication.config.com.nest5.Nest5Client.bigDataServerURL )
        def jsonData
        def result
        http.request( Method.GET, ContentType.TEXT ) {
            uri.path = grailsApplication.config.com.nest5.Nest5Client.bigDataPath+'rowOps/fetchProperty'
            uri.query = [company:user.id,table: 'combo']
            headers.'User-Agent' = 'Mozilla/5.0 Ubuntu/8.10 Firefox/3.0.4'
            response.success = { resp, json ->
                jsonData = ContentType.JSON.parse(json)
            }
            response.failure = { resp,json ->
                println "Unexpected error: ${resp.statusLine.statusCode} : ${resp.statusLine.reasonPhrase}"
                println ContentType.JSON.parse(json)
                result = [status: 404, message: json]
            }
        }

        if(jsonData?.status != 200){
            result = [status: jsonData?.status, message: jsonData?.message]
        }
        result = [status: jsonData.status, elements: jsonData.payload]
        //println result
        DateTimeFormatter dtf = DateTimeFormat.forPattern("yyyy-MM-dd'T'HH:mm:ss'Z'");
        result.elements.each{
            it.timeCreated =   dtf.parseDateTime(it.timeCreated).toDate();
            it.timeReceived =   dtf.parseDateTime(it.timeReceived).toDate();
        }
        //println result
        [user: user,picture: companyService.companyImageUrl(user),youarehere: youarehere,elements: result.elements]
    }

//    @Secured(["ROLE_COMPANY"])
    def devices(){
        def user = springSecurityService.currentUser
        def youarehere = "Dispositivos P.O.S Registrados"
        def http = new HTTPBuilder( grailsApplication.config.com.nest5.Nest5Client.bigDataServerURL )
        def jsonData
        def result
        http.request( Method.GET, ContentType.TEXT ) {
            uri.path = grailsApplication.config.com.nest5.Nest5Client.bigDataPath+'deviceOps/fetchDevices'
            uri.query = [company:user.id]
            headers.'User-Agent' = 'Mozilla/5.0 Ubuntu/8.10 Firefox/3.0.4'
            response.success = { resp, json ->
                jsonData = ContentType.JSON.parse(json)
            }
            response.failure = { resp,json ->
                println "Unexpected error: ${resp.statusLine.statusCode} : ${resp.statusLine.reasonPhrase}"
                println ContentType.JSON.parse(json)
                result = [status: 404, message: json]
            }
        }

        if(jsonData?.status != 200){
            result = [status: jsonData?.status, message: jsonData?.message]
        }
        result = [status: jsonData.status, elements: jsonData.payload]
        //println result
        DateTimeFormatter dtf = DateTimeFormat.forPattern("yyyy-MM-dd'T'HH:mm:ss'Z'");
        result.elements.each{
            it.registeredOn =   dtf.parseDateTime(it.registeredOn).toDate();
        }
        println result
        [user: user,picture: companyService.companyImageUrl(user),youarehere: youarehere,elements: result.elements]
    }
    //

//    @Secured(["ROLE_COMPANY"])
    def addIngredientCategory(){
        def user = springSecurityService.currentUser
        def youarehere = "Agregar Categor&iacute;a de Ingrediente"
        [user: user,picture: companyService.companyImageUrl(user),youarehere: youarehere]
    }
//    @Secured(["ROLE_COMPANY"])
    def addProductCategory(){
        def user = springSecurityService.currentUser
        def youarehere = "Agregar Categor&iacute;a de Producto"
        [user: user,picture: companyService.companyImageUrl(user),youarehere: youarehere]
    }
//    @Secured(["ROLE_COMPANY"])
    def addTax(){
        def user = springSecurityService.currentUser
        def youarehere = "Agregar Impuesto de Ventas / Consumo"
        [user: user,picture: companyService.companyImageUrl(user),youarehere: youarehere]
    }
//    @Secured(["ROLE_COMPANY"])
    def addMeasuramentUnit(){
        def user = springSecurityService.currentUser
        def youarehere = "Agregar Unidad de Medida"
        [user: user,picture: companyService.companyImageUrl(user),youarehere: youarehere]
    }
//    @Secured(["ROLE_COMPANY"])
    def addIngredient(){
        def user = springSecurityService.currentUser
        def youarehere = "Agregar Ingrediente"


        [user: user,picture: companyService.companyImageUrl(user),youarehere: youarehere]
    }
//    @Secured(["ROLE_COMPANY"])
    def addProduct(){
        def user = springSecurityService.currentUser
        def youarehere = "Agregar Producto"


        [user: user,picture: companyService.companyImageUrl(user),youarehere: youarehere]
    }
//    @Secured(["ROLE_COMPANY"])
    def addCombo(){
        def user = springSecurityService.currentUser
        def youarehere = "Agregar Combo"


        [user: user,picture: companyService.companyImageUrl(user),youarehere: youarehere]
    }

//    @Secured(["ROLE_COMPANY"])
    def information(){
        def user = springSecurityService.currentUser
        def youarehere = "Información de Empresa"

        [user: user,picture: companyService.companyImageUrl(user),youarehere: youarehere]
    }


    //EDIT OBJECTS
//    @Secured(["ROLE_COMPANY"])
    def editIngredientCategory(Long id){
        def user = springSecurityService.currentUser
        def http = new HTTPBuilder( grailsApplication.config.com.nest5.Nest5Client.bigDataServerURL )
        def jsonData
        def result
        http.request( Method.GET, ContentType.TEXT ) {
            uri.path = grailsApplication.config.com.nest5.Nest5Client.bigDataPath+'rowOps/fetchRow'
            uri.query = [company:user.id,row: id]
            headers.'User-Agent' = 'Mozilla/5.0 Ubuntu/8.10 Firefox/3.0.4'
            response.success = { resp, json ->
                jsonData = ContentType.JSON.parse(json)
                println jsonData
            }
            response.failure = { resp,json ->
                println "Unexpected error: ${resp.statusLine.statusCode} : ${resp.statusLine.reasonPhrase}"
                println ContentType.JSON.parse(json)
                result = [status: 404, message: json]
            }
        }

        if(jsonData?.status != 200){
            result = [status: jsonData?.status, message: jsonData?.message]
        }
        result = [status: jsonData.status, element: jsonData.payload]
        //println result
        def youarehere = "Editando Categoría de Ingrediente: "+result?.element?.fields?.name
        println result
        [user: user,picture: companyService.companyImageUrl(user),youarehere: youarehere,element: result.element]
    }
//    @Secured(["ROLE_COMPANY"])
    def editProductCategory(Long id){
        def user = springSecurityService.currentUser
        def http = new HTTPBuilder( grailsApplication.config.com.nest5.Nest5Client.bigDataServerURL )
        def jsonData
        def result
        http.request( Method.GET, ContentType.TEXT ) {
            uri.path = grailsApplication.config.com.nest5.Nest5Client.bigDataPath+'rowOps/fetchRow'
            uri.query = [company:user.id,row: id]
            headers.'User-Agent' = 'Mozilla/5.0 Ubuntu/8.10 Firefox/3.0.4'
            response.success = { resp, json ->
                jsonData = ContentType.JSON.parse(json)
                println jsonData
            }
            response.failure = { resp,json ->
                println "Unexpected error: ${resp.statusLine.statusCode} : ${resp.statusLine.reasonPhrase}"
                println ContentType.JSON.parse(json)
                result = [status: 404, message: json]
            }
        }

        if(jsonData?.status != 200){
            result = [status: jsonData?.status, message: jsonData?.message]
        }
        result = [status: jsonData.status, element: jsonData.payload]
        //println result
        def youarehere = "Editando Categoría de Producto: "+result?.element?.fields?.name
        [user: user,picture: companyService.companyImageUrl(user),youarehere: youarehere,element: result.element]
    }
//    @Secured(["ROLE_COMPANY"])
    def editIngredient(Long id){
        //
        def user = springSecurityService.currentUser
        def http = new HTTPBuilder( grailsApplication.config.com.nest5.Nest5Client.bigDataServerURL )
        def jsonData
        def result
        http.request( Method.GET, ContentType.TEXT ) {
            uri.path = grailsApplication.config.com.nest5.Nest5Client.bigDataPath+'rowOps/fetchRow'
            uri.query = [company:user.id,row: id]
            headers.'User-Agent' = 'Mozilla/5.0 Ubuntu/8.10 Firefox/3.0.4'
            response.success = { resp, json ->
                jsonData = ContentType.JSON.parse(json)
                println jsonData
            }
            response.failure = { resp,json ->
                println "Unexpected error: ${resp.statusLine.statusCode} : ${resp.statusLine.reasonPhrase}"
                println ContentType.JSON.parse(json)
                result = [status: 404, message: json]
            }
        }

        if(jsonData?.status != 200){
            result = [status: jsonData?.status, message: jsonData?.message]
        }
        result = [status: jsonData.status, element: jsonData.payload]
        //println result
        def youarehere = "Editando Ingrediente: "+result?.element?.fields?.name
        [user: user,picture: companyService.companyImageUrl(user),youarehere: youarehere,element: result.element]
    }
//    @Secured(["ROLE_COMPANY"])
    def editProduct(Long id){
        //
        def user = springSecurityService.currentUser
        def http = new HTTPBuilder( grailsApplication.config.com.nest5.Nest5Client.bigDataServerURL )
        def jsonData
        def result
        http.request( Method.GET, ContentType.TEXT ) {
            uri.path = grailsApplication.config.com.nest5.Nest5Client.bigDataPath+'rowOps/fetchRow'
            uri.query = [company:user.id,row: id]
            headers.'User-Agent' = 'Mozilla/5.0 Ubuntu/8.10 Firefox/3.0.4'
            response.success = { resp, json ->
                jsonData = ContentType.JSON.parse(json)
            }
            response.failure = { resp,json ->
                result = [status: 404, message: json]
            }
        }

        if(jsonData?.status != 200){
            result = [status: jsonData?.status, message: jsonData?.message]
        }
        //check if it is a special_product and bring the syncId

        def jsonData2
        def result2
        http.request( Method.GET, ContentType.TEXT ) {
            uri.path = grailsApplication.config.com.nest5.Nest5Client.bigDataPath+'rowOps/fetchSpecialRow'
            uri.query = [company:user.id,row: id]
            headers.'User-Agent' = 'Mozilla/5.0 Ubuntu/8.10 Firefox/3.0.4'
            response.success = { resp, json ->
                jsonData2 = ContentType.JSON.parse(json)
            }
            response.failure = { resp,json ->
                println "Unexpected error: ${resp.statusLine.statusCode} : ${resp.statusLine.reasonPhrase}"
                println ContentType.JSON.parse(json)
                result = [status: 404, message: json]
            }
        }


        result = [status: jsonData.status, element: jsonData.payload]

        //println result
        def youarehere = "Editando Producto: "+result?.element?.fields?.name
        [user: user,picture: companyService.companyImageUrl(user),youarehere: youarehere,element: result.element,special: jsonData2?.payload?.syncId]
    }
//    @Secured(["ROLE_COMPANY"])
    def editCombo(Long id){
        def user = springSecurityService.currentUser
        def http = new HTTPBuilder( grailsApplication.config.com.nest5.Nest5Client.bigDataServerURL )
        def jsonData
        def result
        http.request( Method.GET, ContentType.TEXT ) {
            uri.path = grailsApplication.config.com.nest5.Nest5Client.bigDataPath+'rowOps/fetchRow'
            uri.query = [company:user.id,row: id]
            headers.'User-Agent' = 'Mozilla/5.0 Ubuntu/8.10 Firefox/3.0.4'
            response.success = { resp, json ->
                jsonData = ContentType.JSON.parse(json)
            }
            response.failure = { resp,json ->
                println "Unexpected error: ${resp.statusLine.statusCode} : ${resp.statusLine.reasonPhrase}"
                println ContentType.JSON.parse(json)
                result = [status: 404, message: json]
            }
        }

        if(jsonData?.status != 200){
            result = [status: jsonData?.status, message: jsonData?.message]
        }



        result = [status: jsonData.status, element: jsonData.payload]

        //println result
        def youarehere = "Editando Combo: "+result?.element?.fields?.name
        [user: user,picture: companyService.companyImageUrl(user),youarehere: youarehere,element: result.element]
    }
//    @Secured(["ROLE_COMPANY"])
    def editDevice(String id){
        //
        def user = springSecurityService.currentUser
        def http = new HTTPBuilder( grailsApplication.config.com.nest5.Nest5Client.bigDataServerURL )
        def jsonData
        def result
        http.request( Method.GET, ContentType.TEXT ) {
            uri.path = grailsApplication.config.com.nest5.Nest5Client.bigDataPath+'deviceOps/fetchDevice'
            uri.query = [company:user.id,row: id]
            println uri.query
            headers.'User-Agent' = 'Mozilla/5.0 Ubuntu/8.10 Firefox/3.0.4'
            response.success = { resp, json ->
                jsonData = ContentType.JSON.parse(json)
                println jsonData
            }
            response.failure = { resp,json ->
                println "Unexpected error: ${resp.statusLine.statusCode} : ${resp.statusLine.reasonPhrase}"
                println ContentType.JSON.parse(json)
                result = [status: 404, message: json]
            }
        }

        if(jsonData?.status != 200){
            result = [status: jsonData?.status, message: jsonData?.message]
        }



        result = [status: jsonData.status, element: jsonData.payload]
        DateTimeFormatter dtf = DateTimeFormat.forPattern("yyyy-MM-dd'T'HH:mm:ss'Z'");
        result?.element?.registeredOn =   dtf.parseDateTime(result?.element?.registeredOn).toDate();

        def youarehere = "Editando Dispositivo: "+result?.element?.name ?: "Sin Nombre"
        [user: user,picture: companyService.companyImageUrl(user),youarehere: youarehere,element: result.element]
    }


//    @Secured(["ROLE_COMPANY"])
    def fetchProperty(){
        def user = springSecurityService.currentUser as Company
        def http = new HTTPBuilder( grailsApplication.config.com.nest5.Nest5Client.bigDataServerURL )
        def jsonData
        // perform a GET request, expecting JSON response data
        http.request( Method.GET, ContentType.TEXT ) {

            uri.path = grailsApplication.config.com.nest5.Nest5Client.bigDataPath+'rowOps/fetchProperty'
            uri.query = [company:user.id,table: params?.table]
            //println uri

            headers.'User-Agent' = 'Mozilla/5.0 Ubuntu/8.10 Firefox/3.0.4'

            // response handler for a success response code:
            response.success = { resp, json ->
                jsonData = ContentType.JSON.parse(json)
            }

            // handler for any failure status code:
            response.failure = { resp,json ->
                println "Unexpected error: ${resp.statusLine.statusCode} : ${resp.statusLine.reasonPhrase}"
                println ContentType.JSON.parse(json)
                return
            }
        }
        def result
        //println jsonData
        if(jsonData?.status != 200){
             result = [status: jsonData?.status, message: jsonData?.message]
            render result as JSON
            return

        }
        result = [status: jsonData.status, elements: jsonData.payload]
        render result as JSON
        return

    }




    /****************************
    *****************************
    *****************************
     Save rows to big data server
    *****************************
    *****************************
    ****************************/

//    @Secured(["ROLE_COMPANY"])
    def saveRow(){
        def user = springSecurityService.currentUser as Company
        def http = new HTTPBuilder( grailsApplication.config.com.nest5.Nest5Client.bigDataServerURL )
        def jsonData
        println params
        // perform a GET request, expecting JSON response data
        http.request( Method.POST, ContentType.TEXT ) {

            uri.path = grailsApplication.config.com.nest5.Nest5Client.bigDataPath+'rowOps/rowReceived'
            def now = Calendar.getInstance(Locale.default)
            def nowmillis = now.getTimeInMillis()
            params.put("time_created",nowmillis)
            params.put("device_id",new StringBuilder().append(user.id).append((user.email).encodeAsMD5()).toString())
            def fields = ContentType.JSON.parse(params.fields)
            params.fields = fields
            uri.query = [row:params as JSON,sync_row_id:params.sync_row_id]
           // println uri

            headers.'User-Agent' = 'Mozilla/5.0 Ubuntu/8.10 Firefox/3.0.4'

            // response handler for a success response code:
            response.success = { resp, json ->

                // parse the JSON response object:
                jsonData = ContentType.JSON.parse(json)

            }

            // handler for any failure status code:
            response.failure = { resp,json ->
                println "Unexpected error: ${resp.statusLine.statusCode} : ${resp.statusLine.reasonPhrase}"
                println ContentType.JSON.parse(json)
                //resp.setStatus(400)

                return
            }
        }
        if(jsonData) {
            if((jsonData.status == 201 && jsonData.code == 555) || (jsonData.status == 200 && jsonData.code == 555)){
                def result = [status: 1,syncId: jsonData.syncId]
                response.setStatus(200)
                render result as JSON
                return
            }

        }
        else{
            def result = [status: 0,syncId: 0]
            response.setStatus(200)
            render result as JSON
            return

        }


    }
//@Secured(["ROLE_COMPANY"])
    def saveDevice(){
        def user = springSecurityService.currentUser as Company
        def http = new HTTPBuilder( grailsApplication.config.com.nest5.Nest5Client.bigDataServerURL )
        def jsonData
        http.request( Method.POST, ContentType.TEXT ) {
            uri.path = grailsApplication.config.com.nest5.Nest5Client.bigDataPath+'deviceOps/updateDevice'
            uri.query = [row: params?.uid,company: user?.id, name: params?.name, prefix: params?.prefix, maxSale: params?.maxSale,currentSale: params?.currentSale,resolution: params?.resolution]
            headers.'User-Agent' = 'Mozilla/5.0 Ubuntu/8.10 Firefox/3.0.4'
            response.success = { resp, json ->
                jsonData = ContentType.JSON.parse(json)
            }
            response.failure = { resp,json ->
                println "Unexpected error: ${resp.statusLine.statusCode} : ${resp.statusLine.reasonPhrase}"
                println ContentType.JSON.parse(json)
                return
            }
        }
        if(jsonData) {
            if(jsonData.status == 200 ){
                def result = [status: 1]
                response.setStatus(200)
                render result as JSON
                return
            }

        }
        else{
            def result = [status: 0]
            response.setStatus(200)
            render result as JSON
            return

        }


    }

//    @Secured(["ROLE_COMPANY"])
    def saveInfo(){
        def user = springSecurityService.currentUser as Company

        user.properties = params
        if(!user.save(flush: true)){
            println user.errors.allErrors
            def result = [status: 0]
            response.setStatus(200)
            render result as JSON
            return
        }
        def result = [status: 1]
        response.setStatus(200)
        render result as JSON
        return




    }



    /*def firstInteraction(){
        if (request.xhr) {
            def company = Company.findByEmail(params.companyid)
            def promos = company.managedPromos
            def results = []
            promos.each{promocion->
                def newbies = []
                def s = Stamp.createCriteria()
                def users = s.list{
                    eq("promo",promocion)
//                    order("date","asc")
                    projections{
                        distinct("user")

                    }
                }
                    users.each{usuario->

                        def userStamps = usuario.stamps
                        def ss = Stamp.createCriteria()

                        def firstTimeInPromo = ss.get{
                            eq("promo",promocion)
                            eq("user",usuario)
                            order("date","asc")
                            maxResults(1)
                            projections {
                                property("date")
                            }
                        }

                        def firstTimer = true

                        for(def actual : userStamps){
                            if(actual.promo != promocion)
                            {
                               if (actual.date < firstTimeInPromo)
                               {
                                firstTimer = false
                                break

                               }
                            }
                        }
                        if(firstTimer)
                        {
                           newbies += [user: usuario, date: firstTimeInPromo]
                        }

                    }
                results += [promo: promocion,newbies: newbies]

                }

//




        render results as JSON
        return

        }

    }*/



/*
    @Secured(["ROLE_COMPANY"])
    def messages(){
        def user = springSecurityService.currentUser
        def users = user.chats().unique()

        def distribution = []
        users.each{actual->
            def cantUnread = 0
            def totalMessages = 0
            def lastDate = (Message.findByCompanyAndUser(user,actual,[sort: 'time', order: 'desc'])).time
            def mc = Message.createCriteria()
             cantUnread = mc.get {
                eq('user',actual)
                eq('company',user)
                eq('read',false)
                projections {
                    count('id')
                }
            }
             totalMessages = Message.countByCompanyAndUser(user,actual)

            distribution += [user: actual, total: totalMessages, unread: cantUnread, last: lastDate]
        }
        def messages = Message.countByCompanyAndRead(user,false)
        [user: user, messages: messages,distribution:distribution]
    }*/

    /*@Secured(["ROLE_COMPANY"])
    def chat(Long id){
        def user = springSecurityService.currentUser

        def client = User.findById(id as Long)
        if(!client){
            redirect(action: 'messages')
        }
        def conversation = Message.findAllByCompanyAndUser(user,client,[sort: 'time', order: 'asc'])

        conversation.each {act->
            if (act.read == false){
                act.read = true
                act.save(flush: true)
            }
        }
        def messages = Message.countByCompanyAndRead(user,false)

        [user: user, conversation: conversation,client:  client,messages: messages, pictures: [company: companyService.companyImageUrl(user), client: userService.userImageUrl(client)]]
    }*/

   /* @Secured(["ROLE_COMPANY"])
    def messageUser(){
        def user = User.findById(params.id as Long)
        def result
        if(!user){
            result = [status: 0, message: "No existe el usuario"]
            render result as JSON
            return
        }
        def company = springSecurityService.currentUser
        if(!company){
            result = [status: 0, message: "No existe la Marca"]
            render result as JSON
            return
        }
        def message = params.message
        company.addToChat(user,message)
//        userService.generateStatusEvent(user,message)
        result = [status: 1, message: message,user: user.id]
        render result as JSON
        return


    }*/
   /* @Secured(["ROLE_COMPANY"])
    def clients(){
        def company = springSecurityService.currentUser


        [user: company,picture: companyService.companyImageUrl(company)]

    }*/

    /*@Secured(["ROLE_COMPANY"])
    def selectUsers(){
        def user = springSecurityService.currentUser
        def today = new Date()
        def allUsers = user.clients().unique()
        def promos = user.managedPromos
        def sc4 = Stamp.createCriteria()
        def allUsersInPromo = sc4.list {
            'in'('promo',promos)
            projections {
                property('user')
            }
        }.unique()
        def oneWeekBefore
        def oneMonthBefore
        def type = params.type
        def result
//One Week

            use(TimeCategory) {
                oneWeekBefore = today - 1.week
                oneMonthBefore = today - 1.month
            }

        switch(type){
            case 'oneweek':

                def sc = Stamp.createCriteria()
                def oneWeekUsers = sc.list {
                    'in'('promo',promos)
                    ge('date',oneWeekBefore)
                    projections{
                        property('user')
                    }

                }.unique()
                result = []
                oneWeekUsers.each {
                    result += [id: it.id, name: it.name, email:  it.email, picture: userService.userImageUrl(it)]
                }
                break
            case 'onemonth':
                def sc1 = Stamp.createCriteria()
                def oneMonthUsers = sc1.list {
                    'in'('promo',promos)
                    ge('date',oneMonthBefore)
                    projections{
                        property('user')
                    }

                }.unique()
                result = []
                oneMonthUsers.each {
                    result += [id: it.id, name: it.name, email:  it.email, picture: userService.userImageUrl(it)]
                }
                break
            case 'moreonemonth':
                def sc1 = Stamp.createCriteria()
                def oneMonthUsers = sc1.list {
                    'in'('promo',promos)
                    ge('date',oneMonthBefore)
                    projections{
                        property('user')
                    }

                }.unique()
                def sc2 = Stamp.createCriteria()
                def moreOneMonthUsers = sc2.list {
                    'in'('promo',promos)
                    lt('date',oneMonthBefore)
                    not {'in'("user",oneMonthUsers)}
                    projections{
                        property('user')
                    }

                }.unique()
                result = []
                moreOneMonthUsers.each {
                    result += [id: it.id, name: it.name, email:  it.email, picture: userService.userImageUrl(it)]
                }
                break
            case 'nevercame':
                def sc3 = Stamp.createCriteria()
                def stampUsers = sc3.list {
                    'in'('promo',promos)
                    projections{
                        property('user')
                    }

                }.unique()
                def neverUsers = allUsers - stampUsers
                result = []
                neverUsers.each {
                    result += [id: it.id, name: it.name, email:  it.email, picture: userService.userImageUrl(it)]
                }
                break
            case 'onestamp':
                //One stamp, the week before and haven't returned (Fresh users, easy to make come back)
//also Stamped their card once last month
                def cal = Calendar.instance
                cal.setTime(oneWeekBefore)
                cal[Calendar.DAY_OF_WEEK] = cal.firstDayOfWeek
                def previousWeekBefore = cal.time
                def oneStampUsersLastWeek = []
                def oneStampUsersLastMonth = []
                allUsersInPromo.each{usuario->

                    def sc5 = Stamp.createCriteria()
                    def sellos = sc5.list {
                        'in'('promo',promos)
                        eq('user',usuario)
                    }

                    if (sellos.size() == 1){
                        if (sellos[0].date >= previousWeekBefore){
                            oneStampUsersLastWeek += usuario
                        }
                        if(sellos[0].date >= oneMonthBefore){
                            oneStampUsersLastMonth += usuario
                        }
                    }
                }
                result = [oneweek: [], onemonth: []]
                oneStampUsersLastWeek.each {
                    result.oneweek += [id: it.id, name: it.name, email:  it.email, picture: userService.userImageUrl(it)]
                }
                oneStampUsersLastMonth.each {
                    result.onemonth += [id: it.id, name: it.name, email:  it.email, picture: userService.userImageUrl(it)]
                }
                break
            case 'firstfive':
                def rc = Relation.createCriteria()
                def fiveusers = rc.list {
                    eq('company',user)
                    order('firstTime','asc')
                    maxResults(5)
                    projections {
                        property('user')

                    }
                }
                result = []
                fiveusers.each {
                    result += [id: it.id, name: it.name, email:  it.email, picture: userService.userImageUrl(it)]
                }
                break
            case 'almostthere':
                def almostWinUsers = []
                allUsersInPromo.each{usuario->

                    def sc6 = Stamp.createCriteria()
                    def sellos = sc6.list {
                        'in'('promo',promos)
                        eq('user',usuario)
                        eq('redeemed',false)
                    }
                    println sellos.size()
                    if (sellos.size() == 4){
                        almostWinUsers += usuario
                    }
                }
                result = []
                almostWinUsers.each {
                    result += [id: it.id, name: it.name, email:  it.email, picture: userService.userImageUrl(it)]
                }
                break
            case 'mostactive':
                def mostActiveUsers = []

                allUsersInPromo.each{usuario->

                    def sc7 = Stamp.createCriteria()
                    def sellos = sc7.list {
                        'in'('promo',promos)
                        eq('user',usuario)

                    }
                    println "ususario"+usuario.id+" : "+sellos.size()
                    mostActiveUsers += [user: usuario, sellos: sellos]
                }
                mostActiveUsers.sort {-it.sellos.size()}
                result = []
                mostActiveUsers.each {
                    result += [id: it.user.id, name: it.user.name,stamps: it.sellos.size(), email:  it.user.email, picture: userService.userImageUrl(it.user)]
                }
                break
        }
        if(type){
            if(!result)
                result = []
            response.setStatus(200)
            render result as JSON
        }

        else{
            response.setStatus(400)
            render text: "Bad Request"
        }

        return

         //


       *//* def cal = Calendar.instance
        cal.set(previousDate[Calendar.YEAR],previousDate[Calendar.MONTH],1,0,0,0)
        previousDate = cal.time  //Date of first day 00:00:00 ranges months ago (6 months ago, 3 months ago)
        def i = 0
        def promociones = user.managedPromos
        def results = []
        while(i < ranges+1){
            def oneMonthAfter
            use(TimeCategory) {
                oneMonthAfter = previousDate + 1.months - 1.days
            }*//*
    }*/

     def registerDevice(){
         try{
             def user = springSecurityService.currentUser as Company
             def http = new HTTPBuilder( grailsApplication.config.com.nest5.Nest5Client.bigDataServerURL )
             def jsonData
             http.request( Method.POST, ContentType.TEXT ) {

                 uri.path = grailsApplication.config.com.nest5.Nest5Client.bigDataPath+'deviceOps/registerDevice'
                 uri.query = [payload:"{company: "+user.id+",device_id:'"+new StringBuilder().append(user.id).append((user.email).encodeAsMD5()).toString()+"'}"]
                 headers.'User-Agent' = 'Mozilla/5.0 Ubuntu/8.10 Firefox/3.0.4'
                 response.success = { resp, json ->
                     jsonData = ContentType.JSON.parse(json)
                 }
                 response.failure = { resp,json ->
                 }
             }

         }catch(Exception e){}

        return true
    }
}
