import serial
import pynmea2
import time
ser = serial.Serial("/dev/ttyUSB0",9600)
def getgps():
    while True:
        line = ser.readline()
        if line.startswith('$GPRMC'):
            rmc = pynmea2.parse(line)
            latitude = float(rmc.lat)/100
            longitude = float(rmc.lon)/100
            return latitude,longitude
            break
        else:
            continue
lat, lon = getgps()
print(lat,lon)

