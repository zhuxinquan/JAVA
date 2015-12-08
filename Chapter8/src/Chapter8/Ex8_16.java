package Chapter8;

import com.sun.org.apache.xerces.internal.impl.xs.SchemaSymbols;

/**
 * Created by zhuxinquan on 15-12-8.
 */

class StudentException extends Exception{
    public String toString(){
        return "StudentException: 学生问题！";
    }
}

class TeacherException extends Exception{
    public String toString(){
        return "TeacherException: 教师问题！";
    }
}

class TeachingException extends Exception{
    public String toString(){
        return "TeachingException: 教学计划问题！";
    }
}

class FacilityException extends Exception{
    public String toString(){
        return "FacilityException: 教学设施问题！";
    }
}

class Student{
    void goToClass(int n)throws TeachingException, FacilityException{
        try{
            if(n == 2){
                System.out.println("第二种情况：教师异常");
                throw new TeacherException();
            }if(n == 3){
                System.out.println("第三种情况：教学计划异常");
                throw new TeachingException();
            }if(n == 4){
                System.out.println("第四种情况：教学设施异常");
                throw new FacilityException();
            }
            System.out.println("第一种情况：没有发生异常");
        }catch (TeacherException e){
            System.out.println("异常被捕捉处理");
        }catch  (FacilityException e){
            System.out.println("异常被捕捉， 但又被重新引发");
            throw e;
        }finally {
            System.out.println("this is finally");
        }
        System.out.println("this in try after code");
    }
}

public class Ex8_16 {
    public static void main(String[] args) {
        Student obj = new Student();
        for(int i = 1; i < 5; i++){
            try{
                obj.goToClass(i);
            }catch(Exception e){
                System.out.println("main catch Exception");
            }
        }
    }
}
