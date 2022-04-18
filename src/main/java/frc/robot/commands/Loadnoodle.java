// // //This command is what is called when the A button is pressed, it controls the slower motor

//  package frc.robot.commands;


//  import org.usfirst.frc.team677.robot.Robot;
//  import org.usfirst.frc.team677.robot.subsystems.Slowmotor;

// //  import edu.wpi.first.wpilibj.command.Command;
//  import edu.wpi.first.wpilibj2.command.CommandBase;

//  // /**
//  //  *
//  //  */
//  public class Loadnoodle extends CommandBase {
//  	double speed;
	
//      public Loadnoodle(double speed) {
//      	requires(Robot.slowmotor);

//          this.speed = speed;
//      }

// //     // Called just before this Command runs the first time
//      protected void initialize() {
//           frc.robot.subsystems.Slowmotor.opperate(0);
//      }

// //     // Called repeatedly when this Command is scheduled to run
//      protected void execute() {
//           frc.robot.subsystems.Slowmotor.opperate(speed);
//      }

// //     // Make this return true when this Command no longer needs to run execute()
//      protected boolean isFinished() {
//      	return false; 
//      }

// //     // Called once after isFinished returns true
//      protected void end() {
//          Slowmotor.opperate(0);
//      }

// //     // Called when another command which requires one or more of the same
// //     // subsystems is scheduled to run
//      protected void interrupted() {
//      	Slowmotor.opperate(0);
//      }
//  }
