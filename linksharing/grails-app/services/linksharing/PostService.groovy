package linksharing

import grails.transaction.Transactional

@Transactional
class PostService {

    def showData() {
      Integer rating=ResourceRating.createCriteria().get{
          projections{
              max "score"
          }

      }
        ResourceRating rating1=ResourceRating.findByScore(rating)
        Resource resource=rating1.resource
        return resource

    }
    def topic(){
        List <Topic> topicList=[]
        def topics = Resource.createCriteria().list([max:5,offset:0]) {
            projections {
                groupProperty("topic")
                rowCount('count')
            }
            order('count','desc')
        }

        topics.each { topic->
              Topic topic1= topic[0]
            topicList << topic1

        }
       return  topicList
    }
}

