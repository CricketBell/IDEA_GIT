package com.zss.edu.manager.dao;

import com.zss.edu.manager.domain.Teacher;

public class TeacherDao {
    private static Teacher[] teas = new Teacher[5];

    public static boolean addTeacher(Teacher tea) {
        //判断数组是否装满
        int index = -1;
        for (int i = 0; i < teas.length; i++) {
            Teacher tea01 = new Teacher();
            tea01 = teas[i];
            if (tea01 == null) {
                index = i;
                break;
            }

        }
        if (index == -1) {
            return false;
        } else {
            teas[index] = tea;
            return true;
        }
    }

    public Teacher[] findAllTeacher() {
        return teas;
    }

    public void deleteTeacherById(String delid) {
        // 1. 查询id在数组中的索引位置
        int index = getIndex(delid);
        // 2. 将该索引位置的元素, 使用null进行替换
        teas[index] = null;


    }

    public int getIndex(String id) {
        int index = -1;
        for (int i = 0; i < teas.length; i++) {
            Teacher t = teas[i];
            if (t != null && t.getId().equals(id)) {
                index = i;
                break;
            }
        }

        return index;
    }

    public void updateTeacher(String id, Teacher teacher) {
        int index = getIndex(id);
        teas[index] = teacher;
    }
}
