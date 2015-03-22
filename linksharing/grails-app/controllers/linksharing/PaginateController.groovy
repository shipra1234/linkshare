package linksharing

import grails.converters.JSON

class PaginateController {

    def show() {
        params.max = params.max ? params.int('max') : 2
        params.offset = params.offset ? params.int('offset') : 0

       Topic topic=Topic.findById(1)
       // String name=topic.name
        String name="grails"
        List<Resource> resources=Resource.createCriteria().list(max:params.max,offset:params.offset) {
            ilike("description","%${name}%")
        }
        int count=Resource.countByDescriptionLike("%${name}%")
         println "-------------${params.max }.......${params.offset}.......${count}"
          render(template: "/user/showList", model: [resources:resources,count: count])
    }

    def count(){
        params.max = params.max ? params.int('max') : 2
        params.offset = params.offset ? params.int('offset') : 0
        String name="grails"
        List<Resource> resources=Resource.createCriteria().list(max:params.max,offset:params.offset) {
            ilike("description","%${name}%")
        }
        int count=Resource.countByDescriptionLike("%${name}%")
        render(view:'pagination',model:[resources: resources, count:count])

    }




}
