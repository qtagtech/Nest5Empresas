package com.nest5.Nest5Client

import grails.converters.JSON
import groovyx.net.http.HTTPBuilder
import org.apache.commons.codec.binary.Base64
import org.apache.commons.lang.RandomStringUtils
import org.codehaus.groovy.grails.web.context.ServletContextHolder
class UserController {
    def springSecurityService
    def userService
    def utilityService
    def companyService
    def user

    def index() {

    }


    def store(){
        render(view: 'landing',model: [cobranding: flash.cobranding ])
    }

    def create(){
        //println(params.terms)

        if (params.terms != "accepted")
        {
            def data =  [errors: "1", errorType: "2", messages: [[id:13 , value: message(code: 'user.accept.terms', args: [],default: "You didn´t accept the terms and conditions.")]] ]
            render data  as JSON
            return
        }
        def cantUser = User.countByEmail(params.email)
        
        if(cantUser > 0) {
            def data =  [errors: "1", errorType: "2", messages: [[id:3 , value: message(code: 'user.email.taken', args: [params.email],default: "The Email {0} is already registered.")]] ]
            render data  as JSON
            return
        }
        
        def user = new User()
        user.properties = params
        def userRole = SecRole.findByAuthority('ROLE_USER')


        user.username = params.email
        user.referer = params.referer ? params.referer : "NONE"
        user.smartphone = params.smartphone ? params.smartphone : false
        user.smartphoneBrand = params.smartphone ? params.smartphoneBrand : "NONE"
        user.date = params.date ? params.date : "NONE"
        user.phone = params.phone ? params.phone : "NONE"
        user.magnetic5 = "0000000000000000"
        String charset = (('A'..'Z') + ('0'..'9')).join()
        Integer length = 18
        String randomString = RandomStringUtils.random(length, charset.toCharArray())
        user.password = randomString
       
        if(user.save(flush: true))
        {
            userService.sendWelcomeMail(user,randomString)
            SecUserSecRole.create user,userRole
            def data =  [errors: "0", errorType: "0", messages: [[id:4 , value: message(code: 'user.register.success', args: ["<h2>${(user.name.split(" "))[0]}</h2>","<strong>${params.email}</strong>"],default: "{0}, \nThank You!, we have sent you an email to {1} with your access password for you to start with The Nest5 Experience. \nAs for now, why don't you take a look at what your favorite Brands and Stores are doing to make you fall in love with them.")] ] ]
            render data  as JSON
            return

        }
        else
        {
            def data =  [errors: "1", errorType: "1", messages: [id: "NA",value:  user.errors] ]
            render data  as JSON
            return
        }

        

    }

    def confirmEmail() {

        def id = params.id
        try{
            def parameters = new String(id.decodeBase64())
            def separate = parameters.split("::")
            def email = separate[1]

            def user = User.findByEmail(email)

            if (!user)
            {
                flash.message = "${message(code: 'user.email.notfound', args: [email],default: "We are sorry, the Email you're trying to use is not in our database. Maybe you havenn't Signed Up yet.")}"
                return [email:email, errorCode: 1]
            }

            def date = user.date
            def name = user.name


            def complete = date+"_"+name
            def decoded = separate[0]


            if (complete.encodeAsMD5() != decoded)
            {

                flash.message = "${message(code: 'user.link.malformed', default: "The link you're trying to activate seems to be invalid or malformed. Please try again and hit the button below.")}"
                return [code: id, errorCode: 2]
            }
            
            if (user.enabled){
                flash.message = "${message(code: 'user.already.active', default: "You account is already active. You may go to your profile and start using Nest5, The Experience.")}"
                return [code: id, errorCode: 2]
            }

            user.enabled = true
            user.points = user.points + 100;
            if (user.save(flush: true)){
                redirect (uri: "/user/account",params: [activity: 'password'])
            }
        }
        catch (e) {
            flash.message = "${message(code: 'user.link.malformed', default: "The link you're trying to activate seems to be invalid or malformed. Please try again and hit the button below.")}"
            return [code: id, errorCode: 2]
        }
        
        

    }

