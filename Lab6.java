//import java.io.BufferedReader;
//import java.io.File;
//import java.io.FileReader;
//import java.util.ArrayList;
//import java.io.FileNotFoundException;
//import java.io.IOException;
//import java.sql.Date;
//import java.util.Scanner;
//import javax.print.attribute.SetOfIntegerSyntax;
//
//    public class Lab6 {
//    public static void main(String[] args) {
//
//        // Priority. without arrival time
//
//        ArrayList<Integer> ProcessID =   new ArrayList<>();
//        ArrayList<Integer> ArrivalTime = new ArrayList<>();
//        ArrayList<Integer> BurstTime =   new ArrayList<>();
//        ArrayList<Integer> Priority =    new ArrayList<>();
//        ArrayList<Integer> WaitingTime =  new ArrayList<>();
//         // ArrayList<String> state = new ArrayList<String>();3
//
//        String state[] = new String[4];
//        int CpuTime = 0;
//
//        int i = 0;
//
//        try {
//            File file = new File("Text Files\\inputforLab6.txt");
//
//            // BufferedReader reader = new BufferedReader(new FileReader(file));
//
//            Scanner reader = new Scanner(file);
//
//            while (reader.hasNextLine()) {
//
//                String data[] = reader.nextLine().split(",");
//
//                ProcessID.add(Integer.valueOf(data[i]));
//                ArrivalTime.add(Integer.valueOf(data[i + 1]));
//                BurstTime.add(Integer.valueOf(data[i + 2]));
//                Priority.add(Integer.valueOf(data[i + 3]));
//                WaitingTime.add(0);
//                TurnaroundTime.add(0);
//            }
//
//            // Before sorting
//            // for (int j = 0; j < ProcessID.size(); j++) {
//            // System.out.print(ProcessID.get(j) + " ");
//            // }
//            // System.out.println();
//            // for (int j = 0; j < ArrivalTime.size(); j++) {
//            // System.out.print(ArrivalTime.get(j) + " ");
//            // }
//            // System.out.println();
//            // for (int j = 0; j < BurstTime.size(); j++) {
//            // System.out.print(BurstTime.get(j) + " ");
//            // }
//
//            // Sort Burst Time & Process ID
//            for (int k1 = 0; k1 < ProcessID.size(); k1++) {
//
//                int temp = 0;
//
//                for (int k2 = k1 + 1; k2 < ProcessID.size(); k2++) {
//                    if (Priority.get(k1) > Priority.get(k2)) {
//
//                        temp = Priority.get(k1);
//                        Priority.set(k1, Priority.get(k2));
//                        Priority.set(k2, temp);
//
//                        temp = ProcessID.get(k1);
//                        ProcessID.set(k1, ProcessID.get(k2));
//                        ProcessID.set(k2, temp);
//
//                        temp = BurstTime.get(k1);
//                        BurstTime.set(k1, BurstTime.get(k2));
//                        BurstTime.set(k2, temp);
//                    }
//                }
//            }
//
//            // After sorting;
//            // for (int j = 0; j < ProcessID.size(); j++) {
//            // System.out.print(ProcessID.get(j) + " ");
//            // }
//            // System.out.println();
//            // for (int j = 0; j < ArrivalTime.size(); j++) {
//            // System.out.print(ArrivalTime.get(j) + " ");
//            // }
//            // System.out.println();
//            // for (int j = 0; j < BurstTime.size(); j++) {
//            // System.out.print(BurstTime.get(j) + " ");
//            // }
//
//                for
//                (int j = 0; j < ProcessID.size(); j++) {
//                int arrivalTime = ArrivalTime.get(j);
//                int burstTime = BurstTime.get(j);
//
//                int waitingTime = CpuTime + arrivalTime;
//                WaitingTime.set(j, waitingTime);
//
//                int turnaroundTime = waitingTime + burstTime;
//                TurnaroundTime.set(j, turnaroundTime);
//
//                CpuTime = CpuTime + burstTime;
//            }
//
//                    for (int j = 0; j <= CpuTime; j++) {
//                    System.out.println("CPU Time = " + j);
//
//                    for (int j1 = 0; j1 < ProcessID.size(); j1++) {
//                    int processID = ProcessID.get(j1);
//                    int arrivalTime = ArrivalTime.get(j1);
//                    int burstTime = BurstTime.get(j1);
//                    int waitingTime = WaitingTime.get(j1);
//                    int turnaroundTime = TurnaroundTime.get(j1);
//
//                    if (arrivalTime == j)
//                        state[j1] = "new";
//                    if (arrivalTime < j)
//                        state[j1] = "ready";
//                    if (arrivalTime + waitingTime <= j)
//                        state[j1] = "running";
//                    if (turnaroundTime <= j)
//                        state[j1] = "end";
//                }
//
//                for (int j2 = 0; j2 < ProcessID.size(); j2++) {
//                    System.out.println("State P" + ProcessID.get(j2) + " = " + state[j2]);
//                }
//
//                System.out.println("----------------------------------");
//            }
//
//            System.out.println();
//            System.out.println(" processID   arrivalTime   burstTime   Priority   waitingTime   turnaroundTime");
//
//            for (int j = 0; j < ProcessID.size(); j++) {
//                System.out
//                        .println("\t" + ProcessID.get(j) + "\t\t\t\t" + ArrivalTime.get(j) + "\t\t\t" + BurstTime.get(j)
//                                + "\t\t\t" + Priority.get(j) + "\t\t\t" +
//                                +WaitingTime.get(j) + "\t\t\t" + TurnaroundTime.get(j));
//            }
//
//            reader.close();
//        } catch (FileNotFoundException e) {
//            System.out.println("An error occurred.");
//            e.printStackTrace();
//        }
//
//    }
//}
//
