package linksharing

import grails.converters.JSON
import grails.transaction.Transactional

@Transactional
class TopicService {

  def createTopic(String name,String visibility,String username){
      Topic topic=new Topic(name:name,visibility:visibility)
      User user= User.findByUsername(username)
      topic.validate()
      if(topic.hasErrors())
      {
         String msg="Validation errors"
          return msg
      }
      else {
          user.addToTopic(topic)
          user.save(flush: true, failOnError: true)
          Subscription subscription=new Subscription(topic:topic,user:user,seriousness:Subscription.Seriousness.SERIOUS)
          subscription.save(flush:true,failOnError:true)
          String msg="topic created"
          return  msg
      }

    }
    def searchTopic(String topicName){
            Topic topic = Topic.findByName(topicName)
            if(topic!=null) {
                List<Resource> resource = Resource.findAllByTopic(topic)
                return resource
            }
        else{
                println "try again"
            }
    }
    def renderTopic(Topic topic){
       List<Resource> resources=Resource.findAllByTopic(topic,[max:5,offset:0])
        return resources

    }
    def user(List<Resource> resources){
        List user=[]
        List topic=[]


    }
    def showResourceItems(Topic topic,Integer max, Integer offset){
        List<Resource> resourceList=Resource.findAllByTopic(topic,[max:max,offset:offset])
        println "++++paginate++++++" +resourceList
        //Resource countResource=Resource.countByTopic(topic)
//        List items=[]
//        items << resourceList
//        items << countResource
//        return items
        return resourceList

    }
}
