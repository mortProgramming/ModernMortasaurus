package frc.robot.Commands.Teleop;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Subsystems.Arm;
import frc.robot.Subsystems.Wrist;

import static frc.robot.utility.EvanEffectorConstants.*;

import java.util.function.DoubleSupplier;

public class WristCommand extends Command{

private static Wrist wrist;

private DoubleSupplier speed;
    
    public WristCommand(DoubleSupplier speed){
        wrist = Wrist.getInstance();
        
        this.speed = speed;
        addRequirements(wrist);
    }

    public void execute () {
        wrist.setWristVelocity(0.5* speed.getAsDouble());
    }











}




