package com.jandrevl.familycomms;

public class Message {
    String sender;
    String dateTime;
    String messageText;

    public Message(String sender, String dateTime, String messageText) {
        this.sender = sender;
        this.dateTime = dateTime;
        this.messageText = messageText;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

    @Override
    public String toString() {
        return "Message{" +
                "sender='" + sender + '\'' +
                ", dateTime='" + dateTime + '\'' +
                ", messageText='" + messageText + '\'' +
                '}';
    }
}
