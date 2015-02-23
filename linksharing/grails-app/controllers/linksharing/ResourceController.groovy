package linksharing

class ResourceController {

    def index()
    {
        Resource resource=Resource.get(1)
        println "=========="+        resource.topic.user.firstName
        println "=========="+        resource.topic.name
        println "=========="+        resource.topic.resource
    }
}
