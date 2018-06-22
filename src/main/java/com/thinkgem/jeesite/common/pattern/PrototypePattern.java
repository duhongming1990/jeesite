package com.thinkgem.jeesite.common.pattern;

import java.io.*;

/**
 * @Author duhongming
 * @Email 19919902414@189.cn
 * @Date 2018/6/19 10:00
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

    /* 管道复制 */
    public PrototypePattern pipeClone(){
        PrototypePattern prototype = null;
        try {
            PipedOutputStream pipedOutputStream = new PipedOutputStream();
            PipedInputStream pipedInputStream = new PipedInputStream();
            pipedOutputStream.connect(pipedInputStream);

            ObjectOutputStream objectOutputStream = new ObjectOutputStream(pipedOutputStream);
            objectOutputStream.writeObject(this);

            ObjectInputStream objectInputStream = new ObjectInputStream(pipedInputStream);
            prototype = (PrototypePattern)objectInputStream.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return prototype;
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