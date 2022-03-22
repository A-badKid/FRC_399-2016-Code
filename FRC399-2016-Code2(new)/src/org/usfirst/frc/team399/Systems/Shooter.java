package org.usfirst.frc.team399.Systems;

import com.ctre.CANTalon;

public class Shooter {
	CANTalon shooter1;
	CANTalon shooter2;
	
	public Shooter(int s1, int s2){
		shooter1 = new CANTalon(s1);
		shooter2 = new CANTalon(s2);
	}
	
	public void setShooter(double sht1){
		shooter1.set(sht1);
		shooter2.set(sht1);
	}
	

}
