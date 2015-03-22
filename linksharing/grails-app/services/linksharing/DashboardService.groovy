package linksharing

import grails.transaction.Transactional

@Transactional
class DashboardService {

    def showReadItems(String userName, Integer max, Integer offset) {
        List<Resource> resources = []
        List<ReadingItem> isRead=[]
        List data = []
        User user = User.findByUsername(userName)
        List<ReadingItem> readingItems = ReadingItem.findAllByUserAndIsRead(user,false,[max: max, offset: offset])
        readingItems.each { read ->
            resources << read.resource
            isRead   <<  read.id
        }
        Integer count = ReadingItem.countByUser(user)
        data << count
        data << resources
        data << isRead
        return data

    }

    def showPost(String username) {
        User user = User.findByUsername(username)
        Integer topic = Topic.countByUser(user)
        return topic

    }

    def subscription(String username) {
        List data = []
        User user = User.findByUsername(username)
        List<Subscription> subscription1 = Subscription.findAllByUser(user, [max: 6, offset: 0])
        println "subscription++++++++ " + subscription1
        List<Topic> topics = subscription1.topic
        Integer subscription = Subscription.countByUser(user)
        data << topics
        data << subscription
        return data
    }

    def showTopic(String username) {
        User user = User.findByUsername(username)
        Topic topic = Topic.findByUser(user)
        return topic.name
    }

    def edit(String seriousness, String username, String topic) {
        def value1 = seriousness as Subscription.Seriousness
        User user = User.findByUsername(username)
        Topic topic1 = Topic.findByName(topic)
        Subscription subscription = Subscription.findByUserAndTopic(user, topic1)
        def id = subscription.id
        subscription.executeUpdate("update Subscription set seriousness=(:serious) where id=(:id)", [serious: value1, id: id])
        return seriousness
    }

    def editVisibility(String visibility, String username, String topic) {
        def value = visibility as Topic.Visibility
        User user = User.findByUsername(username)
        Topic topic1 = Topic.findByName(topic)
        def id = topic1.id
        topic1.executeUpdate("update Topic set visibility=(:visible) where id=(:id)", [visible: value, id: id])

    }

    def invite(String email, String topic, String username, String link, def mailService) {

        if (username) {
            mailService.sendMail()
                    {
                        to email
                        subject "Forget Password"
                        html link

                    }


        }
    }
}




