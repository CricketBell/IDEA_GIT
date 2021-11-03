package com.zss.edu.manager.dao;

import com.zss.edu.manager.domain.Student;

public class StudentDao {
    private static Student[] stus = new Student[5];

    public static void updateStudent(String updateid, Student newstu) {
        int up = getIndex(updateid);
        stus[up] = newstu;
    }

    public boolean addStudent(Student stu) {

        int index = -1;
        for (int i = 0; i < stus.length; i++) {
            Student stu01 = stus[i];
            if (stu01 == null) {
                index = i;
            }
        }
        if (index == -1) {
            //装满了
            return false;
        } else {
            //添加成功
            stus[index] = stu;
            return true;
        }
    }

    public Student[] findAllStudent() {
        return stus;
    }

    public void deleteStudentById(String delid) {
        int index = getIndex(delid);
        stus[index] = null;
    }

    public static int getIndex(String id) {
        int index = -1;
        for (int i = 0; i < stus.length; i++) {
            Student stu = stus[i];
            if (stu != null && stu.getId().equals(id)) {
                index = i;
                break;
            }
        }
        return index;

    }
}
