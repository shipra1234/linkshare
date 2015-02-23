package linksharing

class Topic {

    String name
    Date dateCreated
    Date lastUpdated
    enum Visibility{
        PUBLIC,PRIVATE
    }
    Visibility visibility
    static constraints = {
        visibility(blank:true)
        dateCreated date:"now()"
        lastUpdated( autoTimestamp:true)
    }

    public String toString()
    {
        return name
    }
    static hasMany = [resource:Resource,subscription:Subscription]
    static belongsTo = [user:User,subscription:Subscription]

}
