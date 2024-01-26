package org.firstinspires.ftc.teamcode.hardware

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode
import com.qualcomm.robotcore.hardware.DcMotor
import com.qualcomm.robotcore.hardware.DcMotorEx
import com.qualcomm.robotcore.hardware.DcMotorSimple
import com.qualcomm.robotcore.hardware.Servo
import java.lang.Double.max
import kotlin.math.abs
import kotlin.math.atan2
import kotlin.math.cos
import kotlin.math.hypot
import kotlin.math.sin

open class Hardware(private var opMode: LinearOpMode) {


    //.\adb connect 192.168.43.1:5555


    //declare global objects
    private var myOpMode: LinearOpMode = opMode
    private var frontLeftMotor: DcMotor
    private var backLeftMotor: DcMotor
    private var frontRightMotor: DcMotor
    private var backRightMotor: DcMotor
    private var armBeltMotor: DcMotorEx
    private var armServo: Servo

    init {
        myOpMode = opMode
        //initialize motors
        frontLeftMotor = myOpMode.hardwareMap.dcMotor.get("motor0")
        backLeftMotor = myOpMode.hardwareMap.dcMotor.get("motor1") //S
        frontRightMotor = myOpMode.hardwareMap.dcMotor.get("motor2") //S
        backRightMotor = myOpMode.hardwareMap.dcMotor.get("motor3")
        armBeltMotor = myOpMode.hardwareMap.dcMotor.get("motor0b") as DcMotorEx

        frontLeftMotor.mode = DcMotor.RunMode.RUN_USING_ENCODER
        backLeftMotor.mode = DcMotor.RunMode.RUN_USING_ENCODER
        frontRightMotor.mode = DcMotor.RunMode.RUN_USING_ENCODER
        backRightMotor.mode = DcMotor.RunMode.RUN_USING_ENCODER
        armBeltMotor.mode = DcMotor.RunMode.RUN_TO_POSITION

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

    //open claw servo
    fun testservo(){
        armServo.direction = Servo.Direction.FORWARD
        armServo.position = 0.18 //DO NOT CHANGE
        myOpMode.telemetry.addData("Servo Position", armServo.position)
    }

    //close claw servo
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

    fun autoarm(){
        //fun code
    }

    fun arm(height: Int){
        when(height) {
            1 -> {
                armBeltMotor.power = 0.5
                armBeltMotor.targetPosition = 0
                //lowest height
            }

            2 -> {
                armBeltMotor.power = 0.5
                armBeltMotor.targetPosition = 0
                //medium height
            }

            3 -> {
                armBeltMotor.power = 0.5
                armBeltMotor.targetPosition = 0
                //tallest height
            }
        }
    }
}


