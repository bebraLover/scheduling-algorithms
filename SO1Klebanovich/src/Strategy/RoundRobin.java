package Strategy;

import Comparators.ProcessArrivalTimeComparator;
import com.util.Data;
import com.util.Process;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

public class RoundRobin extends SchedulingAlgorithm implements SchedulingStrategy {
    private int timeQuant;

    public RoundRobin(int timeQuant) {
        this.timeQuant = timeQuant;
    }

    public void run(String data) {
        System.out.println("___________________Round Robin________________________");

        ArrayList<Process> processes = Data.getDataSet(data);
        ArrayList<Process> resolved = new ArrayList<>();
        ArrayList<Process> waitingProcesses = new ArrayList<>();
        processes.sort(new ProcessArrivalTimeComparator());

        int time = 0;
        while (processes.size() != 0 || waitingProcesses.size() != 0) {
            waitingProcesses = newProcesses(time, processes, waitingProcesses);
            if (waitingProcesses.size() != 0) {
                Process temp = waitingProcesses.remove(0);
                time = resolveProcess(temp, time);
                waitingProcesses = newProcesses(time, processes, waitingProcesses);
                if(temp.getRemainingTime() <= 0){
                    temp.setExitTime(time);
                    resolved.add(temp);
                }else {
                    waitingProcesses.add(temp);
                }
            } else {
                time++;
            }
        }
        statistics(resolved);
    }


    public int resolveProcess(Process process, int time) {

        if (process.getRemainingTime() > timeQuant) {
            process.setWaitingTime(process.getWaitingTime() + time - process.getNextAppearence());
            process.setRemainingTime(process.getRemainingTime() - timeQuant);
            time += timeQuant;
            process.setNextAppearence(time);
        } else {
            process.setWaitingTime(process.getWaitingTime() + time - process.getNextAppearence());
            time += process.getRemainingTime();
            process.setRemainingTime(0);
        }

        return time;
    }


}
