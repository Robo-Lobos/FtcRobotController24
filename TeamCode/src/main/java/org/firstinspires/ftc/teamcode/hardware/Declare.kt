package org.firstinspires.ftc.teamcode.hardware

import com.qualcomm.robotcore.hardware.DcMotor
import org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.hardwareMap
import org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.gamepad1
import kotlin.math.abs
import kotlin.math.max

public class  Declare {
    companion object {
        // motors
        val frontLeftMotor = hardwareMap.get(DcMotor::class.java, "left_drive")
        val frontRightMotor = hardwareMap.get(DcMotor::class.java, "right_drive") //this may need to be set to direction.negative
        val backLeftMotor = hardwareMap.dcMotor["backLeftMotor"]
        val backRightMotor = hardwareMap.dcMotor["backRightMotor"] //this many need to be set to direction.negative

        //game pad
        //some of these values may need to be negative
        //fix strafing with constant?
        var drive = -(gamepad1.left_stick_y).toDouble() //aka forward
        var strafe = (gamepad1.left_stick_x).toDouble() //aka sideways
        var turn = (gamepad1.right_stick_x).toDouble()
        private var one = (1).toDouble()
        // makes sure power is never >1, will scale all values down if >1
        var drivescale = max(abs(drive) + abs(strafe) + abs(turn), one)
    }
}
