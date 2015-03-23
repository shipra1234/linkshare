package linksharing

import grails.transaction.Transactional

@Transactional
class LoginService {

    def showPost() {
       List <Resource> resourceList=[]
        List<ResourceRating> ratingList = ResourceRating.createCriteria().list(max: 5, offset: 0) {
            order("score", "desc")
        }
        ratingList.each {rating->
            resourceList << rating.resource
        }
        return resourceList
    }
}