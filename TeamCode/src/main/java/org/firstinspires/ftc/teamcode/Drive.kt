package org.firstinspires.ftc.teamcode

import  com.qualcomm.robotcore.eventloop.opmode.LinearOpMode
import com.qualcomm.robotcore.eventloop.opmode.TeleOp
import org.firstinspires.ftc.teamcode.hardware.Hardware

@TeleOp(name = "Drive")
class Drive : LinearOpMode() {
    override fun runOpMode() {
        var hwmap = Hardware(this)
        waitForStart()

        while (opModeIsActive() && !isStopRequested) {
            //set variables to controller
            var drive = -(gamepad1.left_stick_y).toDouble() //aka forward
            var strafe =
                (gamepad1.left_stick_x * 1.1).toDouble() //aka sideways //try *1.1 to counteract strafing
            var turn = (gamepad1.right_stick_x).toDouble()

            //send to drive function that is still here lmao
            hwmap.driveRobot(drive, strafe, turn)

            //arm servo stuff (is our arm servo based?)
            if (gamepad1.y) {
                hwmap.testservo()
                telemetry.addData("Servo OPEN", 1)
            }
            if (gamepad1.a) {
                hwmap.servoreset()
                telemetry.addData("Servo CLOSED", 0)
            }
            if (gamepad1.x) {
                hwmap.test()
            }

            if (gamepad2.y) {
                hwmap.arm(3)
            }

            if (gamepad2.a || gamepad2.b) {
                hwmap.arm(2)
            }

            if (gamepad2.x) {
                hwmap.arm(1)
            }
        }

    }
}