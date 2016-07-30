package issue

import org.codehaus.groovy.grails.commons.GrailsApplication

import javax.annotation.PostConstruct

class MyService {
    GrailsApplication grailsApplication
    String property

    @PostConstruct
    void init() {
        println "Initializing... ${this}"
        property = grailsApplication.config.myProperty

//Enabling this business sanity check make the service untestable under Spock, because to be able to run, we need to initialize the configuration of the shared instance
// but the execution of the method under test will not have the initialized property, because the service being executed is not the shared instance
        if (property == "[:]") {
            throw new RuntimeException("This property cannot be empty")
        }
    }


    void doSomething() {
        println "Executing... ${this}"
        println(property.toLowerCase())
    }
}
