import urllib
import serial
import time
import RPi.GPIO as GPIO
import gpsfin
import pm25fin
import dhtfin


ser = serial.Serial('/dev/ttyAMA0',9600)

if __name__ == "__main__":
    while True:
        tem,hum,dhttmp,dhtcheck = dhtfin.getdht()
        pmvalue = pm25fin.getpm(ser)
        lat, lon = gpsfin.getgps()
        print(lat,lon,pmvalue,tem,hum)
        parmas = urllib.urlencode({'uav_pm':pmvalue,'uav_lon':lon,'uav_lat':lat,'uav_tem':tem,'uav_hum':hum})
        #urllib.urlopen("http://192.72.1.100:8080/UAV-Environmental-Monitoring/en_uav_home/sensors/insert_data.jsp?",parmas)
        urllib.urlopen("http://192.168.2.1:8080/UAV-Environmental-Monitoring/en_uav_home/sensors/insert_data.jsp?",parmas)
        time.sleep(2)
        
