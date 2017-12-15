import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class digitalCandles extends PApplet {

Snowflake[] flakes;
int count;
int distance = 10;

public void setup(){
  stroke(255);
  
  count = width/distance+1;
  flakes = new Snowflake[count];
  for (int i = 0; i<count; i++){
    flakes[i] = new Snowflake(i*10,height - height/8,100);
  } 
}

public void draw(){
  background(0);
  for (int i = 0; i<count; i++){
    flakes[i].pen();
  }
  println( (flakes[1].life/ flakes[1].totalLife));
}
class Snowflake { 
  float xpos, ypos, size, life, totalLife, maxSize; 
  Snowflake (float tempxpos, float tempypos, float tempsize){
    xpos = tempxpos;
    ypos = tempypos;
    maxSize = random(0.85f*tempsize, 1.15f*tempsize);
    size = maxSize;
    totalLife = PApplet.parseInt(random(1000,1200));
    life = totalLife;
  }
  public void pen(){
    noFill();
    strokeWeight(3);
    stroke(255,200);
    size = maxSize*life/totalLife;
    line(xpos,ypos-size,xpos,ypos);
    strokeWeight(1);
    stroke(255,map(life,0,totalLife,10,255));
    ellipse(xpos,ypos-size-8,3,4);
    stroke(255,map(life,0,500,0,150));
    ellipse(xpos,ypos-size-9,4,5);
    if (life>0){life--;}
  }
} 
  public void settings() {  size(400,400); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "--present", "--window-color=#666666", "--stop-color=#cccccc", "digitalCandles" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
