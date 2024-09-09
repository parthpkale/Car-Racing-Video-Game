// Red Car Track 1: Computer Car Driving
  if (keygo == true && redcargo1 == true) {
    image(movie1, 0, 0, 800, 600);
   
    fill(255);
    textFont(statistics);
    text("Speed: " + speed, 20, 60);
    text("Gear: " + gear, 20, 135);
   
    println("time: " + time);
    println("start: " + starttime);
     
    translate(track1carX, track1carY);
    rotate(radians(carturn));
    image(redcar, 0, 0, 50.4, 25);
  }
 
  // Grey Car Track 1: Computer Car Driving
  if (keygo == true && greycargo1 == true) {
    image(movie1, 0, 0, 800, 600);
   
    fill(255);
    textFont(statistics);
    text("Speed: " + speed, 20, 60);
    text("Gear: " + gear, 20, 135);

    translate(track1carX, track1carY);
    rotate(radians(carturn));
    image(greycar, 0, 0, 50.4, 25);
  }
 
  // Pink Car Track 1: Computer Car Driving
  if (keygo == true && pinkcargo1 == true) {
    image(movie1, 0, 0, 800, 600);
   
    fill(255);
    textFont(statistics);
    text("Speed: " + speed, 20, 60);
    text("Gear: " + gear, 20, 135);

    translate(track1carX, track1carY);
    rotate(radians(carturn));
    image(pinkcar, 0, 0, 50.4, 25);
  }
 
  // Red Car Track 2: Computer Car Driving
  if (keygo == true && redcargo2 == true) {
    image(movie2, 0, 0, 800, 600);
   
    fill(255);
    textFont(statistics);
    text("Speed: " + speed, 20, 60);
    text("Gear: " + gear, 20, 135);

    translate(track2carX, track2carY);
    rotate(radians(carturn));
    image(redcar, 0, 0, 50.4, 25);
   
    println(track2carY);
  }
 
  // Grey Car Track 2: Computer Car Driving
  if (keygo == true && greycargo2 == true) {
    image(movie2, 0, 0, 800, 600);
   
    fill(255);
    textFont(statistics);
    text("Speed: " + speed, 20, 60);
    text("Gear: " + gear, 20, 135);

    translate(track2carX, track2carY);
    rotate(radians(carturn));
    image(greycar, 0, 0, 50.4, 25);
  }
 
  // Pink Car Track 2: Computer Car Driving
  if (keygo == true && pinkcargo2 == true) {
    image(movie2, 0, 0, 800, 600);
   
    fill(255);
    textFont(statistics);
    text("Speed: " + speed, 20, 60);
    text("Gear: " + gear, 20, 135);

    translate(track2carX, track2carY);
    rotate(radians(carturn));
    image(pinkcar, 0, 0, 50.4, 25);
  }
 
  // Track 1 Boolean Player Victory Screen True
  if (time < 37 && track1carX >= 52.4 && track1carX <= 82.2 && track1carY >= 247.6 && ((keygo == true && redcargo1 == true) || (keygo == true && greycargo1 == true) || (keygo == true && pinkcargo1 == true))) {
    victoryscene = true;
    keygo = false;
    defeatscene = false;
  }
 
  if (starttime > 37) {
    defeatscene = false;
  }
 
  // Track 1 Boolean Player Defeat Screen True
  if (time > 37 && ((keygo == true && redcargo1 == true) || (keygo == true && greycargo1 == true) || (keygo == true && pinkcargo1 == true))) {
    defeatscene = true;
    keygo = false;
    victoryscene = false;
  }
 
  // Track 2 Boolean Player Victory Screen True
  if (time < 56 && track2carX >= 66.2 && track2carX <= 141.0 && track2carY >= 326.7 && track2carY <= 370.0 && ((keygo == true && redcargo2 == true) || (keygo == true && greycargo2 == true) || (keygo == true && pinkcargo2 == true))) {
    victoryscene = true;
    keygo = false;
    defeatscene = false;
  }
 
  // Track 2 Boolean Player Defeat Screen True
  if (time > 56 && ((keygo == true && redcargo2 == true) || (keygo == true && greycargo2 == true) || (keygo == true && pinkcargo2 == true))) {
    defeatscene = true;
    keygo = false;
    victoryscene = false;
  }
 
  if (victoryscene == true) {
    image(victorybackground, 0, 0, 800, 600);
    textSize(40);
    text("CONGRATULATIONS!", 200, 100);
    text("YOU WON!", 300, 350);
   
    keygo = false;
    redcargo1 = false;
    greycargo1 = false;
    pinkcargo1 = false;
    redcargo2 = false;
    greycargo2 = false;
    pinkcargo2 = false;
  }
 
  if (defeatscene == true) {
    image(victorybackground, 0, 0, 800, 600);
    text("YOU LOST", 200, 100);
    text("BETTER LUCK NEXT TIME", 100, 350);
   
    keygo = false;
    redcargo1 = false;
    greycargo1 = false;
    pinkcargo1 = false;
    redcargo2 = false;
    greycargo2 = false;
    pinkcargo2 = false;
  }
} // end draw

