package testers;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import classes.ArrayQueue;
import classes.Job;
import classes.SLLQueue;

public class SystemMain {
    public static void main(String[] args) {
        SLLQueue<Job> inputQueue = new SLLQueue<>();
        ArrayQueue<Job> processingQueue = new ArrayQueue<>();
        ArrayQueue<Job> terminatedQueue = new ArrayQueue<>();


        int time = 0;
        int avgtime = 0;
        double elements;

        Job job;

        try {
            FileReader inputFILE = new FileReader("input.txt");

            BufferedReader buffRead = new BufferedReader(inputFILE);

            String line;

            int id = 1;

            while ((line = buffRead.readLine()) != null) {
                String[] numbers = line.split(",");

                job = new Job(id, new Integer(numbers[0]), new Integer(numbers[1]));

                inputQueue.enqueue(job);
                id++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        while (!inputQueue.isEmpty() || !processingQueue.isEmpty()) {
            if (!processingQueue.isEmpty()) {
                processingQueue.first().isServed(1);

                if (processingQueue.first().getRemainingTime() == 0) {
                    processingQueue.first().setDepartureTime(time);

                    terminatedQueue.enqueue(processingQueue.dequeue());
                } else {
                    processingQueue.enqueue(processingQueue.dequeue());
                }

            }

            if(!inputQueue.isEmpty() && inputQueue.first().getArrivalTime() == time){
                processingQueue.enqueue(inputQueue.dequeue());
            }

            time++;
        }

        elements = terminatedQueue.size();

        while (!terminatedQueue.isEmpty()) {
            Job etr = terminatedQueue.dequeue();
            avgtime += etr.getDepartureTime() - etr.getArrivalTime();
        }

        double meanSystTime = avgtime/elements;

        System.out.println("Average processing time in system: " + meanSystTime);

    }
}
