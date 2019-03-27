package com.thinkgem.jeesite.common.pattern.prototype;

import java.io.*;

/**
 * @Author duhongming
 * @Email 19919902414@189.cn
 * @Date 2018/6/19 10:00
 *
 * 抽象类:InputStream/OutputStream
 * 文件流类：FileInputStream/FileOutputStream
 * 字节数字流类：ByteArrayInputStream/ByteArrayOutputStream
 * 对象流类：ObjectInputStream/ObjectOutputStream
 * 管道流类：PipedInputStream/PipedOutputStream
 */
public class PrototypePattern implements Cloneable,Serializable {

    private static final long serialVersionUID = 1L;
    private String string;
    private SerializableObject obj;

    /* 浅复制 */
    public PrototypePattern clone() throws CloneNotSupportedException {
        return (PrototypePattern) super.clone();
    }

    /* 深复制 */
    public PrototypePattern deepClone(){
        PrototypePattern prototype = null;
        //使用try-resource的方式来自动关闭资源，没有必要再手动调用一次close
        /* 写入当前对象的二进制流 */
        try(
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream)
        ) {
            objectOutputStream.writeObject(this);
            /* 读出二进制流产生的新对象 */
            try(
                    ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
                    ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream)
            ){
                return (PrototypePattern) objectInputStream.readObject();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return prototype;
    }

    /* 文件复制 */
    public PrototypePattern fileClone(){
        PrototypePattern prototype = null;
        //使用try-resource的方式来自动关闭资源，没有必要再手动调用一次close
        try(
                FileOutputStream fileOutputStream = new FileOutputStream("PrototypePattern.dat");
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)
        ){
            objectOutputStream.writeObject(this);
            try(
                    FileInputStream fileInputStream = new FileInputStream("PrototypePattern.dat");
                    ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)
            ){
                prototype = (PrototypePattern)objectInputStream.readObject();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return prototype;
    }

    /**
     * 管道复制
     *
     * PipedInputStream，管道输入流应该连接到管道输出流；管道输入流提供要写入管道输出流的所有数据字节。
     * 通常，数据由某个线程从PipedInputStream 对象读取， 并由其他线程将其写入到相应的 PipedOutputStream。
     * 不建议对这两个对象尝试使用单个线程，因为这样可能死锁线程。管道输入流包含一个缓冲区，可在缓冲区限定的 范 围内将读操作和写操作分离开。
     * 如果向连接管道输出流提供数据字节的线程不再存在，则认为该管道已损坏。
     *
     * PipedOutputStream，可以将管道输出流连接到管道输入流来创建通信管道。管道输出流是管道的发送端。
     * 通常，数据由某个线程写入PipedOutputStream 对象，并由 其他线程从连接的PipedInputStream 读取。
     * 不建议对这两个对象尝试使用单个线程，因为这样可能会造成该线程死锁。
     * 如果某个线程正从连接的管道输入流中读取数据字节，但该线程不再处于活动状态，则该管道被视为处于毁坏状态。
     *
     * 通过官方API的两段解释，大概能摸到这种实现方式的设计思路了：PipedOutputStream(生产者)生产数据，PipedInputStream(消费者)读取数据，二者同步进行。
     * 但谁也不能先挂掉，一旦挂掉，管道便处于损坏状态。
     *
     * @return
     */
    public PrototypePattern pipeClone(){
        final PrototypePattern[] prototype = {null};
        try {

            PipedOutputStream pipedOutputStream = new PipedOutputStream();
            PipedInputStream pipedInputStream = new PipedInputStream();
            //将管道输出流连接到管道输入流来创建通信管道
            pipedOutputStream.connect(pipedInputStream);

            //创建生产者线程来为管道输出流写入数据.
            new Thread(() -> {
                try {
                    ObjectOutputStream objectOutputStream = new ObjectOutputStream(pipedOutputStream);
                    objectOutputStream.writeObject(this);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }).start();

            //创建消费者线程来从 PipedInputStream对象读取数据
            Thread consumer = new Thread(()->{
                try {
                    ObjectInputStream objectInputStream = new ObjectInputStream(pipedInputStream);
                    prototype[0] = (PrototypePattern)objectInputStream.readObject();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }

            });
            consumer.start();

            //勿必等所有数据读完才继续后面的操作,否则可能造成数据仍未读完便GameOver了.
            consumer.join();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return prototype[0];
    }

    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }

    public SerializableObject getObj() {
        return obj;
    }

    public void setObj(SerializableObject obj) {
        this.obj = obj;
    }

}

class SerializableObject implements Serializable {
    private static final long serialVersionUID = 1L;
}