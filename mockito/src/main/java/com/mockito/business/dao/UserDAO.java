package com.mockito.business.dao;

import com.mockito.business.entity.UserEntity;
import com.mockito.business.model.User;

public interface UserDAO {

    UserEntity save(User user);

}
