package linksharing

class ApplicationTagLib {
   // static defaultEncodeAs = [taglib:'html']
    //static encodeAsForTags = [tagName: [taglib:'html'], otherTagName: [taglib:'none']]

    static namespace = "ls"

    def showInbox={attrs,body->
        out << g.render(template:"/user/showdetails",model:[resource:attrs.resources])

    }
    def recentShare =  {attrs,body->

      out << g.render(template:"/user/showShare",model:[resource:attrs.resource])


    }
    def inbox =  {attrs,body->

        out << g.render(template:"/user/showList",model:[resources:attrs.resources])


    }
    def showPost={attrs,body->
          out << attrs.post


    }
    def showSubscription={attrs,body->

        out << attrs.subscription

    }
    def isEditable = { attrs, body ->
        String username = session.getAttribute('user')
        String topic = attrs.topic
        String visibility=attrs.visibility
        println "+++++visibilty+++"+visibility
        User user1 = User.findByUsername(username)
        List<Topic> topics = Topic.findAllByUser(user1)
        if(topics.name.contains(topic)){
            out<< g.render(template:'/user/showdata',model:[topic:topic,visibility:visibility])
        }
        else if(user1.role=="admin"){
            out<< g.render(template:'/user/showdata',model:[topic:topic,visibility:visibility])
        }


        }
    def marked={attrs,body->
        Resource resource=attrs.resource
       long resourceId=resource.id
        ReadingItem readingItem=ReadingItem.findByResource(resource)
           String isRead=readingItem.isRead
        flash.message=isRead
        if(isRead=="false"){
            out<< g.render(template:'/user/marked',model:[isRead:'mark as read',resource:resourceId])
        }
        else{
            out<< g.render(template:'/user/marked',model:[isRead:'mark as unread',resource:resourceId])
        }


    }
    def document={attrs,body->

        Resource resource=attrs.resource
       println "class " +resource.class
        if(resource.class==linksharing.LinkResource)
        {
            out<< g.render(template:'/user/document',model:[isRead:'view full site',resource:resource.id])
        }
        else{
            out<< g.render(template:'/user/document',model:[isRead:'Download',resource:resource.id])
        }
    }
    }




