## 一、主动运行
git clone下来后，直接运行epidemic_back与epidemic_syscontrol_back，系统功能就全部开启了。
## 二、部署
进入docker-deploy中执行：
> docker-compose up --build -d

**注意：docker-compose中简单部署需要将redis镜像名的myredis改为redis，如果需要定制redis则可自己制作一个名为myredis的镜像即可**