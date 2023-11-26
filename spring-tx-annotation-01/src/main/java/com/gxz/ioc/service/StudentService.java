package com.gxz.ioc.service;


import java.io.FileNotFoundException;

public interface StudentService {
    void changeInfo();
    void writeFile() throws FileNotFoundException;
    void getStudentInfo();
}
