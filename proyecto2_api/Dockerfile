# Usar la imagen oficial de Tomcat con JDK 17
FROM tomcat:10.1-jdk17-corretto

# Copiar tu archivo WAR a la carpeta de aplicaciones de Tomcat
COPY /target/proyecto2_api-1.0-SNAPSHOT.war /usr/local/tomcat/webapps/proyecto2_api.war

# Exponer el puerto 8080 (puerto estándar de Tomcat)
EXPOSE 8080

# Comando para arrancar Tomcat
CMD ["catalina.sh", "run"]

