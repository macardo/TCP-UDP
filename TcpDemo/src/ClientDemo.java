import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class ClientDemo {
    public static void main(String[] args) throws IOException {
        //1.创建客户端socket服务 指定目标地址以及端口
        Socket s = new Socket("192.168.200.7",10001);

        //2.通过socket对象向服务器写入数据
        OutputStream out = s.getOutputStream();
        out.write("Hello,服务器.".getBytes());

        //3.通过socket对象获取服务器返回的数据
        InputStream in = s.getInputStream();
        byte[] buf = new byte[1024];
        int len = in.read(buf);
        String str = new String(buf,0,len);
        System.out.println("server:" + str);

        //4.关闭资源
        s.close();
    }
}
