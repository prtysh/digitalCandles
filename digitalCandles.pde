Candles[] candle;
int count;
int distance = 10;

void setup(){
  stroke(255);
  size(400,400);
  count = width/distance+1;
  candle = new Candles[count];
  for (int i = 0; i<count; i++){
    candle[i] = new Candles(i*10,height - height/8,100);
  } 
}

void draw(){
  background(0);
  for (int i = 0; i<count; i++){
    candle[i].pen();
  }
  println( (candle[1].life/ candle[1].totalLife));
}
class Candles { 
  float xpos, ypos, size, life, totalLife, maxSize; 
  Candles (float tempxpos, float tempypos, float tempsize){
    xpos = tempxpos;
    ypos = tempypos;
    maxSize = random(0.85*tempsize, 1.15*tempsize);
    size = maxSize;
    totalLife = int(random(1000,1200));
    life = totalLife;
  }
  void pen(){
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