package frc.robot.Commands;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.math.kinematics.ChassisSpeeds;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Subsystems.Drivetrain;

import static frc.robot.utility.DrivetrainConstants.*;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.Commands;

public class DriveCommand extends Command {
     private Drivetrain drivetrain;

    private DoubleSupplier leftY;
    private DoubleSupplier rightY;

    public DriveCommand(DoubleSupplier leftY, DoubleSupplier rightY
            ) {
        drivetrain = Drivetrain.getInstance();

        this.leftY = leftY;
        this.rightY = rightY;

        addRequirements(drivetrain);
    }

    @Override
    public void execute() {
        // Drive the drivetrain based on the inputted values
        // The inputted values come from the joystick controls on the drive station
        drivetrain.drive(leftY.getAsDouble(),
                rightY.getAsDouble() );

       
    }
}
