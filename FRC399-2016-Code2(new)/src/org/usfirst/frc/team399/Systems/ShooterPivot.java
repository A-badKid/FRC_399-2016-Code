package org.usfirst.frc.team399.Systems;
import com.ctre.CANTalon;

public class ShooterPivot {
	CANTalon pivotWheel1,pivotWheel2;
	double pivotValue;
	public ShooterPivot(int pW,int pW2){
		pivotWheel1 = new CANTalon(pW);
		pivotWheel2 = new CANTalon(pW2);
		//Capitalized W 
	}
	
	public void setShooterPivotValue(double pivotValue){
		pivotWheel1.set(pivotValue);
		pivotWheel2.set(pivotValue);
		
	}

}
