package Simulation;

import Strategy.*;

import java.util.ArrayList;

import com.util.Data;
import com.util.Process;

public class Simulation {

    SchedulingStrategy CPUSchedulingAlgorithm;
    String data;


    public Simulation(SchedulingStrategy CPUSchedulingAlgorithm,String data) {
        this.CPUSchedulingAlgorithm = CPUSchedulingAlgorithm;
        this.data = data;
    }

    public void setCPUSchedulingAlgorithm(SchedulingStrategy CPUSchedulingAlgorithm) {
        this.CPUSchedulingAlgorithm = CPUSchedulingAlgorithm;
    }

    public void runSimulation(){
        CPUSchedulingAlgorithm.run(data);
    }

    public static void main(String[] args) {
        Simulation simulation = new Simulation(new FCFS(),"medium");
        simulation.runSimulation();

        simulation.setCPUSchedulingAlgorithm(new SJF());
        simulation.runSimulation();

        simulation.setCPUSchedulingAlgorithm(new SRTF());
        simulation.runSimulation();

        simulation.setCPUSchedulingAlgorithm(new RoundRobin(1000));
        simulation.runSimulation();

    }
}
