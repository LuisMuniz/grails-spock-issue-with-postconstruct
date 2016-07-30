package issue

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.services.ServiceUnitTestMixin} for usage instructions
 */
@TestFor(MyService)
class MyServiceWithSharedInstanceInitializationSpec extends Specification {

    //Initializing the shred instance grailsApplication lets the @PostConstruct work, but will fail during method test
    //because the instance that was initialized is the shared instance
    def setupSpec() {
        grailsApplication.config.myProperty = 'myValue'
    }

    void "It fails to execute myProperty"() {
        when:
        service.doSomething()

        then:
        def e = thrown(NullPointerException)
        e.message == 'Cannot invoke method toLowerCase() on null object'
        service.property == null
    }
}
