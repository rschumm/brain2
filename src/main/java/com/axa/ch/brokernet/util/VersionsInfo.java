package com.axa.ch.brokernet.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.util.Properties;

import javax.faces.bean.ApplicationScoped;
import javax.inject.Named;

@Named("versionsInfo")
@ApplicationScoped
public class VersionsInfo implements Serializable {

    public String getSystemInfo() {
        // cool waere auch, jboss.home.dir und jboss.host.name jboss.qualified.host.name
        // jboss.server.name os.name os.version anzuzeigen.

        return System.getProperty("os.name") + " " + System.getProperty("os.version") + " "
                + System.getProperty("jboss.server.name") + " " + System.getProperty("jboss.qualified.host.name") + " "
                + System.getProperty("jboss.home.dir");
        //return System.getProperty(build.property)
    }

    public String getVersionNr() throws IOException {
        System.out.println("blubb 1");
        
        Properties props = new Properties();
//        FileInputStream in = new FileInputStream("system.properties");
//        props.load(in);
//        in.close();
//        String str = props.getProperty("version");

        String display = System.getProperty("broker.displayVersion");
        if (display.equals("true")) {
            FileInputStream in = new FileInputStream("src/main/resources/build.properties");
            props.load(in);
            in.close();
            return props.getProperty("version");
        }
        String leer = "";
        return leer;
    }

}
