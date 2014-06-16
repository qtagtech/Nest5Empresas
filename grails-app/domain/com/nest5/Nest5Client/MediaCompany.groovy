package com.nest5.Nest5Client

class MediaCompany {
    static belongsTo = [file: FileCompany, company: Company]
    Boolean isMain
    static constraints = {
    }
}
