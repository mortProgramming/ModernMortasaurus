// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.Commands.ArmCommand;
import frc.robot.Commands.ClawPistonControl;
import frc.robot.Commands.DriveCommand;
import frc.robot.Subsystems.Arm;
import frc.robot.Subsystems.Drivetrain;
import frc.robot.utility.Peripherals;
import frc.robot.utility.*;


public class RobotContainer {
  private static final Joystick leftJoy = new Joystick(Peripherals.LEFT_JOYSTICK_PORT);
  private static final Joystick rightJoy = new Joystick(Peripherals.RIGHT_JOYSTICK_PORT);

  private static final CommandXboxController controller = new CommandXboxController(Peripherals.CONTROLLER_PORT);

  private final Drivetrain drivetrain = Drivetrain.getInstance();
  private final Arm arm = Arm.getInstance();

  public RobotContainer() {
    configureBindings();
  }

  private void configureBindings() {
    drivetrain.setDefaultCommand(new DriveCommand(RobotContainer::getLeftJoystickY, RobotContainer::getRightJoystickY));
    controller.a().onTrue(new ClawPistonControl(2));
    // controller.x().onTrue(new ArmCommand(1));
    arm.setDefaultCommand(new ArmCommand(RobotContainer::getLeftJoystickY));
  }

  public Command getAutonomousCommand() {
    return Commands.print("No autonomous command configured");
  }

  public static double getLeftJoystickY() {
		return leftJoy.getY();
	}
  public static double getRightJoystickY() {
		return rightJoy.getY();
	}
}
