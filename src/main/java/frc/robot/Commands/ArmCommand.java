package frc.robot.Commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Subsystems.Arm;

import static frc.robot.utility.EvanEffectorConstants.*;

import java.util.function.DoubleSupplier;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;

public class ArmCommand extends Command{

    Arm arm;
    //change from i in a sec
    private DoubleSupplier speed;
    
    public ArmCommand(DoubleSupplier speed){
        arm = Arm.getInstance();
        
        this.speed = speed;
        addRequirements(arm);
    }

    public void execute() {
        arm.setArmVelocity(0.2 * speed.getAsDouble());

        

    }



    
}
