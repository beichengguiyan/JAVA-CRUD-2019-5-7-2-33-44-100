package com.employee.crud.service;

import com.employee.crud.entity.Employee;
import com.employee.crud.exception.BusinessException;
import com.employee.crud.data.UserData;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private List<Employee> userData = UserData.userData();

    public List<Employee> getAllUser() {
        return userData;
    }

    public void addUser(Employee user) {

        userData.add(user);
    }

    public void updateUserById(int userId, Employee user) throws BusinessException {
    	Employee userInfo = getUserById(userId);
        userInfo.setName(user.getName());
        save(userInfo);
    }

    public void deleteUserById(int userId) throws BusinessException {
        deleteById(userId);
    }

    private Employee getUserById(int userId) throws BusinessException {
        return userData.stream()
                .filter(item -> item.getId() == userId)
                .findFirst()
                .orElseThrow(() -> new BusinessException(
                        String.format("Unknown User with id: %s", userId)
                ));
    }

    private void save(Employee userInfo) {
        int index = 0;
        for(int i = 0; i<userData.size(); i++){
            if(userData.get(i).getId() == userInfo.getId()){
                index = i;
            }
        }
        userData.set(index, userInfo);
    }

    private void deleteById(int userId) throws BusinessException {
    	Employee user = getUserById(userId);
        userData.remove(user);
    }
}
