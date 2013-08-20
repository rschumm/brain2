package com.axa.ch.brokernet.util;

import java.io.Serializable;

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

    public String getVersionNr() {
        System.out.println("blubb 1");
        
        String display = System.getProperty("broker.displayVersion");
        if (display.equals("true")) {
            return getSystemInfo();
        }
        String leer = "";
        return leer;
    }

}
