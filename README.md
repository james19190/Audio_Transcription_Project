# Transcription with AssemblyAI API - Java

This project demonstrates utilizes the AssemblyAI API for audio transcription in Java. AssemblyAI is an Automatic Speech Recognition (ASR) service that converts spoken language into written text.

## Prerequisites

Before running the code, make sure you have the following:

- Java Development Kit (JDK) installed on your machine.
- API key from [AssemblyAI](https://www.assemblyai.com/) for authentication.

## Getting Started

1. **Clone the repository:**
   ```bash
   git clone https://github.com/james19190/TranscribeAudio.git
   ```

2. Open the main.java file and replace Keys.authKey with your AssemblyAI API key.

3. Build and run the Java application.
   ```bash
    javac main.java
    java main
   ```

## Project Structure
- main.java: Contains the main code for interacting with the AssemblyAI API using Java.
- Transcript.java: Defines the Transcript class representing the data structure for the transcript object.

## How It Works
1) Creates a Transcript object with the audio URL.
2) Converts the Transcript object to JSON using Gson.
3) Sends a POST request to the AssemblyAI API to initiate the transcription.
4) Polls the API with GET requests until the transcription is completed or an error occurs.
5) Prints the transcription text once the process is complete.

## Notes
- The program uses the AssemblyAI API endpoint https://api.assemblyai.com/v2/transcript.
- The status of the transcription is checked at regular intervals until it is marked as "completed" or "error."
- The transcribed text is printed to the console once the process is complete.

## Acknowledgments
AssemblyAI for providing the Automatic Speech Recognition API.
Gson for JSON serialization/deserialization in Java.
Feel free to contribute or provide feedback!
