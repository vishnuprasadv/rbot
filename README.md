# rbot
A simple app that will pull images from subreddits and uploads to online storage services if needed. Created using Spring Boot and Spring scheduler.

# How to run
* Clone the repo and modify the properties and configurations.
* Application uses a mysql db to keep track of images it downloaded. Needed for future enhancements, not yet implemented. So you'll need mysql installed. Create a mysql db for the app and update the properties file or just purge all the db related codes.
* If you're gonna make use of online storage service upload functionality, then update the credentials.properties file with credentials. If not, just remove the upload scheduled method from running in `Engine` class
* Change the time you want to run this process. I choose it to run weekly.
* Compile + run it

## Future enhancements
Add more sources than reddit.

## Note
No copyright infringement intended. Check with the original poster of images before downloading and using the images.

