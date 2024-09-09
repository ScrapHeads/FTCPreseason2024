package org.firstinspires.ftc.teamcode.Subsystems;

import static org.firstinspires.ftc.teamcode.Constants.drivetrainConstants.parameters;
import static org.firstinspires.ftc.teamcode.Constants.*;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.arcrobotics.ftclib.drivebase.MecanumDrive;
import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.arcrobotics.ftclib.hardware.motors.MotorEx;
import com.qualcomm.robotcore.hardware.IMU;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.YawPitchRollAngles;


public class Drivetrain extends SubsystemBase {
    private final MotorEx[] Motors;
    private final MecanumDrive mecanumDrive;
    private final IMU gyro;

    public Drivetrain() {
        this.gyro = hm.get(IMU.class, "imu");
        this.gyro.initialize(parameters);
        this.gyro.resetYaw();

        this.Motors = new MotorEx[] {
                new MotorEx(hm, "leftFront", Motor.GoBILDA.RPM_312),
                new MotorEx(hm, "rightFront", Motor.GoBILDA.RPM_312),
                new MotorEx(hm, "leftBack", Motor.GoBILDA.RPM_312),
                new MotorEx(hm, "rightBack", Motor.GoBILDA.RPM_312)
        };

        this.Motors[0].setInverted(true);
        this.Motors[1].setInverted(false);
        this.Motors[2].setInverted(true);
        this.Motors[3].setInverted(false);

        this.mecanumDrive = new MecanumDrive(
                false,
                this.Motors[0],
                this.Motors[1],
                this.Motors[2],
                this.Motors[3]
        );
    }

    @Override
    public void periodic() {
        // This method will be called once per scheduler run
    }

    public void drive(double forward, double slide, double turn) {
        YawPitchRollAngles heading = gyro.getRobotYawPitchRollAngles();

        tele.addData("Yaw", "Yaw: " + heading.getYaw(AngleUnit.DEGREES));
        tele.addData("Pitch", "Pitch: " + heading.getPitch(AngleUnit.DEGREES));
        tele.addData("Roll", "Roll: " + heading.getRoll(AngleUnit.DEGREES));

        this.mecanumDrive.driveFieldCentric(slide, forward, turn, heading.getYaw(AngleUnit.DEGREES), true);
    }
}
