package linksharing

class ResourceController {

    def resourceService
    List des = []
    List userName = []

    def index() {
        Resource resource = Resource.get(1)
        println "==========" + resource.topic.user.firstName
        println "==========" + resource.topic.name
        println "==========" + resource.topic.resource
    }

    def createLink(String link, String description, String topic, String title) {
        String user = session.getAttribute("user")
        resourceService.linkResource(link, description, topic, title, user)
        ReadingItemService readingItemService = new ReadingItemService(topic)
        flash.message = "Link Created Successfully"
        List<Resource> res = resourceService.userResource(user)
        res.each { docs ->
            des.add(docs.description)
            userName.add(docs.user)

        }
        render(view: '/dashboard/dashboard', model: [resource1: des[0], resource2: des[1], user1: userName[0], user2: userName[1]])


    }

    def createDocument(String description, String topic, String title) {
        String user = session.getAttribute("user")
        def document = request.getFile('document')
        resourceService.documentResource(document, description, topic, title, user)
        flash.message = "Document Created Successfully"
        redirect(controller:'dashboard',action:'index')


    }

    def viewDocument() {
        Resource resource = Resource.get(params.resource)
        println "++++++++Resource+++++++++" + resource
        // DocumentResource document= resourceService.viewData(resource)
        Topic topic = resource.topic
        if (resource.class == linksharing.DocumentResource) {
            DocumentResource documentResource = DocumentResource.findByTopic(topic)
            def createOrderPDF = {
                byte[] orderPDF = documentResource.filePath // create the bytes from some source
                response.setHeader("Content-disposition", "attachment; filename=" + resource.topic.name)
                response.contentType = contentType
                response.contentLength = bytes.length
                response.outputStream << bytes
            }
            flash.message = "download successfull"
            redirect(controller: 'dashboard', action: 'index')

        }
    }
}

