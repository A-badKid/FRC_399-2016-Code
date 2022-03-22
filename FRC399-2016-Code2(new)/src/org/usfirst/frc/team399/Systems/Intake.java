package org.usfirst.frc.team399.Systems;

import org.usfirst.frc.team399.Config.Ports;
import com.ctre.CANTalon;


public class Intake {

	private CANTalon intakewheelsMotor = null;
	private CANTalon intakepivotMotor = null;
	
	public Intake(int iwm, int ipm) {
		
		intakewheelsMotor = new CANTalon(iwm);
		intakepivotMotor = new CANTalon(ipm);
	}
	
	public void setIntake(double intakepivotmotorv) {
		
		intakepivotMotor.set(intakepivotmotorv);
		
	}
	
	public void runIntake(double intakewheelsmotorv) {
		
		intakewheelsMotor.set(intakewheelsmotorv);
	}
}
