package io.lemon.cloud.common.port;

public class AutoDecideStartPort {

    private static final String SERVER_PORT = "server.port";

    public static void autoGetAndSetStartPort(String[] args) {
        boolean isServerPort = false;
        String serverPort = null;
        //从命令行读
        if (null != args && 0 < args.length) {
            for (String arg : args) {
                if (arg.startsWith("--server.port")) {
                    isServerPort = true;
                    serverPort = arg;
                    break;
                }
            }
        }
        if (!isServerPort) {
            int port = ServerPortUtils.getAvailablePort();
            System.out.println("current server.port=" + port);
            System.setProperty(SERVER_PORT, String.valueOf(port));
        } else {
            System.out.println("current server.port=" + serverPort.split("=")[1]);
            System.setProperty(SERVER_PORT,  serverPort.split("=")[1]);
        }
    }

}
