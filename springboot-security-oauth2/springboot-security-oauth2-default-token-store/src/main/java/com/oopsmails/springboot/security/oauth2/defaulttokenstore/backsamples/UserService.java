package com.oopsmails.springboot.security.oauth2.defaulttokenstore.backsamples;

import java.util.List;

public interface UserService {

    User save(User user);
    List<User> findAll();
    void delete(long id);
}
