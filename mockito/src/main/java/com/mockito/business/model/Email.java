package com.mockito.business.model;

public class Email {

    private String receiverAddress;
    private String subject;
    private String body;

    public Email(){

    }

    public Email(String receiverAddress, String subject, String body) {
        this.receiverAddress = receiverAddress;
        this.subject = subject;
        this.body = body;
    }

    public String getReceiverAddress() {
        return receiverAddress;
    }

    public void setReceiverAddress(String receiverAddress) {
        this.receiverAddress = receiverAddress;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
