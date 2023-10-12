package com.pada.learnproject.grpcexample.proto;

import com.pada.learnproject.HelloRequest;
import com.pada.learnproject.HelloResponse;
import com.pada.learnproject.HelloServiceGrpc;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.client.inject.GrpcClient;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
public class HelloServiceImpl  extends HelloServiceGrpc.HelloServiceImplBase{

    @GrpcClient("account-service-grpc") // (1)
    HelloServiceGrpc.HelloServiceBlockingStub stub;

    @Override
    public void hello(HelloRequest request, StreamObserver<HelloResponse> responseObserver) {
        HelloResponse reply = HelloResponse.newBuilder()
                .setGreeting("Hello ==> " + request.getName())
                .build();
        responseObserver.onNext(reply);
        responseObserver.onCompleted();
    }
}
