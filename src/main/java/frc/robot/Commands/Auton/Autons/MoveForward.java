package frc.robot.Commands.Auton.Autons;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.Commands.Auton.Actions.TimedDrive;

public class MoveForward extends SequentialCommandGroup {
    public MoveForward() {
        addCommands(
            new TimedDrive(1, 0.25, 0.25)
        );
    }
}
