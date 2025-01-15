// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;

/* You should consider using the more terse Command factories API instead https://docs.wpilib.org/en/stable/docs/software/commandbased/organizing-command-based.html#defining-commands */
public class ArcadeDriveCommand extends Command {
  /** Creates a new ArcadeDriveCommand. */
  private Drivebase m_db;
  private Supplier<Double> xSpeed;
  private Supplier<Double> ySpeed;

  public ArcadeDriveCommand(Drivebase db, Supplier<Double> xSpeed, Supplier<Double> ySpeed) {
    // Use addRequirements() here to declare subsystem dependencies.
    m_db = db;
    this.xSpeed = xSpeed;
    this.ySpeed = ySpeed;
    this.addRequirements(db);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_db.arcadeDrive(xSpeed.get(), ySpeed.get());
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
