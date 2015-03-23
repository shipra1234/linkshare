package linksharing


class User {
    String username
    String email
    String password
    String firstName
    String lastName
    String confirmPassword
    String photo
    String role
    boolean active
    Date dateCreated
    Date lastUpdated
    static constraints = {
        username(unique: true)
        email(email: true, blank: false)
        password (size: 6..10,blank: false, validator: { val, obj ->
            if (!(val?.equals(obj.confirmPassword))) {
                return false
            }
        })
        dateCreated date: "now()"
        lastUpdated(autoTimestamp: true)
        photo(maxSize: 1024 * 1024 * 2, nullable: true)
        //admin(nullable: true, blank: true)
        active(nullable: true, blank: true)
        confirmPassword(nullable: false, blank: true)

    }

    static hasMany = [topic: Topic]
    static belongsTo = [Subscription, ReadingItem]
}
