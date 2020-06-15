package javaIO流.Demo9BIO同步阻塞IO流;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Auther: xuzaiya
 * @Date: 2020/6/12 09:59
 * @Description: # 同步阻塞BIO，使用byte[]数组缓冲数据
 */

/*
* 服务端
* */
public class BIOServer {
    private static ServerSocket serverSocket = null;
    private static int bufferSize = 4096;
    private static byte[] readBuffer = new byte[bufferSize];

    public static void main(String[] args) throws IOException {
        serverSocket = new ServerSocket(8899);
        //这里表示同步，必须等待接收一个socket才能执行后面的代码
        while(true){
            //获取一个客户端的连接
            Socket accept = serverSocket.accept();
            //必须为一个客户端建立一个线程处理
            DThread th = new DThread(accept);
            th.start();
        }
    }


    public static class DThread extends  Thread {
        Socket accept;
        public DThread(Socket accept){
            this.accept = accept;
        }
        public void run(){
            try{
                InputStream inputStream = this.accept.getInputStream();
                OutputStream outputStream = this.accept.getOutputStream();
                int readCount = inputStream.read(readBuffer);
                String readText = new String(readBuffer,0,readCount);
                System.out.println("读取到的数据为："+readText);
                outputStream.write("hello Client".getBytes());
                outputStream.flush();
                accept.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

}
