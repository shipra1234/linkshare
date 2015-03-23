package linksharing

import org.springframework.web.multipart.commons.CommonsMultipartFile

class ProfileController {
    static allowedMethods = [updateProfile: 'POST',changePassword:'POST']
     def profileService
    def dashboardService
    def editProfile() {
        String username=session.getAttribute('user')
        Integer post=dashboardService.showPost(username)
        List subscription=dashboardService.subscription(username)
        Integer subscriptionCount=subscription[1]
        User user=User.findByUsername(username)
        render(view:'editProfile',model:[user:user,post:post,subscription:subscriptionCount])
    }
    def updateProfile(String username,String firstName,String lastName,Long userId){
        def photo=params.photo
      profileService.updateData(username,photo,firstName,lastName,userId)
        flash.message="update successfully"
        redirect(controller:'profile',action:'editProfile')
    }
    def changePassword(String password,String confirmPassword,Long userId){
        profileService.updatePassword(password,confirmPassword,userId)
        flash.message="update successfully"
        redirect(controller:'profile',action:'editProfile')

    }
}
