package com.study;

import java.io.*;
import java.nio.charset.Charset;


/**
 * Created by Brian in 16:53 2018/4/2
 */
public class FileEncodeConvert {

    public static void main(String[] args) {
        convertEncoding(new File("E:\\Projects\\sprboot-demo\\src\\main\\java\\com\\webService\\client\\Say.java"), "utf-8");
    }

    public static void convertEncoding(File file, String encoding) {
        InputStreamReader reader = null;
        BufferedReader bfReader = null;
        OutputStreamWriter writer = null;
        BufferedWriter bfWriter = null;
        if (file.exists()) {
            try {
                reader = new InputStreamReader(new FileInputStream(file));
                bfReader = new BufferedReader(reader);

                writer = new OutputStreamWriter(new FileOutputStream("E:/tmp/" + file.getName()), Charset.forName(encoding));
                bfWriter = new BufferedWriter(writer);
                String str = null;
                while ((str = bfReader.readLine()) != null) {
                    bfWriter.write(str);
                }


            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (bfReader != null) {
                    try {
                        bfReader.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if (bfWriter != null) {
                    try {
                        bfWriter.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
