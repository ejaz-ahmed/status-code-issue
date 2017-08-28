package demo


import org.springframework.http.HttpStatus

class UserController {
	static responseFormats = ['json', 'xml']
	
    def save() {
        User user = new User()
        user.username = request.JSON.username
        user.save()
        if(user.hasErrors()) {
            respond user.errors , [status: HttpStatus.BAD_REQUEST]
        } else {
            render status: HttpStatus.OK
        }
    }
}
