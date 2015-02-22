package linksharing

class Subscription {
    Topic topic
    User  user
    enum Seriousness{
        SERIOUS,VERYSERIOUS,CASUAL
    }
    Date dateCreated
    Seriousness seriousness
    static constraints = {
        seriousness(blank:false)
        dateCreated date:"now()"
        user unique: 'topic'
    }
    static belongsTo = [user:User,topic:Topic]
}
