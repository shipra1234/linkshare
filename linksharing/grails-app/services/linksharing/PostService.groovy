package linksharing

import grails.transaction.Transactional

@Transactional
class PostService {

    def showData(String userName) {
      Integer rating=ResourceRating.createCriteria().get{
          projections{
              max "score"
          }

      }
        ResourceRating rating1=ResourceRating.findByScore(rating)
        Resource res=rating1.resource
        User user=rating1.user
        String username=user.username
        String resource=res.description
        String firstName=user.firstName
        List<ResourceRating> list=[]
        list << username
        list << firstName
        list << resource

        return list
    }
}
