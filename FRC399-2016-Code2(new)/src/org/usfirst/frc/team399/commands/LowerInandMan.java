package org.usfirst.frc.team399.commands;

import org.usfirst.frc.team399.Systems.Supersystem;

import edu.wpi.first.wpilibj.command.Command;

public class LowerInandMan extends Command {
	private double intakepiv;
	private double manipulatorpiv;
	private double timout;
	
	public LowerInandMan (double intakepiv,double manipulatorpiv,double timout){
		this.intakepiv = intakepiv;
		this.manipulatorpiv = manipulatorpiv;
		this.timout = timout;
	}

	@Override
	protected void initialize() {
		Supersystem.getInstance().intake.runIntake(intakepiv);
		Supersystem.getInstance().manipulator.setManipulator(manipulatorpiv);
		setTimeout(timout);
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void execute() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return this.isTimedOut();
	}

	@Override
	protected void end() {
		Supersystem.getInstance().intake.runIntake(0.0);
		Supersystem.getInstance().manipulator.setManipulator(0.0);
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void interrupted() {
		Supersystem.getInstance().intake.runIntake(0.0);
		Supersystem.getInstance().manipulator.setManipulator(0.0);
		// TODO Auto-generated method stub
		
	}

}
