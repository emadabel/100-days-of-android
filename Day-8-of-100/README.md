# DAY 8 CHALLENGE
Today’s android challenge is to write an android application with two activities – Activity A and B.

Activity A will contain two EditText widgets for username and password and a button widget. When a user inputs username and password and click the button, it validates against stored data in the shared prefernces, if it matches start Activity B.And display the username with welcome message and Logout Button.

## Task requirements
1. Create a launch or intro Activity A.
2. Add two EditText (Username and Password) and a Button widgets in Activity A layout file.
3. When the Button View on Activity A is clicked,
    1. Check that the username and password fields are not empty.
    2. If the are empty instruct the user to fill in these fields.
    3. If the fields are already filled validate the username and password with the username and password you stored in a Shared Preference.
4. If the username and password match then send the user to a new Activity B.
5. If there is no match, stay in Activity A and notify the user of incorrect login details.
6. If a user is login, display the username with welcome in Activity B and a Logout Button.
7. If a user click on the Logout Button it will redirect the User to Activity A with all the EditText empty.

## Note
You must store a hand coded username and password when the app initially loads.

## Task screenshot
![](https://inducesmile.com/wp-content/uploads/2017/02/androidlogin.png)