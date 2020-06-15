package javaIO流.Demo11AIO异步非阻塞式IO;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;

/**
 * @Auther: xuzaiya
 * @Date: 2020/6/12 10:39
 * @Description: # 类的描述
 */
public class AIOServer {

    private static AsynchronousServerSocketChannel serverSocketChannel=null;
    private static int bufferSize=4096;
    private static ByteBuffer readBuffer= ByteBuffer.allocate(bufferSize);
    private static ByteBuffer writeBuffer=ByteBuffer.allocate(bufferSize);

    public static void main(String[] args) throws IOException {
        serverSocketChannel=AsynchronousServerSocketChannel.open().bind(new InetSocketAddress(8899));
        serverSocketChannel.accept(null, new CompletionHandler<AsynchronousSocketChannel, Object>(){

            @Override
            public void completed(AsynchronousSocketChannel channel, Object attachment) {
                try {

                    //读的异步
                    channel.read(readBuffer, null, new CompletionHandler<Integer, Object>() {

                        @Override
                        public void completed(Integer result, Object attachment) {
                            String readText=new String(readBuffer.array(),0,result);
                            System.out.println("讀取的數據為："+readText);
                            readBuffer.clear();
                        }

                        @Override
                        public void failed(Throwable exc, Object attachment) {
                            exc.printStackTrace();
                            System.out.println("读取失败");
                        }

                    });
                    writeBuffer.put("hello client".getBytes());
                    writeBuffer.flip();
                    //写入测试数据
                    channel.write(writeBuffer);
                    serverSocketChannel.accept(null, this);// 监听新的请求，递归调用。
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void failed(Throwable exc, Object attachment) {
                System.out.println("出现异常："+exc);
                serverSocketChannel.accept(null, this);// 监听新的请求，递归调用。
            }

        });


        System.in.read();
    }


}
