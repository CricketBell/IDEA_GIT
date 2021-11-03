package com.zss.edu.manager.controller;

import com.zss.edu.manager.dao.TeacherDao;
import com.zss.edu.manager.domain.Teacher;
import com.zss.edu.manager.service.TeacherService;

import java.util.Scanner;

public class TeacherController {
    TeacherService teacherService = new TeacherService();
    Scanner sc = new Scanner(System.in);

    public void start() {
        teacherLoop:
        while (true) {
            System.out.println("--------欢迎来到 <老师> 管理系统--------");
            System.out.println("请输入您的选择: 1.添加老师  2.删除老师  3.修改老师  4.查看老师  5.退出");
            String choice = sc.next();
            switch (choice) {
                case "1":
                    // System.out.println("添加老师");
                    addTeacher();
                    break;
                case "2":
                    // System.out.println("删除老师");
                    deleteTeacherById();
                    break;
                case "3":
                    // System.out.println("修改老师");
                    updateTeacher();
                    break;
                case "4":
                    // System.out.println("查看老师");
                    findAllTeacher();
                    break;
                case "5":
                    System.out.println("感谢您使用老师管理系统, 再见!");
                    break teacherLoop;
                default:
                    System.out.println("您的输入有误, 请重新输入");
                    break;
            }
        }

    }

    private void updateTeacher() {
        String id = inputTeacherId();
        System.out.println("请输入老师的姓名");
        String name = sc.next();
        System.out.println("请输入老师的年龄");
        String age = sc.next();
        System.out.println("请输入老师的生日");
        String birthday = sc.next();
        Teacher teacher = new Teacher();
        teacher.setId(id);
        teacher.setId(name);
        teacher.setAge(age);
        teacher.setBirthday(birthday);
        TeacherService.updateTeacher(id,teacher);
        System.out.println("修改成功！");

    }

    public void deleteTeacherById() {

        String delid = inputTeacherId();
        teacherService.deleteTeacherById(delid);
        System.out.println("删除成功");


    }

    public void findAllTeacher() {

        Teacher[] teachers = TeacherService.findAllTeacher();
        if (teachers == null) {
            System.out.println("查无信息，请重新输入");
            return;
        }
        System.out.println("学号\t\t姓名\t\t年龄\t\t生日");

        for (int i = 0; i < teachers.length; i++) {
            Teacher tea = new Teacher();
            tea = teachers[i];
            if (tea != null) {
                System.out.println(tea.getId() + "\t" + tea.getName() + "\t" + tea.getAge() + "\t" + tea.getBirthday());
            }

        }

    }


    public void addTeacher() {

        String id;
        while (true) {
            System.out.println("请输入老师ID：");
            id = sc.next();
            boolean result = teacherService.isExists(id);
            if (result) {
                System.out.println("ID已被占用请重新输入");
            } else {
                break;
            }
        }
        System.out.println("请输入老师的姓名：");
        String name = sc.next();
        System.out.println("请输入老师的年龄：");
        String age = sc.next();
        System.out.println("请输入老师的生日");
        String birthday = sc.next();
        Teacher tea = new Teacher();
        //此时不是用构造方法
        tea.setId(id);
        tea.setName(name);
        tea.setAge(age);
        tea.setBirthday(birthday);
        //将封装好的老师发送给业务员，返回布尔类型
        boolean result = teacherService.addTeacher(tea);
        if (result) {
            System.out.println("添加成功");
        } else {
            System.out.println("添加失败");
        }


    }

    public String inputTeacherId() {
        String id;
        while (true) {
            System.out.println("请输入id");
            id = sc.next();
            boolean exists = teacherService.isExists(id);
            if (!exists) {
                System.out.println("您输入的id不存在, 请重新输入:");
            } else {
                break;
            }
        }
        return id;
    }

}
