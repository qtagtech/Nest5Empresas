package com.nest5.Nest5Client

class Family {

    static belongsTo = [universe: Universe]
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

