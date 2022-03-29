// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class IndexingSubsystem extends SubsystemBase {
  private CANSparkMax indexing;
  /** Creates a new IndexingSubsystem. */
  public IndexingSubsystem() {
    this.indexing = new CANSparkMax(4, MotorType.kBrushless);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void setSpeed() {
    // 0.1 -> 0.4
    // > 0.1 -> 0.0

    double currentSpeed = this.indexing.get();
    if (currentSpeed > Constants.indexingSpeedDeadband) {
      // The Motor is Moving
      this.indexing.set(0.0);
    } else {
      // The Motor was not moving
      double now = Timer.getFPGATimestamp();
      while (now < 0.6) {
        if (now < 0.2)
          this.indexing.set(Constants.indexingSpeedMax / 3);
        else if (now < 0.4)
          this.indexing.set(Constants.indexingSpeedMax / 2);
      }
      this.indexing.set(Constants.indexingSpeedMax);
    }

  }
}