    def checkUserName()
    {
        def user = params.username
        def data
        if(user)
        {
            def object = SecUser.findByUsername(user)

            if(object == null)
            {

                data = [status:1]   //false porque esta libre el usuario

            }
            else
            {
                data = [status : 0]
                // true porque está ocupado el usuario
            }

        }
        else
        {
            data = [status: 2] //error porque no llegó nada
        }

        render data as JSON
        return

    }



    
//    @Secured(['ROLE_USER','ROLE_ADMIN','ROLE_FACEBOOK'])
    def update(){
        
         
        def userid = Integer.parseInt(params.user.id)
       // println "Por acaaaaa "+params.uid

        def user = springSecurityService.currentUser

        if (user.id != userid)
        {
            def data =  [errors: "1", errorType: "2", messages: [[id:5 , value: message(code: 'user.modify.unauthorized', args: [],default: "We are sorry, you're not authorized to modify this account's properties.")] ] ]
            render data  as JSON
            return
        }
        if (params.password)
        {
            if (params.password != params.pass2)
            {
                def data =  [errors: "1", errorType: "2", messages: [[id:6 , value: message(code: 'user.passwords.do.not.match', args: [],default: "Both passwords fields must match.")] ] ]
                render data  as JSON
                return
            }
        }




        user.properties = params
        def date
        if (params.date_select_day)
        {
          date = params.date_select_year+"/"+params.date_select_month+"/"+params.date_select_day
        }
        user.date = date
        user.lastLogin = new Date()
        if (!user.save(flush: true))
        {
            if(params.email)
            {
                String charset = (('A'..'Z') + ('0'..'9')).join()
                Integer length = 18
                String randomString = RandomStringUtils.random(length, charset.toCharArray())
                userService.sendWelcomeMail(user,randomString,"SOCIAL","Twitter")
            }
            def data =  [errors: "1", errorType: "1", messages: [id: "NA",value:  user.errors] ]
            render data  as JSON
            return
        }
        def data =  [errors: "0", errorType: "0", messages: [[id:4 , value: message(code: 'user.modify.success', args: ["<h2>${(user.name.split(" "))[0]}</h2>"],default: "{0}, \nWe have successfully updated your information.")] ] ]
        render data  as JSON
        return

    }
    

    /*def openEmail() {
        def servletContext = ServletContextHolder.servletContext
        def imagen = servletContext.getResourceAsStream('/images/logo.png')
        response.contentType = 'image/png' // or the appropriate image content type
        response.outputStream << imagen
        response.outputStream.flush()

    }*/

    def findUsernames() {
           def q = params.term
          def c = User.createCriteria()
        def users = c.list {
            ilike('username','%'+q+'%')
        }
        def results = []
        users.each{actual->
            results += [id: actual.id, name: actual.name, username: actual.username, email: actual.email,value: actual.username,type: 'contact', title: actual.username, img: userService.userImageUrl(actual)]
        }
        render results as JSON
        return
    }













    /********************************************************
     *TODAS LAS ACCIONES QUE TIENEN QUE VER CON AMIGOS Y FEED
     ********************************************************/


    /*----------------------------------------------
   *
   *
   *
   *               addFriend ACTION - MAY 19TH 2013 - Juanda
   *               Permite que desde app movil con api o desde web un usuario loggeado agregue a otro usando un id
   *
   *
   *
   * ------------------------------------------------*/

//    @Secured(["ROLE_API","ROLE_USER"])
    /*def addFriend(){
        def userRole = SecRole.findByAuthority('ROLE_USER')
        def actual = User.get(springSecurityService.currentUser.id)?.authorities?.contains(userRole) ? springSecurityService.currentUser : User.get(params.uid as Long)
        def friend = User.get(params.friendid as Long)
        def result
        if (!actual)
        {
            result = [status:  0, friend: '', user: '',messages: 'No existe un usuario actual']
            render result as JSON
            return
        }


        if (!friend)
        {
            result = [status:  0, friend: '', user: '',messages: 'No existe el usuario con id: '+params.friendid]
            render result as JSON
            return
        }

        actual.addToFriend(friend)

        //Generate Event of EventType NEI004 - Add Friend
        userService.generateUserEvent(actual,friend)

        result = [status:  1, friend: friend, user: friend,messages: 'Ahora sigues a: '+friend.username]
        render result as JSON
        return

    }*/

    /*----------------------------------------------
   *
   *
   *
   *              CHECK FRIENDHIP BETWEEN 2 USERS - JUNE 24 2013 JUANDA
   *
   *
   *
   * ------------------------------------------------*/


    /*def checkFriendship(){
      def result = []
        //possible friendship values : 0--> no, 1--> user1 follows user2, 2--> user1 is followed by user2, 3--> user1 follows user2 and user1 is followed by user2
      def user1 = User.findById(params.user1 as Long)
      def user2 = User.findById(params.user2 as Long)
        if(!user1 || !user2){
          result = [status: 0, friendship: 0]  //friendship : 0 es que nadie sigue a nadie
        }
        def f1 = Friendship.findByUser1AndUser2(user1,user2) ? true : false
        def f2 = Friendship.findByUser1AndUser2(user2,user1) ? true : false

      if(f1 && f2){// el usuario 2 es seguido por el usuario 1
        result = [status: 1,friendship: 3]
      }
        else if(f1 && !f2){
            result = [status: 1,friendship: 1]
        }
        else if(!f1 && f2){
            result = [status: 1,friendship: 2]
        }
        else{
            result = [status: 1,friendship: 0]
        }
        render result as JSON
        return
        //
    }*/

