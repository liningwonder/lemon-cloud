package io.lemon.cloud.hystrix.client;

public class MallClientCallFallback implements MallClient {
    @Override
    public String getTest() {
        return "hystrix";
    }
}
