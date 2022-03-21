package Strategy;

import Comparators.ProcessArrivalTimeComparator;
import Comparators.ProcessPhaseLengthComparator;
import com.util.Data;
import com.util.Process;

import java.util.ArrayList;

public class SJF extends SchedulingAlgorithm implements SchedulingStrategy{
    @Override
    public void run(String data) {
        System.out.println("___________________SJF________________________");
        ArrayList<Process> processes = Data.getDataSet(data);
        ArrayList<Process> resolved = new ArrayList<>();
        ArrayList<Process> waitingProcesses = new ArrayList<>();
        processes.sort(new ProcessArrivalTimeComparator());

        int time = 0;
        while(processes.size() != 0 || waitingProcesses.size() != 0 ){
            waitingProcesses = newProcesses(time, processes, waitingProcesses);
            if(waitingProcesses.size() != 0 ){
                waitingProcesses.sort(new ProcessPhaseLengthComparator());  //Shortest

                Process temp = waitingProcesses.remove(0);
                time = resolveProcess(temp, time);
                temp.setExitTime(time);
                resolved.add(temp);
            }else{
                time++;
            }
        }
        statistics(resolved);
    }

    public int resolveProcess(Process temp, int time){
        if(time - temp.getAppearanceTime() < 0){
            temp.setWaitingTime(0);
        }else {
            temp.setWaitingTime(time - temp.getAppearanceTime());
        }
        while(temp.getRemainingTime() > 0){
            temp.setRemainingTime(temp.getRemainingTime()-1);
            time++;
        }
        return time;
    }
}
