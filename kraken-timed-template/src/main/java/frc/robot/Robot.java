package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.configs.TalonFXConfigurator;
import com.ctre.phoenix6.hardware.TalonFX;


public class Robot extends TimedRobot {
  private TalonFX motor1;
  public Robot() {
   motor1 = new TalonFX();
  }

  @Override
  public void teleopInit() {

  }

  @Override
  public void teleopPeriodic() {
    motor1.set(0.6);
  }
}
