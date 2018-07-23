package cn.hlxd;

import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Hello world!
 *
 */

public class App 
{
    public static void main1( String[] args ) throws Exception {
        System.out.println( "Hello World!" );


        String Auket =  Sign.appSign(1256333064,"AKIDVr1BB1G0jGbliUKRcfaLvJ6h7MPGgTs7",
                "BE6mGag2Wr1zmRwFMH0XxCUcgfS3RjbS",null,72000);

        System.out.println(Auket);
    }
}
