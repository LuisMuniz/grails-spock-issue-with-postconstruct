    package issue

    import grails.test.mixin.TestFor
    import spock.lang.Specification

    @TestFor(MyService)
    class MyServiceSpec extends Specification {

        def setup() {
            grailsApplication.config.myProperty = 'myValue'
        }

        void "It fails to initialize the service"() {
            expect:
            false // this is never executed
        }
    }
