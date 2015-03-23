package linksharing

import grails.transaction.Transactional

@Transactional
class SearchService {

    def searchResource(String params) {
        Topic topic = Topic.findByName(params)
        if (topic != []) {
            List<Resource> resources = Resource.findAllByTopic(topic, [max: 5, offset: 0])
            return resources
        } else {
            List<Resource> resourceList = Resource.createCriteria().list(max: 5, offset: 0) {
                ilike("description", "%${params}%")

            }
            return resourceList

        }
    }


}