package org.usfirst.frc.team399.Systems;

import org.usfirst.frc.team399.Config.Ports;
import org.usfirst.frc.team399.Systems.Drivetrain;
import org.usfirst.frc.team399.Systems.Intake;
import org.usfirst.frc.team399.Systems.Shooter;
import org.usfirst.frc.team399.Systems.ShooterPivot;
import org.usfirst.frc.team399.Systems.ShooterActuator;
import edu.wpi.first.wpilibj.Encoder;

public class Supersystem {
	
	public static Supersystem instance = null;
	public Drivetrain drive = null;
	public Intake intake = null;
	public Manipulator manipulator = null;
	public ShooterPivot shooterpivot = null;
	public Shooter shooter = null;
	public static ShooterActuator shooteractuator = null;
	public Encoder rightenc = null;

	
	
	private Supersystem() {
		
		drive = new Drivetrain(Ports.Drivetrain.DRIVE_LEFTA_MOTOR,
							   Ports.Drivetrain.DRIVE_LEFTC_MOTOR,
							   Ports.Drivetrain.DRIVE_RIGHTA_MOTOR,
							   Ports.Drivetrain.DRIVE_RIGHTC_MOTOR);
		
		intake = new Intake(Ports.Intake.INTAKE_PIVOT_MOTOR,
							Ports.Intake.INTAKE_WHEELS_MOTOR);
		
		manipulator = new Manipulator(Ports.Manipulator.MANIPULATOR_TALON1,
									  Ports.Manipulator.MANIPULATOR_TALON2);
		
		shooterpivot = new ShooterPivot(Ports.Shooter.PIVOT_SHOOTER1_ID,
										Ports.Shooter.PIVOT_SHOOTER2_ID);
		
		shooter = new Shooter(Ports.Shooter.SHOOTER1_ID, Ports.Shooter.SHOOTER2_ID);
		
		shooteractuator = new ShooterActuator(Ports.Shooter.SHOOTER_ACTUATOR_ID);
		
		rightenc = new Encoder(Ports.Encoders.RIGHT_ENCA,
							   Ports.Encoders.RIGHT_ENCB,
							   false,
							   Encoder.EncodingType.k4X);
		
		}
	
	
	
	public static Supersystem getInstance() {

		if (instance == null) {
			instance = new Supersystem();
		}
		return instance;
		

	}
	
	
	
	

}
