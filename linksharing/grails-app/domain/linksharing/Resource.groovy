package linksharing


abstract class Resource {
    String title
    String description
    Date dateCreated
    Date lastUpdated
    byte[] file

    static constraints = {
        title(unique: true,nullable:false)
        dateCreated date: "now()"
        lastUpdated(autoTimestamp: true)
        description(maxSize:1024)
        file(maxSize: 102400,nullable: true)
    }
    static belongsTo = [topic:Topic,user:User]

}