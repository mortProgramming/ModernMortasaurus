package frc.robot.Subsystems;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.drive.RobotDriveBase.MotorType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.utility.Peripherals;

public class ClawMotor extends SubsystemBase {


    private static TalonSRX clawMotor;
    //changed from 
    public ClawMotor(){
        clawMotor = new TalonSRX(0);
    }


    public TalonSRX getClawMotor(){
        return clawMotor;
    }
        
    

    



    
}
