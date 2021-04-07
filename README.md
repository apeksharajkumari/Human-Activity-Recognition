The main zip contains 2 folders -

1. Human_Activity_Recognition - This folder is an Android Studio Project of the entire CSE 535 Project. You can open Android studio and load this folder to view all the code and run the code too.

2. Accelerometer_Data - This folder is an Android Studio Project to record Accelerometer Data and write it to a CSV

Files -

data.csv - This is the CSV containing accelerometer readings for 5 activities recorded by the team members.

MC_Project_Group21.ipynb - This is a Python Notebook containing the preprocessing code and LSTM model generation code. Output of this file would a frozen graph (.pb) file. This Python Notebook was run using Google Colab to avoid GPU problems. To run this code, first create a folder called "MC_Project" on your Google drive and paste the data.csv in that folder. Once that's done, you can run the code and all the intermediate outputs are also stored in that folder on your google Drive.

The .pb file can be found in the "MC_Project" folder on your google drive. Copy that and paste it under the assets folder in the Human_Activity_Recognition project to use the generated model for prediction.

The APK's for the Android Studio Projects are under the path <Project_Name>/app/release -  app_release.apk

The app_release.apk found inside the Zip file is for the Human_Activity_Recognition as that is the main Project.
