import linksharing.Resource
import linksharing.User
import linksharing.Topic
import linksharing.Subscription
import linksharing.LinkResource
import linksharing.DocumentResource
import linksharing.ReadingItem
class BootStrap {
    User user
    User user2
    Topic topic1
    Topic topic2
    Topic topic3
    Topic topic4
    Topic topic5
    Topic topic6
    Topic topic7
    Topic topic8
    Topic topic9
    Topic topic10
    def init = { servletContext ->

       createUser()
       createTopics()
        subscription()
        resource()
        readingItems()

    }

    def destroy = {
    }

    def createUser={
        log.info "Creating users.."

            user = new User(username: 'shipratayal', email: 'sttayalshipra@gmail.com', password: 'shipra', firstName: 'shipra', lastName: 'tayal', admin: 'true', active: 'true')
            user2 = new User(username: 'shailytayal', email: 'sttayalshipra@gmail.com', password: 'shipra', firstName: 'shaily', lastName: 'tayal', admin: 'true', active: 'true')
            user.save()
            user2.save(flush:true)

        log.info "User creation successfully"
    }

    def createTopics={
        log.info "Creating topics"
        Topic topicChk=Topic.get(1)

        println "++++++---------------"+topicChk
        if(topicChk==null) {
            User user3 = User.findByUsername('shipratayal')
            User user4 = User.findByUsername('shailytayal')

            topic1 = new Topic(name: 'grails', visibility: Topic.Visibility.PUBLIC)
//        topic1.save(flush: true, failOnError: true)

            topic2 = new Topic(name: 'groovy', visibility: Topic.Visibility.PUBLIC)
            topic3 = new Topic(name: 'html', visibility: Topic.Visibility.PUBLIC)
            topic4 = new Topic(name: 'java', visibility: Topic.Visibility.PUBLIC)
            topic5 = new Topic(name: 'jquery', visibility: Topic.Visibility.PUBLIC)
            topic6 = new Topic(name: 'grails', visibility: Topic.Visibility.PUBLIC)
//        topic1.save(flush: true, failOnError: true)

            topic7 = new Topic(name: 'groovy', visibility: Topic.Visibility.PUBLIC)
            topic8 = new Topic(name: 'html', visibility: Topic.Visibility.PUBLIC)
            topic9 = new Topic(name: 'java', visibility: Topic.Visibility.PUBLIC)
            topic10 = new Topic(name: 'jquery', visibility: Topic.Visibility.PUBLIC)

            user3.addToTopic(topic1)
            user3.addToTopic(topic2)
            user3.addToTopic(topic3)
            user3.addToTopic(topic4)
            user3.addToTopic(topic5)
            user3.save(flush:true)

            user4.addToTopic(topic6)
            user4.addToTopic(topic7)
            user4.addToTopic(topic8)
            user4.addToTopic(topic9)
            user4.addToTopic(topic10)

            user4.save(flush: true)
        }

        log.info "topics creation done."
    }
    def subscription={

        User user5=User.findByUsername('shipratayal')
        User user6=User.findByUsername('shailytayal')
        Topic topic11=Topic.findById(1)
        Topic topic12=Topic.findById(2)
        Topic topic13=Topic.findById(3)
        Topic topic14=Topic.findById(4)
        Topic topic15=Topic.findById(5)
        Topic topic16=Topic.findById(6)
        Topic topic17=Topic.findById(7)
        Topic topic18=Topic.findById(8)
        Topic topic19=Topic.findById(9)
        Topic topic20=Topic.findById(10)

        Subscription sub1=new Subscription(user:user5,topic:topic11, seriousness:Subscription.Seriousness.SERIOUS).save(flush: true)
        Subscription sub2=new Subscription(user:user5,topic:topic12, seriousness:Subscription.Seriousness.SERIOUS).save(flush:true)
        Subscription sub3=new Subscription(user:user5,topic:topic13, seriousness:Subscription.Seriousness.SERIOUS).save(flush:true)
        Subscription sub4=new Subscription(user:user5,topic:topic14, seriousness:Subscription.Seriousness.SERIOUS).save(flush:true)
        Subscription sub5=new Subscription(user:user5,topic:topic15, seriousness:Subscription.Seriousness.SERIOUS).save(flush:true)
        Subscription sub6=new Subscription(user:user6,topic:topic16, seriousness:Subscription.Seriousness.SERIOUS).save(flush:true)
        Subscription sub7=new Subscription(user:user6,topic:topic17, seriousness:Subscription.Seriousness.SERIOUS).save(flush:true)
        Subscription sub8=new Subscription(user:user6,topic:topic18, seriousness:Subscription.Seriousness.SERIOUS).save(flush:true)
        Subscription sub9=new Subscription(user:user6,topic:topic19, seriousness:Subscription.Seriousness.SERIOUS).save(flush:true)
        Subscription sub10=new Subscription(user:user6,topic:topic20, seriousness:Subscription.Seriousness.SERIOUS).save(flush:true)

    }

