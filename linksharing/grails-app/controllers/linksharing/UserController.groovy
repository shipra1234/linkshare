package linksharing

import grails.gsp.PageRenderer

class UserController {
    static allowedMethods = [changePassword: 'POST', forgetPassword: 'POST']
    PageRenderer groovyPageRenderer
    def mailService

    def userList() {

        List<User> list = User.list(offset: 0, max: 20)
        render(view: '/login/userList', model: [users: list])
    }

    def forgetPassword(String username, String password) {
        User user = User.findByUsername(username)
        String link = g.createLink(controller: 'chk', action: 'forgetPassword', absolute: true, params: [username: "${user.username}"])

        println link
        if (user) {
            String email = user.email
            mailService.sendMail()
                    {
                        to email
                        subject "Forget Password"
                        html link


                    }
            flash.message = "link send in your gmail account"
            redirect(controller: 'chk', action: 'index')
        } else {
            flash.message = "UserName is not correct"
            redirect(controller: 'chk', action: 'index')


        }

    }

    def changePassword(String newPassword, String retypePassword, String username) {

        User user = User.findByUsername(username)

        if (user) {

            if (newPassword == retypePassword) {
                user.password = newPassword
                user.confirmPassword = newPassword
                user.validate()
                if (user.hasErrors()) {
                    render(view: '/forget_password', model: [errors: user])
                } else {
                    user.save(flush: true, failOnError: true)
                    flash.message = "password change successfully"
                    render(view: '/forget_password')
                }

            } else {
                 flash.message="wrong password"
                redirect(controller: 'chk', action: 'index')
            }

        }
    }
}

