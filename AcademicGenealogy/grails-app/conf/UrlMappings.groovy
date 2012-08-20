class UrlMappings {

	static mappings = {
		"/$controller/$action?/$id?"{
			constraints {
				// apply constraints here
			}
		}
		//home changed from index view to academic controller
		"/"(controller: "academic", action:"find")
		//"/" (view: "index")
		"500"(view:'/error')
		"/super"(controller: "user")
	}
}