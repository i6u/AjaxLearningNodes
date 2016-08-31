package com.util;

import java.io.*;

/**
 * Created by zhouweitao on 16/8/29.
 * <p>
 * File和String相互转换
 */
public class Conversion {
    public static String fileToString(String filePath, String encoding, int bufferSize) {
        InputStreamReader reader = null;
        StringWriter writer = new StringWriter();
        File file = new File(filePath);

        try {
            if (encoding != null && "".equals(encoding.trim())) {
                reader = new InputStreamReader(new FileInputStream(file), encoding);
            } else {
                reader = new InputStreamReader(new FileInputStream(file));
            }
            char[] buffer = bufferSize != 0 ? new char[bufferSize] : new char[512];
            int n = 0;
            while ((n = reader.read(buffer)) != -1) {
                writer.write(buffer, 0, n);
            }
            writer.flush();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            closeAll(reader, writer);
        }
        return writer != null ? writer.toString() : null;
    }

    public static boolean StringToFile(String str, String strPath, int bufferSize) {
        BufferedReader reader = null;
        BufferedWriter writer = null;
        try {
            File file = new File(strPath);
            if (!file.getParentFile().exists()) file.getParentFile().mkdirs();
            reader = new BufferedReader(new StringReader(str));
            writer = new BufferedWriter(new FileWriter(file));
            char[] buffer = bufferSize != 0 ? new char[bufferSize] : new char[512];
            int n;
            while ((n = reader.read(buffer)) != -1) {
                writer.write(buffer, 0, n);
            }
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        } finally {
            closeAll(reader, writer);
        }
        return true;
    }

    private static void closeAll(Reader reader, Writer writer) {
        try {
            if (reader != null) reader.close();
            if (writer != null) writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
