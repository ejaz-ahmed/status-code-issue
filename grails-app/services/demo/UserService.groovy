package demo

import grails.gorm.transactions.Transactional

@Transactional
class UserService {

    User create(String username) {
        User user = new User(username: username)
        user.save()
        user
    }
}
