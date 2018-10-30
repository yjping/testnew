import com.sun.org.apache.regexp.internal.RE;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author yuanjiaping
 * @create 2018-10-18 17:03
 * @description 客户端
 **/
public class ClientDemo {
    public static void main(String[] args) {
        ClientDemo client = new ClientDemo();
        client.login();
    }

    public void login(){
        try {
            // 通过localhost找到服务器端，通过端口号8000找到那个程序
            Socket s = new Socket("localhost", 8000);
            // in：服务器端传给客户端信息
            InputStream in = s.getInputStream();
            OutputStream out = s.getOutputStream();
            new Reader(out).start();
            new Writer(in).start();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // reader负责读取控制台输入的信息，传递给服务器端
    class Reader extends Thread{
        OutputStream out;
        public Reader(OutputStream out){
            this.out = out;
            setDaemon(true);
        }

        public void run(){
            Scanner sc = new Scanner(System.in);
            while(true){
                String str = sc.nextLine().trim();
                try {
                    out.write(str.getBytes());
                    // 以回车符判断是否接收一行
                    out.write('\n');
                    out.flush();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    // writer负责将服务器端传递过来的信息显示到控制台
    class Writer extends Thread{
        InputStream in;

        public Writer(InputStream in){
            this.in = in;
        }

        public void run(){
            try {
                int b;
                while((b = in.read()) != -1){
                    System.out.write(b);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
