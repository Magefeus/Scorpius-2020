package frc.robot;

import com.revrobotics.CANSparkMax;
import com.revrobotics.SparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Robot extends TimedRobot {

  CANSparkMax left1 = new CANSparkMax(1, MotorType.kBrushless);
  CANSparkMax left2 = new CANSparkMax(2, MotorType.kBrushless);
  CANSparkMax right1 = new CANSparkMax(3, MotorType.kBrushless);
  CANSparkMax right2 = new CANSparkMax(4, MotorType.kBrushless);

  SpeedControllerGroup left = new SpeedControllerGroup(left1, left2);
  SpeedControllerGroup right = new  SpeedControllerGroup(right1, right2);
  DifferentialDrive mainDrive = new DifferentialDrive(left, right);
  
  Joystick joy1 = new Joystick(0);

  @Override
  public void robotInit() {
    mainDrive.setSafetyEnabled(false);
    
  }

 
  @Override
  public void robotPeriodic() {
  }

  
  @Override
  public void autonomousInit() {

  }

  @Override
  public void autonomousPeriodic() {

  }

  @Override
  public void teleopPeriodic() {
    double y = joy1.getRawAxis(1);
		double zrot = -joy1.getRawAxis(2);
		if(Math.abs(y) >= 0.2 || Math.abs(zrot) >= 0.2) {
			mainDrive.arcadeDrive(y, (zrot/1.5));
		} else {
			mainDrive.arcadeDrive(0, 0);
  	}
  }

  @Override
  public void testPeriodic() {

  }
}
