// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.commands.DriveCommand;
import frc.robot.commands.IndexingCommand;
import frc.robot.commands.IntakeCommand;
import frc.robot.commands.IntakeOpeningCommand;
import frc.robot.commands.ShooterDirectCommand;
import frc.robot.commands.ShooterFarawayCommand;
import frc.robot.commands.autonomous.AutonomousParallelGroupCommand;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.IndexingSubsystem;
import frc.robot.subsystems.IntakeSubsystem;
import frc.robot.subsystems.ShooterSubsystem;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

/**
 * This class is where the bulk of the robot should be declared. Since
 * Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in
 * the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of
 * the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private DriveSubsystem driveSubsystem;
  private IntakeSubsystem intakeSubsystem;
  private IndexingSubsystem indexingSubsystem;
  private ShooterSubsystem shooterSubsystem;

  public static Joystick joyDriving;

  /**
   * The container for the robot. Contains subsystems, OI devices, and commands.
   */
  // () -> {}
  public RobotContainer() {
    RobotContainer.joyDriving = new Joystick(0);

    this.driveSubsystem = new DriveSubsystem();
    this.intakeSubsystem = new IntakeSubsystem();
    this.indexingSubsystem = new IndexingSubsystem();
    this.shooterSubsystem = new ShooterSubsystem();

    this.driveSubsystem.setDefaultCommand(
        new DriveCommand(this.driveSubsystem, () -> joyDriving.getRawAxis(1), () -> joyDriving.getRawAxis(4)));

    this.intakeSubsystem.setDefaultCommand(
        new IntakeOpeningCommand(this.intakeSubsystem, () -> joyDriving.getRawAxis(5)));
    // Configure the button bindings
    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be
   * created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing
   * it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    // Intake Button Binding
    new JoystickButton(RobotContainer.joyDriving, Constants.intakeButton_JoyDriving_4)
        .toggleWhenActive(new IntakeCommand(this.intakeSubsystem));

    // Indexing Button Binding
    new JoystickButton(RobotContainer.joyDriving, Constants.indexingButton_JoyDriving_5)
        .toggleWhenActive(new IndexingCommand(this.indexingSubsystem));

    // Shooter Direct Speed Binding
    new JoystickButton(RobotContainer.joyDriving, Constants.shootingButton_JoyDriving_6)
        .whenActive(new ShooterDirectCommand(this.shooterSubsystem));

    // Shooter Faraway Speed Binding
    new JoystickButton(RobotContainer.joyDriving, Constants.shootingFarawayButton_JoyDriving_7)
        .whenActive(new ShooterFarawayCommand(this.shooterSubsystem));
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return new AutonomousParallelGroupCommand(this.shooterSubsystem, this.driveSubsystem, this.indexingSubsystem);
  }

}
