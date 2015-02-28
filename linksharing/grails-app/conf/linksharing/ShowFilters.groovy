package linksharing

class ShowFilters {

    def filters = {
        all(controller: '*', action: '*') {
            before = {

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

        activeUser(controller:'user',action:'*')
                {
                    before= {
                        if (session.getAttribute("user") == null) {
                            redirect(controller: 'chk', action: 'index')
                            return false
                        } else {
                            println "welcome"
                        }
                    }

                    }
           User(controller:'*',action:'*')
                   {
            before={
                println "${controllerName}+----------+++++++++++${actionName}"
            }
        }
                }


    }

