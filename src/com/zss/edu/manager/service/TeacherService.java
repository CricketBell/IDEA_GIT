package com.zss.edu.manager.service;

import com.zss.edu.manager.dao.TeacherDao;
import com.zss.edu.manager.domain.Teacher;

public class TeacherService {
    static TeacherDao teacherDao = new TeacherDao();

    public static Teacher[] findAllTeacher() {
        boolean flag = false;
        Teacher[] teas = teacherDao.findAllTeacher();
        for (int i = 0; i < teas.length; i++) {
            Teacher tea = new Teacher();
            tea = teas[i];
            if (tea != null) {
                flag = true;
                break;

            }
        }
        if (flag) {
            return teas;
        }
        else{
            return null;
        }
    }

    public static void updateTeacher(String id, Teacher teacher) {
        teacherDao.updateTeacher(id,teacher);
    }

    public boolean addTeacher(Teacher tea) {
        return TeacherDao.addTeacher(tea);

    }

    public static boolean isExists(String id) {
        boolean exists = false;
        Teacher[] teas = teacherDao.findAllTeacher();
        for (int i = 0; i < teas.length; i++) {
            Teacher tea01 = new Teacher();
            tea01 = teas[i];
            if (tea01 != null && tea01.getId().equals(id)) {
                exists = true;
                break;
            }
        }
        return exists;
    }


    public void deleteTeacherById(String delid) {
        teacherDao.deleteTeacherById(delid);
    }
}
