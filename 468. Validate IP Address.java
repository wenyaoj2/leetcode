class Solution {
    public String validIPAddress(String IP) {
        if(IP.length() == 0) {
            return "Neither";
        }
        if(!Character.isDigit(IP.charAt(0)) && !Character.isAlphabetic(IP.charAt(0))) {
            return "Neither";
        }
        if(!Character.isDigit(IP.charAt(IP.length() - 1)) && !Character.isAlphabetic(IP.charAt(IP.length() - 1))) {
            return "Neither";
        }
        String[] IPv4 = IP.split("\\.");
        String[] IPv6 = IP.split(":");
        if(IPv4.length == 4) {
            for(String s : IPv4) {
                int cur = 0;
                if(s.length() == 0) {
                    return "Neither";
                }
                if(s.charAt(0) == '0' && s.length() > 1) {
                    return "Neither";
                }
                for(int i = 0; i < s.length(); i++) {
                    if(!Character.isDigit(s.charAt(i))) {
                        return "Neither";
                    }
                    cur = cur * 10 + s.charAt(i) - '0';
                     if(cur > 255) {
                        return "Neither";
                    }
                }               
            }
            return "IPv4";
        }
        else if(IPv6.length == 8) {
            for(String s : IPv6) {
                if(s.length() == 0 || s.length() > 4) {
                    return "Neither";
                }
                for(char c : s.toCharArray()) {
                    if(Character.isDigit(c) || (c <= 'F' && c >= 'A') || (c <= 'f' && c >= 'a')) {
                        continue;
                    }
                    return "Neither";
                }
            }
            return "IPv6";
        }
        return "Neither";
    }
}