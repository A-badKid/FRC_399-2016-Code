package org.usfirst.frc.team399.Systems;


import org.usfirst.frc.team399.Config.Ports;
import com.ctre.CANTalon;

public class Drivetrain {
	
	private CANTalon lefta = null;
	private CANTalon leftb = null;
	private CANTalon righta = null;
	private CANTalon rightb = null;
	
	public Drivetrain(int la, int lb, int ra, int rb) {
		
		lefta = new CANTalon(la);
		leftb = new CANTalon(lb);
		
		righta = new CANTalon(ra);
		rightb = new CANTalon(rb);
		
		
	}
	
	public void tankDrive(double leftv, double rightv) {
		lefta.set(-leftv);
		leftb.set(-leftv);
		
		righta.set(rightv);
		rightb.set(rightv);
	}
	
	public void limitSwitch(boolean leftfor,boolean leftrev,boolean rightfor,boolean rightrev){
		lefta.enableLimitSwitch(leftfor,leftrev);
		leftb.enableLimitSwitch(leftfor,leftrev);
		
		righta.enableLimitSwitch(rightfor,rightrev);
		rightb.enableLimitSwitch(rightfor,rightrev);
		
	}
	
	public void tankDrive(double[] input) {
		tankDrive(input[0], input [1]);
	}
	

}
