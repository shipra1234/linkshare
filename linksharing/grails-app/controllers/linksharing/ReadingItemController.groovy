package linksharing

class ReadingItemController {
   def readingItemService
    def isRead(){
        Resource resource=Resource.get(params.resource)
          readingItemService.update(resource,params.isRead)
        flash.message="update successfully"
       redirect(controller:'dashboard',action:'index')
}

}
