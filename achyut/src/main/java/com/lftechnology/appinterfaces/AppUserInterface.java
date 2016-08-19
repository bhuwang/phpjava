package com.lftechnology.appinterfaces;

import com.lftechnology.entities.Employee;
import com.lftechnology.entities.User;
/**
 * Interface for authentication for the application users
 * @author achyut
 *
 */
public interface AppUserInterface {

    public Employee authenticate(User user);
    
}
