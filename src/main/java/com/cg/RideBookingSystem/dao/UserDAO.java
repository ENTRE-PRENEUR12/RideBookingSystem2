package com.cg.RideBookingSystem.dao;

import java.util.ArrayList;
import java.util.List;
import com.cg.RideBookingSystem8.entities.User;

public interface UserDAO {
	void save(User user);
    User findById(String id);
    List<User> findAll();
    void update(User user);
    void delete(String id);
}
