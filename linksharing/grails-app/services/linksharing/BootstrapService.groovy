package linksharing

import grails.transaction.Transactional

@Transactional
class BootstrapService {

    def createUser={
        log.info "Creating users.."

        User  user = new User(username: 'shipratayal', email: 'sttayalshipra4@gmail.com', password: 'shipra',confirmPassword:'shipra', firstName: 'shipra', lastName: 'tayal',role:'admin', active: 'true',photo:'/home/intelligrape/linkshare/linksharing/upload_image/index.jpeg')
        User user2 = new User(username: 'shailytayal', email: 'sttayalshipra4@gmail.com', password: 'shipra',confirmPassword: 'shipra' ,firstName: 'shaily', lastName: 'tayal',role:'user', active: 'true',photo:'/home/intelligrape/linkshare/linksharing/upload_image/index.jpeg')
        user.save()
        user2.save(flush:true)

        log.info "User creation successfully"
    }

    def createTopics={
        log.info "Creating topics"
        User user3 = User.findByUsername('shipratayal')
        User user4 = User.findByUsername('shailytayal')

        Topic  topic1 = new Topic(name: 'grails', visibility: Topic.Visibility.PUBLIC)
        Topic  topic2 = new Topic(name: 'groovy', visibility: Topic.Visibility.PUBLIC)

        Topic topic3 = new Topic(name: 'html', visibility: Topic.Visibility.PUBLIC)
        Topic topic4 = new Topic(name: 'java', visibility: Topic.Visibility.PUBLIC)
        Topic topic5 = new Topic(name: 'jquery', visibility: Topic.Visibility.PUBLIC)

        Topic topic6 = new Topic(name: 'php', visibility: Topic.Visibility.PUBLIC)
        Topic  topic7 = new Topic(name: 'ruby', visibility: Topic.Visibility.PUBLIC)
        Topic   topic8 = new Topic(name: 'c#', visibility: Topic.Visibility.PUBLIC)
        Topic   topic9 = new Topic(name: 'asp', visibility: Topic.Visibility.PUBLIC)
        Topic   topic10 = new Topic(name: 'bootstrap', visibility: Topic.Visibility.PUBLIC)

        Subscription subscription1=new Subscription(topic:topic1,user:user3,seriousness:Subscription.Seriousness.SERIOUS)
        Subscription subscription2=new Subscription(topic:topic2,user:user3,seriousness:Subscription.Seriousness.SERIOUS)
        Subscription subscription3=new Subscription(topic:topic3,user:user3,seriousness:Subscription.Seriousness.SERIOUS)
        Subscription subscription4=new Subscription(topic:topic4,user:user3,seriousness:Subscription.Seriousness.SERIOUS)
        Subscription subscription5=new Subscription(topic:topic5,user:user3,seriousness:Subscription.Seriousness.SERIOUS)
        Subscription subscription6=new Subscription(topic:topic6,user:user4,seriousness:Subscription.Seriousness.SERIOUS)
        Subscription subscription7=new Subscription(topic:topic7,user:user4,seriousness:Subscription.Seriousness.SERIOUS)
        Subscription subscription8=new Subscription(topic:topic8,user:user4,seriousness:Subscription.Seriousness.SERIOUS)
        Subscription subscription9=new Subscription(topic:topic9,user:user4,seriousness:Subscription.Seriousness.SERIOUS)
        Subscription subscription10=new Subscription(topic:topic10,user:user4,seriousness:Subscription.Seriousness.SERIOUS)
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
        subscription1.save(flush:true,failOnError:true)
        subscription2.save(flush:true,failOnError:true)
        subscription3.save(flush:true,failOnError:true)
        subscription4.save(flush:true,failOnError:true)
        subscription5.save(flush:true,failOnError:true)
        subscription6.save(flush:true,failOnError:true)
        subscription7.save(flush:true,failOnError:true)
        subscription8.save(flush:true,failOnError:true)
        subscription9.save(flush:true,failOnError:true)
        subscription10.save(flush:true,failOnError:true)


        log.info "topics creation done."
    }
    def subscription={

        User user5=User.findByUsername('shipratayal')
        Topic topic17=Topic.findById(7)
        Topic topic18=Topic.findById(8)
        Subscription sub19=new Subscription(user:user5,topic:topic17, seriousness:Subscription.Seriousness.SERIOUS)
        Subscription sub20=new Subscription(user:user5,topic:topic18, seriousness:Subscription.Seriousness.SERIOUS)
        sub19.save(flush:true,failOnError:true)
        sub20.save(flush:true,failOnError:true)

    }

