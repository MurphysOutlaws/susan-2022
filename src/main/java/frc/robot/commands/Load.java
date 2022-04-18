// // Copyright (c) FIRST and other WPILib contributors.
// // Open Source Software; you can modify and/or share it under the terms of
// // the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Loader;
import edu.wpi.first.wpilibj.motorcontrol.VictorSP;
import frc.robot.Constants;
import frc.robot.RobotMap;

  public class Load extends CommandBase {
    public Load (Loader loader){
      addRequirements(loader);
    }


  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    Loader.go(0);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    Loader.go(Constants.LOAD_SPEED);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    Loader.go(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
