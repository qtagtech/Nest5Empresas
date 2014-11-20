package com.nest5.Nest5Client

class Universe {

    static hasMany = [families: Family]
    String name
    String description
    Icon icon

    static constraints = {
    }

    String toString(){
        name
    }
    static mapping = {
        datasource 'trans'
    }

}
