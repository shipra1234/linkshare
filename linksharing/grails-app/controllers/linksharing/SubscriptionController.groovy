package linksharing

class SubscriptionController {
         def subscriptionService
   def index()
   {
       Topic topic=Topic.get(params.topic)
       Subscription subscription=Subscription.get(params.subscriptionId)
       String username=session.getAttribute('user')
        String message= subscriptionService.update(username,topic,subscription)
       flash.message=message
       redirect(controller:'topic',action:'renderTopic',params:[topic:params.topic])
   }
}
