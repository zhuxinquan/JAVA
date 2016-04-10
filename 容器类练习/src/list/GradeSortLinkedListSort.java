package list;

import java.util.*;

/**
 * Created by zhuxinquan on 16-4-6.
 */
public class GradeSortLinkedListSort {

    static class Student{
        private String name;
        private String id;
        private String grade;

        public Student(String name, String id, String grade) {
            this.name = name;
            this.id = id;
            this.grade = grade;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getGrade() {
            return grade;
        }

        public void setGrade(String grade) {
            this.grade = grade;
        }
    }

    static class Cm implements Comparator<Student>{
        @Override
        public int compare(Student o1, Student o2) {
            return Integer.parseInt(o2.getGrade()) - Integer.parseInt(o1.getGrade());
        }
    }

    public static void com(Student s1, Student s2){

    }

    public static void main(String[] args) {
        LinkedList<Student> ss = new LinkedList<>();
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        for(int i = 0; i < num; i++){
            String name = in.next();
            String id = in.next();
            String grade = in.next();
            Student s1 = new Student(name, id, grade);
            ss.add(s1);
        }
        Collections.sort(ss, new Cm());
        System.out.println(ss.getFirst().getName() + " " + ss.getFirst().getId());
        System.out.println(ss.getLast().getName() + " " + ss.getLast().getId());
    }
}