class UrlMappings {

	static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }

//        "/"(controller: 'filterRequest', action: 'index')
        "500"(view:'/error')
	}
}
