package org.firstinspires.ftc.teamcode
import com.acmerobotics.roadrunner.geometry.Pose2d
import com.acmerobotics.roadrunner.geometry.Vector2d
import com.acmerobotics.roadrunner.trajectory.Trajectory
import org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.hardwareMap
import org.firstinspires.ftc.teamcode.drive.SampleMecanumDrive


class Trajectories {
    object rrtraj{
        //call trajectory builder function from drive
        var drive: SampleMecanumDrive  = SampleMecanumDrive(hardwareMap)
        val absYVal: Double = 58.5 //think about where robot will be placed FIX AFTER BOT BUILT

        /**
         * somehow squeeze drive.setPoseEstimate(startPose) in there??
         *
         * RR and meepmeep use a FIELD-centric coordinate system
         * meaning we have to specify where the robot starts with the startpose() command
         * be mindful when making the four separate drive programs (innerblue, outerred, etc.)
         *
         */


        //all possible starting positions (poses)
        var outerblue: Pose2d? = Pose2d(-36.0, -70.0, Math.toRadians(90.0))
        var outerred: Pose2d? = Pose2d(-36.0, 70.0, Math.toRadians(270.0))


        //pixel backboard trajectories for all possible robot and cat positions
        var innerblue1: Trajectory = drive.trajectoryBuilder(Pose2d(12.0, -absYVal, Math.toRadians(90.0))) //fix pose
            //blah blah
            .build()

        var innerblue2: Trajectory = drive.trajectoryBuilder(Pose2d(12.0, -absYVal, Math.toRadians(90.0)))
            //blah blah
            .build()

        var innerblue3: Trajectory = drive.trajectoryBuilder(Pose2d(12.0, -absYVal, Math.toRadians(90.0)))
            //blah blah
            .build()

        var outerblue1: Trajectory = drive.trajectoryBuilder(Pose2d(-36.0, -absYVal, Math.toRadians(90.0)))
            //blah blah
            .build()

        var outerblue2: Trajectory = drive.trajectoryBuilder(Pose2d(-36.0, -absYVal, Math.toRadians(90.0)))
            //blah blah
            .build()

        var outerblue3: Trajectory = drive.trajectoryBuilder(Pose2d(-36.0, -absYVal, Math.toRadians(90.0)))
            //blah blah
            .build()

        var innerred1: Trajectory = drive.trajectoryBuilder(Pose2d(12.0, absYVal, Math.toRadians(270.0)))
            //blah blah
            .build()

        var innerred2: Trajectory = drive.trajectoryBuilder(Pose2d(12.0, absYVal, Math.toRadians(270.0)))
            //blah blah
            .build()

        var innerred3: Trajectory = drive.trajectoryBuilder(Pose2d(12.0, absYVal, Math.toRadians(270.0)))
            //blah blah
            .build()

        var outerred1: Trajectory = drive.trajectoryBuilder(Pose2d(-36.0, absYVal, Math.toRadians(270.0)))
            //blah blah
            .build()

        var outerred2: Trajectory = drive.trajectoryBuilder(Pose2d(-36.0, absYVal, Math.toRadians(270.0)))
            //blah blah
            .build()

        var outerred3: Trajectory = drive.trajectoryBuilder(Pose2d(-36.0, absYVal, Math.toRadians(270.0)))
            //blah blah
            .build()
    }
}