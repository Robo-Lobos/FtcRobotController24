package org.firstinspires.ftc.teamcode.hardware

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode
import com.qualcomm.robotcore.hardware.DcMotor
import org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.gamepad1
import org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.hardwareMap
import kotlin.math.abs
import kotlin.math.max


public class Customhwmap: LinearOpMode() {

        override fun runOpMode() {

                // motors
                var frontLeftMotor: DcMotor =
                        hardwareMap.dcMotor.get("left_drive")     // get(DcMotor::class.java, "left_drive")
                var frontRightMotor: DcMotor =
                        hardwareMap.dcMotor.get("right_drive")  //get(DcMotor::class.java, "right_drive") //this may need to be set to direction.negative
                var backLeftMotor: DcMotor = hardwareMap.dcMotor.get("backLeftMotor")
                var backRightMotor: DcMotor =
                        hardwareMap.dcMotor.get("backRightMotor") //this many need to be set to direction.negative

                //game pad
                //some of these values may need to be negative
                //fix strafing with constant?
                var drive = -(gamepad1.left_stick_y).toDouble() //aka forward
                var strafe = (gamepad1.left_stick_x).toDouble() //aka sideways
                var turn = (gamepad1.right_stick_x).toDouble()
                var one = (1).toDouble()
                // makes sure power is never >1, will scale all values down if >1
                var drivescale = max(abs(drive) + abs(strafe) + abs(turn), one)
        }
}
