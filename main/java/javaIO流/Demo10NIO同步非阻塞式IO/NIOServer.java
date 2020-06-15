package javaIO流.Demo10NIO同步非阻塞式IO;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * @Auther: xuzaiya
 * @Date: 2020/6/12 10:16
 * @Description: # 类的描述
 */
public class NIOServer {
    private static ServerSocketChannel serverSocketChannel = null;
    private static int bufferSize = 4096;
    private static ByteBuffer readBuffer = ByteBuffer.allocate(bufferSize);
    private static ByteBuffer writeBuffer = ByteBuffer.allocate(bufferSize);
    private static Selector selector;

    public static void main(String[] args) throws IOException {
        //打开通道
        serverSocketChannel = ServerSocketChannel.open();
        //设置为非阻塞
        serverSocketChannel.configureBlocking(false);
        serverSocketChannel.bind(new InetSocketAddress(8899));
        selector = Selector.open();
        //通道注册多路复用 selector中，selector监听事件，接收客户端请求事件
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        listen();

    }

    public static void listen() throws IOException {
        //存在注册事件返回，方法返回，否则一直阻塞，应该轮询
        while(true){
            selector.select();
            //select到了后面，说明存在事件，获取事件并轮询
            Set<SelectionKey> selectedKeys = selector.selectedKeys();
            Iterator<SelectionKey> iterator = selectedKeys.iterator();
            while(iterator.hasNext()){
                SelectionKey selectionKey = iterator.next();
                iterator.remove();

                //客户端连接事件
                if (selectionKey.isAcceptable()){
                    ServerSocketChannel server = (ServerSocketChannel) selectionKey.channel();
                    //获取和客户端连接的通道
                    SocketChannel channel = server.accept();
                    //这里要配置一下 否则报错
                    channel.configureBlocking(false);
                    //给接入的客户端注册读的事件
                    channel.register(selector, SelectionKey.OP_READ);
                    writeBuffer.put("hello client".getBytes());
                    writeBuffer.flip();
                    //写入测试数据
                    channel.write(writeBuffer);
                }

                //缓冲区有数据可以读
                if(selectionKey.isReadable()){
                    SocketChannel channel = (SocketChannel) selectionKey.channel();
                    int readCount=channel.read(readBuffer);
                    String readText=new String(readBuffer.array(),0,readCount);
                    System.out.println("读取的数据为："+readText);
                    readBuffer.clear();
                }


            }
        }
    }

}
