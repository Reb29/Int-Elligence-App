# Int-Elligence-App
UWF Parking Service

---User Manual---

The user will interact with the system solely through the app. The application requires internet access as it must
obtain information from the web to populate the list of lots. On the top right there are two buttons that allow you to select whether
you want to see every lot, or just the favorited lots.

Each lot will appear on as button as you open the screen. Each lot will have a name, a current capacity, a max capacity, and a favorite icon
if the lot is selected as a favorite.

If you click the icon you can view the most recent image of the parking lot. There is a switch on the same screen that allows you to
favorite the specified lot.



---Installation Instructions(For the app, server, and Rekognition)---

Mobile App - The mobile app will need to be imported from Github and opened from Android Studios. From here you can build the app
on a mobile device or an emulator. The user will need internet access as information pertaining to the park lots must be downloaded from the provided server.

Server - The server can be installed on any virtual machine that allows nodejs. The default port, 7576, will need to be opened to allow
incoming traffic. The server will need to have a file called lotdata.json as this is the file the app will download. As implied by the file type, the file needs to be in the json format. Once nodejs is install the program can be run with the command "node server.js".

Rekognition - The repo has a maven file that will automatically import the Rekognition SDK for use. Rekognition requires that it is connected to an active Amazon account as the API calls are tracked and limited to a free tier that includes 5,000 monthly uses. The detectLabels class takes in an image and outputs the number of vehicals that it count. When linked to a database it can be used to values with the returned count.
