package linksharing

class LoginController {

        def signUp()
        {

            def resource=Resource.get(1)
            def user=resource.user
            String name=user.username
            String description=resource.description
            render(view:'/home',model:[resource:description,username:name])
        }

    }

