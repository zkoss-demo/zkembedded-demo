# ZK Embedded Demo

The demo contains two parts, one is NodeJS application, another one is ZK application.

Before launching both applications, please launch nginx with the following settings.

```
location / {
	proxy_pass http://127.0.0.1:9000;
	root   html;
	index  index.html;
}

location /zkembedded-app/ {
	proxy_pass http://127.0.0.1:8080;
}
```
## Useful Commands NodeJS application
run application

```
node nodejs-app/app.js
```

## Useful Build Commands for ZK application

run jetty
```
nodejs-app/gradlew appRun
```

http://localhost:8080/zkembedded-demo

run tests
```
nodejs-app/gradlew test
```

build war
```
nodejs-app/gradlew war
```

## License
* Demo Code - [Apache License 2.0](http://www.apache.org/licenses/LICENSE-2.0)