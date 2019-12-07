# Int-Elligence-App
    UWF Parking Service

    Project Report

    Executive Summary: Int Elligence

Int Elligence wanted to revolutionize the entire UWF parking situation by designing a parking lot open space tracking app for UWF. Throughout the semester, Int Elligence worked to determine how feasible
implementing a parking lot open space tracking app on the UWF campus would be.  In order to achieve our goal, we had to utilize technological advances of our time, to provide a full spectrum of our passion to our client. We were set on setting the standard!
The following paragraph will summarize the results and accomplishments of the project.


An image of a parking lot is uploaded to the Amazon Web Services API. The Amazon Web Services API scans the number of cars inside of the image and writes corresponding data and statistics to the Amazon EC2 Virtual Machine, which houses the database and server for our project. The parking lot open space tracking application requests the information from the server. Amazon EC2 virtual machine hosts a nodejs application that processes the request and updates a json file on the server that is transmitted to the mobile application. The mobile application then displays an image of the parking lot and the number of parking spaces that are available. The user is able to toggle between different parking lots on the UWF campus and favorite their most commonly used lots. 

    Final Requirements and Comparison with Initial Requirements

In regards to the functionality of our mobile application, our final product enabled a  user to view the current image of a parking lot, display the max capacity, and display the current capacity of their selected parking lot. Our initial requirement was to create a mobile application that only contained the functionality of toggling between different parking lot images of the UWF parking lots.  

    Parking Lot Capacity Calculation:

Amazon Recognition API was able to analyze an image and distinguish between automobiles, parking lots, and transportation in the image and determine the output data and write it in the requested format. By simply feeding images of a parking lot, we were able to determine what parking spots were available and what parking spots were not.

Referencing the server for our mobile application, our final product utilized Amazon EC2 virtual machine to harbor the database and server and facilitate communication between the two. Initial research brought us to a conclusion that a storage device, on the same network as time capturing and processing device, is the way to go. They would share the same network and work under the same set of rules of the network to exist in peace and prosperity. The server was used to analyze an image with AWS Rekognition and write the corresponding statistics to a JSON file.  Our initial requirement  involved converting a laptop into a server using Unraid engine and utilizing ip filtering and port forwarding rules to allow the server, database, and mobile application to communicate. 

For the database, we used Amazon EC2 virtual machine to host the database and used SQL and Java queries to update, extract, and store information about the UWF Parking Lots. In the beginning, we did not incorporate a database in our design plans. 

For the final product, we utilized the Netbeans, Android Studios, and Intellij development platforms. However, our initial development platform only involved Android Studios. 

Originally, we wanted to monitor the workload of the mobile application by monitoring server network traffic and efficiency in real time. For the final product, we did not incorporate those features. 


    Final Timeline and Comparison with the Initial Timeline:
    
During the initial timeline of the project we had many aspirations, ambitions, potential avenues of exploration, and endless motivation to reach our end goal. We, as a team, were driven by the same vision and struggles, to make our lives and the lives of our fellow students easier, happier and less stressful.


    Initial Timeline: September:
    
During the first month of the project, int Elligence wanted to confirm our topic, mission, and objectives, as well as conduct a general survey for data on students attitude toward the UWF parking lot situation. Additionally, we wanted to contact UWF Parking Services to gain statistical data regarding the facility to student parking ratio, busiest times in each parking lot, and most popular parking lots. By the end of the month, we wanted to have research regarding the different types of sensors on the market and their security vulnerabilities explored. 


    Final Timeline: September:

In actuality, int Elligence was able to complete all of the aforementioned tasks by 15 September and began developing the mobile parking lot status application and verifying that the code was utilizing secure programming practices throughout the following weeks of September. 


Initial Timeline: October:

During the second month of the project, int Elligence wanted to begin writing a program that could analyze parking lot aerial data and begin writing a mobile application that would display the status of  the parking lots on the UWF campus. 


    Final Timeline: October:

In actuality, int Elligence shifted from began developing the program for the mobile application in September. Additionally, we began working on our client side/server side communication and began developing a database to store the information about the various parking lots on campus. We shifted from the idea of actually testing the transmit of an actual image from a camera to upload a picture to AWS Rekognition and having Amazon’s software analyze the image and determine the parking statistics.During this month, we also begin converting a laptop into a physical server to store information.  Amazon cloud storage, Amazon AWS database and Amazon image recognition was the way to go. 


    Initial Timeline: November:

Initially, we projected our first deployment of our program would be in November. During that time, we would have a small group of UWF students that would test the functionality, efficiency, and user-friendliness of the mobile application. Once the testing was completed, we would evaluate the results, implement the necessary improvements, and begin preparing for the final presentation. 


    Final Timeline: November:

