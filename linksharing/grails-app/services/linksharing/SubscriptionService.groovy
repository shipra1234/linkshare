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
}
