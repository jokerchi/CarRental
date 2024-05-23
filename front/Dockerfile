# 使用官方的node基础镜像
FROM node:14

# 设置工作目录
WORKDIR /app

# 将package.json和package-lock.json复制到工作目录
COPY package*.json ./

# 安装项目依赖
RUN npm install

# 将项目源代码复制到工作目录
COPY . .

# 构建项目
RUN npm run build

# 使用官方的nginx基础镜像来部署构建好的项目
FROM nginx:1.19.0-alpine

# 将构建好的项目复制到nginx的html目录下
COPY --from=0 /app/dist /usr/share/nginx/html

# 暴露80端口
EXPOSE 80

# 启动nginx
CMD ["nginx", "-g", "daemon off;"]