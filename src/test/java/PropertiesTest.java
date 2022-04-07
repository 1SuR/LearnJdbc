import org.junit.Test;

import java.io.*;
import java.util.Properties;

public class PropertiesTest {
    @Test
    public void test1(){
        Properties properties=System.getProperties();
        properties.list(System.out);
    }
    @Test
    //打印自义的properties
    public void test2(){
        Properties properties=new Properties();
        try {
            InputStream inputStream=new BufferedInputStream(new FileInputStream("C:\\Users\\SR\\Desktop\\project\\LearnJdbc\\src\\main\\resources\\demo.properties"));
            properties.load(inputStream);
            properties.list(System.out);
            System.out.println(properties.getProperty("name"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void test3(){
        Properties properties=new Properties();
        try {
            //直接写src下的路径
            InputStream inputStream=PropertiesTest.class.getResourceAsStream("demo.properties");
            properties.load(inputStream);
            properties.list(System.out);

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
