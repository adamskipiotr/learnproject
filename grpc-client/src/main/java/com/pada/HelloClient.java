package com.pada;

import com.pada.learnproject.HelloRequest;
import com.pada.learnproject.HelloServiceGrpc;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Service;

@Service
public class HelloClient {

    @GrpcClient("grpc-client")
    private HelloServiceGrpc.HelloServiceBlockingStub helloServiceBlockingStub;


    public String receiveGreeting(String name){
        HelloRequest request = HelloRequest.newBuilder()
                .setName(name)
                .build();
        return helloServiceBlockingStub.hello(request).getGreeting();
    }
}
