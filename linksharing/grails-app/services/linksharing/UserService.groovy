package linksharing

import CO.UserCO
import grails.transaction.Transactional
import org.springframework.web.multipart.commons.CommonsMultipartFile

@Transactional
class UserService {

    def userRegister(User user, CommonsMultipartFile imageFile)
    {
        def photo=imageFile
        File file=new File("/home/shipra/linkshare/linksharing/upload_image/${user.username}_image.jpeg")
        file<<photo?.getBytes()
        user.photo= file.canonicalPath
        user.save(flush: true,failOnError: true)


    }

    def userLogin(String username)
    {
        User user=User.findByUsername(username)
        if(user)
        {
            String pwd=user.password
            return pwd

        }


    }
    def name(String userName)
    {
        User user=User.findByUsername(userName)
        String firstName=user.firstName
        return firstName
    }
}