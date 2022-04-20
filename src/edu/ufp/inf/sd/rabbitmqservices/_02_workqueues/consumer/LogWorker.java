package edu.ufp.inf.sd.rabbitmqservices._02_workqueues.consumer;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class LogWorker {
    private String fileName = "/Users/miguelcarvalho/IdeaProjects/SD/src/edu/ufp/inf/sd/rabbitmqservices/_02_workqueues/consumer/logs.txt";

    public void writeToFile(String str) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
        writer.append(str);
        writer.newLine();
        writer.close();
    }
}
