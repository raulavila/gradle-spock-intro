package com.raulavila.calculator;

public class AuditImpl implements Audit {
    @Override
    public void register(String request) {
        System.out.println(request);
    }
}
