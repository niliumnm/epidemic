## 一、准备工作
git clone下来后，将epidemic_back与epidemic_syscontrol_back进行maven打包。
## 二、部署
将两个模块的jar包与docker-compose.yml、 Dockerfile-sysControl、Dockerfile-userSystem放到同一目录下
使用docker-compose进行环境容器化部署
> docker-compose up --build -d