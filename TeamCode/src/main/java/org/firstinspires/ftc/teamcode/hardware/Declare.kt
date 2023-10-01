package org.firstinspires.ftc.teamcode.hardware

import com.qualcomm.robotcore.hardware.DcMotor
import org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.hardwareMap
import org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.gamepad1

public class Declare {

        //motors
//        public val frontLeftMotor = hardwareMap.dcMotor["frontLeftMotor"]
//        public val frontRightMotor = hardwareMap.dcMotor["frontRightMotor"]
//        public val backLeftMotor = hardwareMap.dcMotor["backLeftMotor"]
//        public val backRightMotor = hardwareMap.dcMotor["backRightMotor"]

//    public val frontLeftMotor = hardwareMap.get(DcMotor::class.java, "left_drive")
//    public val frontRightMotor = hardwareMap.get(DcMotor::class.java, "right_drive")
//
//        //gamepad
//        public var drive = gamepad1.left_stick_x
//        public var strafe = gamepad1.left_stick_x
//        public var turn = gamepad1.right_stick_x

    companion object {
        // motors
        val frontLeftMotor = hardwareMap.get(DcMotor::class.java, "left_drive")
        val frontRightMotor = hardwareMap.get(DcMotor::class.java, "right_drive")
        val backLeftMotor = hardwareMap.dcMotor["backLeftMotor"]
        val backRightMotor = hardwareMap.dcMotor["backRightMotor"]

        //game pad
        var drive = gamepad1.left_stick_x
        var strafe = gamepad1.left_stick_x
        var turn = gamepad1.right_stick_x
    }
}
