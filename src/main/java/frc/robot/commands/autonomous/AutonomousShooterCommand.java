// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.autonomous;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.ShooterSubsystem;

public class AutonomousShooterCommand extends CommandBase {
  private ShooterSubsystem shooterSubsystem;
  /** Creates a new AutonomousShooterCommand. */
  public AutonomousShooterCommand(ShooterSubsystem shooterSubsystem) {
    this.shooterSubsystem = shooterSubsystem;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(this.shooterSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    this.shooterSubsystem.setAutonomousSpeed(Constants.shooterDirectSpeed);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    this.shooterSubsystem.setAutonomousSpeed(0.0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
