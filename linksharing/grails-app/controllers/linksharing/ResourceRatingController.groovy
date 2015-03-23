package linksharing

import grails.converters.JSON

class ResourceRatingController {
   def resourceRatingService
  def rate(Integer rate,Long resource){
      String username=session.getAttribute('user')
      User user=User.findByUsername(username)
      Resource resource1=Resource.get(resource)
      String message=  resourceRatingService.saveRating(rate,user,resource1)
       flash.message=message+rate
      render([message:flash.message,status:true]as JSON)

  }
}
