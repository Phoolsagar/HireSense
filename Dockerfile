FROM tomcat:10.1-jdk21-temurin

WORKDIR /build

# Copy app source and web assets
COPY src/main/java ./src/main/java
COPY src/main/webapp ./src/main/webapp

# Compile servlet/JSP Java sources into WEB-INF/classes
RUN mkdir -p src/main/webapp/WEB-INF/classes && \
    find src/main/java -name "*.java" > sources.txt && \
    javac -encoding UTF-8 \
      -cp "/usr/local/tomcat/lib/servlet-api.jar:src/main/webapp/WEB-INF/lib/*" \
      -d src/main/webapp/WEB-INF/classes \
      @sources.txt

# Deploy app as /HireSense
RUN rm -rf /usr/local/tomcat/webapps/* && \
    mkdir -p /usr/local/tomcat/webapps/HireSense && \
    cp -R src/main/webapp/. /usr/local/tomcat/webapps/HireSense/

EXPOSE 8080
CMD ["sh", "-c", "sed -i \"s/port=\\\"8080\\\"/port=\\\"${PORT:-8080}\\\"/\" /usr/local/tomcat/conf/server.xml && catalina.sh run"]
