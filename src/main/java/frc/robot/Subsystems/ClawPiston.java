package frc.robot.Subsystems;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.drive.RobotDriveBase.MotorType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.utility.Peripherals;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import frc.robot.utility.EvanEffectorConstants;
import static frc.robot.utility.EvanEffectorConstants.*;



public class ClawPiston extends SubsystemBase{

	


	private static ClawPiston clawPiston;
    
    private static DoubleSolenoid piston;

    public ClawPiston(){
        piston = new DoubleSolenoid(PNEUMATIC_PORT, PneumaticsModuleType.CTREPCM, OPEN_ARM_PISTON, CLOSE_ARM_PISTON);
    }

public static ClawPiston getInstance() {
        if(clawPiston == null){
            clawPiston = new ClawPiston();
        }
		return clawPiston;
    }

public void setClawPiston(boolean setClawPiston) {
        if(setClawPiston == false){
            piston.set(DoubleSolenoid.Value.kForward);
        }
        else if(setClawPiston == true){
            piston.set(DoubleSolenoid.Value.kReverse);
        }
    }
public void setMultiClawPiston(int setClawPiston) {
        if(setClawPiston == 0) {
            piston.set(DoubleSolenoid.Value.kForward);
        }
        else if(setClawPiston == 1) {
            piston.set(DoubleSolenoid.Value.kReverse);
        }
        else if(setClawPiston == 2) {
            piston.toggle();
        }
    }

    public void trueClawPiston() {
        piston.set(DoubleSolenoid.Value.kReverse);
    }

    public void falseClawPiston() {
        piston.set(DoubleSolenoid.Value.kForward);
    }

    public void toggleClawPiston() {
        piston.toggle();
    }

    public DoubleSolenoid.Value getClawPiston() {
        return piston.get();
    }
}