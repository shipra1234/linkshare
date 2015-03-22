package linksharing

import grails.converters.JSON

class TopicController {
    static allowedMethods = [searchTopic:'POST',topicPaginate:'POST']
    def resourceService
     def topicService
    def dashboardService
    def subscriptionService
    List des=[]
    def saveTopic(String topicName,String visibility){
        println "name+++++++++++" +topicName
        String user = session.getAttribute("user")
        List errors=  topicService.createTopic(topicName,visibility,user)
          if(errors)
          {
              flash.msg=errors
              redirect(controller:'dashboard',action:'index')
          }
        else {
              flash.message = "Topic Created Successfully"
              redirect(controller:'dashboard',action:'index')
          }


    }
    def showTopic()
    {
        Topic topic=Topic.get(params.topic)
        render(view:'showTopic')
    }
    def searchTopic(String resource) {
        println "params+++++++++" +params
           println "+++++resource++++"+resource
        List<Resource> resources=Resource.createCriteria().list(max:5,offset:0) {
            ilike("description","%${resource}%")
        }

        if(resources!=[]){
            println "+++++++resources++++" +resources
            String updatedResourcesHtml=ls.inbox(resources:resources)

            render([status:true,updatedResourcesHtml:updatedResourcesHtml]as JSON)
        }
        else{
            flash.message="Resource is not found"
            render([status:false,mess:flash.message]as JSON)

        }
        }
    def renderTopic(){
        params.max = params.max ? params.int('max') : 5
        params.offset = params.offset ? params.int('offset') : 0
       String username= session.getAttribute('user')
        Topic topic=Topic.get(params.topic)
       List<Resource> resources=topicService.renderTopic(topic)
        Integer post=dashboardService.showPost(username)
        List subscription=dashboardService.subscription(username)
        Integer subscriptionCount=subscription[1]
        Integer count=Resource.countByTopic(topic)
        render(view:'showTopic',model:[resources:resources,post:post,subscription:subscriptionCount,topic:topic,count:count])

    }
    def topicPaginate(){
        Topic topic=Topic.get(params.topic)
        println "topic+++++++++"+topic
        params.max = params.max ? params.int('max') : 5
        params.offset = params.offset ? params.int('offset') : 0
        List<Resource> resources1 = topicService.showResourceItems(topic,params.max,params.offset)
        render(template: "/user/showList",  model: [resources:resources1])
    }


    }

