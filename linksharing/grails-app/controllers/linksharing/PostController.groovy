package linksharing

class PostController {
    def postService

    def showPost() {
        String username=session.getAttribute('user')
        List<ResourceRating> resources = postService.showData(username)
        String user=resources.get(0)
        String firstName=resources.get(1)
        String resource=resources.get(2)
        render(view:"post",model:[resource:resource,username:user,firstName:firstName])
    }
}
