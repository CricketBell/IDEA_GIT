package com.zss.edu.manager.controller;

import com.zss.edu.manager.domain.Student;
import com.zss.edu.manager.service.StudentService;

import javax.security.sasl.SaslClient;
import javax.xml.namespace.QName;
import java.util.Scanner;

public class StudentController {
    Scanner sc = new Scanner(System.in);
    StudentService studentservice = new StudentService();

    public void start() {

        studentLoop:
        while (true) {
            System.out.println("--------欢迎来到 <学生> 管理系统--------");
            System.out.println("请输入您的选择: 1.添加学生  2.删除学生  3.修改学生  4.查看学生  5.退出");

            String choice = sc.next();
            switch (choice) {
                case "1":
                    //System.out.println("添加");
                    addStudent();
                    break;
                case "2":
                    //System.out.println("删除");
                    deleteStudentById();
                    break;
                case "3":
                    //System.out.println("修改");
                    updateStudent();
                    break;
                case "4":
                    //System.out.println("查询");
                    findAllStudent();
                    break;
                case "5":
                    System.out.println("感谢您使用学生管理系统, 再见!");
                    break studentLoop;
                default:
                    System.out.println("您的输入有误, 请重新输入");
                    break;
            }
        }
    }

    public void updateStudent() {
        String id = inputStudentID();

        Student newstu = inputStudentiofo(id);
        StudentService.updateStudent(id, newstu);
        System.out.println("修改成功！");

    }

    public void deleteStudentById() {
        String delid = inputStudentID();
        StudentService.deleteStudentById(delid);
        System.out.println("删除成功！");

    }

    private void findAllStudent() {
        Student[] stus = studentservice.findAllStudent();
        if (stus == null) {
            System.out.println("查无信息，请重新输入");
            return;
        }
        System.out.println("学号\t\t姓名\t\t年龄\t\t生日");
        for (int i = 0; i < stus.length; i++) {
            Student stu01 = new Student();
            stu01 = stus[i];
            if (stu01 != null) {
                System.out.println(stu01.getId() + "\t\t" + stu01.getName() + "\t" + stu01.getAge() + "\t\t" + stu01.getBirthday());
            }
        }


    }

    private void addStudent() {
        //Scanner sc = new Scanner(System.in);
        String id;
        while (true) {
            System.out.println("请输入学生ID：");
            id = sc.next();
            boolean result = StudentService.isExists(id);
            if (result) {
                System.out.println("请重新输入ID");

            } else {
                break;
            }
        }
        Student stu = inputStudentiofo(id);


        boolean result = studentservice.addStudent(stu);
        if (result) {
            System.out.println("添加成功！");
        } else {
            System.out.println("添加失败！");
        }

    }

    public String inputStudentID() {
        String id;
        while (true) {
            System.out.println("请输入学生ID：");
            id = sc.next();
            boolean result = StudentService.isExists(id);
            if (!result) {
                System.out.println("请重新输入ID");

            } else {
                break;
            }
        }
        return id;
    }

    public Student inputStudentiofo(String id) {
        System.out.println("请输入学生姓名：");
        String name = sc.next();
        System.out.println("请输入学生年龄：");
        String age = sc.next();
        System.out.println("请输入学生生日：");
        String birthday = sc.next();
        Student stu = new Student();
        stu.setId(id);
        stu.setName(name);
        stu.setAge(age);
        stu.setBirthday(birthday);
        return stu;
    }
}
