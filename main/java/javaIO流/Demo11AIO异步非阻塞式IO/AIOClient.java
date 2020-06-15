package javaIO流.Demo11AIO异步非阻塞式IO;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.nio.channels.Selector;

/**
 * @Auther: xuzaiya
 * @Date: 2020/6/12 10:40
 * @Description: # 类的描述
 */
public class AIOClient {
    private static AsynchronousSocketChannel socketChannel=null;
    private static int bufferSize=4096;
    private static ByteBuffer readBuffer=ByteBuffer.allocate(bufferSize);
    private static ByteBuffer writeBuffer=ByteBuffer.allocate(bufferSize);
    private static Selector selector;
    private static int port=8899;
    public static void main(String[] args) throws Exception {
        socketChannel=AsynchronousSocketChannel.open();
        //这里一定要指定ip 就算是本机  也要使用localhost
        socketChannel.connect(new InetSocketAddress("localhost",port),null,new CompletionHandler<Void, Object>() {

            @Override
            public void completed(Void result, Object attachment) {
                try {
                    //读的异步
                    socketChannel.read(readBuffer, null, new CompletionHandler<Integer, Object>() {

                        @Override
                        public void completed(Integer result, Object attachment) {
                            String readText=new String(readBuffer.array(),0,result);
                            System.out.println("讀取的數據為："+readText);
                        }

                        @Override
                        public void failed(Throwable exc, Object attachment) {
                            exc.printStackTrace();
                            System.out.println("读取失败");
                        }

                    });
                    //写入数据到服务端
                    writeBuffer.put("hello server".getBytes());
                    writeBuffer.flip();
                    //写入测试数据
                    socketChannel.write(writeBuffer);

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void failed(Throwable exc, Object attachment) {
                // TODO Auto-generated method stub

            }
        });


        System.in.read();

    }

}
