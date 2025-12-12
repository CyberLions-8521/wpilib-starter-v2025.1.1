package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.configs.TalonFXConfigurator;
import com.ctre.phoenix6.hardware.TalonFX;


public class Robot extends TimedRobot {
  TalonFX m-motor;

  public Robot() {
   m-motor = new TalonFX(3);
  }

  @Override
  public void teleopInit() {

  }

  @Override
  public void teleopPeriodic() {
  m-motor.set(.5);

  }
}
