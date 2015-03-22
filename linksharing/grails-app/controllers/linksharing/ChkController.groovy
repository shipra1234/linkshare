package linksharing

class ChkController {
    def resourceService

    def index() {
        List des=[]
        List user=[]
        List<Resource> resources=resourceService.resource()
        resources.each {res->
            des.add(res.description)
            user.add(res.user)
        }
        render(view:'/home',model:[resource1:des[0],resource2:des[1],resource3:des[2],user1:user[0],user2:user[1],user3:user[2]])

    }
    def userList()
    {
        render(view:"/login/userList")
    }
    def forgetPassword(){
        render(view:"/forget_password")
    }


}
