

import linksharing.User
import linksharing.Topic
import linksharing.Subscription
class BootStrap {
    User user
    User user2
    Topic topic1
    Topic topic2
    Topic topic3
    Topic topic4
    Topic topic5
    def init = { servletContext ->

       createUser()
       createTopics()
        subscription()
    }

    def destroy = {
    }

    def createUser={

      user=  new User(username:'shipratayal',email:'sttayalshipra@gmail.com',password:'shipra',firstName:'shipra',lastName:'tayal',admin:'true',active:'true')
       user2=new User(username:'shailytayal',email:'sttayalshipra@gmail.com',password:'shipra',firstName:'shaily',lastName:'tayal',admin:'true',active:'true')


    }

    def createTopics={


         topic1=new Topic(name:'grails')
         topic2=new Topic(name:'groovy')
         topic3=new Topic(name:'html')
         topic4=new Topic(name:'java')
         topic5=new Topic(name:'jquery')
        user.addToTopic(topic1)
        user.addToTopic(topic2)
        user.addToTopic(topic3)
        user.addToTopic(topic4)
        user.addToTopic(topic5)

        user2.addToTopic(topic1)
        user2.addToTopic(topic2)
        user2.addToTopic(topic3)
        user2.addToTopic(topic4)
        user2.addToTopic(topic5)
        user.save()
        user2.save()


    }
    def subscription={

        Subscription sub1=new Subscription(seriousness: 'very Serious')
            sub1.user=user
            sub1.topic=topic1

    }


}

