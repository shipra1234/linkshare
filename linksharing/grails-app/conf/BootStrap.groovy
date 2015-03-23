
class BootStrap {
    def bootstrapService
    def init = { servletContext ->

        bootstrapService.createUser()
        bootstrapService.createTopics()
        bootstrapService.subscription()
        bootstrapService.resource()
        bootstrapService.readingItems()
        bootstrapService.rating()
    }

    def destroy = {
    }

}