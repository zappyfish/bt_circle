# bt_circle

Hiya! This repository contains code, .apk, and a schematic to build a circle of LEDs controlled by an arduino that receives information
from the HC-05 bluetooth module sent by an android phone running the arduinoid app. 

# THE SOFTWARE
The bt_circle folder contains the .ino. This .ino assumes that you're using a shift register (see hardware) but you can easily
modify it if you just want to use digital I/O pins. I only used 10 LEDs, so it wasn't necessary to use a shift register but I just 
wanted to get some practice with it. Nonetheless, you can add more LEDs using shift registers and modify the code as necessary. If you
do add LEDs, you'll need to change the android code in ConnectionView. ConnectionView gets a value (val) 0-255 then divides by 25.5
and converts it to a char starting at 'a'. So, if you want 20 LEDs, you'll divide val by 12.75 instead, and so on. If you just
want to run things exactly as I made it, you can just download the .apk I provided and you'll be good to go.

# THE HARDWARE
As mentioned above, I used a shift register to drive 7 of the 10 LEDs (I didn't use Q0 because I don't like its pin
placement on the chip), and pins 2-4 on the arduino to drive the other 3. I used the HC-05 bluetooth module which is
pretty simple to wire up (GND, VCC, Tx to Rx, Rx to Tx). You'll need to go into your device's settings to pair with it before
you use the app or else it will crash. The last items you'll need are an arduino UNO and LEDs. I wired the LEDs with a common cathode
so I just needed one 220 ohm resistor to limit current. (EDIT: I have since learned that this is a bad idea since the LEDs may have descrepancies in forward voltage) I also included a .pdf schematic. It's a bit messy, so please
let me know if you have any questions.
