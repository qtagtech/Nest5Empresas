package com.nest5.Nest5Client

import com.mongodb.BasicDBObject
import grails.converters.JSON
import grails.transaction.Transactional

class InstallationController {
    def userService
    def mongo

    def index() {}

    def one() {}

    def two() {}

    def three() {
        render text: 'holi!'
        return
    }

    def beginInstallation(){
        println params
        def fingerprint = params.fingerprint
        def email = params.email
        def city = params.city
        def country = params.country
        if(!!fingerprint == false || !!email == false  || !!country ==false || !!city == false || !!params.initTime == false || !!params.endTime == false){
            response.setStatus(400)
            def result = [status: 0, text: "Missing api call parameters."]
            render result as JSON
            return
        }
        def db = mongo.getDB(grailsApplication.config.com.nest5.BusinessData.database)
        BasicDBObject query = new BasicDBObject().append("fingerprint" , fingerprint)
        def existing = db.installation.findOne(query)
        if(!!existing == false){
            def resultado = db.installation.insert(fingerprint:fingerprint, city: city, country: country, email: email, createdOn: new Date(), lastUpdated: new Date(), startedAt: new Date(params.initTime as Long), lastModification : new Date(params.endTime as Long) )
            if(resultado.error)
            {
                response.setStatus(400)
                def result = [status: 400, code: 55512,message: 'Error saving new device to database: '+resultado?.lastError?.err]
                render result as JSON
                return
            }
            existing = db.installation.findOne(query)

        }
        BasicDBObject newfields = new BasicDBObject("lastModification":new Date(params?.endTime as Long))
                .append("email",params?.email)
                .append("lastUpdated",new Date())
        BasicDBObject setObject = new BasicDBObject('$set' : newfields)
        def filas = db.installation.update(query,setObject)
        def result = [status: 1, text: "listo"]
        render result as JSON
        return
    }

