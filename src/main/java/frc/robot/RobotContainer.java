// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.Subsystems.Drivetrain;
import frc.robot.utility.Constants.*;

public class RobotContainer {
  private final Joystick leftJoy = new Joystick(Peripherals.LEFT_JOYSTICK_PORT);
  private final Joystick rightJoy = new Joystick(Peripherals.RIGHT_JOYSTICK_PORT);
  private final CommandXboxController controller = new CommandXboxController(Peripherals.CONTROLLER_PORT);

  private final Drivetrain drivetrain = new Drivetrain();




  public RobotContainer() {
    configureBindings();
  }

  private void configureBindings() {
    drivetrain.setDefaultCommand(drivetrain.driveCommand(() -> {return leftJoy.getX();}, () -> {return rightJoy.getX();}));
  }

  public Command getAutonomousCommand() {
    return Commands.print("No autonomous command configured");
  }
}
