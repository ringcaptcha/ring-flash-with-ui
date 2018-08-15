# Android flash call usage example

Requirements:

* git
* Android Studio

Steps:

* `git clone https://github.com/ringcaptcha/ring-flash-ui`
* `cd ring-flash-ui`
* Find out which full path you are on which you need for next step: `pwd`
* Open 'Android Studio', and at the top menu, choose 'File' -> 'Open', and select the directory where you cloned ring-flash-ui app
* 'Android Studio' will start building, and you may get errors about missing requirements at the bottom of 'Android Studio'
![Android Studio missing requirements](img/ring-flash-ui-missing.png?raw=true "Missing Requirements")
* Click on 'Install missing ...' to continue
* Repeat the process to install all the missing requirements
* When installation if completed, on the left menu click 'Project' -> 'app' -> 'java' -> 'com.example.olehm.myapplication' -> 'MainActivitiy'
![Insert RingCaptcha Credentials](img/ring-flash-ui-insert-credentials.png?raw=true "Insert Credentials")
* Under 'private void verify()', replace the 'APP_KEY' and 'SECRET_KEY' of your RingCaptcha app
  * If you do not have these, please sign-up at https://ringcaptcha.com
* On the top menu, click 'Run app'
* This will popup a window to select your 'Device'
  * If your 'Device' is marked 'OFFLINE', click on 'Cancel'
  * On your physical device:
    * Click on 'Settings'
    * Click on 'Developer options'
    * Toggle 'Developer options' to enable it
    * Toggle 'USB debugging'
  * Click 'Run app' again, and the 'OFFLINE' should disappear
* If you are prompted to allow 'USB Debugging', click 'Allow'
* The app should now appear on your Android device screen
