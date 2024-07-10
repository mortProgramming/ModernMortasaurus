package frc.robot.Subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import static frc.robot.utility.EvanEffectorConstants.*;

import java.util.function.DoubleSupplier;
import edu.wpi.first.wpilibj2.command.Commands;
public class Arm extends SubsystemBase{
    private static Arm arm;
    private TalonSRX armMotor;

// Creates a third arm for Evan
public Arm() {
    armMotor = new TalonSRX(ARM_MOTOR_PORT);
  }
  //richard evan matyskiel
  /**
   * Construct a command for driving the robot given a Left and Right value and a boolean to determine if the robot should stop if the command is cancelled
   * @param left
   * @param right 
   * @param stopOnFinish
   * @return
   */
  // public Command driveCommand(DoubleSupplier left, DoubleSupplier right){
  //     leftMaster.set(left.getAsDouble() * 0.25);
  //     rightMaster.set(right.getAsDouble() * 0.25);
  //   }

    public void setArmVelocity (double value){
      armMotor.set(ControlMode.PercentOutput, value);
    }

  @Override
  public void periodic() {
 
  }

  public static Arm getInstance(){
    if(arm == null){
      arm = new Arm();
    }
    return arm;
  }
// make name better later
  // public void armUpwards(double motorUp){
  //   //
  public void setMotor(double motorSpeed) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'setMotor'");
  }
    

  // }
}

