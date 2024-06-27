package frc.robot.Subsystems;

import static frc.robot.utility.EvanEffectorConstants.PNEUMATIC_CONTROL_MODULE;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import static frc.robot.utility.EvanEffectorConstants.*;

public class Pneumatic extends SubsystemBase {
    private static Pneumatic pneumatic;

	private Compressor compressor;

	private Pneumatic() {
		compressor = new Compressor(PNEUMATIC_CONTROL_MODULE, PneumaticsModuleType.CTREPCM);
		compressor.enableDigital();
	}
    
    //if electrical plays a prank on us then we can use this (tip from Evan)
    public void setCompressorAnalog(){
        compressor.enableAnalog(COMPRESSER_MIN_PRESSURE, COMPRESSER_MAX_PRESSURE);
    }


    public double getPressure() {
		return compressor.getPressure();
	}

	@Override
	public void periodic() {
	}

	public static Pneumatic getInstance() {
		if (pneumatic == null) {
			pneumatic = new Pneumatic();
		}
		return pneumatic;
	}
}




    



    

