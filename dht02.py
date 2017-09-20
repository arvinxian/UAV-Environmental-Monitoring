import RPi.GPIO as GPIO
import urllib
import time
#isDataOk = 1

def delay(i): #20*i usdelay  
    a=0  
    for j in range(i):  
        a+1  

def dhtvalue():
	channel =4 
	data = []
	j = 0

	GPIO.setmode(GPIO.BCM)

	time.sleep(1)

	GPIO.setup(channel, GPIO.OUT)
	GPIO.output(channel, GPIO.LOW)

        time.sleep(0.02)
        
        
	GPIO.output(channel, GPIO.HIGH)
	GPIO.setup(channel, GPIO.IN)

	while GPIO.input(channel) == GPIO.LOW:
	  continue
	while GPIO.input(channel) == GPIO.HIGH:
	  continue

        while j<2:
          k = 0
          while GPIO.input(channel) == GPIO.LOW:
            continue
          while GPIO.input(channel) == GPIO.HIGH:
            k += 1
            if k > 100:
              break
          if k < 8:
            data.append(0)
          else:
#            data.append(1)
            j -= 1
          j += 1

	while j < 40 and j>1:
	  k = 0
	  while GPIO.input(channel) == GPIO.LOW:
	    continue
	  while GPIO.input(channel) == GPIO.HIGH:
	    k += 1
	    if k > 100:
	      break
	  if k < 8:
	    data.append(0)
	  else:
	    data.append(1)          
	  j += 1
              

	print "sensor is working."
#	print data

	humidity_bit = data[0:8]
	humidity_point_bit = data[8:16]
	temperature_bit = data[16:24]
	temperature_point_bit = data[24:32]
	check_bit = data[32:40]

	humidity = 0
	humidity_point = 0
	temperature = 0
	temperature_point = 0
	check = 0

	for i in range(8):
	  humidity += humidity_bit[i] * 2 ** (7-i)
	  humidity_point += humidity_point_bit[i] * 2 ** (7-i)
	  temperature += temperature_bit[i] * 2 ** (7-i)
	  temperature_point += temperature_point_bit[i] * 2 ** (7-i)
	  check += check_bit[i] * 2 ** (7-i)

	tmp = humidity + humidity_point + temperature + temperature_point

	if check == tmp:
          print data
	  print "temperature :", temperature, "*C, humidity :", humidity, "%"
          global mytem,myhum
          mytem = temperature
          myhum = humidity
	else:
          global isDataOk
          isDataOk = 0
	  print data
          print "*************************************************************************"
#	  print "temperature :", temperature, "*C, humidity :", humidity, "% check :", check, ", tmp :", tmp
          #isDataOk = 0
#          print isDataOk

	GPIO.cleanup()



isDataOk = 1
mytem = 0
myhum = 0
var = 1
while var == 1:
#for i in range(1,103):
#    print isDataOk
    if isDataOk == 1:
        dhtvalue()
        parmas = urllib.urlencode({'my_tem':mytem,'my_hum':myhum})
        f=urllib.urlopen("http://192.168.2.1:8080/demo/adddata.jsp?",parmas)
        time.sleep(5)
    else:
        print "data is not good"
        isDataOk = 1
        time.sleep(0.5)
       # continue


'''
	#dhtvalue()
        if isDataOk == False:
            print isDataOk
            print "******************"
            #isDataOk = True
            #continue
        else:
            dhtvalue()
            time.sleep(1)
'''