    /*----------------------------------------------
    *
    *
    *
    *               FEED ACTION - MAY 19TH 2013 - Juanda
    *
    *
    *
    * ------------------------------------------------*/



   /* @Secured(["ROLE_USER"])
    def feed(){
       def user = springSecurityService.currentUser
        if(!user) return
       def extended = ExtendedUser.findByUser(user)
       if(!extended?.completed)
           redirect(uri: '/user/details', params: [userInstance: user, userPicture: userService.userImageUrl(user), extended: extended])
        [userInstance: user, vUser: user, userPicture: userService.userImageUrl(user)]
    }*/

    /*@Secured(["ROLE_USER"])
    def syncFriends(){
        def user = springSecurityService.currentUser
        if(!user) return
        def facebook = FacebookUser.findByUser(user)
        def dummy = User.findByUsername('dummyNest5')
        def existing = []
        def invite = []
        if(facebook){
            def http = new HTTPBuilder('https://graph.facebook.com')
            def json = http.get( path : '/me/friends', query : [access_token: facebook?.accessToken] )
            def qty =  json?.data?.size()
            def friends =  json?.data


            friends.each{

                def actual= User.findByUid(it.id as Long)
                if(actual) {
                    def areFriends = (Friendship.findByUser1AndUser2(user,actual) || Friendship.findByUser1AndUser2(actual,user))
                    if (!areFriends)
                        existing += actual
                }
                else{

                    invite += [id: it.id, name: it.name]
                }


            }
        }


        def imfriend = user.isFriendOf
        def followers = []

        imfriend.each{
          def already = Friendship.findByUser1AndUser2(user,it.user1)
            if ((!already) && (it.user1 != user) && (it.user1 != dummy))
                followers += [id: it.user1.id, name: it.user1.name, picture: userService.userImageUrl(it.user1)]
        }

        def followedByFriends = []
        def mine = user.friends
        def iFollow = mine.take(mine.size() > 3 ? 3 : mine.size())
        iFollow.each{aa->
            def his = ((aa.user2).friends).take(aa.user2.friends.size() > 6 ? 6 : aa.user2.friends.size())
            his.each{
                def already = Friendship.findByUser1AndUser2(user,it.user2)
                if ((!already) &&(it.user2 != user)&& (it.user2 != dummy))
                    followedByFriends += [id: it.user2.id, name: it.user2.name, picture: userService.userImageUrl(it.user2)]
            }

        }

        def i = 0
        iFollow.each{
            def already = Friendship.findByUser1AndUser2(user,it.user1)
            if ((!already)&&(it.user1 != user) && (it.user1 != dummy))
                followers += [id: it.user1.id, name: it.user1.name, picture: userService.userImageUrl(it.user1)]
        }

        def followMyBrands = []
        def brands = Relation.findAllByUser(user).collect{it.company}.take(3) //maximun 3 brands i follow

        brands.each{marca->
            def clients = marca.clients().take(10)
            clients.each{cliente->
                def amistad = Friendship.findByUser1AndUser2(user,cliente) ?: Friendship.findByUser1AndUser2(cliente,user)
                if((cliente != user)&& (!amistad) &&(cliente != dummy))
                    followMyBrands += [id: cliente.id, name: cliente.name, picture: userService.userImageUrl(cliente)]
            }

        }
        //



        def result = [status:  1, existing: existing, invite: invite,followers: followers,followedByFriends: followedByFriends, followMyBrands: followMyBrands]
        render result as JSON
        return
    }*/

    /*----------------------------------------------
    *
    *
    *
    *               COMPLETE PROFILE - MAY 21TH 2013 - Juanda
    *
    *
    *
    * ------------------------------------------------*/

    /*@Secured(["ROLE_USER"])
    def details(){

        def vUser = springSecurityService.currentUser
        def user = springSecurityService.currentUser
        if(!user) return
        def extended = ExtendedUser.findByUser(user)
        [userInstance: user,vUser: vUser,extended: extended, picture: userService.userImageUrl(user)]
    }*/

    /*@Secured(["ROLE_USER","ROLE_FACEBOOK","ROLE_ADMIN"])
    def saveDetails() {
        def ajax = request.xhr

        def user = springSecurityService.currentUser
        if(!user) return
        user.properties = params

        def extended = ExtendedUser.findByUser(user)
        println extended
        extended.properties = params
        if(params.password){//usuarios de facebook guardando detalles

            def city = City.findByCode(params.city_val) ?: City.findByCode("unknown")
            def latitude = params.lat ? new BigDecimal(params.lat) : new BigDecimal(0)
            def longitude = params.lng ? new BigDecimal(params.lng) : new BigDecimal(0)
            extended.city = city
            extended.latitude = latitude
            extended.longitude = longitude
         }
        if(ajax){
            def city = City.findByCode(params.city_val) ?: City.findByCode("unknown")
            extended.city = city

        }

        if(params.birth_date){
            def date = Date.parse('yyyy-MM-dd',params.birth_date)
            extended.birthDate = date
        }
        extended.completed = true
        def result = []
        if(!user.save(failOnError: true)){
             println user.errors.allErrors
            if(ajax){
               result = [status: 0]
            }
        }
        if(!extended.save(failOnError: true)){
            println extended.errors.allErrors
            if(ajax){
                result = [status: 0]
            }
        }
        println extended.city
        println extended.latitude
        if(!ajax){
            redirect(uri: "/user/feed")
            return
        }
         result =  [status : 1]
        springSecurityService.reauthenticate user.username
        render result as JSON
        return

    }*/

