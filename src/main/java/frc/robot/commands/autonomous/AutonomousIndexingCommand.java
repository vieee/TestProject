// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.autonomous;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.IndexingSubsystem;

public class AutonomousIndexingCommand extends CommandBase {
  private IndexingSubsystem indexingSubsystem;

  /** Creates a new AutonomousIndexingCommand. */
  public AutonomousIndexingCommand(IndexingSubsystem indexingSubsystem) {
    this.indexingSubsystem = indexingSubsystem;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(this.indexingSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    this.indexingSubsystem.setAutonomousSpeed(Constants.indexingSpeedMax);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    this.indexingSubsystem.setAutonomousSpeed(0.0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
