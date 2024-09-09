// Global Variables
PImage track1;
PImage track2;
PImage pinkcar;
PImage greycar;
PImage redcar;
PImage introbackground;
PImage track1background;
PImage track2background;
PImage wheelspin;
PImage carselectscenebackground;
PImage computercar;
PImage track1gif;
PImage track2gif;
PImage track1wcar;
PImage track2wcar;
PImage coverspeed;
PImage victorybackground;
PFont scene1;
PFont scene1title;
PFont howtoplayfont;
PFont statistics;
String title = "Race Away";
boolean introscene = true;
boolean howtoplayscene = false;
boolean levelselectscenetrack1 = false;
boolean levelselectscenetrack2 = false;
boolean carselectscenegrey = false;
boolean carselectscenered = false;
boolean carselectscenepink = false;
boolean level1selected = false;
boolean level2selected = false;
boolean redcarselected = false;
boolean greycarselected = false;
boolean pinkcarselected = false;
boolean redcarandtrack1 = false;
boolean greycarandtrack1 = false;
boolean pinkcarandtrack1 = false;
boolean redcarandtrack2 = false;
boolean greycarandtrack2 = false;
boolean pinkcarandtrack2 = false;
boolean acceleration = false;
boolean keygo = false;
boolean redcargo1 = false;
boolean greycargo1 = false;
boolean pinkcargo1 = false;
boolean redcargo2 = false;
boolean greycargo2 = false;
boolean pinkcargo2 = false;
boolean victoryscene = false;
boolean defeatscene = false;
float track1carX = 294.0;
float track1carY = 338.0;
float track1computerX = 344.5;
float track1computerY = 364.0;
float carspeed = 0.3;
float carturn = 0.0;
float caracceleration = 0.0;
float computercarspeed = 4.5;
float computerturn = 0.0;
float track2carX = 111.4;
float track2carY = 517.3;
float speed = 0.0;
float track1time;
float track2time;
int gear = 1;
int starttime;
int endtime;
int time;

import processing.video.*;

Movie movie1;
Movie movie2;

void setup() {
  size(800, 600);
  background(138, 62, 1);

  movie1 = new Movie(this, "track 1 clip.mp4");
  movie1.play();
  track1time = movie1.duration();
 
  movie2 = new Movie(this, "track 2 clip.mp4");
  movie2.play();
  track2time = movie2.duration();

  scene1 = createFont("Arial", 40);

  howtoplayfont = createFont("Arial", 25);

  scene1title = createFont("Lucida Calligraphy", 80);
 
  statistics = createFont("Bauhaus 93", 50);

  // Level Images
  track1 = loadImage("track 1.png");
  track2 = loadImage("track 2.png");

  track1wcar = loadImage("track 1 with car.jpg");
  track2wcar = loadImage("track 2 with car.png");

  // Car Images
  greycar = loadImage("grey car.png");
  redcar = loadImage("red car.png");
  pinkcar = loadImage("pink car.png");
  computercar = loadImage("computer car.png");

  // Background Images
  introbackground = loadImage("introscene background.jpg");
  track1background = loadImage("track 1 background.jpg");
  track2background = loadImage("track 2 background.jpg");
  carselectscenebackground = loadImage("car selecting scene background.png");
  victorybackground = loadImage("victory stage.jpg");

  // Cover Speed
  coverspeed = loadImage("speed coverup.jpg");

  // Wheel Spin Image
  wheelspin = loadImage("wheel spin.png");
} // end setup

