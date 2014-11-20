package com.nest5.Nest5Client

import org.bson.types.ObjectId

class Installation {

    ObjectId id
    Boolean completed = false
    String email
    String fingerprint
    String city
    String country
    Boolean stepone = false
    Boolean steptwo = false
    Date createdOn
    Date lastUpdated
    Date startedAt
    Date lastModification

    static mapping = {
        autoTimestamp true
        fingerprint index: true
    }
    static constraints = {
    }
    static mapWith = "mongo"
}
