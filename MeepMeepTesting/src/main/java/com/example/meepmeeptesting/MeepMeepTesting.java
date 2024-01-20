package com.example.meepmeeptesting;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.acmerobotics.roadrunner.geometry.Vector2d;
import com.noahbres.meepmeep.MeepMeep;
import com.noahbres.meepmeep.roadrunner.DefaultBotBuilder;
import com.noahbres.meepmeep.roadrunner.entity.RoadRunnerBotEntity;

public class MeepMeepTesting {
    public static void main(String[] args) {
        MeepMeep meepMeep = new MeepMeep(800);

        RoadRunnerBotEntity myBot = new DefaultBotBuilder(meepMeep)
                // Set bot constraints: maxVel, maxAccel, maxAngVel, maxAngAccel, track width
                .setConstraints(60, 60, Math.toRadians(180), Math.toRadians(180), 15)
                .followTrajectorySequence(drive ->
                        drive.trajectorySequenceBuilder(new Pose2d(-36.0, -58.5, Math.toRadians(90)))
                                .splineToConstantHeading(new Vector2d(-44.0, -43.0), Math.toRadians(90))
                                .waitSeconds(1)
                                .splineToConstantHeading(new Vector2d(-34.0, -60.0), Math.toRadians(90))
                                .splineToConstantHeading(new Vector2d(-34.0, 0.0), Math.toRadians(90))
                                .turn(Math.toRadians(-90))
                                .splineToConstantHeading(new Vector2d(36.0, 0.0), Math.toRadians(0))
                                .splineToConstantHeading(new Vector2d(36.0, -29.0), Math.toRadians(0))
                                .splineToConstantHeading(new Vector2d(49.2, -29.0), Math.toRadians(0))
                                .build()
                );


        RoadRunnerBotEntity myBot2 = new DefaultBotBuilder(meepMeep)
                // Set bot constraints: maxVel, maxAccel, maxAngVel, maxAngAccel, track width
                .setConstraints(60, 60, Math.toRadians(180), Math.toRadians(180), 15)
                .followTrajectorySequence(drive ->
                        drive.trajectorySequenceBuilder(new Pose2d(-36.0, -58.5, Math.toRadians(90)))
                                .waitSeconds(2)
                               // .splineToConstantHeading(new Vector2d(-36.0, -60.4), Math.toRadians(90))

                                .splineToConstantHeading(new Vector2d(-36.0, -34.5), Math.toRadians(90))
                                .waitSeconds(1)
                                .lineTo(new Vector2d(-36.0, -58.5))
                                .splineToConstantHeading(new Vector2d(-55.0, -23.5), Math.toRadians(90))
                                .splineToConstantHeading(new Vector2d(-34.0, 0.0), Math.toRadians(90))
                                .turn(Math.toRadians(-90))
                                .splineToConstantHeading(new Vector2d(36.0, 0.0), Math.toRadians(0))
                                .splineToConstantHeading(new Vector2d(48.5, -35.0), Math.toRadians(0))
                                //.splineToConstantHeading(new Vector2d(49.2, -29.0), Math.toRadians(0))
                                .build()
                );

        RoadRunnerBotEntity myBot3 = new DefaultBotBuilder(meepMeep)
                // Set bot constraints: maxVel, maxAccel, maxAngVel, maxAngAccel, track width
                .setConstraints(60, 60, Math.toRadians(180), Math.toRadians(180), 15)
                .followTrajectorySequence(drive ->
                        drive.trajectorySequenceBuilder(new Pose2d(-36.0, -58.5, Math.toRadians(90)))
                                .waitSeconds(2)
                                // .splineToConstantHeading(new Vector2d(-36.0, -60.4), Math.toRadians(90))

                                .splineToConstantHeading(new Vector2d(-50.0, -30.0), Math.toRadians(90))
                                .turn(Math.toRadians(-90)) //can't be called in a trajectory
                                .waitSeconds(1)
                                .lineTo(new Vector2d(-34.5, -30.0))
                                .waitSeconds(2)
                                .lineTo(new Vector2d(-39.0, -30.0))
                                .strafeTo(new Vector2d(-34.0, 0.0))
                                .waitSeconds(10)
                                .build()
                );


        // LEARN TO SPLIT TRAJECTORIES EVENTUALLY
        // LOTS O' WORK TO DO!!!
        meepMeep.setBackground(MeepMeep.Background.FIELD_CENTERSTAGE_JUICE_DARK)
                .setDarkMode(true)
                .setBackgroundAlpha(0.95f)
                //.addEntity(myBot)
                .addEntity(myBot3)
                .start();
    }
}