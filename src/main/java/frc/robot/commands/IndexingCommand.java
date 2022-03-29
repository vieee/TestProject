// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.RobotContainer;
import frc.robot.subsystems.IndexingSubsystem;

public class IndexingCommand extends CommandBase {
  public IndexingSubsystem indexingSubsystem;
  /** Creates a new IndexingCommand. */
  public IndexingCommand(IndexingSubsystem indexingSubsystem) {
    this.indexingSubsystem = indexingSubsystem;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(this.indexingSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {}

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    this.indexingSubsystem.setSpeed();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return !RobotContainer.joyDriving.getRawButton(Constants.indexingButton_JoyDriving_5);
  }
}