    /*def changePass(){
        def user = User.findByUsername('jaunarrop@gmail.com')
        user.password = 'farroyavefami'
        user.enabled = true
        user.accountLocked = false
        user.accountExpired = false
        user.passwordExpired = false
        user.save(flush: true)
    }*/

    /*----------------------------------------------
    *
    *
    *
    *               GET FRIEND'S ACTIVITY ON NEST5 - JUNE 4TH 2013 - Juanda
    *
    *
    *
    * ------------------------------------------------*/

//    @Secured(["ROLE_USER"])
    /*def activity(){
        def vUser = springSecurityService.currentUser
        def user = springSecurityService.currentUser
        if(!user) return
        def extended = ExtendedUser.findByUser(user)
        def friends = user.friends() //gets both friends and isFriendOf
        def events = []
        if(friends)
            events = Event.findAll("from Event as e where e.user in (:friends) order by e.date desc",[friends: friends],[max: params.max as Integer ?: 20, offset: params.offset as Integer ?: 0])
        def result =  []


        events.each {
            def comments = Comment.findAll("from Comment as c where c.event=:event order by c.date asc", [event: it], [max: 10, offset: 0])
            def commentsResult = []

            comments.each{com->

                commentsResult += [id: com.id, date: utilityService.timeFrom(com.date), content: com.content, user: [id: com.user.id, name: com.user.name, picture: userService.userImageUrl(com.user)]]
            }
            def userHearts = Heart.findByUserAndEvent(user, it) ?: false
            switch(it.type.code){
                case "NEI001":

                    result += [id: it.id, type: [code: it.type.code,name: it.type.name], message: it.toString(), user: [id: it.user.id, uid: it.user.uid,name: it.user.name,picture: userService.userImageUrl(it.user)],element:[id: it.company.id,uid: null,name: it.company.name,picture: companyService.companyImageUrl(it.company) ,stamps: it.stampCount,total_stamps: 5, store: it.store,coupons: 0], comments: commentsResult,userHearts: userHearts,userInstance: user, vUser: vUser]
                    break
                case "NEI002": //message = message(code: 'user.get.coupon', args: [it.user.name,it.company.name,"5","6" ])
                    result += [id: it.id, type: [code: it.type.code,name: it.type.name], message: it.toString(), user: [id: it.user.id, uid: it.user.uid,name: it.user.name,picture: userService.userImageUrl(it.user)],element:[id: it.company.id,uid: null,name: it.company.name,picture: "http://lorempixel.com/300/200/food/" ,stamps: 0,total_stamps: 0, store: it.store,coupons: it.couponCount], comments: commentsResult,userHearts: userHearts,userInstance: user, vUser: vUser]
                    break
                case "NEI003": //message = message(code: 'user.redeem.coupon', args: [it.user.name,it.company.name,"5","6" ])
                    break
                case "NEI004": result += [id: it.id,type: [code: it.type.code,name: it.type.name], message: it.toString(), user: [id: it.user.id, uid: it.user.uid,name: it.user.name,picture: userService.userImageUrl(it.user)],element:[id: it.oUser.id,uid: it.oUser.uid,name: it.oUser.name,picture: userService.userImageUrl(it.oUser),stamps: 0,total_stamps: 0, store:null,coupons: 0], comments: commentsResult,userHearts: userHearts]
                    break
                case "NEI005": result += [id: it.id,type: [code: it.type.code,name: it.type.name], message: it.toString(), user: [id: it.user.id, uid: it.user.uid,name: it.user.name,picture: userService.userImageUrl(it.user)],element:[id: null,uid: null,name: null,picture: null,stamps: 0,total_stamps: 0, store:null,coupons: 0], comments: commentsResult,userHearts: userHearts]
                    break
            }

        }
        render result as JSON
        return

    }*/

    /*----------------------------------------------
    *
    *
    *
    *               GO TO USER PROFILE - JUNE 16 2013 JUANDA
    *
    *
    *
    * ------------------------------------------------*/



