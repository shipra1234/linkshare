package linksharing


class Resource {
    String title
    String description
    Date dateCreated
    Date lastUpdated
    String pathToFile
    byte[] file

    static constraints = {
        title(unique: true,nullable:false)
        dateCreated date: "now()"
        lastUpdated(autoTimestamp: true)
        description(maxSize:1024)
        file(maxSize: 102400)
    }
    static belongsTo = [topic:Topic,user:User]

}