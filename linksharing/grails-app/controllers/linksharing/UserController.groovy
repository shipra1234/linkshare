package linksharing

import CO.UserCO

class UserController {
    static allowedMethods = [register: 'POST']
    UserService userService


    def register(UserCO userCO) {
        User user = new User()
        bindData(user, userCO, ['photo', 'class'])
        userService.userRegister(user, userCO.photo)
        flash.message = "registered Successfully"
        redirect(action: "index", controller: "chk")
    }


    def login(String username, String password) {
        String pwd = userService.userLogin(username, password)
        if (pwd == password) {
            session.setAttribute("user", username)
            //request.setAttribute("msg","hiiiiiiiiii")
            // redirect(action:'index',controller:'chk')
            render(view: '/dashboard')

        } else {

            flash.message = "please enter correct password"
            redirect(action: 'index', controller: 'chk')
        }

    }

    def viewImage() {
        File file = new File(params.image)
        def image = file.getBytes()
        response.outputStream << image
        response.outputStream.flush()
    }

    def showResource() {
//          List des=[]
//        def user=User.get(1)
//       List<Resource> resource=Resource.findAllByUser(user)
//        resource.each {
//             des= resource.description

        def resource = Resource.get(1)
        def user = resource.user
        String name = user.username
        String description = resource.description

        //redirect(action:'index',controller: 'chk',model:[resource:des])
        render(view: '/home', model: [resource: description, username: name])


    }


}

