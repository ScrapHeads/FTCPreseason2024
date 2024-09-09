package org.firstinspires.ftc.teamcode;

import com.arcrobotics.ftclib.command.CommandOpMode;
import com.arcrobotics.ftclib.command.CommandScheduler;
import com.arcrobotics.ftclib.command.InstantCommand;
import com.arcrobotics.ftclib.command.button.Trigger;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.gamepad.GamepadKeys;
import com.arcrobotics.ftclib.gamepad.TriggerReader;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import static org.firstinspires.ftc.teamcode.Constants.*;

import org.firstinspires.ftc.teamcode.Commands.driveContinous;
import org.firstinspires.ftc.teamcode.Commands.moveArm;
import org.firstinspires.ftc.teamcode.Commands.moveClaw;
import org.firstinspires.ftc.teamcode.Subsystems.Arm;
import org.firstinspires.ftc.teamcode.Subsystems.Claw;
import org.firstinspires.ftc.teamcode.Subsystems.Drivetrain;

@TeleOp(group = "Scrapheads", name = "TestTeleOp")
public class TestTeleOP extends CommandOpMode {
    GamepadEx driver = null;
    Drivetrain drivetrain = null;
    Arm arm = null;
    Claw claw = null;

    private enum clawMode {
        CLOSED,
        OPEN
    }

    private clawMode currentClawMode = clawMode.OPEN;

    @Override
    public void initialize() {
        tele = telemetry;
        hm = hardwareMap;

        driver = new GamepadEx(gamepad1);

        drivetrain = new Drivetrain();
        drivetrain.register();

//        arm = new Arm();

//        claw = new Claw();

        // TODO: Dashboard
        // TODO: Finish Servo
//        SimpleServo leftClawServo = new SimpleServo(hardwareMap, "clawLeft", 0, 180);

        registerControls();
    }

    private void registerControls() {
        drivetrain.setDefaultCommand(new driveContinous(drivetrain, driver));

//        driver.getGamepadButton(GamepadKeys.Button.Y).whileHeld(new moveArm(arm, .4));
//        driver.getGamepadButton(GamepadKeys.Button.A).whileHeld(new moveArm(arm, -.4));

//        new Trigger(
//                () -> new TriggerReader(driver, GamepadKeys.Trigger.LEFT_TRIGGER).isDown()
//        ).whenActive(new moveClaw(claw, 160));

//        driver.getGamepadButton(GamepadKeys.Button.X).whenPressed(new moveClaw(claw, 180));
//        driver.getGamepadButton(GamepadKeys.Button.B).whenPressed(new moveClaw(claw, 180));

//        driver.getGamepadButton(GamepadKeys.Button.X).whenPressed(new InstantCommand(this::changeClawMode));
//
//        new Trigger(() -> currentClawMode == clawMode.OPEN).whileActiveOnce(new moveClaw(claw, 180));
//        new Trigger(() -> currentClawMode == clawMode.CLOSED).whileActiveOnce(new moveClaw(claw, 0));

    }

    private void changeClawMode() {
        if (currentClawMode == clawMode.OPEN) {
            currentClawMode = clawMode.CLOSED;
        } else {
            currentClawMode = clawMode.OPEN;
        }
    }

    @Override
    public void run() {
        CommandScheduler.getInstance().run();

        updateTelemetry(telemetry);
    }
}
