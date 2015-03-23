package linksharing

class PostController {
    def postService
    def dashboardService
    def showPost() {

        Resource resource = postService.showData()

        render(view: "post", model: [resource: resource, username: user, firstName: firstName])
    }

    def trendingTopic() {
        String username=session.getAttribute('user')
         List topicList= postService.topic()
        Integer post=dashboardService.showPost(username)
        List subscription=dashboardService.subscription(username)
        Integer subscriptionCount=subscription[1]
        Resource resource = postService.showData()
        render(view:'post',model:[topicList:topicList,post:post,subscription:subscriptionCount,resource:resource])

    }
}
