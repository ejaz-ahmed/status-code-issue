package demo


import org.springframework.http.HttpStatus

class UserController {
    UserService userService
	static responseFormats = ['json', 'xml']
	
    def save() {
        User user = userService.create(request.JSON.username)
        if(user.hasErrors()) {
            respond user.errors , [status: HttpStatus.BAD_REQUEST]
        } else {
            render status: HttpStatus.OK
        }
    }
}
