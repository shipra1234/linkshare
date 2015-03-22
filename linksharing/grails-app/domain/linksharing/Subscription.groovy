package linksharing

class Subscription {
    enum Seriousness{
        SERIOUS,VERYSERIOUS,CASUAL
    }
    Date dateCreated
    Seriousness seriousness
    static constraints = {
        seriousness(blank:true)
        dateCreated date:"now()"
        user unique: 'topic'
    }
    static belongsTo = [user:User,topic:Topic]
}
