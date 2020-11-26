package com.mockito.business;

import com.mockito.business.dao.UserDAO;
import com.mockito.business.entity.UserEntity;
import com.mockito.business.model.Email;
import com.mockito.business.model.User;

import java.security.CryptoPrimitive;

/**
 * gerencia a alteração de senha de usuários;
 */
public class UserPasswordService {

    private UserDAO userDAO;
    private EmailSender emailSender;



    public UserPasswordService(UserDAO userDAO, EmailSender emailSender){
        this.userDAO = userDAO;
        this.emailSender = emailSender;
    }

    //o envio do email deve obrigatoriamente ocorrer APÓS a persistência, pois não queremos enviar um email
    // notificando o usuário sobre algo que não aconteceu (afinal, poderia ocorrer um erro durante a atualização da base de dados e a senha não ser alterada).
    // Esse será nosso teste:
    public void changePassword(User user, String newPassword){
        user.setPassWord(newPassword);

        Email email = new Email();
        email.setReceiverAddress(user.getEmail());
        email.setSubject("Alteração de senha");
        email.setBody("Sua senha foi alterada com sucesso");

        emailSender.send(email);
        userDAO.save(user);

    }
}
