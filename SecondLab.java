import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SecondLab {

    public static void main(String[] args)

            throws Exception

    {

        int Arrival_Time[] = {0,0,0,0};
        int Burst_Time[] = {6,5,2,10};
        int Waiting_Time[] = new int[4];
        int Turnaround_Time[] = new int[4];

        int CpuTime = 0;

        for (int i = 0; i < Waiting_Time.length; i++) {

            Waiting_Time[i] = CpuTime - Arrival_Time[i];
            CpuTime = CpuTime + Burst_Time[i];
            System.err.print(Waiting_Time[i] + " ");
        }

        System.err.println();

        for (int i = 0; i < Turnaround_Time.length; i++) {
            Turnaround_Time[i] = Waiting_Time[i] + Burst_Time[i];
            System.err.print(Turnaround_Time[i] + " ");
        }

    }

}
