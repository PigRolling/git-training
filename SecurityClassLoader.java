package com.crx.sample;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public class SecurityClassLoader extends ClassLoader {
    private String rootDir;

    /**
     * @param name String
     * @return Class<?>
     */
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        byte[] clazzData = this.getData(name);
        if (clazzData == null) {
            throw new ClassNotFoundException();
        }
        else {
            return this.defineClass(name, clazzData, 0, clazzData.length);
        }
    }


    /**
     * @param clazzName String
     * @return byte[]
     */
    public byte[] getData(String clazzName) {
        String filePath = this.getPath(clazzName);
        InputStream input = null;
        ByteArrayOutputStream byteOutput = null;
        try {
            input = new FileInputStream(filePath);
            byteOutput = new ByteArrayOutputStream();
            int bufferSize = 1024;
            byte[] buffer = new byte[bufferSize];
            while (true) {
                int len = input.read(buffer);
                if (len == -1) {
                    break;
                }
                byteOutput.write(buffer, 0, len);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return byteOutput.toByteArray();

    }

    /**
     * 设置类加载路径
     * @param clazzName String
     * @return String
     */
    public String getPath(String clazzName) {
        return this.rootDir + File.separator + clazzName.replace('.', File.separatorChar) + ".class";
    }

    /**
     * @return String
     */
    public String getRootDir() {
        return rootDir;
    }

    /**
     * 设置加载类路
     * @param rootDir String
     */
    public void setRootDir(String rootDir) {
        this.rootDir = rootDir;
    }
}
