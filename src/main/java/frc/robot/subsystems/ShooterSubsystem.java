// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ShooterSubsystem extends SubsystemBase {
  private CANSparkMax lowerWheels;
  private CANSparkMax upperWheelsLeft;
  private CANSparkMax upperWheelsRight;

  private MotorControllerGroup upperWheels;

  /** Creates a new ShooterSubsystem. */
  public ShooterSubsystem() {
    this.lowerWheels = new CANSparkMax(10, MotorType.kBrushless);

    this.upperWheelsLeft = new CANSparkMax(11, MotorType.kBrushless);
    this.upperWheelsRight = new CANSparkMax(12, MotorType.kBrushless);
    this.upperWheels = new MotorControllerGroup(this.upperWheelsLeft, this.upperWheelsRight);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void setSpeeds(double speed) {
    this.lowerWheels.set(speed);
    this.upperWheels.set(speed);
  }
}
