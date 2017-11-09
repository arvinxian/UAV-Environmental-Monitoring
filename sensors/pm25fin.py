import urllib
import serial
import numpy as np
from time import sleep
#pmdec=0
#pmint=0

ser = serial.Serial('/dev/ttyAMA0',9600)
def getpm(serial):
    global data
    global pmpercent
    global pmdec
    global pmint
   
   
    data = serial.read(9)
    b = ''
    j=0
    for i in data:
        b=b + str(ord(i))+' '
        if j== 3:
            pmint = ord(i)
        if j== 4:
            pmdec = ord(i)
        j=j+1
    if(pmdec<10):
           pmpercent=(pmint+pmdec/10)*19
    else:
           pmpercent=(pmint+pmdec/100)*19
    print b
    print "%f"%(pmpercent)
    print pmint,pmdec/10
   # sleep(1)
    return pmpercent
   

    
    #print int(data,16)
    #pmdata = data.decode('utf-8')
    #print pmdata
if __name__ == '__main__':
    #pmpercent
    #pmdec
    #ppmint
    for i in range(100):
       pmvalue = getpm(ser)
       print(pmvalue)
       # parmas = urllib.urlencode({'my_pm':pmpercent})
       # f=urllib.urlopen("http://192.72.1.100:8080/demo/adddata.jsp?",parmas)
        #sleep(1)
