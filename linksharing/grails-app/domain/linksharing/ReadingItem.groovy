package linksharing

class ReadingItem {
    Boolean isRead
    static constraints = {
    }
    static belongsTo = [user:User,resource:Resource]
}
