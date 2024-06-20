
# Social Media Application

This is the code for a social media application built in Java. It provides functionalities for users to create accounts, post content (photos), interact with other users (follow/accept requests), and send direct messages.




## Features

- **User Management:**
User registration and login.
Invalid login attempt handling.
- **Photo Posting:**
Create photo posts with captions.
Like and comment on posts.
Delete posts.
- **Follower Management:**
Follow other users and accept follower requests.
View follower information (ID, name, follower count, and request count).
- **Direct Messaging:**
Send direct messages to other users.
Edit and delete sent messages.

## Assumptions
The code assumes a pre-existing text file named "userData.txt" containing user data in a specific format.
Error handling is done for invalid input.

## Code Breakdown
**Classes:**

- User: Handles user accounts with username, password, login/logout functionalities.
- Post: Base class for posts with ID and caption.
- PhotoPost: Inherits from Post, represents photo posts with additional functionality for liking, commenting, and deleting.
- VideoPost: (Currently empty, likely planned to extend Post for video posts).
- Follower: Handles follower information (ID, name, password, follower count, and request count) with functionalities to accept/request followers.
- Chatting: Represents a single message with content.
- DirectMessage: Handles sending, editing, and deleting direct messages.
- InvalidInputException: Custom exception class for handling invalid user input.
- FileNotCreated: Custom exception class for handling file creation issues (not currently used).
- Lab6SCD: Main class containing the program logic.
- Main Function (Lab6SCD.main()): 
## Running the Program
- Ensure you have Java installed and configured on your system.
- Create a text file named "userData.txt" with sample data in the expected format (refer to code for details on data format).
- Compile the source code using a Java compiler (e.g., Apache NetBeans IDE).
- Run the Lab6SCD class for working code.

