# Lexure

Lexure is an application that takes a recorded lecture in .wav format and produces:
* A searchable text file
* Topics covered
* Abstract of the lecture

For lectures, this will allow students to improve their process in the following ways:
1. Students will be able to select a topic and see all the times the topic was mentioned in a selected lecture or set of lectures.
2. At any point in the translated text-from-speech document, a student will be able to hit “play” and hear exactly what the professor said, allowing them to study more effectively.
3. All lectures will be summarized via abstract generation, which will allow the student to be better prepared for the next class by quickly reviewing the previous lecture.
4. All information will be easily shareable with other students (i.e. missed class? Here’s the entire, searchable lecture with topics and a summary).


## USING LEXURE
* Compile with the required dependency jars included in the classpath, or using the gradle project set up.
* Simply call the generated executable with no arguments to open the interactive command line utility.


## Current Implementation:
* Accepts user-inputted input file (must be .wav format ahead of time).
* Outputs to user-specified output file.
* Stores output files relative to application location (moving toward file structure).

## Future features:
* All files copied/stored locally in an intelligent way (i.e. two users have the same class at the same time and have
    a recording from the same day? Only save one copy)
* Personalization per user
* Flag-passed data (using Args4J or similar)
* Customization of audio recognition per professor (requires at least 5 minutes of annotated audio)
* Testing capability (provided transcribed audio)
* Topic modelling with MALLET
* Abstract generation with MALLET



Acknowledgements:
* Thank you to the CMUSphinx team for making their tool available for our use.
* Thank you to the team from UMass that designed MALLET for making their toolset available for our use.