package org.firstinspires.ftc.teamcode

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode
import com.qualcomm.robotcore.eventloop.opmode.TeleOp
import org.firstinspires.ftc.teamcode.hardware.Hardware

@TeleOp(name = "Drive")
class Drive : LinearOpMode() {

    //do this to access the "Hardware" class
    private var hwmap = Hardware(this)

    override fun runOpMode() {
        hwmap.init()
        waitForStart()
        while (opModeIsActive()&&!isStopRequested) {
            //set variables to controller
            var drive = -(gamepad1.left_stick_y).toDouble() //aka forward
            var strafe = (gamepad1.left_stick_x).toDouble() //aka sideways
            var turn = (gamepad1.right_stick_x).toDouble()

            //update telemetry
            telemetry.addData("Drive", drive)
            telemetry.addData("Strafe", strafe)
            telemetry.addData("Turn", turn)

            //send to motors
            hwmap.driveRobot(drive, strafe, turn)
        }
    }

}
