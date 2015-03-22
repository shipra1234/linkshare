class UrlMappings {

	static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }

     "/"(controller:'login',action:'signUp')
     //   "/"(view:'/layouts/dashboard_layout')
      //  "/"(view:'pagination')
     //  "/"(controller:'paginate',action:'count')

	}
}
