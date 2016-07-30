# grails-spock-issue-with-postconstruct
This is a sample Grails 2.5.4 application that has an untestable service, due to Spock's handling of @PostConstruct

I demonstrate 2 different spock tests that fail for different reasons.

 * The first one fails because the initialization code makes a sanity check, that the required property in Config.groovy actually exists.

 * The second fails because the property that is initialized in the shared instance (vias setupSpec) from a configuration entry in the GrailsApplication, is not initialized in the instance of the service instance that is tested.