    /*def profile(){
        if(!params.id && !springSecurityService.currentUser){
            redirect(uri: "/") //Redireccionar a registro de usuario o inicio de sesión
            return
        }



        User user = params.id ?  User.findById(params.id as Long) : springSecurityService.currentUser
        if(!user){
            redirect(uri: "/") //Redireccionar a registro de usuario o inicio de sesión
            return
        }
        User vUser = springSecurityService.currentUser
        def friends = user.friends.collect{it.user2}
        def isFriend = user.isFriendOf.collect{it.user1}
        def connections = [friend: [], isFriend: [],totalFriends: friends.size(), totalIsFriend: isFriend.size()]
        def i = 0
        while (i < 10){
          if(friends[i])
            {
                def actualF = [id: friends[i].id, name:friends[i].name,picture: userService.userImageUrl(friends[i])]
                connections.friend += actualF
            }
            if(isFriend[i])
            {
                def actualI = [id: isFriend[i].id, name:isFriend[i].name,picture: userService.userImageUrl(isFriend[i])]
                connections.isFriend += actualI
            }

            i++
        }


        def events = Event.findAllByUser(user).sort{it.date}
       def result =  []
        events.each {
            def comments = Comment.findAll("from Comment as c where c.event=:event order by c.date asc", [event: it], [max: 10, offset: 0])
            def commentsResult = []

            comments.each{com->

                commentsResult += [id: com.id, date: utilityService.timeFrom(com.date), content: com.content, user: [id: com.user.id, name: com.user.name, picture: userService.userImageUrl(com.user)]]
            }
            def userHearts = Heart.findByUserAndEvent(user, it) ?: false
            switch(it.type.code){
                case "NEI001": result += [id: it.id, type: [code: it.type.code,name: it.type.name], message: it.toString(), user: [id: it.user.id, uid: it.user.uid,name: it.user.name,picture: userService.userImageUrl(it.user)],element:[id: it.company.id,uid: null,name: it.company.name,picture: companyService.companyImageUrl(it.company) ,stamps: it.stampCount,total_stamps: 5, store: it.store,coupons: 0], comments: commentsResult,userHearts: userHearts,userInstance: user, vUser: vUser]
                    break
                case "NEI002": //message = message(code: 'user.get.coupon', args: [it.user.name,it.company.name,"5","6" ])
                    result += [id: it.id, type: [code: it.type.code,name: it.type.name], message: it.toString(), user: [id: it.user.id, uid: it.user.uid,name: it.user.name,picture: userService.userImageUrl(it.user)],element:[id: it.company.id,uid: null,name: it.company.name,picture: "http://lorempixel.com/300/200/food/" ,stamps: 0,total_stamps: 0, store: it.store,coupons: it.couponCount], comments: commentsResult,userHearts: userHearts, date: formatDate(date: it.date, format: 'yyy-MM-dd')]
                    break
                case "NEI003": //message = message(code: 'user.redeem.coupon', args: [it.user.name,it.company.name,"5","6" ])
                    break
                case "NEI004": result += [id: it.id,type: [code: it.type.code,name: it.type.name], message: it.toString(), user: [id: it.user.id, uid: it.user.uid,name: it.user.name,picture: userService.userImageUrl(it.user)],element:[id: it.oUser.id,uid: it.oUser.uid,name: it.oUser.name,picture: userService.userImageUrl(it.oUser),stamps: 0,total_stamps: 0, store:null,coupons: 0], comments: commentsResult,userHearts: userHearts, date: formatDate(date: it.date, format: 'yyy-MM-dd')]
                    break
                case "NEI005": result += [id: it.id,type: [code: it.type.code,name: it.type.name], message: it.toString(), user: [id: it.user.id, uid: it.user.uid,name: it.user.name,picture: userService.userImageUrl(it.user)],element:[id: null,uid: null,name: null,picture: null,stamps: 0,total_stamps: 0, store:null,coupons: 0], comments: commentsResult,userHearts: userHearts]
                    break

            }

        }

        def stamps = Stamp.findAllByUser(user,[max: 10, offset: 0]).sort{it.date}
        def tiendas = stamps.collect{it.store}.toList().unique()

        println tiendas
        [userInstance: user,vUser: vUser,friends: friends, isFriendOf: isFriend,connections: connections,eventList: result,stores: tiendas, picture: userService.userImageUrl(user)]
    }*/

    /*----------------------------------------------
   *
   *
   *
   *               GO TO USER INFO PAGE - JUNE 20 2013 JUANDA
   *
   *
   *
   * ------------------------------------------------*/


   /* @Secured(["ROLE_USER"])
    def info(){
        def user = springSecurityService.currentUser
        def vUser = springSecurityService.currentUser
        if(!user) return
        def extended = ExtendedUser.findByUser(user)
        def fsqLink = "https://es.foursquare.com/oauth2/authorize?client_id="+grailsApplication.config.grails.nest5.foursquare.clientId+"&response_type=code&redirect_uri="+grailsApplication.config.grails.nest5.foursquare.redirectUri
        [userInstance: user, extended: extended, picture: userService.userImageUrl(user), fsqLink: fsqLink, vUser: vUser]

    }*/


