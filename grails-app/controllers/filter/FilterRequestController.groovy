package filter

import grails.plugin.springsecurity.annotation.Secured
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.core.userdetails.UserDetails

@Secured(['permitAll'])
class FilterRequestController {

    def userDetailsService
    def cookieService
    def springSecurityService

    /**
     * For accepting cookie and fetching the username from it
     * Also destroys the existing users session
     * @return
     */
    def index() {

        List cookieDetails = cookieService.get(grailsApplication.config.cookieName).split(":")
        String username = cookieDetails[0]

        println "username of new user : " + username

        println "Removing previously logged in user"
        session.invalidate()

        redirect(action: "forRedirect", params: [username: username])
    }

    /**
     * For setting spring security context and redirecting to main application controller
     * @return
     */
    def forRedirect() {

        String password

        UserDetails userDetails = userDetailsService.loadUserByUsername(params.username)

        //setting spring security context
        SecurityContextHolder.getContext().setAuthentication(new UsernamePasswordAuthenticationToken(
                userDetails, password == null ? userDetails.getPassword() : password, userDetails.getAuthorities()))

        redirect(controller: 'provisioning', action: 'index')
    }
}
