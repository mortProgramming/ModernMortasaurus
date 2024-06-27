package frc.robot.Commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Subsystems.ClawPiston;

public class ClawPistonControl extends Command {
    ClawPiston clawPiston;
    private int setting;

    public ClawPistonControl(int setting) {
        this.setting = setting;

        clawPiston = ClawPiston.getInstance();

        addRequirements(clawPiston);
    }

    @Override
    public void initialize() {
        clawPiston.setMultiClawPiston(setting);
    }

    public boolean isFinished() {
        return true;
    }

    public void end(boolean interrupted) {}
}