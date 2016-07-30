package issue

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.services.ServiceUnitTestMixin} for usage instructions
 */
@TestFor(MyService)
class MyServiceSpec extends Specification {

    def setup() {
        grailsApplication.config.myProperty = 'myValue'
    }

    void "It fails to initialize myProperty"() {
        when:
        service.doSomething()

        then:
        service.property == null
    }
}