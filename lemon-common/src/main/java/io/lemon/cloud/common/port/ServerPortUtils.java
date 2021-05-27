package io.lemon.cloud.common.port;

import java.net.InetAddress;
import java.net.Socket;
import java.util.Random;

public class ServerPortUtils {

    public static int getAvailablePort() {
        int max = 65535;
        int min = 2000;
        Random random = new Random();
        int port = random.nextInt(max) % (max - min + 1) + min;
        boolean using = isLocalPortUsing(port);
        if (using) {
            return getAvailablePort();
        } else {
            return port;
        }
    }

    public static boolean isLocalPortUsing(int port){
        boolean flag = true;
        try {
            flag = isPortUsing("127.0.0.1", port);
        } catch (Exception e) {
            System.out.println("can not judge target port is using : " + port);
        }
        return flag;
    }

    private static boolean isPortUsing(String host,int port) {
        boolean flag = false;
        try {
            InetAddress theAddress = InetAddress.getByName(host);
            Socket socket = new Socket(theAddress,port);
            socket.close();
            flag = true;
        } catch (Exception e) {
            System.out.println("judge target port is using， socket connecting : " + port);
        }
        return flag;
    }

}
