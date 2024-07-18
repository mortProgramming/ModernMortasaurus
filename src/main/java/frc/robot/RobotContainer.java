// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.Commands.Auton.Autons.Dance;
import frc.robot.Commands.Auton.Autons.LiftArm;
import frc.robot.Commands.Auton.Autons.MoveForward;
import frc.robot.Commands.Teleop.ArmCommand;
import frc.robot.Commands.Teleop.ClawPistonControl;
import frc.robot.Commands.Teleop.DriveCommand;
import frc.robot.Commands.Teleop.WristCommand;

import frc.robot.Subsystems.Arm;
import frc.robot.Subsystems.Drivetrain;
import frc.robot.Subsystems.Wrist;

import frc.robot.utility.Peripherals;
import frc.robot.utility.*;


public class RobotContainer {
  private static final Joystick leftJoy = new Joystick(Peripherals.LEFT_JOYSTICK_PORT);
  private static final Joystick rightJoy = new Joystick(Peripherals.RIGHT_JOYSTICK_PORT);

  private static final CommandXboxController controller = new CommandXboxController(Peripherals.CONTROLLER_PORT);

  private final Drivetrain drivetrain = Drivetrain.getInstance();
  private final Arm arm = Arm.getInstance();
  private final Wrist wrist = Wrist.getInstance(); 

   private SendableChooser<Command> autoChooser = new SendableChooser<Command>();

  public RobotContainer() {
    configureBindings();
    autoChooser.setDefaultOption("None", null);
    autoChooser.addOption("MoveForward", new MoveForward());
    autoChooser.addOption("LiftArm", new LiftArm());
    autoChooser.addOption("Dance", new Dance());

    SmartDashboard.putData(autoChooser);

  }

  private void configureBindings() {
    drivetrain.setDefaultCommand(new DriveCommand(RobotContainer::getLeftJoystickY, RobotContainer::getRightJoystickY));
    arm.setDefaultCommand(new ArmCommand(RobotContainer::getLeftControllerY));
    wrist.setDefaultCommand(new WristCommand(RobotContainer::getRightControllerY));

    controller.a().onTrue(new ClawPistonControl(0));
    controller.b().onTrue(new ClawPistonControl(1));
  }

  
  public Command getAutonomousCommand() {
    return autoChooser.getSelected();
  }

  public static double getLeftJoystickY() {
		return -leftJoy.getY();
	}

  public static double getRightJoystickY() {
		return -rightJoy.getY();
	}

  public static double getLeftControllerY() {
    return controller.getLeftY();
  }

  public static double getRightControllerY() {
    return controller.getRightY();
  }
}
