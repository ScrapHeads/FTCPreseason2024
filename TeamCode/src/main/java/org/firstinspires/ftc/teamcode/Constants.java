package org.firstinspires.ftc.teamcode;

import com.qualcomm.hardware.rev.RevHubOrientationOnRobot;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.IMU;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.AxesOrder;
import org.firstinspires.ftc.robotcore.external.navigation.AxesReference;
import org.firstinspires.ftc.robotcore.external.navigation.Orientation;

public class Constants {
    public static Telemetry tele;
    public static HardwareMap hm;

    public static class drivetrainConstants {
        public static final Orientation orientation =
                new Orientation(AxesReference.INTRINSIC,
                        AxesOrder.ZYX,
                        AngleUnit.DEGREES,
                        90, 0, 0, 0);
        public static final RevHubOrientationOnRobot orientationOnRobot = new RevHubOrientationOnRobot(orientation);
        public static final IMU.Parameters parameters = new IMU.Parameters(orientationOnRobot);
    }
}
