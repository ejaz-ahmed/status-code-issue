package demo

class User {
    String username

    static constraints = {
        username unique: true
    }
}
