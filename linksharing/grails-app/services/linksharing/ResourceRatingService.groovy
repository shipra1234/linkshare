package linksharing

import grails.transaction.Transactional

@Transactional
class ResourceRatingService {

    def saveRating(Integer rate,User user,Resource resource) {
        ResourceRating resourceRating=ResourceRating.findByUserAndResource(user,resource)
        if(resourceRating!=[]){
            resourceRating.executeUpdate("update ResourceRating set score=(:rate) where id=(:id)", [rate:rate,id:resourceRating.id])
           String message="update rating"
             return message
        }
        else{
            ResourceRating resourceRating1=new ResourceRating(score:rate,user:user,resource:resource)
            resourceRating1.save(flush:true,failOnError:true)
            String message="Save Rating"
            return message

        }

    }
}
