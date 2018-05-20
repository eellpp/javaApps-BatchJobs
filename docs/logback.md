
### TimeBasedRollingPolicy 
https://logback.qos.ch/manual/appenders.html#TimeBasedRollingPolicy

Configuration Properties
- mandatory fileNamePattern
- Others are optional


Example Filename pattern:
- /var/log/%d{yyyy/MM, aux}/myapplication.%d{yyyy-MM-dd}.log
the file name pattern shown above organizes log folders by year and month but roll-over log files every day at midnight.
