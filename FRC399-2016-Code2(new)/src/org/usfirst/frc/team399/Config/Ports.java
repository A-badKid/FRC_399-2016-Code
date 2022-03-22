package org.usfirst.frc.team399.Config;

public class Ports {
	
	public static class Controls {
		
		public static int DRIVER_PORT_A = 0;
		public static int DRIVER_PORT_B = 1;
		public static int OPERATOR_PORT = 2;
	}

	public static class Drivetrain {
		
		public static int DRIVE_LEFTA_MOTOR = 0;
		public static int DRIVE_LEFTC_MOTOR = 12;
		public static int DRIVE_RIGHTA_MOTOR = 6;
		public static int DRIVE_RIGHTC_MOTOR = 11;

		
	}
	
	public static class Intake {
		
		public static int INTAKE_PIVOT_MOTOR = 14;
		public static int INTAKE_WHEELS_MOTOR = 7;
	}
	
	public static class Manipulator{
		public static final int MANIPULATOR_TALON1 = 1;
		public static final int MANIPULATOR_TALON2 = 13;
	}
	
	public static class Shooter{
		public static final int SHOOTER1_ID = 10; 
		public static final int SHOOTER2_ID = 15;
		public static final int PIVOT_SHOOTER1_ID = 5;
		public static final int PIVOT_SHOOTER2_ID = 4; 
		public static final int SHOOTER_ACTUATOR_ID = 0;

		
	}
	
	public static class Encoders{
		public static final int RIGHT_ENCA= 0; 
		public static final int RIGHT_ENCB = 1;

		
	}
	
	public static class Pixycam {
		public static int PIXYCAM_PORT = 0;
	}
	
	
}
