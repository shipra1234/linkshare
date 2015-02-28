class UrlMappings {

	static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }
        "/"(controller:'login',action:'signUp')
          //   "/"(view:'/dashboard')
        "500"(view:'/error')
	}
}
