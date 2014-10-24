package com.nest5.Nest5Client


import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class SellerController {
    def springSecurityService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Seller.list(params), model: [sellerInstanceCount: Seller.count()]
    }

    def show(Seller sellerInstance) {
        respond sellerInstance
    }

    def create() {
        respond new Seller(params)
    }

    @Transactional
    def save(Seller sellerInstance) {
        if (sellerInstance == null) {
            notFound()
            return
        }

        if (sellerInstance.hasErrors()) {
            respond sellerInstance.errors, view: 'create'
            return
        }

        sellerInstance.save flush: true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'seller.label', default: 'Seller'), sellerInstance.id])
                redirect sellerInstance
            }
            '*' { respond sellerInstance, [status: CREATED] }
        }
    }

    @Transactional
    def saveFromCompany() {
        def company = springSecurityService.currentUser as Company
        if(!company){
            notFound()
            return
        }
        Seller sellerInstance = new Seller()
        sellerInstance.properties = params
        sellerInstance.company = company
        sellerInstance.passwordExpired = false
        sellerInstance.accountExpired = false
        sellerInstance.active = true
        sellerInstance.enabled = true
        sellerInstance.registerDate = new Date()
        sellerInstance.accountLocked= false
        if(!sellerInstance.save (flush: true)){
            println sellerInstance.errors.allErrors
            notFound()
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'seller.label', default: 'Vendedor creado con Éxito'), sellerInstance.id])
                redirect (controller: 'company',action: 'createSeller')
            }
            '*' { flash.message = message(code: 'default.created.message', args: [message(code: 'seller.label', default: params.name+' creado con Éxito'), sellerInstance.id])
                redirect (controller: 'company',action: 'createSeller') }
        }
    }

    def edit(Seller sellerInstance) {
        respond sellerInstance
    }

    @Transactional
    def update(Seller sellerInstance) {
        if (sellerInstance == null) {
            notFound()
            return
        }

        if (sellerInstance.hasErrors()) {
            respond sellerInstance.errors, view: 'edit'
            return
        }

        sellerInstance.save flush: true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Seller.label', default: 'Seller'), sellerInstance.id])
                redirect sellerInstance
            }
            '*' { respond sellerInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(Seller sellerInstance) {

        if (sellerInstance == null) {
            notFound()
            return
        }

        sellerInstance.delete flush: true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Seller.label', default: 'Seller'), sellerInstance.id])
                redirect action: "index", method: "GET"
            }
            '*' { render status: NO_CONTENT }
        }
    }
    @Transactional
    def deleteFromCompany(Seller sellerInstance) {

        if (sellerInstance == null) {
            notFound()
            return
        }

        sellerInstance.delete flush: true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'seller.label', default: 'Vendedor eliminado con éxito'), sellerInstance.id])
                redirect (controller: 'company',action: 'createSeller')
            }
            '*' {
                    flash.message = message(code: 'default.deleted.message', args: [message(code: 'seller.label', default: 'Vendedor eliminado con éxito'), sellerInstance.id])
                    redirect (controller: 'company',action: 'createSeller')
                }
        }
    }

    @Transactional
    def updateFromCompany(Seller sellerInstance) {
        if (sellerInstance == null) {
            notFound()
            return
        }

        def seller = Seller.findById(params.sellerid as Long)
        if(!seller){
            respond null, view: '../company/updateSeller'  //cambiar al view de edicion desde compañia
            return
        }
        seller.name = !((params.name) && (params.name?.trim().size() > 1) ) ?:  params.name
        seller.identification = !((params.identification) && (params.identification?.trim().size() > 1) ) ?:  params.identification
        seller.telephone = !((params.telephone) && (params.telephone?.trim().size() > 1) ) ?:  params.telephone
        seller.email = !((params.email) && (params.email?.trim().size() > 1) ) ?:  params.email
        seller.username = !((params.username) && (params.username?.trim().size() > 1) ) ?:  params.username
        seller.password = !((params.password) && (params.password?.trim().size() > 1) ) ?:  params.password

        if (seller.hasErrors()) {
            respond seller.errors, view: '../company/updateSeller'  //cambiar al view de edicion desde compañia
            return
        }


       if(!seller.save(flush: true)){
           println seller.errors.allErrors
       }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'seller.label', default: ' actualizado con éxito'), sellerInstance.id])
                redirect (controller: 'company',action: 'createSeller')
            }
            '*' {
                flash.message = message(code: 'default.created.message', args: [message(code: 'seller.label', default: ' actualizado con éxito'), sellerInstance.id])
                redirect (controller: 'company',action: 'createSeller')
            }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'seller.label', default: 'Seller'), params.id])
                redirect action: "index", method: "GET"
            }
            '*' { render status: NOT_FOUND }
        }
    }
}
