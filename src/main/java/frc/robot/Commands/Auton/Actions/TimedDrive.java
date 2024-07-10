package frc.robot.Commands.Auton.Actions;
import edu.wpi.first.math.kinematics.ChassisSpeeds;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Subsystems.Drivetrain;

public class TimedDrive extends Command{ 
    private Drivetrain drivetrain;

    private Timer timer;

    private double time;
    private double leftDrive;
    private double rightDrive;

    public TimedDrive(double time, double leftDrive, double rightDrive){
        
        drivetrain = Drivetrain.getInstance();

        timer = new Timer();
        this.time = time;
        this.leftDrive = leftDrive;
        this.rightDrive = rightDrive;
    
    addRequirements(drivetrain);
    }
 @Override
    public void initialize() {
        // Reset and start the timer
        timer.reset();
        timer.start();
    }

    @Override
    public void execute() {
        drivetrain.drive(leftDrive, rightDrive);
    }

    @Override
    public void end(boolean interrupted) {
        drivetrain.drive(0, 0);
    }

    @Override
    public boolean isFinished() {
        return timer.get() > time;
    }
    
}