void mousePressed() {
  // Home Page -> Track 1
  if (mouseX > 100 && mouseX < 700 && mouseY > 300 && mouseY < 400 && introscene == true) {
    levelselectscenetrack1 = true;
    introscene = false;
  }

  // Home Page -> How to Play
  if (mouseX > 100 && mouseX < 700 && mouseY > 450 && mouseY < 550 && introscene == true) {
    howtoplayscene = true;
    introscene = false;
  }

  // Track Select Scene -> Home Page
  if (mouseX > 700 && mouseX < 795 && mouseY > 550 && mouseY < 595 && (howtoplayscene == true || levelselectscenetrack1 == true || levelselectscenetrack2 == true)) {
    howtoplayscene = false;
    introscene = true;
    levelselectscenetrack1 = false;
    levelselectscenetrack2 = false;
  }

  // Car Select Scene -> Level Select Page
  if (mouseX > 700 && mouseX < 795 && mouseY > 550 && mouseY < 595 && (carselectscenered == true || carselectscenegrey == true || carselectscenepink == true)) {
    carselectscenepink = false;
    carselectscenegrey = false;
    levelselectscenetrack1 = true;
    carselectscenered = false;
    redcarselected = false;
    greycarselected = false;
    pinkcarselected = false;
  }

  // Track 1 -> Track 2
  if (mouseX > 550 && mouseX < 625 && mouseY > 30 && mouseY < 105 && levelselectscenetrack1 == true) {
    levelselectscenetrack2 = true;
    levelselectscenetrack1 = false;
    carselectscenered = false;
  }

  // Track 2 -> Track 1
  if (mouseX > 175 && mouseX < 250 && mouseY > 30 && mouseY < 105 && levelselectscenetrack2 == true) {
    levelselectscenetrack2 = false;
    levelselectscenetrack1 = true;
  }

  // Track 1 -> Car Select
  if (introscene == false && mouseX > 5 && mouseX < 100 && mouseY > 550 && mouseY < 595 && levelselectscenetrack1 == true) {
    carselectscenered = true;
    levelselectscenetrack1 = false;
    level1selected = true;
    level2selected = false;
  }

  // Track 2 -> Car Select
  if (introscene == false && mouseX > 5 && mouseX < 100 && mouseY > 550 && mouseY < 595 && levelselectscenetrack2 == true) {
    carselectscenered = true;
    levelselectscenetrack2 = false;
    level2selected = true;
    level1selected = false;
  }

  // Red Car Select
  if (carselectscenered == true && mouseX > 290 && mouseX < 360 && mouseY > 520 && mouseY < 590) {
    redcarselected = true;
    carselectscenered = true;
    greycarselected = false;
    pinkcarselected = false;
  }

  // Red Car -> Grey Car
  if (carselectscenered == true && mouseX > 365 && mouseX < 435 && mouseY > 520 && mouseY < 590) {
    carselectscenegrey = true;
    carselectscenered = false;
    redcarselected = false;
    pinkcarselected = false;
    greycarselected = true;
  }

  // Grey Car -> Red Car
  if (carselectscenegrey == true && mouseX > 290 && mouseX < 360 && mouseY > 520 && mouseY < 590) {
    carselectscenegrey = false;
    carselectscenered = true;
    redcarselected = true;
    pinkcarselected = false;
    greycarselected = false;
  }

  // Grey Car -> Pink Car
  if (carselectscenegrey == true && mouseX > 440 && mouseX < 510 && mouseY > 520 && mouseY < 590) {
    carselectscenepink = true;
    carselectscenegrey = false;
    redcarselected = false;
    pinkcarselected = true;
    greycarselected = false;
  }

  // Pink Car -> Grey Car
  if (carselectscenepink == true && mouseX > 365 && mouseX < 435 && mouseY > 520 && mouseY < 590) {
    carselectscenepink = false;
    carselectscenegrey = true;
    redcarselected = false;
    pinkcarselected = false;
    greycarselected = true;
  }

  // Red Car -> Pink Car
  if (carselectscenered == true && mouseX > 440 && mouseX < 510 && mouseY > 520 && mouseY < 590) {
    carselectscenepink = true;
    carselectscenered = false;
    redcarselected = false;
    pinkcarselected = true;
    greycarselected = false;
  }

  // Pink Car -> Red Car
  if (carselectscenepink == true && mouseX > 290 && mouseX < 360 && mouseY > 520 && mouseY < 590) {
    carselectscenepink = false;
    carselectscenered = true;
    redcarselected = true;
    pinkcarselected = false;
    greycarselected = false;
  }

  // Red Car & Track 1
  if (level1selected == true && redcarselected == true && carselectscenered == true && mouseX > 5 && mouseX < 100 && mouseY > 550 && mouseY < 595) {
    redcarandtrack1 = true;
    carselectscenered = false;
  }

  // Grey Car & Track 1
  if (level1selected == true && greycarselected == true && carselectscenegrey == true && mouseX > 5 && mouseX < 100 && mouseY > 550 && mouseY < 595) {
    greycarandtrack1 = true;
    carselectscenegrey = false;
  }

  // Pink Car & Track 1
  if (level1selected == true && pinkcarselected == true && carselectscenepink == true && mouseX > 5 && mouseX < 100 && mouseY > 550 && mouseY < 595) {
    pinkcarandtrack1 = true;
    carselectscenepink = false;
  }

  // Red Car & Track 2
  if (level2selected == true && redcarselected == true && carselectscenered == true && mouseX > 5 && mouseX < 100 && mouseY > 550 && mouseY < 595) {
    redcarandtrack2 = true;
    carselectscenered = false;
  }

  // Grey Car & Track 2
  if (level2selected == true && greycarselected == true && carselectscenegrey == true && mouseX > 5 && mouseX < 100 && mouseY > 550 && mouseY < 595) {
    greycarandtrack2 = true;
    carselectscenegrey = false;
  }

  // Pink Car & Track 2
  if (level2selected == true && pinkcarselected == true && carselectscenepink == true && mouseX > 5 && mouseX < 100 && mouseY > 550 && mouseY < 595) {
    pinkcarandtrack2 = true;
    carselectscenepink = false;
  }
} // end mousePressed

