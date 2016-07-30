    package issue

    import grails.test.mixin.TestFor
    import spock.lang.Specification

    @TestFor(MyService)
    class MyServiceWithSharedInstanceInitializationSpec extends Specification {

        //Initializing the shared instance grailsApplication lets the @PostConstruct work, but will fail during method test
        //because the instance that was initialized is the shared instance
        def setupSpec() {
            grailsApplication.config.myProperty = 'myValue'
        }

        void "It fails to execute doSomething()"() {
            when:
            service.doSomething()

            then:
            def e = thrown(NullPointerException)
            e.message == 'Cannot invoke method toLowerCase() on null object'
            service.property == null
        }
    }
