package frc.robot.Commands.Auton.Actions;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj.Timer;
import frc.robot.Subsystems.Arm;

public class TimedArm extends Command{
    private Arm arm;

    private Timer timer;

    private double motorSpeed;
    private double time;


public TimedArm(double time, double motorSpeed){
    arm = Arm.getInstance();
    timer = new Timer();
    
    this.time = time;
    this.motorSpeed = motorSpeed;


        addRequirements(arm);
    }
    @Override
    public void initialize() {
        timer.reset();
        timer.start();
    }

    @Override
    public void execute() {
        arm.setArmVelocity(motorSpeed);
    }

    @Override
    public void end(boolean interrupted) {
        arm.setMotor(0);
    }

    @Override
    public boolean isFinished() {
        // Once the timer's counted time is greater than the specified time, the command should finish
        return timer.get() > time;
    }
}