   def resource={
       //Topic1,user1,linkResource
       LinkResource resource=new LinkResource(title:'google',description:'mkjckdjckdjckj',url:'http://www.google.com')
         Topic topicUrl=Topic.get(1)
       resource.topic=topicUrl
       User userUrl=User.get(1)
       resource.user=userUrl
       resource.save(flush:true,failOnError: true)
       LinkResource resource2=new LinkResource(title:'new document',description:'mkjckdjckdjckj',url:'http://www.grails.org')
       resource2.topic=topicUrl
       resource2.user=userUrl
       resource2.save(flush:true,failOnError: true)
       LinkResource resource3=new LinkResource(title:'groovydocs',description:'mkjckdjckdjckj',url:'http://www.groovy.org')
       resource3.user=userUrl
       resource3.topic=topicUrl
       resource3.save(flush: true,failOnError: true)
       LinkResource resource4=new LinkResource(title:'javascriptdocs',description:'mkjckdjckdjckj',url:'http://www.javascript.com')
       resource4.topic=topicUrl
       resource4.user=userUrl
       resource4.save(flush:true,failOnError: true)
       LinkResource resource5=new LinkResource(title:'grailsdocs',description:'mkjckdjckdjckj',url:'http://www.grails.org')
       resource5.user=userUrl
       resource5.topic=topicUrl
       resource5.save(flush: true,failOnError: true)
       //Topic1,user1,documentResource
        DocumentResource document1=new DocumentResource(title:'document2',description:'fhgfhghgghgh',filePath:'/home/shipra/shipra.txt')
                    document1.topic=topicUrl
                    document1.user=userUrl
       document1.save(flush: true,failOnError: true)
       DocumentResource document2=new DocumentResource(title:'document3',description:'fhgfhghgghgh',filePath:'/home/shipra/shipra.txt')
       document2.topic=topicUrl
       document2.user=userUrl
       document2.save(flush: true,failOnError: true)
       DocumentResource document3=new DocumentResource(title:'document4',description:'fhgfhghgghgh',filePath:'/home/shipra/shipra.txt')
       document3.topic=topicUrl
       document3.user=userUrl
       document3.save(flush: true,failOnError: true)
       DocumentResource document4=new DocumentResource(title:'document5',description:'fhgfhghgghgh',filePath:'/home/shipra/shipra.txt')
       document4.topic=topicUrl
       document4.user=userUrl
       document4.save(flush: true,failOnError: true)
       DocumentResource document5=new DocumentResource(title:'document6',description:'fhgfhghgghgh',filePath:'/home/shipra/shipra.txt')
       document5.topic=topicUrl
       document5.user=userUrl
       document5.save(flush: true,failOnError: true)
       //Topic2,user1,linkresource
       LinkResource resource6=new LinkResource(title:'javadocs',description:'mkjckdjckdjckj',url:'http://www.javatpoint.com')
       Topic topicUrl2=Topic.get(2)
       resource6.topic=topicUrl2
       resource6.user=userUrl
       resource6.save(flush:true,failOnError: true)
       LinkResource resource7=new LinkResource(title:'content',description:'mkjckdjckdjckj',url:'http://www.stackoverflow.com')
       resource7.topic=topicUrl2
       resource7.user=userUrl
       resource7.save(flush:true,failOnError: true)
       LinkResource resource8=new LinkResource(title:'docs',description:'mkjckdjckdjckj',url:'http://www.groovy.org')
       resource8.user=userUrl
       resource8.topic=topicUrl2
       resource8.save(flush: true,failOnError: true)
       LinkResource resource9=new LinkResource(title:'docs1',description:'mkjckdjckdjckj',url:'http://www.javascript.com')
       resource9.topic=topicUrl2
       resource9.user=userUrl
       resource9.save(flush:true,failOnError: true)
       LinkResource resource10=new LinkResource(title:'docs3',description:'mkjckdjckdjckj',url:'http://www.grails.org')
       resource10.user=userUrl
       resource10.topic=topicUrl2
       resource10.save(flush: true,failOnError: true)
       //Topic2,user1,documentResource
       DocumentResource document6=new DocumentResource(title:'doc1',description:'fhgfhghgghgh',filePath:'/home/shipra/shipra.txt')
       document6.topic=topicUrl2
       document6.user=userUrl
       document6.save(flush: true,failOnError: true)
       DocumentResource document7=new DocumentResource(title:'doc2',description:'fhgfhghgghgh',filePath:'/home/shipra/shipra.txt')
       document7.topic=topicUrl2
       document7.user=userUrl
       document7.save(flush: true,failOnError: true)
       DocumentResource document8=new DocumentResource(title:'doc3',description:'fhgfhghgghgh',filePath:'/home/shipra/shipra.txt')
       document8.topic=topicUrl2
       document8.user=userUrl
       document8.save(flush: true,failOnError: true)
       DocumentResource document9=new DocumentResource(title:'doc4',description:'fhgfhghgghgh',filePath:'/home/shipra/shipra.txt')
       document9.topic=topicUrl2
       document9.user=userUrl
       document9.save(flush: true,failOnError: true)
       DocumentResource document10=new DocumentResource(title:'doc5',description:'fhgfhghgghgh',filePath:'/home/shipra/shipra.txt')
       document10.topic=topicUrl2
       document10.user=userUrl
       document10.save(flush: true,failOnError: true)
       //Topic3,user2,linkResource
       LinkResource resource11=new LinkResource(title:'link1',description:'mkjckdjckdjckj',url:'http://www.google.com')
       Topic topicUrl3=Topic.get(3)
       resource11.topic=topicUrl3
       User userUrl2=User.get(2)
       resource11.user=userUrl2
       resource11.save(flush:true,failOnError: true)
       LinkResource resource12=new LinkResource(title:'link2',description:'mkjckdjckdjckj',url:'http://www.grails.org')
       resource12.topic=topicUrl3
       resource12.user=userUrl2
       resource12.save(flush:true,failOnError: true)
       LinkResource resource13=new LinkResource(title:'link3',description:'mkjckdjckdjckj',url:'http://www.groovy.org')
       resource13.user=userUrl2
       resource13.topic=topicUrl3
       resource13.save(flush: true,failOnError: true)
       LinkResource resource14=new LinkResource(title:'link4',description:'mkjckdjckdjckj',url:'http://www.javascript.com')
       resource14.topic=topicUrl3
       resource14.user=userUrl2
       resource14.save(flush:true,failOnError: true)
       LinkResource resource15=new LinkResource(title:'link5',description:'mkjckdjckdjckj',url:'http://www.grails.org')
       resource15.user=userUrl2
       resource15.topic=topicUrl3
       resource15.save(flush: true,failOnError: true)
       //Topic3,user2,documentResource
       DocumentResource document11=new DocumentResource(title:'document7',description:'fhgfhghgghgh',filePath:'/home/shipra/shipra.txt')
       document11.topic=topicUrl3
       document11.user=userUrl2
       document11.save(flush: true,failOnError: true)
       DocumentResource document12=new DocumentResource(title:'document8',description:'fhgfhghgghgh',filePath:'/home/shipra/shipra.txt')
       document12.topic=topicUrl3
       document12.user=userUrl2
       document12.save(flush: true,failOnError: true)
       DocumentResource document13=new DocumentResource(title:'document9',description:'fhgfhghgghgh',filePath:'/home/shipra/shipra.txt')
       document13.topic=topicUrl3
       document13.user=userUrl2
       document13.save(flush: true,failOnError: true)
       DocumentResource document14=new DocumentResource(title:'document10',description:'fhgfhghgghgh',filePath:'/home/shipra/shipra.txt')
       document14.topic=topicUrl3
       document14.user=userUrl2
       document14.save(flush: true,failOnError: true)
       DocumentResource document15=new DocumentResource(title:'document11',description:'fhgfhghgghgh',filePath:'/home/shipra/shipra.txt')
       document15.topic=topicUrl3
       document15.user=userUrl2
       document15.save(flush: true,failOnError: true)
       //Topic4,user2,linkResource
       LinkResource resource16=new LinkResource(title:'link6',description:'mkjckdjckdjckj',url:'http://www.google.com')
       Topic topicUrl4=Topic.get(4)
       resource16.topic=topicUrl4
       resource16.user=userUrl2
       resource16.save(flush:true,failOnError: true)
       LinkResource resource17=new LinkResource(title:'link7',description:'mkjckdjckdjckj',url:'http://www.grails.org')
       resource17.topic=topicUrl4
       resource17.user=userUrl2
       resource17.save(flush:true,failOnError: true)
       LinkResource resource18=new LinkResource(title:'link8',description:'mkjckdjckdjckj',url:'http://www.groovy.org')
       resource18.user=userUrl2
       resource18.topic=topicUrl4
       resource18.save(flush: true,failOnError: true)
       LinkResource resource19=new LinkResource(title:'link9',description:'mkjckdjckdjckj',url:'http://www.javascript.com')
       resource19.topic=topicUrl4
       resource19.user=userUrl2
       resource19.save(flush:true,failOnError: true)
       LinkResource resource20=new LinkResource(title:'link10',description:'mkjckdjckdjckj',url:'http://www.grails.org')
       resource20.user=userUrl2
       resource20.topic=topicUrl4
       resource20.save(flush: true,failOnError: true)
       //Topic4,user2,documentResource
       DocumentResource document16=new DocumentResource(title:'document12',description:'fhgfhghgghgh',filePath:'/home/shipra/shipra.txt')
       document16.topic=topicUrl4
       document16.user=userUrl2
       document16.save(flush: true,failOnError: true)
       DocumentResource document17=new DocumentResource(title:'document13',description:'fhgfhghgghgh',filePath:'/home/shipra/shipra.txt')
       document17.topic=topicUrl4
       document17.user=userUrl2
       document17.save(flush: true,failOnError: true)
       DocumentResource document18=new DocumentResource(title:'document14',description:'fhgfhghgghgh',filePath:'/home/shipra/shipra.txt')
       document18.topic=topicUrl4
       document18.user=userUrl2
       document18.save(flush: true,failOnError: true)
       DocumentResource document19=new DocumentResource(title:'document15',description:'fhgfhghgghgh',filePath:'/home/shipra/shipra.txt')
       document19.topic=topicUrl4
       document19.user=userUrl2
       document19.save(flush: true,failOnError: true)
       DocumentResource document20=new DocumentResource(title:'document16',description:'fhgfhghgghgh',filePath:'/home/shipra/shipra.txt')
       document20.topic=topicUrl4
       document20.user=userUrl2
       document20.save(flush: true,failOnError: true)
       //Topic5,user2,linkResource
       LinkResource resource21=new LinkResource(title:'link11',description:'mkjckdjckdjckj',url:'http://www.google.com')
       Topic topicUrl5=Topic.get(5)
       resource21.topic=topicUrl5
       resource21.user=userUrl2
       resource21.save(flush:true,failOnError: true)
       LinkResource resource22=new LinkResource(title:'link12',description:'mkjckdjckdjckj',url:'http://www.grails.org')
       resource22.topic=topicUrl5
       resource22.user=userUrl2
       resource22.save(flush:true,failOnError: true)
       LinkResource resource23=new LinkResource(title:'link13',description:'mkjckdjckdjckj',url:'http://www.groovy.org')
       resource23.user=userUrl2
       resource23.topic=topicUrl5
       resource23.save(flush: true,failOnError: true)
       LinkResource resource24=new LinkResource(title:'link14',description:'mkjckdjckdjckj',url:'http://www.javascript.com')
       resource24.topic=topicUrl5
       resource24.user=userUrl2
       resource24.save(flush:true,failOnError: true)
       LinkResource resource25=new LinkResource(title:'link15',description:'mkjckdjckdjckj',url:'http://www.grails.org')
       resource25.user=userUrl2
       resource25.topic=topicUrl5
       resource25.save(flush: true,failOnError: true)
       //Topic5,user2,documentResource
       DocumentResource document21=new DocumentResource(title:'document17',description:'fhgfhghgghgh',filePath:'/home/shipra/shipra.txt')
       document21.topic=topicUrl5
       document21.user=userUrl2
       document21.save(flush: true,failOnError: true)
       DocumentResource document22=new DocumentResource(title:'document18',description:'fhgfhghgghgh',filePath:'/home/shipra/shipra.txt')
       document22.topic=topicUrl5
       document22.user=userUrl2
       document22.save(flush: true,failOnError: true)
       DocumentResource document23=new DocumentResource(title:'document19',description:'fhgfhghgghgh',filePath:'/home/shipra/shipra.txt')
       document23.topic=topicUrl5
       document23.user=userUrl2
       document23.save(flush: true,failOnError: true)
       DocumentResource document24=new DocumentResource(title:'document20',description:'fhgfhghgghgh',filePath:'/home/shipra/shipra.txt')
       document24.topic=topicUrl5
       document24.user=userUrl2
       document24.save(flush: true,failOnError: true)
       DocumentResource document25=new DocumentResource(title:'document21',description:'fhgfhghgghgh',filePath:'/home/shipra/shipra.txt')
       document25.topic=topicUrl5
       document25.user=userUrl2
       document25.save(flush: true,failOnError: true)


   }

