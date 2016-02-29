class UrlMappings {

	static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }

        "/"(view:"/index")
        "500"(view:'/error')

        "/transaction"{
            controller = "transactionInfo"
            action = [ GET:"showTransaction", POST: "submitAccount"]
        }

        "/pay"{
            controller = "transaction"
            action = [ GET:"showPay", POST: "payToAccount"]
        }
	}
}
