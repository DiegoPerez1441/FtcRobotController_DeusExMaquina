/* Copyright (c) 2018 FIRST. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without modification,
 * are permitted (subject to the limitations in the disclaimer below) provided that
 * the following conditions are met:
 *
 * Redistributions of source code must retain the above copyright notice, this list
 * of conditions and the following disclaimer.
 *
 * Redistributions in binary form must reproduce the above copyright notice, this
 * list of conditions and the following disclaimer in the documentation and/or
 * other materials provided with the distribution.
 *
 * Neither the name of FIRST nor the names of its contributors may be used to endorse or
 * promote products derived from this software without specific prior written permission.
 *
 * NO EXPRESS OR IMPLIED LICENSES TO ANY PARTY'S PATENT RIGHTS ARE GRANTED BY THIS
 * LICENSE. THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
 * CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package org.firstinspires.ftc.teamcode;

import com.qualcomm.ftccommon.SoundPlayer;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

/**
 * █▀█ █▀█ █▀█   █ █▀▀ █▀▀ ▀█▀   █▀▄▀█ █▄▀ █▀▄▀█
 * █▀▀ █▀▄ █▄█ █▄█ ██▄ █▄▄  █    █ ▀ █ █ █ █ ▀ █
 * Also known as Project Mario Kart Music/Meme
 *
 * Controls:
 * Gamepad1's dpad buttons are used to play the Mario Kart Music sounds
 *      - Up:       Title Screen(mkm_titlescreen)
 *      - Right:    Luigi Circuit and Mario Circuit(mkm_luigicircuitandmariocircuit)
 *      - Down:     Coconut Mall(mkm_coconutmall)
 *      - Left:     To be determined...
 *
 * Sound Files Info:
 * For sound files to be used as a compiled-in resource, they need to be located in a folder called "raw" under your "res" (resources) folder.
 * Path: /TeamCode/src/main/res/raw
 *
 * Requirements:
 * - File name should be lower-case characters, no spaces, and no special characters other than underscores
 * - File type must be .wav
 *
 * The name you give your .wav files will become the resource ID for these sounds.
 * eg:  gold.wav becomes R.raw.gold
 */

@TeleOp(name="Project MKM", group="Concept")
@Disabled
public class ProjectMKM extends LinearOpMode {

    // Declare OpMode members

    // Sound file present flags
    private boolean mkm_titlescreenFound;                   // dpad up
    private boolean mkm_luigicircuitandmariocircuitFound;   // dpad right
    private boolean mkm_coconutmallFound;                   // dpad down

    // gamepad1 button state variables
    private boolean isDpad_up = false;
    private boolean isDpad_right = false;
    private boolean isDpad_down = false;
    //private boolean isDpad_left = false;

    // gamepad1 button history variables
    private boolean wasDpad_up = false;
    private boolean wasDpad_right = false;
    private boolean wasDpad_down = false;
    //private boolean wasDpad_left = false;

    @Override
    public void runOpMode() {

        // Determine Resource IDs for sounds built into the RC application.
        int mkm_titlescreenSoundID = hardwareMap.appContext.getResources().getIdentifier("mkm_titlescreen", "raw", hardwareMap.appContext.getPackageName());
        int mkm_luigicircuitandmariocircuitSoundID = hardwareMap.appContext.getResources().getIdentifier("mkm_luigicircuitandmariocircuit",   "raw", hardwareMap.appContext.getPackageName());
        int mkm_coconutmallSoundID = hardwareMap.appContext.getResources().getIdentifier("mkm_coconutmall", "raw", hardwareMap.appContext.getPackageName());

        // Determine if sound resources are found.
        // Note: Preloading is NOT required, but it's a good way to verify all your sounds are available before you run.
        if (mkm_titlescreenSoundID != 0) {
            mkm_titlescreenFound = SoundPlayer.getInstance().preload(hardwareMap.appContext, mkm_titlescreenSoundID);
        }

        if (mkm_luigicircuitandmariocircuitSoundID != 0) {
            mkm_luigicircuitandmariocircuitFound = SoundPlayer.getInstance().preload(hardwareMap.appContext, mkm_luigicircuitandmariocircuitSoundID);
        }

        if (mkm_coconutmallSoundID != 0) {
            mkm_coconutmallFound = SoundPlayer.getInstance().preload(hardwareMap.appContext, mkm_coconutmallSoundID);
        }


        // Display sound status
        telemetry.addData("mkm_titlescreen resource",   mkm_titlescreenFound ? "Found" : "NOT found\n Add gold.wav to /src/main/res/raw" );
        telemetry.addData("mkm_luigicircuitandmariocircuit resource", mkm_luigicircuitandmariocircuitFound ? "Found" : "Not found\n Add silver.wav to /src/main/res/raw" );
        telemetry.addData("mkm_coconutmall resource",   mkm_coconutmallFound ? "Found" : "NOT found\n Add gold.wav to /src/main/res/raw" );

        // Wait for the game to start (driver presses PLAY)
        telemetry.addData(">", "Press Start to continue");
        telemetry.update();
        waitForStart();

        telemetry.addData(">", "Press dpad buttons to play sounds...");
        telemetry.update();

        // Run until the end of the match (driver presses STOP)
        while (opModeIsActive()) {

            // Play mkm_titlescreen each time gamepad1 dpad_up is pressed
            if (mkm_titlescreenFound && (isDpad_up = gamepad1.dpad_up) && !wasDpad_up) {
                SoundPlayer.getInstance().startPlaying(hardwareMap.appContext, mkm_titlescreenSoundID);
                telemetry.addData("Playing", "mkm_titlescreen");
                telemetry.update();
            }

            // Play mkm_luigicircuitandmariocircuitl each time gamepad1 dpad_right is pressed
            if (mkm_luigicircuitandmariocircuitFound && (isDpad_right = gamepad1.dpad_right) && !wasDpad_right) {
                SoundPlayer.getInstance().startPlaying(hardwareMap.appContext, mkm_luigicircuitandmariocircuitSoundID);
                telemetry.addData("Playing", "mkm_luigicircuitandmariocircuit");
                telemetry.update();
            }

            // Play mkm_coconutmall each time gamepad1 dpad_down is pressed
            if (mkm_coconutmallFound && (isDpad_down = gamepad1.dpad_down) && !wasDpad_down) {
                SoundPlayer.getInstance().startPlaying(hardwareMap.appContext, mkm_coconutmallSoundID);
                telemetry.addData("Playing", "mkm_coconutmall");
                telemetry.update();
            }

            // Save last button states
            wasDpad_up = isDpad_up;
            wasDpad_right = isDpad_right;
            wasDpad_down = isDpad_down;
            //wasDpad_left = isDpad_left;

        }
    }
}
