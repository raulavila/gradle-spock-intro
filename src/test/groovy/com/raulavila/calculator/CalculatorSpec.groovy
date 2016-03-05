package com.raulavila.calculator

import spock.lang.Specification
import spock.lang.Subject

import static com.raulavila.calculator.Calculator.Mode.ABSOLUTE
import static com.raulavila.calculator.Calculator.Mode.STRAIGHT

class CalculatorSpec extends Specification {

    Audit audit = Mock()

    @Subject
    Calculator calculator = new Calculator(audit)

    def "Calculator can add operands in straight mode"() {
        when: "We add two operands in straight mode"
        long sum = calculator.add(operand1, operand2, STRAIGHT)

        then: "The result of the sum matches the expected one"
        sum == expectedResult

        where:
        operand1 | operand2 || expectedResult
        2        | 2        || 4
        -2       | 2        || 0
        -3       | -3       || -6
    }

    def "Calculator can add operands in absolute mode"() {
        when: "We add two operands in absolute mode"
        long sum = calculator.add(operand1, operand2, ABSOLUTE)

        then: "The result of the sum matches the expected one"
        sum == expectedResult

        where:
        operand1 | operand2 || expectedResult
        2        | 2        || 4
        -2       | 2        || 4
        -3       | -3       || 6
    }

    def "Audit object intercepts all calls to the Calculator"() {
        when: "We add two operands in any mode"
        calculator.add(2, 2, ABSOLUTE)
        calculator.add(2, 2, STRAIGHT)

        then: "The Audit object registers the call"
        1 * audit.register("2 + 2 (ABSOLUTE)")
        1 * audit.register("2 + 2 (STRAIGHT)")
    }
}