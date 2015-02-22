package linksharing

class User {
     String username
     String email
     String password
    String firstName
    String lastName
    byte[] photo
    boolean admin
    boolean active
    Date dateCreated
    Date lastUpdated
    static constraints = {
        username(unique: true)
        email(email:true,blank:false)
        password(size: 6..10,blank:false)
        dateCreated date:"now()"
        lastUpdated(autoTimestamp:true)
        photo(maxSize:1024*1024*2,nullable:true)
    }

    public String toString()
    {
        return username
    }
    static hasMany = [topic:Topic]
    static belongsTo = Subscription
}
