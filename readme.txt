first build base_component
build microservice1, microservice2

both rabbitMQ and mongoDB are defined on localhost, to change it just replace the hostname in the applicationContext class (microservice1 - rabbitMQ, microservice2 -MongoDB)

microservice1 - The producer, will run on port 8080 by default (can be modified from applicationContext)
				has API to process transaction - "/api/v1/transactions/processTransaction" expect json "{currency:<currency>, amount:<amount>}" 
				currency is Enum defined in base_component - currently there are only NIS, USD, GBP 
				
				example for curl call to check this API - curl -H "Content-Type:application/json; charset=utf-8"  -X POST "http://localhost:8080/api/v1/transactions/processTransaction" -d "{\"currency\":\"NIS\",\"amount\":\"150\"}"
				

microservice2 - The consumer, will listen to any new message recevied from rabbitMQ and procees it, then save to MongoDB
