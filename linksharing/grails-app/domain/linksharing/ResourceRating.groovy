package linksharing

class ResourceRating {
    int score
    static constraints = {
    }
    static belongsTo = [resource:Resource,user:User]
}
