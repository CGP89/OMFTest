/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject2;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Calendar;
import java.util.Properties;

/**
 *
 * @author ClideP
 */
public class Utility
{
    

    public static String getProperty(String property) throws IOException {
        FileReader reader = getFile("config.properties");
        Properties p = new Properties();
        p.load(reader);
        return p.getProperty(property);
    }

    public static String getProperty(String file, String property) throws IOException {
    FileReader reader = getFile(file);
    Properties p = new Properties();
            p.load(reader);
            return p.getProperty(property);
    }

    private static FileReader getFile(String fileName) throws FileNotFoundException {
        return new FileReader(fileName);
    }

    public String getTime(){

        return String.valueOf(Calendar.getInstance().getTime());
    }

    public void sleep() throws InterruptedException{
        Thread.sleep(500);
    }
}
