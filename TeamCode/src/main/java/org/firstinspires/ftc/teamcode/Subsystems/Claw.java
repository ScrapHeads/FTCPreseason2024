package org.firstinspires.ftc.teamcode.Subsystems;

import static org.firstinspires.ftc.teamcode.Constants.*;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.arcrobotics.ftclib.hardware.ServoEx;
import com.arcrobotics.ftclib.hardware.SimpleServo;
import com.arcrobotics.ftclib.util.MathUtils;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;

public class Claw extends SubsystemBase {
    private final ServoEx leftClaw;
    private final ServoEx rightClaw;

    public Claw() {
        this.leftClaw = new SimpleServo(hm, "leftclaw", 0, 180, AngleUnit.DEGREES);
        this.rightClaw = new SimpleServo(hm, "rightclaw", 0, 180, AngleUnit.DEGREES);
    }

    @Override
    public void periodic() {

    }

    public void moveClaw(double pos) {
        pos = MathUtils.clamp(pos, 0, 180);

        this.leftClaw.setPosition(pos);
        this.rightClaw.setPosition(pos);
    }
}
