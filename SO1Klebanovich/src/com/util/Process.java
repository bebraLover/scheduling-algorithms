package com.util;

public class Process {
    int PID;
    int phaseLength;
    int appearanceTime;
    int waitingTime;
    int remainingTime;
    int exitTime;
    int nextAppearence;

    public Process(int PID, int phaseLength, int appearanceTime) {
        this.PID = PID;
        this.phaseLength = phaseLength;
        this.appearanceTime = appearanceTime;
        this.remainingTime = phaseLength;
        this.nextAppearence = appearanceTime;

    }


    public int getPID() {
        return PID;
    }

    public int getPhaseLength() {
        return phaseLength;
    }

    public int getAppearanceTime() {
        return appearanceTime;
    }

    public int getWaitingTime() {
        return waitingTime;
    }

    public void setWaitingTime(int waitingTime) {
        this.waitingTime = waitingTime;
    }

    public int getRemainingTime() {
        return remainingTime;
    }

    public void setRemainingTime(int remainingTime) {
        this.remainingTime = remainingTime;
    }

    public void setExitTime(int exitTime) {
        this.exitTime = exitTime;
    }

    public int getExitTime() {
        return exitTime;
    }

    public int getNextAppearence() {
        return nextAppearence;
    }

    public void setNextAppearence(int nextAppearence) {
        this.nextAppearence = nextAppearence;
    }

    @Override
    public String toString() {
        return "Process{" +
                "PID=" + PID +
                ", phaseLength=" + phaseLength +
                ", appearanceTime=" + appearanceTime +
                ", waitingTime=" + waitingTime +
                ", turnAroundTime=" + (exitTime - appearanceTime)+
                '}';
    }
}
