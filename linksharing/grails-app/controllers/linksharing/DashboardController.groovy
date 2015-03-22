package linksharing

import grails.converters.JSON

class DashboardController {
  def dashboardService
    def mailService
    static allowedMethods = [searchResource:'POST',resourcePaginate:'POST',editData:'POST']
    def index() {
        params.max = params.max ? params.int('max') : 5
        params.offset = params.offset ? params.int('offset') : 0
        String userName = session.getAttribute("user")
        User user=User.findByUsername(userName)
        String topicName=dashboardService.showTopic(userName)
        List data = dashboardService.showReadItems(userName,params.max,params.offset)
        List<Resource> resources=data[1]
        Integer count=data[0]
        Integer post=dashboardService.showPost(userName)
        List subscription=dashboardService.subscription(userName)
        Integer subscriptionCount=subscription[1]
        List<Topic> topics=subscription[0]
        List<ReadingItem> isRead=subscription[2]
        render(view:'dashboard',model:[resources:resources,count:count,post:post,subscription:subscriptionCount,
                                       topicName:topicName,topics:topics,user:user,isRead:isRead])

    }
    def searchResource(String resource){
         println "++++++++++resource+++++++++" +resource
        List<Resource> resources=Resource.createCriteria().list(max:5,offset:0) {
            ilike("description","%${resource}%")

        }
        if(resources!=[]){
               String updatedResourcesHtml=ls.inbox(resources:resources)
               println resources.topic
            render([status:true,updatedResourcesHtml:updatedResourcesHtml]as JSON)
        }
        else{
            flash.message="Resource is not found"
            render([status:false,mess:flash.message]as JSON)

        }

    }
    def resourcePaginate(){
        params.max = params.max ? params.int('max') : 5
        params.offset = params.offset ? params.int('offset') : 0
        String userName = session.getAttribute("user")
        List data = dashboardService.showReadItems(userName,params.max,params.offset)
        List<Resource> resources=data[1]
        render(template: "/user/showList", model: [resources:resources])
    }
    def editData(){
        String seriousness=params.seriousness
        String topic=params.topic
        String username=session.getAttribute("user")
      String seriousness1=  dashboardService.edit(seriousness,username,topic)
        flash.message="Update data successfully"
        render([status:true,mess:flash.message,seriousness1:seriousness1]as JSON)
    }
    def editVisibility(){
        String visibility=params.visibilty
        String topic=params.topic
        String username=session.getAttribute("user")
        dashboardService.editVisibility(visibility,username,topic)
        flash.message="Update data successfully"
        render([status:true,mess:flash.message]as JSON)

    }

    def sendInvitation(String email,String topic){
        String username=session.getAttribute('user')
        Topic topic1=Topic.findByName(topic)
        String link = g.createLink(controller: 'topic', action: 'renderTopic',
                absolute: true, params: [username: "${username}",topic:"${topic1.id}"])
        dashboardService.invite(email,topic,username,link,mailService)
        flash.message = "link send in your gmail account"
        redirect(controller: 'dashboard', action: 'index')
           }

}
