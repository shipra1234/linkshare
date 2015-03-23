package linksharing

import CO.UserCO

class LoginController {
        def userService
        def resourceService
    def loginService
        def signUp()
        {
         List<Resource> resources=resourceService.resource()
            List<Resource> resourceList= loginService.showPost()
            render(view:'/home',model:[resources:resources,resourceList:resourceList])
        }

    def login(String username, String password) {
        String pwd = userService.userLogin(username)
        if (pwd == password) {
            session.setAttribute("user", username)
            redirect(controller:'dashboard',action:'index')

        } else {
            flash.message = "please enter correct password"
            redirect(action:'signUp')
        }

    }

    def register(UserCO userCO) {
        User user = new User()
        bindData(user, userCO, ['photo', 'class'])
        userService.userRegister(user, userCO.photo)
        flash.message = "registered Successfully"
        redirect(action:'signUp')
    }


}

