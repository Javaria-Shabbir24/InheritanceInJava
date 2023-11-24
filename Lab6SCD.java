
package com.mycompany.lab6scd;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class User
{
    private String username;
    private String password;
    public User(String username, String password)
    {
        this.username=username;
        this.password=password;
    }
    //set password 
    void setPassword(String username)
    {
         this.username=username;
    }
    //login
    void login(String username, String password)
    {
        if(  this.username.equals(username)&&this.password.equals(password))
        {
            System.out.println("Successful Login");
        }
        else
        {
            System.out.println("Invalid Login credentials");
        }
    }
    //enter username
    String EnterUsername()
    {
        Scanner input=new Scanner(System.in);
        String name=input.next();
        return name;
    }
    //enter password
     String EnterPassword()
    {
        Scanner input=new Scanner(System.in);
        String pass=input.next();
        return pass;
    }
    //sign up
    void signUp()
    {
        System.out.print("Enter your username: ");
        this.username=EnterUsername();
        System.out.print("Enter your password: ");
        this.password=EnterPassword();
    }
    //logout
    void logOut()
    {
         try{
                 System.out.println("Do you want to logout?(Y/N)");
            Scanner input=new Scanner(System.in);
            String choice=input.next();
            if(choice.equals("Y")||choice.equals("y"))
            {
                System.out.println("Logged out successfully");
            }
            else if(choice.equals("N")||choice.equals("n"))
            {
                System.out.println("Action denied");
            }
            else
            {
                throw new InvalidInputException("Invalid Input");
            }
        }
        catch(InvalidInputException e)
        {
            System.out.println("Exception Error: "+e);
        }
    }
    //void display
    void display()
    {
        System.out.println("Username: "+this.username+"\nPassword: "+this.password);
    }
}
//post class
class Post
{
    private int id;
    private String caption;
    public Post(int id,String caption)
    {
        this.id=id;
        this.caption=caption;
    }
    //add like
    void addLike()
    {
        System.out.println("Like has been added");
    }
    //delete Post
    void deletePost()
    {
        this.id=0;
        this.caption=null;
        System.out.println("Post has been deleted");
    }
    //add caption
    void addComment(String caption)
    {
        System.out.println("Comment has been added: "+caption);
    }
    //getter
    int getId()
    {
        return this.id;
    }
    String getcaption()
    {
        return this.caption;
    }
}
//photo post
class PhotoPost extends Post
{
    private static int imageid =10;
    public PhotoPost(String caption)
    {
        super(++imageid,caption);
    }
    void display()
    {
        System.out.println("The post id is: "+getId()+"\nThe post caption is: "+getcaption());
    }
}
//video post
 class VideoPost extends Post
{
    private static int videoid =0;
    private float timer;
    public VideoPost(String caption)
    {
        super(++videoid,caption);
    }
    // timer
    void setTimer()
    {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the timer: ");
        float timer=sc.nextFloat();
        this.timer=timer;
        System.out.println("Timer has been set successfully!");
    }
   
}   
//class Follower
class Follower
{
    private int id;
    private String name;
    private String password;
    private int followerCount;
    private int requestCount;
    //constructor
    public Follower(int id,String name,String password,int followerCount,int requestCount)
    {
        this.name=name;
        this.id=id;
        this.password=password;
        this.followerCount=followerCount;
        this.requestCount=requestCount;
    }
    // accept follower
    void acceptFollower()
    {
        try{
        System.out.println("You a follower request.Do you want to accept?(Y/N");
        Scanner input=new Scanner(System.in);
            String choice=input.next();
            if(choice.equals("Y")||choice.equals("y"))
            {
                System.out.println("Follower Accepted successfully");
            }
            else if(choice.equals("N")||choice.equals("n"))
            {
                System.out.println("Action denied");
            }
            else
            {
                throw new InvalidInputException("Invalid Input");
            }
        }
         catch(InvalidInputException e)
        {
            System.out.println("Exception Error: "+e);
        }
    }
      // accept follower
    void requestFollower()
    {
        try{
        System.out.println("Do you want to request this follower?(Y/N");
        Scanner input=new Scanner(System.in);
            String choice=input.next();
            if(choice.equals("Y")||choice.equals("y"))
            {
                System.out.println("Follower Requested successfully");
            }
            else if(choice.equals("N")||choice.equals("n"))
            {
                System.out.println("Action denied");
            }
            else
            {
                throw new InvalidInputException("Invalid Input");
            }
        }
         catch(InvalidInputException e)
        {
            System.out.println("Exception Error: "+e);
        }
    }
    void display()
    {
        System.out.println("Follower id: "+this.id+"\nFollower name: "+this.name+"\nFollowers Count: "+this.followerCount+"\nRequest Count: "+this.requestCount);
    }
}
//chatting class
class Chatting
{
    private String message;
    public Chatting(String message)
    {
        this.message= message;
    }
    //set message
    void setMessage(String message)
    {
         this.message= message;
    }
    //get message
    String getMessage()
    {
        return this.message;
    }
}
//Direct message class
class DirectMessage
{
    Chatting c1=new Chatting("Hello");
    //send message
    void sendMessage()
    {
        System.out.println("Message has been sent");
    }
    //edit message
    void editMessage()
    {
        System.out.print("Enter the new message: ");
        Scanner input=new Scanner(System.in);
        String message=input.next();
        c1.setMessage(message);
        System.out.println("Message changed successfully!");
    }
    //delete message
    void deleteMessage()
    {
        Chatting c1=new Chatting("Hello");
        c1.setMessage(null);
        System.out.println("Message deleted successfully!");
    }
}
class InvalidInputException extends Exception
{
    public InvalidInputException(String e)
    {
        super(e);
    }
}
class FileNotCreated extends Exception
{
    public FileNotCreated(String e)
    {
        super(e);
    }
}
public class Lab6SCD {

    public static void main(String[] args) throws FileNotFoundException {
      
        File obj=new File("userData.txt");
        Scanner sc=new Scanner(obj);
        sc.useDelimiter(",");
        
        while(sc.hasNextLine())
        {
            String line=sc.nextLine();
            String []value=line.split(",");
            int opt=Integer.parseInt(value[0]);
            if(opt==1)
            {
            User u1=new User(value[1],value[2]);//create user object
            u1.display();
            }
            else if(opt==2)
            {
                PhotoPost p1=new PhotoPost(value[1]);
                p1.display();
                p1.addLike();
                p1.addComment("Wonderful!");
                p1.deletePost();
            }
            else if (opt==3)
            {
                Follower f1=new Follower(Integer.parseInt(value[1]),value[2],value[3],Integer.parseInt(value[4]),Integer.parseInt(value[5]));
                f1.display();
            }
        }
            
    }
}
