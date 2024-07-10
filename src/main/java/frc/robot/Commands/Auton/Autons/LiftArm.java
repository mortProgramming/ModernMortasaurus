package frc.robot.Commands.Auton.Autons;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.Commands.Auton.Actions.TimedArm;
import frc.robot.Commands.Auton.Actions.TimedDrive;

public class LiftArm extends SequentialCommandGroup{
 public LiftArm() {
        addCommands(
            new TimedArm(1, -0.4)
        );
    }
    
}
