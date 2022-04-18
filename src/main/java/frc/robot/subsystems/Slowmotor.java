// // //This is the subsystem for the slow motor, the one that sends the noodles through the launcher

// package frc.robot.subsystems;
package frc.robot.subsystems;

import frc.robot.RobotMap;
import edu.wpi.first.wpilibj.motorcontrol.VictorSP;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
//  //import edu.wpi.first.wpilibj2.commands.subsystems;

public class Slowmotor extends SubsystemBase{

// // 	//This is the victor for the slow motor called slowmotor
// // 	//See if this will conflict with Robot
    public static VictorSP slowmotor = new VictorSP(RobotMap.SLOW_MOTOR_PORT);
    
    public static void opperate(double speed) {
        slowmotor.set(-speed);
    }
    
    //   public void initDefaultCommand() {
    //       setDefaultCommand(Load(0));
    // }
    

    @Override
    public void setDefaultCommand(Command load) {
        slowmotor.set(0);
    }

}

