package com.service;

import java.util.List;

import com.Dao.UserDao;
import com.Dao.model.Employee;

public class EmployeeService {

    UserDao dao;

    public EmployeeService(){
        dao = new UserDao();

    }


    public Employee login(String username, String email) {

        Employee employee = null;
        employee = dao.getByName(username);

        if(employee != null){
            return employee;
        }

        return null;
    }

    public List<Employee> search(String keyword){

        List<Employee> result = null;

        result = dao.getAll(keyword);

        return result;
        
    }

    public void register(String username, String email){

        //TODO check if already exists
        Employee employee = new Employee(username,email);
        dao.add(employee);
    }

}
