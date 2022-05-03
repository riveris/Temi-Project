package com.example.readdata.temi;

import com.robotemi.sdk.Robot;

public class RoboTemi {
    private Robot robot;
    public RoboTemi() {
        this.robot =  Robot.getInstance();
    }
}
