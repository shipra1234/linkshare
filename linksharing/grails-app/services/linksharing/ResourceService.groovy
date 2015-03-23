package linksharing

import grails.transaction.Transactional
import org.hibernate.FetchMode


@Transactional
class ResourceService {

    def resource() {

        // List<Resource> res=Resource.list(sort:'dateCreated',order:'desc',max:5,offset:0)

        List<Resource> resources=Resource.createCriteria().list(max:5,offset:0) {
            order("dateCreated","desc")
        }
        return resources

    }
    def userResource(String userName)
    {
        List<ReadingItem> read=ReadingItem.list()
        List<Resource> resources=Resource.list()
        List<Resource> resource=(resources-read)
        return resource
    }

    def linkResource(String link,String description,Topic topic,String title,String user){
        User userId=User.findByUsername(user)
        LinkResource resource=new LinkResource(title:title,url:link,description:description,topic:topic,user:userId)
        resource.save(flush:true,failOnError:true)


    }
    def documentResource(def document,String description,Topic topic,String title,String user)
    {
        String filename=document.originalFilename
        String path= "/home/shipra/linkshare/linksharing/upload_image/${filename}"
        document.transferTo(new File(path))
        User userId=User.findByUsername(user)
        DocumentResource resource=new DocumentResource(filePath:path,description:description,topic:topic,
                title:title,user:userId)
        resource.save(flush:true,failOnError: true)

    }
    def viewData(Resource resource){
        Topic topic=resource.topic
        println "++++++helloooo+++++" +resource.class

        if(resource.class==linksharing.DocumentResource){
            println "+++++++++"
            DocumentResource documentResource=DocumentResource.findByTopic(topic)
                 return documentResource

        }

    }
}