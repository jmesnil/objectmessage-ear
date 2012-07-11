# EAR application to check that JMS ObjectMessage works as expected in AS7.

* Use case for https://issues.jboss.org/browse/AS7-1271

## Scenario

* instance of MyResource class is used as the JMS ObjectMessage payload
  * put inside a JAR in EAR's lib/ directory
* a Servlet send a JMS message with a MyResource instance
  * put inside a WAR in the EAR
* a MDB consumes the JMS message and is able to use the MyResource instance
  * put inside a EJB JAR in the EAR

## Instructions

1. Start AS7 with the standalone-full configuration


        $ ${JBOSS_HOME}/bin/standalone.sh -c standalone-full.xml


* Deploy the EAR

        $ mvn clean package jboss-as:deploy


  Then go to [http://localhost:8080/objectmessage-ear-web/hello](http://localhost:8080/objectmessage-ear-web/hello)
  and check in the AS7 logs that the HelloWorldMDB has received the ObjectMessage with the MyResource payload

* Undeploy the EAR

        $ mvn jboss-as:undeploy

