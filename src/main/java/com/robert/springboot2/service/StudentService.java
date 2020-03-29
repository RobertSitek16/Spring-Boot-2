package com.robert.springboot2.service;

import com.robert.springboot2.dao.StudentDao;
import com.robert.springboot2.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class StudentService {

    private final StudentDao studentDao;

    @Autowired
    public StudentService(@Qualifier("fakeDao") StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    public int persistNewStudent(UUID studentId, Student student){
        UUID studentUid = studentId == null ? UUID.randomUUID() : studentId;
        student.setId(studentId);
        return studentDao.insertNewStudent(studentUid, student);
    }

    public Student getStudentByID(UUID studentId){
        return studentDao.selectStudentByID(studentId);
    }

    public List<Student> getAllStudents(){
        return studentDao.selectAllStudents();
    }

    public int updateStudentById(UUID studentId, Student studentUpdate){
        return studentDao.updateStudentById(studentId, studentUpdate);
    }

    public int deleteStudentById(UUID studentId){
        return studentDao.deleteStudentById(studentId);
    }
}
