Instalacion del ambiente

Requisitos.

*. Mongodb (opcional en la version 1.0 , falta definir la conexion)  http://docs.mongodb.org/manual/tutorial/install-mongodb-on-windows/
*. Gradle.   http://www.gradle.org/docs/1.12/userguide/installation.html
*. Eclipse   https://www.eclipse.org/downloads/
*. Tomcat 7  http://tomcat.apache.org/download-70.cgi

1) Bajar el repo

	git clone https://github.com/JonathanVilllaverde/GeolocacionPromoGL.git
	
2) Instalar plugin de gradle en eclipse

	https://github.com/spring-projects/eclipse-integration-gradle/blob/master/README.md

3) Importar proyecto Tracker
	
	*. Menu file -> Import -> Gradle Proyect.
	
	*. En root folder la ruta del proyecto C:\Users\mi.usuario\Documents\GeolocacionPromoGL\back\Tracker
	
	*. Seleccionar buildModel  

	*. Seleccionar el checkbox en Tracker -> Finish.
	
4) Run on server tomcat 7


5) Corroborar el servicio

	localhost:8080/Tracker/gendarme/nombreDelGendarme
	localhost:8080/Tracker/test/devolverValor