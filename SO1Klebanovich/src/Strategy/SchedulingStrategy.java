package Strategy;

import com.util.Process;

import java.util.ArrayList;

public interface SchedulingStrategy {
    void run(String data);
    void statistics(ArrayList<Process> resolved);
//    ArrayList<Process> newProcesses(int time , ArrayList<Process> processes, ArrayList<Process> waitingProcesses);
}
