// //This is the launcher of the robot, or the really fast wheels that launch pool noodles

// package org.usfirst.frc.team677.robot.subsystems;


// import org.usfirst.frc.team677.robot.RobotMap;
// import org.usfirst.frc.team677.robot.commands.ZeroSpeed;

// import edu.wpi.first.wpilibj.Timer;
// import edu.wpi.first.wpilibj.motorcontrol.VictorSP;
// import edu.wpi.first.wpilibj.command.Subsystem;
// import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

// /**
//  *
//  */
// public class Launcher extends Subsystem {

//    public static int cycle;
//    public static double output;
//    public static double time;

//    //change this boolean to 'false' to turn off adult mode
//    //change this boolean to 'true' to turn on adult mode
//    public static boolean adultMode = false;
	
// 	//These are the launcher victors, named left for left wheel and right for right wheel
//     public static VictorSP left = new VictorSP(RobotMap.LEFT_WHEEL_PORT);
//     public static VictorSP right = new VictorSP(RobotMap.RIGHT_WHEEL_PORT);

//     public Launcher () {
//         cycle = 0;
//         time = Timer.getFPGATimestamp();
//     }
    
//     public static void setSpeed () {
//         left.set(output);
//         right.set(output);
//     }

//     public static void zeroSpeed () {
//         left.set(0);
//         right.set(0);
//     }
    

    
//     //This puts the speed variable on the SmartDashboard and it is run in Robot under "update"

    
//     public static double getLeftSpeed () {
//     	return left.get();
//     }
    
//     public static double getRightSpeed() {
//     	return right.get();
//     }

//     public static void cycleSpeed(boolean keepCycle) {
//         if (cycle == 0 && Timer.getFPGATimestamp() - time >= 1 && keepCycle) {
//             output = .25;
//             cycle++;
//             time = Timer.getFPGATimestamp();
//         } else if (cycle == 1 && Timer.getFPGATimestamp() - time >= 1 && keepCycle) {
//             output = .5;
//             cycle++;
//             time = Timer.getFPGATimestamp();
//         } else if (cycle == 2 && Timer.getFPGATimestamp() - time >= 1 && keepCycle) {
//             if (adultMode) {
//                 output = .75;
//             } else {
//                 output = .25;
//             }
//             cycle++;
//             time = Timer.getFPGATimestamp();
//         } else if (cycle == 3 && Timer.getFPGATimestamp() - time >= 1 && keepCycle) {
//             if (adultMode) {
//                 output = 1;
//             } else {
//                 output = .5;
//             }
//             cycle = 0;
//             time = Timer.getFPGATimestamp();
//         }
//     }

//     public static double getOutput() {
//         return output * 100;
//     }
    
//     public void update() {
//     	SmartDashboard.putNumber("Left Speed", getLeftSpeed());
//         SmartDashboard.putNumber("Right Speed", getRightSpeed());
//         SmartDashboard.putNumber("Output", getOutput());
//         SmartDashboard.putBoolean("Adult Mode", adultMode);
//     }
    
//     public void initDefaultCommand() {
//     	setDefaultCommand(new ZeroSpeed());
//     }
// }

