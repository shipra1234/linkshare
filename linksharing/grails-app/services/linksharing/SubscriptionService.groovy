package linksharing

import grails.transaction.Transactional

@Transactional
class SubscriptionService {

    def subscription(String topicName,String username) {
        User user=User.findByUsername(username)
        Topic topic=Topic.findByName(topicName)
          Subscription sub=new Subscription(topic:topic,user:user,seriousness:Subscription.Seriousness.SERIOUS)

            sub.save(flush: true, failOnError: true)
    }

    def update(String username,Topic topic,Subscription subscription){
        User user=User.findByUsername(username)
        if(topic.user==user)
        {
            String message="you can not unsubscribe the topic"
            return message
        }
        else{

            subscription.executeUpdate("delete Subscription where id=(:id)", [id:subscription.id])
                String message="unsubscribe successfully"
                   return message

        }
    }
}
