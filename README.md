#HorseRaceTrackATM Application

##To run the in Windows OS: 
	mvn clean compile exec:java -Dexec.mainClass="com.horsetrack2017.HorseRaceTrackATM"
	Or 
	gradlew jar & java -jar ./build/libs/horsetrack2017-1.0.jar

##To run the in Unix OS:
	mvn clean compile exec:java -Dexec.mainClass="com.horsetrack2017.HorseRaceTrackATM"
	Or
	./gradlew jar; java -jar ./build/libs/horsetrack2017-1.0.jar

##Valid commands are as follows:
• 'R' or 'r' - restocks the cash inventory
• 'Q' or 'q' - quits the application
• 'W' or 'w' [1-7] - sets the winning horse number
• [1-7] amount - specifies the horse wagered on and the amount of the bet
• [1-7] display Payout and Dispensing for given horse number
