package linksharing

class SearchController {
    def dashboardService
    def searchService
    def loginService
    def topicSearch() {

        params.max = params.max ? params.int('max') : 5
        params.offset = params.offset ? params.int('offset') : 0
        String username= session.getAttribute('user')
        List<Resource> resourceList=searchService.searchResource(params.topic)
        Integer post=dashboardService.showPost(username)
        List subscription=dashboardService.subscription(username)
        Integer subscriptionCount=subscription[1]
        List<Resource> resources= loginService.showPost()
        render(view:'search',model:[resourceList:resourceList,post:post,subscription:subscriptionCount,resources:resources])


    }
}
