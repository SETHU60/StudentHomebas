package za.ac.cput.service;
/*
 * Author : Sabelo Kama (219149364)
 * Date : 24 July 2024
 * */

import za.ac.cput.domain.StudentApplication;

import java.util.List;

public interface IStudentApplicationService extends IService<StudentApplication, Long> {

    List <StudentApplication> getAll();
}
