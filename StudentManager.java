package heima;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentManager {
    public static void main(String[] args) {

        ArrayList<Student> array = new ArrayList<>();

        while (true) {

            System.out.println("-----欢迎使用学生管理系统-----");
            System.out.println("1 添加学生");
            System.out.println("2 删除学生");
            System.out.println("3 修改学生");
            System.out.println("4 查看所有学生");
            System.out.println("5 退出");
            System.out.println("请输入你的选择：");

            Scanner sc = new Scanner(System.in);
            String line = sc.nextLine();


            switch (line) {
                case "1":
                    System.out.println("添加学生");
                    addStudent(array);
                    break;
                case "2":
                    System.out.println("删除学生");
                    deleteStudent(array);
                    break;
                case "3":
                    System.out.println("修改学生");
                    updateStudent(array);
                    break;
                case "4":
                    System.out.println("查看所有学生");
                    findStudent(array);
                    break;
                case "5":
                    System.out.println("谢谢使用本系统");
                    //break;
                    System.exit(0);//JVM推出
                default:
                    System.out.println("输入数据有误");
                    break;
            }

        }

    }

    public static void addStudent(ArrayList<Student> array) {
        Scanner sc = new Scanner(System.in);


        //为了sid在循环外被访问到，定义在循环外
        String sid;

        //为了让程序回到这，使用循环实现

        while(true) {
            System.out.println("请输入学生学号：");
            sid = sc.nextLine();

            if (isUsed(array, sid)) {
                System.out.println("学号重复了");
            }else {
                break;
            }
        }


        System.out.println("请输入学生姓名：");
        String name = sc.nextLine();
        System.out.println("请输入学生年龄：");
        String age = sc.nextLine();
        System.out.println("请输入学生住址：");
        String address = sc.nextLine();

        Student s = new Student();
        s.setSid(sid);
        s.setName(name);
        s.setAge(age);
        s.setAddress(address);

        array.add(s);
        System.out.println("输入成功");

    }


    public static void findStudent(ArrayList<Student> array) {
        // \t就是tab键
        if (array.size() == 0) {
            System.out.println("无信息，请先添加");

            //为了让程序不往下执行，return;
            return;
        }
        System.out.println("学号\t姓名\t年龄\t居住地");
        for (int i = 0; i < array.size(); i++) {
            Student s = array.get(i);
            System.out.println(s.getSid() + "\t" + s.getName() + "\t" + s.getAge() + "岁\t" + s.getAddress());
        }


    }


    public static void deleteStudent(ArrayList<Student> array) {
        Scanner sc = new Scanner(System.in);

        System.out.println("请输入要删除学生的学号");

        String sid = sc.nextLine();

        int index = -1;

        for (int i = 0; i < array.size(); i++) {
            Student s = array.get(i);
            if (s.getSid().equals(sid)) {
                index = i;
                break;
            }
        }

        if (index == -1) {
            System.out.println("学号输入错误");
        } else {
            array.remove(index);
            System.out.println("删除成功");

        }
    }


    public static void updateStudent(ArrayList<Student> array) {

        System.out.println("请输入要更改的学生学号");
        Scanner sc = new Scanner(System.in);
        String sid = sc.nextLine();

        int index = -1;

        for (int i = 0; i < array.size(); i++) {
            Student student = array.get(i);
            if (student.getSid().equals(sid)) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            System.out.println("学号输入错误");
        } else {
            System.out.println("输入学生的新姓名");
            String name = sc.nextLine();
            System.out.println("输入学生的新年龄");
            String age = sc.nextLine();
            System.out.println("输入学生的新住址");
            String address = sc.nextLine();

            Student s = new Student();
            s.setSid(sid);
            s.setName(name);
            s.setAge(age);
            s.setAddress(address);
            array.set(index, s);
            System.out.println("修改成功");
        }

    }


    public static boolean isUsed(ArrayList<Student> array,String sid) {
        boolean flag =false;
        for (int i = 0; i < array.size(); i++) {
            Student s = array.get(i);
            if(s.getSid().equals(sid)){
                flag = true;
                break;
            }
        }
        return flag;
    }
}





