package org.firstinspires.ftc.teamcode.hardware

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode
import com.qualcomm.robotcore.hardware.DcMotor
import com.qualcomm.robotcore.hardware.DcMotorSimple
import com.qualcomm.robotcore.hardware.Servo
import java.lang.Double.max
import kotlin.math.abs
import kotlin.math.atan2
import kotlin.math.cos
import kotlin.math.hypot
import kotlin.math.sin

open class Hardware(private var opMode: LinearOpMode) {

    //declare global objects
    private var myOpMode: LinearOpMode = opMode
    private var frontLeftMotor: DcMotor
    private var backLeftMotor: DcMotor
    private var frontRightMotor: DcMotor
    private var backRightMotor: DcMotor
    private var armServo: Servo

    init {
        myOpMode = opMode
        //initialize motors
        frontLeftMotor = myOpMode.hardwareMap.dcMotor.get("motor0")
        backLeftMotor = myOpMode.hardwareMap.dcMotor.get("motor1")
        frontRightMotor = myOpMode.hardwareMap.dcMotor.get("motor2")
        backRightMotor = myOpMode.hardwareMap.dcMotor.get("motor3")

        //servos
        armServo = myOpMode.hardwareMap.servo.get("servo0")
        armServo.scaleRange(0.0,0.75) //DO NOT CHANGE

        //reverse as needed (this may need to be the left wheels rather than the right)
        frontRightMotor.direction = (DcMotorSimple.Direction.REVERSE)
        backRightMotor.direction = (DcMotorSimple.Direction.REVERSE)

        //update telemetry
        val message = "Hardware Initialized"
        myOpMode.telemetry.addData(">", message)
        myOpMode.telemetry.update()
    }

    fun driveRobot(drive: Double, strafe: Double, turn: Double) {
        //magic of trig
        val theta = atan2(drive, strafe)
        val power = hypot(strafe, drive)

        val sin = sin(theta - Math.PI/4)
        val cos = cos(theta - Math.PI/4)
        val max = max(abs(sin), abs(cos))

        //omnidirectional wheel math
        var flp = power * cos/max + turn
        var frp = power * sin/max - turn
        var blp = power * sin/max + turn
        var brp = power * cos/max - turn

        if(power + abs(turn) >1){
            flp /= power + turn
            frp /= power + turn
            blp /= power + turn
            brp /= power + turn
        }

        //send values to motors
        frontLeftMotor.power = flp
        frontRightMotor.power = frp
        backLeftMotor.power = blp
        backRightMotor.power = brp

        //update telemetry
        myOpMode.telemetry.addData("Drive", drive)
        myOpMode.telemetry.addData("Strafe", strafe)
        myOpMode.telemetry.addData("Turn", turn)
        myOpMode.telemetry.update()
    }

    /**create two arm functions??
    one for opmode, one for teleop?
    *op mode arm function has multiple heights?*/

    fun testservo(){
        armServo.direction = Servo.Direction.FORWARD
        armServo.position = 0.18 //DO NOT CHANGE
        myOpMode.telemetry.addData("Servo Position", armServo.position)
    }

    fun servoreset(){
        armServo.direction = Servo.Direction.REVERSE
        armServo.position = 0.07 //DO NOT CHANGE
        myOpMode.telemetry.addData("Servo Position", armServo.position)
    }

    fun test(){
        testservo()
        myOpMode.sleep(1000)
        servoreset()
    }
}

