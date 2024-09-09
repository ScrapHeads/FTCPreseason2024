package org.firstinspires.ftc.teamcode.Subsystems;

import static org.firstinspires.ftc.teamcode.Constants.*;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.arcrobotics.ftclib.command.Command;
import com.arcrobotics.ftclib.command.Subsystem;
import com.arcrobotics.ftclib.command.SubsystemBase;
import com.arcrobotics.ftclib.hardware.motors.MotorEx;
import com.arcrobotics.ftclib.util.MathUtils;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import kotlin.collections.builders.SetBuilder;

public class Arm extends SubsystemBase {
    private final MotorEx armMotor;

    public Arm() {
        this.armMotor = new MotorEx(hm, "arm");
    }

    @Override
    public void periodic() {

    }

    public void moveArm(double power) {
        power = MathUtils.clamp(power, -1, 1);

        this.armMotor.set(power);
    }

    public Command moveArmCommand(double power) {
        Arm arm = this;
        return new Command() {
            @Override
            public Set<Subsystem> getRequirements() {
                Set<Subsystem> set = new HashSet<Subsystem>();
                set.add(arm);
                return set;
            }

            @Override
            public void initialize() {
                moveArm(power);
            }

            @Override
            public void end(boolean isInterrupted) {
                moveArm(0);
            }
        };
    }
}
