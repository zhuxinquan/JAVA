package Chapter12;

import java.io.*;
import java.util.function.BiFunction;
import java.util.function.LongBinaryOperator;

/**
 * Created by zhuxinquan on 15-12-15.
 */
public class Ex12_16 {
    public static void main(String[] args) throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        DataOutputStream out = new DataOutputStream(new BufferedOutputStream(new FileOutputStream("Employee.dat", true)));
        int id;
        String idNO, name, post, salaryStr;
        long salary;
        while(true){
            System.out.print("id = ");
            idNO = in.readLine();
            if(idNO.length() == 0){
                break;
            }
            try{
                id = Integer.parseInt(idNO);
            }catch(NumberFormatException e){
                continue;
            }

            while(true){
                System.out.print("name = ");
                name = in.readLine();
                if(name.length() != 0){
                    break;
                }
            }
            while(true){
                System.out.print("post = ");
                post = in.readLine();
                if(post.length() != 0){
                    break;
                }
            }
            while(true){
                System.out.print("salary =");
                salaryStr = in.readLine();
                if(name.length() != 0){
                    try{
                        salary = Long.parseLong(salaryStr);
                    }catch (NumberFormatException e){
                        continue;
                    }
                    break;
                }
            }
            out.writeInt(id);
            out.writeUTF(name);
            out.writeUTF(post);
            out.writeLong(salary);
        }
        out.close();
        in.close();
    }
}
