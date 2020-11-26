package com.mockito.business;

import static org.mockito.Mockito.*;

import com.mockito.business.dao.UserDAO;
import com.mockito.business.model.Email;
import com.mockito.business.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith()
public class UserPasswordServiceTest {

    @Mock
    private UserDAO mockUserDAO;

    @Mock
    private EmailSender mockEmailSender;

    @InjectMocks
    private UserPasswordService userPasswordService;

    @Test
    public void shouldSaveNewPasswordAndSendEmailToUser(){
        User user = new User();

        userPasswordService.changePassword(user, "newPassword");

        InOrder inOrder = inOrder(mockUserDAO, mockEmailSender);

        inOrder.verify(mockUserDAO).save(user);
        inOrder.verify(mockEmailSender).send(notNull(Email.class));

    }

}
