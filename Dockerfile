#
# Manuel Dockerfile for the blog
#
FROM openjdk:11
LABEL maintainer="no@email.com"

ENV LANG de_DE.utf8
ENV TZ="Europe/Berlin"
RUN mkdir -p /opt/blog-app/
ADD target/blog-1.0.0-SNAPSHOT.jar /opt/blog-app/blog.jar
WORKDIR /opt/blog-app/
EXPOSE 8080

CMD ["java","-jar","/opt/blog-app/blog.jar"]
