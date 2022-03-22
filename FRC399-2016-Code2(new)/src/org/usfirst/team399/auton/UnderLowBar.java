package org.usfirst.team399.auton;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc.team399.commands.TankDrive;
import org.usfirst.frc.team399.commands.LowerInandMan;

public class UnderLowBar extends CommandGroup {
	
	public UnderLowBar(){
		this.addSequential(new LowerInandMan(0.5,0.5,1.5));
		this.addSequential(new TankDrive(0.4, 0.4, 3.0));
		//check value for intake pivot
	}

}
