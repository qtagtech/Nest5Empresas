class UrlMappings {

    static mappings = {
        "/$controller/$action?/$id?"{
            constraints {
                // apply constraints here
            }
        }

        "/"(view:"/posindex")
        "/download"(view:"/download")
        "/invitationmail"(view:"/emails/invite")
        "/fba"(view:"/user/landingfba")
        "/privacy"(view: "/privacy")
        "/user/landing/$referer?"(controller: "user",action: "landing")
        "500"(view:'/error')
        "404"(view: '/404')

    }
}
