package frc.robot.Commands.Auton.Autons;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.Commands.Auton.Actions.TimedArm;
import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;

public class Dance extends SequentialCommandGroup{
    public Dance(){
        addCommands(
            new SequentialCommandGroup(
            new TimedArm(1, 0.4),
            new TimedArm(1, -0.4))
        );
    }
    
}
