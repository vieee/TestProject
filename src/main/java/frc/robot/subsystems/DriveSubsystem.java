// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DriveSubsystem extends SubsystemBase {
  private CANSparkMax FL, FR;
  private MotorControllerGroup leftSide, rightSide;

  private DifferentialDrive driveTrain;

  /** Creates a new DriveSubsystem. */
  public DriveSubsystem() {
    this.FL = new CANSparkMax(1, MotorType.kBrushed); // 11
    this.FR = new CANSparkMax(2, MotorType.kBrushed); // 21

    this.leftSide = new MotorControllerGroup(this.FL);
    this.rightSide = new MotorControllerGroup(this.FR);

    this.rightSide.setInverted(true);
    this.leftSide.setInverted(false);

    this.driveTrain = new DifferentialDrive(this.leftSide, this.rightSide);
    this.driveTrain.setDeadband(0.05);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void arcadeDriveInbuilt(double speed, double turn) {
    this.driveTrain.arcadeDrive(Math.pow(speed, 3), Math.pow(turn, 3));
  }
}
