package org.usfirst.frc.team399.Systems;
import edu.wpi.first.wpilibj.Solenoid;

public class ShooterActuator {
	Solenoid actuator;
	
	public ShooterActuator(int aS){
		actuator = new Solenoid(aS);
	}
	
	public void setShoot(boolean state){
		actuator.set(state);
		
	}

}
