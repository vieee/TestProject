// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import java.util.function.Supplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveSubsystem;


public class DriveCommand extends CommandBase {
  private DriveSubsystem driveSubsystem;
  private Supplier<Double> speedAxis, turnAxis;
  /** Creates a new DriveCommand. */
  public DriveCommand(DriveSubsystem driveSubsystem, Supplier<Double> speedAxis, Supplier<Double> turnAxis) {
    this.driveSubsystem = driveSubsystem;
    this.speedAxis = speedAxis;
    this.turnAxis = turnAxis;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(this.driveSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double currentSpeedValue = this.speedAxis.get();
    double currentTurnValue = this.turnAxis.get();

    // Check Deadband
    currentSpeedValue = (Math.abs(currentSpeedValue) > 0.05) ? currentSpeedValue : 0;
    currentTurnValue = (Math.abs(currentTurnValue) > 0.05) ? currentTurnValue : 0;

    this.driveSubsystem.arcadeDriveInbuilt(currentSpeedValue, currentTurnValue);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