    def secondStepInstallation(){

    }
    @Transactional
    def endStepOne(){
        def fingerprint = params.fingerprint
        def email = params.email
        def city = params.city
        def country = params.country
        def name = params.name
        def telephone = params.telephone
        if(!!fingerprint == false || !!email == false  || !!country ==false || !!city == false || !!params.initTime == false || !!params.endTime == false || !!name == false || !!telephone == false){
            response.setStatus(400)
            def result = [status: 0, text: "Missing api call parameters."]
            render result as JSON
            return
        }
        def db = mongo.getDB(grailsApplication.config.com.nest5.BusinessData.database)
        BasicDBObject query = new BasicDBObject().append("fingerprint" , fingerprint)
        def existing = db.installation.findOne(query)
        BasicDBObject admin = new BasicDBObject().append('name',name)
                            .append('telephone', telephone)
                            .append('email',email)
        if(!!existing == false){
            def resultado = db.installation.insert(fingerprint:fingerprint, city: city, country: country, email: email, createdOn: new Date(), lastUpdated: new Date(), startedAt: new Date(params.initTime as Long), lastModification : new Date(params.endTime as Long), admin: admin, stepone: true)
            if(resultado.error)
            {
                response.setStatus(400)
                def result = [status: 400, code: 55512,message: 'Error saving new device to database: '+resultado?.lastError?.err]
                render result as JSON
                return
            }
            existing = db.installation.findOne(query)

        }
        BasicDBObject newfields = new BasicDBObject("lastModification":new Date(params?.endTime as Long))
                .append("email",params?.email)
                .append("lastUpdated",new Date())
                .append('admin',admin)
                .append('stepone',true)
        BasicDBObject setObject = new BasicDBObject('$set' : newfields)
        def filas = db.installation.update(query,setObject)
        def result = [status: 1, text: "listo"]
        render result as JSON
        return
    }
    def endStepTwo(){
        def fingerprint = params.fingerprint
        def address = params.address
        def city = params.city
        def country = params.country
        def name = params.name
        def telephone = params.telephone
        def identification = params.identification
        def web = params.web
        println params
        if(!!fingerprint == false || !!address == false  || !!country ==false || !!city == false || !!params.initTime == false || !!params.endTime == false || !!name == false || !!telephone == false || !!identification == false){
            response.setStatus(400)
            def result = [status: 0, text: "Missing api call parameters."]
            render result as JSON
            return
        }

        def db = mongo.getDB(grailsApplication.config.com.nest5.BusinessData.database)
        BasicDBObject query = new BasicDBObject().append("fingerprint" , fingerprint)
        def existing = db.installation.findOne(query)
        BasicDBObject company = new BasicDBObject().append('name',name)
                .append('address', address)
                .append('telephone',telephone)
                .append('identification',identification)
                .append('telephone',telephone)
                .append('web',web)
//        println (params.simplified).toBoolean()
        def regimen = (params.simplified).toBoolean() ? 'S' : 'C'
        BasicDBObject companydetails = new BasicDBObject().append('regimen',regimen)
                .append('knewregimen', (params.knewregimen).toBoolean())
                .append('isfranchise',(params.isfranchise).toBoolean())
                .append('inc',(params.inc).toBoolean())
                .append('incvalue',(params.incvalue).toBoolean())
                .append('aantventasinfer',(params.aantventinf).toBoolean())
                .append('uncomercio',(params.uncomercio).toBoolean())
                .append('pressedjuriridica',(params.pressedjuridic).toBoolean())
                .append('aanteriorcontratosinferior',(params.aantcontinf).toBoolean())
                .append('aactualcontratosinferior',(params.aactcontinf).toBoolean())
                .append('aanterioconsignacioinfer',(params.aantconsinf).toBoolean())
                .append('aactualconsignacioninfer',(params.aactconsinf).toBoolean())
        if(!!existing == false){
            //def resultado = db.installation.insert(fingerprint:fingerprint, city: city, country: country, email: email, createdOn: new Date(), lastUpdated: new Date(), startedAt: new Date(params.initTime as Long), lastModification : new Date(params.endTime as Long), admin: admin, stepone: true)
                response.setStatus(303)  //see other, the company should be starting at ste one since there is no admin user registered
                def result = [status: 303, code: 55512,message: 'Error there is no admin user registered for this fingerprint, strart from step one.']
                render result as JSON
                return
        }
        BasicDBObject newfields = new BasicDBObject("lastModification":new Date(params?.endTime as Long))
                .append("lastUpdated",new Date())
                .append('company',company)
                .append('companydetails',companydetails)
                .append('steptwo',true)
        BasicDBObject setObject = new BasicDBObject('$set' : newfields)
        def filas = db.installation.update(query,setObject)
        //create company on trans db, son the user can now login to the dashboard
        def icon = Icon.findByName('dummyIcon') ?: new Icon(
                name: 'dummyIcon',
                tipo: 'image/png',
                ruta: 'https://s3-us-west-2.amazonaws.com/com.nest5.assets/user-profile/bola_80.png',
                description: 'Logo de Nest5'
        ).save(failOnError: true)
        def webadd = existing.company.web
        if(!!existing.company.web == false || existing.company.web == '')
            webadd == "http://"
        def compania = Company.findByUsername(existing.admin.email as String) ?: new Company(

                category: Category.findByName('Ninguna') ?: new Category(name: 'Ninguna', description: 'Sin clasificacion posible.',icon: icon).save(failOnError: true),
                username: existing.admin.email as String,
                password: userService.generateUserPassword(),
                enabled: true,
                name : existing.company.name as String,
                address: existing.company.address as String,
                telephone: existing.company.telephone as String,
                contactName: existing.admin.name as String,
                email: existing.admin.email as String,
                nit: existing.company.identification as String,
                logo : 'https://s3-us-west-2.amazonaws.com/com.nest5.assets/user-profile/bola_80.png',
                url : webadd,
                registerDate: new Date(),
                active: true
        ).save(failOnError: true)
        def companyRole = SecRole.findByAuthority('ROLE_COMPANY') ?: new SecRole(authority: 'ROLE_COMPANY').save(failOnError: true)
        if (!compania.authorities.contains(companyRole)) {
            SecUserSecRole.create compania, companyRole
        }
        def result = [status: 1, text: "listo"]
        render result as JSON
        return
        //
    }

    def checkStep(){
        def fingerprint = params.fingerprint
        if(!!fingerprint == false){
            response.setStatus(400)
            def result = [status: 400, code: 55512,message: 'Missing Parameters.']
            render result as JSON
            return
        }
        def db = mongo.getDB(grailsApplication.config.com.nest5.BusinessData.database)
        BasicDBObject query = new BasicDBObject().append("fingerprint" , fingerprint)
        def existing = db.installation.findOne(query)
        if(!!existing == false){
            response.setStatus(200)
            def result = [status: 200, code: 55512,message: 'First Step',step: "one"]
            render result as JSON
            return
        }
        def first = existing.stepone
        def second = existing.steptwo
        def third = existing.stepthree
        if(!first){
            response.setStatus(200)
            def result = [status: 200, code: 55512,message: 'First Step',step: "one"]
            render result as JSON
            return
        }
        if(!second){
            response.setStatus(200)
            def result = [status: 200, code: 55512,message: 'First Step',step: "two"]
            render result as JSON
            return
        }
        if(!third){
            response.setStatus(200)
            def result = [status: 200, code: 55512,message: 'First Step',step: "two"]//temp redirect to step two to test
            render result as JSON
            return
        }

            response.setStatus(200)
            def result = [status: 200, code: 55512,message: 'First Step',step: "one"]
            render result as JSON
            return


    }
}
