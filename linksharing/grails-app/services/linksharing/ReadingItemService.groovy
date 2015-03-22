package linksharing

import grails.transaction.Transactional

@Transactional
class ReadingItemService {

    def update(Resource resource,String isRead) {

        if(isRead=='mark as read')
        {
            println"+++++++++resource++++"+resource
            ReadingItem readingItem=ReadingItem.findByResource(resource)
            Long id=readingItem.id
            println "+++++++++" +id
            readingItem.executeUpdate("update ReadingItem set isRead=(:isRead) where id=(:id)", [isRead:true,id:id])


        }

    }
}