void draw() {
  background(138, 62, 1);
 
  // Movie1 Availability
  if (movie1.available()) {
    movie1.read();
  }
 
  // Movie2 Availability
  if (movie2.available()) {
    movie2.read();
  }

  if (key == 's' && (redcarandtrack1 == true || greycarandtrack1 == true || pinkcarandtrack1 == true)) {
    keygo = true;
  }

  if (key == 's' && (redcarandtrack2 == true || greycarandtrack2 == true || pinkcarandtrack2 == true)) {
    keygo = true;
  }

  // Speed Calculation
  speed = caracceleration * 38.7;

  // Gear Calculation
  if (speed < 24.6) {
    gear = 1;
  } else if (speed >= 24.6 && speed < 49.2) {
    gear = 2;
  } else if (speed >= 49.2 && speed < 73.8) {
    gear = 3;
  } else if (speed >= 73.8 && speed < 98.4) {
    gear = 4;
  } else if (speed >= 98.4 && speed < 123.0) {
    gear = 5;
  } else if (speed >= 123.0 && speed < 147.6) {
    gear = 6;
  } else if (speed >= 147.6 && speed < 123.0) {
    gear = 7;
  } else if (speed >= 123.0 && speed < 172.3) {
    gear = 8;
  } else if (speed >= 172.3 && speed < 196.9) {
    gear = 9;
  }

  // Time Calculation
  if (starttime > second()) {
    time = 59 - starttime + second();
  } else if (starttime < second()) {
    time = second() - starttime;
  }

  // Intro Scene Code
  if (introscene == true) {
    image(introbackground, 0, 0, 800, 600);

    image(wheelspin, 60, 65, 147.5, 100);

    fill(255, 0, 0);
    textFont(scene1title);
    text(title, 215, 150);

    fill(166, 157, 151);
    rect(100, 300, 600, 100);
    rect(100, 450, 600, 100);

    textFont(scene1);
    fill(255);
    text("Play Game", 305, 360);
    text("How to Play", 290, 510);
  }

  // How to Play Scene Code
  if (howtoplayscene == true) {
    image(introbackground, 0, 0, 800, 600);

    image(wheelspin, 60, 65, 147.5, 100);

    fill(255, 0, 0);
    textFont(scene1title);
    text(title, 215, 150);

    textFont(scene1);
    fill(255);
    textFont(howtoplayfont);
    text("1. In this Car Racing Game, you have to use the ARROW keys, or the\n" +
      "WASD keys in order to move your car.\n" +
      "2. Another player (computer) will be competing with you.\n" +
      "3. The objective of the game is to come in first place. \n" +
      "4. If your car goes beyond the race track, you will be teleported \n" +
      "back to the starting position. \n" +
      "5. Try not to veer of the track. \n" +
      "6. Have Fun, and download more fun games at:", 20, 240);
      fill(80, 139, 235);
      text("'thebestgamesintheworld.com'", 20, 527);

    fill(166, 157, 151);
    rect(700, 550, 95, 45, 10);

    fill(255);
    textSize(15);
    text("Home Page", 709, 578);
  }

  // Select Track 1 Code
  if (levelselectscenetrack1 == true) {
    image(track1background, 0, 0, 800, 600);

    fill(166, 157, 151);
    triangle(550, 30, 625, 67.5, 550, 105);

    fill(255);
    textSize(40);
    text("Track 1: Easy", 205, 90);

    image(track1, 133.33, 150, 533.33, 427.33);

    fill(166, 157, 151);
    rect(700, 550, 95, 45, 10);

    fill(15, 184, 60);
    rect(5, 550, 100, 45, 10);

    fill(255);
    textSize(15);
    text("Home Page", 709, 578);

    text("Select Level", 14, 578);
  }

  // Select Track 2 Code
  if (levelselectscenetrack2 == true) {
    image(track2background, 0, 0, 800, 600);

    fill(166, 157, 151);
    triangle(250, 30, 175, 67.5, 250, 105);

    fill(255);
    textSize(40);
    text("Track 2: Hard", 330, 90);

    image(track2, 133.33, 150, 533.33, 427.33);

    fill(166, 157, 151);
    rect(700, 550, 95, 45, 10);

    fill(15, 184, 60);
    rect(5, 550, 100, 45, 10);

    fill(255);
    textSize(15);
    text("Home Page", 709, 578);

    text("Select Level", 14, 578);
  }  

  // Select Red Car
  if (carselectscenered == true) {
    fill(0);
    textSize(40);
    text("Red Car", 100, 90);

    image(carselectscenebackground, 0, 100, 800, 400);

    image(redcar, 144, 170, 512, 254);

    fill(166, 157, 151);
    rect(700, 550, 95, 45, 10);

    fill(255);
    textSize(15);
    text("Back Page", 712, 578);

    fill(204, 14, 14);
    rect(290, 520, 70, 70);

    fill(133, 126, 126);
    rect(365, 520, 70, 70);

    fill(240, 141, 141);
    rect(440, 520, 70, 70);

    fill(15, 184, 60);
    rect(5, 550, 100, 45, 10);

    fill(0);
    text("GO!", 42, 578);
  }  

  // Select Grey Car
  if (carselectscenegrey == true) {
    fill(0);
    textSize(40);
    text("Grey Car", 100, 90);

    image(carselectscenebackground, 0, 100, 800, 400);

    image(greycar, 144, 170, 512, 254);

    fill(166, 157, 151);
    rect(700, 550, 95, 45, 10);

    fill(255);
    textSize(15);
    text("Back Page", 712, 578);

    fill(204, 14, 14);
    rect(290, 520, 70, 70);

    fill(133, 126, 126);
    rect(365, 520, 70, 70);

    fill(240, 141, 141);
    rect(440, 520, 70, 70);

    fill(15, 184, 60);
    rect(5, 550, 100, 45, 10);

    fill(0);
    text("GO!", 42, 578);
  }    

  // Select Pink Car
  if (carselectscenepink == true) {
    fill(0);
    textSize(40);
    text("Pink Car", 100, 90);

    image(carselectscenebackground, 0, 100, 800, 400);

    image(pinkcar, 144, 170, 512, 254);

    fill(166, 157, 151);
    rect(700, 550, 95, 45, 10);

    fill(255);
    textSize(15);
    text("Back Page", 712, 578);

    fill(204, 14, 14);
    rect(290, 520, 70, 70);

    fill(133, 126, 126);
    rect(365, 520, 70, 70);

    fill(240, 141, 141);
    rect(440, 520, 70, 70);

    fill(15, 184, 60);
    rect(5, 550, 100, 45, 10);

    fill(0);
    text("GO!", 42, 578);
  }  

  // Red Car & Track 1
  if (redcarandtrack1 == true) {
    image(track1wcar, 0, 0, 800, 600);

    redcargo1 = true;
   
    fill(255);
    textFont(statistics);
    text("Speed: " + speed, 20, 60);
    text("Gear: " + gear, 20, 135);
   
    text("Press 'S' to Start", 200, 300);

    image(redcar, 294.0, 338.0, 50.4, 25);
  }

  // Grey Car & Track 1
  if (greycarandtrack1 == true) {
    image(track1wcar, 0, 0, 800, 600);

    greycargo1 = true;

    fill(255);
    textFont(statistics);
    text("Speed: " + speed, 20, 60);
    text("Gear: " + gear, 20, 135);
   
    text("Press 'S' to Start", 200, 300);

    image(greycar, 294.0, 338.0, 50.4, 25);
  }

  // Pink Car & Track 1
  if (pinkcarandtrack1 == true) {
    image(track1wcar, 0, 0, 800, 600);

    pinkcargo1 = true;

    fill(255);
    textFont(statistics);
    text("Speed: " + speed, 20, 60);
    text("Gear: " + gear, 20, 135);
   
    text("Press 'S' to Start", 200, 300);

    image(pinkcar, 294.0, 338.0, 50.4, 25);
  }

  // Red Car & Track 2
  if (redcarandtrack2 == true) {
    image(track2wcar, 0, 0, 800, 600);

    redcargo2 = true;

    fill(255);
    textFont(statistics);
    text("Speed: " + speed, 20, 60);
    text("Gear: " + gear, 20, 135);
   
    text("Press 'S' to Start", 200, 300);

    image(redcar, 111.4, 517.3, 50.4, 25);
  }

  // Grey Car & Track 2
  if (greycarandtrack2 == true) {
    image(track2wcar, 0, 0, 800, 600);

    greycargo2 = true;

    fill(255);
    textFont(statistics);
    text("Speed: " + speed, 20, 60);
    text("Gear: " + gear, 20, 135);
   
    text("Press 'S' to Start", 200, 300);

    image(greycar, 111.4, 517.3, 50.4, 25);
  }

  // Pink Car & Track 2
  if (pinkcarandtrack2 == true) {
    image(track2wcar, 0, 0, 800, 600);

    pinkcargo2 = true;

    fill(255);
    textFont(statistics);
    text("Speed: " + speed, 20, 60);
    text("Gear: " + gear, 20, 135);
   
    text("Press 'S' to Start", 200, 300);

    image(pinkcar, 111.4, 517.3, 50.4, 25);
  }

  // Acceleration True
  if (acceleration == true) {
    caracceleration = caracceleration + 0.1;
  }

  // Acceleration False
  if (acceleration == false) {
    caracceleration = caracceleration - 0.2;
  }

  // Car Acceleration Maxout
  if (caracceleration >= 5.0) {
    caracceleration = 5.0;
    carspeed = 0.5;
  }

  // Car Acceleration Stopping
  if (caracceleration <= 0.0) {
    caracceleration = 0.0;
    carspeed = 0.0;
  }

  // Track 1 LEFT End Restart
  if (track1carX <= 0.0) {
    track1carX = 294.0;
    track1carY = 338.0;
    carturn = 0.0;
  }
 
  // Track 2 LEFT End Restart
  if (track2carX <= 0.0) {
    track2carX = 111.4;
    track2carY = 517.3;
    carturn = 0.0;
  }

  // Track 1 RIGHT End Restart
  if (track1carX >= 800.0) {
    track1carX = 294.0;
    track1carY = 338.0;
    carturn = 0.0;
  }  
 
  // Track 2 RIGHT End Restart
  if (track2carX >= 800.0) {
    track2carX = 111.4;
    track2carY = 517.3;
    carturn = 0.0;
  }

  // Track 1 TOP End Restart
  if (track1carY <= 0.0) {
    track1carX = 294.0;
    track1carY = 338.0;
    carturn = 0.0;
  }
 
  // Track 2 TOP End Restart
  if (track2carY <= 0.0) {
    track2carX = 111.4;
    track2carY = 517.3;
    carturn = 0.0;
  }

  // Track 1 BOTTOM End Restart
  if (track1carY >= 600.0) {
    track1carX = 294.0;
    track1carY = 338.0;
    carturn = 0.0;
  }
 
  // BOTTOM End Restart
  if (track2carY >= 600.0) {
    track2carX = 111.4;
    track2carY = 517.3;
    carturn = 0.0;
  }
}
