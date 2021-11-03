package com.zss.edu.manager.service;

import com.zss.edu.manager.dao.StudentDao;
import com.zss.edu.manager.domain.Student;

public class StudentService {
    private static StudentDao studentDao = new StudentDao();

    public static boolean isExists(String id) {
        //StudentDao studentDao = new StudentDao();
        Student[] stus = studentDao.findAllStudent();
        boolean result = false;
        for (int i = 0; i < stus.length; i++) {
            Student stu01 = stus[i];
            if (stu01 != null && stu01.getId().equals(id)) {
                result = true;
                break;
            }

        }
        return result;
    }

    public static void deleteStudentById(String delid) {
        studentDao.deleteStudentById(delid);
    }

    public static void updateStudent(String updateid, Student newstu) {
        StudentDao.updateStudent(updateid, newstu);
    }


    public boolean addStudent(Student stu) {

        return studentDao.addStudent(stu);
    }

    public Student[] findAllStudent() {

        // 1. 调用库管对象的findAllStudent获取学生对象数组
        Student[] stus = studentDao.findAllStudent();
        // 2. 判断数组中是否有学生信息 (有: 返回地址,  没有: 返回null)
        // 思路: 数组中只要存在一个不是null的元素, 那就代表有学生信息
        boolean flag = false;
        for (int i = 0; i < stus.length; i++) {
            Student stu = stus[i];
            if (stu != null) {
                flag = true;
                break;
            }
        }

        if (flag) {
            // 有信息
            return stus;
        } else {
            // 没有信息
            return null;
        }

    }
}
