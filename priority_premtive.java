
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class priority_premtive {

  static int n = 5;
  static int ProcessID[] = new int[5];
  static int ArrivalTime[] = new int[5];
  static int ArrivalTimee[] = new int[5];
  static int BurstTime[] = new int[5];
  static int WaitingTime[] = new int[5];
  static int TurnaroundTime[] = new int[5];
  static int priority[] = new int[5];
  static int CpuTime = 0;

  public static void main(String[] args) {

    // SJF , Primitive , WithArrivalTime
    String states[] = new String[5];

    read();
    priority();
    state(states);
    print();
  }

  public static void read() {

    int i1 = 0;
    int i2 = 0;

    try {
      File file = new File("input/input3.txt");

      Scanner reader = new Scanner(file);

      while (reader.hasNextLine()) {

        String data[] = reader.nextLine().split(",");

        ProcessID[i2] = Integer.valueOf(data[i1]);
        ArrivalTime[i2] = Integer.valueOf(data[i1 + 1]);
        BurstTime[i2] = Integer.valueOf(data[i1 + 2]);
        priority[i2] = Integer.valueOf(data[i1 + 3]);
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

  public static void priority() {
    int[] completeTime = new int[n];
    int[] flag = new int[n];
    int[] CopyOfBurstTime = new int[n];
    int CPUTimer = 0;
    int completedProcess = 0, index = 0;

    for (int i = 0; i < n; i++) {
      CopyOfBurstTime[i] = BurstTime[i];
      flag[i] = 0;
    }

    while (completedProcess != n) {

      int minValue = Integer.MAX_VALUE;

      for (int i = 0; i < n; i++) {
        if ((ArrivalTime[i] <= CPUTimer) && (flag[i] == 0) && (priority[i] <= minValue)) {
          if (priority[i] == minValue) {
            if (ArrivalTime[i] < priority[index]) {

            }
          }
        }
      }

      CopyOfBurstTime[index]--;
      CPUTimer++;

      if (CopyOfBurstTime[index] == 0) {
        completeTime[index] = CPUTimer;
        flag[index] = 1;
        completedProcess++;
      }
    }

    for (int i = 0; i < n; i++) {
      WaitingTime[i] = completeTime[i] - ArrivalTime[i] - BurstTime[i];

      for (int j = 0; i < n; i++) {
        CopyOfBurstTime[i] = BurstTime[i];
        flag[i] = 0;
      }

      while (completedProcess != n) {

        int minValue = Integer.MAX_VALUE;

        for (int j = 0; i < n; i++) {
          if ((ArrivalTime[i] <= CPUTimer) && (flag[i] == 0) && (priority[i] <= minValue)) {
            if (priority[i] == minValue) {
              if (ArrivalTime[i] < priority[index]) {
                minValue = priority[i];
                index = i;
              }
              minValue = priority[index];
              index = i;
            }
          }
        }

        CopyOfBurstTime[index]--;
        CPUTimer++;

        if (CopyOfBurstTime[index] == 0) {
          completeTime[index] = CPUTimer;
          flag[index] = 1;
          completedProcess++;
        }
      }

      for (int k = 0; i < n; i++) {
        WaitingTime[i] = completeTime[i] - ArrivalTime[i] - BurstTime[i];

        TurnaroundTime[i] = WaitingTime[i] + BurstTime[i];
      }

      CpuTime = CPUTimer;
    }

    CpuTime = CPUTimer;
  }

  public static void state(String processState[]) {
    for (int i = 0; i <= CpuTime; i++) {
      System.out.println("CPU Time = " + i);

      for (int k = 0; k < ProcessID.length; k++) {
        int processID = ProcessID[k];
        int arrivalTime = ArrivalTime[k];
        int burstTime = BurstTime[k];
        int waitingTime = WaitingTime[k];
        int turnaroundTime = TurnaroundTime[k];
        int pro = priority[k];
        if (arrivalTime == i)
          processState[k] = "new";
        if (arrivalTime < i) {
          processState[k] = "ready";
          ArrivalTimee[i] = CpuTime;
        }
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

  public static void print() {
    System.out.println();
    System.out.println(" processID  arrivalTime  burstTime  waitingTime  turnaroundTime");

    for (int i = 0; i < ProcessID.length; i++) {
      System.out.println("\t" + ProcessID[i] + "\t\t\t" + ArrivalTime[i] + "\t\t\t" + BurstTime[i] + "\t\t\t"
          + WaitingTime[i] + "\t\t\t" + TurnaroundTime[i]);
    }
  }
}
