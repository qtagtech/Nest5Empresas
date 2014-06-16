package com.nest5.Nest5Client

import grails.converters.JSON

class ApiController {
    def springSecurityService

    def index() {}

    def checkLogin(){
        // println params
        def username = params.email?.trim()
        def pass = params.password?.trim()
        //println username+" "+pass
        def result
        if(!username || ! pass){
            result = [status: 0,id: 0, email: "", name: "",phone: "", username: ""]
            render result as JSON
            return
        }
        def user = Company.findByUsername(username);
        if(!user){

            result = [status: 0,id: 0, email: "", name: "",phone: "", username: ""]
            render result as JSON
            return
        }
        if (springSecurityService?.passwordEncoder?.isPasswordValid(user.password, pass, null)) { //validates raw password against hashed
            result = [status: 1,id: user.id, email: user.email, name: user.name, username: user.username, phone: "000000"]
            render result as JSON
            return
        }
        result = [status: 0,id: 0, email: "", name: "",phone: "", username: ""]
        render result as JSON
        return

    }


    def companyDetails(){
        def username = params.company_id
        //println username+" "+pass
        def result
        if(!username){
            result = [status: 0,id: 0, email: "", name: "",phone: "", username: ""]
            render result as JSON
            return
        }
        def user = Company.findById(username) as Company;
        if(!user){

            result = [status: 0,id: 0, email: "", name: "",phone: "", username: ""]
            render result as JSON
            return
        }

        result = [status: 1,name: user?.name, telephone: user?.telephone, address: user?.address, email: user?.email,url: user?.url,invoiceMessage: user.invoiceMessage, tipMessage: user?.tipMessage, resolution: user?.resolution]
        response.setContentType("text/json")
        render(contentType:"text/json") {
            result
        }

        return


    }
}
