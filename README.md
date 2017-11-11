# Lexure

Lexure is an application that takes a recorded lecture in .wav format and produces:
* A searchable text file
* Topics covered
* Abstract of the lecture

For lectures, this will allow students to improve their process in the following ways:
1. Students will be able to select a topic and see all the times the topic was mentioned in a selected lecture or set of 
lectures.
2. At any point in the translated text-from-speech document, a student will be able to hit “play” and hear exactly what 
the professor said, allowing them to study more effectively.
3. All lectures will be summarized via abstract generation, which will allow the student to be better prepared for the 
next class by quickly reviewing the previous lecture.
4. All information will be easily shareable with other students (i.e. missed class? Here’s the entire, searchable 
lecture with topics and a summary).

Lexure is a project for [Cal Poly](https://www.calpoly.edu/)'s Artifical Intelligence class, CSC 480, by Dave Arndt, Duc Dao, Nicholas Ilog, Jin Young Jeong, and Tommy White.

## Usage
* Compile with the required dependency jars included in the classpath, or using the gradle project set up.
* Simply call the generated executable with no arguments to open the interactive command line utility.

### IntelliJ Idea
1. Import dependency jars into the project. File > Project Structure... > + > select `sphinx4-core-5prealpha.jar` and 
`sphinx4-core-5prealpha.jar` (located in project root directory).
2. Compile `/src/main/java/Transcribe.java` by opening it, and selecting Build > Recompile 'Transcribe.java'.
3. Run by selecting Run > 'Run Transcribe'.

## Current Implementation
* Accepts user-inputted input file (must be in .wav format) from `/input` directory (located in project root directory).
* Outputs transcription of the .wav file to user-specified output file. 
* Stores output file in the `/output` directory (located in project root directory) and `/mallet-2.0.8/input`.
* Topic model the transcription by executing `mallet-2.0.8/topicModelling.sh`. This is bash script that obtains a cluster of words. From here, we'll extract the topic by choosing the most frequently occurring word from that cluster.

## Future Features
* All files copied/stored locally in an intelligent way (i.e. two users have the same class at the same time and have
    a recording from the same day? Only save one copy)
* Personalization per user
* Flag-passed data (using Args4J or similar)
* Customization of audio recognition per professor (requires at least 5 minutes of annotated audio)
* Testing capability (provided transcribed audio)
* Topic modelling with MALLET
* Abstract generation with MALLET

## Acknowledgements
* Thank you to the [CMUSphinx](https://cmusphinx.github.io/) team for making their tool available for our use.
* Thank you to the team from UMass that designed [MALLET](http://mallet.cs.umass.edu/) for making their toolset 
available for our use.
