package org.usfirst.frc.team399.Systems;

import com.ctre.CANTalon;

public class Manipulator {
	
	CANTalon talon1;
	CANTalon talon2;
	
	public static class State{
		public static final double STOW = 0; 
		public static final double MANIPULATE = 1; 
		
	} 
	
	public Manipulator(int m1, int m2){
		talon1 = new CANTalon(m1);
		talon2 = new CANTalon(m2);
	}
	
	public void setManipulator(double manvalue){
		talon1.set(manvalue);
		talon2.set(manvalue);
		
	}
	
	
	

}
