import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerDemo {
    public static void main(String[] args) throws IOException {
        //1.创建server socket服务器对象 监听具体的端口
        ServerSocket ss= new ServerSocket(10001);

        //2.获取具体的连接客户端对象
        Socket s = ss.accept();
        String ip = s.getInetAddress().getHostAddress();
        System.out.println(ip + " connected");

        //3.通过客户端对象获取读取流对象 读取客户端发送的消息
        InputStream in = s.getInputStream();
        byte[] buff = new byte[1024];
        int len = in.read(buff);
        String str = new String(buff,0,len);
        System.out.println("Client:" + str);

        //4.获取socket对象将数据返回客户端
        OutputStream out = s.getOutputStream();
        out.write("已收到！".getBytes());

        //5.关闭流对象
        s.close();
        ss.close();
    }
}