    def readingItems={
        //for user1
         ReadingItem rs=new ReadingItem(isRead:'true')
        ReadingItem rs1=new ReadingItem(isRead:'true')
        ReadingItem rs2=new ReadingItem(isRead:'true')
        User read=User.get(1)
        Resource res=Resource.get(1)
        Resource res1=Resource.get(2)
        Resource res2=Resource.get(3)

          rs.user=read
          rs.resource=res
          rs.save(flush: true,failOnError: true)
         rs1.user=read
        rs1.resource=res1
         rs1.save(flush: true,failOnError: true)
        rs2.user=read
        rs2.resource=res2
        rs2.save(flush: true,failOnError: true)
       //for user2
        ReadingItem rs3=new ReadingItem(isRead:'true')
        ReadingItem rs4=new ReadingItem(isRead:'true')
        ReadingItem rs5=new ReadingItem(isRead:'true')
        User read1=User.get(2)
        Resource res3=Resource.get(4)
        Resource res4=Resource.get(5)
        Resource res5=Resource.get(6)

        rs3.user=read1
        rs3.resource=res3
        rs3.save(flush: true,failOnError: true)
        rs4.user=read1
        rs4.resource=res4
        rs4.save(flush: true,failOnError: true)
        rs5.user=read1
        rs5.resource=res5
        rs5.save(flush: true,failOnError: true)



    }

}

