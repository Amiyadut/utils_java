/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils_java;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 *
 * @author amiya
 */
public class FileUtils {

    public static String readfile(String filename) {
        String data = "";

        File clsfl = new File(filename);

        if (clsfl.exists()) {
            try {
                FileReader fr = new FileReader(filename);

                BufferedReader br = new BufferedReader(fr);
                String s;

                while ((s = br.readLine()) != null) {
                    data = s.trim();

                    break;
                }

                fr.close();
            } catch (Exception ex) {
                System.out.println("err " + ex);
            }
        } else {
            System.out.println("No file exist ");
        }

        return data;
    }

    public static String readfilefully(String filename) {
        String data = "";
        java.io.DataInputStream input;
        File clsfl = new File(filename);

        if (clsfl.exists()) {
            try {
                // String s = "";
                input = new java.io.DataInputStream(new FileInputStream(clsfl));

                byte[] byt = new byte[(int) clsfl.length()];
                input.readFully(byt);
                data = new String(byt, 0, byt.length);
                input.close();
            } catch (Exception ex) {
                System.out.println("err " + ex);
            }
        } else {
            System.out.println("No file exist");
        }

        return data;
    }

    public static String getTextContent(String filename, String encoding) {
        String data = "";
        java.io.DataInputStream input;
        File clsfl = new File(filename);

        if (clsfl.exists()) {
            try {
                // String s = "";
                input = new java.io.DataInputStream(new FileInputStream(clsfl));

                byte[] byt = new byte[(int) clsfl.length()];
                input.readFully(byt);
                data = new String(byt, 0, byt.length, Charset.forName(encoding));//"ISO-8859-1"
                input.close();

            } catch (Exception ex) {
                System.out.println("err " + ex);

            }
        } else {
            System.out.println("No file exist");

        }

        return data;

    }

    public static void WriteTextFile(String seq_, String txtfile, boolean append) {
        try {

            File fl = new File(txtfile);
            if (append == false) {
                if (fl.exists()) {
                    fl.delete();
                }
            }
            if (!fl.exists()) {
                FileWriter fwr = new FileWriter(txtfile);
                fwr.close();
            }

            RandomAccessFile rf;
            rf = new RandomAccessFile(txtfile, "rw");

            rf.seek(rf.length());
            rf.writeBytes(seq_);

            rf.close();
        } catch (Exception ex) {
            //
        }
    }

    public static byte[] readFileBytes(File file) {

        byte[] bytes = null;
        try {
            InputStream is = new FileInputStream(file);

            long length = file.length();

            if (length > Integer.MAX_VALUE) {
                System.out.println("File is too large.");
            }

            // Create the byte array to hold the data
            bytes = new byte[(int) length];

            // Read in the bytes
            int offset = 0;
            int numRead = 0;
            while (offset < bytes.length && (numRead = is.read(bytes, offset, bytes.length - offset)) >= 0) {
                offset += numRead;
            }

            // Ensure all the bytes have been read in
            if (offset < bytes.length) {
                System.out.println("Could not completely read file " + file.getName());
            }

            // Close the input stream and return bytes
            is.close();
        } catch (Exception ex) {
            System.out.println("" + ex);
        }

        return bytes;
    }

}
