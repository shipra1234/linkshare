package linksharing

import grails.transaction.Transactional
import org.springframework.web.multipart.commons.CommonsMultipartFile

@Transactional
class ProfileService {

    def updateData(String username,def photo,String firstName,String lastName,Long userId) {
        User user=User.get(userId)
        File file=new File("/home/shipra/linkshare/linksharing/upload_image/${user.username}_image.jpeg")
        file<<photo?.getBytes()
        user.executeUpdate("update User set photo=(:image),username=(:username),firstName=(:firstName),lastName=(:lastName) where id=(:id)",
                [image:file.canonicalPath,id:user.id,username:username,firstName:firstName,lastName:lastName])


    }
    def updatePassword(String password,String confirmPassword,Long userId){

        User user=User.get(userId)
        user.executeUpdate("update User set password=(:password),confirmPassword=(:confirmPassword) where id=(:id)",
       [password:password,confirmPassword:confirmPassword,id:user.id] )

    }
}
