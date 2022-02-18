# UGBE
Unknown Game Back End

# 接口编写方法
首先确定一个 xxxControlelr  xxx 最好简单易懂 比如 LoginController 登录接口相关服务全部写在里面 UserController 用户相关接口相关服务等等
其次在里面写一个 public 描述的方法就是一个接口了
如果是get方法 那么在方法上面写一个 @GetMapping("/路径") post put delete 方法同理 只是表示不用的请求方式

# 打包方法
使用 maven 里面的 package 打成尾缀为 jar 的包
然后把 包 放在指定的地方 运行命令 java -jar xxx.jar就可以运行了
# docker 打包镜像
FROM centos
COPY xxx.jar /app.jar
ADD jdk-8u202-linux-x64.tar.gz /usr/local/ 这里要准备jdk-8u202 如果最上面是 FROM java8 就不用这个了，不过java8镜像用的是java开源镜像openjdk 会有目前已知字体库方面的缺少
ENV MYPATH /usr/local 
WORKDIR $MYPATH 设置工作目录
ENV JAVA_HOME /usr/local/jdk1.8.0_202 设置java环境
ENV CLASSPATH $JAVA_HOME/lib/dt.jar:$JAVA_HOME/lib/tools.jar 设置java环境
ENV PATH $PATH:$JAVA_HOME/bin 设置java环境
EXPOSE 8080 暴露端口 这个依据目前的springboot配置暴露端口
ENTRYPOINT ["java","-jar","/app.jar"] 运行
