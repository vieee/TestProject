// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class ShooterSubsystem extends SubsystemBase {
  private CANSparkMax shooter;

  /** Creates a new ShooterSubsystem. */
  public ShooterSubsystem() {
    this.shooter = new CANSparkMax(10, MotorType.kBrushless);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void setSpeeds(double speed) {
    double currentSpeed = this.shooter.get();
    if (currentSpeed > Constants.shooterSpeedDeadband) {
      // The Motor is Moving
      this.shooter.set(0.0);
    } else {
      // The Motor was not moving
      double now = Timer.getFPGATimestamp();
      while (now < 0.6) {
        if (now < 0.2)
          this.shooter.set(Constants.intakeSpeedMax / 3);
        else if (now < 0.4)
          this.shooter.set(Constants.intakeSpeedMax / 2);
      }
      this.shooter.set(Constants.intakeSpeedMax);
    }
  }

  public void setAutonomousSpeed(double speed) {
    this.shooter.set(speed);
  }
}