void keyPressed() {
  // Car Forward Movement Track 1
  if ((keyCode == UP || key == 'w') && (redcarandtrack1 == true || greycarandtrack1 == true || pinkcarandtrack1 == true)) {
    track1carX = track1carX + cos(radians(carturn))*(carspeed + caracceleration);
    track1carY = track1carY + sin(radians(carturn))*(carspeed + caracceleration);
    carspeed = 0.5;

    acceleration = true;
  }

  // Car Forward Movement Track 2
  if ((keyCode == UP || key == 'w') && (redcarandtrack2 == true || greycarandtrack2 == true || pinkcarandtrack2 == true)) {
    track2carX = track2carX + cos(radians(carturn))*(carspeed + caracceleration);
    track2carY = track2carY + sin(radians(carturn))*(carspeed + caracceleration);
    carspeed = 0.5;

    acceleration = true;
  }
 
  // Start Track 1
  if (key == 's' && (redcarandtrack1 == true || greycarandtrack1 == true || pinkcarandtrack1 == true)) {
    keygo = true;
    starttime = second();
  }
 
  // Start Track 2
  if (key == 's' && (redcarandtrack2 == true || greycarandtrack2 == true || pinkcarandtrack2 == true)) {
    keygo = true;
    starttime = second();
  }

  // Car Backward Movement Track 1
  if ((keyCode == DOWN || key == 's') && (redcarandtrack1 == true || greycarandtrack1 == true || pinkcarandtrack1 == true)) {
    carspeed = 3.5;
    track1carX = track1carX - cos(radians(carturn))*(carspeed);
    track1carY = track1carY - sin(radians(carturn))*(carspeed);
  }

  // Car Backward Movement Track 2
  if ((keyCode == DOWN || key == 's') && (redcarandtrack2 == true || greycarandtrack2 == true || pinkcarandtrack2 == true)) {
    carspeed = 3.5;
    track2carX = track2carX - cos(radians(carturn))*(carspeed);
    track2carY = track2carY - sin(radians(carturn))*(carspeed);
    speed = caracceleration * 38.6;
  }

  // Car Turning Left Track 1
  if ((keyCode == LEFT || key == 'a') && (redcarandtrack1 == true || greycarandtrack1 == true || pinkcarandtrack1 == true)) {
    carturn = carturn - 5.0;
  }

  // Car Turning Left Track 2
  if ((keyCode == LEFT || key == 'a') && (redcarandtrack2 == true || greycarandtrack2 == true || pinkcarandtrack2 == true)) {
    carturn = carturn - 5.0;
  }

  // Car Turning Right Track 1
  if ((keyCode == RIGHT || key == 'd') && (redcarandtrack1 == true || greycarandtrack1 == true || pinkcarandtrack1 == true)) {
    carturn = carturn + 5.0;
  }

  // Car Turning Right Track 2
  if ((keyCode == RIGHT || key == 'd') && (redcarandtrack2 == true || greycarandtrack2 == true || pinkcarandtrack2 == true)) {
    carturn = carturn + 5.0;
  }
 
  // 'N' Cheat Key
  if ((key == 'n' || key == 'N') && (redcargo1 == true || greycargo1 == true || pinkcargo1 == true || redcargo2 == true || greycargo2 == true || pinkcargo2 == true || redcarandtrack1 == true || greycarandtrack1 == true || pinkcarandtrack1 == true || redcarandtrack2 == true || greycarandtrack2 == true || pinkcarandtrack2 == true)) {
    victoryscene = true;
   
    keygo = false;
    redcargo1 = false;
    greycargo1 = false;
    pinkcargo1 = false;
    redcargo2 = false;
    greycargo2 = false;
    pinkcargo2 = false;
    redcarandtrack1 = false;
    greycarandtrack1 = false;
    pinkcarandtrack1 = false;
    redcarandtrack2 = false;
    greycarandtrack2 = false;
    pinkcarandtrack2 = false;
  }
} // end keyPressed

void keyReleased() {
  if ((keyCode == UP || key == 'w') && acceleration == true && (redcarandtrack1 == true || greycarandtrack1 == true || pinkcarandtrack1 == true)) {
    acceleration = false;
  }
} // end keyReleased