In actuality, we decided to stray away from using a laptop as a server and ventured toward using Amazon EC2 Virtual Machine to host the server and database. We completed the mobile application, as usually planned, and focused on facilitating communication between the mobile application, the server, and the database, a task we originally did not anticipate. In the end, we did not deploy a mock application with a small test group. However, we were able to complete the application development, create the databasebase, maintain a server, and create final product that allows a user to view an image of a parking lot and view the number of available parking spaces.


    Project Results compared with expectations:

The final project resulted in a user friendly mobile application that allows a user to identify the current parking conditions on the UWF campus. In the end, int Elligence can successfully deem our mission goals & objectives accomplished. Originally, we expected to have an actual camera to take a picture of any given parking lot and transmit that picture to a laptop, which acted as a server. A program, written in Netbeans would analyze the program, determine the available number of parking spots, and send that information to our mobile application. Our project results lead us to the discovery that we did not have the economic feasibility to utilize a camera for our project. Instead, we incorporated Amazon Web Services API to scan an image upload and write corresponding statistics regarding parking spot capacity to a JSON file. The JSON file was transferred to our mobile application, upon request, and provided the mobile application user with an image of the parking lot and the number of parking spaces that were available. We discovered that AWS Rekognition software has trouble evaluating large number of cars accurately. We contemplated positioning one camera on a campus parking lot in order to give AWS Rekognition the opportunity to present more accurate results, but eventually decided against it. All functions designed serve for a convenient, safe and trouble free experience.


        Project Process Review: Gap Analysis:
    Current State vs. Future State:

Parking lot sensors: We currently do not have any parking lot sensors placed in the parking lots on UWF campus. This gap is due to financial feasibility and tariffs. During our research, we came to the conclusion that the cost of implementing this feature would outweigh the benefits of implementing this feature. However, for future development, if an organization is willing to sponsor the installation of sensors on every parking lot, parking sensors are an ideal solution.


    Parking Signs: 

Currently, we do not have any parking signs that display the capacity or availability of the parking lots. A parking sign would be very convenient for individuals who do not have the mobile application. The overall technological process of updating the parking sign would be similar to that of updating the mobile application. We did not have time to explore this possibility. However, we hope that the future state of the project for future development includes it. 





    Ios Application Compatibility: 

The current state of our algorithm is not compatible with ioS operating systems, only android operating systems. The members of our development team did not have experience with ios operating system mobile programming. We hope the future state of our project includes ios capability. 

    Real-Time Data: 

The current state of our project does not include the capability to analyze  real-time images from cameras taken in the UWF parking lot. This was due to a lack of financial resources. In the future state of our project, we hope to have this capability. 
Work to be done

Although we accomplished our main goal of developing a parking lot open space tracking application for UWF, there are still areas of expansion. First off, due to time constraints and finances, the installation of cameras in each parking lot on the UWF campus was not completed during the stages of our project and must be completed during future development. When the installation of cameras in each parking lot on the UWF campus is completed, it must be determined which locations in those parking lots will result in the most accurate images for the AWS API Rekognition software to analyze accurately the amount of parking spots available and occupied in the parking lot. When positioning the cameras, we also have to take into account the inevitability of natural weather and their potential to damage or destroy the equipment. The strategic placement of the cameras is vital when exploring the financial aspects of this project. Additionally, the compatibility of the cameras with the server must be explored in order to ensure successful communication. Although we utilized AWS API Rekognition and Amazon EC2 Virtual Machine, the software itself must be maintained throughout a paid subscription. Since we are relying on a 3rd party’s software, the availability and functionality of our mobile application is dependent on the availability of Amazon’s servers. A new avenue of server and database implementation may have to be explored in order for the stand-alone capability of the project. 







    User Manual

The user will interact with the system solely through the app. The application requires internet access as it must
obtain information from the web to populate the list of lots. On the top right there are two buttons that allow you to select whether
you want to see every lot, or just the favorited lots.

Each lot will appear on as button as you open the screen. Each lot will have a name, a current capacity, a max capacity, and a favorite icon
if the lot is selected as a favorite.

If you click the icon you can view the most recent image of the parking lot. There is a switch on the same screen that allows you to
favorite the specified lot.



    Installation Instructions(For the app, server, and Rekognition)

Mobile App - The mobile app will need to be imported from Github and opened from Android Studios. From here you can build the app
on a mobile device or an emulator. The user will need internet access as information pertaining to the park lots must be downloaded from the provided server.

Server - The server can be installed on any virtual machine that allows nodejs. The default port, 7576, will need to be opened to allow
incoming traffic. The server will need to have a file called lotdata.json as this is the file the app will download. As implied by the file type, the file needs to be in the json format. Once nodejs is install the program can be run with the command "node server.js".

Rekognition - The repo has a maven file that will automatically import the Rekognition SDK for use. Rekognition requires that it is connected to an active Amazon account as the API calls are tracked and limited to a free tier that includes 5,000 monthly uses. The detectLabels class takes in an image and outputs the number of vehicals that it count. When linked to a database it can be used to values with the returned count.
