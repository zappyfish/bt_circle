int dataPin = 11;        //Define which pins will be used for the Shift Register control
int latchPin = 12;
int clockPin = 8;
int masterReclear = 5; // MR pin on shift register


int myPins[10] = {2, 16, 32, 64, 8, 128, 4, 4, 2, 3};
// NOTE: the first 7 entries are shift register pins (if you
// choose to use a shift register), the last 3 are digital I/O
void setup()
{
    pinMode(dataPin, OUTPUT);       //Configure each IO Pin
    pinMode(latchPin, OUTPUT);
    pinMode(clockPin, OUTPUT);
    pinMode(masterReclear, OUTPUT);
    digitalWrite(masterReclear, HIGH);
    Serial.begin(9600);
}

void loop()
{
  if(Serial.available()) {
  char myChar = Serial.read();
  // you should use the serial monitor when you're setting up
  // the myPins array to figure out the order the entries
  // should go in
  
  int x = myChar-95; // convert data 0-9 int
  Serial.println(x);
  clearIO();
  if(x>= 0 && x<10) {
    if(x<7) {   // if it's a shift array pin
      Serial.println("shifty");
      digitalWrite(latchPin, LOW);
      shiftOut(dataPin, clockPin, MSBFIRST, myPins[x]);
      digitalWrite(latchPin, HIGH);
    }
    else {
      
      digitalWrite(latchPin, LOW);
      shiftOut(dataPin, clockPin, MSBFIRST, 1);
      digitalWrite(latchPin, HIGH);
      digitalWrite(myPins[x], HIGH);
    }
  }
  }
}
void clearIO() { // turn off the digital I/O pins for when you switch LEDs
  for(int i = 2; i<5; i++) {
    digitalWrite(i, LOW);
  }
}
  
