import java.io.*;
import java.util.Scanner;
import java.io.FileOutputStream;  
class Packgen {
    public static void main (String args[]){
        Scanner sc = new Scanner(System.in); 
        System.out.print("Enter Package Name: ");
        String name=sc.nextLine();
        System.out.print("Version (1.0.0): ");
        String v=sc.nextLine();
        System.out.print("Package Description: ");
        String d=sc.nextLine();
        System.out.print("Main (test.js): ");
        String main=sc.nextLine();
        System.out.print("Keywords: ");
        String key=sc.nextLine();
        String[] keys = key.split(",");
        String keywords="";
        for(int i=0;i<keys.length;i++){
            keywords+= "\""+keys[i]+"\",";
        }
        StringBuffer sb= new StringBuffer(keywords);    
        sb.deleteCharAt(sb.length()-1);  
        System.out.print("Author: ");
        String author=sc.nextLine();
        System.out.print("License (MIT): ");
        String l=sc.nextLine();
        System.out.print("Github Repository (ex. username/repository): ");
        String g=sc.nextLine();
        System.out.print("Home Page (https://github.com/"+g+"#readme): ");
        String h=sc.nextLine();
        String data="{      \n"+ 
        " \"name\": \""+name+"\",                                    \n"+
        " \"version\": \""+(v.isEmpty()?"1.0.0":v)+"\",                                                    \n"+
        " \"description\": \""+d+"\",                             \n"+
        " \"main\": \""+(main.isEmpty()?"test.js":main)+"\",                                                \n"+
        " \"scripts\": {                                                             \n"+
        "   \"test\": \"echo \\\"Error: no test specified\\\" && exit 1\"              \n"+
        " },                                                                         \n"+
        " \"keywords\": [                                                            \n"+
        "  "+sb+"                                                                 \n"+
        " ],                                                                         \n"+
        " \"author\": \""+author+"\",                                             \n"+
        " \"license\": \""+(l.isEmpty()?"MIT":l)+"\",                                                      \n"+
        " \"repository\": {                                                         \n "+
        "   \"type\": \"git\",                                                     \n  "+
        "   \"url\": \"git+https://github.com/"+g+".git\"          \n"+
        " },                                                                         \n"+
        " \"bugs\": {                                                               \n "+
        "   \"url\": \"https://github.com/"+g+"/issues\"           \n"+
        " },                                                                        \n "+
        " \"homepage\": \""+(h.isEmpty()?"https://github.com/"+g+"#readme":h)+"\",      \n "+
        " \"_publishConfig\": { \"registry\": \"https://npm.pkg.github.com/\" }    \n  "+
        " }";

        System.out.println(data);

try  
{       
    FileOutputStream fos=new FileOutputStream("package.json", true);  
    byte[] b= data.getBytes();    
    fos.write(b);           
    fos.close();           
    System.out.println("\nPackage.json has been saved!");  
}  
    catch(Exception e)  
{  
    e.printStackTrace();          
}  
    }
}