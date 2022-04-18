// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Loader;
import frc.robot.subsystems.Shooter;

public class NoSpeed extends CommandBase {

  private Shooter m_shooter;

  /** Creates a new Load. */
  public NoSpeed(Shooter shooter) {
    m_shooter = shooter;

    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(m_shooter);
  }


  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    Shooter.zeroSpeed();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    Shooter.zeroSpeed();
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    Shooter.zeroSpeed();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
