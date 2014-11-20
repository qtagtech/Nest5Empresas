package com.nest5.Nest5Client

class Icon {
    static hasMany = [families: Family]
    String name
    String tipo
    String ruta
    String description
    static constraints = {
    }
    static mapping = {
        datasource 'trans'
    }
}