    /*@Secured(["ROLE_USER"])
    def cards(){
        def user = springSecurityService.currentUser
        def vUser = springSecurityService.currentUser
        if(!user) return
        def extended = ExtendedUser.findByUser(user)
//        def fsqLink = "https://es.foursquare.com/oauth2/authorize?client_id="+grailsApplication.config.grails.nest5.foursquare.clientId+"&response_type=code&redirect_uri="+grailsApplication.config.grails.nest5.foursquare.redirectUri
        [userInstance: user, extended: extended, picture: userService.userImageUrl(user), vUser: vUser]
    }*/

    /*@Secured(["ROLE_USER"])
    def benefits(){
        def user = springSecurityService.currentUser
        def vUser = springSecurityService.currentUser
        if(!user) return
        def extended = ExtendedUser.findByUser(user)
//        def fsqLink = "https://es.foursquare.com/oauth2/authorize?client_id="+grailsApplication.config.grails.nest5.foursquare.clientId+"&response_type=code&redirect_uri="+grailsApplication.config.grails.nest5.foursquare.redirectUri
        [userInstance: user, extended: extended, picture: userService.userImageUrl(user), vUser: vUser]
    }*/


    /*----------------------------------------------
   *
   *
   *
   *              SIMPLIFIED USER REGISTER, ONLY EMAIL, NAME AND ADDRESS FOR CARD AND LETTER - JUNE 23 2013 JUANDA
   *
   *
   *
   * ------------------------------------------------*/


    /*def simpleCreate(){
        def result  = []
        //enviar email, crear extended con address
        def userRole = SecRole.findByAuthority('ROLE_USER')
        println params
        def email = params.email
        def user = new User(
                name: params.name,
                email: email,
                username: email,
                date: "00/00/0000",
                phone: "0000000",
                referer: "none",
                password: params.password,
                enabled: true,
                accountExpired: false,
                accountLocked: false,
                passwordExpired: false,
                magnetic5: "0000000000000000"
        )
        if(!user.save(flush: true)){
            result = [status: 0, errors: "hubo errores creando el usuario, inténtalo de nuevo."]
            println user.errors.allErrors
        }
        SecUserSecRole.create user,userRole
        def longi = params.lat ? new BigDecimal(params.lat) : new BigDecimal(0)
        def lati =  params.lng ? new BigDecimal(params.lng) :  new BigDecimal(0)
        def city = City.findByCode(params.city) ?: City.findByCode("unknown")
        def extended = new ExtendedUser(
                user: user,
                bio: "",
                gender: "unknown",
                birthDate: new Date(),
                accessToken: "0",
                working: false,
                educated: false,
                completed: false,
                twitterUser: "",
                fqAccessToken: "0",
                address: params.address ?: "",
                city: city,
                latitude: lati,
                longitude: longi
        )
        if(!extended.save(flush : true)){
            result = [status: 0, errors: "hubo errores creando el usuario, inténtalo de nuevo."]
            println extended.errors.allErrors

        }
        if(session.referer)
        {
            def inv = Invitation.findById(session.referer as Long)
            if(inv){
                inv.registered = true
                inv.dateRegistered = new Date()
                inv.registeredUser = user
                inv.email = user.email
                inv.save(flush: true)
                session.referer = null
                session.invalidate()
            }
        }

        render result as JSON
        return
    }*/
    /*
    *
    *    SEND INVITATION TO MAXIMUN 10 FRIENDS -- JUNE 25 2013 JUANDA
    *
    *
    * */

//    @Secured(["ROLE_USER"])
    /*def inviteFriends(){

        def user = springSecurityService.currentUser
        if(!user) return
        def picture = userService.userImageUrl(user)
        def all = params.emails
        def emails = all?.split(",")*.trim()
        def sent = Invitation.findAllByUser(user)
        def enviar = emails

        if (sent.size() - emails.size() < 0){
             enviar = emails.take(emails.size()-sent.size())
        }

        if(enviar instanceof List) {

            emails.each{actual->

                //generar un código que si se inscribe se gaurde en bd que los dos usuarios son referidos uno del otro
                def inv = new Invitation(
                        type: 'email',
                        user: user,
                        email: actual,
                        uid: '0',
                        date: new Date(),
                        registered: false,
                        opened: false,
                        dateOpened: new Date(),
                        dateRegistered: new Date(),
                        registeredUser: User.findByUsername('dummyNest5')

                ).save(flush: true)
                userService.sendInvitationMail(user, picture,actual,inv)


            }
        }
        else{

            userService.sendInvitationMail(user, picture,enviar)
        }

        def result = [status: 1]
        render result as JSON
        return
    }*/

