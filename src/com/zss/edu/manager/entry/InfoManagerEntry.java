package com.zss.edu.manager.entry;

import com.zss.edu.manager.controller.StudentController;
import com.zss.edu.manager.controller.TeacherController;

import java.util.Scanner;

public class InfoManagerEntry {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            // 主菜单搭建
            System.out.println("--------欢迎来到蟋蟀信息管理系统--------");
            System.out.println("请输入您的选择: 1.学生管理  2.老师管理  3.退出");
            String choice = sc.next();
            StudentController studentController = new StudentController();
            switch (choice) {
                case "1":
                    // System.out.println("学生管理");
                    // 开启学生管理系统

                    studentController.start();
                    break;
                case "2":
                    //System.out.println("老师管理");
                    TeacherController teacherController = new TeacherController();
                    teacherController.start();
                    break;
                case "3":
                    System.out.println("感谢您的使用");
                    // 退出当前正在运行的JVM虚拟机
                    System.exit(0);
                    break;
                default:
                    System.out.println("您的输入有误, 请重新输入");
                    break;
            }
        }
    }
}
