import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author yuanjiaping
 * @create 2018-10-18 16:42
 * @description 服务端
 **/
public class ServerDemo {
    public static void main(String[] args) {
        ServerDemo server = new ServerDemo();
        try {
            // 启动服务器
            server.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void start() throws IOException {
        //先创建serversocket实例，并确定端口号
        ServerSocket ss = new ServerSocket(8000);
        while(true){
            System.out.println("等待客户端的登录。。。");
            //等待客户端登录，若客户登录，进来；不登录，一直等待
            Socket s = ss.accept();
            //如果登录进来，服务器会创建一个线程来针对客户端的访问
            System.out.println("一个客户登录进来: " + s.getInetAddress());
            // 启动一个线程来处理请求
            new Service(s).start();
        }
    }

    // 成员内部类，为客户socket创建一个服务线程，提供run方法
    class  Service extends Thread{
        Socket s;

        public Service(Socket s){
            this.s = s;
        }

        public void run(){

            try {
                // in:客户端传递给服务器的信息
                InputStream in = s.getInputStream();
                // out:服务器传递给客户端的信息
                OutputStream out = s.getOutputStream();
                // 在服务器端跟客户端收一句话
                out.write("Hello\n".getBytes());
                out.flush();

                Scanner sc = new Scanner(in);
                while(true){
                    String str = sc.nextLine().trim();
                    if("hi".equals(str)){
                        out.write("请问你叫?\n".getBytes());
                        out.flush();
                    }else if("你好，本人有事不在\n".equals(str)){
                        out.write("再见".getBytes());
                        out.flush();
                        break;
                    }else{
                        out.write("你好\n".getBytes());
                        out.flush();
                        s.close();
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
