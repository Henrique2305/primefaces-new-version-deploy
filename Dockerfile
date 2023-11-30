FROM ubuntu:latest AS build

RUN apt-get update
RUN apt-get install openjdk-8-jdk -y
COPY . .

RUN apt-get install maven -y
RUN mvn clean install

FROM tomcat:8-jre8

EXPOSE 8080

# Copie o arquivo WAR para o diretório de implantação do Tomcat
COPY --from=build target/jsf-demo-1.0-SNAPSHOT.war /usr/local/tomcat/webapps/app.war

# Configurar o arquivo index.xhtml como a página de início
RUN mv /usr/local/tomcat/webapps/app.war /usr/local/tomcat/webapps/ROOT.war

# Adicionar o PostgreSQL JDBC Driver
ADD https://jdbc.postgresql.org/download/postgresql-42.2.23.jar /usr/local/tomcat/lib/

# Adicionar configurações de contexto para o Tomcat para o PostgreSQL
COPY context.xml /usr/local/tomcat/conf/context.xml

CMD ["catalina.sh", "run"]

