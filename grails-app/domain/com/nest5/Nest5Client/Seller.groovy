package com.nest5.Nest5Client

class Seller extends SecUser {

    static belongsTo = [company: Company]
    String name
    String identification
    String telephone
    String email
    Date registerDate
    Boolean active = true

    static mapping = {
        datasource 'trans'
    }
    static constraints = {

    }

    String toString(){
        name
    }
}
