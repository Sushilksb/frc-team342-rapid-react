// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.climb;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ClimbSubsystem;
import frc.robot.subsystems.IntakeSubsystem;

public class TurnOnClimbMode extends CommandBase {
  /** Creates a new TurnOnClimbMode. */
  private ClimbSubsystem climb;
  private IntakeSubsystem intake;

  public TurnOnClimbMode(ClimbSubsystem climb, IntakeSubsystem intake) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.climb = climb;
    this.intake = intake;

    addRequirements(intake);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    climb.toggleClimbMode();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if (climb.getClimbMode()) {
      intake.deployIntake();
    }
    else {
      intake.retractIntake();
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    // since it is toggle when pressed
    climb.toggleClimbMode();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
