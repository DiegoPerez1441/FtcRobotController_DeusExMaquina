package org.firstinspires.ftc.teamcode.subsystem;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.util.Hardware;

public class MecanumDrivetrain {

    // Motors
    private DcMotor frontLeftMotor = null;
    private DcMotor backLeftMotor = null;
    private DcMotor frontRightMotor = null;
    private DcMotor backRightMotor = null;

    // Constants
    private static final double STRAFING_SENSIBILITY = 1.5;

    // Constructor
    public MecanumDrivetrain() {

    }

    public void init(HardwareMap hwMap) {
        /*
         * Motors
         * */

        this.frontLeftMotor = hwMap.get(DcMotor.class, "frontLeftMotor");
        this.backLeftMotor = hwMap.get(DcMotor.class, "backLeftMotor");
        this.frontRightMotor = hwMap.get(DcMotor.class, "frontRightMotor");
        this.backRightMotor = hwMap.get(DcMotor.class, "backRightMotor");

    }

    public void runTeleOp(Gamepad g1, Gamepad gp2) {
        //========================================
        // MECANUM DRIVETRAIN
        //========================================

        double y = -g1.left_stick_y;                          // This is reversed
        double x = g1.left_stick_x * STRAFING_SENSIBILITY;    // Counteract strafing imperfections
        double rx = g1.right_stick_x;                         // Strafing

        double frontLeftPower = y + x + rx;
        double backLeftPower = y - x + rx;
        double frontRightPower = y - x - rx;
        double backRightPower = y + x - rx;

        // Scale values in between -1.0 and 1.0 to prevent the clipping of values in order to maintain the driving ratio
        if (Math.abs(frontLeftPower) > 1 || Math.abs(backLeftPower) > 1 ||
                Math.abs(frontRightPower) > 1 || Math.abs(backRightPower) > 1 ) {

            // Find the largest value
            double max = 0;
            max = Math.max(Math.abs(frontLeftPower), Math.abs(backLeftPower));
            max = Math.max(Math.abs(frontRightPower), max);
            max = Math.max(Math.abs(backRightPower), max);

            // Divide everything by max (it's positive so we don't need to worry about signs)
            frontLeftPower /= max;
            backLeftPower /= max;
            frontRightPower /= max;
            backRightPower /= max;
        }

        // Update Drivetrain
        this.frontLeftMotor.setPower(frontLeftPower);
        this.backLeftMotor.setPower(backLeftPower);
        this.frontRightMotor.setPower(frontRightPower);
        this.backRightMotor.setPower(backRightPower);
    }


}
