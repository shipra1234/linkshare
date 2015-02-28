package linksharing

import CO.UserCO
import grails.transaction.Transactional
import org.springframework.web.multipart.commons.CommonsMultipartFile

@Transactional
class UserService {

    def userRegister(User user, CommonsMultipartFile imageFile)
    {
        def photo=imageFile
        File file=new File("/home/intelligrape/linkshare/linksharing/upload_image/${user.username}_image.jpeg")
        //println "---------------"+userCO.photo?.contentType
        file<<photo?.getBytes()
        user.photo= file.canonicalPath
        println "=======path========="+user.photo
        user.save(flush: true,failOnError: true)


    }

    def userLogin(String username,String password)
    {
        User user=User.findByUsername(username)
        if(user)
        {
            println "++++++++++---------------" +user
            String pwd=user.password
            println "++++++++++++++++------------" +pwd
            return pwd

        }

    }
}