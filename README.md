# SendButtonIXI

 Ixi module example for IOTA ICT network.


This IXI module listens GPIO pins so you can add two buttons to send messages to ICT tangle to address which you have chosen, first button sends message "ON" to that address and other "OFF". You can run example ReceivingLedIXI module on other or same Raspberry Pi, which will turn led on and off if it receive those messages from that address

USES:
https://github.com/Pi4J/pi4j

pi4j-1.2-SNAPSHOT

Please check out how your Raspberry pi versions pin numbers are defined at http://pi4j.com/ So you can figure out in which pin you should connect buttons on your Raspberry pi.

Connect buttons from 3,3V to pin with 1K ohm resistor.

USE ONLY 3,3V Raspberry Pis GPIOs can't tolerate 5V.

YOU MUST USE RESISTOR WITH BUTTONS OTHERWISE IT MAY CAUSE DAMAGE TO YOUR RASPBERRY PI!

TEST
To test this IXI you must clone repo and go SendButtonIXI.java file and write address which you wanna use in to: t.address = ""; between "" you can write address with uppercase letters A-Z and number 9, make that address 81 char long.

If you are using ReceivingLedIXI module to receive messages from this module you wanna use same address which you use on that IXI module.

then compile with: gradle ixi and copy *.jar file in to ict/modules and restart ict


KEEP IN MIND THAT THIS MODULE DO NOT USE ANY TAGS, ENCRYPTION OR MAM. SO IF SOMEONE ELSE SEND "ON" MESSAGE TO ADDRESS YOU HAVE CHOSEN, RECEIVER CAN'T KNOW IF THAT MESSAGE COMES FROM YOU OR SOMEONE ELSE IF THAT PERSON USE SAME ADDRESS.

USE AT YOUR OWN RISK!
I am not responsible for any damage caused by running this software. Please use it at your own risk! If you don't understand what you are doing, do not use it. Use this only as template and make your own IXI module if you want to use Raspberry Pi's GPIOs.
