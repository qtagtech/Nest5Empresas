package com.nest5.Nest5Client

import grails.converters.JSON

class ApiController {

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
        def password = springSecurityService.encodePassword(pass)
        if(password == user.password){
            result = [status: 1,id: user.id, email: user.email, name: user.name, username: user.username, phone: "000000"]
            render result as JSON
            return
        }
        result = [status: 0,id: 0, email: "", name: "",phone: "", username: ""]
        render result as JSON
        return

    }


    def companyDetails(){
        println request
        def username = params.company_id
        println params
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

        result = [status: 1,company: user,category: [category:user.category,icon: user.category.icon]]
        response.setContentType("text/json")
        render(contentType:"text/json") {
            result
        }

        return


    }
}
