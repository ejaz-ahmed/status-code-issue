package demo

import grails.converters.JSON
import grails.testing.gorm.DomainUnitTest
import grails.testing.web.controllers.ControllerUnitTest
import org.grails.web.json.JSONObject
import spock.lang.Specification

class UserControllerSpec extends Specification implements ControllerUnitTest<UserController>, DomainUnitTest <User> {

    def setup() {
    }

    def cleanup() {
    }

    void "test something"() {
        given:
        JSONObject json = JSON.parse('{"username":"test"}')
        String username = 'test'
        controller.userService = Mock(UserService) {
            1 * create(username) >> {
                User user = new User(username: "bar")
                user.errors.reject(
                        'user.username.unique',
                        ['username', 'class User'] as Object [],
                        'dummy msg')
                user
            }
        }

        when:
        request.setJson(json)
        request.method = 'POST'
        controller.save()

        then:
        response.status == 400

    }
}