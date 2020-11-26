package com.mockito.business;

import com.mockito.business.model.Email;

public interface EmailSender {

    boolean send(Email email);
}
