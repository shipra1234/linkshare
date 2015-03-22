package linksharing

class ShowFilters {

    def filters = {
        all(controller: '*', action: '*') {
            before = {
                println "-----------------${params}"

            }
            after = { Map model ->

            }
            afterView = { Exception e ->

            }
        }

//        allUser(controllerExclude:'login',actionExclude:'signUp'){
//
//            before={
//                session.setAttribute("user","shipra")
//            }
//            after={
//                println session.getAttribute("user")
//            }
//        }

//       activeUser(controller:'login',action:'login')
//                {
//                    before= {
//
//                            if (session.getAttribute("user") == null) {
//                                redirect(controller: 'chk', action: 'index')
//
//                            }
//                        }
//
//
//                   }
//
           forAdmin(controller:'user',action:'userList')
                   {
                       before = {
                           String name=session.getAttribute('user')
                           User user=User.findByUsername(name)
                               if (user.role!='admin') {
                                   flash.message="you are not authorized for this link"
                                   redirect(controller: 'chk', action: 'index')

                               }
                           }
                       }
//
//           User(controller:'*',action:'*')
//                   {
//            before={
//                println "${controllerName}+----------+++++++++++${actionName}"
//           }
//       }
//                }

//       notUser(controller:'*',action:'*',controllerExclude:'login|assets|chk')
//               {
//                     before={
//                         if (session.getAttribute("user") == null) {
//                             redirect(controller: 'login', action: 'signUp')
//                         }
//
//                         }
//               }
    }

}

