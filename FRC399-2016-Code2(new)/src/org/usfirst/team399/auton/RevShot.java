package org.usfirst.team399.auton;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

import org.usfirst.frc.team399.commands.Rev;
import org.usfirst.frc.team399.commands.Shoot;

public class RevShot extends CommandGroup{
	
	public RevShot(){
		this.addSequential(new Rev(-1.0));
		new WaitCommand(7000);
		this.addSequential(new Shoot(true));
		this.addSequential(new Rev(0.0));
		this.addSequential(new Shoot(false));
	}
	

}
