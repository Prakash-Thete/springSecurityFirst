package springsecurityfirst

import grails.plugin.springsecurity.annotation.Secured
import util.RestSessionUtil
import util.ServiceContext

@Secured(['ROLE_SUPER_ADMIN', 'ROLE_ADMIN'])
class ProvisioningController {
    def springSecurityService
    def cookieService
    def userManagementService

    @Secured(['ROLE_SUPER_ADMIN', 'ROLE_ADMIN'])
    def index() {
        redirect(action: 'showDetails')
    }

    @Secured(['ROLE_SUPER_ADMIN', 'ROLE_ADMIN'])
    def showDetails(){
        ServiceContext sCtx = RestSessionUtil.getServiceContext(request, springSecurityService, userManagementService)
        [userName : sCtx.userId, role : sCtx.mainRole]
    }
}
