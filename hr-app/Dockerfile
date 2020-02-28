FROM node:latest
WORKDIR /hr-app
RUN npm install -g live-server
COPY ./dist/hr-app /hr-app
CMD live-server
EXPOSE 8080