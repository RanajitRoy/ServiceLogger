package roy.ranajit.logger;

import java.time.Instant;

import org.springframework.stereotype.Component;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import logger.LoggerGrpc;
import logger.Interface.Ack;
import logger.Interface.LogMsg;
import logger.Interface.LogMsg.LOG_LEVEL;

@Component
public class Logger {
    ManagedChannel channel;
    LoggerGrpc.LoggerBlockingStub loggerBlockingStub;
    

    public Logger() {
        String logServer = System.getenv("GRPC_SERVER_NAME");
        if(logServer == null) {
            logServer = "localhost";
        }
        String port = System.getenv("GRPC_SERVER_PORT");
        if(port == null) {
            port = "9090";
        }
        channel = ManagedChannelBuilder.forAddress(logServer, Integer.parseInt(port)).usePlaintext().build();
        loggerBlockingStub = LoggerGrpc.newBlockingStub(channel);
    }

    public boolean log(int logLevel, String serviceName, String Message) {
        LogMsg newMsg = LogMsg.newBuilder()
            .setLevel(LOG_LEVEL.forNumber(logLevel))
            .setTsMs(Instant.now().toEpochMilli())
            .setService(serviceName)
            .setMessage(Message)
            .build();
        
        Ack ack = loggerBlockingStub.log(newMsg);
        return ack.getSuccess();
    }
}