    def resource={
        //Topic1,user1,linkResource
        LinkResource resource=new LinkResource(title:'google',description:'I\'m very new to Grails so there\'s probably a very simple answer to this question. ',url:'http://www.google.com')
        Topic topicUrl=Topic.findByName("grails")
        resource.topic=topicUrl
        User userUrl=User.findByUsername("shipratayal")
        resource.user=userUrl
        resource.save(flush:true,failOnError: true)
        LinkResource resource2=new LinkResource(title:'new document',description:'I\'m very new to Grails so there\'s probably a very simple answer to this question.',url:'http://www.grails.org')
        resource2.topic=topicUrl
        resource2.user=userUrl
        resource2.save(flush:true,failOnError: true)
        LinkResource resource3=new LinkResource(title:'groovydocs',description:'I\'m very new to Groovy so there\'s probably a very simple answer to this question',url:'http://www.groovy.org')
        resource3.user=userUrl
        resource3.topic=topicUrl
        resource3.save(flush: true,failOnError: true)
        LinkResource resource4=new LinkResource(title:'javascriptdocs',description:'I\'m very new to javascript so there\'s probably a very simple answer to this question',url:'http://www.javascript.com')
        resource4.topic=topicUrl
        resource4.user=userUrl
        resource4.save(flush:true,failOnError: true)
        LinkResource resource5=new LinkResource(title:'grailsdocs',description:'I\'m very new to Grails so there\'s probably a very simple answer to this question',url:'http://www.grails.org')
        resource5.user=userUrl
        resource5.topic=topicUrl
        resource5.save(flush: true,failOnError: true)
        //Topic1,user1,documentResource
        DocumentResource document1=new DocumentResource(title:'document2',description:'I\'m very new to Grails so there\'s probably a very simple answer to this question',filePath:'/home/shipra/shipra.txt')
        document1.topic=topicUrl
        document1.user=userUrl
        document1.save(flush: true,failOnError: true)
        DocumentResource document2=new DocumentResource(title:'document3',description:'I\'m very new to Grails so there\'s probably a very simple answer to this question',filePath:'/home/shipra/shipra.txt')
        document2.topic=topicUrl
        document2.user=userUrl
        document2.save(flush: true,failOnError: true)
        DocumentResource document3=new DocumentResource(title:'document4',description:'I\'m very new to Grails so there\'s probably a very simple answer to this question',filePath:'/home/shipra/shipra.txt')
        document3.topic=topicUrl
        document3.user=userUrl
        document3.save(flush: true,failOnError: true)
        DocumentResource document4=new DocumentResource(title:'document5',description:'I\'m very new to Grails so there\'s probably a very simple answer to this question',filePath:'/home/shipra/shipra.txt')
        document4.topic=topicUrl
        document4.user=userUrl
        document4.save(flush: true,failOnError: true)
        DocumentResource document5=new DocumentResource(title:'document6',description:'I\'m very new to Grails so there\'s probably a very simple answer to this question',filePath:'/home/shipra/shipra.txt')
        document5.topic=topicUrl
        document5.user=userUrl
        document5.save(flush: true,failOnError: true)
        //Topic2,user1,linkresource
        LinkResource resource6=new LinkResource(title:'javadocs',description:'I\'m very new to Grails so there\'s probably a very simple answer to this question',url:'http://www.javatpoint.com')
        Topic topicUrl2=Topic.findByName('groovy')
        resource6.topic=topicUrl2
        resource6.user=userUrl
        resource6.save(flush:true,failOnError: true)
        LinkResource resource7=new LinkResource(title:'content',description:'I\'m very new to Grails so there\'s probably a very simple answer to this question',url:'http://www.stackoverflow.com')
        resource7.topic=topicUrl2
        resource7.user=userUrl
        resource7.save(flush:true,failOnError: true)
        LinkResource resource8=new LinkResource(title:'docs',description:'I\'m very new to Grails so there\'s probably a very simple answer to this question',url:'http://www.groovy.org')
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
        DocumentResource document6=new DocumentResource(title:'doc1',description:'I\'m very new to Grails so there\'s probably a very simple answer to this question',filePath:'/home/shipra/shipra.txt')
        document6.topic=topicUrl2
        document6.user=userUrl
        document6.save(flush: true,failOnError: true)
        DocumentResource document7=new DocumentResource(title:'doc2',description:'I\'m very new to Grails so there\'s probably a very simple answer to this question',filePath:'/home/shipra/shipra.txt')
        document7.topic=topicUrl2
        document7.user=userUrl
        document7.save(flush: true,failOnError: true)
        DocumentResource document8=new DocumentResource(title:'doc3',description:'I\'m very new to Grails so there\'s probably a very simple answer to this question',filePath:'/home/shipra/shipra.txt')
        document8.topic=topicUrl2
        document8.user=userUrl
        document8.save(flush: true,failOnError: true)
        DocumentResource document9=new DocumentResource(title:'doc4',description:'I\'m very new to Grails so there\'s probably a very simple answer to this question',filePath:'/home/shipra/shipra.txt')
        document9.topic=topicUrl2
        document9.user=userUrl
        document9.save(flush: true,failOnError: true)
        DocumentResource document10=new DocumentResource(title:'doc5',description:'I\'m very new to Grails so there\'s probably a very simple answer to this question',filePath:'/home/shipra/shipra.txt')
        document10.topic=topicUrl2
        document10.user=userUrl
        document10.save(flush: true,failOnError: true)
        //Topic3,user2,linkResource
        LinkResource resource11=new LinkResource(title:'link1',description:'I\'m very new to Grails so there\'s probably a very simple answer to this question',url:'http://www.google.com')
        Topic topicUrl3  =Topic.get(7)
        resource11.topic=topicUrl3
        User userUrl2=User.get(2)
        resource11.user=userUrl2
        resource11.save(flush:true,failOnError: true)
        LinkResource resource12=new LinkResource(title:'link2',description:'I\'m very new to Grails so there\'s probably a very simple answer to this question',url:'http://www.grails.org')
        resource12.topic=topicUrl3
        resource12.user=userUrl2
        resource12.save(flush:true,failOnError: true)
        LinkResource resource13=new LinkResource(title:'link3',description:'I\'m very new to Grails so there\'s probably a very simple answer to this question',url:'http://www.groovy.org')
        resource13.user=userUrl2
        resource13.topic=topicUrl3
        resource13.save(flush: true,failOnError: true)
        LinkResource resource14=new LinkResource(title:'link4',description:'I\'m very new to Grails so there\'s probably a very simple answer to this question',url:'http://www.javascript.com')
        resource14.topic=topicUrl3
        resource14.user=userUrl2
        resource14.save(flush:true,failOnError: true)
        LinkResource resource15=new LinkResource(title:'link5',description:'I\'m very new to Grails so there\'s probably a very simple answer to this question',url:'http://www.grails.org')
        resource15.user=userUrl2
        resource15.topic=topicUrl3
        resource15.save(flush: true,failOnError: true)
        //Topic3,user2,documentResource
        DocumentResource document11=new DocumentResource(title:'document7',description:'I\'m very new to Grails so there\'s probably a very simple answer to this question',filePath:'/home/shipra/shipra.txt')
        document11.topic=topicUrl3
        document11.user=userUrl2
        document11.save(flush: true,failOnError: true)
        DocumentResource document12=new DocumentResource(title:'document8',description:'I\'m very new to Grails so there\'s probably a very simple answer to this question',filePath:'/home/shipra/shipra.txt')
        document12.topic=topicUrl3
        document12.user=userUrl2
        document12.save(flush: true,failOnError: true)
        DocumentResource document13=new DocumentResource(title:'document9',description:'I\'m very new to Grails so there\'s probably a very simple answer to this question',filePath:'/home/shipra/shipra.txt')
        document13.topic=topicUrl3
        document13.user=userUrl2
        document13.save(flush: true,failOnError: true)
        DocumentResource document14=new DocumentResource(title:'document10',description:'I\'m very new to Grails so there\'s probably a very simple answer to this question',filePath:'/home/shipra/shipra.txt')
        document14.topic=topicUrl3
        document14.user=userUrl2
        document14.save(flush: true,failOnError: true)
        DocumentResource document15=new DocumentResource(title:'document11',description:'I\'m very new to Grails so there\'s probably a very simple answer to this question',filePath:'/home/shipra/shipra.txt')
        document15.topic=topicUrl3
        document15.user=userUrl2
        document15.save(flush: true,failOnError: true)
        //Topic4,user2,linkResource
        LinkResource resource16=new LinkResource(title:'link6',description:'I\'m very new to Grails so there\'s probably a very simple answer to this question',url:'http://www.google.com')
        Topic topicUrl4=Topic.get(4)
        resource16.topic=topicUrl4
        resource16.user=userUrl2
        resource16.save(flush:true,failOnError: true)
        LinkResource resource17=new LinkResource(title:'link7',description:'I\'m very new to Grails so there\'s probably a very simple answer to this question',url:'http://www.grails.org')
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
        DocumentResource document16=new DocumentResource(title:'document12',description:'HTML is a markup language for describing web documents (web pages).',filePath:'/home/shipra/shipra.txt')
        document16.topic=topicUrl4
        document16.user=userUrl2
        document16.save(flush: true,failOnError: true)
        DocumentResource document17=new DocumentResource(title:'document13',description:'HTML is a markup language for describing web documents (web pages).',filePath:'/home/shipra/shipra.txt')
        document17.topic=topicUrl4
        document17.user=userUrl2
        document17.save(flush: true,failOnError: true)
        DocumentResource document18=new DocumentResource(title:'document14',description:'HTML is a markup language for describing web documents (web pages).',filePath:'/home/shipra/shipra.txt')
        document18.topic=topicUrl4
        document18.user=userUrl2
        document18.save(flush: true,failOnError: true)
        DocumentResource document19=new DocumentResource(title:'document15',description:'HTML is a markup language for describing web documents (web pages).',filePath:'/home/shipra/shipra.txt')
        document19.topic=topicUrl4
        document19.user=userUrl2
        document19.save(flush: true,failOnError: true)
        DocumentResource document20=new DocumentResource(title:'document16',description:'HTML is a markup language for describing web documents (web pages).',filePath:'/home/shipra/shipra.txt')
        document20.topic=topicUrl4
        document20.user=userUrl2
        document20.save(flush: true,failOnError: true)
        //Topic5,user2,linkResource
        LinkResource resource21=new LinkResource(title:'link11',description:'jQuery is a fast, small, and feature-rich JavaScript library. ',url:'http://www.grails.org/')
        Topic topicUrl5=Topic.get(6)
        resource21.topic=topicUrl5
        resource21.user=userUrl2
        resource21.save(flush:true,failOnError: true)
        LinkResource resource22=new LinkResource(title:'link12',description:'jQuery is a fast, small, and feature-rich JavaScript library. ',url:'http://www.grails.org')
        resource22.topic=topicUrl5
        resource22.user=userUrl2
        resource22.save(flush:true,failOnError: true)
        LinkResource resource23=new LinkResource(title:'link13',description:'jQuery is a fast, small, and feature-rich JavaScript library. .',url:'http://www.groovy.org')
        resource23.user=userUrl2
        resource23.topic=topicUrl5
        resource23.save(flush: true,failOnError: true)
        LinkResource resource24=new LinkResource(title:'link14',description:'jQuery is a fast, small, and feature-rich JavaScript library.',url:'http://www.javascript.com')
        resource24.topic=topicUrl5
        resource24.user=userUrl2
        resource24.save(flush:true,failOnError: true)
        LinkResource resource25=new LinkResource(title:'link15',description:'jQuery is a fast, small, and feature-rich JavaScript library. ',url:'http://www.grails.org')
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

        List <Subscription> subscription=Subscription.list()
        subscription.each {subscribe->
            User user = subscribe.user
            Topic topic = subscribe.topic
            List<Resource> resources = Resource.createCriteria().list {
                and {
                    ne("user", user)
                    eq("topic", topic)
                }
            }
            if(resources!=[])
            {
                resources.each {resource->
                    ReadingItem readingItem = new ReadingItem(isRead:false, user: user, resource:resource)
                    readingItem.save(flush:true,failOnError:true)
                }

            }
        }

    }



    def rating={
        User user1=User.findByUsername('shipratayal')
        List<Topic> topicNames=Topic.findAllByUser(user1)
        Topic topic1=Topic.findByName(topicNames.get(0).name)
        Topic topic2=Topic.findByName(topicNames.get(1).name)

        List<Resource> resource=Resource.findAllByTopic(topic1)
        List<Resource> resource2=Resource.findAllByTopic(topic2)

        ResourceRating rating1=new ResourceRating(score:3,user:user1,resource: resource[0])
        rating1.save(flush:true,failOnError:true)

        ResourceRating rating2=new ResourceRating(score:2)
        rating2.user=user1
        rating2.resource=resource[1]
        rating2.save(flush:true,failOnError:true)
        ResourceRating rating3=new ResourceRating(score:4)
        rating3.user=user1
        rating3.resource=resource[2]
        rating3.save(flush:true,failOnError:true)
        ResourceRating rating4=new ResourceRating(score:4)
        rating4.user=user1
        rating4.resource=resource[3]
        rating4.save(flush:true,failOnError:true)
        ResourceRating rating5=new ResourceRating(score:5)
        rating5.user=user1
        rating5.resource=resource2[1]
        rating5.save(flush:true,failOnError:true)




    }

}