    def invite(long id){

        def inv = Invitation.findById(id)
        if(inv){
            session.referer = id
            inv.opened = true
            inv.dateOpened = new Date()
            inv.save(flush:true)
        }

        else
            session.referer = null
        //llevar al landing page, y al guardar, ver si hay sesión, si lo hay guardar el referido

        [invite: inv]

    }



   /*
    *
    *    FOLLOW BRAND (BECOME CUSTOMER) - JUANDA JULY 1 2013
    *
    *
    * */

//    @Secured(["ROLE_USER","ROLE_ADMIN"])
    def followBrand(){
       User user = springSecurityService.currentUser
        if(!user) return
        def brand = Company.findById(params.company as Long)
        def result = []
        if(!brand){
           result = [status: 0, message: "no existe la marca seleccionada", brand: [id: null, name: null, picture: null ]]
            render result as JSON
            return
        }
        user.addToCompany(brand)
        //generar Evento de usuario siguiendo marca
        result = [status: 1, message: "Siguiendo marca con éxito", brand: [id: brand.id, name: brand.name, picture: companyService.companyImageUrl(brand) ]]
        render result as JSON
        return

    }

//    @Secured(["ROLE_USER","ROLE_ADMIN"])
    def suggestBrands(){
        def user = springSecurityService.currentUser
        if(!user) return
        def brands = Company.findAll()
        def result = []
        def dummy = Company.findByUsername('dummyCompany')
        brands.each{actual->
            def relation = Relation.findByCompanyAndUser(actual, user)
            if ((actual != dummy)&& !relation)
                result += [id: actual.id, name: actual.name, picture: companyService.companyImageUrl(actual)]
        }
        render result as JSON
        return
    }


    /*List Users*/

   /* def prefetchListUsers(){
        def user = springSecurityService.currentUser
        def users = User.findAll([max: 200, offset: 0])
        def results = []
        users.each {actual->

                def tokens = []
                def partes = actual.name.split(" ")
                partes.each{part->
                    tokens += part
                }
                results += [id: actual.id,name: actual.name,picture: userService.userImageUrl(actual),tokens: tokens]


        }
        render results as JSON
        return
    }*/

    /*def findUser(){
        def query =  params.q
        def users = User.findAllByUsernameOrName(query,query)
        def emails = User.findAllByEmail(query)
        users = users + emails
        def results = []
        users.each {actual->

            def tokens = []
            def partes = actual.name.split(" ")
            partes.each{part->
                tokens += part
            }
            results += [id: actual.id,name: actual.name,picture: userService.userImageUrl(actual),tokens: tokens]


        }
        render results as JSON
        return
    }*/

    /*@Secured(["ROLE_USER"])
    def myBrands(){
        def user = springSecurityService.currentUser
        def response = []
        if(!user){
            return
        }
        def brands = user.brands().unique()

        brands.each{
            response += [id: it.id, name: it.name, picture: companyService.companyImageUrl(it)]
        }
        render response  as JSON
        return
    }*/

    /*@Secured(["ROLE_USER"])
    def myFriends(){
        User user = springSecurityService.currentUser
        def friends = user.friends.collect{it.user2}
        def isFriend = user.isFriendOf.collect{it.user1}
        def connections = [friend: [], isFriend: [],totalFriends: friends.size(), totalIsFriend: isFriend.size()]
        def i = 0
        def max = Math.max(connections.totalFriends, connections.totalIsFriend)
        while (i < max){
            if(friends[i])
            {
                def actualF = [id: friends[i].id, name:friends[i].name,picture: userService.userImageUrl(friends[i])]
                connections.friend += actualF
            }
            if(isFriend[i])
            {
                def actualI = [id: isFriend[i].id, name:isFriend[i].name,picture: userService.userImageUrl(isFriend[i])]
                connections.isFriend += actualI
            }

            i++
        }

        render connections as JSON

        return
    }*/

    /*@Secured(["ROLE_USER"])
    def messageBrand(){
        def user = springSecurityService.currentUser
        def result
        if(!user){
            result = [status: 0, message: "No existe el usuario"]
            render result as JSON
            return
        }
        def company = Company.findById(params.id as Long)
        if(!company){
            result = [status: 0, message: "No existe la Marca"]
            render result as JSON
            return
        }
        def message = params.message
        user.addToChat(company,message)
        userService.generateStatusEvent(user,message)
        result = [status: 1, message: "publicado con exito"]
        render result as JSON
        return


    }*/
    /*@Secured(["ROLE_USER"])
    def setStatus(){
        def user = springSecurityService.currentUser
        def result
        if(!user){
            result = [status: 0, message: "No existe el usuario"]
            render result as JSON
            return
        }

        def message = params.message

        userService.generateStatusEvent(user,message)
        result = [status: 1, message: "publicado con exito"]
        render result as JSON
        return


    }*/

