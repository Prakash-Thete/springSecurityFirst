
import org.springframework.security.core.userdetails.UserDetailsByNameServiceWrapper

// Place your Spring DSL code here
beans = {

    userDetailsServiceWrapper(UserDetailsByNameServiceWrapper) {
        userDetailsService = ref('userDetailsService')
    }

    cookieService = ref("cookieService")
}
