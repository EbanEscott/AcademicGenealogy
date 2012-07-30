class UrlMappings {

	static mappings = {
		"/$controller/$action?/$id?"{
			constraints {
				// apply constraints here
			}
		}
		//"/tree"(controller:"tree", action:"index")
		"/"(view:"/index")
		"500"(view:'/error')
	}
}