# 指定基础镜像  
FROM williamyeh/java8
# 指定作者名和E-mail  
MAINTAINER yizhen "aaron_sunny@163.com"
  
#指定挂载点  
VOLUME /tmp  
#将本地文件或目录复制到由dockerfile构建的镜像中  
ADD boot-docker-demo-1.0-SNAPSHOT.jar app.jar
ENV TZ=Asia/Shanghai
#设置环境变量  
#ENV JAVA_OPTS=""  
#提供容器运行的默认命令  
ENTRYPOINT ["java", "-jar", "/app.jar"]