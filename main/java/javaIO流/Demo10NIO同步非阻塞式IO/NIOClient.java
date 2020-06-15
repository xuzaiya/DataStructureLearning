package javaIO流.Demo10NIO同步非阻塞式IO;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

/**
 * @Auther: xuzaiya
 * @Date: 2020/6/12 10:34
 * @Description: # 类的描述
 */
public class NIOClient {
    private static SocketChannel socketChannel=null;
    private static int bufferSize=4096;
    private static ByteBuffer readBuffer=ByteBuffer.allocate(bufferSize);
    private static Selector selector;
    private static int port=8899;
    public static void main(String[] args) throws IOException {
        socketChannel=SocketChannel.open();
        selector= Selector.open();
        socketChannel.configureBlocking(false);
        socketChannel.register(selector, SelectionKey.OP_CONNECT);
        socketChannel.connect(new InetSocketAddress(port));
        connect();
    }

    private static void connect() throws IOException {

        while (true) {
            // 选择一组可以进行I/O操作的事件，放在selector中,客户端的该方法不会阻塞，
            //这里和服务端的方法不一样，查看api注释可以知道，当至少一个通道被选中时，
            //selector的wakeup方法被调用，方法返回，而对于客户端来说，通道一直是被选中的
            selector.select();
            // 获得selector中选中的项的迭代器
            Iterator<SelectionKey> ite = selector.selectedKeys().iterator();
            while (ite.hasNext()) {
                SelectionKey selectionKey = ite.next();
                ite.remove();
                //如果是连接事件
                if(selectionKey.isConnectable()) {
                    SocketChannel channel = (SocketChannel) selectionKey.channel();
                    //如果正在连接 等待完成连接
                    if(channel.isConnectionPending()) {
                        channel.finishConnect();
                    }
                    channel.write(ByteBuffer.wrap(new String("hello server").getBytes()));
                    //在和服务端连接成功之后，为了可以接收到服务端的信息，需要给通道设置读的权限。
                    channel.register(selector, SelectionKey.OP_READ);
                }
                if(selectionKey.isReadable()) {
                    SocketChannel channel = (SocketChannel) selectionKey.channel();
                    int readCount=channel.read(readBuffer);
                    String readText=new String(readBuffer.array(),0,readCount);
                    System.out.println("讀取的數據為："+readText);
                    readBuffer.clear();
                }
            }
        }
    }




}
