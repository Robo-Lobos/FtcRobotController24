
package org.firstinspires.ftc.teamcode

import com.qualcomm.robotcore.eventloop.opmode.Autonomous
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode
import com.qualcomm.robotcore.eventloop.opmode.TeleOp
import org.firstinspires.ftc.robotcore.external.hardware.camera.BuiltinCameraDirection
import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName
import org.firstinspires.ftc.teamcode.Trajectories.rrtraj.drive
import org.firstinspires.ftc.vision.VisionPortal
import org.firstinspires.ftc.vision.tfod.TfodProcessor

/*
 * This OpMode illustrates the basics of TensorFlow Object Detection,
 * including Java Builder structures for specifying Vision parameters.
 *
 * Use Android Studio to Copy this Class, and Paste it into your team's code folder with a new name.
 * Remove or comment out the @Disabled line to add this OpMode to the Driver Station OpMode list.
 */
@Autonomous(name = "detecttestkotlin")

class detecttestkotlin : LinearOpMode() {
    /**
     * The variable to store our instance of the TensorFlow Object Detection processor.
     */
    private var tfod: TfodProcessor? = null

    /**
     * The variable to store our instance of the vision portal.
     */
    private var visionPortal: VisionPortal? = null

    //init variable
    private var elementPosition: Int? = null

    override fun runOpMode() {
        initTfod()

        // Wait for the DS start button to be touched.
        telemetry.addData("DS preview on/off", "3 dots, Camera Stream")
        telemetry.addData(">", "Touch Play to start OpMode")
        telemetry.update()
        waitForStart()
        if (opModeIsActive()) {
            while (opModeIsActive()) {
                telemetryTfod()

                // Push telemetry to the Driver Station.
                telemetry.update()

                when (elementPosition) {
                    1 -> {
                        telemetry.addData("logic test", elementPosition)
                        drive.followTrajectory(Trajectories.rrtraj.common1)
                        //common traj, then specific traj for color/side
                    }
                    2 -> {
                        telemetry.addData("logic test", elementPosition)
                        drive.followTrajectory(Trajectories.rrtraj.common2)
                        //seperate teleop functions by color and side for easy driver use
                    }
                    3 -> {
                        telemetry.addData("logic test", elementPosition)
                        drive.followTrajectory(Trajectories.rrtraj.common3)
                    }
                    else -> {
                        //share the CPU.
                        sleep(20)
                    }
                }
            }
        }

        // Save more CPU resources when camera is no longer needed.
        visionPortal!!.close()
    } // end runOpMode()

    /**
     * Initialize the TensorFlow Object Detection processor.
     */
    private fun initTfod() {

        // Create the TensorFlow processor by using a builder.
        tfod =
            TfodProcessor.Builder() // With the following lines commented out, the default TfodProcessor Builder
                // will load the default model for the season. To define a custom model to load, 
                // choose one of the following:
                //Use setModelAssetName() if the custom TF Model is built in as an asset (AS only).
                //Use setModelFileName() if you have downloaded a custom team model to the Robot Controller.
                .setModelAssetName(TFOD_MODEL_ASSET) //.setModelFileName(TFOD_MODEL_FILE)
                // The following default settings are available to un-comment and edit as needed to 
                // set parameters for custom models.
                //.setModelLabels(LABELS)
                //.setIsModelTensorFlow2(true)
                //.setIsModelQuantized(true)
                //.setModelInputSize(300)
                //.setModelAspectRatio(16.0 / 9.0)
                .build()

        // Create the vision portal by using a builder.
        val builder = VisionPortal.Builder()

        // Set the camera (webcam vs. built-in RC phone camera).
        if (USE_WEBCAM) {
            builder.setCamera(hardwareMap.get(WebcamName::class.java, "Webcam 1"))
        } else {
            builder.setCamera(BuiltinCameraDirection.BACK)
        }

        // Choose a camera resolution. Not all cameras support all resolutions.
        //builder.setCameraResolution(new Size(640, 480));

        // Enable the RC preview (LiveView).  Set "false" to omit camera monitoring.
        //builder.enableLiveView(true);

        // Set the stream format; MJPEG uses less bandwidth than default YUY2.
        //builder.setStreamFormat(VisionPortal.StreamFormat.YUY2);

        // Choose whether or not LiveView stops if no processors are enabled.
        // If set "true", monitor shows solid orange screen if no processors enabled.
        // If set "false", monitor shows camera view without annotations.
        //builder.setAutoStopLiveView(false);

        // Set and enable the processor.
        builder.addProcessor(tfod)

        // Build the Vision Portal, using the above settings.
        visionPortal = builder.build()

        // Set confidence threshold for TFOD recognitions, at any time.
        tfod!!.setMinResultConfidence(0.70f)

        // Disable or re-enable the TFOD processor at any time.
        //visionPortal.setProcessorEnabled(tfod, true);
    } // end method initTfod()

    /**
     * Add telemetry about TensorFlow Object Detection (TFOD) recognitions.
     */
    private fun telemetryTfod() {
        val currentRecognitions = tfod!!.recognitions
        telemetry.addData("# Objects Detected", currentRecognitions.size)

        // Step through the list of recognitions and display info for each one.
        for (recognition in currentRecognitions) {
            val x = ((recognition.left + recognition.right) / 2).toDouble()
            val y = ((recognition.top + recognition.bottom) / 2).toDouble()
            telemetry.addData("", " ")
            telemetry.addData(
                "Image",
                "%s (%.0f %% Conf.)",
                recognition.label,
                recognition.confidence * 100
            )
            telemetry.addData("- Position", "%.0f / %.0f", x, y)
            telemetry.addData("- Size", "%.0f x %.0f", recognition.width, recognition.height)

            //element position logic
            if (x < 200){
                elementPosition = 1
                telemetry.addData("Game Element Position", elementPosition)
                visionPortal!!.close() //changed to .close() from .stopStreaming() to save more CPU resources
            }
            else if (x > 200 && x < 400){
                elementPosition = 2
                telemetry.addData("Game Element Position", elementPosition)
                visionPortal!!.close() // .close() is more permanent than .stopStreaming()
            }
            else if (x > 400){
                elementPosition = 3
                telemetry.addData("Game Element Position", elementPosition)
                visionPortal!!.close() //vision portal cannot be used again without REBUILDING after being closed!!
            }
            else {
                return
            }

        } // end for() loop
    } // end method telemetryTfod()

    companion object {
        private const val USE_WEBCAM = true // true for webcam, false for phone camera

        // TFOD_MODEL_ASSET points to a model file stored in the project Asset location,
        // this is only used for Android Studio when using models in Assets.
        private const val TFOD_MODEL_ASSET = "cat.tflite"

        // TFOD_MODEL_FILE points to a model file stored onboard the Robot Controller's storage,
        // this is used when uploading models directly to the RC using the model upload interface.
        //private static final String TFOD_MODEL_FILE = "/sdcard/FIRST/tflitemodels/cat.tflite";
        // Define the labels recognized in the model for TFOD (must be in training order!)
        private val LABELS = arrayOf(
            "cat"
        )
    }
} // end class
