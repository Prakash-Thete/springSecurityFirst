import grails.plugin.springsecurity.SecurityFilterPosition
import static grails.plugin.springsecurity.SpringSecurityUtils.clientRegisterFilter

class BootStrap {

    def userManagementService

    def init = { servletContext ->
        //Bootstrapping System Roles
        userManagementService.bootstrapSystemRoles()
    }
    def destroy = {
    }
}