    /*@Secured(["ROLE_USER"])
    def myChats(){
        User user = springSecurityService.currentUser
        def chats = user.chats().unique()
        def connections = [chats: [],totalChats: chats.size()]
        def i = 0

        while (i < connections.totalChats){
            if(chats[i])
            {

                def lastMessage = Message.findByUserAndCompany(user, chats[i],[sort:"time", order:"desc"])

                def actualF = [id: chats[i].id, name:chats[i].name,picture: companyService.companyImageUrl(chats[i]),lastMessage: lastMessage.message]
                connections.chats += actualF
            }


            i++
        }

        render connections as JSON

        return
    }*/


//    Reegistrar usuario de manera manual en punto de venta o lugar publico

    def manual(){

        def empresas = Company.list()
        def companies = empresas.findAll{it.name != "Dummy Company" }
       [companies: companies,prueba: "esta es la prueba de controlador"]
    }


    def capture(){
       def companyid = params.company
        def company
        if(companyid){
            company = Company.findById(companyid as Long)
            if(!company){
                redirect(action: 'manual')
            }
            else{

            }
        }
        else{
            def name = params.name_company ?: ""
            def address = params.address_company ?: ""
            if(name == "" || address == "") redirect action: 'manual'
            def pass = userService.generateUserPassword()
            def username = companyService.generateUserName(name)
             company = new Company(

                    category: Category.findByName('Ninguna') ?: new Category(name: 'Ninguna', description: 'Sin clasificacion posible.',icon: icon).save(failOnError: true),
                    username: username,
                    password:  pass,
                    enabled: true,
                    name : name,
                    address: address,
                    telephone: "00",
                    contactName: "NA",
                    email: username+"@nest5.com",
                    nit: "0000",
                    logo : " ",
                    url : "http://",
                    registerDate: new Date(),
                    active: false
            ).save(failOnError: true)
            //Enviar correo a admin y vendedores con usuario y clave de nueva empresa creada para luego poder contactarlos en caso que sea necesario, aca empieza el proceso de que un usuario pueda pedir una empresa con las cooredenadas actuales
            companyService.sendCreatedContactMail(username,pass)
        }
        return [company: company]
    }
    /*----------------------------------------------
 *
 *
 *
 *              SIMPLIFIED USER REGISTER USED FOR SALES PERSON TO REGISTER USER MANUALLY IN PUBLIC PLACES, - October 25 2013 JUANDA
 *
 *
 *
 * ------------------------------------------------*/


    def manualCreate(){
//        println params


        def result  = []
        //enviar email, crear extended con address
        def userRole = SecRole.findByAuthority('ROLE_USER')
        def email = params.email
        def pass =  userService.generateUserPassword()
        if(params.name == "" || params.address == ""){
            result = [status: 0, errors: "hubo errores creando el usuario, inténtalo de nuevo."]
            render result as JSON
        }
        def user = new User(
                name: params.name,
                email: email,
                username: email,
                date: "00/00/0000",
                phone: "0000000",
                referer: "none",
                password: pass,
                enabled: true,
                accountExpired: false,
                accountLocked: false,
                passwordExpired: false,
                magnetic5: "0000000000000000"
        )
        if(!user.save(flush: true)){
            result = [status: 0, errors: "hubo errores creando el usuario, inténtalo de nuevo."]
            println user.errors.allErrors
            render result as JSON
            return
        }
        SecUserSecRole.create user,userRole
        /*def longi = params.lat ? new BigDecimal(params.lat) : new BigDecimal(0)
        def lati =  params.lng ? new BigDecimal(params.lng) :  new BigDecimal(0)*/
        def city = City.findByCode(params.city) ?: City.findByCode("unknown")
        def isSmart = params.method == 'smartphone'
        def extended = new ExtendedUser(
                user: user,
                bio: "",
                gender: params.gender ?: "unknown",
                birthDate: new Date(),
                accessToken: "0",
                working: false,
                educated: false,
                completed: false,
                twitterUser: "",
                fqAccessToken: "0",
                address: params.address ?: "",
                city: city,
                latitude: 0,
                longitude: 0,
                nfc: !isSmart,
                smartphone: isSmart
        )
        if(!extended.save(flush : true)){
            result = [status: 0, errors: "hubo errores creando el usuario, inténtalo de nuevo."]
            println extended.errors.allErrors
            render result as JSON
            return

        }
        def company = Company.findById(params.company_id as Long)
        if(!company)
        {
            result = [status: 0, errors: "no existe la empresa que esta registrando"]
            render result as JSON
            return
        }
        user.addToCompany(company)
        result = [status: 1, errors: "usuario creado con exito"]
//        enviar correo
        userService.captureEmail(user,company, pass)
        render result as JSON
        return





    }
}
