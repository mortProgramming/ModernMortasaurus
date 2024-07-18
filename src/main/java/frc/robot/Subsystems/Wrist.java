package frc.robot.Subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.drive.RobotDriveBase.MotorType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.utility.Peripherals;
import static frc.robot.utility.EvanEffectorConstants.*;


public class Wrist extends SubsystemBase {

    private static Wrist wrist;
    private static TalonSRX wristMotor;
    //changed from 
    public Wrist(){
        wristMotor = new TalonSRX(CLAW_MOTOR_PORT);
    }

    public void setWristVelocity (double value){
      wristMotor.set(ControlMode.PercentOutput, value);
    }

    @Override
  public void periodic() {
 
  }

  public static Wrist getInstance(){
    if(wrist == null){
      wrist = new Wrist();
    }
    return wrist;
  }



    public TalonSRX getwrist(){
        return wristMotor;
    }
        
    
    



    
}
