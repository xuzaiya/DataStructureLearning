package javaIO流.Demo9BIO同步阻塞IO流;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @Auther: xuzaiya
 * @Date: 2020/6/12 10:10
 * @Description: # BIO的客戶端
 */
public class BIOClient {
    private static int port = 8899;
    private static int bufferSize = 4096;
    private static byte[] readBuffer = new byte[bufferSize];

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost",port);
        OutputStream outputStream = socket.getOutputStream();
        InputStream inputStream = socket.getInputStream();
        outputStream.write("hello server".getBytes());
        outputStream.flush();
        int readCount = inputStream.read(readBuffer);
        String readText=new String(readBuffer,0,readCount);
        System.out.println("读取到的数据为："+readText);

    }
}
