package org.firstinspires.ftc.teamcode

import org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.hardwareMap


class DeclareMotors {
    val frontLeftMotor = hardwareMap.dcMotor["frontLeftMotor"]
    val frontRightMotor = hardwareMap.dcMotor["frontRightMotor"]
    val backLeftMotor = hardwareMap.dcMotor["backLeftMotor"]
    val backRightMotor = hardwareMap.dcMotor["backRightMotor"]
}