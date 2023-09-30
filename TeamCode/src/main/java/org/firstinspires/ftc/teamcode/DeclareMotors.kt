package org.firstinspires.ftc.teamcode

import org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.hardwareMap
import org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.gamepad1

class DeclareMotors {
    fun main() {
        //motors
        val frontLeftMotor = hardwareMap.dcMotor["frontLeftMotor"]
        val frontRightMotor = hardwareMap.dcMotor["frontRightMotor"]
        val backLeftMotor = hardwareMap.dcMotor["backLeftMotor"]
        val backRightMotor = hardwareMap.dcMotor["backRightMotor"]

        //gamepad
        var drive = gamepad1.left_stick_x
        var strafe = gamepad1.left_stick_x
        var turn = gamepad1.right_stick_x
    }
}