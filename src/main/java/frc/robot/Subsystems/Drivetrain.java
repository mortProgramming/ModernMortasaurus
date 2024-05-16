// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Subsystems;

import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import java.util.function.DoubleSupplier;

import com.ctre.phoenix6.controls.DutyCycleOut;
import com.ctre.phoenix6.controls.Follower;
import edu.wpi.first.wpilibj2.command.Commands;

public class Drivetrain extends SubsystemBase {
  private static Drivetrain drivetrain;
  private TalonFX leftMaster;
  private TalonFX leftFollower;
  private TalonFX rightMaster;
  private TalonFX rightFollower;





  /** Creates a new Drivetrain. */
  public Drivetrain() {
    leftFollower.setControl(new Follower(leftMaster.getDeviceID(), false));
    rightFollower.setControl(new Follower(rightMaster.getDeviceID(), false));
    
  }
  
  /**
   * Construct a command for driving the robot given a Left and Right value and a boolean to determine if the robot should stop if the command is cancelled
   * @param left
   * @param right
   * @param stopOnFinish
   * @return
   */
  public Command driveCommand(DoubleSupplier left, DoubleSupplier right){
    return run(
    () -> {
      leftMaster.set(left.getAsDouble());
      rightMaster.set(right.getAsDouble());
    }
    );
  }

  @Override
  public void periodic() {
 
  }




  public static Drivetrain getInstance(){
    if(drivetrain == null){
      drivetrain = new Drivetrain();
    }
    return drivetrain;
  }
}
