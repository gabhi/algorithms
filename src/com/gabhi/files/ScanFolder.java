/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gabhi.files;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author Abhijit Gaikwad <gaikwad.abhijit@gmail.com>
 */
public class ScanFolder {

    public static void main(String[] args) {
        Collection<File> all = new ArrayList<File>();
        addTree(new File("."), all);
        // System.out.println(all);
    }

    static void addTree(File file, Collection<File> all) {
        File[] children = file.listFiles();
        if (children != null) {
            for (File child : children) {
                System.out.println(child + "::" + countLines(child.getAbsolutePath()));

                all.add(child);
                addTree(child, all);
            }
        }
    }

    public static int countLines(String filename) {
        InputStream is = null;
        try {
            is = new BufferedInputStream(new FileInputStream(filename));

            byte[] c = new byte[1024];
            int count = 0;
            int readChars = 0;
            while ((readChars = is.read(c)) != -1) {
                for (int i = 0; i < readChars; ++i) {
                    if (c[i] == '\n') {
                        ++count;
                    }
                }
            }
            return count;
        } catch (Exception e) {
            return 0;
        } finally {
            try {
                is.close();
            } catch (Exception e) {
            }
        }
    }
}
