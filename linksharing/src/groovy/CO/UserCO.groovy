package CO

import grails.validation.Validateable
import org.springframework.web.multipart.commons.CommonsMultipartFile

/**
 * Created by intelligrape on 25/2/15.
 */
@Validateable
class UserCO {
    String username
    String firstName
    String lastName
    String email
    String password
    String confirmPassword
    CommonsMultipartFile photo

    static constraints = {
        username(unique: true)
        email(email:true,blank:false)
        password(size: 6..10,blank:false)
       // dateCreated date:"now()"
        //lastUpdated(autoTimestamp:true)
        photo(maxSize:1024*1024*2,nullable:true)
        //admin(nullable:true,blank:true)
        //active(nullable:true,blank:true)
        confirmPassword(nullable: true,blank:true)
    }

}
