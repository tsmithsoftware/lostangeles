# lostangeles
This project is an Android application built as a solution to the problem outlined in [the project specification outlined here](./Lost_Angeles_final.pdf).

# Running the project
In order to run the project, please either: <br/> 
<li>check out the repository as an Android Studio project and run from within Studio</li>
<li>run gradlew assembleDebug from the projects root directory and install the resulting build on a simulator/device</li>
<li>install the .apk build provided at /app/build/outputs/apk/debug/app-debug.apk on a simulator/device</li>

# Project structure
The project is broadly organised using the Clean Architecture design pattern. The project code has one "greet" feature located at the com/timsmith/lostangeles/features/greet directory. This is further organised into /app, /data and /domain folders. <br />
<li>The /app folder holds presentation-related code - activities, fragments, viewmodels and the models used for the internal logic of the app</li>
<li>The data layer contains abstract definitions of all data sources (in this case, the remote data source only) and the transformation logic to map between the data source and the internal models</li>
<li>The domain layer holds the code to interact with the remote data sources (repository and usecase code)</li>

There is also a /shared folder containing DI (Dagger) related code.

In terms of the abstractions used to model the problem domain, the MainFragment:
<li>creates a MainGate where the visitors arrive each day</li>
<li>starts the Cart which picks up the visitors</li>
<li>the Cart uses the SiteMap to get the best Route, makes the Trip and records the Trip in the Ledger</li>
<li>once all FamilyGroupModels have completed their trip, the results of the Ledger are output to the UI</li>
<p>
The user of the application can then select the particular trip to see the details of that trip, including time spent and route taken.
</p> 
The SiteMap is currently hardcoded from the project spec, and uses a breadth-first search algorithm to populate the graph. Areas for further development could include loading/saving the SiteMap from a JSON file.

