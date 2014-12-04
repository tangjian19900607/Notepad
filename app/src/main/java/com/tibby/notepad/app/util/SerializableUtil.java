package com.tibby.notepad.app.util;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Author:tibby tang
 * Created on 4/12/14.
 * Email:tangjian19900607@gmail.com
 * QQ:562980080
 */
public class SerializableUtil {
    public static void serializObject(Object obj, String path) {
        File file = new File(path);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        ObjectOutputStream objectOutputStream = null;
        try {
            OutputStream outputStream = new FileOutputStream(file, true);
            if (file.length() < 1) {
                objectOutputStream = new ObjectOutputStream(outputStream);
            } else {
                objectOutputStream = new MyObjectOutputStream(outputStream);
            }
            objectOutputStream.writeObject(obj);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                objectOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static Object unserializObject(String path) {
        InputStream inputStream = null;
        Object obj = null;
        File file = new File(path);
        try {
            inputStream = new FileInputStream(file);
            ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
            obj = objectInputStream.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return obj;
    }

    public static <T> void serializList(List<T> collections, String path) {
        File file = new File(path);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        ObjectOutputStream objectOutputStream = null;
        try {
            OutputStream outputStream = new FileOutputStream(file, true);
            objectOutputStream = new ObjectOutputStream(outputStream);
            if (file.length() < 1) {
                objectOutputStream = new ObjectOutputStream(outputStream);
            } else {
                objectOutputStream = new MyObjectOutputStream(outputStream);
            }
            for (T collection : collections) {
                objectOutputStream.writeObject(collection);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                objectOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    public static <T> List<T> unserializList(String path) {
        File file = new File(path);
        List<T> collections = new ArrayList<T>();
        ObjectInputStream objectInputStream = null;
        try {
            InputStream inputStream = new FileInputStream(file);
            objectInputStream = new ObjectInputStream(inputStream);
            while (true) {
                try {
                    T t = (T) objectInputStream.readObject();
                    collections.add(t);
                } catch (EOFException e) {
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                objectInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return collections;
    }
}
