package com.nest5.Nest5Client

class Category {
    static hasMany = [families: Family,companies: Company]
    String name
    String description
    Icon icon


    static  mapping = {
        sort name: "asc"
        description type: 'text'
        name type: 'text'
        datasource 'trans'
    }

    static constraints = {
    }

    String toString(){
        name
    }
}
