package com.raulavila.helloworld

import spock.lang.Specification

class MessageServiceSpec extends Specification {

    def "first Spock test"() {
        
        when: "get message from MessageService"
        String message = MessageService.getMessage()
        
        then: "message is Hello World"
        message == 'Hello World'
    
    }
}
