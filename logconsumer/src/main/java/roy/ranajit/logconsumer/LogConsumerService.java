package roy.ranajit.logconsumer;

import java.sql.Timestamp;
import java.time.Instant;

import org.springframework.beans.factory.annotation.Autowired;

import io.grpc.stub.StreamObserver;
import logger.LoggerGrpc;
import logger.Interface.Ack;
import logger.Interface.LogMsg;
import net.devh.boot.grpc.server.service.GrpcService;
import roy.ranajit.logconsumer.model.LogMessage;
import roy.ranajit.logconsumer.model.LogRepostiory;

@GrpcService
public class LogConsumerService extends LoggerGrpc.LoggerImplBase {
    @Autowired
    private LogRepostiory repo;
    
    @Override
    public void log(LogMsg request, StreamObserver<Ack> responseObserver) {
        LogMessage msg = new LogMessage();
        msg.setMessage(request.getMessage());
        msg.setService(request.getService());
        msg.setLogLevel(request.getLevelValue());
        msg.setTimeStamp(Timestamp.from(Instant.ofEpochMilli(request.getTsMs())));

        repo.save(msg);

        Ack response = Ack.newBuilder().setSuccess(false).build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
