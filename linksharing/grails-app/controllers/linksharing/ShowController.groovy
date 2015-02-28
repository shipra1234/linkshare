package linksharing

import CO.UserCO

class ShowController {
      static allowedMethods = [save:'POST']
    def index() {

        render(view:'/home')
    }
    def save(UserCO userCO){
        println "++++++++++++++++++++++++--------------------------" + userCO.properties
        //user.validate()
        userCO.validate()
        if(userCO.hasErrors())
        {
            println userCO.errors
        }
//        User user=new User(userCO.properties)
        User user=new User()
        bindData(user, userCO)
//        user.hasProperty()
//        userCO.properties.each {k, v->
//            if(user.hasProperty(k)){
//                user.setProperty(k, v)
//            }
//
//        }
        user.properties=userCO.properties

        user.save(flush: true,failOnError:true)
        render(view:'/home')
    }
    def dashboard()
    {

    }
}
