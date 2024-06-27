// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import static frc.robot.utility.DrivetrainConstants.*;

import java.util.function.DoubleSupplier;
import edu.wpi.first.wpilibj2.command.Commands;

public class Drivetrain extends SubsystemBase {
  private static Drivetrain drivetrain;
  private TalonSRX leftMaster;
  private TalonSRX leftFollower;
  private TalonSRX rightMaster;
  private TalonSRX rightFollower;



  /** Creates a new Drivetrain. */
  public Drivetrain() {
    leftMaster = new TalonSRX(LEFT_MASTER_PORT);
    rightMaster = new TalonSRX(RIGHT_MASTER_PORT);
    leftFollower = new TalonSRX(LEFT_FOLLOWER_PORT);
    rightFollower = new TalonSRX(RIGHT_FOLLOWER_PORT);


    leftFollower.follow(leftMaster);
    rightFollower.follow(rightMaster);
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

    public void drive (double left, double right){
      leftMaster.set(ControlMode.PercentOutput, left);
      rightMaster.set(ControlMode.PercentOutput, -right);
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
