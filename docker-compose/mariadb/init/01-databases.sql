# create databases
CREATE DATABASE IF NOT EXISTS `hfuaa`;
CREATE DATABASE IF NOT EXISTS `hfgateway`;

# create root user and grant gights
GRANT ALL ON *.* TO 'root'@'%';
