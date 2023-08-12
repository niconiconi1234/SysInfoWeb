package org.huajuan.sysinfoweb.controller;

import org.apache.commons.lang3.SystemUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;

@RestController
public class SysInfoController {

    @Value("${sys-info-web.version}")
    private String version;

    @GetMapping("/sysInfo")
    public Object sysInfo() {
        String hostname;
        try {
            hostname = InetAddress.getLocalHost().getHostName();
        } catch (UnknownHostException e) {
            hostname = "unknown";
        }
        int cpuCores = Runtime.getRuntime().availableProcessors();
        String osName = System.getProperty("os.name");
        String osVersion = System.getProperty("os.version");
        String javaVersion = System.getProperty("java.version");
        String userHomeDirectory = SystemUtils.USER_HOME;
        String userWorkingDirectory = SystemUtils.USER_DIR;
        String javaHomeDirectory = SystemUtils.JAVA_HOME;
        String javaVendor = SystemUtils.JAVA_VENDOR;

        Map<String, String> res = new HashMap<>();
        res.put("hostname", hostname);
        res.put("cpuCores", String.valueOf(cpuCores));
        res.put("osName", osName);
        res.put("osVersion", osVersion);
        res.put("javaVersion", javaVersion);
        res.put("userHomeDirectory", userHomeDirectory);
        res.put("userWorkingDirectory", userWorkingDirectory);
        res.put("javaHomeDirectory", javaHomeDirectory);
        res.put("javaVendor", javaVendor);
        
        return res;
    }

    @GetMapping("/version")
    public String version() {
        return version;
    }
}
