import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.StreamCorruptedException;
import java.sql.Date;
import java.util.Scanner;

public class  HomeWork3 {

    static int ProcessID[] = new int[4];
    static int ArrivalTime[] = new int[4];
    static int BurstTime[] = new int[4];
    static int WaitingTime[] = new int[4];
    static int TurnaroundTime[] = new int[4];
    static int CpuTime = 0;

    public static void main(String[] args) {

        // SJF , NON-Primitive , With Arrival Time

        String states[] = new String[4];

        read();
        System.out.println("-----------------------------------------");
        sortArrivalTime();
        process();
        state(states);
        print();
    }

    public static void read() {

        int i1 = 0;
        int i2 = 0;

        try {
            File file = new File("Text Files\\input2.txt");

            Scanner reader = new Scanner(file);

            while (reader.hasNextLine()) {

                String data[] = reader.nextLine().split(",");

                ProcessID[i2] = Integer.valueOf(data[i1]);
                ArrivalTime[i2] = Integer.valueOf(data[i1 + 1]);
                System.out.println(data[i1+1]);
                BurstTime[i2] = Integer.valueOf(data[i1 + 2]);
                WaitingTime[i2] = 0;
                TurnaroundTime[i2] = 0;
                i2++;
            }

            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static void sortArrivalTime() {
        for (int i = 0; i < ProcessID.length; i++) {

            int temp = 0;

            for (int j = i + 1; j < ProcessID.length; j++) {
                if (ArrivalTime[i] > ArrivalTime[j]) {
                    temp = ProcessID[i];
                    ProcessID[i] = ProcessID[j];
                    ProcessID[j] = temp;

                    temp = ArrivalTime[i];
                    ArrivalTime[i] = ArrivalTime[j];
                    ArrivalTime[j] = temp;

                    temp = BurstTime[i];
                    BurstTime[i] = BurstTime[j];
                    BurstTime[j] = temp;
                }
            }
        }
        for(int i=0;i<ArrivalTime.length;i++){
            System.out.println(ArrivalTime[i]);
        }
    }

    public static void process() {
        for (int i = 0; i < ProcessID.length; i++) {

            SJF(i);

            WaitingTime[i] = CpuTime - ArrivalTime[i];

            TurnaroundTime[i] = WaitingTime[i] + BurstTime[i];

            CpuTime += BurstTime[i];
        }
    }

    public static void SJF(int position) {
        for (int i = position; i < ProcessID.length; i++) {

            int temp = 0;

            for (int j = i + 1; j < ProcessID.length; j++) {
                if (ArrivalTime[j] <= CpuTime) {
                    if (BurstTime[i] >= BurstTime[j]) {
                        temp = ProcessID[i];
                        ProcessID[i] = ProcessID[j];
                        ProcessID[j] = temp;

                        temp = ArrivalTime[i];
                        ArrivalTime[i] = ArrivalTime[j];
                        ArrivalTime[j] = temp;

                        temp = BurstTime[i];
                        BurstTime[i] = BurstTime[j];
                        BurstTime[j] = temp;
                    }
                }
            }
        }
    }

    public static void print() {
        System.out.println();
        System.out.println(" processID  arrivalTime  burstTime  waitingTime  turnaroundTime");

        for (int i = 0; i < ProcessID.length; i++) {
            System.out.println("\t" + ProcessID[i] + "\t\t\t" + ArrivalTime[i] + "\t\t\t" + BurstTime[i] + "\t\t\t"
                    + WaitingTime[i] + "\t\t\t" + TurnaroundTime[i]);
        }
    }

    int input = 2;

    public static void state(String processState[]) {
        for (int i = 0; i <= CpuTime; i++) {
            System.out.println("CPU Time = " + i);

            for (int k = 0; k < ProcessID.length; k++) {
                int processID = ProcessID[k];
                int arrivalTime = ArrivalTime[k];
                int burstTime = BurstTime[k];
                int waitingTime = WaitingTime[k];
                int turnaroundTime = TurnaroundTime[k];

                if (arrivalTime == i)
                    processState[k] = "new";
                if (arrivalTime < i)
                    processState[k] = "ready";
                if (arrivalTime + waitingTime <= i)
                    processState[k] = "running";
                if (turnaroundTime <= i)
                    processState[k] = "end";
            }

            for (int k2 = 0; k2 < ProcessID.length; k2++) {
                System.out.println("State P" + ProcessID[k2] + " = " + processState[k2]);
            }
            System.out.println("----------------------------------");
        }
    }
}
