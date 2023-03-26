package com.trainings.algorithms.arrays;

import java.util.LinkedList;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/restore-ip-addresses/">...</a>
 */
public class RestoreIPAddresses {
    //25525511135
    public List<String> restoreIpAddresses(String s) {
        List<String> ipAdresses = new LinkedList<>();

        //Get all possible ips in S that are valid
        String ipPart1, ipPart2, ipPart3, ipPart4;
        for (int i = 1; i < 4 && i < s.length(); i++) {
            ipPart1 = s.substring(0, i);
            if(isValid(ipPart1)) {
                for (int j = i+1; j < i + 4 && j < s.length(); j++) {
                    ipPart2 = s.substring(i, j);
                    if(isValid(ipPart2)) {
                        for (int k = j + 1; k < j + 4 && k < s.length(); k++) {
                            ipPart3 = s.substring(j, k);
                            if(isValid(ipPart3)) {
                                ipPart4 = s.substring(k);
                                if(isValid(ipPart4)) {
                                    ipAdresses.add(ipPart1 + "." + ipPart2 + "." + ipPart3 + "." + ipPart4);
                                }
                            }
                        }
                    }
                }
            }
        }

        return ipAdresses;
    }

    private boolean isValid(String ipPart) {
        boolean valid = ipPart.length() <= 3 && Integer.parseInt(ipPart) <= 255;
        if(valid && ipPart.length() > 1 && (ipPart.startsWith("0") || ipPart.startsWith("00"))) {
            valid = false;
        }
        return valid;
    }
}
